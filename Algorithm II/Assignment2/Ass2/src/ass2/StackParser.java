/*
 * CSD436-ALGORITHM PROBLEM SOLVING
 * ASSIGNMENT 2
 * XIN DONG on Jan. 23, 2021.
 */
package ass2;


import java.util.Stack;
import java.util.HashMap;
import java.util.Objects;


public class StackParser {
    
    private static Stack<Character> stackOfBracket = new Stack<Character>();   

    private static HashMap<Character, Character> brackets = new HashMap<Character, Character>();
    
    public static boolean Parsing(String s){
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put('>', '<');
        
        char[] arrayChar = s.replaceAll(" ", "").toCharArray(); 
        for(char item:arrayChar){
            if(brackets.containsKey(item)) {
                if(stackOfBracket.empty()) {
                    return false;
                }
                if(Objects.equals(stackOfBracket.peek(), brackets.get(item))) {
                    stackOfBracket.pop();
                } else {
                    return false;
                }
            } else {
                stackOfBracket.push(item);
            }
        }
        return stackOfBracket.empty();
    }
    
}
