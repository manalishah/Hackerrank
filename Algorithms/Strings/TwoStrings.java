/*
Problem Statement

You are given two strings, A and B. Find if there is a substring that appears in both A and B.

Input Format

Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.

Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.

Output Format

For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.

Constraints

All the strings contain only lowercase Latin letters.
1<=T<=10
1<=|A|,|B|<=105
Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

For the 1st test case, the letter o is common between both strings, hence the answer YES. 
For the 2nd test case, hi and world do not have a common substring, hence the answer NO.
*/

package algo.treesgraphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TwoStrings {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t = Integer.parseInt(br.readLine());
	        HashSet<Character> h1 = new HashSet<Character>();
	        HashSet<Character> h2 = new HashSet<Character>();
	        while(t-->0){
	            h1.clear();
	            h2.clear();
	            char a[] = br.readLine().toCharArray();
	            char b[] = br.readLine().toCharArray();
	            if(a.length<b.length){
	                char temp[] = a;
	                a = b;
	                b = temp;
	            }
	            int i = 0;
	            int flag = 0;
	                
	                
	            while(i<a.length){
	                if(!h2.contains(a[i])){
	                    h1.add(a[i]);
	                }
	                else{
	                    flag = 1;
	                    break;
	                }
	                
	                if(i<b.length){
	                    if(!h1.contains(b[i])){
	                        h2.add(b[i]);
	                    }
	                    else{
	                        flag = 1;
	                        break;
	                    }
	                }
	                i++;
	                
	            }
	            
	            if(flag == 1){
	                System.out.println("YES");
	            }
	            else{
	                System.out.println("NO");
	            }
	           
	            
	        }

	}

}
