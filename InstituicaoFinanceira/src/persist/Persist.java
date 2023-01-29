package persist;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
 *@desc Classe responsável pela inclusão de dados em um arquivo binário
 */
public class Persist{
	private static FileOutputStream arquivo = null;
	private static ObjectOutputStream  objGravar = null;
	
	public static boolean gravar(Object obj,String nomeArquivo){
		try {
			//Gera o arquivo para amazenar os objetos
			arquivo = new FileOutputStream(nomeArquivo);

			//Insere os dados no arquivo
			objGravar = new ObjectOutputStream(arquivo);	
			objGravar.writeObject(obj);

			//Termina
			objGravar.flush();
			objGravar.close();
			arquivo.flush();
			arquivo.close();
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
