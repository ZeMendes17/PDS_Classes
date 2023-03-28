package Ex1;

public class AdapterDB implements AdapterInterface {

    private Database adaptee = new Database();

    @Override
    public void insere(Empregado e) {
        Employee emp = new Employee(e.nome() + " " + e.apelido(), e.codigo(), e.salario());
        adaptee.addEmployee(emp);
    }

    @Override
    public void remove(int codigo) {
        adaptee.deleteEmployee(codigo);
    }

    @Override
    public boolean isEmpregado(int codigo) {
        Employee[] employees = adaptee.getAllEmployees();

        for(Employee e : employees){
            if(e.getEmpNum() == codigo)
                return true;
        }
        return false;
    }

    @Override
    public void print() {
        Employee[] employees = adaptee.getAllEmployees();
        for(Employee e : employees) {
            System.out.println(e.getName() + ";" + e.getEmpNum() + ";" + e.getSalary());
        }
    }
}
