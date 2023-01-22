
public class Conta {
    protected int nroDaConta;
    protected double saldoAtual;
    protected String dataAbertura;
    protected String dataUltimaMovimentacao;
    protected int agenciaBancaria;
    protected boolean ativa;

    private String senha;

    public Conta() {
    }

    public Conta(int nroDaConta, double saldoAtual, String dataAbertura, String dataUltimaMovimentacao, int agenciaBancaria) {
        this.nroDaConta = nroDaConta;
        this.saldoAtual = saldoAtual;
        this.dataAbertura = dataAbertura;
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
        this.agenciaBancaria = agenciaBancaria;
    }

    public int getNroDaConta() { return nroDaConta; }

    public void setNroDaConta(int nroDaConta) { this.nroDaConta = nroDaConta; }

    public double getSaldoAtual() { return saldoAtual; }

    public void setSaldoAtual(double saldoAtual) { this.saldoAtual = saldoAtual; }

    public String getDataAbertura() { return dataAbertura; }

    public void setDataAbertura(String dataAbertura) { this.dataAbertura = dataAbertura; }

    public String getDataUltimaMovimentacao() { return dataUltimaMovimentacao; }

    public void setDataUltimaMovimentacao(String dataUltimaMovimentacao) { this.dataUltimaMovimentacao = dataUltimaMovimentacao; }

    public int getAgenciaBancaria() { return agenciaBancaria; }

    public void setAgenciaBancaria(int agenciaBancaria) { this.agenciaBancaria = agenciaBancaria; }

    public int getNroConta() {
        return nroDaConta;
    }
    public boolean getStatusConta() { return ativa; }

    public void setStatusConta(boolean status) { this.ativa = status; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) {
        PasswordEncoder password = new PasswordEncoder();
        this.senha = password.stringToBase64(senha);
    }

    public boolean isSenhaCorreta(String senhaDigitada, String senhaArmazenada) {
        PasswordEncoder password = new PasswordEncoder();
        if (password.stringToBase64(senhaDigitada) == this.senha)
             return true;
        else
            return false;
    }
}
