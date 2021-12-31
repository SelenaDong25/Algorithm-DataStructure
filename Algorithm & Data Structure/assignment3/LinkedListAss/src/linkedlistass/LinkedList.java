/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 3
 * XIN DONG ON MAY 9, 2020.
 */
package linkedlistass;


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
        linked list contain only the common elements. 
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
    public void MergeSort() {
        if (isEmpty() || this.size() == 1) {
            System.out.println("The list is empty or cannot be sorted");;
        }
        // call the private MergeSort because it takes a list parameter
        MergeSort(this);
    }
    
    private void MergeSort(LinkedList list) {
        
        LinkedList right;        
        LinkedList left;
        
        if (2 <= list.size()){
            right  = list.split();
            left  = list;
        }
        else{
            left = list;
            right = left.split();           
        }

        if (left.size() >= 2)  {  
           MergeSort(left);
       
        }    
        if (right.size() >= 2)  {          
           MergeSort(right);
        }       
        Merge(left, right);       
    }

    private LinkedList Merge(LinkedList a, LinkedList b) {
        LinkedList result = null;
        if (a == null && b == null) {
            return null;
        } else if (a != null && b == null) {
            result = a;
        } else if (b != null && a == null) {
            result = b;
        } else if (a != null && a.size() >= 1 && b != null && b.size() >= 1) {
            
            while (result != null) {
                if (a.first.value.compareToIgnoreCase(b.first.value) <= 0) {
                    result.add(result.size(), a.first.value);
                    a.remove(0);

                } else if (b.first.value.compareToIgnoreCase(a.first.value) < 0) {
                    result.add(result.size(), b.first.value);
                    b.remove(0);
                } 
            }
        } 
        return result;
    }
          

    public LinkedList split() {
        
        if( this.size() < 2){
            return null;
        }
        int halfWay;
        if(this.size()%2 == 0)
            halfWay = this.size()/2 - 1;
        else
            halfWay = this.size()/2 ;
        
        Node node = this.first;
        
        for( int index = 0; index < halfWay; index++){
            node = node.next;
        }
        
        LinkedList newList = new LinkedList();
        newList.first = node.next;
        
        node.next = null;
        return newList;
        
    }
}