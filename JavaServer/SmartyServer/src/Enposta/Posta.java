package Enposta;

import java.util.ArrayList;
import java.util.List;

import DataFile.DataFileIO;
import DataFile.Word;
import DataFile.WordFile;
import kr.co.shineware.nlp.posta.en.core.EnPosta;

public class Posta {
	
	private WordFile wordFile;
	
	/*
	 * getPosta�� ���¼Ұ� �и��� List return�Ѵ�.
	 * ���� List�� �Ű������� �� getPosList�� �̿��� �ʿ��� ���¼��� ���縸�� �����´�.
	 * ���� List�� �Ű������� �� webCrolling�� ���� ���������� ArrayList<Word>�� ��ü�� �����Ѵ�.
	 */
	
	public Posta(WordFile wordFile) {
		this.wordFile = wordFile;
	}
	
	public ArrayList<Word> getFinalPosta(String posts) {
		List<String> list = getPosta(posts);
		ArrayList<String> PosList = getPosList(list);
		ArrayList<Word> WordList = webCrolling(PosList);
		
		return WordList;
	}
	
	/*
	 * webCrollong�� ArrayList ��ü�� �޾� ������ ������ �ܾ�´�.
	 * �׻� ���˻��� �� �� �ӵ��� ������ �˻��Ҷ����� ���Ϸ� �����Ѵ�.
	 * ����Ǿ��ִ� �ܾ� ������ �������⵵ �Ѵ�.
	 * ���������� ArrayList<Word>�� ��ü�� return �Ѵ�.
	 */
	public ArrayList<Word> webCrolling(ArrayList<String> list) {
		ArrayList<Word> array = new ArrayList<Word>();
		
		Crolling crolling = new Crolling();
		int length = list.size();
		for(int i = 0; i < length; i++ ) {
			String spelling = list.get(i);
			Word word = wordFile.getWord(spelling);
			
			if(array.contains(word)) {
				continue;
			}
			
			if(word == null) {
				System.out.print(spelling);
				System.out.print(" �ܾ ���� �˻��մϴ�.");
				word = crolling.getText(spelling);
				if(word == null) {
					Word word_ = new Word("none", "none", "none");
					wordFile.setWord(spelling, word_);
					System.out.println();
					continue;
				}
				if(!wordFile.setWord(spelling, word)) {
					System.out.println();
					continue;
				}
					
			} else {
				System.out.print(spelling);
				System.out.print("�����ϴ� �ܾ �����ɴϴ�.");
			}
			
			System.out.print(" [����]");
			System.out.println(word);
			
			if(!wordFile.findspelling(spelling))
				array.add(word);
		}
		/*
		System.out.print("array");
		System.out.println(array);
		*/
		return array;
	}
	/*
	 * getPosList�� ���¼Ұ� �и��� List ��ü�� �޾� �츮���� �ʿ���
	 * ���, ����, ����, �ణ�� �λ������ �ɷ��ش�.
	 * ���������� �ɷ��� ���¼Ҹ��� return �Ѵ�.
	 */
	
	private String[] posArray = {"JJ", "NN", "NNP", "NNPS", "NNS", "VB", "VBD", "VBG", "VBN", "VBP", "VBZ"};
	
	public ArrayList<String> getPosList(List<String> list) {
		ArrayList<String> posList = new ArrayList<String>();
		
		int length = list.size();
		
		for(int i = 0; i < length; i++) {
			String str = list.get(i);
			String[] str_ = str.split("/");
			String spelling = str_[0];
			String pos = str_[1];
			
			for(int l = 0; l < posArray.length; l++) {
				if(pos.equals(posArray[l]) ) {
					posList.add(spelling);
				}
			}
			
		}
		/*
		System.out.print("posList");
		System.out.println(posList);
		*/
		return posList;
	}
	
	/*
	 * getPosta�� EnPosta��� ���̺귯���� ����Ͽ� �� ������ ����
	 * ���¼� �м��Ѵ�. ���¼Ұ� �м��� ���� List�� ��Ƴ��� return �Ѵ�.
	 */
	
	public List<String> getPosta(String posts) {
		EnPosta posta = new EnPosta();

		posta.load("src/model");

		// ����� ���� �߰�
		posta.buildFailLink();

		List<String> resultList = posta.analyze(posts);
		
		/*
		System.out.print("resultList");
		System.out.println(resultList);
		*/
		return resultList;
		
	}

}
