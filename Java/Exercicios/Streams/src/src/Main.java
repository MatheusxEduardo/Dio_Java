import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Ninja> ninjasOrdenados = ninjas.stream()
                .sorted((n1,n2) -> n1.getNome().compareTo(n2.getNome()))
                .collect(Collectors.toList());
        ninjasOrdenados.forEach(System.out::println);

        ninjas.stream()
                .map(Ninja::getNome)
                .forEach(System.out::println);

    }
}