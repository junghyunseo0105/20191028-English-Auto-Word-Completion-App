package Enposta;

public class Word {

	String spelling;
	String Component;
	String mean;
	
	public Word(String spelling, String component, String mean) {
		super();
		this.spelling = spelling;
		Component = component;
		this.mean = mean;
	}
	public String getSpelling() {
		return spelling;
	}
	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}
	public String getComponent() {
		return Component;
	}
	public void setComponent(String component) {
		Component = component;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	} 
	
}
