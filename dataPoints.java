//import java util and io
import java.util.*;
import java.io.*;
//initialize new class
class dataPoints{
 
 private int dims; //dimensions of array
 private int numPoints; //number of points
 private double range; //range of datapoints
 private double data[][]; //array with datapoints 
 
 //default constructor
 public dataPoints(){
    range = 0; 
    numPoints = 0;
    dims = 0;  
    data = new double [numPoints] [dims  + 1]; //create array with extra
   
 }
 //constructor with arguments
 public dataPoints(int SetnumPoints, int Dimensions, int Length  ){
   range = Length;
   numPoints = SetnumPoints;
   dims = Dimensions;
   data =  new double [numPoints] [dims+1];
   
 }
 
 
 
 //fill array with arguments
 public static void fillArray(double points[][], int MynumPoints, int Mydims, double Myrange){
   for(int r=0;r < MynumPoints;r++){
     
     for(int c=0; c < Mydims ;c++){
       //put random points in array
       points[r][c] = -Myrange + (Myrange - -Myrange) * new Random().nextDouble();
       
       
     }
 }
 }
 

//write data method 
 public static void writeData(double[][] points){
   PrintWriter writeFile; //new file to write
   try{
 writeFile = new PrintWriter (new FileWriter ("data.txt")); //create new output stream and file
  writeFile.println(Arrays.deepToString(points)); //write in the array
  writeFile.close(); //close output stream

} catch (IOException e) {
  System.out.println(e.getMessage()); //print out error message
}

 }
 //method reads the file data
 public static void readData(){
    File readFile = new File("data.txt"); //assigns file

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
    
    System.out.println(e.getMessage()); //print out error message

  }
   
   
   
 }

//finds distance for data points
 public static void getDist(double[][] points, int cdims, int cnumPoints){
   //loop through points
       for (int a=0; a < cnumPoints;a++){
     //loop through dimensions
     for(int b=0; b < cdims;b++){
       
       //add points and put them in the last dimension
     points [a][cdims] += points[a][b] * points[a][b];
         
     }
     //square root the sum
      points [a][cdims] = Math.sqrt(points[a][cdims]);
   }
 
}
 

 //sorts the array
 public static double[][] sortArray(double[][] points, int cdims, int down, int top){

//down and top position   
int i = down;
int j = top;
//finds the middle
double x = points[(down+top)/2][cdims];

do{
  //while the position is less than the middle move it down
  while(points[i][cdims]<x){
    i++;
  }
    //while the position is less than the middle move it up
  while(points[j][cdims]>x){
   j--; 
  }
  
  if(i<=j){
    //create new pivot array
    double[] pivot = new double[points[i].length];
    
    for(int y=0; y < points[i].length; y++){
      //switch positions with pivot
      pivot[y] = points[i][y];
      points[i][y] = points[j][y];
      points[j][y] = pivot[y];
      
    }
    i++;
    j--;
    }
} while(i<=j);

//use recursion to keep looping until all points are sorted
if(down < j){
 points = sortArray(points,cdims,down,j); 
}

if(i < top){
 points = sortArray(points,cdims,i,top); 
}
//return the sorted array
return points;
    

    
    
   
   
 }
 
 








//gets data array
 public double[][]  getArray(){
  return data; 
  }
 public int getDims(){
  return dims; 
 }
 //gets number of points
 public int getnumPoints(){
  return numPoints; 
 }
 //sets the number of data points
 public void setNumPoints(int points){
  numPoints=points; 
 }
 //gets the range of the data points
 public double getRange(){
  return range; 
 }
 //sets the range of the data points
 public void setRange(int length){
  range = length; 
 }
 

}