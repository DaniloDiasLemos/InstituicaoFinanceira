public class Gerente extends Funcionario {
    private String dataDeIngresso;
    private AgenciaBancaria agenciaBancaria;
    private boolean formacaoEmGerencia;
    static private double comissao = 0;

    public Gerente(
            String CPF, String nome, int nroCarteiraDeTrabalho, int RG, String dataNascimento, String endereco,
            String sexo, String estadoCivil, String cargo, double salario, int anoDeIngresso, String dataDeIngresso,
            AgenciaBancaria agenciaBancaria, boolean formacaoEmGerencia) {
        super(CPF, nome, nroCarteiraDeTrabalho, RG, dataNascimento, endereco, sexo, estadoCivil, cargo, salario,
                anoDeIngresso);
        this.dataDeIngresso = dataDeIngresso;
        this.agenciaBancaria = agenciaBancaria;
        this.formacaoEmGerencia = formacaoEmGerencia;
    }

    public static void setComissao(double a) {
        comissao = a;
    }

    public static void getComissao() {
        System.out.println("Comissão: " + comissao);
    }

    
    // método para calcular Salario para gerentes, calculado pela
    // soma do salário de um funcionário comum acrescido pela comissão recebida por
    // gerenciar
    // uma agência bancária

    public double calcularSalario() {
        double novoSalario = this.salario + comissao;
        return novoSalario;
    }
}
