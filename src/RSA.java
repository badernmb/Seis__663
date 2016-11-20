import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class RSA {

	protected int n;
	protected int e;
	protected int d;

	public RSA() {

		int p = Helper.generatePrimeNumber();
		int q = Helper.generatePrimeNumber();

		this.n = p * q;
		int t = (p - 1) * (q - 1);
		computeE(t);

	}

	public void computeE(int t) {

		boolean check = false;

		while (check == false) {

			this.e = Helper.generatePrimeNumber();

			if (this.e < t && Helper.isCoPrime(this.e, t) == true) {
				check = true;
			}

		}

	}

	public int[] encrypt(String plainText) {

		int CoTONu[] = new int[plainText.length()];
		for (int i = 0; i < CoTONu.length; i++) {
			CoTONu[i] = Helper.convertLetterToNumber(plainText.charAt(i));
			CoTONu[i] = Helper.powerMode(CoTONu[i], e, n);
		}

		return CoTONu;

	}

	public String toString() {

		return this.n + " " + this.e + " " + this.d;

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		RSA r1 = new RSA();

	

		System.out.println("Enter the message :");

		String message = input.nextLine();

		System.out.println(message);

		int cipher[] = r1.encrypt(message);

		Helper.writerEncryptionFile("test", cipher);

	}

}
