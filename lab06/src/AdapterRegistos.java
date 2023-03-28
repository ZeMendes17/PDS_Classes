import java.util.List;

public class AdapterRegistos implements AdapterInterface {

    private Registos registos = new Registos();

    @Override
    public void insere(Empregado e) {
        registos.insere(e);
    }

    @Override
    public void remove(int codigo) {
        registos.remove(codigo);
    }

    @Override
    public boolean isEmpregado(int codigo) {
        return registos.isEmpregado(codigo);
    }

    @Override
    public void print() {
        List<Empregado> lista = registos.listaDeEmpregados();
        for(Empregado e : lista){
            System.out.println(e.nome() + " " + e.apelido() + ";" + e.codigo() + ";" + e.salario());
        }
    }
    
}
