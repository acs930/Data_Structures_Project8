
public class stack <T> implements stackInterface <T>{
  
	private Node topNode;
	
	public stack()
	{
		topNode = null;
	}
	
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, null);
		topNode = newNode;
		
	}
	
	public T pop()
	{
		T top = peek();
		if(topNode != null)
		{
			topNode = topNode.getNext();
		}
		
		return top;
	}
	
	public T peek()
	{
		T top = null;
		
		if(topNode != null)
		{
			top = (T) topNode.getData();
		}
		
		return top;
	}
	
	public boolean isEmpty()
	{
		if(topNode == null)
		{
			return true;
		}
		
		return false;
	}
	
	public void clear()
	{
		topNode = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
