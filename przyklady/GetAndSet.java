public class GetAndSet {
String name;
int age;
    
    public static void main(String[] args) {
        GetAndSet a = new GetAndSet();
        a.sayHB("Alex");
    }

    public static void sayHB(String name){
    System.out.println("Happy Bday "+name);
    }
}
