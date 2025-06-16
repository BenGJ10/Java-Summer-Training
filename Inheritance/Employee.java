public class Employee {
    
    int accountNumber;
    String name;
    int balance;

    Employee(int accNum, String name, int balance){
        this.accountNumber = accNum;
        this.name = name;
        this.balance = balance;
    }
    
    void displayDetails(){
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder name: " + name);
        System.out.println("Remaining balance: " + balance);
    }

    void transferMoney(Employee emp, int amount){
        if(amount <= this.balance){
            this.balance -= amount;
            emp.balance += amount;
            System.out.println("Successfully transferred " + amount + " Rs to " + emp.name);
        } else{
            System.out.println("Insufficient balance. Try later.");
        }
    }

    public static void main(String args[]){
     
        Employee emp1 = new Employee(101, "Ben Gregory", 1000);
        Employee emp2 = new Employee(102, "Lionel Messi", 2000);
        
        System.out.println("Details before transferring amount: ");
        emp1.displayDetails();
        emp2.displayDetails();

        int amount = Integer.parseInt(args[0]); // Command line arguments
        emp1.transferMoney(emp2, amount);
        
        System.out.println();
        System.out.println("Details after transferring amount: ");
        emp1.displayDetails();
        emp2.displayDetails();

    }
}
