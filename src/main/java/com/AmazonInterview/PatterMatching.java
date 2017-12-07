package com.AmazonInterview;

import java.util.HashMap;
import java.util.Map;

public class PatterMatching {
    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        String pat = "GfGG";
        if(!patterMatch(str, pat, str.length()-1, pat.length()-1)){
            System.out.println("Solution does not exists");
        }
    }

    static boolean patterMatch(String str, String pat, int n, int m){
        if(m > n)
            return false;
        Map<Character, String> map = new HashMap<>();
        
        boolean resp = patterMatchUtil(str, n, 0, pat , m , 0, map);
        if(resp)
            map.keySet().stream().forEach(key -> System.out.println(map.get(key)));
        return resp;
    }

    private static boolean patterMatchUtil(String str, int n, int i, String pat, int m, int j, Map<Character, String> map) {
        // Both String and Pattern reach their end
        if(i == n && j == m)
            return true;
        // If either of string or pattern reach to their end
        if(i == n || j == m)
            return false;

        // Read next character from pattern
        char ch = pat.charAt(j);

        // If character is seen before
        if(map.containsKey(ch)){
            String s = map.get(ch);
            int len = s.length();

            // consider next len character for string
            String subStr = str.substring(i, len);

            // If next len char of str doesn't match with s return false
            if(subStr.equals(s))
                return false;

            // If it a matches, recursion for remaining chars
            return patterMatchUtil(str, n, i+len, pat, m, j+1, map);
        }

        // If character is seen first time, try out remaining character in str
        for (int k = 1; k <= n-i ; k++) {
            // consider substring that starts at position i and spans len chars and add it to map
            map.put(ch, str.substring(i, k));

            // see if it leads to a solution
            if (patterMatchUtil(str, n, i+k, pat , m , j+1, map )){
                return true;
            }
            map.remove(ch);
        }


        return false;
    }
}
