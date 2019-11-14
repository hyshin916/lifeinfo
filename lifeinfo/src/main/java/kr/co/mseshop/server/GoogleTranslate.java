package kr.co.mseshop.server;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class GoogleTranslate {

	public String getGoogleTranslate(String text) {

		  Translate translate = TranslateOptions.getDefaultInstance().getService();

		    // The text to translate
		    String value = text;

		    // Translates some text into Russian
		    Translation translation =
		        translate.translate(
		        		value,
		            TranslateOption.sourceLanguage("zh-CN"),
		            TranslateOption.targetLanguage("ko"));


		 //   System.out.printf("Text: %s%n", text);
		 //   System.out.printf("Translation: %s%n", translation.getTranslatedText());
		    return translation.getTranslatedText();
		
	}
}
