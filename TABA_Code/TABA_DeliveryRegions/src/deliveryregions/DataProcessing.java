/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliveryregions;

/**
 *
 * @author jodie
 */
public class DataProcessing {
    
    //method to perform all calculations required for the summary report from the array of file data
    public static String calculateSummary(String [] fileData){

        // get region name by checking the 2nd element in the first line in the array
        String region = fileData[0].split(",")[1];
        
        // i. Total number of deliveries - each line represents 1 delivery so array length is total deliverys
        int totalDeliveries = fileData.length;
        
        // ii. Total deliveries that have a delivered status
        
        int totalDelivered = 0; //variable to track number of delivered
        
        // loop through array and convert each element into a new array split based on commas
        for(int i=0; i<fileData.length; i++){
            String[] lines = fileData[i].split(",");
            if(lines[3].equals("Delivered")) totalDelivered ++; //check if status is delivered and increase counter
        }
        
        // iii. Percentage of Delivered of Total stored as a float to have decimal values
        float percentageDelivered = ((float)totalDelivered)/totalDeliveries *100;
        
        // create String of summary values and return it
        //formating used on float to have 6 digits after decimal as displayed in the questions example
        String summary = region + "," + totalDeliveries + "," + totalDelivered+ "," + String.format("%.6f",percentageDelivered);
        
        //return the string
        return summary;
    }
    
}
