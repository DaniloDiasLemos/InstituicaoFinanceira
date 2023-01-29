public class ContaSalario extends Conta {
    private double limiteSaque;
    private double limiteTransferencia;

    public ContaSalario(double saldoAtual,
            double limiteSaque, double limiteTransferencia, AgenciaBancaria agenciaBancaria, Cliente cliente1) {
        super(saldoAtual, agenciaBancaria, cliente1);
        this.limiteSaque = limiteSaque;
        this.limiteTransferencia = limiteTransferencia;
    }

}
