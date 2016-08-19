package testes;
import java.util.*; 

/* Classe: Loja */
public class Loja {
	public HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
	
	public Loja(){}
	
	/* Adiciona um usuário na lista de Usuários;
	 * Retorna true, caso a operação seja bem sucedida.
	 */
	public boolean addUsuario(Usuario usuario) throws Exception{
		if (usuario == null){
			throw new Exception("Usuário não pode ser nulo");
		}else if (listaUsuarios.containsValue(usuario)){
			throw new Exception("Usuário já adicionado");
		}else{
			listaUsuarios.put(usuario.getLogin(), usuario);
			return true;
		}
	}
	
	/* Verifica se o login passado como parâmetro corresponde a algum usuário;
	 * Se for um login válido ele adiciona o crédito correspondente no crédito do usuário;
	 * Retorna true, caso a operação seja bem sucecida e caso contrário, retorna false.
	 */
	public boolean addCredito(String login, double credito){
		try{
			if (listaUsuarios.containsKey(login)){
				listaUsuarios.get(login).addCredito(credito);
				return true;
			}else{
				throw new Exception("Usuário não encontrado");
			}
		}catch (Exception excecao){
			System.out.println("Erro ao adicionar crédito na conta do usuário");
			System.out.println(excecao.getMessage());
		}
		return false;
	}
	/* Verifica se o login correspondente está relacionado a algum usuário;
	 * Caso seja um login válido, ele retira o crédito do usuário correspondente ao preço do jogo e adiciona o jogo na lista de jogos do usuário;
	 * Retorna true, caso a operação seja bem sucecida e caso contrário, retorna false.
	 */
	public boolean venderJogo(String login, Jogo jogo){
		try{
			if (listaUsuarios.containsKey(login)){
				listaUsuarios.get(login).compraJogo(jogo);
				return true;
			}
		}catch (Exception excecao){
			System.out.println("Erro ao vender o jogo ao usuário");
			System.out.println(excecao.getMessage());
		}
		return false;
	}
	
	/* Imprime os dados da Loja de acordo com a especificação pedida. */
	public void imprimeDados(){
		System.out.println("=== Central P2-CG ===");
		System.out.println();
		
		if (listaUsuarios.size() == 0){
			System.out.println("Não há usuários na Loja");
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
				
				System.out.println("Total de  preço dos jogos: R$ " + listaUsuarios.get(i).precoTotal());
				System.out.println();
			}
		}
		System.out.println("--------------------------------------------");
	}
	
	/* Verifica se é um usuário válido através do login;
	 * Faz a promoção de um usuário "Noob" para um "Veterano", inalterando seus dados base;
	 * Remove o usuário antigo da lista de usuários e adiciona o novo usuário promovido;
	 * Retorna true, caso a operação seja bem sucecida.
	 */
	public boolean upgrade(String login) throws Exception{
		if (login == null){
			throw new Exception("O login não pode ser nulo");
		}else if (login.equals("")){
			throw new Exception("O login não pode ser vazio");
		}else if (! listaUsuarios.containsKey(login)){
			throw new Exception("Usuário com esse login não pertence a Loja");
		}else if (! listaUsuarios.get(login).getTipo().equals("Noob")){
			throw new Exception("Esse usuário não é Noob");
		}else if (listaUsuarios.get(login).getX2p() < 1000){
			throw new Exception("Esse usuário não tem x2p suficiente para o upgrade");
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