package Enposta;

import java.util.ArrayList;
import java.util.List;

import kr.co.shineware.nlp.posta.en.core.EnPosta;

public class Posta {

	/*
	 * getPosta�� ���¼Ұ� �и��� List return�Ѵ�.
	 * ���� List�� �Ű������� �� getPosList�� �̿��� �ʿ��� ���¼��� ���縸�� �����´�.
	 * ���� List�� �Ű������� �� webCrolling�� ���� ���������� ArrayList<Word>�� ��ü�� �����Ѵ�.
	 */
	
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
			WordFile wordFile = new WordFile();
			String wordName = list.get(i);
			Word word = null;
			
			if(wordFile.findWord(wordName)) {
				word = wordFile.getWord(wordName);
				continue;
			}
			
			word = crolling.getText(wordName);
			wordFile.setWord(word);
		}
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
			String pos = str_[1];
			String spelling = str_[0];
			
			for(int l = 0; l < posList.size(); l++) {
				if(pos.equals(posArray[l]) ) {
					posList.add(spelling);
				}
			}
			
		}
		
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
		posta.appendUserDic("dic.user");
		posta.buildFailLink();

		List<String> resultList = posta.analyze(posts);
		
		return resultList;
		
	}

}
