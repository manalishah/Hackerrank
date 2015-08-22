/8
Problem Statement

Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence s, tell Roy if it is a pangram or not.

Input Format Input consists of a line containing s.

Constraints 
Length of s can be at most 103 (1≤|s|≤103) and it may contain spaces, lower case and upper case letters. Lower case and upper case instances of a letter are considered the same.

Output Format Output a line containing pangram if s is a pangram, otherwise output not pangram.

Sample Input #1

We promptly judged antique ivory buckles for the next prize    
Sample Output #1

pangram
Sample Input #2

We promptly judged antique ivory buckles for the prize    
Sample Output #2

not pangram
Explanation 
In the first test case, the answer is pangram because the sentence contains all the letters of the English alphabet.


*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pangrams {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toLowerCase();
        String pangram = "thequickbrownfoxjumpsoverthelazydog";
        String pU = pangram.toUpperCase();
        int flag = 0;
        for(int i = 0; i<pangram.length(); i++){
            if(!s.contains(pangram.charAt(i)+"") ){
                flag = 1; 
                break;
            }
        }
        if(flag == 0){
            System.out.println("pangram");
        }
        else{
            System.out.println("not pangram");
        }
    }
}