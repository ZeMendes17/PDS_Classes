package Ex1;
// tests each part
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee_test1 = new Employee("Julio", 4, 2300);
        Employee employee_test2 = new Employee("Fernando", 2, 200);
        Database test = new Database();

        
        test.addEmployee(employee_test1); // true
        test.addEmployee(employee_test2); // true
        
        test.deleteEmployee(4);           
        test.addEmployee(employee_test2);   // false

        test.addEmployee(employee_test1); // true

        Employee[] employees = test.getAllEmployees();
        for(Employee e : employees) {
            System.out.println(e.getName() + ";" + e.getEmpNum() + ";" + e.getSalary());
        }
            
    
        Empregado empregado1 = new Empregado("Coiso", "Tal", 122, 2000);
        Empregado empregado2 = new Empregado("John", "Smith", 123, 2400);
        Empregado empregado3 = new Empregado("Mike", "A", 232, 1400);
    
        Registos registo = new Registos();
        registo.insere(empregado1);   
        registo.insere(empregado2);   
        registo.insere(empregado3);   

        registo.remove(123);

        registo.isEmpregado(1); // false
        registo.isEmpregado(122); // true

        List<Empregado> lista = registo.listaDeEmpregados();
        for(Empregado e : lista) {
            System.out.println(e.nome() + ";" + e.apelido() + ";" + e.codigo() + ";" + e.salario());
        }
    }
}
