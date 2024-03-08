package database;
import java.util.*;
public class Calculator {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of subjects: ");
        int totSubjects = sc.nextInt();
        
        int totalMarks = 0;
        
        for (int i=1;i<=totSubjects;i++) 
        {
            System.out.println("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            totalMarks += marks;
        }
        
        double Percentage = (double) totalMarks / totSubjects;
        
        String grade;
        
        if (Percentage >= 90)
        {
            grade = "A";
        } 
        else if (Percentage >= 80)
        {
            grade = "B";
        }
        else if (Percentage >= 70)
        {
            grade = "C";
        } 
        else if (Percentage >= 60)
        {
            grade = "D";
        }
        else 
        {
            grade = "F";
        }
        
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + Percentage + "%");
        System.out.println("Grade: " + grade);

	}

}
