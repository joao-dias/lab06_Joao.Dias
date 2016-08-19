package testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class LojaTest {

	@Test
	public void testAddUsuario() throws Exception{
		/* Teste para verificar se a implementação está correta. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		Loja loja = new Loja();
		
		assertTrue(loja.addUsuario(usuario));
		assertTrue(loja.listaUsuarios.size() == 1);
		
		/* Teste para verificar se a captura de exceptions está correta. */
		try{
			loja.addUsuario(usuario);
		}catch (Exception e){
			assertEquals("Usuário já adicionado", e.getMessage());
		}
	}

	@Test
	public void testAddCredito() throws Exception{
		/* Teste para verificar se a incrementação dos dados está correta. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		Loja loja = new Loja();
		loja.addUsuario(usuario);
		
		assertTrue(loja.addCredito("Jvblayd", 100));
		assertTrue(usuario.getCredito() == (200.50 + 100));
		
		/* Teste para verificar se a captura de exceptions está correta. */
		try{
			loja.addCredito("Jvblayd01", 50);
		}catch (Exception e){
			assertEquals("Usuário não encontrado", e.getMessage());
		}
	}

	@Test
	public void testVenderJogo() throws Exception{
		/* Teste para verificar se a incrementação dos dados está correta. */
		Usuario usuario = new Usuario("Shz Jvblayd", "Jvblayd", 200.50);
		Jogo jogo = new Jogo("Dragon Quest VIII", 150);
		Loja loja = new Loja();
		loja.addUsuario(usuario);
		
		assertTrue(loja.venderJogo("Jvblayd", jogo));
		assertTrue(usuario.getCredito() == (200.50 - 150));
		assertTrue(usuario.listaJogos.contains(jogo));
	}

	@Test
	public void testUpgrade() throws Exception{
		/* Teste para verificar se a implementação está correta. */
		Loja loja = new Loja();
		Noob usuario = new Noob("Shz Jvblayd", "Jvblayd", 200.50);
		usuario.setX2p(1200);
		loja.addUsuario(usuario);
		
		assertTrue(loja.upgrade("Jvblayd"));
		assertFalse(loja.listaUsuarios.containsValue(usuario));
		assertTrue(loja.listaUsuarios.get("Jvblayd").getX2p() == 1200);
		
		/* Teste para verificar se a captura de exceptions está correta. */
		Noob usuario1 = new Noob("Jvblayd", "Jvblayd01", 200.50);
		usuario1.setX2p(500);
		loja.addUsuario(usuario1);
		
		try{
			loja.upgrade("");
		}catch (Exception e){
			assertEquals("O login não pode ser vazio", e.getMessage());
		}
		
		try{
			loja.upgrade("loginAleatorio");
		}catch (Exception e){
			assertEquals("Usuário com esse login não pertence a Loja", e.getMessage());
		}
		
		try{
			loja.upgrade("Jvblayd01");
		}catch (Exception e){
			assertEquals("Esse usuário não tem x2p suficiente para o upgrade", e.getMessage());
		}	
	}
}