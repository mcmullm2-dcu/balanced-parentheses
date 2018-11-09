import java.util.*;

public class Brackets {

    public static void main(String[] args) {
        String s1 = "([{}])";
        String s2 = "([]){}";
        String s3 = "[(])";
        String s4 = "[()]{}{[()()]()}";
        String s5 = "([]){}(";
        
        System.out.println(isBalanced(s1)); // true
        System.out.println(isBalanced(s2)); // true
        System.out.println(isBalanced(s3)); // false
        System.out.println(isBalanced(s4)); // true
        System.out.println(isBalanced(s5)); // false
    }

    public static boolean isBalanced(String s) {
        Stack<Character> x = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (isOpeningBracket(c)) {
                x.push(c);
            } else {
                char opening = x.pop();
                if (!isMatching(opening, c)) return false;
            }
        }
        return x.size() == 0;
    }
    
    public static boolean isOpeningBracket(char c) {
        return (c == '(' || c == '[' || c == '{');
    }
    
    public static boolean isMatching(char c1, char c2) {
        return (c1 == '(' && c2 == ')')
                || (c1 == '[' && c2 == ']')
                || (c1 == '{' && c2 == '}');
    }
}
