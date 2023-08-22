//                STUDENT GRADE CALCULATOR

package com.codesoft.StudentGradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String[] args) {
		
       Scanner scn = new Scanner(System.in);
       
       System.out.println("Enter the total number of subjects: ");
       
       int totalsubjects = scn.nextInt();
       
       int []marksobtained = new int[totalsubjects];
       
       for(int i=0; i<totalsubjects; i++) {
    	   System.out.println("Enter the marks obtained in subject " + ( i + 1) + ":");
    	   marksobtained[i] = scn.nextInt();
       }
       
       int totalmarks=0;
       
       for(int i=0; i<totalsubjects; i++) {
    	   totalmarks +=marksobtained[i];
       }
       
       System.out.println("The total marks obtained: " + totalmarks);
       
       double avgpercentage = ((double)totalmarks / (totalsubjects * 100)) * 100;
       
       System.out.println("The average percentage obtained: " + avgpercentage +" %");
       
       if(avgpercentage>=90) {
    	   System.out.println("Grade Obtained: A");
       }
       else if(avgpercentage>=80) {
    	   System.out.println("Grade Obtained: B");
       }
       else if(avgpercentage>=70) {
    	   System.out.println("Grade Obtained: C");
       }
       else if(avgpercentage>=60) {
    	   System.out.println("Grade Obtained: D");
       }
       else if(avgpercentage>=50) {
    	   System.out.println("Grade Obtained: E");
       }
       else{
    	   System.out.println("Grade Obtained: F");
       }
       scn.close();
   }
}
