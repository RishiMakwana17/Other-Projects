package model;
import java.util.*;
//Abstract class is implemented to interact with leaf node
//and composite node similarly
//The class Direction utilises this class
abstract public class Parent 
{
    private String name;
    private String parent;
          
    public Parent(String name) //Constructor that takes multiple parameters
    {
        this.name = name;
    }
       
    public Parent(String name, String parent) //Constructor
    {
        this.name = name; //Declares variables in Constructor
        this.parent = parent;
    }

       
    public String getName() //Getter class for name
                            //This allows the name of the variable to be called 
                                //for use of display for example
    {
        return name;
    }
           
    public String getParent() //Allows us to retrieve the information stored in the parent
    {   
        return parent;
    }

    public void setName(String name) 
    {
        this.name = name;
    }   
       
    public boolean isLeaf()
    {
        return true;
    }
}
