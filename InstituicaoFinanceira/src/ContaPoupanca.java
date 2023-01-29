public class ContaPoupanca extends Conta {
    private double rendimentoMesAtual;

    public ContaPoupanca(double saldoAtual, String dataAbertura, String dataUltimaMovimentacao,
            double rendimentoMesAtual, AgenciaBancaria agenciaBancaria, Cliente cliente1) {
        super(saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria, cliente1);
        this.rendimentoMesAtual = rendimentoMesAtual;
    }
}
