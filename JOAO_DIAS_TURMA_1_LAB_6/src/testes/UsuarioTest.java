package testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void testUsuario() throws Exception{
		/* Teste para verificar se os dados estão corretos. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		
		assertEquals("Shz Jvblayd", usuario.getNome());
		assertEquals("Jvblayd", usuario.getLogin());
		assertTrue(200.50 == usuario.getCredito());
		
		/* Teste para verificar se a captura das exceptions estão corretas. */
		try{
			Usuario usuario1 = new Usuario("", "Jvblayd", 200.50);
		}catch (Exception e){
			assertEquals("Nome do Usuário não pode ser vazio", e.getMessage());
		}
		
		try{
			Usuario usuario2 = new Usuario("Shz Jvblayd", "Jvblayd", -200.50);
		}catch (Exception e){
			assertEquals("Usuário não pode ter crédito negativo", e.getMessage());
		}
	}

	@Test
	public void testCompraJogo() throws Exception{
		/* Teste para verificar se a implementação dos dados está correta. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		Jogo jogo = new Jogo("Chrono Trigger", 10);
		
		assertTrue(usuario.compraJogo(jogo));
		assertTrue(usuario.getCredito() == (200.50 - 10));
		assertTrue(usuario.listaJogos.size() == 1);
		
		/* Teste para verificar se a captura das exception está correta. */
		Jogo jogo1 = new Jogo("Chrono Trigger", 300);
		
		try{
			usuario.compraJogo(jogo);
		}catch (Exception e){
			assertEquals("Esse jogo já foi comprado", e.getMessage());
		}
		
		try{
			usuario.compraJogo(jogo1);
		}catch (Exception e){
			assertEquals("Crédito insuficiente para realização da compra", e.getMessage());
		}
	}

	@Test
	public void testAddCredito() throws Exception{
		/* Teste para verificar a incrementação dos dados. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		
		usuario.addCredito(150);
		assertTrue((150 + 200.50) == usuario.getCredito());
		
		/* Teste para verificar se a captura de exceptions está correta */
		try{
			usuario.addCredito(-150);
		}catch (Exception e){
			assertEquals("Crédito a ser adicionado não pode ser negativo", e.getMessage());
		}
	}

	@Test
	public void testPrecoTotal() throws Exception{
		/* Teste para verificar se está funcionando correto. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		Jogo jogo = new Jogo("Chrono Trigger", 10);
		Jogo jogo1 = new Jogo("The Binding of Isaac", 30);
		
		usuario.compraJogo(jogo1);
		usuario.compraJogo(jogo);
		assertTrue((30 + 10) == usuario.precoTotal());
	}
}