class Solution {
    public String solution(int a, int b) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day =  {" ","FRI", "SAT","SUN","MON","TUE","WED","THU"};
        int tempDay = 0;
        for(int i=1; i<=a; i++){
            if(i==a){
                tempDay+=b;
            }else{
                tempDay += month[i];
            }
        }
        tempDay %= 7;
        if(tempDay==0){
            return day[7];
        }else{
        return day[tempDay];
        }
    }
}