package de.unidue.stud.maha;

import java.util.ArrayList;
import java.util.Collections;

import SoFTlib.Msg;
import SoFTlib.Node;
import SoFTlib.SoFTException;

public class Maskierer extends Node {

	private String source;
	private String target;
	private int timeOut;

	public Maskierer(String name, String source, String target, int timeOut) {
		this.setName(name);
		this.source = source;
		this.target = target;
		this.timeOut = timeOut;
	}

	public String runNode(String input) throws SoFTException {
		ArrayList<Double> ergebnisse = new ArrayList<Double>();

		// Empfangen der e-Nachrichten aller Prozesselemente
		for (int i = 0; i < source.length(); i++) {
			Msg receive = receive(source, 'e', timeOut);
			if (receive != null) {
				double curVal = -1;
				try {
					curVal = Double.valueOf(receive.getCo());
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
				ergebnisse.add(curVal);
			}
		}

		Collections.sort(ergebnisse);

		double median = -1.0;

		if (ergebnisse.size() == source.length())
			median = getMedian(ergebnisse);
		else if (ergebnisse.size() == 2)
			median = Double.valueOf(ergebnisse.get(0).toString());

		if(target!=null){
			form('e', median).send(target);
		}
		return String.valueOf(median);
	}

	private double getMedian(ArrayList<Double> ergebnisse) {

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
