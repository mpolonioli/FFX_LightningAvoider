
public class ParserInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	protected String command;
	protected String string;
	
	public ParserInputException(String command, String string) {
		this.command = command;
		this.string = string;
	}
	
	@Override
	public String toString() {
		return "Error to perform command.\n"+this.command+" it's not a number but: " + this.string;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}
}
