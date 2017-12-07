package com.AmazonInterview;

import java.util.HashMap;

public class CopyPatterMatching {
    public static void main(String[] args) {
        CopyPatterMatching copyPatterMatching = new CopyPatterMatching();
        String str = "GeeksforGeeks";
        String pat = "abba";
        System.out.println(copyPatterMatching.isMatched(str, pat));
    }

    public int isMatched(String p, String input) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        HashMap<Character, String> toMatch = new HashMap<Character, String>();
        char first = p.charAt(0);
        int count = map.get(first);
        for (int i = 1; i <= input.length() / count; i++) {
            toMatch.put(first, input.substring(0, i));
            if (startToMatch(p, 1, input, i, toMatch, map, input.length()
                    - count * i)) {
                return 1;
            }
            toMatch.clear();
        }
        return 0;
    }

    private boolean startToMatch(String p, int i, String input, int j,
                                 HashMap<Character, String> toMatch,
                                 HashMap<Character, Integer> map, int left) {
        if (i == p.length()) {
            return j == input.length();
        }
        char first = p.charAt(i);
        if (toMatch.containsKey(first)) {
            String s = toMatch.get(first);
            int len = s.length();
            if (j + len > input.length()) {
                return false;
            } else {
                if (!s.equalsIgnoreCase(input.substring(j, j + len))) {
                    return false;
                } else {
                    return startToMatch(p, i + 1, input, j + len, toMatch, map,
                            left);
                }
            }
        } else {
            int count = map.get(first);
            for (int k = 1; k <= left / count; k++) {
                toMatch.put(first, input.substring(j, j + k));
                if (startToMatch(p, i + 1, input, j + k, toMatch, map, left
                        - count * k)) {
                    return true;
                }
                toMatch.remove(first);
            }
            return false;
        }
    }
}
