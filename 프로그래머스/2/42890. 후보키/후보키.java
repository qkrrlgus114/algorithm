import java.util.*;

class Solution {
    
    static int N, M;
    static List<int[]> candidateKey = new ArrayList<>();
    static List<int[]> combList = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(String[][] relation) {
        N = relation.length;
        M = relation[0].length;
        visited = new boolean[M];
        
        for(int j=0; j<M; j++){
            if(isUniqueness(relation, j)){
                candidateKey.add(new int[]{j});
                visited[j] = true;
            }
        }
        combination(0, 0, new ArrayList<>());
        
        Collections.sort(combList, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1.length == o2.length){
                    for(int i=0; i<o1.length; i++){
                        if(o1[i] != o2[i]){
                            return o1[i] - o2[i];
                        }
                    }
                }
                return o1.length - o2.length;
            }
        });
        // for(int i=0; i<combList.size(); i++){
        //     System.out.println(Arrays.toString(combList.get(i)));
        // }
        
        for(int i=0; i<combList.size(); i++){
            if(isMinimality(combList.get(i), relation)){
                if(combiUniqueness(combList.get(i))){
                    candidateKey.add(combList.get(i));
                }
            }
        }
        
        return candidateKey.size();
    }
    
    // 하나의 경우 유일성 판단
    private static boolean isUniqueness(String[][] relation, int j){
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            if(set.contains(relation[i][j])) return false;
            set.add(relation[i][j]);
        }
        return true;
    }
    
    // 조합
    private static void combination(int depth, int start, List<Integer> list){
        if(depth > 0){
            int[] tempArr = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                tempArr[i] = list.get(i);
            }
            combList.add(tempArr);
        }
        
        for(int i = start; i < M; i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(i);
            combination(depth + 1, i + 1, list);
            visited[i] = false;
            list.remove(list.size() - 1); 
        }
    }
    
    // 최소성 판단
    private static boolean isMinimality(int[] tempArr, String[][] relation){
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++){
            for(int num : tempArr){
                sb.append(relation[i][num]);
            }
            if(set.contains(sb.toString())) return false;
            set.add(sb.toString());
            sb.setLength(0);
        }
        return true;
    }
    
    // 조합의 유일성 판단
    private static boolean combiUniqueness(int[] target){
        for(int[] candidate : candidateKey){
            int count = 0;
            for(int i=0; i<candidate.length; i++){
                for(int j=0; j<target.length; j++){
                    if(candidate[i] == target[j]) count++;
                }
            }
            if(count == candidate.length) return false;
        }
        return true;
        
    }

}