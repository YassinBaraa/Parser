import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {
	static Integer kazaljka = 0;
	static boolean returnedA = false;
	static boolean returnedB = false;

	public static void main(String[] args) {

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = null;
	        String[] niz1 = null;
	        List<String> ulazni_niz=new ArrayList<>();

	        HashMap<String, List<String>> prijelazi = new HashMap<>();
	        List<String> lista = new ArrayList<>();
	        lista.add("aAB");
	        lista.add("bBA");
	        prijelazi.put("S", lista);

	        lista = new ArrayList<>();
	        lista.add("bC");
	        lista.add("a");
	        prijelazi.put("A", lista);

	        lista = new ArrayList<>();
	        lista.add("ccSbc");
	        lista.add("$");
	        prijelazi.put("B", lista);

	        lista = new ArrayList<>();
	        lista.add("AA");
	        prijelazi.put("C", lista);

	        List<String> abeceda = new ArrayList<>();
	        abeceda.add("a");
	        abeceda.add("b");
	        abeceda.add("c");

	        try {

			line = br.readLine();

	        if(line.length() > 200) {
	        	System.out.println("Niz predugacak");
	        	return;
	        }
            //ulazni nizov
            niz1 = line.split("");
            for(String niz:niz1) {
            	ulazni_niz.add(niz);
        	}


            kazaljka = 0;
            parsiranje(ulazni_niz,prijelazi,abeceda );
            br.close();


	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
//TODO pada na 7,13,19 testu jer se dogada epsilon prijelaz za B, a kazljka nijw stigla do kraja
	private static void parsiranje( List<String> ulazni_niz,
			HashMap<String, List<String>> prijelazi,  List<String> abeceda) {

		System.out.print("S");
		S(ulazni_niz,prijelazi,abeceda);
		if(kazaljka !=  ulazni_niz.size() ) {
			System.out.println();
			System.out.println("NE");
		}
		else {
			System.out.println();
			System.out.println("DA");
		}
	}

	private static void S(  List<String> ulazni_niz,
			HashMap<String, List<String>> prijelazi,  List<String> abeceda) {

		if(kazaljka == ulazni_niz.size()) {return;}//------>
		if(ulazni_niz.get(kazaljka).equals("a")) {
			kazaljka++;
			
			System.out.print("A");
			A(ulazni_niz,prijelazi,abeceda);
			if(returnedA) {return;}
			//if(kazaljka == ulazni_niz.size()) {return;}//------>
			System.out.print("B");
			B(ulazni_niz,prijelazi,abeceda);
		}
		else if(ulazni_niz.get(kazaljka).equals("b")){
			kazaljka++;
			
			System.out.print("B");
			B(ulazni_niz,prijelazi,abeceda);
			if(returnedB) {return;}
			if(kazaljka == ulazni_niz.size()) {return;}//------>
			System.out.print("A");
			A(ulazni_niz,prijelazi,abeceda);
		}
	}

	private static void A(  List<String> ulazni_niz,
			HashMap<String, List<String>> prijelazi,  List<String> abeceda) {
		//Integer bruh = ulazni_niz.size();
		//Integer bruh2 = kazaljka;
		if(kazaljka == ulazni_niz.size()) {returnedA = true;return;}//------>
		if(ulazni_niz.get(kazaljka).equals("b")) {
			kazaljka++;
			System.out.print("C");
			C(ulazni_niz,prijelazi,abeceda);
		}
		else if(ulazni_niz.get(kazaljka).equals("a")){
			kazaljka++;
		}
	}

	private static void B(  List<String> ulazni_niz,
			HashMap<String, List<String>> prijelazi,  List<String> abeceda) {

		if(kazaljka == ulazni_niz.size()) {returnedB = true;return;}//------>
		if(ulazni_niz.get(kazaljka).equals("c") ) {
			kazaljka++;
			
			if(kazaljka == ulazni_niz.size()) {returnedB = true;return;}//------>
			if(ulazni_niz.get(kazaljka).equals("c") ) {
			kazaljka++;
			System.out.print("S");
			
			S(ulazni_niz,prijelazi,abeceda);

			if(kazaljka == ulazni_niz.size()) {returnedB = true;return;}//------>
			if(!ulazni_niz.get(kazaljka).equals("b")) {
				return;}
			else {
				kazaljka++;
				if(kazaljka == ulazni_niz.size()) {returnedB = true;return;}//------>
				if(!ulazni_niz.get(kazaljka).equals("c")) {
					return;}
				kazaljka++;
				}
			}
		}
	}

	private static void C(  List<String> ulazni_niz,
			HashMap<String, List<String>> prijelazi,  List<String> abeceda) {

		System.out.print("A");
		A(ulazni_niz,prijelazi,abeceda);
		if(returnedA) {kazaljka++;return;};
		System.out.print("A");
		A(ulazni_niz,prijelazi,abeceda);

	}
	
}
