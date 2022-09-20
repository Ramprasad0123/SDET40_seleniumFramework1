package org.providenceSMS.practice;

import java.util.Scanner;

public class TwoDimensionalArray {
	public static void main(String[] args) {
		/*String[][] arr=new String[2][2];
		arr[0][0]="a1";
		arr[0][1]="a2";
		arr[1][0]="b1";
		arr[1][1]="b2";
		
		for(int i=0;i<arr.length;i++)
		System.out.println(arr[i][i]);*/
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = sc.nextInt();
		System.out.println("Enter the number of coloumns");
		int columns = sc.nextInt();
		
		System.out.println("enter the values");
		String[][] arr = new String[rows][columns];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				arr[i][j]=sc.next();
			}
		}
		
		System.out.println("--------");
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.println(arr[i][j]);
			}
		}
	}

}
