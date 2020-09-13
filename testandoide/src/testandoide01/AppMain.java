package testandoide01;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		double a;
		
		do {
		System.out.print("Entre com o valor de a -> ");
			a = teclado.nextDouble(); 
			if (a == 0.0) {
				System.out.println("O valor de \"a\" não pode ser nulo");
			}
				
		} while (a == 0.0);
		
		System.out.print("Entre com o valor de b -> ");
		double b = teclado.nextDouble();
		System.out.print("Entre com o valor de c -> ");
		double c = teclado.nextDouble();
		
		double delta = Math.pow(b, 2.0) - 4 * a * c;
		System.out.println("Delta = "+ delta);
		double xv = -b / 2 * a;
		double yv = -delta / 4 * a;
		System.out.printf("As coordenadas do vértice da parábola são (%.4f; %.4f)%n", xv, yv);
		
		if (delta > 0) {
			double x1 = (-b + Math.sqrt(delta)) / 2 * a;
			double x2 = (-b - Math.sqrt(delta)) / 2 * a;
			System.out.printf("x1 = %.4f\n", x1);
			System.out.printf("x2 = %.4f\n", x2);
		}
		else if (delta == 0) {
			System.out.printf("x1 = x2 = %.4f", xv);
		}
		else {
			double imag = Math.sqrt(-delta) / 2 * a;
			if (xv != 0){
				System.out.printf("x1 = %.4f +%.4fi\n", xv, imag);
				System.out.printf("x2 = %.4f -%.4fi\n", xv, imag);
			}
			else {
				System.out.printf("x1 = +%.4fi\n", imag);
				System.out.printf("x2 = -%.4fi\n", imag);
			}
		}
		teclado.close();

	}

}
