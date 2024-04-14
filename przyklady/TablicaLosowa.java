import java.util.Arrays;
import java.util.Random;

public class TablicaLosowa {

    public static void main(String[] args) {
        int[][] tablica = utworzTablice(4, 4);
        
        System.out.println("Tablica przed sortowaniem:");
        drukujTablice(tablica);

        // Sortowanie tablicy rosnąco
        sortujTablice(tablica);

        System.out.println("\nTablica po sortowaniu:");
        drukujTablice(tablica);
    }
// metoda ktora robi tablice losową
    private static int[][] utworzTablice(int wiersze, int kolumny) {
        int[][] tablica = new int[wiersze][kolumny];
        Random rand = new Random();

        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                tablica[i][j] = rand.nextInt(100); // Losowa liczba z zakresu 0-99
            }
        }

        return tablica;
    }
//  metoda ktora printuje tablice
    private static void drukujTablice(int[][] tablica) {
        for (int[] wiersz : tablica) {
            for (int element : wiersz) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
// metoda ktora ją sortuje
    private static void sortujTablice(int[][] tablica) {
        for (int[] wiersz : tablica) {
            Arrays.sort(wiersz);
        }
    }
}
