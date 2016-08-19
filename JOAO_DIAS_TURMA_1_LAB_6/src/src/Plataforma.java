package src;

/* Subclasse de Jogo: Plataforma */
public class Plataforma extends Jogo{
	
	public Plataforma(String nome, double preco) throws Exception{
		super(nome, preco);
	}
	
	@Override
	public String getTipo(){
		return "Plataforma";
	}
	
	/* Mesma funcionalidade do "registraJogada" da Superclasse, com diferença em seu retorno;
	 * Retorna o score relativo ao tipo Plataforma para cada vez que o jogo é zerado.
	 */
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
	
	@Override
	public String toString(){
		return this.nome + "(" + getTipo() + ") - " + this.preco;
	}
}