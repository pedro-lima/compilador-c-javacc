/* Generated By:JJTree: Do not edit this line. ExpressaoMatematica.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.unipe.compilador.analisador;

public
class ExpressaoMatematica extends CustomNode {
  public ExpressaoMatematica(int id) {
    super(id);
  }

  public ExpressaoMatematica(Gramatica p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(GramaticaVisitor visitor, Controlador data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=286274f7427715d447975e6046c898d4 (do not edit this line) */