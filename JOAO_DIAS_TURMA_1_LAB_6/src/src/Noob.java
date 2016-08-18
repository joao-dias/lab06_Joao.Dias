package src;

public class Noob extends Usuario{
	private int x2p = 0;
	
	public Noob(String nome, String login, double credito){
		super(nome, login, credito);
	}
	
	@Override
	public String getTipo(){
		return "Noob";
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
		if (credito < (jogo.getPreco() - (jogo.getPreco() * 0.1))){ //Desconto de 10%
			return false;
		}else{
			credito -= (jogo.getPreco() - (jogo.getPreco() * 0.1));
			listaJogos.add(jogo);
			x2p += (int) (jogo.getPreco()) * 10;
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