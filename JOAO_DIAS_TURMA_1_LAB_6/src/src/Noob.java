package src;

public class Noob extends Usuario{
	public Noob(String nome, String login, double credito){
		super(nome, login, credito);
	}
	
	@Override
	public boolean compraJogo(Jogo jogo){
		if (credito < (jogo.getPreco() - (jogo.getPreco() * 0.1))){ //Desconto de 10%
			return false;
		}else{
			credito -= (jogo.getPreco() - (jogo.getPreco() * 0.1));
			listaJogos.add(jogo);
			return true;
		}
	}
}
