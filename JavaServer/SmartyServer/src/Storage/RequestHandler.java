package Storage;

import java.io.File;
import java.io.IOException;

public class RequestHandler {
	private int requestNum;
	private FileIO fileIO;
	private final String path = "Request.txt";
	
	private File f = new File(path);
	
	public RequestHandler() {
		fileIO = new FileIO(f);
		requestNum = new Integer(0);
		
		if(!isFile())
			saveRequest();
		
		requestNum = fileIO.readInteger(path);
	}
	
	public void plusRequest(int plusNum) {
		requestNum += plusNum;
	}
	
	public int getRequest() {
		return requestNum;
	}
	
	public void saveRequest() {
		fileIO.writeInteger(path, requestNum);
	}
	
	public int readRequest() {
		return requestNum;
	}
	
	public boolean isFile() {
		return f.isFile();
	}
	
}
