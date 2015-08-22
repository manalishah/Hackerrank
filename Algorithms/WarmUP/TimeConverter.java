/*Problem Statement

You are given time in AM/PM format. Convert this into a 24 hour format.

Note Midnight is 12:00:00AM or 00:00:00 and 12 Noon is 12:00:00PM.

Input Format

Input consists of time in the AM/PM format i.e. hh:mm:ssAM or hh:mm:ssPM 
where 
01≤hh≤12 
00≤mm≤59 
00≤ss≤59

Output Format

You need to print the time in 24 hour format i.e. hh:mm:ss 
where 
00≤hh≤23 
00≤mm≤59 
00≤ss≤59

Sample Input

07:05:45PM
Sample Output

19:05:45

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeConverter.java {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        String type = time.substring(8);
        String hours = time.substring(0,2);
        String min = time.substring(3,5);
        String sec = time.substring(6,8);
        
        if(type.equals("PM")){
            if(hours.equals("12") && min.equals("00") && sec.equals("00")){
                System.out.println(time.substring(0,8));
                
            }
            else if(hours.equals("12")){
                System.out.println(time.substring(0,8));
            }
            else{
                int x = Integer.parseInt(hours);
                x += 12;
                time = x + time.substring(2,8);
                System.out.println(time);
            }
        }
        else{
            if(hours.equals("12") && min.equals("00") && sec.equals("00")){
                System.out.println("00:00:00");
                
            }
            else if( hours.equals("12")){
                System.out.println("00" + time.substring(2,8));
            }
            else{
                System.out.println(time.substring(0,8));
            }
        }
    }
}