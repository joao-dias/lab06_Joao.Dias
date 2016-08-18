package src;

public class Veterano extends Usuario{
	public Veterano(String nome, String login, double credito){
		super(nome, login, credito);
	}
	
	@Override
	public boolean compraJogo(Jogo jogo){
		if (credito < (jogo.getPreco() - (jogo.getPreco() * 0.2))){ //Desconto de 20%
			return false;
		}else{
			credito -= (jogo.getPreco() - (jogo.getPreco() * 0.2));
			listaJogos.add(jogo);
			return true;
		}
	}
}