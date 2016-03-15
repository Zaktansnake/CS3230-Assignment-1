import java.io.*;
import java.util.*;

public class A0116633 {
	
	private static double minimalI;
	private static double minimalJ;
	private static double value;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileName = sc.next();
		
		readFile(fileName);
		
		sc.close();
	}
	
	public static void readFile(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {	
    		fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			String fileInput = null;
			
			while ((fileInput = br.readLine()) != null) {
				fileInput = br.readLine();
				calculateSum(fileInput);
			}
			
			String outputFileName = fileName + ".txt";
			File outputFile = new File(outputFileName);
			pw = new PrintWriter(outputFile);
			pw.print(minimalI);
			pw.print(" ");
			pw.print(minimalJ);
			pw.print(" ");
			pw.print(value);
			
			fr.close();
			br.close();
			pw.close();
        } catch(IOException e) { 
			System.err.println(fileName + " does not exist!");
		}
	}
	
	public static void calculateSum(String fileInput) {
		
	}
}