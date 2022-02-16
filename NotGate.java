package circuits;

public class NotGate extends Gate {

//constructor to Initialize Gate not
	public NotGate(Gate in) {
		super(new Gate[] { in });
	}

//return the name of gate
	@Override
	public String getName() {
		return "NOT";
	}

//simplify the gate
	@Override
	public Gate simplify() {
		if (inGates[0].simplify() instanceof FalseGate)
			return TrueGate.instance();// return instance of TrueGate
		else if (inGates[0].simplify() instanceof TrueGate)
			return FalseGate.instance();// return instance of FalseGate
		else if (inGates[0].simplify() instanceof NotGate)// If the son is some kind of NotGate
			return inGates[0].simplify().inGates[0];// Return the grandson
		return new NotGate(inGates[0].simplify());// return new FalseGate instance with simplify
	}

	@Override
//Returns what the gateway should calculate
	protected boolean func(boolean[] inValues) throws CircuitException {
		if (inValues[0] == false)// if the value is false
			return true;
		else if (inValues[0] == true)// if the value is true
			return false;
		else // if not initialize
			throw new CircuitException();
	}

}
