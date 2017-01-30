import java.awt.AWTException;

public class Main {

    final static public int DEFAULT_WAITING_PIXEL = 5000;
    final static public int DEFAULT_MAXLIGHTNING_AVOIED = 210;
    public static int counter;

    public static void main(String[] args) throws AWTException {

	int waitingPizel;
	int maxLightningAvoied;
	if (args.length > 0) {
	    try {
		String commandValue;
		waitingPizel = ((commandValue = ParserInput.getCommand("-wp", args)) != null)
			? ParserInput.parseIntForCommand("-wp", commandValue) : DEFAULT_WAITING_PIXEL;
		maxLightningAvoied = ((commandValue = ParserInput.getCommand("-ml", args)) != null)
			? ParserInput.parseIntForCommand("-ml", commandValue) : DEFAULT_WAITING_PIXEL;
	    } catch (ParserInputException e) {
		System.out.println(e.getMessage());
		return;
	    }

	    // int counter = 0;
	    new LightningSensor(waitingPizel, maxLightningAvoied)
		    .run(() -> System.out.println("Lightning: " + (++counter)));
	} else {
	    LightningSensor sensor = new LightningSensor();
	    switch (View.mainMenu()) {
	    case 1:
		sensor.run(() -> System.out.println("Lightning: " + (++counter)));
		break;
	    case 2:
		System.out.println("Function does not implemented yet");
		break;
	    default:
		System.out.println("Error menu1");
		break;
	    }
	}
    }

}
