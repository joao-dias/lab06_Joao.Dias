package src;

public class Luta extends Jogo{
	private String tipo = "Luta";
	
	public Luta(String nome, double preco){
		super(nome, preco);
	}
	
	public String getTipo(){
		return tipo;
	}
}
