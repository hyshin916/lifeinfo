package kr.co.mseshop.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import kr.co.mseshop.model.OilInfoVO;

@Component
public class OilInfoAPI {
	

	public List<OilInfoVO> getOilInfoList(String oilKind) {
		
		List<OilInfoVO> oilList = null;
		OilInfoVO oilInfoVO = new OilInfoVO();
		String path = "";
		
		if (oilKind.equals("A01")) {
			path = "http://www.opinet.co.kr/api/lowTop10.do?code=F608190909&out=xml&prodcd=B027&area=0301";
		} else if (oilKind.equals("A02")) {
			path = "http://www.opinet.co.kr/api/lowTop10.do?code=F608190909&out=xml&prodcd=D047&area=0301";
		}
		
		try {
			URL url = new URL(path);
			URLConnection uc = url.openConnection();
			uc.setConnectTimeout(30000);
			uc.setReadTimeout(30000);
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String value = null;
			StringBuffer buffer = new StringBuffer();
			while ((value = br.readLine()) != null) {
				buffer.append(value + "\n");
			}
			System.out.println("buf:" + buffer.toString());
			// System.out.println("buffer:" + buffer.toString());

			InputSource is = new InputSource(new StringReader(buffer.toString()));

			Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			doc.getDocumentElement().normalize();
			NodeList descNode = doc.getElementsByTagName("OIL");
			oilList = new ArrayList<OilInfoVO>();
			
			for (int i = 0; i < descNode.getLength(); i++) {

				for (Node node = descNode.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
					if (node.getNodeName().equals("OS_NM")) {
						System.out.println("OS_NM: " + node.getTextContent());
						oilInfoVO.setOs_nm(node.getTextContent());
					} else if (node.getNodeName().equals("PRICE")) {
						System.out.println("PRICE: " + node.getTextContent());
						oilInfoVO.setPrice(node.getTextContent());
					} else if (node.getNodeName().equals("VAN_ADR")) {
						System.out.println("VAN_ADR: " + node.getTextContent());
						oilInfoVO.setVan_adr(node.getTextContent());
					} else if (node.getNodeName().equals("NEW_ADR")) {
						System.out.println("NEW_ADR: " + node.getTextContent());
						oilInfoVO.setNew_adr(node.getTextContent());
					}
				}
				oilList.add(oilInfoVO);
				oilInfoVO = new OilInfoVO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oilList;
	}

}
