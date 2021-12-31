/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 3
 * XIN DONG ON MAY 14, 2020.
 */
package asslinkedlist;

/**
 *
 * @author dx200
 */
public class AssLinkedList {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList ll = new LinkedList(); 
        LinkedList dd = new LinkedList();
        LinkedList cc = new LinkedList();
        
        
        ll.add("Amy");        
        ll.add("Bob");        
        ll.add(0, "Al");        
        ll.add(2, "Beth");        
        ll.add("Carol");  
        ll.add("Selena");
        ll.add(4,"David");
        ll.add("Selena");
        ll.add("David");
        ll.add(3,"Stacey");
        System.out.println("The members of the list are:");        
        System.out.print(ll);
        
        ll.removeDuplicates();
        System.out.println("After remove duplicates, the list is: \n" + ll);
        
        dd.add("Selena");
        dd.add("David");
        dd.add("Mary");
        dd.add("Sandra"); 
        System.out.print("\ndd Linked List is: \n" + dd);
        System.out.print("\nIntersect List is: \n" + ll.intersect(dd));

        System.out.print("\nUnion List is: \n" + ll.union(dd));
        System.out.println("The List contain Carol(true/false)\n" + ll.contains("Carol"));
        
        cc.push("Eric");
        cc.push("Marie");
        cc.push("Philip");
        cc.push("Sally");
        cc.push("Mike");
        cc.push("Neil");
        
        System.out.print("List cc merge sorted result is: \n");
        cc.MergeSort();

      
        
  }
    
}
