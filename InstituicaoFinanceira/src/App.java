import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas agencias deseja cadastrar?");
        int qtdAgencias = sc.nextInt();
        System.out.println("Quantos clientes deseja cadastrar?");
        int qtdClientes = sc.nextInt();

        AgenciaBancaria[] agencia = new AgenciaBancaria[qtdAgencias];
        Cliente[] cliente = new Cliente[qtdClientes];
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<AgenciaBancaria> agencias = new ArrayList<>();

        for (int i = 0; i < agencia.length; i++) {
            agencia[i] = new AgenciaBancaria();
            System.out.println("Digite o nome da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setNome(sc.next());
            System.out.println("Digite a cidade da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setCidade(sc.next());
            System.out.println("Digite o estado da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setEstado(sc.next());
            System.out.println("Digite o bairro da " + (i + 1) + "ª agencia bancaria: ");
            agencia[i].setBairro(sc.next());
            System.out.println("");
            agencias.add(agencia[i]);
        }

        for (int i = 0; i < cliente.length; i++) {
            cliente[i] = new Cliente();
            System.out.println("Digite o nome do " + (i + 1) + "° cliente: ");
            cliente[i].setNome(sc.next());
            System.out.println("Digite o CPF do " + (i + 1) + "° cliente: ");
            cliente[i].setCPF(sc.next());
            System.out.println("Digite o endereço do " + (i + 1) + "° cliente: ");
            cliente[i].setEndereco(sc.next());
            System.out.println("Digite o estado civil do " + (i + 1) + "° cliente: ");
            cliente[i].setEstadoCivil(sc.next());
            System.out.println("Digite a escolaridade do " + (i + 1) + "° cliente: ");
            cliente[i].setEscolaridade(sc.next());
            System.out.println("Digite a data de nascimento do " + (i + 1) + "° cliente: ");
            cliente[i].setDataNascimento(sc.next());
            // adiciona uma agencia aleatoria ao cliente
            cliente[i].setAgenciaBancaria(agencia[(0 + (int) (Math.random() * ((qtdAgencias - 0))))]);
            System.out.println("");
            //Escolhe tipo de conta do cliente
            System.out.println("Qual tipo de conta do cliente? (1-corrente; 2-poupança; 3-salario)");
            int tipoConta = sc.nextInt();
            if (tipoConta == 1) {
                ContaCorrente conta = new ContaCorrente(0, 0, 0, cliente[i].getAgenciaBancaria(),
                        cliente[i]);
                cliente[i].adicionarConta(conta);
            } else {
                if (tipoConta == 2) {
                    Conta conta = new ContaPoupanca(0, 0, cliente[i].getAgenciaBancaria(),
                            cliente[i]);
                    cliente[i].adicionarConta(conta);
                } else {
                    Conta conta = new ContaSalario(0, 0, 0, cliente[i].getAgenciaBancaria(),
                            cliente[i]);
                    cliente[i].adicionarConta(conta);
                }
            }
            ;

            clientes.add(cliente[i]);
        }

        Cliente.gravarClientes(clientes);
    }
}
