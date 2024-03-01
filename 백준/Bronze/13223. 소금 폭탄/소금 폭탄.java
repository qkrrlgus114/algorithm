

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(":");
        int cur_hour = Integer.parseInt(inputs[0]);
        int cur_min = Integer.parseInt(inputs[1]);
        int cur_sec = Integer.parseInt(inputs[2]);
        inputs = br.readLine().split(":");
        int drop_hour = Integer.parseInt(inputs[0]);
        int drop_min = Integer.parseInt(inputs[1]);
        int drop_sec = Integer.parseInt(inputs[2]);

        if(cur_hour == drop_hour && cur_min == drop_min && cur_sec == drop_sec){
            System.out.println("24:00:00");
        }else{

            int need_hour = drop_hour - cur_hour;
            int need_min = drop_min - cur_min;
            int need_sec = drop_sec - cur_sec;
            if(need_sec < 0){
                need_sec += 60;
                need_min--;
            }
            if(need_min < 0){
                need_min += 60;
                need_hour--;
            }
            if(need_hour < 0){
                need_hour += 24;
            }

            StringBuilder sb = new StringBuilder();
            if(need_hour < 10) sb.append("0" + need_hour + ":");
            else sb.append(need_hour + ":");
            if(need_min < 10) sb.append("0" + need_min + ":");
            else sb.append(need_min + ":");
            if(need_sec < 10) sb.append("0" + need_sec);
            else sb.append(need_sec);

            System.out.println(sb.toString());
        }



    }


}
