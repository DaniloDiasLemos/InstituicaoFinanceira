public class Cliente extends Pessoa {
    private String escolaridade;
    private int agenciaBancaria;

    public Cliente() {
    }

    public Cliente(int CPF, String nome, String endereco, String estadoCivil, String escolaridade,
            String dataNascimento, int agenciaBancaria) {
        super(CPF, nome, endereco, estadoCivil, dataNascimento);
        this.escolaridade = escolaridade;
        this.agenciaBancaria = agenciaBancaria;
    }

}
