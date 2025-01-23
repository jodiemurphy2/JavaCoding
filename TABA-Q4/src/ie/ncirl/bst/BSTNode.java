/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.ncirl.bst;

/**
 *
 * @author jodie
 */
public class BSTNode {
    public Employee employee;
    public BSTNode left;
    public BSTNode right;
    
    
    //Constructor
    public BSTNode(Employee employee) {  
	this.employee = employee;
	this.left = null;
	this.right = null;
    }
}
