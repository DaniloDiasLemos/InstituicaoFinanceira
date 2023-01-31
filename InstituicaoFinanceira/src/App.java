import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas agencias deseja cadastrar?");
        int qtdAgencias = sc.nextInt();
        sc.nextLine();
        System.out.println("Quantos clientes deseja cadastrar?");
        int qtdClientes = sc.nextInt();
        sc.nextLine();

        AgenciaBancaria[] agencia = new AgenciaBancaria[qtdAgencias];
        Cliente[] cliente = new Cliente[qtdClientes];

        for (int i = 0; i < agencia.length; i++) {
            agencia[i] = new AgenciaBancaria();
            System.out.println("Digite o numero da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setNumero(sc.nextInt());
            sc.nextLine();
            System.out.println("Digite o nome da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setNome(sc.nextLine());
            System.out.println("Digite a cidade da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setCidade(sc.nextLine());
            System.out.println("Digite o estado da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setEstado(sc.nextLine());
            System.out.println("Digite o bairro da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setBairro(sc.nextLine());
            System.out.println("");
            AgenciaBancaria.gravarAgencias(agencia[i]);
        }

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
            cliente[i].setAgenciaBancaria(agencia[(0 + (int) (Math.random() * ((qtdAgencias - 0))))]);
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

            Cliente.gravarClientes(cliente[i]);
        }

        Transacao tr = new Transacao(cliente[0].contas.get(0), "30/01/2023");
        tr.depositar(10000);
        tr.sacar(1000);
        tr.consultarSaldo();
        tr.efetuarPagamento(5000);
        tr.consultarSaldo();

        Cliente.lerCliente("22344322345");

        sc.close();
    }
}
