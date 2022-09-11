package model;

import java.io.*;

public class WriteGeneration
{
    private Parent root;
        
    public WriteGeneration(Parent root)
    {
        this.root = root;
    }    
   
    public void write(PrintWriter pw)
    {   
        generateWrite(root,pw);
    }   
    public void generateWrite(Parent parent, PrintWriter pw)
    {
        int spaces = 0;
        if(parent != null)
        {
            System.out.println(parent.getName()); //Prints the name
            if(parent instanceof Direction) //Tests if parent is an occurance of the Direction class, if so proceed 
            {
                spaces++;
                for(Parent p : ((Direction) parent).getLeaf()) //For each of the parents, retrieve the data 
                {
                    for(int i = 0;i < spaces;i++) // Prints the spaces 
                    {
                        System.out.print("   "); //Space printed
                    }
                    generateWrite(p,pw);
                }
            }
        }
        else
        {
            System.out.println("The value you have entered is null!");
        }
    }
}  
