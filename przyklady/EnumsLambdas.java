import java.util.Arrays;
import java.util.Comparator;

// Define enum for Sex
enum Sex {
    F, M;

    @Override
    public String toString() {
        return switch (this) {
            case F -> "Female";
            case M -> "Male";
        };
    }
}

// Define enum for Size
enum Size {
    XS, S, M, L, XL;
}

// Define enum for Country with custom toString method
enum Country {
    PL, NL, DE;

    @Override
    public String toString() {
        return switch (this) {
            case PL -> "Polska";
            case NL -> "Nederland";
            case DE -> "Deutschland";
        };
    }
}

// Define class Person
class Person {
    String name;
    Sex sex;
    Size size;
    Country country;

    Person(String name, Sex sex, Size size, Country country) {
        this.name = name;
        this.sex = sex;
        this.size = size;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", name, sex, size, country);
    }
}

public class EnumsLambdas {

    // Generic static function to print array with a title
    public static <T> void printArray(String title, T[] array) {
        System.out.println(title);
        for (T element : array) {
            System.out.println(element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Person[] persons = {
            new Person("Max", Sex.M, Size.XL, Country.NL),
            new Person("Jan", Sex.M, Size.S, Country.PL),
            new Person("Eva", Sex.F, Size.XS, Country.NL),
            new Person("Lina", Sex.F, Size.L, Country.DE),
            new Person("Mila", Sex.F, Size.S, Country.DE),
            new Person("Ola", Sex.F, Size.M, Country.PL)
        };

        // Comparator by sex, then size using lambda expressions
        Comparator<Person> sexThenSize = Comparator
                .comparing((Person p) -> p.sex)
                .thenComparing((Person p) -> p.size);
        Arrays.sort(persons, sexThenSize);
        printArray("Persons by sex and then size", persons);

        // Comparator by size, then name using lambda expressions
        Comparator<Person> sizeThenName = Comparator
                .comparing((Person p) -> p.size)
                .thenComparing((Person p) -> p.name);
        Arrays.sort(persons, sizeThenName);
        printArray("Persons by size and then name", persons);

        // Comparator for Country based on the custom toString
        Comparator<Country> countryByName = Comparator
                .comparing(Country::toString);
        Country[] countries = Country.values();
        Arrays.sort(countries, countryByName);
        printArray("Countries by name", countries);
    }
}