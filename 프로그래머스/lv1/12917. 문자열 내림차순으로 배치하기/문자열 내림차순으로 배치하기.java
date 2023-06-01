import java.util.Arrays;
class Solution {
    public String solution(String s) {
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        return sb.reverse().toString();
    }
}