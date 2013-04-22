import java.util.Iterator;


public class Vertex<T> implements VertexInterface, java.io.Serializable {
  
	private T label;
	private ListWithIteratorInterface<Edge> edgelist;
	private boolean visited;
	private VertexInterface previousVertex;
	private double cost;
	private VertexInterface[] adjacencyList;
	
	public Vertex(T vertexLabel)
	{
		label = vertexLabel;
		edgelist = new LinkedListWithIterator<Edge>();
		visited = false;
		previousVertex = null;
		cost = 0;
		adjacencyList = new Vertex[10];
		
		for(int i = 0; i < 10; i ++)
		{
			adjacencyList[i] = new Vertex(null);
		}
	}

	@Override
	public void visit() {
		
		visited = true;
	}

	@Override
	public void unvisit() {
		// TODO Auto-generated method stub
		visited = false;
		
	}
	
	public void addToAjacencyList(T vertexLabel)
	{
		int i = 0;
		while(adjacencyList[i].getLabel() != null)
		{
			i++;
		}
		((Vertex) adjacencyList[i]).setLabel(vertexLabel);
	}
	
	public void setLabel(T vertexLabel)
	{
		label = vertexLabel;
	}

	@Override
	public boolean isVisited() {
		// TODO Auto-generated method stub
		if(visited == true)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean connect(VertexInterface endVertex, double edgeWeight) {
		// TODO Auto-generated method stub
		
		Edge newEdge = new Edge(endVertex, edgeWeight);
		edgelist.add(newEdge);	
		return false;
	}

	@Override
	public boolean connect(VertexInterface endVertex) {
		// TODO Auto-generated method stub
		Edge newEdge = new Edge(endVertex, 0);
		edgelist.add(newEdge);
		return false;
	}

	@Override
	public Object getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public VertexInterface getPredecessor() {
		// TODO Auto-generated method stub
		return previousVertex;
	}

	@Override
	public java.util.Iterator<Edge> getNeighborIterator() {
		// TODO Auto-generated method stub
		java.util.Iterator<Edge> neighborIt = edgelist.getIterator();
		
		return neighborIt;
		
	}

	@Override
	public java.util.Iterator<Edge> getWeightIterator() {
		// TODO Auto-generated method stub
		java.util.Iterator<Edge> neighborIt = edgelist.getIterator();
		return neighborIt;
	}

	@Override
	public VertexInterface getUnvisitedNeighbor() {
		// TODO Auto-generated method stub
		Edge newEdge = new Edge(null, 0);
		newEdge = edgelist.getEntry(0);
		while(newEdge.getEndVertex().isVisited() == true)
		{
			newEdge = edgelist.getIterator().next();
		}
		
		return newEdge.getEndVertex();
	}

	@Override
	public void setCost(double newCost) {
		// TODO Auto-generated method stub
		cost = newCost;
		
	}

	@Override
	public void setPredecessor(VertexInterface predecessor) {
		// TODO Auto-generated method stub
		previousVertex = predecessor;
		
	}

	@Override
	public boolean hasNeighbor() {
		// TODO Auto-generated method stub
		if(edgelist.isEmpty() == true)
		{
		return false;
		}
		
		return true;
	}

	@Override
	public boolean hasPredecessor() {
		// TODO Auto-generated method stub
		if(previousVertex != null)
		{
			return true;
		}
		return false;
	}
	


}




// and done
