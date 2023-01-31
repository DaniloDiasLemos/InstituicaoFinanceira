import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos clientes deseja cadastrar?");
        int qtdClientes = sc.nextInt();
        sc.nextLine();

        AgenciaBancaria[] agencia = new AgenciaBancaria[5];
        Cliente[] cliente = new Cliente[qtdClientes];

        agencia[0] = new AgenciaBancaria(1, "Itau", "Uberlandia", "MG", "Santa Monica");
        agencia[1] = new AgenciaBancaria(2, "Brasil", "Araguari", "MG", "Bronx");
        agencia[2] = new AgenciaBancaria(3, "Internacional", "Uberaba", "MG", "Santa Helena");
        agencia[3] = new AgenciaBancaria(4, "Bradesco", "Rio de janeiro", "RJ", "Copa");
        agencia[4] = new AgenciaBancaria(5, "Nubank", "São Paulo", "SP", "Sul");

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
                conta.gravarContas(conta);
                System.out.println("Qual o limite do cheque especial desta conta? ");
                conta.setLimiteChequeEspecial(sc.nextDouble());
                sc.nextLine();
                System.out.println("Qual a taxa administrativa desta conta? ");
                conta.setTaxaAdministrativa(sc.nextDouble());
                sc.nextLine();
                System.out.println("Cadastre a senha para esse cliente: ");
                conta.setSenha(sc.nextLine());
                cliente[i].adicionarConta(conta);
            } else {
                if (tipoConta == 2) {
                    ContaPoupanca conta = new ContaPoupanca(0, 0, cliente[i].getAgenciaBancaria(),
                            cliente[i]);
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
                    cliente[i].adicionarConta(conta);
                }
            }
            ;
        }

        Transacao tr = new Transacao(cliente[0].contas.get(0), "30/01/2023");
        tr.depositar(10000);
        tr.sacar(1000);
        tr.consultarSaldo();
        tr.efetuarPagamento(5000);
        tr.consultarSaldo();

        sc.close();
    }
}
