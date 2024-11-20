package test;

import java.time.LocalDate;

import datos.Afiliado;
import negocio.AfiliadoABM;
import negocio.PlanABM;

public class TestDNI40238958Tema2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AfiliadoABM afiliadoABM = new AfiliadoABM();
		PlanABM planABM = new PlanABM();
		
		System.out.println("1");
		System.out.println(planABM.traer());
		System.out.println("2");
		System.out.println(planABM.traer("Plan Premium 1"));
		System.out.println("3");
		System.out.println(afiliadoABM.calcularCostoMensual(afiliadoABM.traer("2")));
		System.out.println("4");
		System.out.println(afiliadoABM.calcularCostoMensual(afiliadoABM.traer("4")));
		System.out.println("5");
		System.out.println(afiliadoABM.traer(planABM.traer("Plan Premium 1")));
		System.out.println("6");
		for(Afiliado afiliado: afiliadoABM.traer(LocalDate.of(2023, 1, 1), LocalDate.of(2024, 12, 31))) {
			System.out.println(afiliado.toStringConProducto());
		}
		//PREMIUM 1 NO TRAE REGISTROS, PROBAR CON PREMIUM 3
		System.out.println("7");
		for(Afiliado afiliado: afiliadoABM.traer(LocalDate.of(2023, 1, 1), LocalDate.of(2024, 12, 31), planABM.traer("Plan Premium 1"))){
			System.out.println(afiliado.toStringConProducto());
		}
}
}