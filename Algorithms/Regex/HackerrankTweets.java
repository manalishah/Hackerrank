/*
Problem Statement

Increasing popularity of hackerrank can be seen in tweets like

I love #hackerrank
I just scored 27 points in the Picking Cards challenge on #HackerRank
I just signed up for summer cup @hackerrank
Given a set of most popular tweets, your task is to find out how many of those tweets has the string hackerrank in it.

Input Format

First line is an integer N. N lines follow. Each line is a valid tweet.

Constraints

1 <= N <= 10 
Each character of the tweet is a valid ASCII character.

Output format

Print the total number of tweets that has hackerrank (case insensitive) in it

Sample Input

4
I love #hackerrank
I just scored 27 points in the Picking Cards challenge on #HackerRank
I just signed up for summer cup @hackerrank
interesting talk by hari, co-founder of hackerrank
Sample Output

4
Explanation

All the 4 lines have the string hackerrank in them and thus 4.
*/

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HackerrankTweets {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        Pattern p = Pattern.compile(".*[ ]*\\W*((?i)hackerrank(?-i))[ ]*.*");
        int count = 0;
        while(t-- >0){
            String s = br.readLine();
            Matcher m = p.matcher(s);
            if(m.matches()){
                count++;
            }
                
        }
        System.out.println(count);

    }
}