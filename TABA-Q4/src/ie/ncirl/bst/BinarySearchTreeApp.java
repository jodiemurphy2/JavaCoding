/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ie.ncirl.bst;

/**
 *
 * @author jodie
 */
public class BinarySearchTreeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create instances of employees
        Employee emp1 = new Employee(1234, "John Doyle", "HR");
        Employee emp2 = new Employee(4869, "Sam Harris", "Finance");
        Employee emp3 = new Employee(2540, "Mary Murphy", "Sales");
        Employee emp4 = new Employee(6352, "Laura Kelly", "Finance");
        Employee emp5 = new Employee(1875, "Rick Jones", "HR");
        Employee emp6 = new Employee(4558, "Sarah Furlong", "Finance");
        Employee emp7 = new Employee(3685, "Rachel Smith", "Sales");
        Employee emp8 = new Employee(8769, "Bob Keary", "Finance");
        Employee emp9 = new Employee(1836, "Micheal ONeil", "HR");
        Employee emp10 = new Employee(3258, "Lisa Cooney", "Finance");
        
        //Creat an instance on the BST
        BinarySearchTree bst = new BinarySearchTree();
        
        //Insert employees into BST
        bst.insert(emp1);
        bst.insert(emp2);
        bst.insert(emp3);
        bst.insert(emp4);
        bst.insert(emp5);
        bst.insert(emp6);
        bst.insert(emp7);
        bst.insert(emp8);
        bst.insert(emp9);
        bst.insert(emp10);
        
        // Printing all employees
        System.out.println("\nPrinting all employees:");
        bst.printAll();
        
        // Testing search with an employee taht exists
        System.out.println("\nSearching for employee with ID 3685:");
        Employee foundEmployee = bst.search(3685);
        if (foundEmployee != null) {
            foundEmployee.printDetails();
        } else {
            System.out.println("Employee not found.");
        }
        
        // Testing search with an employee taht does notexists
        System.out.println("\nSearching for employee with ID 1111:");
        Employee notFoundEmployee = bst.search(1111);
        if (notFoundEmployee != null) {
            notFoundEmployee.printDetails();
        } else {
            System.out.println("Employee not found.");
        }

        // Testing deletion
        System.out.println("\nDeleting employee with ID 2540:");
        bst.delete(2540);
       

        // Printing all employees to show that deleted employee was removed
        System.out.println("\nPrinting all employees:");
        bst.printAll();
       
        
    }
    
}
