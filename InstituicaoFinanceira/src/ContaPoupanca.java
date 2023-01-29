public class ContaPoupanca extends Conta {
    private double rendimentoMesAtual;

    public ContaPoupanca(double saldoAtual, String dataAbertura, String dataUltimaMovimentacao, AgenciaBancaria agenciaBancaria, Cliente cliente1, double rendimentoMesAtual) {
        super(saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria, cliente1);
        this.rendimentoMesAtual = rendimentoMesAtual;
    }
}
