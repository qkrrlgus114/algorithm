import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person{
    int age;
    String name;
    int seq;

    public Person(int age, String name, int seq) {
        this.age = age;
        this.name = name;
        this.seq = seq;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = bf.readLine();
        int N = Integer.parseInt(n);

        List<Person> personList = new ArrayList<>();

        int seq = 1;
        for(int k=0; k<N; k++){
            String[] sa = bf.readLine().split(" ");
            Person person = new Person(Integer.parseInt(sa[0]), sa[1], seq++);
            personList.add(person);
        }

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });

        for(int i=0; i<N; i++){
            sb.append(personList.get(i).age + " " + personList.get(i).name + "\n");
        }

        System.out.println(sb.toString());


    }
}