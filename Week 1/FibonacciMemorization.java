/*
Fibonacci numbers using memorization technique. 
    T.C -> O(n)
Each Fibonacci number fibonacciMem(i) for i = 0 to num is computed at most once.
After computing fibonacciMem(i), the result is stored in memo[i].
Any repeated call just returns the cached value. 
*/


import java.util.Scanner;
public class FibonacciMemorization {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int memo[] = new int[num + 1]; 
        
        for(int i = 0; i <= num; i++){
            memo[i] = -1;
        }
        
        System.out.println("Fibonacci series up to " + num + ":");
        for(int i = 0; i <= num; i++){
            System.out.print(fibonacciMem(i, memo) + " ");
        }
        sc.close();
    }

    public static int fibonacciMem(int num, int[] memo){    
        if(num <= 1){
            return num;
        }

        if(memo[num] != -1){
            return memo[num];
        }

        memo[num] = fibonacciMem(num - 1, memo) + fibonacciMem(num - 2, memo);
        return memo[num];
    }
}
