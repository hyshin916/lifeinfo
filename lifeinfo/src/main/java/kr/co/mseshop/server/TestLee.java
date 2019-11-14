package kr.co.mseshop.server;

public class TestLee {

	public static void main(String args[]) {
		new TestLee().start();
	}

	private void start() {
		
	//	String data ="自由组合::http://img.alicdn.com/imgextra/i3/2928220622/O1CN01gvmi4M1GSuqAsgusF_!!2928220622.jpg##Y46卡其色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuomOd1ZmrWjq_!!2928220622.jpg##Y46黄色::http://img.alicdn.com/imgextra/i3/2928220622/O1CN011GSuokmEV0gbTpB_!!2928220622.jpg##Y46黑色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuokmCkx1VxQD_!!2928220622.jpg##Y48灰色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuojy4YdZyIY3_!!2928220622.jpg##Y48黑色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuomOfqEspz8w_!!2928220622.jpg##Y71黑色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuomeB148FZaF_!!2928220622.jpg##Y71白色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuolXuAZVQ8lw_!!2928220622.jpg##Y72黑色::http://img.alicdn.com/imgextra/i3/2928220622/O1CN011GSuofbvKxE1H4E_!!2928220622.jpg##Y72白色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuonRfbnJ5dsf_!!2928220622.jpg##Y73白色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuolXtu1jsR8x_!!2928220622.jpg##Y73灰色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuokLCDa5exWD_!!2928220622.jpg##Y73深蓝::http://img.alicdn.com/imgextra/i1/2928220622/O1CN011GSuolFU8s88JKv_!!2928220622.jpg##Y19黑色::http://img.alicdn.com/imgextra/i3/2928220622/O1CN011GSuomOiG2u9t7N_!!2928220622.jpg##Y19白色::http://img.alicdn.com/imgextra/i1/2928220622/O1CN011GSuon3KxLHEn3U_!!2928220622.jpg##Y19浅灰色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuolFUoVnqY6N_!!2928220622.jpg##Y19深咖啡色::http://img.alicdn.com/imgextra/i3/2928220622/O1CN011GSuolXu2RsNtgB_!!2928220622.jpg##Y19深灰色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuom6aLI7P9mX_!!2928220622.jpg##Y75黑色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuomOmtTXyOfL_!!2928220622.jpg##Y75目绿::http://img.alicdn.com/imgextra/i1/2928220622/O1CN011GSuolFcjdWmIRW_!!2928220622.jpg##Y75铁灰::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuomPFd3OIlXe_!!2928220622.jpg##Y44浅卡其::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuomOoyMRdyac_!!2928220622.jpg##Y44湖蓝色::http://img.alicdn.com/imgextra/i1/2928220622/O1CN011GSuom6bgcEVLnC_!!2928220622.jpg##Y44黑色::http://img.alicdn.com/imgextra/i1/2928220622/O1CN011GSuolsmOdzEDml_!!2928220622.jpg##Y50浅卡其::http://img.alicdn.com/imgextra/i1/2928220622/O1CN011GSuomPGAOWGowP_!!2928220622.jpg##Y50红色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuomPHAifbQYR_!!2928220622.jpg##Y51黑色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuomeMUocMHzf_!!2928220622.jpg##Y51红色::http://img.alicdn.com/imgextra/i3/2928220622/O1CN011GSuonRofoCJgQo_!!2928220622.jpg##Y51紫色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN01wLscSD1GSupyV1tGf_!!2928220622.png_40x40q90.jpg##Y51黄色::http://img.alicdn.com/imgextra/i3/2928220622/O1CN011GSuomOpVnwawPo_!!2928220622.jpg##Y37黑色::http://img.alicdn.com/imgextra/i1/2928220622/O1CN011GSuomPIRm6496Z_!!2928220622.jpg##Y37白色::http://img.alicdn.com/imgextra/i3/2928220622/O1CN011GSuokLOMwOJ8yF_!!2928220622.jpg##Y41橙黄::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuom4TC09SSCB_!!2928220622.jpg##Y41白色::http://img.alicdn.com/imgextra/i2/2928220622/O1CN011GSuokLNttN1xte_!!2928220622.jpg##Y41绿色::http://img.alicdn.com/imgextra/i4/2928220622/O1CN011GSuokLON3FgLgk_!!2928220622.jpg##";
	   String data = "璀璨黑第二批##珍珠白第二批##";
	//	String data = "123123::23123##askfjasfd::123123123##";
		String[] temp2 = data.split("##");
		System.out.println(temp2.length);
		int cntt = 1;
		String temp5 = "";
		
		String detailInfo2 = "";
		
		for (int i=0; i<temp2.length; i++) {
			System.out.println("test");
			String[] temp3 = temp2[i].split("::");
		//	String translateStr = googleTranslate.getGoogleTranslate(temp3[0]);  
		//	sum += translateStr.length();
			String str = String.format("%02d", cntt);
			
					temp5+= str +" "+ temp3[0] + ",";
					if (temp3.length != 1) {
						detailInfo2 += "<br/><center><b><div style='font-size:25px; color:brown;'>" +  str +" "+ temp3[0] +"</div></b></center><br/><img src=\"" + temp3[1] +"\"/><br/>";
					} else {
						System.out.println("eeeeee");
						detailInfo2 += "<br/><center><b><div style='font-size:25px; color:brown;'>" + str + " "
								+ temp3[0] + "</div></b></center><br/><img src=\"\"/><br/>";
					}
				cntt++;
		}
		int d = temp5.lastIndexOf(",");
		if (d != -1) {
			String e = temp5.substring(0,d);
			temp5 = e;
		}
		System.out.println(detailInfo2);
		
	}
}
