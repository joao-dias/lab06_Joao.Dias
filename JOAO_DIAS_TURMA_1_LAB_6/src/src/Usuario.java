package src;
import java.util.*;

public class Usuario {
	public String nome;
	public String login;
	public ArrayList<Jogo> listaJogos = new ArrayList<Jogo>();
	public double credito;
	
	public Usuario(String nome, String login, double credito){
		this.credito = credito;
		this.login = login;
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String novoNome){
		nome = novoNome;
	}
	
	public double getCredito(){
		return credito;
	}
	
	public String getLogin(){
		return login;
	}
	
	public void setLogin(String novoLogin){
		login = novoLogin;
	}
	
	public boolean compraJogo(Jogo jogo){
		if (credito < jogo.getPreco()){
			return false;
		}else{
			credito -= jogo.getPreco();
			listaJogos.add(jogo);
			return true;
		}
	}
	
	public void addCredito(double creditoAdicional){
		credito += creditoAdicional;
	}
	
	public String getTipo(){
		return "Usuário";
	}
	
	public double precoTotal(){
		double total = 0;
		for (Jogo i : listaJogos){
			total += i.getPreco();
		}
		return total;
	}
	
	public int getX2p(){
		return 0;
	}
	
	public void setX2p(int novoX2p){}
	
	@Override
	public String toString(){
		return nome;
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
