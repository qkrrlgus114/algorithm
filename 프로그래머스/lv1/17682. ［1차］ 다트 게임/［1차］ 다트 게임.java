import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int sum = 0;
        String[] arr = new String[3];
        int count = 0;
        int temp = 0;
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D'|| dartResult.charAt(i) == 'T'){
                if(i+1 < dartResult.length() && (dartResult.charAt(i+1) == '*' ||  dartResult.charAt(i+1) ==                   '#')){ // #이나 * 붙은 경우
                    arr[count++] = dartResult.substring(temp, i+2);
                    temp = i+2;
                }else{
                    arr[count++] = dartResult.substring(temp,i+1);
                    temp = i+1;
                }
            }
        }
        String tempStr = "";
        int[] point = new int[3];
        for(int i=0; i<3; i++){
            tempStr = arr[i];
            if(arr[i].charAt(arr[i].length()-1) == '*'){
                if(tempStr.charAt(tempStr.length()-2) == 'S'){
                    point[i] = Integer.parseInt(tempStr.substring(0, tempStr.length()-2))*2;
                }else if(tempStr.charAt(tempStr.length()-2) == 'D'){
                    point[i] = (int)Math.pow(Integer.parseInt(tempStr.substring(0, tempStr.length()-2)),2)*2;
                }
                else if(tempStr.charAt(tempStr.length()-2) == 'T'){
                    point[i] = (int)Math.pow(Integer.parseInt(tempStr.substring(0, tempStr.length()-2)),3)*2;
                }
                if(i>0){
                    point[i-1]*=2;
                }
            }else if(arr[i].charAt(arr[i].length()-1) == '#'){
                if(tempStr.charAt(tempStr.length()-2) == 'S'){
                    point[i] = Integer.parseInt(tempStr.substring(0, tempStr.length()-2))*-1;
                }else if(tempStr.charAt(tempStr.length()-2) == 'D'){
                    point[i] = (int)Math.pow(Integer.parseInt(tempStr.substring(0, tempStr.length()-2)),2)*-1;
                }
                else if(tempStr.charAt(tempStr.length()-2) == 'T'){
                    point[i] = (int)Math.pow(Integer.parseInt(tempStr.substring(0, tempStr.length()-2)),3)*-1;
                }
            }else{
                if(tempStr.charAt(tempStr.length()-1) == 'S'){
                    point[i] = Integer.parseInt(tempStr.substring(0, tempStr.length()-1))*1;
                }else if(tempStr.charAt(tempStr.length()-1) == 'D'){
                    point[i] = (int)Math.pow(Integer.parseInt(tempStr.substring(0, tempStr.length()-1)),2);
                }
                else if(tempStr.charAt(tempStr.length()-1) == 'T'){
                    point[i] = (int)Math.pow(Integer.parseInt(tempStr.substring(0, tempStr.length()-1)),3);
                }
            }
        }
        sum = point[0] + point[1] + point[2];
        return sum;
    }
}