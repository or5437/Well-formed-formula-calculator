package circuits;

public class Or2Gate extends OrGate {
	// constructor to initialize Or2Gate instance
	public Or2Gate(Gate g1, Gate g2) {
		super(new Gate[] { g1, g2 });
	}
}
