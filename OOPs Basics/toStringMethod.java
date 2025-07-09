
public class toStringMethod {
    private String name;
    private int age;

    public toStringMethod(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "My name is " + name + ". I am " + age + " years old.";
    }

    public static void main(String[] args) {
        toStringMethod person1 = new toStringMethod("Ben Gregory", 19);
        System.out.println(person1); 
    }
}