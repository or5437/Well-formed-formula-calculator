package circuits;

public class FalseGate extends Gate {
	private static FalseGate instance = null;

	// constructor to initialize FalseGate instance
	private FalseGate() {
		super(null);
	}

//return name "F"
	@Override
	public String getName() {
		return "F";
	}

//Simplifying the gate
	@Override
	public Gate simplify() {
		return this;
	}

	// return instance if there isn't
	public static Gate instance() {
		if (instance == null)
			instance = new FalseGate();
		return instance;
	}

//return false
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

}
