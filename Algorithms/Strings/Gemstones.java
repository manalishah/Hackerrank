/*

Problem Statement

John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.

Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format

The first line consists of an integer, N, the number of rocks. 
Each of the next N lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.

Constraints 
1≤N≤100 
Each composition consists of only lower-case Latin letters ('a'-'z'). 
1≤ length of each composition ≤100
Output Format

Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Sample Input

3
abcdde
baccd
eeabg
Sample Output

2
Explanation

Only "a" and "b" are the two kinds of gem-elements, since these are the only characters that occur in every rock's composition.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Gemstones {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        boolean gem[] = new boolean[26];
        String rock[] = new String[t];
        int j,i = 0;
        while(t!=0){
            rock[i] = sc.next();
            t--;
            i++;
        }
        int flag;
        for(i = 0; i<26; i++){
            flag = 0; 
            for(j=0; j<rock.length; j++){
                if(!rock[j].contains(""+(char)(i+97))){
                    flag = 1;
                }
            }
            if(flag == 0){
                gem[i] = true;
            }
            
           
        }
        
        
        int ans = 0;
        i = 0;
        while(i<26){
            if(gem[i]){
                ans++;
            }
            i++;
        }
        System.out.println(ans);
        
    }
}