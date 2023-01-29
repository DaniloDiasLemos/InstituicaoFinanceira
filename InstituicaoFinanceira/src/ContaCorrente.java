public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;
    private double taxaAdministrativa;

    public ContaCorrente(double saldoAtual, String dataAbertura, String dataUltimaMovimentacao, AgenciaBancaria agenciaBancaria, Cliente cliente1, double limiteChequeEspecial, double taxaAdministrativa) {
        super(saldoAtual, dataAbertura, dataUltimaMovimentacao, agenciaBancaria, cliente1);
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

