public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;
    private double taxaAdministrativa;

    public ContaCorrente(int nroDaConta, double saldoAtual, String dataAbertura, String dataUltimaMovimentacao,
            double limiteChequeEspecial, double taxaAdministrativa, int agenciaBancaria) {
        super(nroDaConta, saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaAdministrativa = taxaAdministrativa;
    }
}
