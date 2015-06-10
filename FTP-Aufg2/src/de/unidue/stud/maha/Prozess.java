package de.unidue.stud.maha;


import static SoFTlib.Helper.words;
import SoFTlib.Node;
import SoFTlib.SoFTException;


public class Prozess extends Node {


	public Prozess(String name) {
		this.setName(name);
	}

	public String runNode(String input) throws SoFTException {
		int index = Main.getInputIndex(myChar());
		int zahl = -1;

		try {
			zahl =Integer.valueOf(words(input, 1, index, index));

		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		String maskierer = Main.MASKIERER_1;

		// Senden der e-Nachricht an alle Maskierer
		form('e', zahl).send(maskierer);

		return ""+zahl;
	}
}