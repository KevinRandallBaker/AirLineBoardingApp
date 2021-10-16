
public class Passenger 
{
	private int passNum;
	private int arrTime;
	private String category;
	private int priority;
	String[] categories = {"Traveling with infant", "Elderly", "Armed Services", "First Class", "Economy"};
	
	public Passenger()
	{
		passNum = -1;
		arrTime = -1;
		category = "default";
		priority = -1;
	}
	
	public Passenger(int arrTime, String category, int priority)
	{
		this.passNum = passNum;
		this.arrTime = arrTime;
		this.category = category;
		this.priority = priority;
	}
	
	public Passenger(int passNum, int arrTime, String category, int priority)
	{
		this.passNum = passNum;
		this.arrTime = arrTime;
		this.category = category;
		this.priority = priority;
	}
	
	public void setRandom(ArrayList<Passenger> roster)
	{   // Sets arrival time from 1 min after the hour to 5 min after the hour
		this.arrTime = (int)(Math.random() * (5 - 1) + 1);
		
		// Index chooses a value 0 through 4 to choose a category
		// Left as (4 - 0) + 0 to leave in formula form incase i need to change
		// (int)(Math.random() * (Max - Min) + Min)
		int index = (int)(Math.random() * (4 - 0) + 0);
		this.category = categories[index];
		if(index == 0)
			this.priority = 1;
		if(index == 1)
			this.priority = 5;
		if(index == 2)
			this.priority = 10;
		if(index == 3)
			this.priority = 15;
		if(index == 4)
			this.priority = 20;
		
		do
		{
			this.passNum = (int)(Math.random() * (9999 - 1000) + 1000);
			
		} while(checkTaken(roster, this.passNum));
		// Loops until unique ID is chosen
		
		
	}
	
	// Return true if ID is taken
	public boolean checkTaken(ArrayList<Passenger> roster, int passNum)
	{
		if(roster.getSize() == 0)
			return false;
		
		for(int i = 0; i < 20; i++)
		{
			
		}
		
		return false;
	}
	
	public int getPriority()
	{
		return this.priority;
	}
	
	public int getArrTime()
	{
		return this.arrTime;
	}
	
	public String toString()
	{
		return "Passenger " + this.passNum + " " + "|"
				+ this.category + ": " +  "Priority " + this.priority + ", "
				+  "arrived " + this.arrTime + " minute(s) past the hour";
		// Passenger 7498 |Armed Services: Priority, 10 arrived 1 minute(s) past the hour
	}
}
