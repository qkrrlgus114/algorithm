import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        List<Human> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            int weight = Integer.parseInt(sa[0]);
            int height = Integer.parseInt(sa[1]);

            list.add(new Human(weight, height));
        }

        for(int i=0; i<list.size(); i++){
            Human human = list.get(i);
            int count = 0;
            for(int j=0; j<list.size(); j++){
                if(i == j) continue;
                if(human.height < list.get(j).height && human.weight < list.get(j).weight) count++;
            }
            human.winCount = count;
        }

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).winCount + 1).append(" ");
        }

        System.out.println(sb);
    }

}

class Human{
    int weight;
    int height;
    int winCount;
    int ranking;

    public Human(int weight, int height){
        this.weight = weight;
        this.height = height;
    }
}
