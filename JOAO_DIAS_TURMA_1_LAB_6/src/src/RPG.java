package src;

/* Subclasse de Jogo: RPG */
public class RPG extends Jogo {
	
	public RPG(String nome, double preco) throws Exception{
		super(nome, preco);
	}
	
	@Override
	public String getTipo(){
		return "RPG";
	}
	
	/* Mesma funcionalidade do "registraJogada" da Superclasse, com diferença em seu retorno;
	 * Retorna o score relativo ao tipo RPG para cada vez que é jogado.
	 */
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
	
	@Override
	public String toString(){
		return this.nome + "(" + getTipo() + ") - " + this.preco;
	}
	
}