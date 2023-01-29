import persist.Persist;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Bonificacao {
    private String escolaridade;
    private AgenciaBancaria agenciaBancaria;
    private static final String arquivo = "clientes.bin";

    protected List<Conta> contas;
    public Cliente() {
    }

    public Cliente(String CPF, String nome, String endereco, String estadoCivil, String escolaridade,
            String dataNascimento, AgenciaBancaria agenciaBancaria) {
        super(CPF, nome, endereco, estadoCivil, dataNascimento);
        this.escolaridade = escolaridade;
        this.agenciaBancaria = agenciaBancaria;
    }

    public Cliente(String CPF, String nome) {
       super(CPF,nome);
    }

    public void setEscolaridade(String escolaridade) { this.escolaridade = escolaridade; }

    public void setAgenciaBancaria(AgenciaBancaria agenciaBancaria) { this.agenciaBancaria = agenciaBancaria; }

    // Salva os clientes em um arquivo binário
    public static void gravarClientes(ArrayList<Cliente> clientes) {
        boolean salvo = true;

        if (!clientes.isEmpty()) {
            for (Cliente c : clientes) {
                salvo = salvo && Persist.gravar(c, arquivo);
            }

            if (salvo)
                System.out.println("Sucesso. Clientes salvos com sucesso!");
            else
                throw new RuntimeException("Erro. Ocorreu um erro ao salvar os clientes, tente novamente!");
        } else
            throw new RuntimeException("Erro. Sem registros para salvar!");
    }

    public void darBrindes()
    {
        for (int i = 0; i < contas.size(); i++)
        contas.get(i).setSaldoAtual(contas.get(i).getSaldoAtual() + 10);
    }
}
