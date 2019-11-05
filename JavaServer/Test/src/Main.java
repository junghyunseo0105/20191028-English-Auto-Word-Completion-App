import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Main {

	private HashMap<String, Integer> test = new HashMap<String, Integer>();
	
	public Main() {
		String url = "https://dictionary.cambridge.org/ko/%EC%82%AC%EC%A0%84/%EC%98%81%EC%96%B4-%ED%95%9C%EA%B5%AD%EC%96%B4/" + "word";
		String spellingSelector = "#page-content > div.pr.entry-body > span > div > div > span > div > span > div > div.di-title > h2 > span";
		
		String ComponentSelector = "#page-content > div.pr.entry-body > span > div > div > span > div > span > div > div.posgram.dpos-g.hdib.lmr-5 > div > span";
		String meanSelector = "#page-content > div.pr.entry-body > span > div > div > span > div > div.pos-body > div:nth-child(1) > div.sense-body.dsense_b > div > div.def-body.ddef_b > span";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			
			Element spellingElement = doc.select(spellingSelector).get(0);
			Element ComponentElement = doc.select(ComponentSelector).get(0);
			Element meanElement1 = doc.select(meanSelector).get(0);
	        
	        String spelling = spellingElement.text();
	        String component = ComponentElement.text();
	        String mean = meanElement1.text();
	        
	        System.out.println(spelling + "/" + component + "/" + mean);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public boolean findWord(String word) {
		File f = new File("WordList/" + word + ".txt");
		
		if(f.isFile()) return true;
		
		return false;
	}
	

}
