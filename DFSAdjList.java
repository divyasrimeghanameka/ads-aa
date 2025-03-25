import java.util.*;
class DFSAdjList
{
	private int v;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public DFSAdjList(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<>();
	}
	public void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
	public void DFS(int start)
	{
	
		boolean[]visited=new boolean[v];
		Arrays.fill(visited,false);
		Stack<Integer> stack=new Stack<>();
		stack.push(start);
		visited[start]=true;
		while(!stack.isEmpty())
		{
			int vis=stack.pop();
			System.out.println(vis+" ");
			for(int neighbour:adj[vis])
				if(!visited[neighbour])
				{
					stack.push(neighbour);
					visited[neighbour]=true;
				}
		}
	}
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=scanner.nextInt();
		DFSAdjList graph=new DFSAdjList(v);
		System.out.println("Enter the number of edges:");
		int e=scanner.nextInt();
		System.out.println("Enter the edges(source and destination):");
		for(int i=0;i<e;i++)
		{
			int src=scanner.nextInt();
			int dest=scanner.nextInt();
			graph.addEdge(src,dest);
		}
		System.out.println("Enter starting vertex for DFS:");
		int start=scanner.nextInt();
		System.out.println("DFS traversal from vertex"+start+":");
		graph.DFS(start);
		scanner.close();
	}
}			


OUTPUT:
Enter number of vertices:
6
Enter the number of edges:
9
Enter the edges(source and destination):
0 1
0 2
0 3
0 4
1 3
2 3
2 4
2 5
2 5
Enter starting vertex for DFS:
1
DFS traversal from vertex1:
1 
3 
2 
5 
4 
0 
