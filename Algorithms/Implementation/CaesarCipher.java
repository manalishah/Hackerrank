/*
Problem Statement

Julius Caesar protected his confidential information from his enemies by encrypting it. Caesar rotated every letter in the string by a fixed number K. This made the string unreadable by the enemy. You are given a string S and the number K. Encrypt the string and print the encrypted string.

For example: 
If the string is middle-Outz and K=2, the encoded string is okffng-Qwvb. Note that only the letters are encrypted while symbols like - are untouched. 
'm' becomes 'o' when letters are rotated twice, 
'i' becomes 'k', 
'-' remains the same because only letters are encoded, 
'z' becomes 'b' when rotated twice.

Input Format

Input consists of an integer N equal to the length of the string, followed by the string S and an integer K.

Constraints 
1≤N≤100 
0≤K≤100 
S is a valid ASCII string and doesn't contain any spaces.

Output Format

For each test case, print the encoded string.

Sample Input

11
middle-Outz
2
Sample Output

okffng-Qwvb

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CaesarCipher {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char m[] = sc.next().toCharArray();
        int k = sc.nextInt();
        
        for(char x:m){
            
            if(Character.isLowerCase(x)){
                x = (char)(((int)x - 97 + k)%26 + 97);
                System.out.print(x);
            }
            else if( Character.isUpperCase(x)){
                x = (char)(((int)x - 65 + k)%26 + 65);
                System.out.print(x);
            }
            else{
                System.out.print(x);
            }
        }
        
    }
}