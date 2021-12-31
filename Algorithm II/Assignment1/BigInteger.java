package biginteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tomabot
 */
public class BigInteger {

    private List<Byte> digits;

    // default constructor
    public BigInteger() {
        digits = new ArrayList<>();
        digits.add((byte) 0);
    }

    // construct a big integer from a String of digits
    public BigInteger(String strDigits) {
        if (strDigits == null || strDigits.length() == 0) {
            throw new IllegalArgumentException();
        }

        digits = new ArrayList<>();
        
        for (int i = 0; i < strDigits.length(); i++) {
            byte digit = (byte) ((int) strDigits.charAt(i) - '0');

            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException();
            }
            digits.add(digit);
        }
    }

    // construct a big integer from an integer
    public BigInteger(int nDigits) {
        if (nDigits == 0) {
            digits = new ArrayList<>();
            digits.add((byte) 0);
            return;
        }

        digits = new ArrayList<>();

        while (nDigits > 0) {
            byte d = (byte) (nDigits % 10);

            if (d < 0 || d > 9) {
                throw new IllegalArgumentException();
            }

            digits.add(d);
            nDigits /= 10;
        } 
    }

    // construct a big integer from a  big integer
    public BigInteger( BigInteger srcBi ) {
        digits = new ArrayList<>();
        
        for( Byte b : srcBi.digits ) {
            digits.add(b);
        }
    }
    
    // construct a big integer from a list of digits
    // with no error checking
    private BigInteger(List<Byte> srcDigits) {
        if (srcDigits == null) {
            throw new IllegalArgumentException();
        }
        this.digits = srcDigits;
    }

    // add two big integers and return a reference to the big integer sum
    public BigInteger add(BigInteger bi) {

        Iterator<Byte> itSmall, itLarge;

        if (bi.digits.size() > this.digits.size()) {
            itLarge = bi.digits.iterator();
            itSmall = this.digits.iterator();
        } else {
            itLarge = this.digits.iterator();
            itSmall = bi.digits.iterator();
        }

        byte carry = 0, rdigit;
        List<Byte> resultDigits = new ArrayList<>();

        while(itSmall.hasNext()) {
            rdigit = (byte) (itSmall.next() +  itLarge.next() + carry);
            
            if (rdigit > 9) {
                rdigit -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            resultDigits.add(rdigit);
        }

        while(itLarge.hasNext()) {
            rdigit = (byte)(itLarge.next() + carry);

            if (rdigit > 9) {
                rdigit -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            resultDigits.add(rdigit);
        }

        if(carry == 1) {
            resultDigits.add(carry);
        }
        
        return new BigInteger(resultDigits);
    }

    // output a string representation of the big integer
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte d : digits) {
            sb.append(d); 
        }
        return sb.reverse().toString();
    }

}
