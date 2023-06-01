class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 1. 한 번 사용하면 재사용 불가
        // 2. 뽑은 카드는 무조건 사용
        // 3. 순서 바꾸기 불가
        int cards1Index = 0;
        int cards2Index = 0;
        for(int i=0; i<goal.length; i++){
            if(goal[i].equals(cards1[cards1Index])){
                if(cards1Index!=cards1.length-1){
                    cards1Index++;
                }
            }else if(goal[i].equals(cards2[cards2Index])){
                if(cards2Index!=cards2.length-1){
                    cards2Index++;
                }
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}