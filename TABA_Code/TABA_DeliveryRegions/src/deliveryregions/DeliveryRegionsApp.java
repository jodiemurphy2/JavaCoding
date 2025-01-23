/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deliveryregions;

import java.util.List;

/**
 *
 * @author jodie
 */
public class DeliveryRegionsApp {

    public static void main(String[] args) {
        
        //Check if the summary report already exists and delete if so delete it
        String summaryName = "summaryReport.txt";
        FileIO.deleteIfExists(summaryName);
        
        //create three instances of the Threading class and pass in the file names
        Threading thread1 = new Threading("region1.txt");
        Threading thread2 = new Threading("region2.txt");
        Threading thread3 = new Threading("region3.txt");
        
        //Start the threads which will simultaniously calculate to statistics for each file and write them to the output file
        thread1.start();
        thread2.start();
        thread3.start();
        
    }
    
}
