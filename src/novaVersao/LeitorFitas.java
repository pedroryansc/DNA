package novaVersao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorFitas {

	private int total;
	private int validas;
	private int invalidas;
	private List<FitaInvalida> fitasInvalidas;
	private String fitasComplementares;
	
	public int getTotal() {
		return total;
	}

	public int getValidas() {
		return validas;
	}

	public int getInvalidas() {
		return invalidas;
	}

	public List<FitaInvalida> getFitasInvalidas() {
		return fitasInvalidas;
	}

	public String getFitasComplementares() {
		return fitasComplementares;
	}

	public boolean executar(String nomeArquivo) {
		try {
			// Leitura do arquivo
			
			File arquivo = new File(nomeArquivo + ".txt");
			
			Scanner leitor = new Scanner(arquivo);
			
			// Inicialização dos atributos
			
			total = 0;
			validas = 0;
			invalidas = 0;
			fitasInvalidas = new ArrayList<FitaInvalida>();
			fitasComplementares = "";
			
			boolean validacao;
			
			// Leitura de cada fita
			
			while(leitor.hasNextLine()) {
				total++;
				
				String fita = leitor.nextLine();
				String[] vetorFita = fita.split("");
				
				validacao = true;
				
				String fitaComplementar = "";
				
				for(String base : vetorFita) {
					if(base.equals("A"))
						fitaComplementar += "T";
					else if(base.equals("T"))
						fitaComplementar += "A";
					else if(base.equals("G"))
						fitaComplementar += "C";
					else if(base.equals("C"))
						fitaComplementar += "G";
					else {
						validacao = false;
						break;
					}
				}
				
				if(validacao) {
					validas++;
					fitasComplementares += fitaComplementar + "\n";
				} else {
					invalidas++;
					fitasInvalidas.add(new FitaInvalida(total, fita));
					fitasComplementares += "****FITA INVÁLIDA - " + fita + "\n";
				}
			}
			
			FileWriter novoArquivo = new FileWriter(nomeArquivo + "Complementar.txt");
			novoArquivo.write(fitasComplementares);

			leitor.close();
			novoArquivo.close();
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}