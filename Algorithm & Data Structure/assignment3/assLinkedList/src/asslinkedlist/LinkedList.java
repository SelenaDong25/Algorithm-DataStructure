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

public class LinkedList {
    /**
     * The Node class stores a list element and a reference to the next node.
     */

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

    /**
     * The remove method removes the element at an index.
     *
     * @param index The index of the element to remove.
     * @return The element removed.
     * @exception IndexOutOfBoundsException When index is out of bounds.
     */
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        String element;  // The element to return     
        if (index == 0) {
            // Removal of first item in the list
            element = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            // To remove an element other than the first,
            // find the predecessor of the element to
            // be removed.
            Node pred = first;

            // Move pred forward index - 1 times
            for (int k = 1; k <= index - 1; k++) {
                pred = pred.next;
            }

            // Store the value to return
            element = pred.next.value;

            // Route link around the node to be removed
            pred.next = pred.next.next;

            // Check if pred is now last
            if (pred.next == null) {
                last = pred;
            }
        }
        return element;
    }

    /**
     * The remove method removes an element.
     *
     * @param element The element to remove.
     * @return true if the remove succeeded, false otherwise.
     */
    public boolean remove(String element) {
        if (isEmpty()) {
            return false;
        }

        if (element.equals(first.value)) {
            // Removal of first item in the list
            first = first.next;
            if (first == null) {
                last = null;
            }
            return true;
        }

        // Find the predecessor of the element to remove
        Node pred = first;
        while (pred.next != null
                && !pred.next.value.equals(element)) {
            pred = pred.next;
        }

        // pred.next == null OR pred.next.value is element
        if (pred.next == null) {
            return false;
        }

        // pred.next.value  is element
        pred.next = pred.next.next;

        // Check if pred is now last
        if (pred.next == null) {
            last = pred;
        }

        return true;
    }
    /**
    This method check if the link list contain a string e. 
    @param e define the passing string.
    @return If the list contain this string, return true, else return false
    **/ 
    public boolean contains(String e) {
        if (isEmpty()) {
            return false;
        }
        while (first != null) {
            if (e.equals(first.value)) {
                return true;
            }
        
        first = first.next;
        }
        return false;
    }
    /**
    This method is to remove duplicates within the linked list. 

    **/
    public void removeDuplicates(){
        Node a = first;
        Node b;
        while (a != null && a.next !=null) {
            b = a;
            while (b.next != null) {

                if (a.value.equals(b.next.value)) {
                    //remove(b.value);          
                    b.next = b.next.next;
                } else {
                    b = b.next;
                }
            }
            a = a.next;
        }
    }
    
    /**
    This method find common elements from two linked list and return a new 
        linked list contain the common elements. 
    @param list define the second linked list which will be used to compare with.
    @return new linked list with common elements.
    **/
    public LinkedList intersect(LinkedList list) {
        LinkedList inter = new LinkedList();
        Node curA = list.first;

        while (curA != null) {
            Node curB = this.first;
            while (curB != null) {
                if (curB.value.equalsIgnoreCase(curA.value)) {
                    inter.add(curB.value);
                }
                curB = curB.next;
            }
            curA = curA.next;
        }
        return inter;
    }
    /**
    This method combine all elements from two linked list and return a new 
        linked list contain all these elements without duplicates. 
    @param list define the second linked list which will be used to combine with.
    @return new linked list with all unique elements.
    **/
    public LinkedList union( LinkedList list ){
        LinkedList uni = list; 
        Node a1 = this.first;
            for(int i = 0; i < this.size(); i++){
                uni.add(a1.value);
                a1 = a1.next;
            }
        uni.removeDuplicates();
        return uni;        
    }
    /**
    This method sort a single linked list by using Merge Sort algorithm. 

    **/
    public Node head = null;
    public void MergeSort() {
        this.head = this.mergeSort(this.head);
        this.printList(this.head);
        }

    private Node sortedMerge(Node a, Node b) 
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
    /**
    This method recursively return sorted nodes. 
    @param h define the node to start with.
    @return node after sorted.
    **/  
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
  
    public void push(String new_data) 
    { 
        /* allocate node */
        Node new_node = new Node(new_data); 
  
        /* link the old list off the new node */
        new_node.next = head; 
  
        /* move the head to point to the new node */
        head = new_node; 
    } 
  
    // Utility function to print the linked list 
   private void printList(Node headref) 
    { 
        while (headref != null) { 
            System.out.print(headref.value + " "); 
            headref = headref.next; 
        } 
    } 
    
    
}

