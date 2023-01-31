import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Transacao {
    Scanner sc = new Scanner(System.in);
    Date dataAtual = new Date();
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    private String dataHoje = formatoData.format(dataAtual); //Transforma a data atual em String
    private String meio;
    private Conta conta; // Conta informada para realizar saque, depósito, consultar saldo e efetuar
                         // pagamento

    public Transacao(Conta conta, String data) {
        this.conta = conta;
        this.dataHoje = data;
    }

    public void sacar(double valor) {
        // CONTA INATIVA
        System.out.println("Insira a senha para prosseguir: ");
        String senha = sc.nextLine();
        if (conta.isSenhaCorreta(senha, conta.getSenha())) {
            if (!conta.getStatusConta()) {
                System.out.println("Saque negado! Conta Inativa!");
            } else {
                // CONTA ATIVA
                if (conta instanceof ContaPoupanca || conta instanceof ContaSalario) // Não utiliza limite cheque especial
                    if (conta.getSaldoAtual() >= valor) {
                        conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                        System.out.println("Saque realizado com sucesso!");
                        conta.setDataUltimaMovimentacao(dataHoje);
                    }

                if (conta instanceof ContaCorrente)
                    if (conta.getSaldoAtual() + ((ContaCorrente) conta).getLimiteChequeEspecial() >= valor) {
                        conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                        System.out.println("Saque realizado com sucesso!");
                        conta.setDataUltimaMovimentacao(dataHoje);
                    }
            }
        }else {
            System.out.println("Senha Incorreta! ");
        }
    }

    public void depositar(double valor) {
        System.out.println("Insira a senha para prosseguir: ");
        String senha = sc.nextLine();
        if (conta.isSenhaCorreta(senha, conta.getSenha())) {
        // CONTA INATIVA
            if (!conta.getStatusConta()) {
                System.out.println("Depósito negado! Conta Inativa!");
            } else {
                // CONTA ATIVA
                conta.setSaldoAtual(conta.getSaldoAtual() + valor);
                System.out.println("Depósito realizado com sucesso!");
                conta.setDataUltimaMovimentacao(dataHoje);
            }
        }else {
            System.out.println("Senha Incorreta! ");
        }
    }

    public void consultarSaldo() {
        System.out.println("Insira a senha para prosseguir: ");
        String senha = sc.nextLine();
        if (conta.isSenhaCorreta(senha, conta.getSenha())) {
            // CONTA INATIVA
            if (!conta.getStatusConta()) {
                System.out.println("Operação negada! Conta Inativa!");
            } else {
                System.out.println("Saldo atual da conta: " + conta.getSaldoAtual());
            }
        }else {
            System.out.println("Senha Incorreta! ");
        }
    }

    public void efetuarPagamento(double valor) {
        System.out.println("Insira a senha para prosseguir: ");
        String senha = sc.nextLine();
        if (conta.isSenhaCorreta(senha, conta.getSenha())) {
        // CONTA INATIVA
        if (!conta.getStatusConta()) {
            System.out.println("Operação negada! Conta Inativa!");
        } else {
            // CONTA ATIVA
            if (conta instanceof ContaPoupanca || conta instanceof ContaSalario) // Não utiliza limite cheque especial
                if (conta.getSaldoAtual() >= valor) {
                    conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                    System.out.println("Pagamento realizado com sucesso!");
                    conta.setDataUltimaMovimentacao(dataHoje);
                }

            if (conta instanceof ContaCorrente)
                if (conta.getSaldoAtual() + ((ContaCorrente) conta).getLimiteChequeEspecial() >= valor) {
                    conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                    System.out.println("Pagamento realizado com sucesso!");
                    conta.setDataUltimaMovimentacao(dataHoje);
                }
        }
        }else {
            System.out.println("Senha Incorreta! ");
        }
    }

}