import java.util.ArrayList;

public class ArrayListProj {
    public static void main(String[] args) {
        String[] fruits = new String[3];
        fruits[0]= "Mango";
        fruits[1]= "Apple";
        fruits[2]= "Strawberry";


        ArrayList fruitlist = new ArrayList();
        fruitlist.add("Mango");
        fruitlist.add("Apple");
        fruitlist.add("Strawberry");
        System.out.println(fruitlist);

    }
}
