import persist.Persist;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private String escolaridade;
    private int agenciaBancaria;
    private final String arquivo = "clientes.bin";

    public Cliente() {
    }

    public Cliente(int CPF, String nome, String endereco, String estadoCivil, String escolaridade,
            String dataNascimento, int agenciaBancaria) {
        super(CPF, nome, endereco, estadoCivil, dataNascimento);
        this.escolaridade = escolaridade;
        this.agenciaBancaria = agenciaBancaria;
    }

    public Cliente(int CPF, String nome) {
       super(CPF,nome);
    }

    // Salva os clientes em um arquivo binário
    public void gravarClientes(ArrayList<Cliente> clientes) {
        boolean salvo = true;

        if (!clientes.isEmpty()) {
            for (Cliente c : clientes) {
                salvo = salvo && Persist.gravar(c, this.arquivo);
            }

            if (salvo)
                System.out.println("Sucesso. Clientes salvos com sucesso!");
            else
                throw new RuntimeException("Erro. Ocorreu um erro ao salvar os clientes, tente novamente!");
        } else
            throw new RuntimeException("Erro. Sem registros para salvar!");
    }
}
