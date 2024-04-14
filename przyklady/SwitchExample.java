import java.util.Scanner;

public class SwitchExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj numer dnia tygodnia (1-7): ");
        int numerDnia = scanner.nextInt();

        String nazwaDnia = nazwaDniaTygodnia(numerDnia);

        System.out.println("Dzień o numerze " + numerDnia + " to: " + nazwaDnia);
    }

    public static String nazwaDniaTygodnia(int numerDnia) {
        String nazwa;

        switch (numerDnia) {
            case 1:
                nazwa = "Poniedziałek";
                break;
            case 2:
                nazwa = "Wtorek";
                break;
            case 3:
                nazwa = "Środa";
                break;
            case 4:
                nazwa = "Czwartek";
                break;
            case 5:
                nazwa = "Piątek";
                break;
            case 6:
                nazwa = "Sobota";
                break;
            case 7:
                nazwa = "Niedziela";
                break;
            default:
                nazwa = "Nieprawidłowy numer dnia";
        }

        return nazwa;
    }
}