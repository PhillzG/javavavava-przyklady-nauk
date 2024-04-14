public class MinMaxTablica {

    public static void main(String[] args) {
        int[][] tab = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        };

        znajdzMinMax(tab);
    }

    private static void znajdzMinMax(int[][] tab) {
        int min = tab[0][0];
        int max = tab[0][0];

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] < min) {
                    min = tab[i][j];
                }
                if (tab[i][j] > max) {
                    max = tab[i][j];
                }
            }
        }

        System.out.println("Najmniejsza wartość: " + min);
        System.out.println("Największa wartość: " + max);
    }
}
