package testes;
import java.util.*; 

/* Classe: Loja */
public class Loja {
	public HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
	
	public Loja(){}
	
	/* Adiciona um usu�rio na lista de Usu�rios;
	 * Retorna true, caso a opera��o seja bem sucedida.
	 */
	public boolean addUsuario(Usuario usuario) throws Exception{
		if (usuario == null){
			throw new Exception("Usu�rio n�o pode ser nulo");
		}else if (listaUsuarios.containsValue(usuario)){
			throw new Exception("Usu�rio j� adicionado");
		}else{
			listaUsuarios.put(usuario.getLogin(), usuario);
			return true;
		}
	}
	
	/* Verifica se o login passado como par�metro corresponde a algum usu�rio;
	 * Se for um login v�lido ele adiciona o cr�dito correspondente no cr�dito do usu�rio;
	 * Retorna true, caso a opera��o seja bem sucecida e caso contr�rio, retorna false.
	 */
	public boolean addCredito(String login, double credito){
		try{
			if (listaUsuarios.containsKey(login)){
				listaUsuarios.get(login).addCredito(credito);
				return true;
			}else{
				throw new Exception("Usu�rio n�o encontrado");
			}
		}catch (Exception excecao){
			System.out.println("Erro ao adicionar cr�dito na conta do usu�rio");
			System.out.println(excecao.getMessage());
		}
		return false;
	}
	/* Verifica se o login correspondente est� relacionado a algum usu�rio;
	 * Caso seja um login v�lido, ele retira o cr�dito do usu�rio correspondente ao pre�o do jogo e adiciona o jogo na lista de jogos do usu�rio;
	 * Retorna true, caso a opera��o seja bem sucecida e caso contr�rio, retorna false.
	 */
	public boolean venderJogo(String login, Jogo jogo){
		try{
			if (listaUsuarios.containsKey(login)){
				listaUsuarios.get(login).compraJogo(jogo);
				return true;
			}
		}catch (Exception excecao){
			System.out.println("Erro ao vender o jogo ao usu�rio");
			System.out.println(excecao.getMessage());
		}
		return false;
	}
	
	/* Imprime os dados da Loja de acordo com a especifica��o pedida. */
	public void imprimeDados(){
		System.out.println("=== Central P2-CG ===");
		System.out.println();
		
		if (listaUsuarios.size() == 0){
			System.out.println("N�o h� usu�rios na Loja");
			System.out.println();
		}else{
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
				
				System.out.println("Total de  pre�o dos jogos: R$ " + listaUsuarios.get(i).precoTotal());
				System.out.println();
			}
		}
		System.out.println("--------------------------------------------");
	}
	
	/* Verifica se � um usu�rio v�lido atrav�s do login;
	 * Faz a promo��o de um usu�rio "Noob" para um "Veterano", inalterando seus dados base;
	 * Remove o usu�rio antigo da lista de usu�rios e adiciona o novo usu�rio promovido;
	 * Retorna true, caso a opera��o seja bem sucecida.
	 */
	public boolean upgrade(String login) throws Exception{
		if (login == null){
			throw new Exception("O login n�o pode ser nulo");
		}else if (login.equals("")){
			throw new Exception("O login n�o pode ser vazio");
		}else if (! listaUsuarios.containsKey(login)){
			throw new Exception("Usu�rio com esse login n�o pertence a Loja");
		}else if (! listaUsuarios.get(login).getTipo().equals("Noob")){
			throw new Exception("Esse usu�rio n�o � Noob");
		}else if (listaUsuarios.get(login).getX2p() < 1000){
			throw new Exception("Esse usu�rio n�o tem x2p suficiente para o upgrade");
		}else{
			
			Veterano usuario = new Veterano(listaUsuarios.get(login).getNome(), login, listaUsuarios.get(login).getCredito());
			usuario.setX2p(listaUsuarios.get(login).getX2p());
			listaUsuarios.remove(login);
			listaUsuarios.put(login, usuario);
			return true;
		}
	}
	
	@Override
	public String toString(){
		return "=== Central P2-CG ===";
	}
}