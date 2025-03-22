import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int k;
    static Set<String> set = new HashSet<>();
    static Map<String, Integer> answerMap = new HashMap<>();
    static List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] X = bf.readLine().toCharArray();
        char[] Y = bf.readLine().toCharArray();
        char[] Z = bf.readLine().toCharArray();

        k = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        combination(0, 0, sb, X);
        sb.setLength(0);
        combination(0, 0, sb, Y);
        sb.setLength(0);
        combination(0, 0, sb, Z);

        for (String key : answerMap.keySet()) {
            answers.add(key);
        }

        Collections.sort(answers);

        sb.setLength(0);
        for (String answer : answers) {
            sb.append(answer).append("\n");
        }

        System.out.println(answers.isEmpty() ? -1 : sb);

    }

    public static void combination(int depth, int index, StringBuilder sb, char[] target) {
        if (depth == k) {
            if (set.contains(sb.toString()) && !answerMap.containsKey(sb.toString())) {
                answerMap.put(sb.toString(), 0);
            } else {
                set.add(sb.toString());
            }
            return;
        }

        for (int i = index; i < target.length; i++) {
            sb.append(target[i]);
            combination(depth + 1, i + 1, sb, target);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
