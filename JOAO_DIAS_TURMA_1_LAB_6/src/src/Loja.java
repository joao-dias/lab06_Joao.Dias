package src;
import java.util.*; 

public class Loja {
	private HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
	
	public Loja(){}
	
	public boolean addUsuario(Usuario usuario){
		if (listaUsuarios.containsValue(usuario)){
			return false;
		}else{
			listaUsuarios.put(usuario.getLogin(), usuario);
			return true;
		}
	}
	
	public boolean addCredito(String login, double credito){
		if (listaUsuarios.containsKey(login)){
			listaUsuarios.get(login).addCredito(credito);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean venderJogo(String login, Jogo jogo){
		if (listaUsuarios.containsKey(login)){
			if (listaUsuarios.get(login).getCredito() < jogo.getPreco()){
				return false;
			}else{
				listaUsuarios.get(login).compraJogo(jogo);
				return true;
			}
		}else{
			return false;
		}
	}
	
	public void imprimeDados(){
		System.out.println("=== Central P2-CG ===");
		System.out.println();
		for (String i : listaUsuarios.keySet()){
			System.out.println(listaUsuarios.get(i).getLogin());
			System.out.println(listaUsuarios.get(i).getNome() + " - " + "Jogador " + listaUsuarios.get(i).getTipo());
			System.out.println("Lista de Jogos:");
			for (int it = 0; it < listaUsuarios.get(i).listaJogos.size(); it++){
				System.out.println("+ " + listaUsuarios.get(i).listaJogos.get(it).getNome() + " - " + listaUsuarios.get(i).listaJogos.get(it).getTipo() + ":");
				System.out.println("==> Jogou " + listaUsuarios.get(i).listaJogos.get(it).getJogadas() + " vez(es)");
				System.out.println("==> Zerou " + listaUsuarios.get(i).listaJogos.get(it).getZerado() + " vez(es)");
				System.out.println("==> Maior Score: " + listaUsuarios.get(i).listaJogos.get(it).getRecorde());
				System.out.println();
			}
			System.out.println("Total de  preço dos jogos: R$ " + listaUsuarios.get(i).precoTotal());
			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}
	
	public boolean upgrade(String login){
		//trate cada caso com uma exception diferente
		if ((listaUsuarios.containsKey(login)) && (listaUsuarios.get(login).getTipo().equals("Noob")) && (listaUsuarios.get(login).getX2p() >= 1000)){
			Veterano usuario = new Veterano(listaUsuarios.get(login).getNome(), login, listaUsuarios.get(login).getCredito());
			usuario.setX2p(listaUsuarios.get(login).getX2p());
			listaUsuarios.remove(login);
			listaUsuarios.put(login, usuario);
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		return "=== Central P2-CG ===";
	}
}


