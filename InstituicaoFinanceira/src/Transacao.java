public class Transacao {
    private String dataAtual;
    private String meio;
    private Conta conta; // Conta informada para realizar saque, depósito, consultar saldo e efetuar
                         // pagamento

    public Transacao(Conta conta, String data) {
        this.conta = conta;
        this.dataAtual = data;
    }

    public void sacar(Conta conta, double valor) {
        // CONTA INATIVA
        if (!conta.getStatusConta()) {
            System.out.println("Saque negado! Conta Inativa!");
        } else {
            // CONTA ATIVA
            if (conta instanceof ContaPoupanca || conta instanceof ContaSalario) // Não utiliza limite cheque especial
                if (conta.getSaldoAtual() >= valor) {
                    conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                    System.out.println("Saque realizado com sucesso!");
                }

            if (conta instanceof ContaCorrente)
                if (conta.getSaldoAtual() + ((ContaCorrente) conta).getLimiteChequeEspecial() >= valor) {
                    conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                    System.out.println("Saque realizado com sucesso!");
                }
        }
    }

    public void depositar(Conta conta, double valor) {
        // CONTA INATIVA
        if (!conta.getStatusConta()) {
            System.out.println("Depósito negado! Conta Inativa!");
        } else {
            // CONTA ATIVA
            conta.setSaldoAtual(conta.getSaldoAtual() + valor);
            System.out.println("Depósito realizado com sucesso!");
        }
    }

    public void consultarSaldo(Conta conta) {
        // CONTA INATIVA
        if (!conta.getStatusConta()) {
            System.out.println("Operação negada! Conta Inativa!");
        } else {
            System.out.println("Saldo atual da conta: " + conta.getSaldoAtual());
        }
    }

    public void efetuarPagamento(Conta conta, double valor) {
        // CONTA INATIVA
        if (!conta.getStatusConta()) {
            System.out.println("Operação negada! Conta Inativa!");
        } else {
            // CONTA ATIVA
            if (conta instanceof ContaPoupanca || conta instanceof ContaSalario) // Não utiliza limite cheque especial
                if (conta.getSaldoAtual() >= valor) {
                    conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                    System.out.println("Pagamento realizado com sucesso!");
                }

            if (conta instanceof ContaCorrente)
                if (conta.getSaldoAtual() + ((ContaCorrente) conta).getLimiteChequeEspecial() >= valor) {
                    conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                    System.out.println("Pagamento realizado com sucesso!");
                }
        }
    }

}