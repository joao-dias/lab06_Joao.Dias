package testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogoTest {

	@Test
	public void testJogo() throws Exception{
		Jogo jogo = new Jogo("Castlevania", 45.5);
		
		/* Teste para verificar se os dados passado est�o corretos. */
		assertEquals("Castlevania", jogo.getNome());
		assertTrue(45.5 == jogo.getPreco());
		
		/* Teste para verificar se a captura das exceptions est�o corretas. */
		try{
			Jogo jogo2 = new Jogo(null, 45.5);
		}catch (Exception e){
			assertEquals("Nome do Jogo n�o pode ser nulo", e.getMessage());
		}
		
		try{
			Jogo jogo2 = new Jogo("Castlevania", -45.5);
		}catch (Exception e){
			assertEquals("Pre�o do Jogo n�o pode ser negativo", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() throws Exception{
		Jogo jogo = new Jogo("Castlevania", 45.5);
		
		/* Teste para verificar se o registro foi bem sucedido. */
		jogo.registraJogada(1000, false);
		assertTrue(jogo.getJogadas() == 1);
		assertTrue(jogo.getRecorde() == 1000);
		assertTrue(jogo.getZerado() == 0);
		
		/* Teste para verificar se a atualiza��o dos dados foi bem sucedida. */
		jogo.registraJogada(1500, true);
		assertTrue(jogo.getJogadas() == 2);
		assertTrue(jogo.getRecorde() == 1500);
		assertTrue(jogo.getZerado() == 1);
		
	}

	@Test
	public void testAddJogabilidade() throws Exception{
		Jogo jogo = new Jogo("Castlevania", 45.5);
		
		/* Teste para verificar a cria��o de duas jogabilidades iguais, que n�o � para acontecer. */
		jogo.addJogabilidade("Online");
		assertTrue(jogo.jogabilidade.size() == 1);
		
		jogo.addJogabilidade("Online");
		assertTrue(jogo.jogabilidade.size() == 1);
		
		/* Teste para verificar se a captura das exceptions est�o corretas. */
		try{
			jogo.addJogabilidade(null);
		}catch (Exception e){
			assertEquals("Jogabilidade n�o pode ser nula", e.getMessage());
		}
	}
}