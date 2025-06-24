// This program shows how we handle Custom Exceptions in Java

import java.util.*;

class InvalidBMIException extends Exception{
    public InvalidBMIException(String message){
        super(message);
    }
}

class BMICalculator{
    public double calculateBMI(double weight, double height) throws InvalidBMIException{
        if(weight <= 0.0){
            throw new InvalidBMIException("Weight of a person cannot be less than zero!");
        }
        if(height <= 0.0){
            throw new InvalidBMIException("Height of a person cannot be less than zero!");
        }

        return (10000 * weight / (height *  height));
    }

    public String interuptBMI(double bmi){
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }
}
public class BMICustomException {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your height: ");
        double height = sc.nextDouble();

        System.out.println("Enter your weight: ");
        double weight = sc.nextDouble();

        try{
            BMICalculator calcBMI = new BMICalculator();
            double bmi = calcBMI.calculateBMI(weight, height);
            System.out.println("Your BMI is: " + bmi);
            System.out.println("Youu BMI category is: " + calcBMI.interuptBMI(bmi));
        } 
        catch(InvalidBMIException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
