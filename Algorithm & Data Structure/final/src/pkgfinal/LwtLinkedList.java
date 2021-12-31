/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author dx200
 */
public class LwtLinkedList {
    class Node {
        private int value;
        private Node next;
    }

    private Node first;
    // assume all the support methods are here...
    
    public void setAbsolute() {
        setAbsolute(first);
    }
    private void setAbsolute(Node n) {
        
        if (n == null){
            return;
        }
        if(n.value<0){
            n.value = n.value * -1;
        }
        setAbsolute(n.next);       
    }
}
