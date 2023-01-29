public class ContaCorrente extends Conta implements Bonificacao {
    private double limiteChequeEspecial;
    private double taxaAdministrativa;

    public ContaCorrente(double saldoAtual, String dataAbertura, String dataUltimaMovimentacao,
            double limiteChequeEspecial, double taxaAdministrativa, AgenciaBancaria agenciaBancaria, Cliente cliente1) {
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

    public void darBrindes() {
        // Quando ativar esse metódo será dado R$10,00 para os clientes da conta gastar
        // como quiser;
        setSaldoAtual(getSaldoAtual() + 10);
    }
}
