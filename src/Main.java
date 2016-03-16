//Author: David Chong Yong Ming
//Matric No: A0116633L
//CS3230 Assignment 1

import java.text.DecimalFormat;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		//2D array to store the 25 x 25 image
		double[][] image = new double[25][25];
		Scanner scan = new Scanner(System.in);
		
		//Stores the image values scanned into the 2d array
		for(int i = 0 ; i < 25; i++) {
			for(int j = 0; j < 25; j++) {
				image[i][j] = scan.nextDouble();
			}
		} 
		
		findCenter(image);
		scan.close();
	}
	
	public static void findCenter(double[][] image) {
		//To print the double value in the requested format
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		
		//Arrays to store the summation of each row and column
		double[] rowsArray = new double[25];
		double[] columnsArray = new double[25];
		
		//Calculates the sum of each row and stores the values in two arrays
		for(int i = 0; i < 25; i++) {
			for(int j = 0; j < 25; j++) {
				if(j == 0) {
					rowsArray[i] = image[i][j];
				} else {
					rowsArray[i] += image[i][j];
				}
			}
		}
		
		//Calculates the sum of each column and stores the values in two arrays
		for(int j = 0; j < 25; j++) {
			for(int i = 0; i < 25; i++) {
				if(i == 0) {
					columnsArray[j] = image[i][j];
				} else {
					columnsArray[j] += image[i][j];
				}
			}
		}
		
		//Finds the row and column where the differences between sums are the absolute minimum
		int minRow = findMinimum(rowsArray);
		int minColumn = findMinimum(columnsArray);
		
		//Retrieves the center position from the image array
		double imageValue = image[minRow][minColumn];
		
		//To get the correct center position of the value on the 25 x 25 image.
		minRow += 1;
		minColumn += 1;
		
		//Prints out the center position and its image value to the user
		System.out.print(minRow + " " + minColumn + " " + decimalFormat.format(imageValue));
	}
	
	public static int findMinimum(double[] sumArray) {
		double difference= 0.00;
		double minDifference = 10.00;
		int min = 0;
		
		for(int i = 0; i < 24; i++) {
			if(i == 0) {
				double zeroCase = calculateBackSum(i+1, sumArray);
				difference = zeroCase;
			}
			
			if(difference <= minDifference) {
				minDifference = difference;
				min = i;
			}
				
			double beforeIndex = calculateFrontSum(i, sumArray);
			double afterIndex = 0.0;
			
			if(i == 23) {
				difference = beforeIndex;
				if(difference <= minDifference) {
					minDifference = difference;
					min = i + 1;
				}
			} else {
				afterIndex = calculateBackSum(i+2, sumArray);

				if(beforeIndex < afterIndex) {
					difference = afterIndex - beforeIndex;
				} else {
					difference = beforeIndex - afterIndex;
				}
			}
		}
		
		return min;
	}
	
	//Recursive method to calculate the sum before the current index
	public static double calculateFrontSum(int index, double[] sumArray) {
		if(index == 0) {
			return sumArray[0];
		} else {
			return sumArray[index] + calculateFrontSum(index - 1, sumArray);
		}
	}
	
	//Recursive method to calculate the sum after the current index
	public static double calculateBackSum(int index, double[] sumArray) {
		if(index == 24) {
			return sumArray[24];
		} else {
			return sumArray[index] + calculateBackSum(index + 1, sumArray);
		}
	}
}