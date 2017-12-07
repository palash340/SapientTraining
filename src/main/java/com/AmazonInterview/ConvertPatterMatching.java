package com.AmazonInterview;

import java.util.HashMap;
import java.util.Map;

public class ConvertPatterMatching {
    public static void main(String[] args) {
        String str = "GeeksforGeeks", pat = "GfG";

        int n = str.length()-1, m = pat.length()-1;

        if(!patternMatch(str, pat, n, m)){
            System.out.println("Solution does not exits");
        }

        /*if(!isMatch(str, pat, n, m)){
            System.out.println("Solution does not exits");
        }*/

    }

    static boolean patternMatch(String str, String pat, int n, int m)
    {
        if (n < m)
            return false;

        // create an empty hashmap
        Map<Character, String> map = new HashMap<>();

        // store result in a boolean variable res
        boolean res = patternMatchUtil(str, n, 0, pat, m, 0, map);

        // if solution exists, print the mappings
        if(res)
            map.keySet().stream().forEach(key -> System.out.println(key + "->" + map.get(key)));

        // return result
        return res;
    }

    static boolean patternMatchUtil(String str, int n, int i,
                          String pat, int m, int j,
                          Map<Character, String> map)
    {
        // If both string and pattern reach their end
        if (i == n && j == m)
            return true;

        // If either string or pattern reach their end
        if (i == n || j == m)
            return false;

        // read next character from the pattern
        char ch = pat.charAt(j);

        // if character is seen before
        if (map.containsKey(ch))
        {
            String s = map.get(ch);
            int len = s.length();

            // consider next len characters of str
            String subStr = str.substring(i, len);

            // if next len characters of string str
            // don't match with s, return false
            if (subStr.equals(s))
                return false;

            // if it matches, recurse for remaining characters
            return patternMatchUtil(str, n, i + len, pat, m,
                    j + 1, map);
        }

        // If character is seen for first time, try out all
        // remaining characters in the string
        for (int len = 0; len <= n - i; len++)
        {
            // consider substring that starts at position i
            // and spans len characters and add it to map
            map.put(ch, str.substring(i,len));

            // see if it leads to the solution
            if (patternMatchUtil(str, n, i + len, pat, m,
                    j + 1, map))
                return true;

            // if not, remove ch from the map
            System.out.println(map.get(ch));
            map.remove(ch);
        }
        return false;
    }

   /* static Boolean isMatch(String str, int iStr, String ptn, int iPtn, HashMap<Character, String> hmap){
        if(iStr == str.length() && iPtn == ptn.length()) return true;
        if(iStr == str.length() || iPtn == ptn.length()) return false;
        char c = ptn.charAt(iPtn);
        if(hmap.containsKey(c)){
            String toMatch = hmap.get(c);
            for (int i = 0; i < toMatch.length(); i++) {
                if (iStr >= str.length() || str.charAt(iStr) != toMatch.charAt(i))
                    return false;
                iStr++;
            }
            return isMatch(str, iStr, ptn, iPtn+1, hmap);
        }
        //try all possiblities
        boolean flag = false;
        for (int i = iStr; i < str.length(); i++){
            hmap.put(c, str.substring(iStr, i - iStr + 1));
            flag |= isMatch(str, i + 1, ptn, iPtn + 1, hmap);
            hmap.remove(c);
            if(flag)
                return true;
        }
        return false;
    }

    static boolean isMatch(String str, String ptn, int n, int m){
        if(n < m)
            return false;
        if(n == 0 && m == 0)
            return true;
        if(n == 0 || m == 0)
            return false;
        if(m == 1 && n > 0)
            return true;

        HashMap<Character, String> hmap = new HashMap<>();
        return isMatch(str, 0, ptn, 0, hmap);
    }*/
}
