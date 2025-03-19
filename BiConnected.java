import java.util.*;
class BiConnected
{
	static class Graph
	{
		int v;
		List<List<Integer>> adjList;
		Graph(int v)
		{
			this.v=v;
			adjList=new ArrayList<>();
			for(int i=0;i<v;i++)
			{
				adjList.add(new ArrayList<>());
			}
		}
		void addEdge(int u,int v)
		{
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		void Bccutil(int u,int disc[],int low[],boolean[] visited,Stack<Integer> stack,int parent)
		{
			visited[u]=true;
			disc[u]=low[u]=++time;
			int children=0;
			for(Integer v:adjList.get(u))
			{
				if(!visited[v])
				{
					stack.push(u);
					Bccutil(v,disc,low,visited,stack,u);
					low[u]=Math.min(low[u],low[v]);
					if ((parent == -1 && children > 1) || (parent != -1 && low[v] >= disc[u]))
					{
						printBcc(stack);
					}
					children++;
				}
				else if(v!=parent)
				{
					low[u]=Math.min(low[u],disc[v]);
					stack.push(u);
				}
			}
		}
		void printBcc(Stack<Integer> stack)
		{
			while(!stack.isEmpty())
			{
				int edge=stack.pop();
				System.out.println(edge + " ");
			}
			System.out.println();
		}
		void Bcc()
		{
			int[] disc=new int[v];
			int[] low=new int[v];
			boolean[] visited=new boolean[v];
			Stack<Integer> stack=new Stack<>();
			Arrays.fill(disc,-1);
			Arrays.fill(low,-1);
			for(int i=0;i<v;i++)
			{
				if(!visited[i])
				{
					Bccutil(i,disc,low,visited,stack,-1);
				}
			}
		}
	}
	static int time = 0;
	public static void main(String[]args)
	{
		Graph g=new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(3,4);
		System.out.println("Biconnected components:");
		g.Bcc();
	}
}
output:
Biconnected components:
3 
1 
2 
1 
0 

