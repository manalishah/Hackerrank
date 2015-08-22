/*
Problem Statement

There are N plants in a garden. Each of these plants has been added with some amount of pesticide. After each day, if any plant has more pesticide than the plant at its left, being weaker than the left one, it dies. You are given the initial values of the pesticide in each plant. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.

Input Format

The input consists of an integer N. The next line consists of N integers describing the array P where P[i] denotes the amount of pesticide in plant i.

Constraints 
1≤N≤100000 
0≤P[i]≤109
Output Format

Output a single value equal to the number of days after which no plants die.

Sample Input

7
6 5 8 4 7 10 9
Sample Output

2
Explanation

Initially all plants are alive. 
Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)} 
Plants[k] = (i,j) => jth plant has pesticide amount = i. 
After the 1st day, 4 plants remain as plants 3, 5, and 6 die. 
Plants = {(6,1), (5,2), (4,4), (9,7)} 
After the 2nd day, 3 plants survive as plant 7 dies. Plants = {(6,1), (5,2), (4,4)} 
After the 3rd day, 3 plants survive and no more plants die. 
Plants = {(6,1), (5,2), (4,4)} 
After the 2nd day the plants stop dying.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PoisonousPlants {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> list = new ArrayList<Long>();
        ArrayList<Integer> rlist;
        for(int i = 0; i<n; i++){
            list.add(sc.nextLong());
        }
        int flag = 0;
        int count = 0;
        int j = 1;
        int index = 1;
        int indexset = 0;
        int breakflag = 0;
        while(j == 1){
            flag = 1;
            rlist = new ArrayList<Integer>();
            
            //for(int i = 0; i<list.size(); i++){
            //    System.out.print("(" + list.get(i) + ","+(i+1)+") ") ;
            //}
            //System.out.println("");
            
            for(int i = index; i < list.size();  i++){
                if(list.get(i) > list.get(i-1)){
                    rlist.add(i);   
                    flag = 0;
                    if(indexset == 0){
                    index = i;
                        indexset = 1;
                    }
                    
                }
                
                if(breakflag == 1){
                    break;
                }
            }
            
            if(rlist.size() == 1){
                breakflag = 1;
            }
            else{
                breakflag = 0;
            }
            indexset = 0;
            //System.out.println("rlist:" + rlist.size());
            for(int i = 0; i<rlist.size(); i++){
                //System.out.print(rlist.get(i) +1 +  " ");
                int x = rlist.get(i)-i;
                list.remove(x);
            }
            
            //System.out.println("list:" + list.size());
            
            if(rlist.size() == 0){
            //    System.out.println("it broke here");
                break;
            }
            count++;
            if(flag == 1 || list.size() == 1){
              //  System.out.println("it broke");
                break;
            }
            
            
        }
        System.out.println(count);
        
    }
}