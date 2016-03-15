import java.io.*;
import java.util.*;

public class A0116633 {
	
	private static double[][] inputArray;
	private static double[] iArray, jArray;
	private static int globalCounterI, globalCounterJ, minimalI, minimalJ;
	private static double value;
	
	public static void main(String[] args) {
		inputArray = new double[24][24];
		iArray = new double[24];
		jArray = new double[24];
		globalCounterI = 0;
		globalCounterJ = 0;
		
		Scanner sc = new Scanner(System.in);
		String fileName = sc.next();
		
		findCenter(fileName);
		
		sc.close();
	}
	
	public static void findCenter(String fileName) {
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
				globalCounterI++;
			}
			
			minimalI = findMinimal(iArray);
			minimalJ = findMinimal(jArray);
			value = inputArray[minimalI][minimalJ];
			
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
				inputArray[globalCounterI][globalCounterJ] = number;
				globalCounterJ++;
				totalSum = totalSum + number;
			}
			
			globalCounterJ = 0;
			iArray[globalCounterI] = totalSum;
		} catch (Exception e) {
			System.err.println("Error when reading file!");
		}
	}
	
	public static void calculateJSum(String fileInput) {
		try {
			for(int i = 0; i <= fileInput.length(); i = i + 4) {
				String extractedNumber = fileInput.substring(i, i+3);
				double number = Double.parseDouble(extractedNumber);
				jArray[globalCounterJ] = jArray[globalCounterJ] + number;
				globalCounterJ++;
			}
			
			globalCounterJ = 0;
		} catch (Exception e) {
			System.err.println("Error when reading file!");
		}
	}
	
	public static int findMinimal(double[] array) {
		double difference = 0.0;
		double min = 1.0;
		int minimal = 0;
		
		for(int i = 0; i <= 22; i++) {
			double front = calculateFrontSum(i, array);
			double back = calculateBackSum(i+2, array);
			
			if(front < back) {
				difference = back - front;
			} else {
				difference = front - back;
			}
			
			if(difference < min) {
				min = difference;
				minimal = i;
			} else {
				continue;
			}
		}
		
		return minimal;
	}
	
	public static double calculateFrontSum(int index, double[] array) {
		if(index == 0) {
			return array[0];
		} else {
			return array[index] + calculateFrontSum(index-1, array);
		}
	}
	
	public static double calculateBackSum(int index, double[] array) {
		if(index == 24) {
			return array[24];
		} else {
			return array[index] + calculateFrontSum(index+1, array);
		}
	}
}