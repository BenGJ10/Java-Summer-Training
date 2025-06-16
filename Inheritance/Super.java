class A{
    int a, b; // Data member
    
    A(){}
    A(int a, int b){
        this.a = a;
        this.b = b;
        System.out.println("A's parameterized constructor is called.");
    }
}

class B extends A{
    int c;
    
    B(){}
    B(int a, int b, int c){
        super(a, b);
        this.c = c;
        System.out.println("B's parameterized constructor is called.");
    }

    void display(){
        System.out.println("Values of a and b are: " + this.a + ", " + this.b + ", " + this.c);
    }
}

class Super{
    public static void main(String args[]){
        B obj = new B(33, 44, 55);
        obj.display();
    }
}