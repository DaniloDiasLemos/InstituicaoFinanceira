public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;
    private double taxaAdministrativa;

    public ContaCorrente(int nroDaConta, double saldoAtual, String dataAbertura, String dataUltimaMovimentacao,
            double limiteChequeEspecial, double taxaAdministrativa, int agenciaBancaria) {
        super(nroDaConta, saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaAdministrativa = taxaAdministrativa;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getTaxaAdministrativa() {
        return taxaAdministrativa;
    }

    public void setTaxaAdministrativa(double taxaAdministrativa) {
        this.taxaAdministrativa = taxaAdministrativa;
    }
}

