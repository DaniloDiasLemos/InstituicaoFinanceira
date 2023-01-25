import java.util.InputMismatchException;

public abstract class Pessoa {
    private int CPF;
    private String nome;
    private String endereco;
    private String estadoCivil;
    private String dataNascimento;

    public Pessoa(){
    }

    public Pessoa(int CPF, String nome, String endereco, String estadoCivil, String dataNascimento){
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa(int CPF, String nome){
        this.CPF = CPF;
        this.nome = nome;
    }

    private boolean cpfValido(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
                || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public int getCPF() { return CPF; }

    public void setCPF(int CPF) { this.CPF = CPF; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEstadoCivil() { return estadoCivil; }

    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
}
