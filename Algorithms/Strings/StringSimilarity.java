/*

Problem Statement

For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common to both strings. For example, the similarity of strings "abc" and "abd" is 2, while the similarity of strings "aaa" and "aaab" is 3.

Calculate the sum of similarities of a string S with each of it's suffixes.

Input: 
The first line contains the number of test cases T. Each of the next T lines contains a string each.

Output: 
Output T lines containing the answer for the corresponding test case.

Constraints: 
1 <= T <= 10 
The length of each string is at most 100000 and contains only lower case characters.

Sample Input:

2
ababaa  
aa
Sample Output:

11  
3
Explanation: 
For the first case, the suffixes of the string are "ababaa", "babaa", "abaa", "baa", "aa" and "a". The similarities of these strings with the string "ababaa" are 6,0,3,0,1, & 1 respectively. Thus, the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.

For the second case, the answer is 2 + 1 = 3.


*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StringSimilarity {
    /* Head ends here */
    static long stringSimilarity(String a) {

        long n = (int) a.trim().length();
		char s[] = a.toCharArray();
		long z[] = new long[(int) n];
		long total = 0;
		for (long i = 1, l = 0, r = 0; i < n; ++i) {
			
	        if (i <= r){
	            z[(int) i] = (r - i + 1)< (z[(int) (i - l)])?(r - i + 1): (z[(int) (i - l)]);
	        }
	        while (i + z[(int) i] < n && s[(int) z[(int) i]] == s[(int) (i + z[(int) i])]){
	            ++z[(int) i];
	        }
	        if (i + z[(int) i] - 1 > r){
	            l = i; r = i + z[(int) i] - 1;
	        }
	        total +=z[(int) i];
	    }
		total += n;
        return total;
    }
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        int _t_cases = Integer.parseInt(in.nextLine());
        for (int _t_i = 0; _t_i<_t_cases; _t_i++) {
            String _a = in.nextLine();
            result = stringSimilarity(_a);
            System.out.println(result);
        }
    }
}