package kr.co.mseshop.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {

public boolean chkStr(String a) {
		
		boolean result = false;
		try {
			
			Double d = Double.parseDouble(a);
			result = true;
			
		} catch (Exception e) {
			
			result = false;
		
		}
		
		return result;
	
	}	

private String convertStr(String str) {

	StringBuffer sb = new StringBuffer();
	
	String cvtStr = str.replace("<br><br>",".");
	
	for (int i = 0; i < cvtStr.length()-20; i++) {

		if ('.' == cvtStr.charAt(i)) {
			if (chkStr(String.valueOf(cvtStr.charAt(i - 1))) == true
					&& chkStr(String.valueOf(cvtStr.charAt(i + 1))) == true) {
				sb.append(cvtStr.charAt(i));
			} else {
				if (cvtStr.charAt(i+1) == '\"' || cvtStr.charAt(i+1) == '”') {
					sb.append(cvtStr.charAt(i));
				} else {
					sb.append(".<br><br>");
				}
			}
		} else {
			sb.append(cvtStr.charAt(i));
		}
	}
	
	return sb.toString() + cvtStr.substring(cvtStr.length()-20,cvtStr.length());
}
	
	

	public static void main(String args[]) {
		
		String str = "민갑룡 청장 춘천 등 방문 </b><br><br>“선배님 감사드립니다.”\r\n" + 
				" \r\n" + 
				" 민갑룡 경찰청장은 6일 춘천시 신북읍에 위치한 내평전투호국경찰추모상을 찾아 참배하고 고 노종해 경감을 비롯한 내평지서 소속 11명의 순직 경찰의 추모비 앞에서 고개를 숙이며 감사 인사를 드렸다. \r\n" + 
				" \r\n" + 
				" 노 경감을 비롯한 11명의 경찰들은 6·25 전쟁 당시 북한군 제2사단 3,000여명에 맞서 교전하며 3시간 가량 남침을 지연해 춘천대첩 승리의 발판을 만든 인물들이다. \r\n" + 
				" \r\n" + 
				" 2015년 6월 이들의 업적을 기리기 위한 추모상이 세워졌다.\r\n" + 
				" \r\n" + 
				" 지난해 7월 취임과 동시에 경찰의 뿌리찾기에 앞장서 온 민 청장은 남은 임기동안 전국 곳곳에서 노 경감과 같이 나라를 지킨 경찰 영웅을 지속적으로 발굴하는 일에 힘을 쏟겠다고 약속했다.\r\n" + 
				" \r\n" + 
				" 민 청장은 “지금 우리의 안녕이 나라를 위해 목숨을 바친 선배 경찰들의 충정으로 이뤄졌다는 점을 오늘 이곳에서 다시 깨닫게 됐다”며 “이름없이 희생한 경찰을 찾는 일을 멈추지 않을 것”이라고 말했다.\r\n" + 
				" \r\n" + 
				" 이날 민 청장은 김재규 강원지방경찰청장과 최현순 춘천경찰서장, 이윤종 도 6·25참전경찰유공자회장, 박제대 도경우회장과 함께 간담회를 갖고 강원 경찰 역사 및 치안 현안과 관련한 의견을 나눈 후 강릉으로 향했다. \r\n" + 
				" \r\n" + 
				" 강릉에서는 강릉경찰수련원과 경포여름경찰서를 찾아 시설점검과 합동 순찰을 했다. \r\n" + 
				" \r\n" + 
				" 이무헌기자 trustme@kwnews.co.kr";
		TestClass tc = new TestClass();
		
		System.out.println(tc.convertStr(str));
	}

}
