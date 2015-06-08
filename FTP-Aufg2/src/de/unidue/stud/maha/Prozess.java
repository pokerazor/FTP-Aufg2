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
		int zahl = Integer.valueOf(words(input, 1, index, 1));
		String maskierer = Main.getMaskierer();

		// Senden der e-Nachricht an alle Maskierer
		form('e', zahl).send(maskierer);

		return "0";
	}
}
