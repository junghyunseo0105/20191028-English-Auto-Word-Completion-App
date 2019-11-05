package Storage;

public class DataHandler {
	private WordsHandler words;
	private RequestHandler request;
	
	public DataHandler() {
		words = new WordsHandler();
		request = new RequestHandler();
	}

	public int plusRequest(int plusNum) {
		request.plusRequest(plusNum);
		
		return request.getRequest();
	}
	
	public int readRequest() {
		return request.readRequest();
	}
	
	public int plusWords(int plusNum) {
		words.plusWords(plusNum);
		
		return words.readWords();
	}
	
	public int readWords() {
		return words.readWords();
	}
	
	public void saveData() {
		request.saveRequest();
		words.saveWords();
	}
}
