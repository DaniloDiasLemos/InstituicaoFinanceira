import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Bonificacao {
    private String escolaridade;
    private AgenciaBancaria agenciaBancaria;
    protected List<Conta> contas;

    public Cliente() {
    }

    public Cliente(String CPF, String nome, String endereco, String estadoCivil, String escolaridade,
            String dataNascimento, AgenciaBancaria agenciaBancaria) {
        super(CPF, nome, endereco, estadoCivil, dataNascimento);
        this.escolaridade = escolaridade;
        this.agenciaBancaria = agenciaBancaria;
        this.contas = new ArrayList<>();
    }

    public Cliente(String CPF, String nome) {
        super(CPF, nome);
    }

    public void adicionarConta(Conta conta) {
        this.contas = new ArrayList<>();
        this.contas.add(conta);
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public void setAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    public String getEscolaridade() {
        return this.escolaridade;
    }

    public AgenciaBancaria getAgenciaBancaria() {
        return this.agenciaBancaria;
    }

    // Salva o cliente em um arquivo de texto
    public static void gravarClientes(Cliente cliente) {
        boolean salvo = true;

        salvo = salvo && Persist.gravarCliente(cliente);

        if (salvo)
            System.out.println("Sucesso. Cliente salvo com sucesso!");
        else
            throw new RuntimeException("Erro. Ocorreu um erro ao salvar os clientes, tente novamente!");
    }

    // Lê o cliente em um arquivo texto
    public static void lerCliente(String cpf) {
        try {
            FileReader ent = new FileReader("src/Clientes/" + cpf + ".txt");
            BufferedReader br = new BufferedReader(ent);
            String linha;
            String[] campos;

            while ((linha = br.readLine()) !=  null) {
                campos = linha.split(":");
                String nome = campos[0];
                String CPF = campos[1];
                String endereco = campos[2];
                String escolaridade = campos[3];
                String estadoCivil = campos[4];
                String dataNascimento = campos[5];

                System.out.println("Nome: " + nome + ", CPF: " + CPF + ", Endereço: " + endereco + ", Escolaridade: " + escolaridade + ", Estado Civil: " + estadoCivil + ", Data Nascimento: " + dataNascimento);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Cliente não encontrado");
        }
    }

    public void darBrindes() {
        // Quando ativar esse metódo será dado R$10,00 para todas as contas do cliente
        // para gastar como quiser;
        for (int i = 0; i < contas.size(); i++)
            contas.get(i).setSaldoAtual(contas.get(i).getSaldoAtual() + 10);
    }
}
