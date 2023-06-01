import java.util.Arrays;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = new int[n][n]; // 지도1
        int[][] map2 = new int[n][n]; // 지도2
        String[] result = new String[n]; // 최종지도
        int index = n-1;
        for(int i=0; i<arr1.length; i++){ // 지도1
            if(arr1[i]==0){
                map1[i][index] = 0;
            }else{
                while(arr1[i]!=1){ // 10진수를 2진수로
                map1[i][index--] = arr1[i]%2; 
                arr1[i]/=2;
            }
            map1[i][index] = 1;
            index = n-1;
            } 
        }
        for(int i=0; i<arr2.length; i++){ // 지도2
            if(arr2[i]==0){
                map2[i][index] = 0;
            }else{
                while(arr2[i]!=1){ // 10진수를 2진수로
                map2[i][index--] = arr2[i]%2; 
                arr2[i]/=2;
            }
            map2[i][index] = 1;
            index = n-1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map1[i][j] == 1 || map2[i][j] == 1){
                    sb.append("#");
                }else if(map1[i][j] == 0 && map2[i][j] == 0){
                    sb.append(" ");
                }
            }
            result[i] = sb.toString();
            sb.setLength(0);
        }
        return result;
    }
}