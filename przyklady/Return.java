public class Return {
 public static void main(String[] args) {
    String shouting =caps("whAt, why?");
    System.out.println(shouting);
    int[] awesomeArray = ArrayInts(3,7,1);
    System.out.println(awesomeArray[0]);
    System.out.println(awesomeArray[1]);
    System.out.println(awesomeArray[2]);


//     message();
//     int sum = add(4, 5);
//     System.out.println(sum);
//  }  
//  public static void message(){
//     System.out.println("hello");
//  } 
// public static int add(int a, int b){;
//     return a +b;
}
public static String caps(String s){
    return s.toUpperCase();
}
public static int[] ArrayInts(int a, int b, int c){
    int[] array = new int[3];
    array[0] = a;
    array[1] = b;
    array[2] = c;
    return array;
    

    
}

}
