public class Conta {
    protected int nroDaConta;
    protected double saldoAtual;
    protected String dataAbertura;
    protected String dataUltimaMovimentacao;
    protected int agenciaBancaria;

    public Conta() {
    }

    public Conta(int nroDaConta, double saldoAtual, String dataAbertura, String dataUltimaMovimentacao, int agenciaBancaria) {
        this.nroDaConta = nroDaConta;
        this.saldoAtual = saldoAtual;
        this.dataAbertura = dataAbertura;
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
        this.agenciaBancaria = agenciaBancaria;
    }

}
