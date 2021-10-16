
public class Task 
{
	private int priority;
	private Passenger passenger;
	
	public Task(Passenger passenger, int priority)
	{
		this.passenger = passenger;
		this.priority = priority;
		
	}
	
	public int getPriority()
	{
		return this.priority;
	}
	
	public Passenger getPassenger()
	{
		return this.passenger;
	}
	
	public String toString()
	{
		return passenger + "";
	}
}
