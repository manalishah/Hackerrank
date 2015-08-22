/*
Problem Statement

The median of a finite list of numbers can be found by arranging all the integers from lowest to highest value and picking the middle one. For example, the median of {3,3,5,9,11} is 5. If there is an even number of integers, then there is no single middle value, and the median is then usually defined to be the mean of the two middle values. For examples, the median of {3,5,7,9} is (5+7)2=6.

Given that integers are read from a data stream, find the median of elements read so far in an efficient way.

Input Format

The first line of input will contain integer N, i.e. the number of integers in the data stream.
Each of the next N lines will contain an integer ai.
Constraints 
1≤N≤105 
0≤ai≤105
Output Format

Print N integers, i.e. the median after each of the input. Report it with precision up to 10−1.

Sample Input

10
1
2
3
4
5
6
7
8
9
10
Sample Output

1.0
1.5
2.0
2.5
3.0
3.5
4.0
4.5
5.0
5.5
Explanation

See the sorted list after each input.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindMedian {

   private static Comparator<Integer> descending = new Comparator<Integer>() {
	
		@Override
		public int compare(Integer o1, Integer o2) {
		return (o2 - o1);
		}
	};

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, descending);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		//ArrayList<integer> myData = new ArrayList<integer>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//count of elements
		int count = 0;
		
		//get live input
		int input = sc.nextInt();
		
		//insert first element
		maxHeap.add(Integer.valueOf(input));
	
		
		System.out.println(maxHeap.peek());
	
		count++;
		n--;
		//enter more elems
		
		while(n>0) {
			//get live input
			input = sc.nextInt();
			
			//even
			if(count % 2 == 0) {
			
				if(input < minHeap.peek()) {
					maxHeap.add(input);
				} 
				else {
					maxHeap.add(minHeap.poll());
					minHeap.add(input);
				}
				
				count++;
				
				
				
				//calculate median
				System.out.println(maxHeap.peek());
			
			} 
			else {//odd
				maxHeap.add(Integer.valueOf(input));
				minHeap.add(maxHeap.poll());
				
				count++;
				
				
				//calculate median
				float median = (float) minHeap.peek() + ((float)(maxHeap.peek() - minHeap.peek()) / 2);
				System.out.println(median);
			
			}
		}
		
		
	}


}