package de.unidue.stud.maha;

import static SoFTlib.Helper.number;
import static SoFTlib.Helper.words;

import SoFTlib.Node;
import SoFTlib.SoFT;

public class Main2 extends SoFT {

	/** @param args */
	public static void main(String[] args) {
		Node[] nodes = { new Prozess("A"), new Prozess("B"), new Prozess("C"),
				new Maskierer("D", PROZESSE, MASKIERER_2, TIMEOUT_1),
				new Maskierer("E", PROZESSE, MASKIERER_2, TIMEOUT_1),
				new Maskierer("F", PROZESSE, MASKIERER_2, TIMEOUT_1),
				new Maskierer("G", PROZESSE, null, TIMEOUT_2),
				new Maskierer("H", PROZESSE, null, TIMEOUT_2),
				new Maskierer("I", PROZESSE, null, TIMEOUT_2) };
		new Main().runSystem(nodes, "m�-Protokoll", "Aufgabe 2",
				"Marc Gesth�sen, Hanno - Felix Wagner");
	}

	public int result(String input, String[] output) {
		int resultVal = determineResult(number(words(input, 1, 1, 1)),
				number(words(input, 1, 2, 2)), number(words(input, 1, 3, 3)),
				sanitize(output[3]), sanitize(output[4]), sanitize(output[5]));
		return resultVal;
	}

	public static int sanitize(String inputVal) {
		return Double.valueOf(inputVal).intValue();
	}

	public int determineResult(int firstInput, int secondInput, int thirdInput,
			int firstValue, int secondValue, int thirdValue) {
		max = Math.max(thirdInput, Math.max(firstInput, secondInput));
		min = Math.min(thirdInput, Math.min(firstInput, secondInput));

		// System.out.println("max"+max);
		// System.out.println("min"+min);
		// System.out.println("firstInput"+firstInput);
		// System.out.println("secondInput"+secondInput);
		// System.out.println("thirdInput"+thirdInput);
		// System.out.println("firstValue"+firstValue);
		// System.out.println("secondValue"+secondValue);
		// System.out.println("thirdValue"+thirdValue);
		if (isValid(firstValue) && isValid(secondValue) && isValid(thirdValue)) {
			if (firstValue == secondValue && firstValue == thirdValue) {
				return 0; // wenn alle drei R�ckgabewerte korrekt und
							// �bereinstimmend sind
			} else {
				return 1; // wenn andernfalls alle drei R�ckgabewerte korrekt,
							// aber nicht �bereinstimmend sind (d.h. mindestens
							// ein Wert unterscheidet sich von den beiden
							// anderen),
			}
		} else {
			if (isValid(firstValue) && isValid(secondValue)) {
				if (firstValue == secondValue) {
					return 2; // wenn andernfalls 2 der 3 der R�ckgabewerte
								// korrekt und �bereinstimmend sind,
				} else {
					return 3; // wenn andernfalls 2 der 3 R�ckgabewerte korrekt,
								// aber nicht �bereinstimmend sind,
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

	public static int TIMEOUT_1 = 1000;
	public static int TIMEOUT_2 = 2000;

	private int max = -1;
	private int min = -1;
	public static String PROZESSE = "ABC";
	public static String MASKIERER_1 = "DEF";
	public static String MASKIERER_2 = "GHI";

	public static int getInputIndex(char Knoten) {
		if (Knoten == 'A')
			return 1;
		if (Knoten == 'B')
			return 2;
		if (Knoten == 'C')
			return 3;
		return -1;
	}

	public boolean isValid(int val) {
		if (val == -1) {
			return false;
		}
		if (val >= min && val <= max) {
			return true;
		} else {
			return false;
		}
	}
}
