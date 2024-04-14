public class Person {
    private String name;
    private String surname;
    private int birthyear;

    // Konstruktor tworzy podane dalej argument w taki spsob jaki chcemy
    public Person(String name, String surname, int birthyear) {
        this.name = name;
        this.surname = surname;
        this.birthyear = birthyear;
    }

    // Metoda toString  printuje wszystkie infomacje
    public String toString() {
        return "Person{name='" + name + "', surname='" + surname + "', birthyear=" + birthyear + "}";
    }

    // Metoda toConsole print  konsoli
    public void toConsole() {
        System.out.println("Person Information:");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Birthyear: " + birthyear);
    }

    // Metoda main w klasie Main  kod w ktorym mozemy sobie ustawiac rzeczy, glowny, tne co dziala nie metoda
    public static void main(String[] args) {
        // Tworzenie obiektu Person
        Person person = new Person("John", "Doe", 1990);

        // Wyświetlanie informacji o osobie za pomocą metody toString
        System.out.println("Person toString(): " + person.toString());

        // Wyświetlanie informacji o osobie za pomocą metody toConsole
        person.toConsole();
    }
}