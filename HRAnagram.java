import java.util.Arrays;

public class HRAnagram {
     static public  void main(String[] args) {
        String s1 = "night";
        String s2 = "thing";

        if (isAnagram(s1, s2))
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }

    static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        
        if (s1.length() != s2.length())
            return false;
        
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}

