import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.awt.MouseInfo;

public class Main {

	public static void main(String[] args) throws AWTException {
		
		Point coord;
		Robot robot = new Robot();
		int count = 0;
		boolean whileCondition = true;
		
		// wait for 5 seconds to permit the user to point the mouse on the desire pixel
		robot.delay(5000);
		// take coordinate of the pointed pixel
		coord = MouseInfo.getPointerInfo().getLocation();
		
		while (whileCondition) {
			// green >= 70 means screen flash
			if (robot.getPixelColor((int) coord.getX(), (int) coord.getY()).getGreen() >= 70) {
				// press ENTER = X 
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.delay(100);
				robot.keyRelease(KeyEvent.VK_ENTER);
				// how many lightning avoided since now
				count++;
				System.out.println(count);
				// wait to prevent X spamming
				robot.delay(500);
				//  exit the while after 210 lightning avoided
				if (count == 210) {
					whileCondition = false;
				}
			}
		}	
	}
}