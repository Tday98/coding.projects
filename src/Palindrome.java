/**
 * Created by tristanday on 4/12/17.
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        if (s.charAt(0) != s.charAt(s.length()-1))
            return false;
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main (String[] args) {
        String s = "hannah";
        System.out.print(isPalindrome(s));
    }
}
