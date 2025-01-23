/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliveryregions;

/**
 *
 * @author jodie
 */
public class Threading extends Thread{
    
    //initialise variables
    private String fileName;
    
    //overloaded constructor which will take in the name of the file
    public Threading(String fileName){
        this.fileName = fileName;
    }
    
    //override the run method to perform the read file, data calculations, and writing the output file.
    @Override
    public void run(){
        
        //instatiate the timeout variable to assist with synchronisation randoml;y chooses a time between 1 and 3 seconds
        int timeout = ((int)(Math.random() * 3000) + 1000);
        
        //read the file and store data in an array
        String[] fileData = FileIO.readFile(fileName);
        
          
        // send the array for calulation and receive String back
        String summary = DataProcessing.calculateSummary(fileData);
        System.out.println(fileName + " summary data: " + summary);
        
        // synchronisation block to prevent threads from attempting to write to the file at the same time
        try {
            
            //Thread will sleep for an amount of time before attempting to write to file
            Thread.sleep(timeout);
            
            //write the string to new file
            String summaryReport = "summaryReport.txt";
            FileIO.writeFile(summaryReport,summary); 
            
        }
        //If thread is interrupted print error
        catch (InterruptedException e){
            System.out.println(" Thread was interrupted");
        }
    
    }
}
