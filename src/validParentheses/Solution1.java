package validParentheses;

import org.junit.Test;

import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Stack;

public class Solution1 {

    public boolean isValid(String s) {
        if (s.length() == 0) return true;                 //如果字符串为空,返回true
        Stack<Character> stack = new Stack<>();         //创建栈对象:stack
        for (int i = 0; i < s.length(); i++) {          //遍历传进来的字符串的每一个字符
            char c = s.charAt(i);                       //取出单个字符
            if (c == '(') {                             //如果匹配到'(' 开始的小括号
                stack.push(')');                       //向栈中入栈一个')'
            } else if (c == '[') {                      //如果匹配到'['
                stack.push(']');                       //入栈']'
            } else if (c == '{') {                      //如果匹配到'{'
                stack.push('}');                       //入栈'}'
            } else if (stack.isEmpty()                  //如果匹配到的字符不是'(','[','{' 这几个开始括号
                    || c != stack.pop()) {                  //如果栈为空,或者当前单个字符,不等于出栈的字符
                return false;                               //说明不是一个所有括号有效闭合的字符串
            }
        }
        return stack.isEmpty();                         //最后遍历完字符串,如果栈为空,就返回true,不为空,表示还要元素没有出栈,返回false
    }

    @Test
    public void testSolution1() {
        String string = "{}{}{}()([]";

        boolean valid = isValid(string);
        System.out.println(valid);
    }

    @Test
    public void testSolution2() {
        String string = "{}{}{}()[]";

        boolean valid = isValid(string);
        System.out.println(valid);
    }
}
