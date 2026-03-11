import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static int[] point = {10, 8, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Time> timeList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            String[] sa = bf.readLine().split(" ");
            String[] times = sa[0].split(":");
            Time time = new Time(Integer.parseInt(times[0]), Integer.parseInt(times[1]),
                    Integer.parseInt(times[2]), sa[1]);
            timeList.add(time);
        }

        timeList.sort(new Comparator<Time>() {
            public int compare(Time t1, Time t2) {
                if (t1.minute == t2.minute) {
                    if (t1.second == t2.second) {
                        return t1.nano - t2.nano;
                    }
                    return t1.second - t2.second;
                }
                return t1.minute - t2.minute;
            }
        });

        int rPoint = 0;
        int bPoint = 0;
        String first = "";

        for (int i = 0; i < timeList.size(); i++) {
            Time time = timeList.get(i);
            if (time.team.equals("B")) {
                if (i == 0) first = "Blue";
                bPoint += point[i];
            } else {
                if (i == 0) first = "Red";
                rPoint += point[i];
            }
        }

        if (rPoint > bPoint) {
            System.out.println("Red");
        } else if (bPoint > rPoint) {
            System.out.println("Blue");
        } else {
            System.out.println(first);
        }


    }

}

class Time {
    int minute;
    int second;
    int nano;
    String team;

    public Time(int minute, int second, int nano, String team) {
        this.minute = minute;
        this.second = second;
        this.nano = nano;
        this.team = team;
    }

    public String toString() {
        return "m : " + minute + ", s : " + second + ", n : " + nano;
    }
}