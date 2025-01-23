/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.ncirl.bst;

/**
 *
 * @author jodie
 */
public class BinarySearchTree implements IBinarySearchTree{
    
    //Set the root node to Null
    public BSTNode root = null;

    
    //create the method to insert the employeeID using recursion
    @Override
    public void insert(Employee employee) {
        //if root is null then current emplyee will be inserted at root
        if(root==null){ 
            root = new BSTNode(employee);
        }
        //Otherwise use recursive method
        else{
            insert(employee, root);
        }
    }
    
    //recursive implementation of insert
    private void insert(Employee employee, BSTNode currentNode){
        if(currentNode == null) return;
        
        //use the compareto method in the Employee class to check if the employeeID is less than the value of employeeID in current node
        else if(employee.compareTo(currentNode.employee) < 0){
            //if so and the next node to the left is null then insert the employyee here
            if(currentNode.left == null){
                currentNode.left = new BSTNode(employee);
            }
            //if left is not null then use recurion again
            else{
                insert(employee,currentNode.left);
            }
        }
        //if the employeeID is greater than the value of employeeID in current node
        else{ 
            //if so and the next node to the right is null then insert the employyee here
            if(currentNode.right == null){
                currentNode.right = new BSTNode(employee);
            }
            //if right is not null then use recurion again
            else{
                insert(employee,currentNode.right);
            }
        }
    }
    
    
    //Method to search for an employee based on employeeID
    @Override
    public Employee search(int employeeID) {
        
        //if root is null then return null
        if(root==null){ 
            return null;
        }
        //Otherwise use recursive method
        else{
            //crete a temporary node called result and run recursize method
            BSTNode result = search(root, employeeID);
            
            //if employeeID is not in tree then return null
            if(result==null)return null;
            
            //if employeeID is found then return the employee
            else return result.employee;
        }
    }
    
    //recursive method to search for employee based on employeeID
    private BSTNode search(BSTNode currentNode, int employeeID) {
        if(currentNode == null) return currentNode;
        
        //check if the employeeID matches the employeeID at current node (return employee if true)
        if (currentNode.employee.getEmployeeID() == employeeID){
            return currentNode;
        }
        //if employeeID is less than employeeID at currentNode then move left and check again
        if (employeeID < currentNode.employee.getEmployeeID()){
            return search(currentNode.left, employeeID);
        }
        //if employeeID is greter than employeeID at currentNode then move right and check again
        else{
            return search(currentNode.right, employeeID);
        }
    }

    
    
    //method to return all employee records in the BST and print details of eachbased on sequence of employeeID
    @Override
    public void printAll() {
        printAll(root);
    }
    
    private void printAll(BSTNode currentNode){
        
        // base case
        if(currentNode == null) return;
        
        // go as far left as possible
        printAll(currentNode.left);
        
        //then print employee details for leftmost employee
        currentNode.employee.printDetails();
        
        // then move right go again
        printAll(currentNode.right);
    }
    
    
    //method to delete an employee from the BST based on employeeID

    /**
     *
     * @param employeeID
     * @return
     */
    @Override
    public BSTNode delete(int employeeID) {
        //if root is null then return null
        if(root==null){ 
            System.out.println("BST is empty, nothing to delete");
            return null;
        }
        
        //Otherwise use recursive method
        else{
            //crete a temporary node called result and run recursize method
            BSTNode result = delete(root, employeeID);
            return result;
        }     
    }
    
     private BSTNode delete(BSTNode currentNode, int employeeID) {
        
        if(currentNode == null) return currentNode;
         
         //check if employeeID is less than current and move left
        if (employeeID < currentNode.employee.getEmployeeID())
            currentNode.left = delete(currentNode.left, employeeID);
        
        //check if employee ID is greter than current and move right
        else if (employeeID > currentNode.employee.getEmployeeID())
            currentNode.right = delete(currentNode.right, employeeID);
        
        //Ife employee ID matches currentNode
        else if(employeeID==currentNode.employee.getEmployeeID()){
            
            //when no children make current Node null
            if (currentNode.left == null && currentNode.right==null){
                currentNode=null;
            }
            //when left child make current Node equal to left child
            else if (currentNode.left != null && currentNode.right==null){
                currentNode=currentNode.left;
            }
            //when right child make current Node equal to right child
            else if (currentNode.left == null && currentNode.right!=null){
                currentNode=currentNode.right;
            }
            //when both children - find the next lowest value on right side and set current to that element 
            //Then delete the minimum value from the BST so it only appears once
            else if(currentNode.left != null && currentNode.right!=null){
                currentNode.employee = minValueNode(currentNode.right).employee;
                currentNode.right = delete(currentNode.right, currentNode.employee.getEmployeeID());
            }
        }
        return currentNode;
    }
    
    //method to find minimum employeeID value Node in the BST
    private BSTNode minValueNode(BSTNode currentNode) {
        BSTNode tempNode = currentNode;
        while (tempNode.left != null)
            tempNode = tempNode.left;
        return tempNode;
    }

}
