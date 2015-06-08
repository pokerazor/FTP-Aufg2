import static SoFTlib.Helper.words;

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
			if (receive != null)
				ergebnisse.add(Integer.valueOf(receive.getCo()));
		}
		
		Collections.sort(ergebnisse);
		
		
		if(ergebnisse.size()==prozesse.length()) return ergebnisse.get(1).toString();
		else if(ergebnisse.size())

		return "1";
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
