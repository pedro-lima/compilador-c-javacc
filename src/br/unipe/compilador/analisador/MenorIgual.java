/* Generated By:JJTree: Do not edit this line. MenorIgual.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.unipe.compilador.analisador;

public
class MenorIgual extends CustomNode {
  public MenorIgual(int id) {
    super(id);
  }

  public MenorIgual(Gramatica p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(GramaticaVisitor visitor, Controlador data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=b80afc2027bb7b1b71e73c23a44a0f36 (do not edit this line) */