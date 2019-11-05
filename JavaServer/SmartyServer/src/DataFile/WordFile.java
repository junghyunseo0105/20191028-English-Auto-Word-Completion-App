package DataFile;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordFile {
	
	private final String path = "data/WorldList.txt";
	private HashMap<String, Word> wordList = new HashMap<String, Word>();
	private DataFileIO dataFileIO;
	private File f;
	
	/*
	 * 저장방식
	 * key = enjoy value = [동사]/즐기다.
	 * key = administration value = [명사]/(또한 英 비격식 admin) 관리[행정] (업무)
	 */
	
	public WordFile() {
		dataFileIO = new DataFileIO();
		f = new File(path);
	}
	
	public void load() {
		if(!f.isFile()) return;
		
		ArrayList<String> array = dataFileIO.getFileData(path);
		int length = array.size();
		for(int i = 0; i < length; i++) {
			String[] str = array.get(i).split("/");
			String key = str[0];
			String spelling = str[1];
			String component = str[2];
			String mean = str[3];
			
			Word word = new Word(spelling, component, mean);
			wordList.put(key, word);
		}
	}
	
	public Word getWord(String key) {
		Word word = null;
		
		try {
			word = wordList.get(key);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return word;
	}
	
	public boolean setWord(String key1, Word word) {
		/*
		System.out.println("word");
		System.out.println(word.getSpelling());
		System.out.println(word.getComponent());
		System.out.println(word.getMean());
		*/
		try {
			String key = key1;
			Word value = word;
			wordList.put(key, value);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	public void save() {
		int length = wordList.size();
		String[] data = new String[length];
		int i = 0;
		for(Map.Entry<String, Word> elem : wordList.entrySet()){
			 
            String key = elem.getKey();
            Word value = elem.getValue();
            
            data[i] = key + "/" + value.getSpelling() + "/" + value.getComponent() + "/" + value.getMean();
            
            i++;
 
        }
		
		dataFileIO.saveFileData(data, path);
	}

	public boolean findspelling(String spelling) {
		boolean flag = true;
		int i = 0;
		for(Map.Entry<String, Word> elem : wordList.entrySet()){
			 
            String key = elem.getKey();
            Word value = elem.getValue();
            
            if(spelling.equals(value.getSpelling())) {
            	flag = false;
            	break;
            }
            i++;
        }
		return flag;
	}
}
