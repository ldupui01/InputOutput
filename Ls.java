import java.io.File;
import java.io.IOException;

public class Ls {

	
	public static void main(String[] args) throws IOException{
		// *** When naming the file "." we have a problem with finding its parent, it needs an absolute path to retrieve the parent's !!! *************
		String fileName = "H:\\JAVA\\Java\\InputOutput";// ".."; //+ File.separator + ls.class; //"H:" + File.separator + "Java" + File.separator + "java"; // + "try.txt";
		File file = new File(fileName);
		//file.createNewFile();
		
		// ****** use file.getCanonicalPath() with file name = "." !!!! *******************
		//String path = file.getCanonicalPath();
		String path = file.getAbsolutePath();
		String parentPath = file.getParent();
		
		System.out.println(path);
		System.out.println(parentPath);

		//File parentFile = file.getParentFile();//new File(parentPath);
		String[] myList = file.list();//parentFile.list();
		/*List the file in H:/Java/java
		 */ 
		for (int i=0;i<myList.length;i++){
			System.out.println(myList[i]);
		}
		//*/
		//System.out.println(file.list());
	}
}