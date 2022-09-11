package model;
import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.Map;
//Extention of the absract parent class
//This class sorts out the power consumption 
    //by splitting the contents and pairing it to the appropriate day(Monday,Tuesday,etc)
public class PowerConsumption extends Parent
{
    private float Mon,Tues,Wed,Thurs,Fri,End;
    public static final String[] DAYS = {"Mon", "Tues", "Wed", "Thurs", "Fri", "End"}; //Constants displaying each day
    public static final String[] FULL_DAYS = {"Monday","Tuesday","Wednesday","Thursday","Friday","Weekend"};
    
    private Map<String,Double> powerConsumption; //Declares TreeMap for power consumption

    public PowerConsumption(String name, String parent, String power)
    {
        super(name, parent); //Super used to retrieve the name and parent from the parent class
        setData(power); //Declares and maintains setData method 
        powerConsumption = new TreeMap<>();
    }
    
    public PowerConsumption(String name,double power)
    {
        super(name);
        //setData(power);
        powerConsumption.put(name, power);
    }
 
       
    public void add(String category, double power)
    {
        powerConsumption.put(category,power); //Add value to power consumption
    }
    
    public Map<String,Double> getValues() //Total value of the power consumption
    {
        return powerConsumption;
    }
    
    public Map<String,Double> getPowerConsumption()
    {
        return powerConsumption;
    }
    
    public float[] getData() //Getter to retrieve the values of the data
    {
        float[] data = {Mon, Tues, Wed, Thurs, Fri, End};
            return data;
    }


    public void setData(String days) 
    {
        String parts[] = days.split(","); //Splits the days in the csv files using split via ,
        for (int i = 0; i < parts.length; i++)  //Iterate through the days
        {
            String day[] = parts[i].split("="); //Splits the day from the eletricity value associated with the day using = 
            float period = Float.parseFloat(day[1]); //Parses the value

            if(day[0].equals("Mon")) //If the day is equaled to the string provided, store the value of the day in period  
            {
                this.Mon = period; //Uses this.Mon as Mon is a private float (similarly for all days used)
            } 
            else if(day[0].equals("Tues")) 
            {
                this.Tues = period;
            } 
            else if(day[0].equals("Wed")) 
            {
                this.Wed = period;
            } 
            else if(day[0].equals("Thurs")) 
            {
                this.Thurs = period;
            } 
            else if(day[0].equals("Fri")) 
            {
                this.Fri = period;
            } 
            else if(day[0].equals("End")) 
            {
                this.End = period;
            } 
            else 
            {
                System.out.println("Wrong value is entered"); 
            }
        }
    }

}
