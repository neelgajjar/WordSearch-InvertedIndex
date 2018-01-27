package textLocation;

import java.util.Arrays;

public class TextLocation {
	private final String filename;
	private final int lineNumber;
	private final String lineOfText;
	
	public TextLocation(String filename, int lineNumber, String lineOfText){
		this.filename = filename;
		this.lineNumber = lineNumber;
		this.lineOfText = lineOfText;
	}
	
	// text locations are only equals if they are from the same file, on the same line and have the same text
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if(!(o instanceof TextLocation)){
			return false;
		}
		TextLocation textLocation = (TextLocation) o;
		return textLocation.filename.equals(filename)&& textLocation.lineNumber == lineNumber &&
				textLocation.lineOfText.equals(lineOfText);
	}
	
	@Override public int hashCode(){
		return Arrays.hashCode(new Object[]{filename, lineNumber, lineOfText});
	}
	@Override public String toString(){
		return String.format("Line %d: %S", lineNumber, lineOfText);
	}
	public String getFilename(){
		return filename;
	}
	
	public int getLineNumber(){
		return lineNumber;
	}
	
	public String getLineOfText(){
		return lineOfText;
	}
}
