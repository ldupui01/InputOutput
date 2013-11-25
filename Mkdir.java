import java.io.File;
import java.io.IOException;


public class Mkdir {


	public static void main(String[] args) throws IOException{
		
		//System.out.println("enter the name of the folder :");
		//String folderName = System.console().readLine();
		
		String fileName = "." + File.separator + args[0];//folderName;
		File file = new File(fileName);
		
		file.mkdir();
	}
}