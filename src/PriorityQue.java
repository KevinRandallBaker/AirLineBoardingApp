// Large amount of code found on this site
//https://www.sanfoundry.com/java-program-priority-queue/
public class PriorityQue
{
	private Task[] heap;
	private int size;
	private int capacity;
	
	public PriorityQue(int capacity)
	{
		this.capacity = capacity + 1;
		this.heap = new Task[this.capacity];
		this.size = 0;
	}

	public int size()
	{
		return this.size;
	}
	
	// Code from https://www.sanfoundry.com/java-program-priority-queue/
	// changed some names so i could more easily understand what was going on
	public void offer(Passenger passenger) 
	{
		Task newTask = new Task(passenger, passenger.getPriority());
		
		heap[++size] = newTask;
		int current = size;
		while(current != 1 && passenger.getPriority() < heap[current / 2].getPriority())
		{
			heap[current] = heap[current / 2];
			current /= 2;
		}
		heap[current] = newTask;
		
	}
	// Code from https://www.sanfoundry.com/java-program-priority-queue/
	// changed some names so i could more easily understand what was going on
	public Task poll() 
	{
		if(this.isEmpty())
		{
			System.out.println("Cannot remove from an empty list.");
			return null;
		}
		
		int parent = 1;
		int child = 2;
		Task newTask = heap[1];
		Task temp = heap[size--];
		
		while(child <= size)
		{
			if(child < size && heap[child].getPriority() > heap[child + 1].getPriority())
			{
				child++;
			}
			if(temp.getPriority() <= heap[child].getPriority())
			{
				break;
			}
			
			heap[parent] = heap[child];
			parent = child;
			child *= 2;
			
		}
		
		heap[parent] = temp;
		return newTask;
	}

	public boolean isEmpty() 
	{
		
		return size == 0;
	}
	
	public boolean isFull() 
	{
		return size == capacity - 1;
	}

	public Passenger peek() 
	{
		
		return heap[1].getPassenger();
	}

	public String toString()
	{
		String s = "";
		
		for(int i = 1; i <= size; i++)
		{
			s += heap[i] + " ";
			s += "\n";
		}
		
		return s;
	}
}
