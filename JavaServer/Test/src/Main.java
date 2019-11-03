import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public Main() {
		try {
			FileOutputStream out = new FileOutputStream("test1.txt");
			String str = "hello";
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
	
	public static void main(String[] args) {
		new Main();
	}
	
	public boolean findWord(String word) {
		File f = new File("WordList/" + word + ".txt");
		
		if(f.isFile()) return true;
		
		return false;
	}
}
