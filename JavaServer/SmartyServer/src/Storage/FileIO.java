package Storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
	private File f;
	
	public FileIO(File f) {
		this.f = f;
	}
	
	public void writeInteger(String path, int num) {
		String str = Integer.toString(num);
		byte[] by=str.getBytes();
		
		try {
			OutputStream output = new FileOutputStream(path);
			output.write(by);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public int readInteger(String path) {
		try {
			FileReader read = new FileReader(f);
			BufferedReader br = new BufferedReader(read);
			String str = br.readLine();
			read.close();
			
			int num = Integer.parseInt(str);
			return num;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
}
