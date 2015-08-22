/*

Problem Statement

Time is running out. You have a final match to play as a counter terrorist. You have N players each having a distinct ID from 1 to N. You have to choose some players on your team from these N players such that no two chosen players have consecutive numbers (as they tend to kill each other). Also you definitely have to choose some K players whose numbers are given. They are the snipers. Find the maximum number of players that you can choose.

Input Format

The first line contains 2 space-separated integers, N and K, where N is the total number of players and K is the number of players that have to be definitely in the team (the snipers). 
The second line contains K space-separated integers that are the IDs of the snipers.

NOTE: There are no two snipers with consecutive numbers.

Constraints 
2≤N≤2×106 
1≤K≤N/2 
1≤ ID of each sniper ≤N
Output Format

You need to print the maximum number of players that you can have in your team.

Sample Input

8 2
6 2
Sample Output

4
Explanation

There are 8 players in total, among which you have to definitely choose players with ID 2 and 6. 
To maximize the number of players in the team, you will choose the players with IDs 4 and 8, so that you will have a total of 4 players.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Campers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long k_no[] = new long[(int)k];
        
        for(int i = 0; i<k; i++){
            k_no[i] = sc.nextLong();
        }
        Arrays.sort(k_no);
        
        int count = 0 ;
        long temp = 0;
        
        if(k_no[0] >2){
            temp = k_no[0] - 1;
            if(k_no[0] %2 == 0 ){
                count += (temp-1)/2;
            }
            else if(k_no[0] %2 != 0){
                count += (temp)/2;
            }
        }
        
        
        for(int i = 0; i < k-1; i++){
            
            temp = k_no[i+1] - k_no[i];
            
            
            if(k_no[i+1]%2!=0 && k_no[i]%2 != 0){
                count += (temp-1)/2;
                //System.out.println(count + " for both odd ");
                
            }
            else if((k_no[i+1]%2==0 && k_no[i]%2 != 0) || (k_no[i+1]%2!=0 && k_no[i]%2 == 0)){
                count += temp/2 - 1;
                //System.out.println(count + " for one odd ");
            }
            else if(k_no[i+1]%2==0 && k_no[i]%2 == 0){
                count += (temp-2)/2;
                //System.out.println(count + " for both even ");
            }       
        }
        
        long last = k_no[(int)k-1];
        temp = n - last;
        
        if(temp>2){
            count += temp/2;
            //System.out.println(count + " for between last ");
        }else if(temp == 2){       
            count++;
            //System.out.println(count + " for last");
        }
        
        System.out.println(count+k);
    }
}