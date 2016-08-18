package src;

public class RPG extends Jogo {
	
	public RPG(String nome, double preco){
		super(nome, preco);
	}
	
	@Override
	public String getTipo(){
		return "RPG";
	}
	
	@Override
	public int registraJogada(int score, boolean zerou){
		if (score > recorde){
			recorde = score;
		}
		jogadas += 1;
		if (zerou){
			zerado += 1;
		}
		return 10;
	}
	
}