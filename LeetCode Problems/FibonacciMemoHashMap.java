    // Solving the Fibonacci problem using HashMap and Memorization technique

    import java.util.Scanner;
    import java.util.HashMap;
    public class FibonacciMemoHashMap {
        
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            HashMap<Integer, Integer> memo = new HashMap<>();
            
            System.out.println("Fibonacci series up to " + num + ":");
            for (int i = 0; i <= num; i++) {
                System.out.print(fibonacciMem(i, memo) + " ");
            }
            sc.close();
        }

        public static int fibonacciMem(int num,  HashMap<Integer, Integer> memo ){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            if(num <= 1){
                return num;
            }
            if(hashMap.containsKey(num)){
                return hashMap.get(num);
            }
            int elem = fibonacciMem(num - 1, memo) + fibonacciMem(num - 2, memo);
            hashMap.put(num, elem);

            return elem;
        }
    }
