package testes;
import java.util.*;

/* Superclasse: Jogo */
public class Jogo {
	public String nome;
	public double preco;
	public int recorde = 0;
	public int jogadas = 0;
	public int zerado = 0;
	public HashSet<String> jogabilidade = new HashSet<String>();
	
	public Jogo(String nome, double preco) throws Exception{
		if (nome == null){
			throw new Exception("Nome do Jogo não pode ser nulo");
		}else if (nome.equals("")){
			throw new Exception("Nome do Jogo não pode ser vazio");
		}else if (preco < 0){
			throw new Exception("Preço do Jogo não pode ser negativo");
		}
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getTipo(){
		return "Jogo";
	}
	
	/* Verifica se o score da jogada atual é maior que o recorde, caso seja verdade, atualiza o recorde;
	 * Atualiza o número de jogadas;
	 * Verifica se o jogo foi zerado, caso seja verdade, atualiza o números de vezes zeradas.
	 */
	public int registraJogada(int score, boolean zerou){
		if (score > recorde){
			recorde = score;
		}
		jogadas += 1;
		if (zerou){
			zerado += 1;
		}
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	public String getNome(){
		return nome;
	}
	
	public double getPreco(){
		return preco;
	}
	
	public int getRecorde(){
		return recorde;
	}
	
	public int getJogadas(){
		return jogadas;
	}
	
	public int getZerado(){
		return zerado;
	}
	
	public void setNome(String novoNome) throws Exception{
		if (novoNome == null){
			throw new Exception("O nome novo não pode ser nulo");
		}else if (novoNome.equals("")){
			throw new Exception("O nome novo não pode ser vazio");
		}
		nome = novoNome;
	}
	
	public void setPreco(double novoPreco) throws Exception{
		if (novoPreco < 0){
			throw new Exception("O preço novo não pode ser negativo");
		}
		preco = novoPreco;
	}
	
	/* Recebe um tipo de jogabilidade e adiciona ela na lista de jogabilidade.*/
	public void addJogabilidade(String jogabilidadeAtual) throws Exception{
		if (jogabilidadeAtual == null){
			throw new Exception("Jogabilidade não pode ser nula");
		}else if (jogabilidadeAtual.equals("")){
			throw new Exception("Jogabilidade não pode ser vazia");
		}
		jogabilidade.add(jogabilidadeAtual);
	}
	
	@Override
	public String toString(){
		return nome + " - " + preco;
	}
}