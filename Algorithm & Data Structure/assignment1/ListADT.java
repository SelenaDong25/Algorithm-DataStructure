
package listadt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Thomas.Abbott
 */
public class ListADT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> src = new LinkedList<>();
        src.add(2);
        src.add(4);
        src.add(6);
        
        System.out.println("src looks like this:" + src);
        List<Integer> dst = new ArrayList<>();

        for( int i = 0; i < src.size(); i++ ) {
            dst.add(src.get(i));
        }

        /*
        Iterator<Integer> ni = src.iterator();
        while(ni.hasNext() == true) {
            dst.add(ni.next());
        }
        */
        /*
        for( Integer n : src ) {
            dst.add(n);
        }
        */
        System.out.println("dst looks like this:" + src);
    }
}
