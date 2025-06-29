import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] sa = bf.readLine().split(" ");
        int needSun = Integer.parseInt(sa[0]);
        int needWater = Integer.parseInt(sa[1]);

        int answer1 = needSun + needWater + needWater / 10;
        int answer2 = needSun + needWater + needSun / 10;

        System.out.println(Math.min(answer1, answer2));
    }
}