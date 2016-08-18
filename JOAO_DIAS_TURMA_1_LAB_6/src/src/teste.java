package src;
import java.util.*;
public class teste {

	public static void main(String[] args) {
		Noob a = new Noob("t","gy",15);
		Veterano b = new Veterano("fwe","qwf",15);
		Loja y = new Loja();
		y.addUsuario(b);
		y.addUsuario(a);
		y.imprimeDados();
		

	}

}
