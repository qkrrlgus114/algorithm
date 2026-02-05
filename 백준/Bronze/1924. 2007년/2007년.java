import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] months = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    static String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] words = bf.readLine().split(" ");

        int month = Integer.parseInt(words[0]);
        int day = Integer.parseInt(words[1]);

        month = months[month - 1] + day;

        int idx = month % 7 == 0 ? 6 : (month % 7) - 1;

        System.out.println(days[idx]);
    }
}