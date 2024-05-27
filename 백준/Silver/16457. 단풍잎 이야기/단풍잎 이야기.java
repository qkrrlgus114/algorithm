import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[][] quests;
    static boolean[] skills;
    static List<Integer> choiceSkill = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        k = Integer.parseInt(sa[2]);

        skills = new boolean[2 * n + 1];
        quests = new int[m][k];
        for (int i = 0; i < m; i++) {
            sa = bf.readLine().split(" ");
            for (int j=0; j<k; j++){
                quests[i][j] = Integer.parseInt(sa[j]);
            }
        }

        dfs(1, 0);
        System.out.println(answer);


    }

    private static void dfs(int depth, int choice) {
        // 종료 조건
        if (choice == n) {
            int count = 0;
            for (int i = 0; i < quests.length; i++) {
                int[] quest = quests[i];
                boolean check = true;
                for (int j = 0; j < quest.length; j++) {
                    if (!choiceSkill.contains(quest[j])){
                        check = false;
                        break;
                    }
                }
                if(check) count++;
            }

            answer = Math.max(answer, count);
            return;
        }

        // 재귀 조건
        for (int i = depth; i <= 2 * n; i++) {
            if (skills[i]) continue;
            skills[i] = true;
            choiceSkill.add(i);
            dfs(i + 1, choice + 1);
            choiceSkill.remove(choiceSkill.size() - 1);
            skills[i] = false;
        }
    }

}


