/* Generated By:JJTree: Do not edit this line. Numero.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.compilador.analisador;

public
class Numero extends CustomNode {
  public Numero(int id) {
    super(id);
  }

  public Numero(Gramatica p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(GramaticaVisitor visitor, Controlador data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=8c4c56c78fcd0f208e4fd4e421aaa546 (do not edit this line) */
