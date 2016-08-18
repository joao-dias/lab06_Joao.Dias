package src;
import java.util.*;

public class Jogo {
	String nome;
	double preco;
	int recorde = 0;
	int jogadas = 0;
	int zerado = 0;
	HashSet<String> jogabilidade = new HashSet<String>();
	
	public Jogo(String nome, double preco){
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getTipo(){
		return "Jogo";
	}
	
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
	
	public void setNome(String novoNome){
		nome = novoNome;
	}
	
	public void setPreco(double novoPreco){
		preco = novoPreco;
	}
	
	public void addJogabilidade(String jogabilidadeAtual){
		jogabilidade.add(jogabilidadeAtual);
	}
	
	@Override
	public String toString(){
		return nome;
	}
}
