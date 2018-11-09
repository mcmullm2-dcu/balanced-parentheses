using System;
using System.Collections.Generic;

/// <summary>
/// Program to check if an input string that contains only (round), [square] or
/// {curly} brackets is balanced.A balanced string indicates that each opening
/// bracket has a corresponding closing bracket, and that no pair of brackets
/// overlap.
/// </summary>
public class Brackets
{

    public static void Main(string[] args)
    {
        String s1 = "([{}])";
        String s2 = "([]){}";
        String s3 = "[(])";
        String s4 = "[()]{}{[()()]()}";
        String s5 = "([]){}(";

        Console.WriteLine(IsBalanced(s1)); // true
        Console.WriteLine(IsBalanced(s2)); // true
        Console.WriteLine(IsBalanced(s3)); // false
        Console.WriteLine(IsBalanced(s4)); // true
        Console.WriteLine(IsBalanced(s5)); // false
    }

    /// <summary>
    /// Indicates whether an input string containing only parentheses is
    /// balanced. In other words, each opening bracket has a corresponding
    /// closing bracket, and different pairs don't overlap.
    /// </summary>
    /// <param name="s">The input string to test. Assume it doesn't contain any
    /// other characters other than (round), [square] and {curly} brackets.
    /// </param>
    /// <returns><c>true</c> if the input string is balanced. Otherwise,
    /// <c>false</c>.</returns>
    public static bool IsBalanced(String s)
    {
        Stack<char> x = new Stack<char>();
        foreach (char c in s.ToCharArray())
        {
            if (IsOpeningBracket(c))
            {
                x.Push(c);
            }
            else
            {
                char opening = x.Pop();
                if (!IsMatching(opening, c))
                    return false;
            }
        }
        return x.Count == 0;
    }

    /// <summary>
    /// Determine if an input character is one of the three supported opening
    /// brackets.
    /// </summary>
    /// <param name="c">The character to test.</param>
    /// <returns><c>true</c> if the input character is an opening bracket.
    /// Otherwise. <c>false</c>.</returns>
    public static bool IsOpeningBracket(char c)
    {
        return (c == '(' || c == '[' || c == '{');
    }

    /// <summary>
    /// Check if a given opening and closing bracket match. For example, if the
    /// opening character is '(', check if the closing character is ')'.
    /// </summary>
    /// <param name="opening">The opening character to test.</param>
    /// <param name="closing">The closing character to test.</param>
    /// <returns><c>true</c> if the closing character is the correct match for
    /// the opening character. Otherwise, <c>false</c>.</returns>
    public static bool IsMatching(char opening, char closing)
    {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }
}
