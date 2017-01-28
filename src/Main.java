import java.awt.AWTException;

public class Main {

	final static public int DEFAULT_WAITING_PIXEL = 5000;
	final static public int DEFAULT_MAXLIGHTNING_AVOIED = 210;

	public static void main(String[] args) throws AWTException {
		try{
			String commandValue;
			int waitingPizel =  ((commandValue = ParserInput.getCommand("-wp", args)) != null) ? ParserInput.parseIntForCommand("-wp", commandValue) : DEFAULT_WAITING_PIXEL;
			int maxLightningAvoied = ((commandValue = ParserInput.getCommand("-ml", args)) != null) ? ParserInput.parseIntForCommand("-ml", commandValue) : DEFAULT_WAITING_PIXEL;
			
			new LightningSensor(waitingPizel, maxLightningAvoied).run();
		}
		catch(ParserInputException e){
			System.out.println(e.getMessage());
		}
	}
	
}