package controller;

import view.*;
import model.*;

public class RandomGeneration 
{
    public Parent generateData()
    {   
        int leafSize = randDepth(0,5); //The number of children
        Direction root = new Direction("Perth"); //The name of the root
        for(int i = 0;i < leafSize;i++) //Iterate through number of children
        {
            Parent leaf = generateDataRecursive(root,randDepth(0,1),4); //Calls the recursive method
            root.addLeaf(leaf); //Add value to ArrayList in Direction
        }
        return root; 
    }
    
    private Parent generateDataRecursive(Parent parent,int nodeIn,int depth)
    {   
        Direction node;
        int leafSize = randDepth(2, 5); //Random depth of the leaf
        String name = generateName(4);   //Generates a name with 4 letters
        if (nodeIn == 0 || depth == 5) 
        {
            node = new Direction(name, parent);
        } 
        else
        {
            node = new Direction(name, parent);
            for (int i = 0; i < leafSize; i++) //loop for the depth of the leaf
            {
                int nDepth = depth + 1;
                Parent leaf = generateDataRecursive((Direction)node, randDepth(0, 1), nDepth); //Calls recursive method
                ((Direction) node).addLeaf(leaf); //Adds value to ArrayList in Direction
            }
        }
        return node;
    }
 
    
       
    public String generateName(int size) //Generates a random name
    {
        char[] letters = "ABCDEFGHIKLMNOPQRSTUVWXYZ0123456789".toCharArray(); //Uses .toCharArray to return a new allocated character array
        char[] name = new char[size]; //name generates 
        
        for(int i = 0;i < size;i++) //for the size of the name
        {
            int random = randDepth(0,letters.length- 1); //randomise the depth
            name[i] = letters[random];  //store the name
        }
    
        return new String(name); 
    }
    
    private int randDepth(int min,int max)
    {
        return (int)((Math.random() * (max - min + 1) + min)); //provide a random value integer
                                                               //Essentially provides a random number in between the min and max variable that has been entered
    }
    
}
    

