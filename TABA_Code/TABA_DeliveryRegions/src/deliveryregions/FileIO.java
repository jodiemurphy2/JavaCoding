/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliveryregions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jodie
 */
public class FileIO {
    
    // method used to delete the output file if it already exists
    public static void deleteIfExists(String fileName){
        
        //get the path to the file
        Path filePath = Paths.get(fileName);
        try {
            System.out.println("Deleting file: " + filePath);
            Files.delete(filePath); //delete the file
        }    
        catch(IOException ioException) {
            System.out.println("Error: " + ioException); // if file already doesnt exist return error
        }    
    }
    
    //method to read the files. Take in the file name and returns an array of values
    public static String [] readFile(String filePath){
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String str;
            List<String> fileLines= new ArrayList<String>(); //create array list to store lines read from the file. Array List used instead of array as size is unknown.
            while ((str = br.readLine()) != null){ // read each line of file until end of file
                fileLines.add(str); // store each line in the array list
            }
            //convert array list to array of strings and return the array
            String[] fileData= fileLines.toArray(new String[0]);
            System.out.println("Data has successfuly been read from " + filePath);
            return fileData;
        }
        //if error occurs print out the error
        catch(IOException e){
            System.out.println(e);
        }
        return null;
    }
    
    //method to write the summary report file. Takes in what file should be named and the information to write.
    //Has append capabilities so new lines can be added.
    public static void writeFile(String fileName, String summaryData){
        
        //attempt to write to file or create a new if file it does not exist.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.append(summaryData+"\n");  //append the data as a new line
            System.out.println("Data has been appended to " + fileName);
        }
        //if error occurs print out the error
        catch(IOException e){
            System.out.println(e);
        }
        
    }
    
}
