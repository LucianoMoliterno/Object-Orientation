package test;

public class TestMetodosEstaticos {
	public static void main(String[] args) {
		int a[] = { 1, 3, 4, 8, -2, 7 };
		imprimirVector(a);
	}

	// Método estático para clases de testeo
	public static void imprimirVector(int[] v) {
		System.out.print("{");
		for (int e : v) {
			System.out.print(e + ",");
		}
		System.out.println("}");
	}
}