/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taba_arraysum;

/**
 *
 * @author jodie
 */
public class ArraySum {

    public static void main(String[] args) {
        // Example array of integers
 	int[] numbers = {1, 2, 3, 4, 5}; 
        // Call the sumArray method and store the result
 	int sum = sumArray(numbers); 
 	// Print the result
 	System.out.println("The sum of the array elements is: " + sum); 
        
        //Q2 (b) - Cal new comparison function and print results to console
        int compSum = compareArray(numbers);
        System.out.println("The sum of each number in the array with every number: " + compSum);

    }
    
    // Method to calculate the sum of an array of integers
    public static int sumArray(int[] arr) {
 	int total = 0;
 	for (int num : arr) {
            total += num; // Add each element to the total O(1)
 	}
 	return total;
    }
    
    // Q2 (b) - New method to compare numbers in array using nested loops
    public static int compareArray(int[] arr){
        int total = 0;
        for (int firstNum : arr) {
            for (int secondNum : arr){
                total += firstNum + secondNum;
            }
 	}
 	return total;
    }
}
