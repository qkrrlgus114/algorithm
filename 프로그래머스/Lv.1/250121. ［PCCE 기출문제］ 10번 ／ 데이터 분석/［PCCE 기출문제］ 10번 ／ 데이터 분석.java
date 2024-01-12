import java.util.*;

class Solution {
    static int[][] new_data;
    static int[] new_sort_arr;
    static int ext_count = 0;
    static int sort_by_index = 0;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // code = 0, date = 1, maximum = 2, reamin = 3
        
        if(ext.equals("code")){
            check(data, 0, val_ext);    
        }else if(ext.equals("date")){
            check(data, 1, val_ext);    
        }else if(ext.equals("maximum")){
            check(data, 2, val_ext);    
        }else if(ext.equals("remain")){
            check(data, 3, val_ext);    
        }
        
        
        
        if(sort_by.equals("code")) sort_by_index = 0;
        else if(sort_by.equals("date")) sort_by_index = 1;
        else if(sort_by.equals("maximum")) sort_by_index = 2;
        else sort_by_index = 3;
        
        Arrays.sort(new_data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[sort_by_index], b[sort_by_index]);
            }
        });
        
        return new_data;
    }
    
    public static void check(int[][] data, int index, int val_ext){
        int temp = 0;
        for(int i=0; i<data.length; i++){
            if(val_ext > data[i][index]){
                ext_count++;
            }
        }
        new_data = new int[ext_count][4];
        for(int i=0; i<data.length; i++){
            if(val_ext > data[i][index]){
                new_data[temp++] = data[i];
            }
        }
    }
}