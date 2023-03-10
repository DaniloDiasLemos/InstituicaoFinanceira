import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Conta implements Serializable {
    protected int nroDaConta;
    protected double saldoAtual;
    Date dataAtual = new Date();
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    protected String dataAbertura;
    protected String dataUltimaMovimentacao;
    protected AgenciaBancaria agencia;
    protected boolean ativa;
    private String senha;

    /*
     * Toda conta bancária deve ter no mínimo um cliente associado. No entanto, uma
     * conta pode ser
     * conjunta. Nesse caso, é possível ter dois clientes associados à mesma conta.
     * Um mesmo cliente
     * pode ter diferentes contas bancárias.
     */
    protected List<Cliente> cliente;
    Random random = new Random();

    public Conta() {
    }

    public Conta(double saldoAtual, AgenciaBancaria agenciaBancaria, Cliente cliente1) {
        this.nroDaConta = random.nextInt(900) + 100; // Quando uma conta for criada, o construtor vai gerar um número de
                                                     // conta aleatório de 3 digitos
        this.saldoAtual = saldoAtual;
        this.dataAbertura = formatoData.format(dataAtual);
        this.agencia = agenciaBancaria;
        this.ativa = true;
        cliente = new ArrayList<>();
        cliente.add(cliente1);
        agenciaBancaria.adicionarConta(this);
    }

    public int getNroDaConta() {
        return nroDaConta;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setNroDaConta(int nroDaConta) {
        this.nroDaConta = nroDaConta;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataUltimaMovimentacao() {
        return dataUltimaMovimentacao;
    }

    public void setDataUltimaMovimentacao(String dataUltimaMovimentacao) {
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
    }

    public AgenciaBancaria getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaBancaria agencia) {
        this.agencia = agencia;
    }

    public int getNroConta() {
        return nroDaConta;
    }

    public boolean getStatusConta() {
        return ativa;
    }

    public void setStatusConta(boolean status) {
        this.ativa = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        PasswordEncoder password = new PasswordEncoder();
        this.senha = password.stringToBase64(senha);
    }

    public boolean isSenhaCorreta(String senhaDigitada, String senhaArmazenada) {
        PasswordEncoder password = new PasswordEncoder();
        if (password.stringToBase64(senhaDigitada).equals(this.senha))
            return true;
        else
            return false;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public void gravarContas(Conta contas) {
        boolean salvo = true;

        if (contas != null) {
            
            salvo = salvo && Persist.gravarConta(contas);

            if (salvo)
                System.out.println("Sucesso. Conta salva com sucesso!");
            else
                throw new RuntimeException("Erro. Ocorreu um erro ao salvar a conta, tente novamente!");
        } else
            throw new RuntimeException("Erro. Sem registros para salvar!");
    }

    @Override
    public String toString() {
        if (this.cliente.size() == 1) {
            return "Conta{" +
                    "nroDaConta=" + nroDaConta +
                    ", saldoAtual=" + saldoAtual +
                    ", dataAtual=" + dataAtual +
                    ", formatoData=" + formatoData +
                    ", dataAbertura='" + dataAbertura + '\'' +
                    ", dataUltimaMovimentacao='" + dataUltimaMovimentacao + '\'' +
                    ", ativa=" + ativa +
                    ", senha='" + senha + '\'' +
                    ", cliente=" + cliente.get(0).getNome() +
                    '}';
        }else{
            return "Conta{" +
                    "nroDaConta=" + nroDaConta +
                    ", saldoAtual=" + saldoAtual +
                    ", dataAtual=" + dataAtual +
                    ", formatoData=" + formatoData +
                    ", dataAbertura='" + dataAbertura + '\'' +
                    ", dataUltimaMovimentacao='" + dataUltimaMovimentacao + '\'' +
                    ", ativa=" + ativa +
                    ", senha='" + senha + '\'' +
                    ", cliente=" + cliente.get(0).getNome() + 
                    ", cliente=" + cliente.get(1).getNome() + 
                    '}';
        }
    }
}
