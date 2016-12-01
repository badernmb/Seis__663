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
        p = 17;
        q = 7;

		this.n = p * q;
		int t = (p - 1) * (q - 1);
		computeE(t);
        computeD(t);
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

	public void computeD(int t){
        boolean check = false;
        int i = 1;
		while (check == false){
            d = i ;

            int x = d *this.e;
            if ((d*this.e)% t == 1){
                check = true;
                System.out.println(d);
            }
            i++;
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

	public String  decrypt(int[]encrypted){
		char CoToLe[] = new char[encrypted.length];
		 int buff;
		for (int i = 0; i <CoToLe.length; i++){
			buff = Helper.calcDecrypt(encrypted[i], d, n);
			CoToLe[i] = Helper.convertNumberToLetter(buff);
		}
        String message = "";

		for(int i = 0; i <CoToLe.length; i++){
			message += CoToLe[i];

		}
		return message;
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

		Helper.writerEncryptionFile("test.txt", cipher);

        int [] encrypted = Helper.readEncryptionFile("test.txt");
		 String v = r1.decrypt(encrypted);

	}

}
