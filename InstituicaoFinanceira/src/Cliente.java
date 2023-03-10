import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Bonificacao {
    private String escolaridade;
    private AgenciaBancaria agenciaBancaria;
    protected List<Conta> contas;

    public Cliente() {
    }

    public Cliente(String CPF, String nome, String endereco, String estadoCivil, String escolaridade,
            String dataNascimento, AgenciaBancaria agenciaBancaria) {
        super(CPF, nome, endereco, estadoCivil, dataNascimento);
        this.escolaridade = escolaridade;
        this.agenciaBancaria = agenciaBancaria;
        this.contas = new ArrayList<>();
    }

    public Cliente(String CPF, String nome) {
        super(CPF, nome);
    }

    @Override
    public String toString() {
        return "Cliente{" + "escolaridade='" + escolaridade + '\'' + ", agenciaBancaria=" + agenciaBancaria
                + ", contas=" + contas + '}';
    }

    public void adicionarConta(Conta conta) {
        this.contas = new ArrayList<>();
        this.contas.add(conta);
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public void setAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    public String getEscolaridade() {
        return this.escolaridade;
    }

    public AgenciaBancaria getAgenciaBancaria() {
        return this.agenciaBancaria;
    }

    public void darBrindes() {
        // Quando ativar esse metódo será dado R$10,00 para todas as contas do cliente
        // para gastar como quiser;
        for (int i = 0; i < contas.size(); i++)
            contas.get(i).setSaldoAtual(contas.get(i).getSaldoAtual() + 10);
    }
}
