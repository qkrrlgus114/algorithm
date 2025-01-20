import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Map<String, Integer> map = new LinkedHashMap<>();
        int index = 1;
        for (int i = 0; i < N; i++) {
            map.put(bf.readLine(), index++);
        }

        int result = 0;

        List<String> cars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cars.add(bf.readLine());
        }

        while (cars.size() != 1) {
            String car = cars.get(0);
            // carsNames를 돌면서 하나라도 낮은 순위가 있다면 추월로 판정
            boolean remove = false;
            for (String carName : cars) {
                if (map.get(car) > map.get(carName)) {
                    result++;
                    cars.remove(0);
                    remove = true;
                    break;
                }
            }
            if (!remove) cars.remove(0);
        }

        System.out.println(result);

    }


}