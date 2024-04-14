import java.io.*;

class BlednaOperacja extends Exception {
	BlednaOperacja(String msg) {
		super(msg);
	}
}

class Osoba {
	
	private String nazwisko;

    public Osoba (String nazwisko)
    {
    	this.nazwisko = nazwisko;
    }
    
    public String toString()
    {
    	return nazwisko;
    }
}

class Rachunek {
	
	private Osoba wlasciciel; 
	private double stan;
	
	public Rachunek(Osoba wlasciciel, double stan) {
		this.wlasciciel = wlasciciel;
		this.stan = stan;
	}
		
	public Rachunek(Osoba wlasciciel){
		this.wlasciciel = wlasciciel;
	}

	public double getStan() {
		return stan;
	}
	
	public Osoba getWlasciciel() {
		return wlasciciel;
	}
	
	protected void setStan(double stan) {
		this.stan = stan;
	}

	public void wplata(double kwota) throws BlednaOperacja
   	{
    	if (kwota < 0)
    		throw new BlednaOperacja(wlasciciel + " (" + this.stan + "): " + "ujemna kwota operacji, " + "wplata, " + kwota);
		
    	// this.stan = this.stan + kwota;
    	setStan(stan + kwota);
   	}
           
    public void wyplata(double kwota) throws BlednaOperacja
    {
    	if (kwota < 0)
    		throw new BlednaOperacja(wlasciciel + " (" + this.stan + "): " + "ujemna kwota operacji, " + "wyplata, " + kwota);
    	
    	if (stan - kwota >= 0)
    		setStan(stan - kwota);
    	else 
    		throw new BlednaOperacja(wlasciciel + " (" + this.stan + "): " + "stan po operacji ujemna, " + "wyplata, " + kwota);
    }
    
    public void przelew(Rachunek rach, double kwota) throws BlednaOperacja
    {
//    	if (kwota < 0)
//    		throw new BlednaOperacja(wlasciciel + " (" + this.stan + "): " + "ujemna kwota operacji, " + "przelew, " + kwota + ", " + rach.wlasciciel);
//    	
    	wyplata(kwota);
    	rach.wplata(kwota);
    }
    
    public String toString()
    {
    	return "Konto nr " + nr + ": " + wlasciciel + ", stan " + stan;
    }
    
    public void aktualizuj() throws BlednaOperacja, IOException
    {
    	System.out.println("Konto nr " + nr + ": " + wlasciciel + ", stan " + stan);
    	zapiszDoPliku("raport.txt");
    }
    
    protected void zapiszDoPliku(String plik) throws IOException {
    	
    	FileWriter fw = new FileWriter(plik, true);
    	fw.write(toString() + "\n");
    	fw.close();
    }
    
	private static int ile;
	protected int nr = ++ile;
}

class Konto extends Rachunek {

	private double oprocentowanie;
		
	public Konto(Osoba wlasciciel, double oprocentowanie)
	{
		super(wlasciciel);
		this.oprocentowanie = oprocentowanie;
	}
	
    private void dodajOdsetki() throws BlednaOperacja
    {
    	if (getStan() > 0) {
    		double odsetki = oprocentowanie/100*getStan();
    		setStan(getStan() + odsetki);
    	} 
    }
     
    @Override
    public String toString()
    {
    	return super.toString() + ", oprocentowanie " + oprocentowanie;
    }
    
    @Override
    public void aktualizuj() throws BlednaOperacja, IOException {
    	dodajOdsetki();
    	super.aktualizuj();
    }
}

class KontoVIP extends Konto {

	private int limitPrzekroczenia;
	private double limitDebetu;
		
	public KontoVIP(Osoba wlasciciel, double oprocentowanie, double limitDebetu)
	{
		super(wlasciciel, oprocentowanie);
		this.limitDebetu = limitDebetu;
	}
		  
    @Override
    public void wyplata(double kwota) throws BlednaOperacja {
    	
    	if (getStan() - kwota >= limitDebetu)
    		setStan(getStan()-kwota);
    	else {
    		limitPrzekroczenia++;
    		throw new BlednaOperacja(this.getWlasciciel() + " (" + this.getStan() + ", " + this.limitDebetu + "): " + "przekroczony limit, " + "wyplata, " + kwota);
    	}
    }

// niepotrzebnie
//   @Override
//    public void przelew(Rachunek konto, double kwota) throws BlednaOperacja {
//    	
//    	if (getStan() - kwota >= limitDebetu) {
//    		setStan(getStan( )- kwota);
//			konto.setStan(konto.getStan() + kwota);
//      } else {
//    		limitPrzekroczenia++;
//    		throw new BlednaOperacja(this.getWlasciciel() + " (" + this.getStan() + ", " + this.limitDebetu + "): " + "przekroczony limit, " + "przelew, " + kwota);
//    	}
//   }
    
    @Override
    public String toString()
    {
    	return super.toString() + ", limit debetu " + limitDebetu;
    }
    
    @Override
    public void aktualizuj() throws BlednaOperacja, IOException {
   
    	super.aktualizuj();
    	if (limitPrzekroczenia > 0) { 
    		System.out.println("Liczba prób przekroczenia limitu debetu od ostatniej aktualizacji - " + limitPrzekroczenia + "!");
    		limitPrzekroczenia = 0;
    	} else
    		System.out.println();
    }	
 
}

class Bank {
	
	public static void main(String[] args) throws BlednaOperacja, IOException
	{
		Osoba klient1 = new Osoba("jan"), klient2 = new Osoba("anna");
		Osoba[] klienci = new Osoba[] {klient1, klient2, new Osoba("maria")};
		
		for (Osoba o: klienci)
			System.out.print(o + "  ");
		System.out.println("\n");
		
		Rachunek konto1 = new Rachunek(klient1); 
		Rachunek konto2 = new Konto(klient2, 5);	// oprocentowanie: 5%
		Rachunek[] konta = {konto1, 
							konto2, 
							new KontoVIP(klienci[2], 10, -100)};	// oprocentowanie: 10%, limit debetu: -100
		
    	konto1.wplata(500);
    	konto2.wplata(900);
    	konto2.wyplata(300);
    	konto1.przelew(konto2, 200);
    	
    	for (Rachunek k: konta)
			System.out.println(k);
    	
    	System.out.println();
    	
    	try {
    		konta[2].wyplata(101);
    	} catch (BlednaOperacja e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		konto2.przelew(konta[2], 801);
    	} catch (BlednaOperacja e) {
    		System.out.println(e.getMessage());
    	}
    	System.out.println();
    	
    	konto2.przelew(konta[2], 700);
    	
    	try {
    		konta[2].przelew(konto1, 801);
    	} catch (BlednaOperacja e) {
    		System.out.println(e.getMessage());
    	}
    		System.out.println();
    	
    	try {
    		konta[2].przelew(konto1, 800);
    	} catch (BlednaOperacja e) {
    		System.out.println(e.getMessage());
    	}
    	for (Rachunek k: konta)
			System.out.println(k);
    	
    	System.out.println();
    	
    	for (Rachunek k: konta)
    		k.aktualizuj();
	
    	System.out.println();
    
	}
}     