package Storage;

public class DataHandler {
	private WordsHandler words;
	private RequestHandler request;
	
	public DataHandler() {
		words = new WordsHandler();
		request = new RequestHandler();
	}

	public void plusRequest(int plusNum) {
		request.plusRequest(plusNum);
	}
	
	public int readRequest() {
		return request.readRequest();
	}
	
	public void plusWords(int plusNum) {
		words.plusWords(plusNum);
	}
	
	public int readWords() {
		return words.readWords();
	}
	
	public void saveData() {
		request.saveRequest();
		words.saveWords();
	}
}
