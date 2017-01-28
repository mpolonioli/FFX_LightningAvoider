
public class ParserInput {
	public static String getCommand(String command, String[] arguments){
		for(int i = 0; i<arguments.length;i++)
			if(arguments[i].compareTo(command) == 0)
				return (i<arguments.length) ? arguments[i+1] : null;
		return null;
	}
}
