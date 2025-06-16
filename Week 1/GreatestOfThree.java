import java.util.Scanner;

class GreatestOfThree{

    public static int greatestOfThree(int num1, int num2, int num3){
        return (num1 > num2 && num1 > num3) ? num1 : (num2 > num3) ? num2 : num3;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        
        int greatest = greatestOfThree(num1, num2, num3);
        
        System.out.println("The greatest of three numbers: " + greatest);

        scanner.close();
    }
}