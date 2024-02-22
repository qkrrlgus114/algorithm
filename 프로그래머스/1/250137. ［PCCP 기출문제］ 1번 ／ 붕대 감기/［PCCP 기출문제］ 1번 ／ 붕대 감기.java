class Solution {
    // 현재 체력
    static int cur_health;
    public int solution(int[] bandage, int health, int[][] attacks) {
        cur_health = health;
        
        // 시간
        int time = 0;
        // 연속 성공 횟수
        int count = 0;
        // 공격 인덱스
        int att_index = 0;
        
        while(true){
            // 공격 인덱스가 끝나면 종료
            if(att_index == attacks.length) break;
            // 현재가 공격 시간이면
            if(attacks[att_index][0] == time){
                cur_health -= attacks[att_index][1];
                // 만약에 체력이 1보다 작으면
                if(cur_health < 1){
                    cur_health = -1;
                    break;
                }
                // 연속 회복 초기화
                count = 0;
                att_index++;
            }
            // 공격시간이 아니면 회복 가능
            else{
                cur_health += bandage[1];
                // 연속 횟수 +1
                count++;
                // 만약에 연속 횟수에 도달했다면
                if(count == bandage[0]){
                    cur_health += bandage[2];
                    count = 0;
                }
                // 최대체력을 넘으면 최대 체력으로 초기화
                if(cur_health > health) cur_health = health;
            }
            time++;
        }
        
        return cur_health;
    }
}