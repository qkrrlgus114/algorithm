import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Human implements Comparable<Human>{
    private int age;
    private String name;
    private int index;

    public Human(int age, String name, int index){
        this.age = age;
        this.name = name;
        this.index = index;
    }

    public int compareTo(Human h){
        if(age == h.age) {
            return index - h.index;
        }
        return age - h.age;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }
}

public class Main {

    /*
    * 1. 나이 오름차순
    * 2. 가입한 순서
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        List<Human> list = new ArrayList<>();

        int index = 0;

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            list.add(new Human(Integer.parseInt(sa[0]), sa[1], index++));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Human h : list){
            sb.append(h.getAge()).append(" ").append(h.getName()).append("\n");
        }

        System.out.println(sb);

    }
}
