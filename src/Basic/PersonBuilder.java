class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class PersonBuilder {
    public static Person buildPerson(int id, String name) { // Mudado de private para public
        return new Person(id, name);
    }

    public static void main(String[] args) {
        int id = 23;
        String name = "John";
        Person person = null;
        person = buildPerson(id, name); // Agora funciona
        System.out.println("ID: " + person.id + ", Name: " + person.name); // Opcional: para verificar
    }
}