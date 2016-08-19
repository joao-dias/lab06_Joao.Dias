package src;

/* Subclasse de Usuario: Noob */
public class Noob extends Usuario{
	private int x2p = 0;
	
	public Noob(String nome, String login, double credito) throws Exception{
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
	
	/* Mesma funcionalidade que o "compraJogo" da Superclasse, com diferença na aplicação de desconto;
	 * Aplica o desconto específico da Subclasse Noob;
	 * Incrementa os pontos ganhos ao comprar o jogo;
	 * Retorna true, caso a operação seja bem sucedida.
	 */
	@Override
	public boolean compraJogo(Jogo jogo) throws Exception{
		if (jogo == null){
			throw new Exception("O Jogo não pode ser nulo");
		}else if (listaJogos.contains(jogo)){
			throw new Exception("Esse jogo já foi comprado");
		}else if (credito < (jogo.getPreco() - (jogo.getPreco() * 0.1))){ 
			throw new Exception("Crédito insuficiente para realização da compra");
		}else{
			credito -= (jogo.getPreco() - (jogo.getPreco() * 0.1));
			listaJogos.add(jogo);
			x2p += (int) (jogo.getPreco()) * 10;
			return true;
		}
	}
}