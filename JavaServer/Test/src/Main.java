import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import kr.co.shineware.nlp.posta.en.core.EnPosta;

public class Main {

	private HashMap<String, Integer> test = new HashMap<String, Integer>();
	
	public Main(String posts) {
		List<String> resultList = getPosta(posts);
		List<Integer> morpheme_array = V_findIndex(resultList);
		List<String> list = makeIdiom(resultList, morpheme_array);
		
		int length = list.size();
		for(int i = 0; i < length; i++) {
			String text = list.get(i);
			
			Word word = getIdiom(text);
			System.out.println(word);
			if(word != null) {
				System.out.println(word.getSpelling() + "/" + word.getMean());
			}
		}
	}
	
	public static void main(String[] args) {
		//new Main("stand up, everybody");
		String text = "are+just";
		
		System.out.println(text.split("\\+")[0]);
	}


	public Word getIdiom(String word) {
		Word word1 = null;
		/*
		String url = "https://endic.naver.com/search.nhn?sLn=kr&query=" + word;
		String spellingSelector = "#content > div:nth-child(4) > dl > dt.first > span.fnt_e30 > a > strong";
		String ComponentSelector = "#content > div:nth-child(4) > dl > dd:nth-child(2) > div > p:nth-child(1) > span.fnt_k09";
		String meanSelector = "#content > div:nth-child(4) > dl > dd:nth-child(2) > div > p:nth-child(1) > span.fnt_k05";
		*/
		String url = "https://dictionary.cambridge.org/ko/%EC%82%AC%EC%A0%84/%EC%98%81%EC%96%B4-%ED%95%9C%EA%B5%AD%EC%96%B4/" + word;
		String meanSelector = "div.sense-block:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1)";

		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			
			Element meanElement1 = doc.select(meanSelector).get(0);
	        

	        String mean = meanElement1.text();
	        
	        if(mean.equals("")) return word1;
	        
	        word1 = new Word(word, "idiom", mean);
	        return word1;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return word1;
        
	}
	
	public List<String> makeIdiom(List<String> resultList, List<Integer> morpheme_array) {
		List<String> idiomList = new ArrayList<String>();
		
		int length = morpheme_array.size();
		for(int i = 0; i < length; i++) {
			int index = morpheme_array.get(i);
			String idiom = resultList.get(index).split("/")[0];
			
			for(int l = 0; l < 3; l++) {
				int plus_index = index + l + 1;
				
				if(plus_index >= resultList.size()) {
					return idiomList;
				}
				
				String text = resultList.get(plus_index).split("/")[0];
				
				if(text.equals("") || text.equals(",") || text.equals(".")) {
					break;
				}
				
				idiom += ("+" + text);
				System.out.println(idiom);
				idiomList.add(idiom);
			}
		}
		
		return idiomList;
	}
	
	public List<Integer> V_findIndex(List<String> list) {
		List<Integer> indexList = new ArrayList<Integer>();
		
		int length = list.size();
		
		String[] morpheme_array = {"VB", "VBD", "VBG", "VBN", "VBP", "VBZ"};
		
		for(int i = 0; i < length; i++) {
			String morpheme = list.get(i).split("/")[1];
			
			String spelling = list.get(i).split("/")[0];
			if(spelling.equals("")) {
				continue;
			}
			
			int length1 = morpheme_array.length;
			for(int l = 0; l < length1; l++) {
				if(morpheme_array[l].equals(morpheme)) {
					indexList.add(i);
					break;
				}
			}
		}
		
		//System.out.println(indexList);
		return indexList;
	}
	
	public List<String> getPosta(String posts) {
		EnPosta posta = new EnPosta();

		posta.load("src/model");

		// 사용자 사전 추가
		posta.buildFailLink();

		List<String> resultList = posta.analyze(posts);
		
		
		System.out.print("resultList");
		System.out.println(resultList);
		
		return resultList;
		
	}
	
}
