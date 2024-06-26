class Solution {
    
    static int N;
    static boolean[] visited = new boolean[3];
    static int result = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        N = minerals.length;
        dfs(0, 0, 0, picks, minerals);
        
        return result;
    }
    
    // 피로도, 현재 광석 위치
    private static void dfs(int health, int mineral, int use, int[] picks, String[] minerals){
        // 종료
        if(mineral >= N || use == 3){
            // System.out.println("들어옴");
            // System.out.println(health + " " + use + " " + mineral);
            result = Math.min(result, health);
            return;
        }
        
        // 재귀
        for(int i=0; i<3; i++){
            if(visited[i]) continue;
            if(picks[i] == 0){
                visited[i] = true;
                dfs(health, mineral, use + 1, picks, minerals);
                visited[i] = false;
            }else{
                picks[i]--;
                int pickCount = 5;
                int newHealth = health;
                int countMineral = 0;
                if(picks[i] == 0){
                    visited[i] = true;
                }
                // 곡괭이 쓰고 넘어감
                while(true){
                    if(mineral >= N) break;
                    if(pickCount == 0) break;
                    newHealth += healthCalculator(minerals, i, mineral);
                    mineral++;
                    countMineral++;
                    pickCount--;
                }
                if(visited[i]){
                    dfs(newHealth, mineral, use + 1, picks, minerals);
                }else{
                    dfs(newHealth, mineral, use, picks, minerals);
                }
                visited[i] = false;
                picks[i]++;
                mineral -= countMineral;
            }
        }
    }
    
    // 피로도 계산
    private static int healthCalculator(String[] minerals, int use, int index){
        if(use == 0){
            return 1;
        }else if(use == 1){
            if(minerals[index].equals("diamond")) return 5;
            return 1;
        }else{
            if(minerals[index].equals("diamond")) return 25;
            else if(minerals[index].equals("iron")) return 5;
            return 1;
        }
    }
}