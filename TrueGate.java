package circuits;

public class TrueGate extends Gate {

	private static TrueGate instance = null;

	// constructor to initiliaze TrueGate instance
	private TrueGate() {
		super(null);
	}

	// return name "T"
	@Override
	public String getName() {
		return "T";
	}

//Simplifying the gate
	@Override
	public Gate simplify() {
		return instance;
	}

//return instance if there isn't instance
	public static Gate instance() {
		if (instance == null)
			instance = new TrueGate();
		return instance;
	}

	// return true
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

}
