import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos clientes deseja cadastrar?");
        int qtdClientes = sc.nextInt();
        sc.nextLine();

        AgenciaBancaria[] agencia = new AgenciaBancaria[2];
        Gerente[] gerente = new Gerente[2];
        Cliente[] cliente = new Cliente[qtdClientes];
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        agencia[0] = new AgenciaBancaria(1, "Itau", "Uberlandia", "MG", "Santa Monica");
        agencia[1] = new AgenciaBancaria(2, "Brasil", "Araguari", "MG", "Bronx");

        gerente[0] = new Gerente("11245455684", "Jose Juao", 123, 123465, "01/10/1880", "Rua alvorada", "Masculino",
                "Solteiro", "Gerente", 8000, 2000, "01/01/2000", agencia[0], true);
        funcionarios.add(gerente[0]);
        agencia[0].setFuncionarios(funcionarios);
        gerente[1] = new Gerente("11245455685", "Paula Juao", 1234, 1234656, "01/10/1999", "Rua alvorada", "Feminino",
                "Casada", "Gerente", 80000, 2000, "01/01/2000", agencia[1], true);
        funcionarios.add(gerente[1]);
        agencia[1].setFuncionarios(funcionarios);

        for (int i = 0; i < cliente.length; i++) {
            cliente[i] = new Cliente();
            System.out.println("Digite o nome do " + (i + 1) + "° cliente: ");
            cliente[i].setNome(sc.nextLine());
            System.out.println("Digite o CPF do " + (i + 1) + "° cliente: ");
            cliente[i].setCPF(sc.nextLine());
            System.out.println("Digite o endereço do " + (i + 1) + "° cliente: ");
            cliente[i].setEndereco(sc.nextLine());
            System.out.println("Digite o estado civil do " + (i + 1) + "° cliente: ");
            cliente[i].setEstadoCivil(sc.nextLine());
            System.out.println("Digite a escolaridade do " + (i + 1) + "° cliente: ");
            cliente[i].setEscolaridade(sc.nextLine());
            System.out.println("Digite a data de nascimento do " + (i + 1) + "° cliente: ");
            cliente[i].setDataNascimento(sc.nextLine());
            // adiciona uma agencia aleatoria ao cliente
            cliente[i].setAgenciaBancaria(agencia[(0 + (int) (Math.random() * ((agencia.length - 0))))]);
            System.out.println("");
            // Escolhe tipo de conta do cliente
            System.out.println("Qual tipo de conta do cliente? (1-corrente; 2-poupança; 3-salario)");
            int tipoConta = sc.nextInt();
            sc.nextLine();
            if (tipoConta == 1) {
                ContaCorrente conta = new ContaCorrente(0, 0, 0, cliente[i].getAgenciaBancaria(),
                        cliente[i]);
                System.out.println("Qual o limite do cheque especial desta conta? ");
                conta.setLimiteChequeEspecial(sc.nextDouble());
                sc.nextLine();
                System.out.println("Qual a taxa administrativa desta conta? ");
                conta.setTaxaAdministrativa(sc.nextDouble());
                sc.nextLine();
                System.out.println("Cadastre a senha para esse cliente: ");
                conta.setSenha(sc.nextLine());
                conta.gravarContas(conta);
                cliente[i].adicionarConta(conta);
            } else {
                if (tipoConta == 2) {
                    ContaPoupanca conta = new ContaPoupanca(0, 0, cliente[i].getAgenciaBancaria(),
                            cliente[i]);
                    System.out.println("Cadastre a senha para esse cliente: ");
                    conta.setSenha(sc.nextLine());
                    cliente[i].adicionarConta(conta);
                    conta.gravarContas(conta);
                    cliente[i].adicionarConta(conta);
                } else {
                    ContaSalario conta = new ContaSalario(0, 0, 0, cliente[i].getAgenciaBancaria(),
                            cliente[i]);
                    System.out.println("Qual o limite de saque desta conta? ");
                    conta.setLimiteSaque(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Qual o limite de transferencia desta conta? ");
                    conta.setLimiteTransferencia(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Cadastre a senha para esse cliente: ");
                    conta.setSenha(sc.nextLine());
                    cliente[i].adicionarConta(conta);
                    conta.gravarContas(conta);
                    cliente[i].adicionarConta(conta);
                }
            }
            ;
        }
    
        Transacao tr = new Transacao(cliente[0].contas.get(0), "30/01/2023");
        System.out.println("\nDepositando 10000 reais na conta");
        tr.depositar(10000);
        System.out.println("\nSacando 1000 reais da conta");
        tr.sacar(1000);
        System.out.println("\nConsultando saldo da conta");
        tr.consultarSaldo();
        System.out.println("\nEfetuando pagamento de 5000 reais");
        tr.efetuarPagamento(5000);
        System.out.println("\nConsultando saldo da conta");
        tr.consultarSaldo();
        System.out.println(" ");

        sc.close();
    }
}
