/* Generated By:JJTree: Do not edit this line. Else.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.unipe.compilador.analisador;

public
class Else extends CustomNode {
  public Else(int id) {
    super(id);
  }

  public Else(Gramatica p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(GramaticaVisitor visitor, Controlador data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=346320b48eaa51ea07800324141a835c (do not edit this line) */