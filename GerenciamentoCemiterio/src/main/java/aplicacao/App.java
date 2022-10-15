package aplicacao;

public class App {
	public static void main(String args[]) {
		CRUDGC crudGC = new CRUDGC();
		//// Ordem de criação = id, pessoaPublica, cemiterio, nome, quadra, rua, numero,
		// certidaoObito, dataNascimento, dataObito;
		crudGC.create();
		crudGC.read();
		crudGC.update();
		crudGC.pa();
	}
}
