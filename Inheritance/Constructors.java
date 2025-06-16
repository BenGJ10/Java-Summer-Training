// Constructor is a special method having same name of the class.
// It has no return type, and is used to initialize the data members of the class.
// Constructors are never called, they are revoked.
// If we don't create a constructor by our own, then compiler will create a default empty constructor.

public class Constructors {
    int num1, num2;

    Constructors(){ // Default Constructor
        this.num1 = 10;
        this.num2 = 20;
    }

    Constructors(int x, int y){ // Parametrized Constructor
        this.num1 = x;
        this.num2 = y;
    }

    Constructors(Constructors obj){ // Copy Constructor -> used to copy contents of one constructor into another.
        this.num1 = obj.num1;
        this.num2 = obj.num2;
    }

    void display(){
        System.out.println("Number 1 is " + num1);
        System.out.println("Number 2 is " + num2);
    }

    public static void main(String args[]){
        Constructors c1 = new Constructors();
        c1.display();

        Constructors c2 = new Constructors(30, 40);
        c2.display();

        Constructors c3 = new Constructors(c2);
        c3.display();
    }
}
