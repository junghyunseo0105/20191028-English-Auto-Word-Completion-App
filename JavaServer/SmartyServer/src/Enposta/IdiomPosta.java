package Enposta;

import java.util.ArrayList;
import java.util.List;

import DataFile.Word;
import DataFile.WordFile;

public class IdiomPosta {

	private Crolling crolling;
	private WordFile wordFile;
	
	public IdiomPosta(WordFile wordFile){
		crolling = new Crolling();
		this.wordFile = wordFile;
	}
	
	public ArrayList<Word> getIdiomList(List<String> resultList) {
		ArrayList<Word> array = new ArrayList<Word>();
		
		List<Integer> morpheme_array = V_findIndex(resultList);
		List<String> list = makeIdiom(resultList, morpheme_array);
		
		int length = list.size();
		for(int i = 0; i < length; i++) {
			String text = list.get(i);
			
			Word word = wordFile.getWord(text);
			
			if(array.contains(word)) {
				continue;
			}
			
			if(word == null) {
				System.out.print(text);
				System.out.print(" 단어를 새로 검색합니다.");
				word = crolling.getIdiom(text);
				
				if(word == null) {
					//System.out.println(word.getSpelling() + "/" + word.getMean());
					Word word_ = new Word("none", "none", "none");
					wordFile.setWord(text, word_);
					System.out.println();
					continue;
				} else {
					wordFile.setWord(text, word);
				}
			} else {
				System.out.print(text);
				System.out.print("존재하는 단어를 가져옵니다.");
			}
			
			
			
			String spelling = clearPlusWord(word.getSpelling());
			
			String mean = word.getMean();
			
			Word word1 = new Word(spelling, "idiom", mean);
			
			if(spelling.equals("none")) {
				Word word_ = new Word("none", "none", "none");
				wordFile.setWord(text, word_);
				System.out.println();
				continue;
			}
			
			System.out.print(" [성공]");
			System.out.println(word);
			
			if(!wordFile.findspelling(word.getSpelling()))
				array.add(word1);
		}
		
		//System.out.println("finished getIdiomList");
		return array;
	}
	
	public String clearPlusWord(String word) {
		String[] array = word.split("\\+");
		String text = array[0];
		
		int length = array.length;
		
		for(int i = 1; i < length; i++) {
			text += (" " + array[i]);
		}
		
		return text;
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
	
}
