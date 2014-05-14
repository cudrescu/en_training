
public class LetterMapping {
	
	private int value;
	private String letter;
	
	public LetterMapping(String letter, int value){
		this.letter = letter;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

}
