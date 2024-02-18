class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 손가락의 위치 0-왼손, 1-오른손
        int[][] finger = new int[2][2];
        finger[0][0] = 3;
        finger[0][1] = 0;
        finger[1][0] = 3;
        finger[1][1] = 2;
        
        for(int i=0; i<numbers.length; i++){
            int target = numbers[i];
            if(target == 1){
                finger[0][0] = 0;
                finger[0][1] = 0;
                sb.append("L");
            }else if(target == 4){
                finger[0][0] = 1;
                finger[0][1] = 0;
                sb.append("L");
            }else if(target == 7){
                finger[0][0] = 2;
                finger[0][1] = 0;
                sb.append("L");
            }else if(target == 3){
                finger[1][0] = 0;
                finger[1][1] = 2;
                sb.append("R");
            }else if(target == 6){
                finger[1][0] = 1;
                finger[1][1] = 2;
                sb.append("R");
            }else if(target == 9){
                finger[1][0] = 2;
                finger[1][1] = 2;
                sb.append("R");
            }
            // 2, 5, 8, 0이 들어오면 위치 확인해야함.
            else{
                int target_y = 0;
                int target_x = 0;
                if(target == 2){
                    target_y = 0;
                    target_x = 1;
                }else if(target == 5){
                    target_y = 1;
                    target_x = 1;
                }else if(target == 8){
                    target_y = 2;
                    target_x = 1;
                }else{
                    target_y = 3;
                    target_x = 1;
                }
                // 왼손과의 거리
                int left_dis = Math.abs(target_y - finger[0][0]) + Math.abs(target_x - finger[0][1]);
                // 오른손과의 거리
                int right_dis = Math.abs(target_y - finger[1][0]) + Math.abs(target_x - finger[1][1]);
                if(left_dis > right_dis){
                    finger[1][0] = target_y;
                    finger[1][1] = target_x;
                    sb.append("R");
                }else if(right_dis > left_dis){
                    finger[0][0] = target_y;
                    finger[0][1] = target_x;
                    sb.append("L");
                }else{
                    if("right".equals(hand)){
                        finger[1][0] = target_y;
                        finger[1][1] = target_x;
                        sb.append("R");
                    }else{
                        finger[0][0] = target_y;
                        finger[0][1] = target_x;
                        sb.append("L");
                    }
                }
                    
            }
        }
        return sb.toString();
    }
}