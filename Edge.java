
public class Edge<T> implements java.io.Serializable{

  private VertexInterface vertex;
	private double weight;
	
	public Edge(VertexInterface endVertex, double edgeWeight)
	{
		vertex = endVertex;
		weight = edgeWeight;
	}
	
	protected VertexInterface getEndVertex()
	{
		return vertex;
	}
	
	protected double getWeight()
	{
		return weight;
	}
	
}
