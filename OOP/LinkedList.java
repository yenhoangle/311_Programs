import java.util.Scanner;
// Java program to implement a singly linked list, enables inserting integers into the list 
  public class LinkedList { 
  
    Node head; //head of list 
   
    //the inner Node class
    static class Node { 
  
        int data; 
        Node next; 
  
        // constructor 
        Node(int data) 
        { 
            this.data = data; 
            next = null; 
        } 
    } 
  
    //method to insert a new node 
    public static LinkedList insert(LinkedList list, int data) 
    { 
        //create a new node with given data 
        Node newNode = new Node(data); 
        newNode.next = null; 
  
        //if the list is empty, then make the new node as head 
        if (list.head == null) { 
            list.head = newNode; 
        } 
        else { 
            // else traverse till the last node and insert after it
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // insert at last node 
            last.next = newNode; 
        } 
  
        return list; 
    } 
  
    //list print method
    public static void printList(LinkedList list) 
    { 
        Node currNode = list.head; 
   
        System.out.print("List Items: "); 
   
        //loop through list
        while (currNode != null) { 
            //print the data at current node 
            System.out.print(currNode.data + " "); 
   
            // set next node 
            currNode = currNode.next; 
        } 
    } 
   
    // driver code 
    public static void main(String[] args) 
    { 
        //make a new list
        LinkedList list = new LinkedList();
        
        //ask how many items to insert
        int count;
        //ask for data to insert
        int data;
        Scanner sc = new Scanner(System.in);  // create a Scanner object
        System.out.println("Enter how many numbers to insert into the list: ");
    
        count = sc.nextInt();  // read user input
        for (int i = 0; i < count; i++) {
            System.out.print("Enter a number to put into the list: ");
            data = sc.nextInt();
            list = insert(list, data);
        }
        sc.close();
        System.out.println("Done inserting! Printing list...");
        //print list 
        printList(list); 
    } 
}