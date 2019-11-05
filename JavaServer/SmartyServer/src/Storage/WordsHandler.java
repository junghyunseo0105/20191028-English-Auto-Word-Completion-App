package Storage;

import java.io.File;
import java.io.IOException;

public class WordsHandler {
	private int wordsNum;
	private FileIO fileIO;
	private final String path = "Words.txt";
	
	private File f = new File(path);
	
	public WordsHandler() {
		fileIO = new FileIO(f);
		wordsNum = new Integer(0);
		
		if(!isFile())
			saveWords();
		
		wordsNum = fileIO.readInteger(path);
	}
	
	public void plusWords(int plusNum) {
		wordsNum += plusNum;
	}
	
	
	public void saveWords() {
		fileIO.writeInteger(path, wordsNum);
	}
	
	public int readWords() {
		return wordsNum;
	}
	
	public boolean isFile() {
		return f.isFile();
	}

}
