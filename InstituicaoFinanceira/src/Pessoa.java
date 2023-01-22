public class Pessoa {
    private int CPF;
    private String nome;
    private String endereco;
    private String estadoCivil;
    private String dataNascimento;

    public Pessoa(){
    }

    public Pessoa(int CPF, String nome, String endereco, String estadoCivil, String dataNascimento){
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
    }
}
