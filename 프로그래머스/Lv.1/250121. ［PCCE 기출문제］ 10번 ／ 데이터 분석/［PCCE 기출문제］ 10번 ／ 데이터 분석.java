import java.util.*;

class Solution {
    static int[][] new_data;
    static int[] new_sort_arr;
    static int ext_count = 0;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // code = 0, date = 1, maximum = 2, reamin = 3q
        new_data = new int[data.length][4];
        
        if(ext.equals("code")){
            check(data, 0, val_ext);    
        }else if(ext.equals("date")){
            check(data, 1, val_ext);    
        }else if(ext.equals("maximum")){
            check(data, 2, val_ext);    
        }else if(ext.equals("remain")){
            check(data, 3, val_ext);    
        }
        
        int sort_by_index = 0;
        
        if(sort_by.equals("code")) sort_by_index = 0;
        else if(sort_by.equals("date")) sort_by_index = 1;
        else if(sort_by.equals("maximum")) sort_by_index = 2;
        else sort_by_index = 3;
        
        new_sort_arr = new int[ext_count];
        
        for(int i=0; i<ext_count; i++){
            new_sort_arr[i] = new_data[i][sort_by_index];
        }
        
        Arrays.sort(new_sort_arr);
        
        int[][] result_arr = new int[ext_count][4];
        
        for(int i=0; i<ext_count; i++){
            for(int j=0; j<ext_count; j++){
                if(new_sort_arr[i] == new_data[j][sort_by_index]){
                    result_arr[i] = new_data[j];
                }
            }
        }
        
        
        return result_arr;
    }
    
    public static void check(int[][] data, int index, int val_ext){
        int temp = 0;
        for(int i=0; i<data.length; i++){
            if(val_ext > data[i][index]){
                ext_count++;
                new_data[temp++] = data[i];
            }
        }
    }
}