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
public class LinkedList {
    private class Node {

        String value;
        Node next;

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         * @param n The reference to the successor node.
         */
        Node(String val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */
        Node(String val) {
            // Call the other (sister) constructor.
            this(val, null);
        }
    }

    private Node first;  // list head
    private Node last; // last element in list
    public Node head = null;
    //public Node head; 

    /**
     * Constructor.
     */
    public LinkedList() {
        first = null;
        last = null;
    }

    /**
     * The isEmpty method checks to see if the list is empty.
     *
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * The size method returns the length of the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
            // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * The add method adds an element to the end of the list.
     *
     * @param e The value to add to the end of the list.
     */
    public void add(String e) {
        if (isEmpty()) {
            first = new Node(e);
            last = first;
        } else {
            // Add to end of existing list
            last.next = new Node(e);
            last = last.next;
        }
    }

    /**
     * The add method adds an element at a position.
     *
     * @param e The element to add to the list.
     * @param index The position at which to add the element.
     * @exception IndexOutOfBoundsException When index is out of bounds.
     */
    public void add(int index, String e) {
        if (index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Index is at least 0
        if (index == 0) {
            // New element goes at beginning
            first = new Node(e, first);
            if (last == null) {
                last = first;
            }
            return;
        }

        // Set a reference pred to point to the node that
        // will be the predecessor of the new node
        Node pred = first;
        for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;
        }

        // Splice in a node containing the new element
        pred.next = new Node(e, pred.next);

        // Is there a new last element ?
        if (pred.next.next == null) {
            last = pred.next;
        }
    }

    /**
     * The toString method computes the string representation of the list.
     *
     * @return The string form of the list.
     */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // Use p to walk down the linked list
        Node p = first;
        while (p != null) {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }
  
    public void MergeSort() {
        this.head = this.mergeSort(this.head);
        System.out.println("After merge sort the list is:");
        this.printList(this.head);
        }
    /**
    This method recursively return sorted nodes. 
    @param h define the node to start with.
    @return node after sorted.
    **/  

    public Node sortedMerge(Node a, Node b) 
    { 
        Node result = null; 
        /* Base cases */
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        /* Pick either a or b, and recur */
        if (a.value.compareToIgnoreCase(b.value) <= 0) { 
            result = a; 
            result.next = sortedMerge(a.next, b); 
        } 
        else { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
    } 
  
    Node mergeSort(Node h) 
    { 
        // Base case : if head is null 
        if (h == null || h.next == null) { 
            return h; 
        } 
  
        // get the middle of the list 
        Node middle = getMiddle(h); 
        Node nextofmiddle = middle.next; 
  
        // set the next of middle node to null 
        middle.next = null; 
  
        // Apply mergeSort on left list 
        Node left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        Node right = mergeSort(nextofmiddle); 
  
        // Merge the left and right lists 
        Node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
  
    // Utility function to get the middle of the linked list 
    public static Node getMiddle(Node head) 
    { 
        if (head == null) 
            return head; 
  
        Node slow = head, fast = head; 
  
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    } 
  
    void push(String new_data) 
    { 
        /* allocate node */
        Node new_node = new Node(new_data); 
  
        /* link the old list off the new node */
        new_node.next = head; 
  
        /* move the head to point to the new node */
        head = new_node; 
    } 
  
    // Utility function to print the linked list 
    void printList(Node headref) 
    { 
        while (headref != null) { 
            System.out.print(headref.value + " "); 
            headref = headref.next; 
        } 
    } 
    
}
