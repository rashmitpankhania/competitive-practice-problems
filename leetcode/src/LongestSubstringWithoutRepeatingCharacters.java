import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){ // faster
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0,j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j)),i);
            }
            res = Math.max(res, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return res;
    }
//    public int lengthOfLongestSubstring(String s) {
//        HashSet<Character> hashSet = new HashSet<>();
//        int res = 0;
//        int i=0,j=0;
//        int n = s.length();
//        while (i < n && j < n){
//            if(hashSet.contains(s.charAt(j))){
//                hashSet.remove(s.charAt(i++));
//            }else{
//                hashSet.add(s.charAt(j++));
//                res = Math.max(res, j-i);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(bufferedReader.readLine()));
    }
}
