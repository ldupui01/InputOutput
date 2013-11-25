import java.io.*;

public class Cat {

	public static void main(String[] args) {   // throws IOException
		Cat c = new Cat();
		
		System.out.println("enter the name of the file :");
		String folderName = System.console().readLine();
		
		String fileName = "." + File.separator + folderName;
		File file = new File(fileName);
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader(file));
			String line;
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
			in.close();
		} catch (FileNotFoundException ex){
			System.out.println("File " +  file + " was not found");
		} catch(IOException ex){
			ex.printStackTrace();
		} finally {
			c.closeReader(in);
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