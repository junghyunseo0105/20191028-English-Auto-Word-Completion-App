package DataFile;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class DataFileIO {
	public ArrayList<String> getFileData(String path) {
		ArrayList<String> array = new ArrayList<String>();

		try {
			File file = new File(path);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";

			int i = 0;
			while ((line = bufReader.readLine()) != null) {
				array.add(line);
				System.out.println(line);
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}

		return array;
	}

	public void saveFileData(String[] data, String path) {
		int length = data.length;
		OutputStream output;

		try {
			output = new FileOutputStream(path);
			for (int i = 0; i < length; i++) {
				String str = data[i] + "\n";
				byte[] by = str.getBytes();
				
				output.write(by);
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
