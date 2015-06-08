package de.unidue.stud.maha;

import java.util.ArrayList;
import java.util.Collections;

import SoFTlib.Msg;
import SoFTlib.Node;
import SoFTlib.SoFTException;

public class Maskierer extends Node {

	public Maskierer(String name) {
		this.setName(name);
	}

	public String runNode(String input) throws SoFTException {
		String prozesse = Main.getProzesse();
		ArrayList<Integer> ergebnisse = new ArrayList<Integer>();

		// Empfangen der e-Nachrichten aller Prozesselemente
		for (int i = 0; i < prozesse.length(); i++) {
			Msg receive = receive(prozesse, 'e', Main.TIMEOUT);
			if (receive != null){
				int curVal=-1;
				try {
					curVal=Integer.valueOf(receive.getCo());
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
				ergebnisse.add(curVal);
			}
		}

		Collections.sort(ergebnisse);

		if (ergebnisse.size() == prozesse.length())
			return String.valueOf(getMedian(ergebnisse));
		else if (ergebnisse.size() == 2)
			return ergebnisse.get(0).toString();
		return "-1";
	}

	private double getMedian(ArrayList<Integer> ergebnisse) {

		double median = 0;
		double pos1 = Math.floor((ergebnisse.size() - 1.0) / 2.0);
		double pos2 = Math.ceil((ergebnisse.size() - 1.0) / 2.0);
		if (pos1 == pos2) {
			median = ergebnisse.get((int) pos1);
		} else {
			median = (ergebnisse.get((int) pos1) + ergebnisse.get((int) pos2)) / 2.0;
		}

		return median;
	}
}
