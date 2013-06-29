package br.compilador.analisador;

import br.compilador.analisador.CustomNode.TIPO;

public class VisitorSemantico implements GramaticaVisitor {

	@Override
	public Object visit(SimpleNode node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(Programa node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(Funcao node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(TipoRetorno node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(ParametroFuncao node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(CorpoFuncao node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(Declaracao node, Controlador data) {
		node.childrenAccept(this, data);
		TIPO tipoID = data.getTipo((Token) node.jjtGetValue());
		// Agora pegamos o tipo da expressao
		try {
			TIPO tipoExpr = ((CustomNode) node.jjtGetChild(0)).getTipo();
			// Agora verificamos se sao compativeis

			if (!tipoID.equals(tipoExpr)) {
				data.addErro(((Token) node.jjtGetValue()).beginLine,
						"Tipos incompatíveis");
			}

		} catch (Exception ex) {
			//a exceção sera lançada caso a declaraçao nao
			//seja seguida de uma atribuiçao. neste caso
			// a exceçao sera ignorada.
		}

		return null;
	}

	// ERRO NO CASO DE BOOLEAN
	@Override
	public Object visit(Atribuicao node, Controlador data) {
		node.childrenAccept(this, data);
		// no comando de atribuicao, temos o valor do no, que eh o id
		// pegamos o tipo dele:
		TIPO tipoID = data.getTipo((Token) node.jjtGetValue());
		// Agora pegamos o tipo da expressao
		TIPO tipoExpr = ((CustomNode) node.jjtGetChild(0)).getTipo();
		// Agora verificamos se sao compativeis

		if (!tipoID.equals(tipoExpr)) {
			data.addErro(((Token) node.jjtGetValue()).beginLine,
					"Tipos incompatíveis");
		}
		return null;
	}

	@Override
	public Object visit(ExpressaoMatematica node, Controlador data) {
		node.childrenAccept(this, data);
		// numa expressao, que soh tem um filho, o tipo eh igual ao tipo do
		// filho
		node.setTipo(((CustomNode) node.jjtGetChild(0)).getTipo());
		return null;
	}

	@Override
	public Object visit(Adicao node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(operaTipos(node)); // seta o tipo a partir dos sub-nos
		return null;
	}

	@Override
	public Object visit(Subtracao node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(operaTipos(node)); // seta o tipo a partir dos sub-nos
		return null;
	}

	@Override
	public Object visit(Multiplicacao node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(operaTipos(node)); // seta o tipo a partir dos sub-nos
		return null;
	}

	@Override
	public Object visit(Divisao node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(operaTipos(node)); // seta o tipo a partir dos sub-nos
		return null;
	}

	@Override
	public Object visit(Identificador node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(Numero node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(If node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(Else node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(While node, Controlador data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(Return node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(((CustomNode) node.jjtGetChild(0)).getTipo());
		return null;
	}

	@Override
	public Object visit(ExpressaoLogica node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(((CustomNode) node.jjtGetChild(0)).getTipo());
		return null;
	}

	@Override
	public Object visit(Or node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(((CustomNode) node.jjtGetChild(0)).getTipo());
		return null;
	}

	@Override
	public Object visit(And node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(((CustomNode) node.jjtGetChild(0)).getTipo());
		return null;
	}

	@Override
	public Object visit(MenorQue node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(TIPO.BOOLEAN);
		return null;
	}

	@Override
	public Object visit(MaiorQue node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(TIPO.BOOLEAN);
		return null;
	}

	@Override
	public Object visit(Igual node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(TIPO.BOOLEAN);
		return null;
	}

	@Override
	public Object visit(Diferente node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(TIPO.BOOLEAN);
		return null;
	}

	@Override
	public Object visit(MenorIgual node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(TIPO.BOOLEAN);
		return null;
	}

	@Override
	public Object visit(MaiorIgual node, Controlador data) {
		node.childrenAccept(this, data);
		node.setTipo(TIPO.BOOLEAN);
		return null;
	}

	// para todas as operacoes (adicao, subtracao, multiplicacao, divisao), se
	// ha um float
	// o resultado eh float
	private TIPO operaTipos(CustomNode node) {
		CustomNode esq = (CustomNode) node.jjtGetChild(0);
		CustomNode dir = (CustomNode) node.jjtGetChild(1);
		if (esq.getTipo().equals(TIPO.FLOAT)
				|| dir.getTipo().equals(TIPO.FLOAT))
			return TIPO.FLOAT;
		return TIPO.INT;
	}
}
