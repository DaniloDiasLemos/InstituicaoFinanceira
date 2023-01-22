public class ContaSalario extends Conta {
    private double limiteSaque;
    private double limiteTransferencia;

    public ContaSalario(int nroDaConta, double saldoAtual, String dataAbertura, String dataUltimaMovimentacao,
            double limiteSaque, double limiteTransferencia, int agenciaBancaria) {
        super(nroDaConta, saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria);
        this.limiteSaque = limiteSaque;
        this.limiteTransferencia = limiteTransferencia;
    }

}
