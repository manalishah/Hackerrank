package abc.warmup;

import java.util.*;

public class SolveMeFirst {


    static int solveMeFirst(int a, int b) {
        return a+b;
   }

   
 public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        int a;
        a = inn.nextInt();
        int b;
        b = inn.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
        inn.close();
   }
}
