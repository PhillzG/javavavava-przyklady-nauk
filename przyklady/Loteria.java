public class Loteria {
    public static void main(String[] args) {
       int[][] lotteryCard = {{23,14,2},{22,42,222},{1,2,3}};
       
       
        int[][] lotteryCard2 = new int[3][3];


        System.out.println(lotteryCard[0][0]);

        System.out.println("--------");
        for(int i = 0; i<3; i++) {
            System.out.println(lotteryCard[i][i]);
        }
        System.out.println("--------");

        for(int i =0;i<3; i++){
            for(int j = 0; j <3; j++){
                System.out.println(lotteryCard[i][j]);
            }
        }


    }
}
