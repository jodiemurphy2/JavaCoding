/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ie.ncirl.bst;

/**
 *
 * @author jodie
 */
public interface IBinarySearchTree {
    
    public void insert(Employee employee); //method to insert employees into BST
    public Employee search(int employeeID); //method to search for an employee based on employeeID
    public BSTNode delete(int employeeID); //method to delete an employee based on employeeID
    public void printAll(); // method to print out all details of employees in BST (ordered by employeeID)
}
