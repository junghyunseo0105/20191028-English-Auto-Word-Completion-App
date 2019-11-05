package DataFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class UserFile {
	private final String path = "data/UserList.txt";
	private HashMap<String, ArrayList<UserWord>> info = new HashMap<String,  ArrayList<UserWord>>();
	private DataFileIO dataFileIO;
	private File f;
	
	public UserFile() {
		dataFileIO = new DataFileIO();
		f = new File(path);
	}
	
	/*
	 * nickName*spelling/used$spelling/used
	 */
	
	public void load() {
		if(!f.isFile()) return;
		
		ArrayList<String> array = dataFileIO.getFileData(path);
		int length = array.size();
		for(int i = 0; i < length; i ++) {
			String nickName = array.get(i).split("*")[0];
			
			ArrayList<UserWord> array1 = new ArrayList<UserWord>();
			int infoLength = array.get(i).split("*")[1].split("/").length;
			for(int l = 0; l < infoLength; l++) {
				String spelling = array.get(i).split("*")[1].split("$")[l].split("/")[0];
				int used = Integer.parseInt(array.get(i).split("*")[1].split("$")[l].split("/")[1]);
				
				UserWord userWord = new UserWord(spelling, used);
				array1.add(userWord);
			}
			
			info.put(nickName, array1);
		}
	}
}
