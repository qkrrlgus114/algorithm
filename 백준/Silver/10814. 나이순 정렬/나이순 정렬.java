import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List<Person> person = new ArrayList<>();

        int index = 1;
        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            person.add(new Person(index++, Integer.parseInt(sa[0]), sa[1]));
        }

        Collections.sort(person, new Comparator<Person>(){
            public int compare(Person o1, Person o2){
                if(o1.age == o2.age){
                    return o1.index - o2.index;
                }
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Person per : person){
            sb.append(per.age).append(" ").append(per.name).append("\n");
        }

        System.out.println(sb);
    }

}

class Person{
    int index;
    int age;
    String name;

    public Person(int index, int age, String name){
        this.index = index;
        this.age = age;
        this.name = name;
    }
}