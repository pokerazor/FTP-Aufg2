package de.unidue.stud.maha;


import static SoFTlib.Helper.number;
import static SoFTlib.Helper.words;


import SoFTlib.Node;
import SoFTlib.SoFT;



public class Main extends SoFT {





	/** @param args */
	public static void main(String[] args) {
		Node[] nodes={ new Prozess(null), new Prozess(null), new Prozess(null), new Maskierer(), new Maskierer(), new Maskierer() };
		new Main().runSystem(nodes , "m²-Protokoll", "Aufgabe 2", "Marc Gesthüsen, Hanno - Felix Wagner");
	}

	public int result(String input, String[] output) {
		int resultVal=determineResult( number(words(input, 1, 1, 1)),number(words(input, 2, 1, 1)),number(words(input, 3, 1, 1)), number(words(output[3], 1, 1, 1)), number(words(output[4], 1, 1, 1)), number(words(output[5], 1, 1, 1)));
		return resultVal;
	}
	

	public int determineResult(int firstInput, int secondInput, int thirdInput,int firstValue, int secondValue, int thirdValue){
		int max=Math.max(thirdInput,Math.max(firstInput, secondInput));
		int min=Math.min(thirdInput,Math.min(firstInput, secondInput));

		if(isValid(firstValue,min,max) && isValid(secondValue,min,max) && isValid(thirdValue,min,max)){
			if (firstValue==secondValue && firstValue==thirdValue){
				return 0; //wenn alle drei Rückgabewerte korrekt und übereinstimmend sind
			} else {
				return 1; //wenn andernfalls alle drei Rückgabewerte korrekt, aber nicht übereinstimmend sind (d.h. mindestens ein Wert unterscheidet sich von den beiden anderen),
			}
		}
		return 4; //sonst
	}
	public static int TIMEOUT = 200;

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
	

	public static boolean isValid(int val, int min, int max){
		if(val>min && val < max){
			return true;
		} else {
			return false;
		}
	}
	public static String getProzesse() {
		return "ABC";

	}
}