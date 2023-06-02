class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length; // 행의 길이
        int m = arr1[0].length; // 열의 길이
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return result;
    }
}