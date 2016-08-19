package testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void testUsuario() throws Exception{
		/* Teste para verificar se os dados est�o corretos. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		
		assertEquals("Shz Jvblayd", usuario.getNome());
		assertEquals("Jvblayd", usuario.getLogin());
		assertTrue(200.50 == usuario.getCredito());
		
		/* Teste para verificar se a captura das exceptions est�o corretas. */
		try{
			Usuario usuario1 = new Usuario("", "Jvblayd", 200.50);
		}catch (Exception e){
			assertEquals("Nome do Usu�rio n�o pode ser vazio", e.getMessage());
		}
		
		try{
			Usuario usuario2 = new Usuario("Shz Jvblayd", "Jvblayd", -200.50);
		}catch (Exception e){
			assertEquals("Usu�rio n�o pode ter cr�dito negativo", e.getMessage());
		}
	}

	@Test
	public void testCompraJogo() throws Exception{
		/* Teste para verificar se a implementa��o dos dados est� correta. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		Jogo jogo = new Jogo("Chrono Trigger", 10);
		
		assertTrue(usuario.compraJogo(jogo));
		assertTrue(usuario.getCredito() == (200.50 - 10));
		assertTrue(usuario.listaJogos.size() == 1);
		
		/* Teste para verificar se a captura das exception est� correta. */
		Jogo jogo1 = new Jogo("Chrono Trigger", 300);
		
		try{
			usuario.compraJogo(jogo);
		}catch (Exception e){
			assertEquals("Esse jogo j� foi comprado", e.getMessage());
		}
		
		try{
			usuario.compraJogo(jogo1);
		}catch (Exception e){
			assertEquals("Cr�dito insuficiente para realiza��o da compra", e.getMessage());
		}
	}

	@Test
	public void testAddCredito() throws Exception{
		/* Teste para verificar a incrementa��o dos dados. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		
		usuario.addCredito(150);
		assertTrue((150 + 200.50) == usuario.getCredito());
		
		/* Teste para verificar se a captura de exceptions est� correta */
		try{
			usuario.addCredito(-150);
		}catch (Exception e){
			assertEquals("Cr�dito a ser adicionado n�o pode ser negativo", e.getMessage());
		}
	}

	@Test
	public void testPrecoTotal() throws Exception{
		/* Teste para verificar se est� funcionando correto. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		Jogo jogo = new Jogo("Chrono Trigger", 10);
		Jogo jogo1 = new Jogo("The Binding of Isaac", 30);
		
		usuario.compraJogo(jogo1);
		usuario.compraJogo(jogo);
		assertTrue((30 + 10) == usuario.precoTotal());
	}
}