class birb{
    public void sing(){
        System.out.println("tweet tweet tweet");
    }
}

class Robin extends birb{
public void sing(){
        System.out.println("doo doo bee");
    }
}
class Pelican extends birb{
    
        
}



public class Poly {
    public static void main(String[] args) {
        Robin b = new Robin();
        b.sing();
        
    }
}
