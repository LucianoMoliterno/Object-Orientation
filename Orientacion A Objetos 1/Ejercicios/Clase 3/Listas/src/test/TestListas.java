package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestListas {
	public static void main(String argv[]) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Vamos a llenar un ArrayList del tipo String, el contenido de c/elemento es un String ");
		
		List<String> lista = new ArrayList<String>(); // inicializamos un objeto lista de tipo String
		
		// entrada de las cadenas
		String elem = "";
		while (!((elem.equalsIgnoreCase("stop")))) {
			System.out.println("Para finalizar tipear stop");
			elem = in.next();
			if (!(elem.equals("stop")))
				lista.add(elem);
		}
		
		System.out.println("1) Impresi�n implementando foreach loop");
		for (String s : lista) {
			System.out.println(s);
		}
		
		System.out.println("2) impresi�n implementando for loop with index");
		for (int p = 0; p < lista.size(); p++) {
			System.out.println(lista.get(p));
		}
		
		System.out.println("3) impresi�n implementando Iterator<tipo>");
		for (Iterator<String> iter = lista.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
		
		in.close();
	}
}
