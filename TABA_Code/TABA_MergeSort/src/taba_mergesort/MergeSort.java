/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taba_mergesort;

/**
 *
 * @author jodie
 */

public class MergeSort {
    
    //create an initial public mergeSort to take in the array values 
    public static void mergeSort(int[] collection){
        
        //Call the divide method and pass in the array collection
        MergeSort.divide(collection);
        
    }
    
    // Method to perform the recursive divide section of the algorithm 
    private static void divide(int[] collection){
        
        //initialise the len variable to keep track or array length
        int len = collection.length;
        
        //base case, if length of the array is 1 or less then it has been sorted and will then be passed to the merge method
        if(len <= 1){
            return;
        }
        
        // initialise the 2 sub-arrays that the array will be divided into
        int midIdx = len/2;
        int[] leftHalf = new int[midIdx];
        int[] rightHalf = new int[len-midIdx];
        
        // copy the Left & Right side from collection array into the sub-arrays
        for(int i = 0; i < midIdx; i++){
            leftHalf[i] = collection[i];
        }
        
        for(int j = midIdx; j < len ;j++){
            rightHalf[j-midIdx] = collection[j];
        }
        
        //recursively call divide for left & right sides
        MergeSort.divide(leftHalf);
        MergeSort.divide(rightHalf);
        
        //call merge nethod to combine the sorted arrays
        MergeSort.merge(collection, leftHalf, rightHalf);
        
    }
    
    // merge method which combines 2 sorted sub-arrays back into a larger sorted array
    private static void merge(int[] collection, int[] leftHalf, int[] rightHalf){
        
        // create and initialise our 3 indexs (leftIdx, rightIdx, collectionIdx ) and len values for right and left sides
        int leftIdx = 0;
        int rightIdx = 0;
        int collectionIdx = 0;
        int leftLen = leftHalf.length;
        int rightLen = rightHalf.length;
        
        // For decending sort: compare left & right and copy larger to collection 
        // increment collectionIdx every time and icrement right or left depending which side copied from
        while((leftIdx < leftLen) && (rightIdx < rightLen)){
            
            if(leftHalf[leftIdx] > rightHalf[rightIdx]){ // The > symbol is for decending (can swap to < if ascending is required)
                collection[collectionIdx] = leftHalf[leftIdx];
                leftIdx++; // copied from leftIdx, so increment leftIdx
            }
            else{
                collection[collectionIdx] = rightHalf[rightIdx];
                rightIdx++; // copied from rightIdx, so incrment rightIdx
            }
            
            collectionIdx++;    // always increment collectionIdx
        }
        
        //Due to the setup of the previous while loop there may be a remaining value in either of the 2 sub-arrays after the loop is finished
        //The below is to copy that remaining (leftIdx) or (rightIdx) value into array (collectionIdx) if there is any
        while(leftIdx < leftLen){
            collection[collectionIdx] = leftHalf[leftIdx];
            leftIdx++;
            collectionIdx++;
        }
        
        while(rightIdx < rightLen){
            collection[collectionIdx] = rightHalf[rightIdx];
            rightIdx++;
            collectionIdx++;
        }
        
    }
}
