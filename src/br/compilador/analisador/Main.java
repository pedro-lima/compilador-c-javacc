package br.compilador.analisador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Gramatica parser = new Gramatica(new FileInputStream(args[0]));
		try {
			System.out.println("Análise sintática:");
			SimpleNode n = parser.Programa();
			System.out.println();
			System.out.println("Arvore sintática:");
			n.dump("  ");
			System.out.println("Fim da análise sintática.");

			System.out.println();
			System.out.println("Análise semântica:");
			n.jjtAccept(new VisitorSemantico(), parser.control);
			parser.control.imprimeErrosSemanticos();
			System.out.println("Fim da análise semântica");
		} catch (Exception e) {
			System.out.println("Oops.");
			System.out.println(e.getMessage());
		}
	}

}
