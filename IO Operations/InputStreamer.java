import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputStreamer{
    public static void main(String[] args) throws IOException{  // or we can use a try-catch method
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int age;
        String name;
        
        System.out.println("Enter your name :");
        name = br.readLine();
        
        System.out.println("Enter your age :");
        age = Integer.parseInt(br.readLine());
        
        if(age >= 18)
            System.out.println(name + ", you are eligible to vote!");
        else
            System.out.println(name + ", sorry you are not eligible to vote!");
    }
}
