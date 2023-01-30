import java.time.Year;
import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private final String arquivo = "funcionarios.bin";
    protected String CPF;
    protected String nome;
    protected int nroCarteiraDeTrabalho;
    protected int RG;
    protected String dataNascimento;
    protected String endereco;
    protected String sexo;
    protected String estadoCivil;
    protected String cargo;
    protected double salario;
    protected int anoDeIngresso;

    public Funcionario() {

    }

    public Funcionario(
            String CPF, String nome, int nroCarteiraDeTrabalho, int RG, String dataNascimento, String endereco,
            String sexo, String estadoCivil, String cargo, double salario, int anoDeIngresso) {
        super(CPF, nome, endereco, estadoCivil, dataNascimento);
        this.nroCarteiraDeTrabalho = nroCarteiraDeTrabalho;
        this.RG = RG;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
        this.anoDeIngresso = anoDeIngresso;
    }

    // método para calcular salário base mais um adicional de 10% caso o funcionario
    // tenha mais que 15 anos de empresa.

    public double calcularSalario() {
        int year = Year.now().getValue();
        if (year - this.anoDeIngresso > 15) {
            double novoSalario = salario + (0.1 * this.salario);
            return novoSalario;
        } else {
            return this.salario;
        }
    }

    // Salva os endereços em um arquivo binário
    public void gravarFuncionarios(ArrayList<Funcionario> funcionarios) {
        boolean salvo = true;

        if (!funcionarios.isEmpty()) {
            for (Funcionario f : funcionarios) {
                salvo = salvo && Persist.gravar(f, this.arquivo);
            }

            if (salvo)
                System.out.println("Sucesso. Funcionários salvos com sucesso!");
            else
                throw new RuntimeException("Erro. Ocorreu um erro ao salvar os funcionários, tente novamente!");
        } else
            throw new RuntimeException("Erro. Sem registros para salvar!");
    }
}
