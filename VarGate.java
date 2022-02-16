
package circuits;

public class VarGate extends Gate {
	// constructor to initiliaze VarGate instance
	private String name;
	private boolean value;
	private boolean ifInit = false;// to check if initialize

	// A constructor who defines the variable name.
	public VarGate(String name) {
		super(null);
		this.name = name;
	}

	// returns V with the name
	@Override
	public String getName() {
		return "V" + name;
	}

	// Returns the variable value.
	// If the variable value has not yet been determined,
	// throws the exception
	protected boolean func(boolean[] inValues) throws CircuitException {
		if (ifInit)// if the gate initialize with value
			return value;
		throw new CircuitException();
	}

	// simplify the gate
	@Override
	public Gate simplify() {
		if (ifInit) {// if the gate initialize with value
			if (value) // if value==true
				return TrueGate.instance();// return instance of TrueGate
			return FalseGate.instance();// return instance of FalseGate
		}
		return this;// return this instance
	}

	// Determines the value of the variable to value.
	public void setVal(boolean value) {
		this.value = value;
		ifInit = true;
	}
}
