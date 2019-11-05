package Enposta;

import java.util.ArrayList;

import DataFile.Word;
import DataFile.WordFile;
import Gui.Gui;
import Storage.DataHandler;

public class Enposta {
	
	private WordFile wordFile;
	private Gui gui;
	private DataHandler dataHandler;
	
	public Enposta(WordFile wordFile, Gui gui, DataHandler dataHandler) {
		this.wordFile = wordFile;
		this.gui = gui;
		this.dataHandler = dataHandler;
	}
	
	/*
	 * 사용량 및 단어 사용량 을 계산한다.
	 * 사용자에 따라 사용되는 단어를 저장
	 * 단어를 한줄 String으로 return;
	 */
	
	public String getCalculList(String posts) {
		Posta posta = new Posta(wordFile);
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
		int requestNum = dataHandler.plusRequest(1);
		int wordsNum = dataHandler.plusWords(amount);
		
		gui.setRequest(requestNum);
		gui.setWords(wordsNum);
	}
}
