/*

Problem Statement

Given a string S, find the number of unordered anagramic pairs of substrings.

Input Format

First line contains T, the number of testcases. Each testcase consists of string S in one line.

Constraints 
1≤T≤10 
2≤length(S)≤100 
String S contains only the lowercase letters of the English alphabet.

Output Format

For each testcase, print the required answer in one line.

Sample Input

2
abba
abcd
Sample Output

4
0
Explanation

Let's say S[i,j] denotes the substring Si,Si+1,⋯,Sj.

testcase 1: 
For S=abba, anagramic pairs are: {S[1,1],S[4,4]}, {S[1,2],S[3,4]}, {S[2,2],S[3,3]} and {S[1,3],S[2,4]}.

testcase 2: 
No anagramic pairs.
*/


import java.io.*;
import java.util.*;

public class SherlockAndAnagrams {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            char s[] = br.readLine().toCharArray();
            int count = 0;
          //  StringBuilder sb = new Stringbuilder("");
            
            for(int m = 0; m<s.length-1; m++){
                for(int i = m,k=1; i<s.length-1; i++,k++){
                    int l = 1;
                    for(int j = i; j<s.length-1; j++,l++){
                        //System.out.println(m+ " " + k+ " & " + l + " " + k);
                        //System.out.println(new String(s,m,k) + " " + new String(s,l+m,k));
                        count+=findAnagrams(new String(s,m,k), new String(s,l+m,k));
                    }
                }
            }   
            System.out.println(count);
        }
    }
    
    public static int findAnagrams(String m1, String m2){
        int alpha[] = new int[26];
        //if(m1.equals(m2)){
          //  return 0;
        //}
        char m[] = m1.toCharArray();
        char n[] = m2.toCharArray();
        for(int i = 0; i<m.length; i++){
            alpha[(int)m[i] - 97]++;
            alpha[(int)n[i] - 97]--;
        }
        
        for(int i =0; i<26; i++){
            if(alpha[i] != 0){
                return 0;
            }
        }
        return 1;
    }
    
    //public static checkAnagram()
}