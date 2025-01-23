/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taba_mergesort;

/**
 *
 * @author jodie
 */
public class MergeSortApp {

    // helper method to print out the array in a readable form
    public static String toString(int[] elements){
        
        String temp = "";
        
        // loop through array and add to a string variable sepated by a ","
        for(int idx = 0; idx < elements.length; idx++){
            if(idx != 0) temp += ",";
            
            temp += elements[idx];
        }
        
        // return the completed string 
        return temp;
    }
    
    // main method which will call the mergeSort method
    public static void main(String[] args) {
        
        // initialise the array using the values given in Q3 (d)
        int[] collection = {24,11,36,42,51,46,22,9};
        
        // print out the unsorted array
        System.out.println("Unsorted: " + toString(collection));
        
        // Callm the mergeSort method the sort the values in decending order
        MergeSort.mergeSort(collection);
        
        // print out the values which are now sorted decendingly
        System.out.println("Sorted decendingly: " + toString(collection));
        
    }
    
}
