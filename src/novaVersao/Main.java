package novaVersao;

public class Main {
	public static void main(String[] args) {
		
		LeitorFitas leitor = new LeitorFitas();
		
		leitor.executar("fitaDNA");
		
		System.out.println("Total de fitas no arquivo: " + leitor.getTotal());
		System.out.println("Fitas válidas: " + leitor.getValidas());
		System.out.println("Fitas inválidas: " + leitor.getInvalidas());
		
		System.out.println();
		
		System.out.println("Listagem de fitas inválidas:");
		for(FitaInvalida fita : leitor.getFitasInvalidas())
			System.out.println(fita.getPosicao() + ". " + fita.getFita());
		
	}
}