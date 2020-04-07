package validParentheses;

import org.junit.Test;

import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Stack;

public class Solution1 {

    public boolean isValid(String s){
        if (s.length()==0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testSolution1(){
        String string = "{}{}{}()([]";

        boolean valid = isValid(string);
        System.out.println(valid);
    }

    @Test
    public void testSolution2(){
        String string = "{}{}{}()[]";

        boolean valid = isValid(string);
        System.out.println(valid);
    }
}
