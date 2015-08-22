/*
Problem Statement

Chinese Version
Russian Version

Alice recently started learning about cryptography and found that anagrams are very useful. Two strings are anagrams of each other if they have same character set and same length. For example strings "bacdc" and "dcbac" are anagrams, while strings "bacdc" and "dcbad" are not.

Alice decides on an encryption scheme involving 2 large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. She need your help in finding out this number.

Given two strings (they can be of same or different length) help her in finding out the minimum number of character deletions required to make two strings anagrams. Any characters can be deleted from any of the strings.

Input Format 
Two lines each containing a string.

Constraints 
1 <= Length of A,B <= 10000 
A and B will only consist of lowercase latin letter.

Output Format 
A single integer which is the number of character deletions.

Sample Input #00:

cde
abc
Sample Output #00:

4
Explanation #00: 
We need to delete 4 characters to make both strings anagram i.e. 'd' and 'e' from first string and 'b' and 'a' from second string.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MakeItAnagram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
            Scanner sc = new Scanner(System.in);
            StringBuilder a = new StringBuilder(sc.next());
            StringBuilder b = new StringBuilder(sc.next());
            StringBuilder c = new StringBuilder("");
            int x = a.length();
            int y = b.length();

            int flag = 0;
            int m = 0;
        
        StringBuilder temp = new StringBuilder( a);
            if(x<y){
                
                a = b;
                b = temp;
                x = a.length();
                y = b.length();
            }
        

            for(int i =0; i<a.length() && i<b.length(); i++){
                String z =  "" + (b.charAt(i));
                //System.out.println(b + " " + z);
                //System.out.println(a + " " + a.indexOf(z));
                
                
                if(a.indexOf(z) != -1){
                    a = a.deleteCharAt(a.indexOf(z));
                    b = b.deleteCharAt(i);
                    i--;
                    c.append(z);
                }
                else{
                    b = b.deleteCharAt(i);
                    i--;
                }
            }

            if(a.length() > b.length()){
               m =  a.length() - b.length();
               a = a.delete(m-1, a.length());
            }
            else{
               m =  b.length() - a.length();
               b = b.delete(m-1, b.length()); 
            }

            System.out.println(x + y - c.length() - c.length());

    }
}