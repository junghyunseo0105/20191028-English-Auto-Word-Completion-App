package UserWord;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DataFile.DataFileIO;
import DataFile.Word;

public class UserWord {

	private String name;
	private String path;
	
	private HashMap<String, Data> array;
	private DataFileIO dataFdileIO;
	private File f;
	
	public UserWord(String name) {
		this.name = name;
		array = new HashMap<String, Data>();
		dataFdileIO = new DataFileIO();
		
		path = "user/"+ name +".txt";
		f = new File(path);
		
		loadData();
	}
	
	/*
	 * data 저장 형식
	 * mean/1
	 */
	
	public String getName() {
		return name;
	}
	
	public void setData(String str) {
		String[] data = str.split("\n");
		
		int length = data.length;
		for(int i = 0; i < length; i++) {
			String spelling = data[i].split("/")[0];
			int used = getUsed(spelling);
			
			if(used == 0) {
				setUsed(spelling, 1);
				continue;
			}
			
			plusUsed(spelling);
		}
	}
	
	public void plusUsed(String spelling) {
		int num = array.get(spelling).getUsed() + 1;
		Data data = new Data(spelling, num);
		
		array.put(spelling, data);
	}
	
	public void setUsed(String spelling, int num) {
		Data data = new Data(spelling, num);
		array.put(spelling, data);
	}
	
	public int getUsed(String spelling) {
		try {
			return array.get(spelling).getUsed();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public void loadData() {
		if(!f.isFile()) return;
		
		ArrayList<String> arr1 = new ArrayList<String>();
		arr1 = dataFdileIO.getFileData(path);
		
		int length = arr1.size();
		
		for(int i = 0; i < length; i++) {
			String spelling = arr1.get(i).split("/")[0];
			int used = Integer.parseInt(arr1.get(i).split("/")[1]);
			
			Data data = new Data(spelling, used);
			
			array.put(spelling, data);
		}
		
	}
	
	public void saveData() {
		int length = array.size();
		
		String[] data = new String[length];
		int i = 0;
		for(Map.Entry<String, Data> elem : array.entrySet()){
			 
            Data value = elem.getValue();
            
            data[i] = value.getSpelling() + "/" + value.getUsed();
            
            i++;
 
        }
		
		dataFdileIO.saveFileData(data, path);
		
	}
	
}
