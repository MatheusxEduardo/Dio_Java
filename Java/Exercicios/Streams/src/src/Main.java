import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Ninja> ninjas = new ArrayList<>();
        ninjas.add(new Ninja("Naruto", "Konoha", 14));
        ninjas.add(new Ninja("Sasuke", "Konoha", 16));
        ninjas.add(new Ninja("Kakashi", "Konoha", 32));
        ninjas.add(new Ninja("Sakura", "Konoha", 15));
        ninjas.add(new Ninja("Gaara", "Suna", 17));
        ninjas.add(new Ninja("Temari", "Suna", 16));
        ninjas.add(new Ninja("Zabuza", "Nevoa", 32));

        ninjas.stream()
                .filter(ninja -> ninja.getAldeia().equals("Nevoa"))
                .forEach(System.out::println);

        ninjas.stream()
                .sorted((n1, n2) -> Integer.compare(n1.getIdade(), n2.getIdade()))
                .forEach(System.out::println);


    }
}