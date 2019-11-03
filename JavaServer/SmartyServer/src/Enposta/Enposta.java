package Enposta;

import java.util.ArrayList;

public class Enposta {
	
	private ArrayList<Word> array = new ArrayList<Word>();
	private Posta posta;
	
	/*
	 * ��뷮 �� �ܾ� ��뷮 �� ����Ѵ�.
	 * ����ڿ� ���� ���Ǵ� �ܾ ����
	 * �ܾ ���� String���� return;
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
