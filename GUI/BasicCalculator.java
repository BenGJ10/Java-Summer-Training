// In Java, an ActionListener is an interface within the java.awt.event package, designed to handle 
// action events, primarily in GUI applications. It is a key component in event-driven programming, 
// allowing Java applications to respond to user interactions with GUI elements.

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener{
    TextField t1, t2, t3;
    Label l1, l2, l3;
    Button add, subtract, mult, divide, clear;
    int num1, num2, res;
    String str;

    MyFrame(String s){
        super(s);
        t1 = new TextField(20);
        t2 = new TextField(20);
        t3 = new TextField(20);

        l1 = new Label("First Number: ");
        l2 = new Label("Second Number: ");
        l3 = new Label("Result: ");

        add = new Button("Add");
        subtract = new Button("Subtract");
        mult = new Button("Multiply");
        divide = new Button("Divide");
        clear = new Button("Clear");

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(add); add(subtract);
        add(mult); add(divide);
        add(clear);

        add.addActionListener(this); // We are making the buttons listen to what the user is going to do!
        subtract.addActionListener(this);
        mult.addActionListener(this);
        divide.addActionListener(this);
        clear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){ // when the buttons which are clicked
            num1 = Integer.parseInt(t1.getText()); // get value from the text field
            num2 = Integer.parseInt(t2.getText());

            res = num1 + num2;
            
            t3.setText("" + res); // placing the answer in the text field
        }
        
        if(ae.getSource() == subtract){
            num1 = Integer.parseInt(t1.getText());
            num2 = Integer.parseInt(t2.getText());

            res = num1 - num2;

            t3.setText("" + res);
        }

        if(ae.getSource() == mult){
            num1 = Integer.parseInt(t1.getText());
            num2 = Integer.parseInt(t2.getText());

            res = num1 * num2;

            t3.setText("" + res);
        }
        if(ae.getSource() == divide){
            num1 = Integer.parseInt(t1.getText());
            num2 = Integer.parseInt(t2.getText());

            if(num2 == 0){
                t3.setForeground(Color.RED);
                t3.setText("Cannot divide by zero");
            } 
            else {
                double res = (double) num1 / num2;
                t3.setForeground(Color.BLACK);
                t3.setText(String.valueOf(res));
            }
        }
        if(ae.getSource() == clear){
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }
}

public class BasicCalculator{
    public static void main(String args[]){
        MyFrame obj = new MyFrame("Basic Calculator");
        obj.setSize(500,500);
        obj.setLayout(new GridLayout(6, 2, 10, 10));
        //obj.setLayout(new FlowLayout());    // Display layouts excatly how we have defined
        obj.setVisible(true);
    }
}

