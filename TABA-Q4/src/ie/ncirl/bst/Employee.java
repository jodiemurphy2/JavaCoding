/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.ncirl.bst;

/**
 *
 * @author jodie
 */
public class Employee implements Comparable<Employee>{
    
    //variables
    private int employeeID;
    private String name;
    private String department;
    
    //Constructor
    public Employee(int employeeID, String name, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
    }
    
    // Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
    
    
    // Over ride to the compareTo method so that BST can be ordered based on employeeID
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.employeeID, other.employeeID);
    }

    // Method to print employee details
    public void printDetails() {
        System.out.println("Employee ID: " + employeeID + ", Name: " + name + ", Department: " + department);
    }
}
