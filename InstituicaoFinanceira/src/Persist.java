import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/*
 *@desc Classe responsável pela inclusão de dados em um arquivo binário
 */
public class Persist {
	private static FileOutputStream arquivo = null;
	private static ObjectOutputStream objGravar = null;

	public static boolean gravarCliente(Cliente cliente, String nomeArquivo) {

		try {
			FileWriter arq = new FileWriter("src/Clientes/" + cliente.getCPF() + ".txt");
			PrintWriter out = new PrintWriter(arq);
			String linha = cliente.getNome() + ":" + cliente.getCPF() + ":" + cliente.getEndereco() + ":" + cliente.getEscolaridade() + ":" + cliente.getEndereco() + ":" + cliente.getEstadoCivil() + ":" + cliente.getDataNascimento() + ":" + cliente.getAgenciaBancaria();
			out.println(linha);
			out.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		// try {
		// 	// Gera o arquivo para amazenar os objetos
		// 	arquivo = new FileOutputStream(nomeArquivo);

		// 	// Insere os dados no arquivo
		// 	objGravar = new ObjectOutputStream(arquivo);
		// 	objGravar.writeObject(obj);

		// 	// Termina
		// 	objGravar.flush();
		// 	objGravar.close();
		// 	arquivo.flush();
		// 	arquivo.close();
		// 	return true;
		// } catch (Exception e) {
		// 	System.out.println(e.getMessage());
		// 	return false;
		// }
	}
}
