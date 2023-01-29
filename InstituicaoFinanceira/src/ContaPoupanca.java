public class ContaPoupanca extends Conta {
    private double rendimentoMesAtual;

    public ContaPoupanca(double saldoAtual, double rendimentoMesAtual, AgenciaBancaria agenciaBancaria,
            Cliente cliente1) {
        super(saldoAtual, agenciaBancaria, cliente1);
        this.rendimentoMesAtual = rendimentoMesAtual;
    }
}
