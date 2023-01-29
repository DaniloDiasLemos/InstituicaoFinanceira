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

        for (int i = 0; i < agencia.length; i++) {
            System.out.println(agencia[i].getNome());
            System.out.println("");
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
            System.out.println("");
            clientes.add(cliente[i]);
        }

        for (int i = 0; i < cliente.length; i++) {
            System.out.println(cliente[i].getNome());
            System.out.println("");
        }

        Cliente.gravarClientes(clientes);
    }
}
