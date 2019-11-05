package DataFile;

public class UserWord {
	String spelling;
	int used;
	
	public UserWord(String spelling, int used) {
		super();
		this.spelling = spelling;
		this.used = used;
	}
	public String getSpelling() {
		return spelling;
	}
	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	
	
}
