/*

Problem Statement

Given the time in numerals we may convert it into words, as shown below:

5:005:015:105:305:405:455:475:28→ five o' clock→ one minute past five→ ten minutes past five→ half past five→ twenty minutes to six→ quarter to six→ thirteen minutes to six→ twenty eight minutes past five
Write a program which prints the time in words for the input given in the format mentioned above.

Input Format

There will be two lines of input:
H, representing the hours
M, representing the minutes

Constraints
1≤H≤12
0≤M<60
Output Format

Display the time in words.

Sample Input

5  
47  
Sample Output

thirteen minutes to six

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeInWords {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int hh = sc.nextInt();
        int mm = sc.nextInt();
        int flag = 0;
        if(mm>30){
            hh++;
            flag = 1;
        }
        Map<Integer,String> m = new HashMap<Integer, String>();
        m.put(0,"o' clock");
        m.put(1,"one");
        m.put(2,"two");
        m.put(3,"three");
        m.put(4,"four");
        m.put(5,"five");
        m.put(6,"six");
        m.put(7,"seven");
        m.put(8,"eigth");
        m.put(9,"nine");
        m.put(10, "ten");
        m.put(11,"eleven");
        m.put(12,"twelve");
        m.put(13,"thirteen");
        m.put(14,"fourteen");
        m.put(15,"quarter");
        m.put(16,"sixteen");
        m.put(17,"seventeen");
        m.put(18,"eighteen");
        m.put(19,"nineteen");
        m.put(20,"twenty");
        m.put(30,"half");
        m.put(40,"twenty"); 
        m.put(50,"ten");
       
        String x ="";
        if(flag == 0){
            
            
           
            if(mm>20 && mm<30 && mm!=15){
                int t = 10*(mm/10);
                int u = mm%10;
                x = m.get(t) + " " + m.get(u);
                
                x += " minutes past " + m.get(hh);
                System.out.println(x);
            }
            else if( mm == 0){
                x = m.get(hh) + " " + m.get(0);
                System.out.println(x);
            }
            else if (mm <10){
                int u = mm%10;
                
                if(mm>1){
                    x = m.get(u) + " minutes past " + m.get(hh);
                }
                else{
                    x = m.get(u) + " minute past " + m.get(hh);
                }
                System.out.println(x);
            }
            else{
                if(mm == 15 || mm == 30){
                    x = m.get(mm) + " past " + m.get(hh);
                }
                else{
                    x = m.get(mm) + " minutes past " + m.get(hh);
                }
                System.out.println(x);
            }
            
        }
        else{
            mm = 60 - mm;
            if(mm>20 && mm<30 && mm!=15){
                int t = 10*(mm/10);
                int u = mm%10;
                x = m.get(t) + " " + m.get(u);
                x += " minutes to " + m.get(hh);
                System.out.println(x);
            }
            else if (mm <10){
                int u = mm%10;
                if(mm > 1){
                    x = m.get(u) + " minutes to " + m.get(hh);
                }
                else{
                    x = m.get(u) + " minute to " + m.get(hh);
                }
                    
                System.out.println(x);
            }
            else{
                if(mm == 15 || mm == 30){
                    x = m.get(mm) + " to " + m.get(hh);
                }
                else{
                    x = m.get(mm) + " minutes to " + m.get(hh);
                }
                System.out.println(x);
            }
        }
        
        
        
        
        
        
    }
}

