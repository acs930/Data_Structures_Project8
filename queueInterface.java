
public interface queueInterface <T>{
  
	public void enqueue (T newEntry);
	
	public T dequeue();
	
	public T getFront();
	
	public boolean isEmpty();
	
	public void clear();
	
	

}
