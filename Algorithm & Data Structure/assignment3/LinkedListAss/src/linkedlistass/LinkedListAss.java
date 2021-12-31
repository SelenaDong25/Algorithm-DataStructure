/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistass;

/**
 *
 * @author dx200
 */
public class LinkedListAss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList ll = new LinkedList(); 
        LinkedList dd = new LinkedList();
        
        
        ll.add("Amy");        
        ll.add("Bob");        
        ll.add(0, "Al");        
        ll.add(2, "Beth");        
        ll.add("Carol");  
        ll.add("Bill");
        ll.add("Selena");
        ll.add(4,"David");
        ll.add(3,"Stacey");
        ll.add("Selena");
        ll.add("David");
        ll.add(3,"Stacey");
        System.out.println("The members of the list are:");        
        System.out.print(ll);
        
        ll.removeDuplicates();
        System.out.println("After remove duplicates, the list is: \n" + ll);
        
        dd.add("Selena");
        dd.add("David");
        dd.add("Stacey");
        dd.add("Mary");
        dd.add("Sandra"); 
        System.out.print("\n dd Linked List is: \n" + dd);
        System.out.print("\n Intersect List is: \n" + ll.intersect(dd));

        System.out.print("\n Union List is: \n" + ll.union(dd));
        System.out.println("The List contain Carol(true/false)" + ll.contains("Carol"));
    }
    
}
