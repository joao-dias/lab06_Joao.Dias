package src;

/* Subclasse de Jogo: Luta */
public class Luta extends Jogo{
	
	public Luta(String nome, double preco) throws Exception{
		super(nome, preco);
	}
	
	@Override
	public String getTipo(){
		return "Luta";
	}
	
	/* Mesma funcionalidade do "registraJogada" da Superclasse, com diferença em seu retorno;
	 * Retorna o score relativo ao tipo Luta para cada vez que um novo recorde é alcançado no jogo.
	 */
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
	
	@Override
	public String toString(){
		return this.nome + "(" + getTipo() + ") - " + this.preco;
	}
}