package de.unidue.stud.maha;

import static SoFTlib.Helper.number;
import static SoFTlib.Helper.words;

import SoFTlib.Node;
import SoFTlib.SoFT;

public class Main extends SoFT {

	/** @param args */
	public static void main(String[] args) {
		Node[] nodes = { new Prozess("A"), new Prozess("B"), new Prozess("C"), new Maskierer("D"), new Maskierer("E"), new Maskierer("F") };
		new Main().runSystem(nodes, "mï¿½-Protokoll", "Aufgabe 2", "Marc Gesthï¿½sen, Hanno - Felix Wagner");
	}

	public int result(String input, String[] output) {

		int resultVal = determineResult(number(words(input, 1, 1, 1)), number(words(input, 1, 2, 2)), number(words(input, 1, 3, 3)), number(words(output[3], 1, 1, 1)), number(words(output[4], 1, 1, 1)), number(words(output[5], 1, 1, 1)));
		return resultVal;
	}

	public int determineResult(int firstInput, int secondInput, int thirdInput, int firstValue, int secondValue, int thirdValue) {
		max = Math.max(thirdInput, Math.max(firstInput, secondInput));
		min = Math.min(thirdInput, Math.min(firstInput, secondInput));

		if (isValid(firstValue) && isValid(secondValue) && isValid(thirdValue)) {
			if (firstValue == secondValue && firstValue == thirdValue) {
				return 0; // wenn alle drei Rückgabewerte korrekt und übereinstimmend sind
			} else {
				return 1; // wenn andernfalls alle drei Rï¿½ckgabewerte korrekt,
							// aber nicht ï¿½bereinstimmend sind (d.h. mindestens
							// ein Wert unterscheidet sich von den beiden
							// anderen),
			}
		} else {
			if (isValid(firstValue) && isValid(secondValue)) {
				if (firstValue == secondValue) {
					return 2; // wenn andernfalls 2 der 3 der Rückgabewerte korrekt und übereinstimmend sind,
				} else {
					return 3; // wenn andernfalls 2 der 3 Rückgabewerte korrekt, aber nicht übereinstimmend sind,
				}
			} else if (isValid(firstValue) && isValid(thirdValue)) {
				if (firstValue == thirdValue) {
					return 2;
				} else {
					return 3;
				}
			} else if (isValid(secondValue) && isValid(thirdValue)) {
				if (secondValue == thirdValue) {
					return 2;
				} else {
					return 3;
				}
			}
		}
		return 4; // sonst
	}

	public static int TIMEOUT = 200;

	private int max = -1;
	private int min = -1;

	public static int getInputIndex(char Knoten) {
		if (Knoten == 'A')
			return 1;
		if (Knoten == 'B')
			return 2;
		if (Knoten == 'C')
			return 3;
		return -1;
	}

	public static String getMaskierer() {
		return "DEF";
	}

	public boolean isValid(int val) {
		if (val > min && val < max) {
			return true;
		} else {
			return false;
		}
	}

	public static String getProzesse() {
		return "ABC";
	}
}
