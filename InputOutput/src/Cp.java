import java.io.*;

public class Cp {

	public static void main(String[] args) { //throws IOException
		Cp cp = new Cp();
		
		String fileInName = "." + File.separator + args[0];
		File fileIn = new File(fileInName);
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader(fileIn));
			
			String fileOutName = "." + File.separator + args[1];
			File fileOut = new File(fileOutName);
			if (fileOut.exists()){
				System.out.println("Do you want to override " + args[1] + " (Y / N)");
				String answer = System.console().readLine();
				if (answer.equals("N")){
					System.out.println(fileOutName + " being erased");
				}
				
			}else{
				fileOut.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(fileOut);
			
			String lineIn;
			while((lineIn = in.readLine()) != null){
				//System.out.println(lineIn);
				out.write(lineIn);
			}
			in.close();
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}
}