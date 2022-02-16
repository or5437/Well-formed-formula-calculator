package circuits;

public class AndGate extends Gate {

	// constructor to initiliaze AndGate instance
	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	// return name of gate
	public String getName() {
		return "AND";
	}

	@Override
	// Simplifying the gate
	public Gate simplify() {
		Gate[] AndGates = new Gate[inGates.length];
		int count = 0;
		for (Gate g : inGates)
			if (g.simplify() instanceof FalseGate)// check if g is a type of FalseGate
				return FalseGate.instance();// return instance of FalseGate
		for (Gate g : inGates) {
			if (!(g.simplify() instanceof TrueGate))// Check if g or his simplification
													// isn't type of TrueGate
				AndGates[count++] = g.simplify();// simplify and put in the appropriate place on AndGates
		}
		if (count == 1)// check if there is one child that not type of TrueGate
			return AndGates[0];
		else if (count == 0)// check if there is no child white type of TrueGate
			return TrueGate.instance();// return instance of TrueGate
		return new AndGate(AndGates);

	}

	// Calculating gateway value
	@Override
	protected boolean func(boolean[] inValues) {
		for (int i = 0; i < inValues.length; i++)
			if (inValues[i] == false)// if the value is false
				return false;
		return true;
	}
}
