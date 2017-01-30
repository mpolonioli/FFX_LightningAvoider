import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class LightningSensor {

    final public int WAITING_PIXEL;
    final public int MAXLIGHTNING_AVOIED;
    
    public Robot robot;
    public Point coord;

    public LightningSensor(int waitinPixel, int maxLightningAvoied) throws AWTException {
	this.WAITING_PIXEL = waitinPixel;
	this.MAXLIGHTNING_AVOIED = maxLightningAvoied;
	this.robot = new Robot();
    }

    public LightningSensor() throws AWTException {
	this(5000, 210);
    }
    
    public void setMousePoint(){
	this.coord = MouseInfo.getPointerInfo().getLocation();
    }

    public void run(Runnable function) throws AWTException {
	int lightningCounter = 0;

	// wait for this.WAITINGPIXEL seconds to permit the user to point the
	// mouse on the desire pixel
	robot.delay(this.WAITING_PIXEL);
	setMousePoint();

	while (lightningCounter < this.MAXLIGHTNING_AVOIED) {
	    // green >= 70 means screen flash
	    if (robot.getPixelColor((int) coord.getX(), (int) coord.getY()).getGreen() >= 70) {
		// press ENTER = X
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_ENTER);
		lightningCounter++;
		function.run();
		// wait to prevent X spamming
		robot.delay(500);
	    }
	}
    }
    
}
