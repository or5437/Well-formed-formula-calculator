package circuits;

public abstract class Gate {
	protected Gate[] inGates;// Array with gates

	// constructor to initialize Gate instance
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}

	// Calculates the Boolean value of the gateway. Otherwise throws out the
	// CircuitException exception.
	public boolean calc() throws CircuitException {
		if (inGates == null)
			return func(null);
		boolean[] values = new boolean[inGates.length];
		for (int i = 0; i < inGates.length; i++)
			values[i] = inGates[i].calc();// Calculate the gate and put in the appropriate place in values array
		return func(values);// Calculate the value of the gates array.
	}

//An abstract method that calculates what the gate should calculate given an array of Boolean inputs.
	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	// Returns the gate name
	public abstract String getName();

	// Returns the gate after simplification
	public abstract Gate simplify();

	// Return the string of the gate
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (inGates == null)
			return getName();
		s.append(getName() + "[");// add to the end of string
		for (int i = 0; i < inGates.length; i++) {
			if (inGates[i] != null)
				s.append(inGates[i].toString() + ", ");// add to the end of string
		}
		s.delete(s.length() - 2, s.length());// delete the last ","
		s.append("]");// add to the end of string
		return s.toString();// change to string and return it
	}
}
