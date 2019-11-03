package Enposta;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crolling {
	
	public Word getText(String word) {
		Word word1 = null;
		
		String url = "https://endic.naver.com/search.nhn?sLn=kr&query=" + word;
		String spellingSelector = "#content > div:nth-child(4) > dl > dt.first > span.fnt_e30 > a > strong";
		String ComponentSelector = "#content > div:nth-child(4) > dl > dd:nth-child(2) > div > p:nth-child(1) > span.fnt_k09";
		String meanSelector = "#content > div:nth-child(4) > dl > dd:nth-child(2) > div > p:nth-child(1) > span.fnt_k05";

		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			
			Element spellingElement = doc.select(spellingSelector).get(0);
			Element ComponentElement = doc.select(ComponentSelector).get(0);
			Element meanElement1 = doc.select(meanSelector).get(0);
	        
	        String spelling = spellingElement.text();
	        String component = ComponentElement.text();
	        String mean = meanElement1.text();
	        
	        if(mean.equals("")) return word1;
	        
	        word1 = new Word(spelling, component, mean);
	        return word1;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return word1;
        
	}
	
}
