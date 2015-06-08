import static SoFTlib.Helper.words;
import SoFTlib.Msg;
import SoFTlib.Node;
import SoFTlib.SoFTException;

<<<<<<< HEAD
import SoFTlib.Node;

public class Maskierer extends Node{
=======
>>>>>>> refs/remotes/origin/Develope

public class Maskierer extends Node{
	public String runNode(String input) throws SoFTException {
		String prozesse = Main.getProzesse();

		// Empfangen der e-Nachrichten aller Prozesselemente
		for (int i = 0; i < prozesse.length(); i++) {
			Msg receive = receive(prozesse, 'e', Main.TIMEOUT);
			if (receive != null)
				// Einzelne Quittungen zusammenfügen
				quittungen += receive.getCo();
			if (checkResult(quittungen))
				// Knoten gibt 0 zurück wenn Quittung alle Nachbarn enthält,
				// anderen Falls 1.
				return "0";
		}

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
