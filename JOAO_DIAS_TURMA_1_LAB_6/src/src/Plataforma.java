package src;

public class Plataforma extends Jogo{
	
	public Plataforma(String nome, double preco){
		super(nome, preco);
	}
	
	@Override
	public String getTipo(){
		return "Plataforma";
	}
	
	@Override
	public int registraJogada(int score, boolean zerou){
		if (score > recorde){
			recorde = score;
		}
		jogadas += 1;
		if (zerou){
			zerado += 1;
			return 20;
		}
		return 0;
	}
}