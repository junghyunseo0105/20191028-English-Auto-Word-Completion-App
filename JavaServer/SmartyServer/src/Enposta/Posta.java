package Enposta;

import java.util.ArrayList;
import java.util.List;

import kr.co.shineware.nlp.posta.en.core.EnPosta;

public class Posta {

	public Posta() {
		
	}
	
	private String[] posArray = {"JJ", "NN", "NNP", "NNPS", "NNS", "VB", "VBD", "VBG", "VBN", "VBP", "VBZ"};
	
	public ArrayList<Word> webCrolling(ArrayList<String> list) {
		ArrayList<Word> array = new ArrayList<Word>();
		
		return array;
	}
	
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
	
	public List<String> getPosta(String Posts) {
		EnPosta posta = new EnPosta();

		posta.load("src/model");

		// 사용자 사전 추가
		posta.appendUserDic("dic.user");
		posta.buildFailLink();

		List<String> resultList = posta.analyze(Posts);
		
		return resultList;
		
	}

}
