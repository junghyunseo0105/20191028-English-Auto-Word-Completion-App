package Enposta;

import java.util.ArrayList;

public class Enposta {
	
	private ArrayList<Word> array = new ArrayList<Word>();
	private Posta posta;
	
	/*
	 * 사용량 및 단어 사용량 을 계산한다.
	 * 사용자에 따라 사용되는 단어를 저장
	 * 단어를 한줄 String으로 return;
	 */
	
	public String getCalculList(String posts) {
		array = posta.getFinalPosta(posts);
		String wordOneList = null;
		int length = array.size();
		for(int i = 0; i < length; i++) {
			Word word = array.get(i);
			
			
			wordOneList += word.getSpelling() + "/";
			wordOneList += word.getComponent() + "/";
			wordOneList += word.getMean() + "$";
		}
		
		return wordOneList;
	}
	
}
