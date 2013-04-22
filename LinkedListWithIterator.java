import java.rmi.NoSuchObjectException;


public class LinkedListWithIterator <T> implements ListWithIteratorInterface<T>
{

  private Node firstNode;
	private int length;
	
	public LinkedListWithIterator() { clear();};
	
	public java.util.Iterator<T> getIterator()
	{
		return new IteratorForLinkedList();
	}
	
	private class IteratorForLinkedList implements Iterator<T>, java.util.Iterator<T>
	{
		private Node nextNode;
		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		}
		
		public T next()
		{
			if(hasNext())
			{
				Node returnNode = nextNode;
				nextNode = nextNode.getNext();
				return (T) returnNode.getData();
			}
			
			else 
			{
				return null; //could cause problems
			}
		}
		
		public boolean hasNext()
		{
			return nextNode != null;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException("remove not supported");
		}
	}

	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry, null);
		
		if(isEmpty() == true)
		{
			firstNode = newNode;
			return true;
		}
		
		else
		{
			newNode.setNext(firstNode);
			firstNode = newNode;
			return true;
		}
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(firstNode.getNext() == null)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}


		
}
