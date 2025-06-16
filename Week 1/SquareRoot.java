import java.util.Scanner;

public class SquareRoot {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Square root of " + num + " is " + sqrt(num));
        sc.close();
    }
    
    public static int sqrt(int n){
        int i = 0;
        while(i * i <= n){
            if(i * i == n)  return i;
            i++;
        }
        return i - 1;
    }
}

/*  If n = 1,000,000
    Then the loop runs up to i = 1000
    Total iterations ≈ √1,000,000 = 1000 → T.C will be O(√n) 
    This is the bruteforce method for finding the squareroot of a number.
*/
