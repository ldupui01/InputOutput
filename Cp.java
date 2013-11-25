import java.io.*;

public class Cp {

	public static void main(String[] args) { //throws IOException
		Cp cp = new Cp();
		cp.launch(args);
	}
	
	public void launch(String[] args) {	
		String fileInName = "." + File.separator + args[0];
		File fileIn = new File(fileInName);
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			in = new BufferedReader(new FileReader(fileIn));
			
			String fileOutName = "." + File.separator + args[1];
			File fileOut = new File(fileOutName);
			if (fileOut.exists()){
				System.out.println("Do you want to overwrite " + args[1] + " (Y / N)");
				String answer = System.console().readLine();
				if (answer.equals("N")){
					throw new ExceptionNoOverWriteAllowed();
				}
			}else{
				fileOut.createNewFile();
			}
			
			out = new PrintWriter(fileOut);
			
			String lineIn;
			while((lineIn = in.readLine()) != null){
				//System.out.println(lineIn);
				out.println(lineIn);
			}
			//in.close();
			out.close();
		}catch (ExceptionNoOverWriteAllowed ex){
			System.out.println (" recall the process with other name");
		}catch (FileNotFoundException ex){
			System.out.println("File " +  fileIn + " was not found");
		}catch(IOException ex){
			ex.printStackTrace();
		} finally {
			closeReader(in);
			//out.close();
		}	
	}
	
	private void closeReader(Reader reader){
		try{
			if (reader != null){
				reader.close();
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}