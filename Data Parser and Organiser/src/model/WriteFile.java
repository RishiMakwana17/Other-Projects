package model;

import java.io.*;

public class WriteFile //Write file for data generation
{
    public void writeFile(WriteGeneration generation,String filename)
    {
        FileOutputStream fileStream = null;
        PrintWriter pw;
        try
        {
            fileStream = new FileOutputStream(filename);
            pw = new PrintWriter(fileStream);
            generation.write(pw);
            pw.close();
        } 
        catch (IOException e)
        {
            if (fileStream != null)
            {
                try
                {
                    fileStream.close();
                } 
                catch (IOException e2)
                {
                }
            }
            System.out.println("Error in writing to file!");
        }
    }
}
