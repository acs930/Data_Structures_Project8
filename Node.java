
public class Node <T>{
  
	private T data;
	private Node next;
	
	private Node (T dataPortion){
		data = dataPortion;
		next = null;
	}
	
	Node(T dataPortion, Node nextNode){
		data = dataPortion;
		next = nextNode;
	}
	
	public T getData()
	{
		return data;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node nextNode)
	{
		next = nextNode;
	}

}
