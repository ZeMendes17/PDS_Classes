package ex2;

class NullEmployee extends Employee {
	@Override
	public String getName() {
		return "Employee not found.";
	}
}
