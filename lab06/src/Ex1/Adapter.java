package Ex1;
public class Adapter implements AdapterInterface{
    private AdapterDB DBadaptee;
    private AdapterRegistos RegistosAdaptee;

    public Adapter(AdapterDB DBadaptee, AdapterRegistos RegistosAdaptee){
        this.DBadaptee = DBadaptee;
        this.RegistosAdaptee = RegistosAdaptee;
    }

    @Override
    public void insere(Empregado e) {
        RegistosAdaptee.insere(e);
    }
    @Override
    public void remove(int codigo) {
        RegistosAdaptee.remove(codigo);
        DBadaptee.remove(codigo);
    }
    @Override
    public boolean isEmpregado(int codigo) {
        if(RegistosAdaptee.isEmpregado(codigo) || DBadaptee.isEmpregado(codigo))
            return true;
        return false;
    }
    @Override
    public void print() {
        DBadaptee.print();
        RegistosAdaptee.print();
    } 
}
