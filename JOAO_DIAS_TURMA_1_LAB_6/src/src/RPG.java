package src;

public class RPG extends Jogo {
	private String tipo = "RPG";
	
	public RPG(String nome, double preco){
		super(nome, preco);
	}
	
	public String getTipo(){
		return tipo;
	}
}
