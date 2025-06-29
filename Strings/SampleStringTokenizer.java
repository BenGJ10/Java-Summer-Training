import java.util.StringTokenizer;

public class SampleStringTokenizer {
    public static void main(String args[]){
        System.out.println("Example 1: Default delimeter (Whitespace)");
        String sentence1 = "Lionel Messi is the best player in the world";
        StringTokenizer st1 = new StringTokenizer(sentence1);   // Default is whitespace

        System.out.println("Original String: \"" + sentence1 + "\""); // Escape sequence
        System.out.println("Number of tokens initially: " + st1.countTokens());
        while(st1.hasMoreTokens()){
            System.out.println("Token: " + st1.nextToken());
        }
        System.out.println("Number of tokens after processing: " + st1.countTokens());

        
        System.out.println("\nExample 2: Custom delimeter (Comma)");
        String sentence2 = "Messi, Ronaldo, Neymar, Yamal, Pedri";
        StringTokenizer st2 = new StringTokenizer(sentence2, ",");
        
        System.out.println("Original String: \"" + sentence2 + "\""); 
        System.out.println("Number of tokens initially: " + st2.countTokens());
        while(st2.hasMoreTokens()){
            System.out.println("Token: " + st2.nextToken());
        }

        
        System.out.println("\nExample 3: Multiple Custom delimeters");
        String sentence3 = "Java is great, isn't it. Let's learn more.";
        StringTokenizer st3 = new StringTokenizer(sentence3, " ,.");

        System.out.println("Original String: \"" + sentence3 + "\""); 
        System.out.println("Number of tokens initially: " + st3.countTokens());
        while(st3.hasMoreTokens()){
            System.out.println("Token: " + st3.nextToken());
        }

        
        System.out.println("\nExample 4: Returning delimeters as tokens");
        String code = "int num = 10";
        StringTokenizer st4 = new StringTokenizer(code, " =", true);

        System.out.println("Original String: \"" + code + "\"");
        System.out.println("Number of tokens initially: " + st4.countTokens());

        while(st4.hasMoreTokens()){
            System.out.println("Token: " + st4.nextToken());
        }
    }    
}
