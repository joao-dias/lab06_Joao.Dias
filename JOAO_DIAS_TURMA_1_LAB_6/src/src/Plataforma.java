package src;

public class Plataforma extends Jogo{
	private String tipo = "Plataforma";
	
	public Plataforma(String nome, double preco){
		super(nome, preco);
	}
	
	public String getTipo(){
		return tipo;
	}
}
