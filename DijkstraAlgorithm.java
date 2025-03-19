import java.util.*;
public class DijkstraAlgorithm
{
    static final int INF=999;
    private static int chooseMinVertex(int[] dist,boolean[] s, int n)
    {
        int minIndex=-1,min=INF;
        for(int i=0;i<n;i++)
        {
            if(!s[i] && dist[i]<min)
            {
                min=dist[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    public static void shortestPaths(int v, int[][] cost, int[] dist, int n)
    {
        boolean[] s=new boolean[n];
        for(int i=0;i<n;i++)
            dist[i]=cost[v][i];
        s[v]=true;
        for(int num=1;num<n;num++)
        {
            int u=chooseMinVertex(dist, s, n);
            if(u==-1) break;
            s[u]=true;
            for(int w=0;w<n;w++)
            {
                if(!s[w] && dist[u]+cost[u][w]<dist[w])
                {
                    dist[w]=dist[u]+cost[u][w];
                }
            }
        }
    }
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of vertices:");
        int n=sc.nextInt();
        int[][] cost=new int[n][n];
        System.out.println("enter cost adjacency matrix:");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cost[i][j]=sc.nextInt();
        System.out.println("enter source vertex:");
        int source=sc.nextInt();
        int[] dist=new int[n];
        shortestPaths(source, cost, dist, n);
        System.out.println("Shortest distance from source "+source+":");
        for(int i=0;i<n;i++)
            System.out.println("vertex "+i+":"+(dist[i]==INF ? "INF" : dist[i]));
        sc.close();
    }
}
output:
enter cost adjacency matrix:
0
3
999
7
3
0
1
999
999
1
0
2
7
999
2
0
enter source vertex:
0
Shortest distance from source 0:
vertex 0:0
vertex 1:3
vertex 2:4
vertex 3:6
