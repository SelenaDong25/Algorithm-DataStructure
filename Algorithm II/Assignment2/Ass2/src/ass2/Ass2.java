/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

/**
 *
 * @author dx200
 */
public class Ass2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Assignment2 aa = new Assignment2();
        System.out.println(aa.Parsing("{ [ ] }"));
        System.out.println(aa.Parsing("( [ { } ( ) ] ( ) { ( ) } )"));
    }
    
}
