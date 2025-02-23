// Delvian Brown ID#: 2301011767
// Marlon Griffiths ID#:
// Shanelle Farquhson ID#:

import java.util.ArrayList;

abstract class StaffMember {
    private String name;
    private int idNumber;
    private int hoursWorked;

    // Parameterized constructor
    public StaffMember(String name, int idNumber, int hoursWorked) {
        this.name = name;
        this.idNumber = idNumber;
        this.hoursWorked = hoursWorked;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID Number: " + idNumber);
        System.out.println("Hours Worked: " + hoursWorked);
    }

    // Abstract method for salary calculation
    public abstract double calculateSalary();
}

class Manager extends StaffMember {
    private double bonus;

    // Parameterized constructor
    public Manager(String name, int idNumber, int hoursWorked, double bonus) {
        super(name, idNumber, hoursWorked);
        this.bonus = bonus;
    }

    // Getter and Setter for bonus
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Override display method
    @Override
    public void display() {
        super.display();
        System.out.println("Bonus: " + bonus);
    }

    // Implement calculateSalary method
    @Override
    public double calculateSalary() {
        return (getHoursWorked() * 2500) + bonus;
    }
}

class SalesRep extends StaffMember {
    private double allowance;

    // Parameterized constructor
    public SalesRep(String name, int idNumber, int hoursWorked, double allowance) {
        super(name, idNumber, hoursWorked);
        this.allowance = allowance;
    }

    // Getter and Setter for allowance
    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    // Override display method
    @Override
    public void display() {
        super.display();
        System.out.println("Allowance: " + allowance);
    }

    // Implement calculateSalary method
    @Override
    public double calculateSalary() {
        return (getHoursWorked() * 1500) + allowance;
    }
}

public class Payroll {
    public static void main(String[] args) {
        // Task 3: Instantiate and display a StaffMember object
        StaffMember staff = new Manager("Delvian Brown", 101, 40, 5000);
        System.out.println("Staff Member Details:");
        staff.display();
        System.out.println();

        // Task 4: Create a list of SalesRep objects
        ArrayList<SalesRep> salesReps = new ArrayList<>();
        salesReps.add(new SalesRep("Ory Williams", 201, 35, 1000));
        salesReps.add(new SalesRep("Lyndall Walcot", 202, 40, 1200));
        salesReps.add(new SalesRep("Fabian Sebastian", 203, 30, 800));
        salesReps.add(new SalesRep("Hamlet Survey", 204, 45, 1500));
        salesReps.add(new SalesRep("Romario Richardson", 205, 38, 1100));

        // Task 5: Display SalesRep objects
        System.out.println("Sales Representatives Details:");
        for (SalesRep salesRep : salesReps) {
            salesRep.display();
            System.out.println();
        }

        // Task 6: Demonstrate polymorphism
        StaffMember polymorphicStaff = new Manager("Delvian Brown", 102, 45, 6000);
        System.out.println("Polymorphic Display (Manager):");
        polymorphicStaff.display();
        System.out.println();

        polymorphicStaff = new SalesRep("Christian  Black", 206, 40, 1300);
        System.out.println("Polymorphic Display (SalesRep):");
        polymorphicStaff.display();
        System.out.println();

        // Task 8: Display salaries
        StaffMember manager = new Manager("Delvian Brown", 101, 40, 5000);
        StaffMember salesRep = new SalesRep("Ory Williams", 201, 35, 1000);

        System.out.println("Manager Salary: " + manager.calculateSalary());
        System.out.println("SalesRep Salary: " + salesRep.calculateSalary());

        // Task 9: Generate paystubs
        System.out.println("\nPaystubs:");
        System.out.println("Manager Paystub:");
        manager.display();
        System.out.println("Salary: " + manager.calculateSalary());

        System.out.println("\nSalesRep Paystub:");
        salesRep.display();
        System.out.println("Salary: " + salesRep.calculateSalary());
    }
}