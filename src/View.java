import java.util.Scanner;

public class View {
    public static int mainMenu(){
	Scanner sc = new Scanner(System.in);
	System.out.println(
		"1. Run\n"
		+ "2. Select pixel\n"
		+ "Select: "
		);
	int in = sc.nextInt();
	sc.close();
	return in;
    }
}
