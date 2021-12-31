/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication29;

/**
 *
 * @author dx200
 */
public class JavaApplication29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList ll = new LinkedList(); 
        LinkedList dd = new LinkedList();
        
        
        ll.add("Amy");        
        ll.add("Bob");  
        ll.add("Carol");  
        ll.add("Bill");
        ll.add("Selena");
        ll.add(0, "Al");        
        ll.add(2, "Beth");        
        ll.add(4,"David");
        ll.add(3,"Stacey");
  
        
        dd.add("Selena");
        dd.add("David");
        dd.add("Stacey");
        dd.add("Mary");
        dd.add("Sandra"); 
        
        
        
        
        System.out.println("The members of the list are:");        
        System.out.print(ll);
        System.out.println(ll.contains("Carol"));
        ll.removeDuplicates();
        System.out.print("\n Sorted Linked List is: \n" + ll); 
        System.out.print("\n dd Linked List is: \n" + dd); 
        ll.intersect( dd );
        ll.MergeSort();
        System.out.print("\n Intersect List is: \n" + ll.intersect(dd));
        
        
        System.out.print("\n Union List is: \n" + ll.union(dd));
        //ll.printList(ll.head);
    }
    
  
    
}
