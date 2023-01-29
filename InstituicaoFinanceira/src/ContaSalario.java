public class ContaSalario extends Conta {
    private double limiteSaque;
    private double limiteTransferencia;

    public ContaSalario(double saldoAtual, String dataAbertura, String dataUltimaMovimentacao,
            double limiteSaque, double limiteTransferencia, AgenciaBancaria agenciaBancaria, Cliente cliente1) {
        super(saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria, cliente1);
        this.limiteSaque = limiteSaque;
        this.limiteTransferencia = limiteTransferencia;
    }

}
