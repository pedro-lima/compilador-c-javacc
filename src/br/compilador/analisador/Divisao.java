/* Generated By:JJTree: Do not edit this line. Divisao.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.compilador.analisador;

public
class Divisao extends CustomNode {
  public Divisao(int id) {
    super(id);
  }

  public Divisao(Gramatica p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(GramaticaVisitor visitor, Controlador data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f7d03f5572c70c58b9c9f8c750226030 (do not edit this line) */
