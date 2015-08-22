/*
Problem Statement

Sid is obsessed with reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books. He chooses strings S1 and S2 in such a way that |len(S1)−len(S2)|≤1.

Your task is to help him find the minimum number of characters of the first string he needs to change to enable him to make it an anagram of the second string.

Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.

Input Format 
The first line will contain an integer, T, representing the number of test cases. Each test case will contain a string having length len(S1)+len(S2), which will be concatenation of both the strings described above in the problem.The given string will contain only characters from a to z.

Output Format 
An integer corresponding to each test case is printed in a different line, i.e. the number of changes required for each test case. Print −1 if it is not possible.

Constraints

1≤T≤100 
1≤len(S1)+len(S2)≤104
*/
import java.io.*;

public class Anagram {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int alpha1[] = new int[26];
        int alpha2[] = new int[26];
        char s1[];
        char s2[];
        
        while(t-->0){
            char s[] = br.readLine().toCharArray();
            int n = s.length;
            if(n % 2 == 0){
                int i = 0;
                while(i<n/2){
                    alpha1[(int)s[i] - 97] += 1;
                    i++;
                }
                int j = n/2;
                while(j<n){
                    alpha2[(int)s[j] - 97] += 1;
                    j++;
                }
                
                
               

                i = 0;
                int count = 0;
                
                while(i<alpha2.length){
                    if(alpha2[i] > 0 && alpha2[i] >= alpha1[i]){
                        count += alpha2[i] - alpha1[i];
                    }
                    alpha1[i] = 0;
                    alpha2[i] = 0;                    
                    i++;
                }
                
                System.out.println(count);
            }
            else{
                System.out.println("-1");
            }
        }
        
    }
}