import java.io.Serializable;
import java.util.ArrayList;

public class AgenciaBancaria implements Serializable {
    private int numero;
    private String nome;
    private String cidade;
    private String estado;
    private String bairro;

    private ArrayList<Conta> contas;
    private ArrayList<Funcionario> funcionarios;

    public AgenciaBancaria() {

    }

    public AgenciaBancaria(int numero, String nome, String cidade, String estado, String bairro) {
        this.numero = numero;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        contas = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas = new ArrayList<>();
        contas.add(conta);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public String toString() {
        return "AgenciaBancaria{" + "numero=" + numero + ", nome='" + nome + '\'' + ", cidade='" + cidade + '\''
                + ", estado='" + estado + '\'' + ", bairro='" + bairro + '\'' + ", contas=" + contas + ", funcionarios=" + funcionarios + '}';
    }

    // GETTER E SETTERS
    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
