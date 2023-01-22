public class AgenciaBancaria {
    private int numero;
    private String nome;
    private String cidade;
    private String estado;
    private String bairro;

    public AgenciaBancaria() {

    }

    public AgenciaBancaria(int numero, String nome, String cidade, String estado, String bairro) {
        this.numero = numero;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
    }
}
