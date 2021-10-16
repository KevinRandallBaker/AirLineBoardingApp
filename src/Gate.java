
public class Gate 
{
	public PriorityQue que = new PriorityQue(20);
	public ArrayList<Passenger> roster = new ArrayList<>(20);
	int  highestPriority = 1;
	
	
	public void board()
	{
		// Adds passengers to ArrayList
		for(int i = 0; i < 20; i++)
		{
			// Creates 20 unique passengers
			Passenger temp = new Passenger();
			temp.setRandom(roster);
			roster.add(temp);
		}
		
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 20 - i - 1; j++)
			{
				if(roster.get(j).getArrTime() > roster.get(j + 1).getArrTime())
				{   // Swapping to sort ArrayList according to arrival time
					Passenger temp = roster.get(j);
					roster.set(roster.get(j + 1), j);
					roster.set(temp, j + 1);
				}
			}
		}
		
		System.out.println("Roster of passengers before boarding.");
		System.out.println("_____________________________________________________________________________________");
		System.out.println(roster);
		
		// i < 300s | 300s = 5 min
		// i += 20 to represent 20 second board time
		// i sort of represents current time
		for(int i = 0; i < 300; i += 20)
		{
			// Adds people to que if they have arrived at the time i * 60 minutes
			while(!roster.isEmpty() && roster.get(0).getArrTime() <= i * 60)
			{
				que.offer(roster.remove(0));
			}
		}
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("List of passengers in order of when they boarded");
		System.out.println("_____________________________________________________________________________________");
		System.out.println(que);
	}
	
	
}
