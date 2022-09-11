package model;

import java.util.List;
import java.util.ArrayList;
//import java.util.*;
//This class is an extension of the abstract Parent class
//It stores and maintains the name and parent, for example SouthPerth and Perth on line 2 of the csv file
public class Direction extends Parent
{
    List<Parent> leaf = new ArrayList<>(); //Container ArrayList is utilised      
    private PowerConsumption powerConsumption;   
    private Parent parent1;
           
    public Direction(String name)
    { 
        super(name); //Constructor that takes in name parameter 
    }
        
    public Direction(String name, Parent parent)
    {
        super(name);
        this.parent1 = parent1;
    }
   
    public Direction(String name,String parent)
    {
        super(name,parent); //Uses the reference variable 'super' to call name and parent from the the Parent class contructor
    }
 
    public boolean addLeaf(Parent parent) //By instantating addLeaf, it will add the specified elemtn to the end of the list array
    {
        return leaf.add(parent); 
    }
    
    public boolean removeLeaf(Parent parent) //Similar to addLeaf, this constructor removes an element from the list
    {
        return leaf.remove(parent);
    }
    
    public List<Parent> getLeaf() //The getLeaf method will return the element from the position in the list
    {
        return leaf;
    }
    
    public int size() //Return the number of elements that are in the list
    {
        return leaf.size();
    }
 
    public void addPowerConsumption(String category,double power) //Allows us to add a values to the power consumption
    {
        powerConsumption.add(category,power);
    }
    
    public Parent find(String name) //Finds values by comparing the stored,parsed value against the value in the file
    {
        Parent found = null;
        if (super.getName().equals(name))
        {
            found = this;
        }
        return found;
    }    

       
    public String toString() //toString method used to output 
    {
        String str = super.getName();
        if(super.getParent() != null)
        {
            str += ", " + super.getParent();
        }
        return str;
    }
}
