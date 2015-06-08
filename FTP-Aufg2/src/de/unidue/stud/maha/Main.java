package de.unidue.stud.maha;

import SoFTlib.Node;

/**
 * 
 */

/**
 * @author Hanno - Felix Wagner
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	public static String getProzesse() {
		return "ABC";
	}

}
