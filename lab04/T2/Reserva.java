public class Reserva{
    private String codigo;
    private String[] lugares;
	private int numPassageiros;
	private char classe;
	private int lugarAtual;

	public Reserva(String codigo, int numPassageiros, char classe) {
		this.codigo = codigo;
		this.numPassageiros = numPassageiros;
		this.classe = classe;
		this.lugares = new String[numPassageiros];
		this.lugarAtual = 0;
	}

    public void adicionarLugar(String code) {
		lugares[lugarAtual++] = code;
	}

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String[] getLugares() {
        return this.lugares;
    }

    public void setLugares(String[] lugares) {
        this.lugares = lugares;
    }

    public int getNumPassageiros() {
        return this.numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public char getClasse() {
        return this.classe;
    }

    public void setClasse(char classe) {
        this.classe = classe;
    }

    public int getLugarAtual() {
        return this.lugarAtual;
    }

    public void setLugarAtual(int lugarAtual) {
        this.lugarAtual = lugarAtual;
    }
   

}