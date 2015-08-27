/*
Problem Statement

Given a graph consisting N nodes (labelled 1 to N) where a specific given node S represents the starting position S and an edge between two nodes is of a given length, which may or may not be equal to other lengths in the graph.

It is required to calculate the shortest distance from the start position (Node S) to all of the other nodes in the graph.

Note 1: If a node is unreachable , the distance is assumed as −1.

Input Format

The first line contains T, denoting the number of test cases. 
First line of each test case has two integers N, denoting the number of nodes in the graph and M, denoting the number of edges in the graph.

The next M lines each consist of three space separated integers x y r, where x and y denote the two nodes between which the undirected edge exists, r denotes the length of edge between these corrresponding nodes.

The last line has an integer S, denoting the starting position.

Constraints 
1≤T≤10 
2≤N≤3000 
1≤M≤N×(N−1))2 
1≤x,y,S≤N 
1≤r≤350

If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

Output Format

For each of the T test cases, print a single line consisting N−1 space separated integers denoting the shortest distance of N−1 nodes from starting position S.

For unreachable nodes, print −1.

Sample Input

1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1
Sample Output

24 3 15
Explanation

The graph given in the test case is shown as :

Graph
										B
									   /
									  S--D
									   \/
									   C
									   
The straight line is a weighted edge, denoting length of edge between the corresponding nodes.
The nodes S,B,C and D denote the obvious node 1,2,3 and 4 in the test case.
The shortest paths followed for the three nodes B,C and D are as follows :

S->B - Shortest Path Value : 24

S->C - Shortest Path Value : 3

S->C->D - Shortest Path Value : 15
*/



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Dijkstras{

    private  Map<Integer, List<Node>> Adjacency_List;
    
    
    /* Initializes the map to with size equal to number of nodes in a graph  */
    public Dijkstras(int vertices)
    {
        Adjacency_List = new HashMap<Integer, List<Node>>();
        for (int i = 1 ; i <= vertices ; i++)
        {
            /* Maps every vertex to a List Object to store its neighbours */
            Adjacency_List.put(i, new LinkedList<Node>());
        }
    }

      public static void main(String m[])
    {
        int source , destination;
        int e,v,t,d;
        int count;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        
        while(t-->0){
            /* Read the number of vertices and edges in graph */
            count = 1;
            v = sc.nextInt();
            e = sc.nextInt();
            
            Dijkstras adjacencyList = new Dijkstras(v);
 
             /* Reads the edges present in the graph */
            while (count <= e)
            {
                source = sc.nextInt();
                destination = sc.nextInt();
                d = sc.nextInt();
                adjacencyList.setEdge(source, destination, d);
                count++;
            }
            
            /* Reads the root node */
            int root = sc.nextInt();
         
           
            
            /* Shortest path distance */
            int distance[] = adjacencyList.BFS(root);
            
            for(int i = 1; i<=v; i++){
            	if(i!=root){
                    
                    if(distance[i] < 0){
            		  System.out.print(-1 + " ");
            	    }
                    else{
            		  System.out.print(distance[i] + " ");
                    }
            	}
            }
            System.out.println("");
        }
        sc.close();
    }

    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setEdge(int source , int destination, int d)
    {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size())
        {
            /* System.out.println("the vertex entered in not present "); */
            return;
        }
        List<Node> slist = Adjacency_List.get(source);
        Node dest = new Node(destination, d);
        slist.add(dest);
        
        List<Node> dlist = Adjacency_List.get(destination);
        Node s = new Node(source, d);
        dlist.add(s);
    }

    
    public int[] BFS(int x){
    	int V = Adjacency_List.size();
    	int distance[] = new int[V+1];
    	Arrays.fill(distance,Integer.MAX_VALUE);
    	distance[x] = 0;
        Set<Integer> S = new HashSet<Integer>();
        /* Nodes unreachable have distance = Integer.MAX_VALUE */
    	Queue<Node> q = new PriorityQueue<Node>(1, compareByDistance);
    	Map<Integer, Node> m = new HashMap<Integer,Node>();
    	Node source;
    	for(int i = 1; i<=V; i++){
    		if(i != x){
    		source = new Node(i, Integer.MAX_VALUE);
    		m.put(i, source);
    		q.add(source);
    		}
    		else{
    			source = new Node (x,0);
    			m.put(i, source);
    	    	q.add(source);
    		}
    	}
    	

    	while(S.size() != V){
    		source = q.poll();
    		int u = source.name;
    		S.add(u);
    		List<Node> Adj = Adjacency_List.get(u);
    		Iterator<Node> it = Adj.iterator();
    		while(it.hasNext()){
    			Node dest = it.next();
    			Node realDest = m.get(dest.name);
    			if(distance[realDest.name] >= distance[u] + dest.dist ){
    				distance[realDest.name] = distance[u] + dest.dist;
    				q.remove(realDest);
    				realDest.dist = distance[realDest.name];
    				q.add(realDest);
    				
    			}
    			
    		}
    		
    			
    	}
       
    	
		return distance; 	
    	
    }
    
    public static Comparator<Node> compareByDistance = new Comparator<Node>(){

        public int compare(Node one, Node two) {
            return (int)one.dist - (int)two.dist;
        }
          
    };
    
    public int edgeCost(int s, int d){
    	int cost = 0;
    	List<Node> neighbours = Adjacency_List.get(s);
    	Node dest = neighbours.get(d);
    	cost = dest.dist;
    	
		return cost;
    	
    }
    
    public class Node{
        int name;
        int dist;
        
        Node(int a, int b){
            name = a;
            dist = b;
        }
    }
    
 
  
}
