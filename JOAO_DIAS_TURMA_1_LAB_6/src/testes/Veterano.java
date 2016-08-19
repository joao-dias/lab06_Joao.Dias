package testes;

/* Subclasse de Usuario: Veterano */
public class Veterano extends Usuario{
	private int x2p = 1000;
	
	public Veterano(String nome, String login, double credito) throws Exception{
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
	
	/* Mesma funcionalidade que o "compraJogo" da Superclasse, com diferença na aplicação de desconto;
	 * Aplica o desconto específico da Subclasse Veterano;
	 * Incrementa os pontos ganhos ao comprar o jogo;
	 * Retorna true, caso a operação seja bem sucedida.
	 */
	@Override
	public boolean compraJogo(Jogo jogo) throws Exception{
		if (jogo == null){
			throw new Exception("O Jogo não pode ser nulo");
		}else if (listaJogos.contains(jogo)){
			throw new Exception("Esse jogo já foi comprado");
		}else if (credito < (jogo.getPreco() - (jogo.getPreco() * 0.2))){ 
			throw new Exception("Crédito insuficiente para realização da compra");
		}else{
			credito -= (jogo.getPreco() - (jogo.getPreco() * 0.2));
			listaJogos.add(jogo);
			x2p += (int) (jogo.getPreco()) * 15;
			return true;
		}
	}
}