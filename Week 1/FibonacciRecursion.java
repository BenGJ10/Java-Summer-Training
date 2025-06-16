import java.util.Scanner;

public class FibonacciRecursion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i = 1; i <= num; i++){
            System.out.print(fibonacci(i) + " ");
        }
        sc.close();
    }

    public static int fibonacci(int num){
        if(num <= 1){
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
