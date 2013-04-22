
public class queue <T> implements queueInterface <T>{
  
	
	private Node firstNode;
	private Node lastNode;
	
	public queue()
	{
		firstNode = lastNode = null;
	}
	
	public void enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry, null);
		
		if(isEmpty() == true)
		{
			firstNode = newNode;
			lastNode = newNode;
		}
		
		else
		{
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
		
	}
	
	public T getFront()
	{
		T front = null;
		
		if(isEmpty() == false)
		{
			front = (T) firstNode.getData();
		}
		
		return front;
	}
	
	public T dequeue()
	{
		T front = null;
		
		if(isEmpty() == false)
		{
			front = (T) firstNode.getData();
			firstNode = firstNode.getNext();
			
			if(firstNode == null)
			{
				lastNode = null;
			}
		}
		
		return front;
	}
	
	public boolean isEmpty()
	{
		if(firstNode == null && lastNode == null)
		{
			return true;
		}
		
		return false;
	}
	
	public void clear()
	{
		firstNode = null;
		lastNode = null;
	}
	

}
