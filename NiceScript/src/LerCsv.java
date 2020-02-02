import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerCsv {
	ArrayList<Integer> dadosColuna;
	int tamanhoTabela = 0;
	String nomeTabela;
	String diretorio;
	ArrayList<String> valores;
	boolean id = false;

	public LerCsv (ArrayList<Integer> dadosColuna, String nomeTabela, String diretorio, boolean id){
		this.dadosColuna = dadosColuna;
		this.nomeTabela = nomeTabela;
		this.diretorio = diretorio;
		valores = csv(id);
		removeRepetidas();
	}
	
	public String devolveString() {
		String script = "INSERT INTO "+nomeTabela +" VALUES\n";
		for (int i = 1; i < valores.size(); i++) {
			script += valores.get(i)+",\n";
		}
		script = script.substring(0, script.length() -2);
		script += ";";
		return script;
	}

	public void removeRepetidas() {
		for (int i = 0; i < valores.size(); i++) {
			for (int j = i ; j < valores.size(); j++) {
				if (valores.get(i).equals(valores.get(j))) {
					valores.remove(j);
				}
			}
		}
	}
	
	public ArrayList<String> csv(boolean id) {
		String arquivoCSV = diretorio;
	    BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		ArrayList<String> script = new ArrayList<>();
		int count = 1;

	    try {
	    	br = new BufferedReader(new FileReader(arquivoCSV));
	    	while ((linha = br.readLine()) != null) {
	    	tamanhoTabela+= 1;
	    	}
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	    try {
			
	    	br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {
				String[] coluna = linha.split(csvDivisor);
				String valor = "(";
				
				if (id) {
					for (int i = 0; i < dadosColuna.size(); i++) {
						valor += count+", "+ coluna[dadosColuna.get(i)].replace("\"", "");
						count++;
						if (i != dadosColuna.size() -1) {
							valor += ", ";
						}
					}
				}else {
					for (int i = 0; i < dadosColuna.size(); i++) {
						valor +=coluna[dadosColuna.get(i)].replace("\"", "");
						
						if (i != dadosColuna.size() -1) {
							valor += ", ";
						}
					}
				}
				valor +=")";
				script.add(valor);
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
		return script;
	  }
	
}
