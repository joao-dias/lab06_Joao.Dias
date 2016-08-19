package testes;
import java.util.*;

/* Superclasse: Usuario */
public class Usuario {
	public String nome;
	public String login;
	public int x2p;
	public ArrayList<Jogo> listaJogos = new ArrayList<Jogo>();
	public double credito;
	
	public Usuario(String nome, String login, double credito) throws Exception{
		if (nome == null){
			throw new Exception("Nome do Usu�rio n�o pode ser nulo");
		}
		else if (nome.equals("")){
			throw new Exception("Nome do Usu�rio n�o pode ser vazio");
		}
		else if (login == null){
			throw new Exception("Login do Usu�rio n�o pode ser nulo");
		}
		else if (login.equals("")){
			throw new Exception("Login do Usu�rio n�o pode ser vazio");
		}
		else if (credito < 0){
			throw new Exception("Usu�rio n�o pode ter cr�dito negativo");
		}
		this.credito = credito;
		this.login = login;
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String novoNome) throws Exception{
		if (novoNome == null){
			throw new Exception("O novo nome do Usu�rio n�o pode ser nulo");
		}
		if (novoNome.equals("")){
			throw new Exception("O novo nome do Usu�rio n�o pode ser vazio");
		}
		nome = novoNome;
	}
	
	public double getCredito(){
		return credito;
	}
	
	public String getLogin(){
		return login;
	}
	
	public void setLogin(String novoLogin) throws Exception{
		if (novoLogin == null){
			throw new Exception("O novo login do Usu�rio n�o pode ser nulo");
		}
		if (novoLogin.equals("")){
			throw new Exception("O novo login do Usu�rio n�o pode ser vazio");
		}
		login = novoLogin;
	}
	
	/* Primeiro faz a verifica��o do cr�dito do usu�rio, para saber se ele tem condi��o de comprar o jogo;
	 * Caso haja condi��o de compra, atualiza o cr�dito e adiciona o jogo na lista de jogos do usu�rio;
	 * Retorna true, caso a opera��o seja bem sucedida.
	 */
	public boolean compraJogo(Jogo jogo) throws Exception{
		if (jogo == null){
			throw new Exception("O jogo n�o pode ser nulo");
		}else if (credito < jogo.getPreco()){
			throw new Exception("Cr�dito insuficiente para realiza��o da compra");
		}else if (listaJogos.contains(jogo)){
			throw new Exception("Esse jogo j� foi comprado");
		}else{
			credito -= jogo.getPreco();
			listaJogos.add(jogo);
			return true;
		}
	}
	
	/* Atualiza o cr�dito do usu�rio adicionando o valor especificado. */
	public void addCredito(double creditoAdicional) throws Exception{
		if (creditoAdicional < 0){
			throw new Exception("Cr�dito a ser adicionado n�o pode ser negativo");
		}
		credito += creditoAdicional;
	}
	
	public String getTipo(){
		return "Usu�rio";
	}
	
	/* Calcula o pre�o total de todos os jogos do usu�rio */
	public double precoTotal(){
		double total = 0;
		for (Jogo i : listaJogos){
			total += i.getPreco();
		}
		return total;
	}
	
	public int getX2p(){
		return x2p;
	}
	
	public void setX2p(int novoX2p){
		x2p = novoX2p;
	}
	
	/* Faz o registro de uma jogatina do usu�rio; 
	 * Pesquisa o jogo na lista de jogos do usu�rio usando o nome do jogo como par�metro;
	 * Retorna true, caso a opera��o seja bem sucedida, caso contr�rio retorna false.
	 */
	public boolean registraJogada(String nomeJogo, int score, boolean zerou) throws Exception{
		if (nomeJogo == null){
			throw new Exception("Nome do jogo n�o pode ser nulo");
		}else if (nomeJogo.equals("")){
			throw new Exception("Nome do jogo n�o pode ser vazio");
		}
		for (int i = 0; i < listaJogos.size(); i++){
			if (listaJogos.get(i).getNome().equals(nomeJogo)){
				x2p += listaJogos.get(i).registraJogada(score, zerou);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return nome + " - " + login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaJogos == null) ? 0 : listaJogos.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (listaJogos == null) {
			if (other.listaJogos != null)
				return false;
		} else if (!listaJogos.equals(other.listaJogos))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}