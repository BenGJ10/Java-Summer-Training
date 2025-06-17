public class StringMethods {
    public static void main(String args[]){
        String str1 = "Java is very powerful";
        String str2 = "Python is easy";

        System.out.println("Length of str1 is: " + str1.length());
        System.out.println("Substring method: " + str1.substring(5));
        System.out.println("Usage of trim() method: " + str1.replace("Java", "    ").trim());

        System.out.println("Character at index 9 is: " + str1.charAt(9));
        System.out.println("Comparing str1 and str2: " + str1.compareTo(str2));
        System.out.println("First and last index of chracter e in str1: " + str1.indexOf('e') + ", " + str1.lastIndexOf('e'));

        System.out.println("Uppercase method: " + str1.toUpperCase());
        System.out.println("Lowercase method: " + str1.toLowerCase());
        System.out.println("Do we have the word Java in str2: " + str2.contains("Java"));
        System.out.println("Is the string empty? " + str2.isEmpty());

        System.out.println("Take out the word Java from str1: " + str1.substring(0, 4));
        System.out.println(str2.replace("Python", "Java"));
        System.out.println("Concatenating both strings: " + str1.concat(str2));
    }
}
