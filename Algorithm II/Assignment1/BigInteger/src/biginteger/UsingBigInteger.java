/*
 * CSD436-ALGORITHM PROBLEM SOLVING
 * ASSIGNMENT 1
 * XIN DONG on Jan. 15, 2021.
   Added Substract Method corresponding test case
 */
package biginteger;

public class UsingBigInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        BigInteger b0 = new BigInteger("99");
        System.out.println("b0=" + b0);
        
        BigInteger b1 = new BigInteger(43);
        System.out.println("b1=" + b1);
        
        BigInteger b2;
        b2 = b0.add(b1);
        System.out.println("b2=" + b2);
        
        BigInteger b3 = new BigInteger(b2); 
        System.out.println("b3=" + b3);
        
        BigInteger b4;
        b4 = b0.subtract(b1);
        System.out.println("b4=" + b4);
    }
    
}
