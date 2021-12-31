
package edu.lwtech.pgmassign4;

public class UsingLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add("Amy");
        ll.add("Bob");
        ll.add(0, "Al");
        ll.add(2, "Beth");
        ll.add(4, "Carol");
        System.out.println("The members of the list are:");
        System.out.print(ll);
    }
}
