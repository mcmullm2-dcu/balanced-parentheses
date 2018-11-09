import java.util.*;

/**
 * Program to check if an input string that contains only (round), [square] or
 * {curly} brackets is balanced. A balanced string indicates that each opening
 * bracket has a corresponding closing bracket, and that no pair of brackets
 * overlap.
 */
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

    /**
     * Indicates whether an input string containing only parentheses is
     * balanced. In other words, each opening bracket has a corresponding
     * closing bracket, and different pairs don't overlap.
     * 
     * @param s
     *            The input string to test. Assume it doesn't contain any other
     *            characters other than (round), [square] and {curly} brackets.
     * @return true if the input string is balanced; otherwise false.
     */
    public static boolean isBalanced(String s) {
        Stack<Character> x = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (isOpeningBracket(c)) {
                x.push(c);
            } else {
                char opening = x.pop();
                if (!isMatching(opening, c))
                    return false;
            }
        }
        return x.size() == 0;
    }

    /**
     * Determine if an input character is one of the three supported opening
     * brackets.
     * 
     * @param c
     *            The character to test.
     * @return true if the input character is an opening bracket. Otherwise,
     *         false.
     */
    public static boolean isOpeningBracket(char c) {
        return (c == '(' || c == '[' || c == '{');
    }

    /**
     * Check if a given opening and closing bracket match. For example, if the
     * opening character is '(', check if the closing character is ')'.
     * 
     * @param opening
     *            The opening character to test.
     * @param closing
     *            The closing character to test.
     * @return true if the closing character is the correct match for the
     *         opening character. Otherwise, false.
     */
    public static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }
}
