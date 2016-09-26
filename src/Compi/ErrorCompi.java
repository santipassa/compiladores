package Compi;

public class ErrorCompi {
	private int lineNumber;
	private String description;

	public ErrorCompi(int lineNumber, String description){
		this.lineNumber = lineNumber;
		this.description = description;
	}
}