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
	 * ��뷮 �� �ܾ� ��뷮 �� ����Ѵ�.
	 * ����ڿ� ���� ���Ǵ� �ܾ ����
	 * �ܾ ���� String���� return;
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
