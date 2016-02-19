

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;




/*

Begin Program

Initialize main
Initialize variables
  Integer number of points
  Integer user inputted length
  Three dimensional array
  File to be written/read
Ask for user input for number of points and length used
Assign the three dimensional array values
Run GeneratePoints method with the 3d array as parameter
  Loop through each dimension and insert random generated number in range in each index
Run the WriteFile method to write to a text file
  Create file
  Print in array
Run the ReadFile method to read and output the text file
  Open the file
  Loop and read until no lines left and output contents


End Program
  


*/



public class multiarrays
{
 
  public static int numPoints; //number of points
  public static double length; //the length of each point
  public static double[][][] dataPoints; //the 3d array
  public static PrintWriter writeFile; //printwrite to write to a file
  public static File readFile; //file that is going to be read



  public static void main(String[] args)
  {

   
    
    Scanner in = new Scanner(System.in); //new user input stream

    //get the number of points
    System.out.println("Enter number of points");
    numPoints = in.nextInt();
    //assign the dimensions of the array
    dataPoints = new double[numPoints][2][3];

    //get the length used for the range of points
    System.out.println("Enter length");
    length = in.nextDouble();

    in.close(); //close input stream

    GeneratePoints(length, numPoints); //generate the points
    WriteFile(); //write the file
    readfile(); //read and output the array

  }//end main()

  
   /*

  The GeneratePonts method loops through the three dimensional array
  and creates random numbers from the range (-length to +length) given by the user and
  inputs them into the array. 

  */



  public static void GeneratePoints(double length, int numPoints)
  {
    //loops through each dimension
    for (int i = 0; i < numPoints; i++)
    {
      for (int x = 0; x < 2; x++) {
       
       for(int y = 0; y < 3; y++){
        //generate random number in the range
        double random = -length + (length - -length) * new Random().nextDouble();
        //assign each index
        dataPoints[i][x][y] = random;
       }
      }
    }
  }

 /*

  The WriteFile method creates a new output text file
  and writes in the array 

  */
  


public static void WriteFile(){
 try{
 writeFile = new PrintWriter (new FileWriter ("arrays.txt")); //create new output stream and file
  writeFile.println(Arrays.deepToString(dataPoints)); //write in the array
  writeFile.close(); //close output stream

} catch (IOException e) {
  System.out.println(e.getMessage()); //print out error message
}
    
    


}




  /*

  The readfile method opens the written file and loops and outputs the text files contents 
  until there are no lines left to ouput. 

  */

public static void readfile(){
  readFile = new File("arrays.txt"); //assigns file

 //new input stream
 
 //loop until theres no lines left to read
 try{
  
  Scanner read = new Scanner(readFile); 
  
  while (read.hasNextLine()) {
  String out = read.nextLine(); //reads each line and assigns to string
  System.out.println(out); //output the string
  }
 
  read.close(); //close input stream
  
  } catch (FileNotFoundException e) { 
    
    System.out.println("error, File not found"); //print out error message

  }


  
        
 
} //end readfile method








} //end class

