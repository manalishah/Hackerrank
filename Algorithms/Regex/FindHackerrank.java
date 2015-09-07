/*
Problem Statement

At HackerRank, we always want to find out how popular we are getting every day and have scraped conversations from popular sites. Each conversation fits in 1 line and there are N such conversations. Each conversation has at most 1 word that says hackerrank (all in lowercase). We would like you to help us figure out whether a conversation:

Starts with hackerrank
Ends with hackerrank
Start and ends with hackerrank
Input Format

First line of the input contains an integer, N. Then N lines follow. 
From the second line onwards, each line contains a set of W words separated by a single space

Constraints

1 <= N <= 10
1 <= W <= 100
All the characters in W are lowercase alphabet characters.
If C is the count of the characters in W, then 1 <= C <= 20
Output Format

For every line,

Print 1 if the conversation starts with hackerrank
Print 2 if the conversation ends with hackerrank
Print 0 if the conversation starts and ends with hackerrank
Print -1 if none of the above.
Sample Input

4
i love hackerrank
hackerrank is an awesome place for programmers
hackerrank
i think hackerrank is a great place to hangout
Sample Output

2
1
0
-1
Explanation

The first conversation ends with hackerrank and hence 2 
The second conversation starts with hackerrank and hence 1 
The third conversation has only one word, it starts and ends with hackerrank and hence 0. 
The fourth conversation satisfies none of the above properties and hence -1.


*/

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FindHackerrank {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Pattern p = Pattern.compile("(^hackerrank$)|(^hackerrank.+hackerrank$)|(^hackerrank.+)|(.+hackerrank$)");
        
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String s = br.readLine();
            Matcher m = p.matcher(s);
            if(m.matches())
            {
                if(m.group(1) != null || m.group(2) != null){
                    System.out.println(0);
                }
                else if(m.group(3) != null){
                    System.out.println(1);
                }
                else if(m.group(4) != null){
                    System.out.println(2);
                }
            }
            else{
                System.out.println(-1);
            }
        }
    }
}