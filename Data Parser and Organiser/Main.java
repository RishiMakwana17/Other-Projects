import model.*;
import view.*;
import controller.*;

import model.PowerConsumption;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{

    public static void main(String args[]) throws OperationException
    {
    
        if(args.length < 2)
        {
            System.out.println("Please enter two or more parameters!");
        }           
        else
        {
            try
            {
                if(args[0].equals("-r") && args[2].equals("-d")) //"-r inputdata.csv -d"
                {    
                    Operation.treeFunction(args[1]);       
                }
                else if(args[0].equals("-g") && args[1].equals("-d")) //"-g -d"
                {
                    Display display = new Display();
                    RandomGeneration generate = new RandomGeneration();
                    Parent store = generate.generateData();
                    display.displayTree(store);
                    
                }
                else if(args[0].equals("-g") && args[1].equals("-w")) //"-g -w outputdata.csv"
                { 
                    WriteFile file = new WriteFile();
                    RandomGeneration generate = new RandomGeneration();
                    WriteGeneration write = new WriteGeneration(generate.generateData());
                    file.writeFile(write,args[2]);
                }
                else if(args[0].equals("-r") && args[2].equals("-w")) //"-r inputdata.csv -w outputdata.csv"
                { 
                    WriteData write = new WriteData();
                    write.writeFile(args[1],args[3]);
                }
                else
                {
                    System.out.println("Please enter a valid input!");
                    System.out.println("Enter: ./gradlew run --args= followed by any of these instructions to run the program:\n1.-r inputdata.csv -d                                                                                                                                         \n2.-g -d                                                                                                                                                       \n3.-g -w outputdata.csv                                                                                                                                        \n4.-r inputdata.csv -w outputdata.csv    ");

                }
            
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Array is out of bounds!");
            System.out.println("Enter: ./gradlew run --args= followed by any of these instructions to run the program:\n1.-r inputdata.csv -d                                                                                                                                     \n2.-g -d                                                                                                                                                   \n3.-g -w outputdata.csv                                                                                                                                    \n4.-r inputdata.csv -w outputdata.csv");
            }   
        }   
    }
}

