
public interface ListInterface <T>{
  
	public boolean add(T newEntry);
	public boolean add(int newPosition, T newEntry);
	public T remove(int givenPosition);
	public void clear();
	public boolean replace(int givenPosition, T newEntry);
	public T getEntry(int givenPosition);
	public boolean contains(T anEntry);
	public int getLength();
	public boolean isEmpty();
	public boolean isFull();
	public void display();

}
