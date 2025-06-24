interface Area{
    float compute(float x, float y);
    public final static float PI = 3.14f;
}

class Rectangle implements Area{ // Defined overridden method of the interface
    public float compute(float x, float y){
        return (x * y);
    }
}
public class AnonymousClass {
    public static void main(String args[]){
        Rectangle objRect = new Rectangle();
        System.out.println("The area of Rectangle is: " + objRect.compute(2.2f, 3.2f));

        Area objArea = new Area() {
            public float compute(float x, float y){
                return (Area.PI * x * x);
            }
        };
        System.out.println("The area of Circle is: " + objArea.compute(1.5f, 4.2f));
    }
}

