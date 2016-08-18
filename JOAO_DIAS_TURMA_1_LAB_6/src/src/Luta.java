package src;

public class Luta extends Jogo{
	
	public Luta(String nome, double preco){
		super(nome, preco);
	}
	
	@Override
	public String getTipo(){
		return "Luta";
	}
	
	@Override
	public int registraJogada(int score, boolean zerou){
		if (score > recorde){
			recorde = score;
			return (score/1000);
		}
		jogadas += 1;
		if (zerou){
			zerado += 1;
		}
		return 0;
	}
}