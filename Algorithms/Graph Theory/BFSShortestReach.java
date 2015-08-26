/*
Problem Statement

Given an undirected graph consisting of N nodes (labelled 1 to N) where a specific given node S represents the start position and an edge between any two nodes is of length 6 units in the graph.

It is required to calculate the shortest distance from start position (Node S) to all of the other nodes in the graph.

Note 1: If a node is unreachable , the distance is assumed as −1. 
Note 2: The length of each edge in the graph is 6 units.

Input Format

The first line contains T, denoting the number of test cases. 
First line of each test case has two integers N, denoting the number of nodes in the graph and M, denoting the number of edges in the graph. 
The next M lines each consist of two space separated integers x y, where x and y denote the two nodes between which the edge exists. 
The last line has an integer S, denoting the starting position.

Constraints 
1≤T≤10 
2≤N≤1000 
1≤M≤N×(N−1)2 
1≤x,y,S≤N

Output Format

For each of T test cases, print a single line consisting of N−1 space separated integers, denoting the shortest distances of the N-1 nodes from starting position S.

For unreachable nodes, print −1.

Sample Input

1
4 2
1 2
1 3
1
Sample Output

6 6 -1
Explanation

The graph given in the test case is shown as :

Graph
                            S----B
                            |
                            |
                            C   D

S denotes the node 1 in the test case and B,C and D denote 2,3 and 4. Since S is the starting node and the shortest distances from it are (1 edge, 1 edge, Infinity) to the nodes B,C and D (2,3 and 4) respectively.

Node D is unreachable, hence -1 is printed (not Infinity).
*/



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestReach{

    private  Map<Integer, List<Integer>> Adjacency_List;
    
    
    /* Initializes the map to with size equal to number of nodes in a graph  */
    public BFSShortestReach(int vertices)
    {
        Adjacency_List = new HashMap<Integer, List<Integer>>();
        for (int i = 1 ; i <= vertices ; i++)
        {
            /* Maps every vertex to a List Object to store its neighbours */
            Adjacency_List.put(i, new LinkedList<Integer>());
        }
    }


    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setEdge(int source , int destination)
    {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size())
        {
            /* System.out.println("the vertex entered in not present "); */
            return;
        }
        List<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
        List<Integer> dlist = Adjacency_List.get(destination);
        dlist.add(source);
    }

    
    public int[] BFS(int x){
    	
        boolean visited[] = new boolean[Adjacency_List.size()];
    	int distance[] = new int[Adjacency_List.size()];
    	visited[x-1] = true;
        
        /* Nodes unreachable have distance = -1 */
    	Arrays.fill(distance, -1);
    	distance[x-1] = 0;
    	Queue<Integer> q = new ArrayDeque<Integer>();
    	q.offer(x);

        while(q.size()>0){
    		int v = q.poll();
    		List<Integer> neighbours = Adjacency_List.get(v);    	
    		Iterator<Integer> it = neighbours.iterator();
    		while(it.hasNext()){
    			int w = it.next();
    			if(!visited[w-1]){
    				visited[w-1] = true;
                    /* Distance of nodes from source = distance of parent from source + 1 */
    				distance[w-1] = distance[v-1] + 1; 
    				q.add(w);
    			}	
    		}	
    	}
		return distance; 	
    	
    }
    
 
    public static void main(String m[])
    {
        int source , destination;
        int e,v,t;
        int count;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        
        while(t-->0){
            /* Read the number of vertices and edges in graph */
            count = 1;
            v = sc.nextInt();
            e = sc.nextInt();
            BFSShortestReach adjacencyList = new BFSShortestReach(v);
 
             /* Reads the edges present in the graph */
            while (count <= e)
            {
                source = sc.nextInt();
                destination = sc.nextInt();
                adjacencyList.setEdge(source, destination);
                count++;
            }
            
            /* Reads the root node */
            int root = sc.nextInt();
         
           
            
            /* Shortest path distance */
            int distance[] = adjacencyList.BFS(root);
            
            for(int i = 0; i<v; i++){
            	if(i!=root-1){
                    
                    if(distance[i] == -1){
            		  System.out.print(-1 + " ");
            	    }
                    else{
            		  System.out.print(6*distance[i] + " ");
                    }
            	}
            }
            System.out.println("");
        }
        sc.close();
    }
}