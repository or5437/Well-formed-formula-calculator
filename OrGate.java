package circuits;

public class OrGate extends Gate {

	// constructor to Initialize Gate or
	public OrGate(Gate[] inGates) {
		super(inGates);
	}

//return name of gate
	@Override
	public String getName() {
		return "OR";
	}

	@Override
//simplify the gate
	public Gate simplify() {
		Gate[] OrGates = new Gate[inGates.length];
		int count = 0;
		for (Gate g : inGates)
			if (g.simplify() instanceof TrueGate)// check if g is a type of TrueGate
				return TrueGate.instance();// return instance of TrueGate
		for (Gate g : inGates) {
			if (!(g.simplify() instanceof FalseGate))// Check if g or his simplification is
														// not type of FalseGate
				OrGates[count++] = g.simplify();// simplify and put in the appropriate place on OrGates
		}
		if (count == 1)// check if there is one child that not type of TrueGate
			return OrGates[0];
		else if (count == 0)// check if there is no child white type of TrueGate
			return FalseGate.instance();// return instance of FalseGate
		return new OrGate(OrGates);// return new instance of OrGate
	}

//Returns what the gateway should calculate
	@Override
	protected boolean func(boolean[] inValues) {
		for (int i = 0; i < inValues.length; i++)
			if (inValues[i] == true)// if the value is true
				return true;
		return false;
	}
}
