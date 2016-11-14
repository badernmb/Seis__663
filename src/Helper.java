
import java.util.Random;

public class Helper {

	// This method converts character to Askii.
	public int convertLetterToNumber(char character) {

		return (int) character;

	}

	// This method converts Integer (Askii code) to character.
	public char convertNumberToLetter(int number) {

		return (char) number;

	}

	// This method checks if number given by the parameter is prime or not.
	public boolean isPrimee(int primeNumberCheck) {

		if (primeNumberCheck == 1 || primeNumberCheck == 0) {
			return false;
		}

		for (int i = 2; i < primeNumberCheck; i++) {

			if (primeNumberCheck % i == 0) {
				return false;
			}

		}

		return true;

	}

	// This method generates a prime number by getting a random value and
	// searching for a prime number.
	public int generatePrimeNumber() {

		Random rng = new Random();
		int value = 0;

		while (isPrimee(value) == false) {

			value = rng.nextInt(100000);
		}

		return value;

	}

	/*
	 * This method checks if two numbers given by parameters are Co-prime or
	 * not.
	 */
	public boolean isCoPrime(int firstvalue, int secondValue) {

		if (firstvalue == 0 || firstvalue == 1 || secondValue == 0 || secondValue == 1) {
			return false;
		}

		int counter = 0;

		for (int i = 1; i <= firstvalue; i++) {

			if (firstvalue % i == 0 && secondValue % i == 0) {
				counter++;
			}

		}

		if (counter == 1) {
			return true;
		}

		return false;
	}

}