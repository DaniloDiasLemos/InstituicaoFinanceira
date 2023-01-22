public class ContaPoupanca extends Conta {
    private double rendimentoMesAtual;

    public ContaPoupanca(int nroDaConta, double saldoAtual, String dataAbertura, String dataUltimaMovimentacao,
            double rendimentoMesAtual, int agenciaBancaria) {
        super(nroDaConta, saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria);
        this.rendimentoMesAtual = rendimentoMesAtual;
    }
}
