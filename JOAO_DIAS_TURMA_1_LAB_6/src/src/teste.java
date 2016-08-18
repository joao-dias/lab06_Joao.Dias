package src;
import java.util.*;
public class teste {

	public static void main(String[] args) {
		RPG a = new RPG("opa", 35);
		Jogo b = new RPG("tf", 20);
		Jogo c = new Jogo("ft", 45);
		ArrayList<Jogo> q = new ArrayList<Jogo>();
		q.add(a);
		System.out.println(a.getTipo());

	}

}
