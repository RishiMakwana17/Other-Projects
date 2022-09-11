package view;
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.Map;

import static model.PowerConsumption.FULL_DAYS;
import static model.PowerConsumption.DAYS;

import model.*;

public class Display
{
    public static void displayTree(Parent parent) //Wrapper method for the recursed tree
    {
        try{
            traverseTree(parent,0);
        }catch(Exception e)
        {
            System.out.println("Error traversing the tree!");
        }   
    } 
    
    
    public static void traverseTree(Parent parent, int spaces) throws displayException
    {
        if(parent != null)
        {
            System.out.println(parent.getName()); //Prints the name
            if(parent instanceof Direction) //Tests if parent is an occurance of the Direction class, if so proceed 
            {
                for(Parent p : ((Direction) parent).getLeaf()) //For each of the parents, retrieve the data 
                {
                    for(int i = 0;i < spaces;i++) // Prints the spaces 
                    {
                        System.out.print("   "); //Space printed
                    }
                    traverseTree(p,spaces + 1);
                }
            }
        }
        else
        {
            throw new displayException("The value you have entered is null!");
        }
    }
    
    public static void displayPowerConsumption(Parent parent) //Displays the power consumption to the user
    {
        float power[] = new float[6]; //Declares how many elements are in the array
        try
        {
            power = powerConsumptionRecord(parent,power); //Stores the values into the array data
        }
        catch(Exception e)
        {
            System.out.println("Error displaying power consumption!");
        }
        System.out.println();
        System.out.println("Monday    : "+power[0]);
        System.out.println("Tuesday   : "+power[1]);
        System.out.println("Wednesday : "+power[2]);
        System.out.println("Thursday  : "+power[3]);
        System.out.println("Friday    : "+power[4]);
        System.out.println("Weekend   : "+power[5]);

    }
    
    public static float[] powerConsumptionRecord(Parent parent, float[] power) throws displayException//Root 
    {        
        float[] elements = power;
        float[] powerGenerated;
        if(parent != null)
        {
            if (parent instanceof Direction) //If the parent is an occurance of the direction then proceed the recursive call
            {
                for(Parent buildings : ((Direction) parent).getLeaf()) //For each of the buildings, get the child nodes of each 
                {
                    if(buildings instanceof PowerConsumption) //Once it has reached the buildings, it retrieves the data stored in the buildings
                    {
                        powerGenerated = ((PowerConsumption) buildings).getData(); 
                        for(int i = 0; i < 6; i++) //Loops through the days  
                        {
                            elements[i] = elements[i] + powerGenerated[i];//Adds together the power consumptions to get the accumulated amount
                        }
                    }
                    else 
                    {
                        powerConsumptionRecord(buildings, elements);
                    }
                }
            }
        }
        else
        {   
            throw new displayException("The value you have entered is null!");
        }
        return elements;
    }
    
}
