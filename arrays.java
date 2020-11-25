import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class Main {
	public static void main(String args[]) {

		//Declaração
		final int valor = 5000;
		int i = 0,
		j = 0,
		k = 0;
		int size = 0;
		int maior,
		menor,
		qtdModa;
		double soma = 0,
		somaQuadrado = 0,
		media = 0,
		mediana = 0,
		variancia = 0,
		desvio = 0,
		p1 = 0,
		p2 = 0;
		Random generator = new Random();
		int[] arrayAleatorio;
		int[] arrayModa;
		int[] arrayOrdenado;
		int[] arrayUnicos;
		boolean existe;

		//Leitura
		System.out.println("Bem Vindo");
		Scanner myObj = new Scanner(System. in );
		do {
			System.out.println("Digite um tamanho maior que zero para o array:");
			size = myObj.nextInt();
		} while ( size <= 0 );

		//Criacao doa array
		arrayAleatorio = new int[size];
		arrayModa = new int[size];
		arrayOrdenado = new int[size];
		arrayUnicos = new int[size];

		//Preenchimento do array    
		for (i = 0, j = 0; i < size; i++) {
			arrayAleatorio[i] = generator.nextInt(valor);
			arrayOrdenado[i] = arrayAleatorio[i];
			if (j == 0) {
				arrayUnicos[j] = arrayAleatorio[i];
				arrayModa[j] = 1;
				j++;
			} else {
				existe = false;
				for (k = 0; k < j; k++) {
					if (arrayAleatorio[i] == arrayUnicos[k]) {
						existe = true;
						arrayModa[k]++;
					}
				}
				if (!existe) {
					arrayUnicos[j] = arrayAleatorio[i];
					arrayModa[j] = 1;
					j++;
				}

			}
		}

		Arrays.sort(arrayOrdenado);

		//Calculo dos requisitos
		maior = arrayAleatorio[0];
		for (i = 1; i < size; i++) {
			if (arrayAleatorio[i] > maior) {
				maior = arrayAleatorio[i];
			}
		}
		System.out.println("\nMaior Numero: " + maior);

		menor = arrayAleatorio[0];
		for (i = 1; i < size; i++) {
			if (arrayAleatorio[i] < menor) {
				menor = arrayAleatorio[i];
			}
		}
		System.out.println("Menor Numero: " + menor);

		System.out.print("Numeros Pares: ");
		for (i = 0; i < size; i++) {
			if (arrayAleatorio[i] % 2 == 0) {
				System.out.print(arrayAleatorio[i] + " ");
			}
		}

		System.out.print("\nNumeros Impares: ");
		for (i = 0; i < size; i++) {
			if (arrayAleatorio[i] % 2 == 1) {
				System.out.print(arrayAleatorio[i] + " ");
			}
		}

		int contador;
		System.out.print("\nNumeros Primos: ");
		for (i = 0; i < size; i++) {
			contador = 0;
			for (j = 2; j < arrayAleatorio[i] && contador == 0; j++) {
				if (arrayAleatorio[i] % j == 0) {
					contador++;
				}
			}
			if (contador == 0) {
				System.out.print(arrayAleatorio[i] + " ");
			}
		}

		for (i = 0; i < size; i++) {
			soma += arrayAleatorio[i];
		}
		System.out.println("\nSoma: " + soma);

		media = soma / size;
		System.out.println("Media: " + media);

		System.out.print("Moda: ");
		qtdModa = arrayModa[0];
		for (i = 1; i < arrayModa.length; i++) {
			if (arrayModa[i] > qtdModa) {
				qtdModa = arrayModa[i];
			}
		}
		if (qtdModa > 1) {
			for (i = 0; i < arrayModa.length; i++) {
				if (arrayModa[i] == qtdModa) {
					System.out.print(arrayUnicos[i] + " ");
				}
			}
		}

		if (size % 2 == 0) {
			mediana = (arrayOrdenado[i / 2] + arrayOrdenado[i / 2 - 1]) / 2.0;
		} else {
			mediana = arrayOrdenado[i / 2];
		}
		System.out.println("\nMediana: " + mediana);

		if (size > 1) {
			for (i = 0; i < size; i++) {
				somaQuadrado += (arrayAleatorio[i] - media) * (arrayAleatorio[i] - media);
			}
			variancia = somaQuadrado / size;
			desvio = Math.sqrt(somaQuadrado) / Math.sqrt(size);
		}
		System.out.println("Variancia: " + variancia);
		System.out.println("Desvio padrao: " + desvio);

		System.out.print("Array Gerado: ");
		for (i = 0; i < size; i++) {
			System.out.print(arrayAleatorio[i] + " ");
		}
		
	}
}