package controller;

import model.*;
import view.Display;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

//This class reads the data in the file, parses it correctly and displays
public class Operation 
{
    public static void treeFunction(String inputFile) throws OperationException
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile)))
        { //Reads text from character input stream
        Map<String,Direction> TreeMap = new TreeMap<String,Direction>(); //Stores the direction(SouthPerth,Perth)
        ArrayList<Parent> parentList = new ArrayList<Parent>(); //Stores the new parent in array
    
        Display display = new Display();//Calls display class
        Direction root = null;    

        String eachLine; //Declarations and initalisations of variables
        String parent = "";
        String sections = "";
            
        while((eachLine = reader.readLine()) != null)  //Reads through the lines in the file and ensures that it is not empty 
        {
            String[] parts = eachLine.split(",");//Uses split function to break up the strings, via a comma so strings can be stored as objects 
            String start = parts[0]; //The root of the tree in the csv file(Perth)
            if(TreeMap.containsKey(start))
            {
                throw new IllegalArgumentException("node already exists");
            }

            if(parts.length >= 2) //If length row is equals/greater than 2, it's not a root as the root would be of length 1
            {
                parent = parts[1]; 
            }        
            if (parts.length >= 3) //If length of row equals/greater than 3, it must contain the building,parent and power consumption
            {
                String[] parse = data(parts); 
                sections = String.join(",",parse); //Links the elements with the delimiter(","), returning a string
            }
                
            if(parts.length == 1) //If the element is a root (length is 1)
            {
                root = rootComponent(parentList,TreeMap,start); //Perform function and store in root variable 
            }    
            else if (parts.length == 2) //If the element is the direction (length is 2)
            {
                parentList.add(new Direction(start,parent)); //Add the name and parent into array (e.g.Southperth,Perth)
                int direction = parentList.size() - 1; //Determines where the next element is
                Direction address = (Direction) parentList.get(direction); //Store in Direction and parse map as Direction object
                TreeMap.put(address.getName(), address); //Inserts key, being the name(SouthPerth) and its value
                TreeMap.get(address.getParent()).addLeaf(address); //returns element using getParent function in Direction, also adding it as a leaf node
            }
            else //If the element isn't 1 or 2, then perform the powerConsumption (3 is the last/greatest length in file)
            {
                parentList.add(new PowerConsumption(start,parent,sections)); //Add name, parent and power consumption into array (building,southperth,power consumption)
                int powerCon = parentList.size()-1; //Determines next element
                PowerConsumption power = (PowerConsumption) parentList.get(powerCon); //Store in powerConsumption, and parse map as PowerConsumption object
                TreeMap.get(power.getParent()).addLeaf(power); //returns element using getParent function and addes it as a leaf node
            }
        }
        display.displayTree(root);
        display.displayPowerConsumption(root);
        }catch(IOException e)
        {
            System.out.println("There was an error reading into the file!");
        }
        catch(IllegalArgumentException e)
        {
            throw new OperationException("Illegal Argument!");
        }
    }


    private static Direction rootComponent(ArrayList<Parent> parentList,Map<String,Direction> treeMap,String start)
    {
        parentList.add(new Direction(start,"")); //Stores start as name in Direction and "" as parent, as the root has no parent value
        int element = parentList.size() - 1; //Determines where the next element is
        Direction address = (Direction) parentList.get(element); // Store in Direction and parse the map as the Direction object
        treeMap.put(address.getName(),address); //Inserts the key, being the name(root) and its value into the map
        return address; //Return to be stored in root object
    }

    private static String[] data(String[] parts)
    {
        int arraySize;
        String[] sections;
        arraySize = parts.length - 2; //Retrieves building but subtracting length of array by 2 (power consumption to building)
        sections = new String[arraySize]; //Stores in array
        for(int i = 0;i< arraySize;i++) //Iterates through the row
        {
            sections[i] = parts[i+2]; 
        }
        return sections;
    }
   
} 
   
