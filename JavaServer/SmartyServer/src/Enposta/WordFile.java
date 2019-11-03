package Enposta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class WordFile {
	
	public boolean findWord(String word) {  //������ ���� ���� Ȯ��
		File f = new File("WordList/" + word + ".txt");
		
		if(f.isFile()) return true;
		
		return false;
	}
	
	/*
	 * ������ ���� ���� Ȯ���Ѵ�.
	 */
	
	public Word getWord(String word) {
		Word word1 = null;
		try {
			FileReader read = new FileReader("WordList/" + word + ".txt");
			BufferedReader br = new BufferedReader(read);
			String str = br.readLine();
			read.close();
			
			String[] wordInfo = str.split("/");
			word1.setSpelling(wordInfo[0]);
			word1.setComponent(wordInfo[1]);
			word1.setMean(wordInfo[2]);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return word1;
	}
	
	public void setWord(Word word) {
		try {
			String[] wordInfo = {word.getSpelling(), word.getComponent(), word.getMean()};
			
			FileOutputStream out = new FileOutputStream("test1.txt");
			String str = wordInfo[0] + "/" + wordInfo[1] + "/" + wordInfo[2];
			byte[] by=str.getBytes();
			out.write(by);
			 
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * �ش� �г����� ���� ������Ǥ� �ܾ �������ش�.
	 * �ش� �г����� ���� ������� ���� �ȿ� ���� �������� �ܾ� ����.
	 * �ش�
	 */
}
