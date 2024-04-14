public class Account {
    String name;
    int age;
    public static void main(String[] args) {
        Account a = new Account();
        a.setName("Pablo");
        a.setAge(23);
        System.out.println(a.getAge());
        System.out.println(a.getName());
        a.printdetails();
        
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void printdetails() {
        System.out.println(name + ", " + age);
    }
}
