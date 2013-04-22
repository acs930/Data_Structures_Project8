import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Maze <T>{


  
	
	public queueInterface<T> getBreadthFirstTraversal(T origin, Vertex[] vertices, int vertSize)
	{
		queueInterface<T> traversalOrder = new queue<T>();
		queueInterface<VertexInterface<T>> vertexQueue = new queue<VertexInterface<T>>();
		VertexInterface<T> originVertex = new Vertex(null);
		for(int i= 0; i < vertSize; i++)
		{
			if(vertices[i].getLabel() == origin)
			{
				 originVertex = vertices[i];
			}
		}
		
		originVertex.visit();
		traversalOrder.enqueue(origin);
		
		vertexQueue.enqueue(originVertex);
		
		while(!vertexQueue.isEmpty())
		{
			VertexInterface<T> frontVertex = vertexQueue.dequeue();
			java.util.Iterator<Edge> neighbors = frontVertex.getNeighborIterator();
		
			while(neighbors.hasNext())
			{
				VertexInterface<T> nextNeighbor = (VertexInterface<T>) neighbors.next();
				
				if(!nextNeighbor.isVisited())
				{
					nextNeighbor.visit();
					traversalOrder.enqueue(nextNeighbor.getLabel());
					vertexQueue.enqueue(nextNeighbor);
				}
			}
			
		
		}
		
		return traversalOrder;
		 
	}
	
	public queueInterface<T> getDepthFirstTraversal(T origin, Vertex[] vertices, int vertSize)
	{
		queueInterface<T> traversalOrder = new queue<T>();
		stackInterface<T> vertexStack = new stack<T>();
		
		VertexInterface<T> originVertex = new Vertex(null);
		for(int i= 0; i < vertSize; i++)
		{
			if(vertices[i].getLabel() == origin)
			{
				 originVertex = vertices[i];
			}
		}
		
		originVertex.visit();
		traversalOrder.enqueue(origin);
		
		vertexStack.push(origin);
		
		while(!vertexStack.isEmpty())
		{
			VertexInterface <T> topVertex = new Vertex (vertexStack.peek());
			
			if(topVertex.getUnvisitedNeighbor() != null)
			{
				VertexInterface <T> nextNeighbor = topVertex.getUnvisitedNeighbor();
				nextNeighbor.visit();
				traversalOrder.enqueue(nextNeighbor.getLabel());
				vertexStack.push(nextNeighbor.getLabel());
			}
			
			else
			{
				vertexStack.pop();
			}
		}
		
		return traversalOrder;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName;
        System.out.println("Type the name of the file");
        Scanner nameOfFile = new Scanner(System.in);
        Scanner inputStream = null;
        Scanner input = new Scanner(System.in);
        fileName = nameOfFile.nextLine();
        
        int vertListTrack = 0;
		Vertex vertList[] = new Vertex[10];
		for(int i = 0; i < 10; i ++)
		{
			vertList[i] = new Vertex<Character>(null);
		}
        
	       try
	       {
	           inputStream = new Scanner(new File(fileName));
	       }
	      catch(FileNotFoundException e)
	       {
	           System.out.println("Error opening the file " + 
	                               fileName);
	           System.exit(0);
	       }
		   
	       while (inputStream.hasNext())
	       {
	    	   String vertex = inputStream.nextLine();
	    	   for(int i = 0; i < vertex.length(); i ++)
	    	   {
	    		   if(i == 0)
	    		   {
	    			   vertList[vertListTrack].setLabel(new Character(vertex.charAt(i)));
	    		   }
	    		   
	    		   else
	    		   {
	    			   vertList[vertListTrack].addToAjacencyList(new Character(vertex.charAt(i)));
	    		   }
	    		   
	    		   vertListTrack++;
	    	   }   	
	    	   
	       }
	       inputStream.close();
		
	       System.out.println("Here is the solution through the maze:");
	     // getDepthFirstTraversal(vertList[0].getLabel(), vertList, 10);
	      
	      System.out.println("Here is the quickest path through the maze:");
	     // getBreadthFirstTraversal(vertList[0].getLabel(), vertList, 10);


	}

}
