import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/*
 *@desc Classe responsável pela inclusão de dados em um arquivo binário
 */
public class Persist {
	public static boolean gravarConta(Conta conta) {

		try {
			FileWriter arq = new FileWriter("src/Contas/" + conta.getNroConta() + ".txt");
			PrintWriter out = new PrintWriter(arq);
			String linha = conta.getNroConta() + ":" + conta.getSaldoAtual() + ":" + conta.getDataAtual() + ":" + conta.getDataAbertura() + ":" + conta.getDataUltimaMovimentacao() + ":" + conta.getAgencia() + ":" + conta.getAtiva() + ":" + conta.getSenha();
			out.println(linha);
			out.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
