import java.io.*;
import java.util.*;

public class A0116633 {
	
	private static double[] iArray, jArray;
	private static int globalCounter;
	private static double minimalI, minimalJ, value;
	
	public static void main(String[] args) {
		iArray = new double[25];
		jArray = new double[25];
		globalCounter = 0;
		
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
				calculateISum(fileInput);
				calculateJSum(fileInput);
				globalCounter++;
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
        } catch(Exception e) { 
			System.err.println(fileName + " does not exist!");
		}
	}
	
	public static void calculateISum(String fileInput) {
		double totalSum = 0.00;
		
		try {
			for(int i = 0; i <= fileInput.length(); i = i + 4) {
				String extractedNumber = fileInput.substring(i, i+3);
				double number = Double.parseDouble(extractedNumber);
				totalSum = totalSum + number;
			}
			
			iArray[globalCounter] = totalSum;
		} catch (Exception e) {
			System.err.println("Error when reeading file!");
		}
	}
	
	public static void calculateJSum(String fileInput) {
		double totalSum = 0.00;
		
		try {
			for(int i = 0; i <= fileInput.length(); i = i + 4) {
				String extractedNumber = fileInput.substring(i, i+3);
				double number = Double.parseDouble(extractedNumber);	
			}
		} catch (Exception e) {
			System.err.println("Error when reeading file!");
		}
	}
	
}