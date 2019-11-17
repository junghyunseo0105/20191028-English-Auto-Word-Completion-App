package Enposta;

import java.util.ArrayList;

import Box.Box;
import DataFile.Word;

public class Enposta {
	
	private Box box;
	
	public Enposta(Box box) {
		this.box = box;
	}
	
	/*
	 * 사용량 및 단어 사용량 을 계산한다.
	 * 사용자에 따라 사용되는 단어를 저장
	 * 단어를 한줄 String으로 return;
	 */
	
	public String getCalculList(String posts) {
		Posta posta = new Posta(box.getWordFile());
		ArrayList<Word> array = posta.getFinalPosta(posts);
		String wordOneList = new String();
		int length = array.size();
		
		increaseStorage(length);
		
		for(int i = 0; i < length; i++) {
			Word word = array.get(i);
			
			wordOneList += word.getSpelling() + "/";
			wordOneList += word.getComponent() + "/";
			wordOneList += word.getMean() + "\n";
		}
		
		return wordOneList;
	}
	
	public void increaseStorage(int amount) {
		int requestNum = box.getDataHandler().plusRequest(1);
		int wordsNum = box.getDataHandler().plusWords(amount);
		
		box.getGui().setRequest(requestNum);
		box.getGui().setWords(wordsNum);
	}
	
	public void saveData() {
		box.getDataHandler().saveData();
	}
}
