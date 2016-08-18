package src;

public class Veterano extends Usuario{
	private int x2p = 1000;
	
	public Veterano(String nome, String login, double credito){
		super(nome, login, credito);
	}
	
	@Override
	public String getTipo(){
		return "Veterano";
	}
	
	@Override
	public int getX2p(){
		return x2p;
	}
	
	@Override
	public void setX2p(int novoX2p){
		x2p = novoX2p;
	}
	
	@Override
	public boolean compraJogo(Jogo jogo){
		if (credito < (jogo.getPreco() - (jogo.getPreco() * 0.2))){ /*Desconto de 20%*/
			return false;
		}else{
			credito -= (jogo.getPreco() - (jogo.getPreco() * 0.2));
			listaJogos.add(jogo);
			x2p = (int) (jogo.getPreco() * 15);
			return true;
		}
	}
	
	public boolean registraJogada(String nomeJogo, int score, boolean zerou){
		for (int i = 0; i < listaJogos.size(); i++){
			if (listaJogos.get(i).getNome().equals(nomeJogo)){
				x2p += listaJogos.get(i).registraJogada(score, zerou);
				return true;
			}
		}
		return false;
	}
}