package utils.arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CheckPalindrome
{
    public static void main(String[] args)
    {

        if (args == null || !(args.length > 0)) {
            System.out.print("Not valid input");
            return;
        }

        String input = args[0];
        String longestPalindrome = CheckPalindrome.check(input);
        System.out.println("Longest Palindrome is:" + longestPalindrome);
    }

    public static String check(String in)
    {
        // logic
        Map<Integer, List<Integer>> palindromes = new HashMap<>();
        char[] arr = in.toCharArray();
        for (int s = 0; s < arr.length; s++) {
            for (int ptr = s+1; ptr < arr.length; ptr++) {
                if (find(arr, s, ptr)) {
                    List<Integer> a = new LinkedList<>();
                    a.add(s);
                    a.add(ptr);
                    palindromes.put(ptr - s, a);
                } else {
                    ptr++;
                }
            }
        }

        Iterator<Entry<Integer, List<Integer>>> t = palindromes.entrySet().iterator();
        Integer max = 0;
        while (t.hasNext()) {
            Entry<Integer, List<Integer>> e = t.next();
            if (e.getKey() > max) {
                max = e.getKey();
            }
        }
        List<Integer> maxList = palindromes.get(max);
        System.out.println("maxx:"+maxList.get(0) +" -- "+ maxList.get(1));
        String retString = in.substring(maxList.get(0)-1, maxList.get(1)+1);
        return retString;

    }

    private static boolean find(char[] arr, int s, int ptr)
    {
        for (int i = s; i < (ptr - s) / 2; i++) {
            if (arr[i] == arr[ptr - i]) {
                continue;
            }
            return false;
        }
        return true;
    }
}
