// Generated from com.enmer.compi2/DecafOLC2.g4 by ANTLR 4.13.2
package com.enmer.compi2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DecafOLC2Parser}.
 */
public interface DecafOLC2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(DecafOLC2Parser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(DecafOLC2Parser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#claseDecl}.
	 * @param ctx the parse tree
	 */
	void enterClaseDecl(DecafOLC2Parser.ClaseDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#claseDecl}.
	 * @param ctx the parse tree
	 */
	void exitClaseDecl(DecafOLC2Parser.ClaseDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#miembroClase}.
	 * @param ctx the parse tree
	 */
	void enterMiembroClase(DecafOLC2Parser.MiembroClaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#miembroClase}.
	 * @param ctx the parse tree
	 */
	void exitMiembroClase(DecafOLC2Parser.MiembroClaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#campoDecl}.
	 * @param ctx the parse tree
	 */
	void enterCampoDecl(DecafOLC2Parser.CampoDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#campoDecl}.
	 * @param ctx the parse tree
	 */
	void exitCampoDecl(DecafOLC2Parser.CampoDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#listaVars}.
	 * @param ctx the parse tree
	 */
	void enterListaVars(DecafOLC2Parser.ListaVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#listaVars}.
	 * @param ctx the parse tree
	 */
	void exitListaVars(DecafOLC2Parser.ListaVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#varInit}.
	 * @param ctx the parse tree
	 */
	void enterVarInit(DecafOLC2Parser.VarInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#varInit}.
	 * @param ctx the parse tree
	 */
	void exitVarInit(DecafOLC2Parser.VarInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDecl(DecafOLC2Parser.ConstructorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDecl(DecafOLC2Parser.ConstructorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#metodoDecl}.
	 * @param ctx the parse tree
	 */
	void enterMetodoDecl(DecafOLC2Parser.MetodoDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#metodoDecl}.
	 * @param ctx the parse tree
	 */
	void exitMetodoDecl(DecafOLC2Parser.MetodoDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(DecafOLC2Parser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(DecafOLC2Parser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(DecafOLC2Parser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(DecafOLC2Parser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(DecafOLC2Parser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(DecafOLC2Parser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#tipoBase}.
	 * @param ctx the parse tree
	 */
	void enterTipoBase(DecafOLC2Parser.TipoBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#tipoBase}.
	 * @param ctx the parse tree
	 */
	void exitTipoBase(DecafOLC2Parser.TipoBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(DecafOLC2Parser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(DecafOLC2Parser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#modificador}.
	 * @param ctx the parse tree
	 */
	void enterModificador(DecafOLC2Parser.ModificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#modificador}.
	 * @param ctx the parse tree
	 */
	void exitModificador(DecafOLC2Parser.ModificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(DecafOLC2Parser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(DecafOLC2Parser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(DecafOLC2Parser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(DecafOLC2Parser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(DecafOLC2Parser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(DecafOLC2Parser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(DecafOLC2Parser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(DecafOLC2Parser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStmt(DecafOLC2Parser.DoWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStmt(DecafOLC2Parser.DoWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(DecafOLC2Parser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(DecafOLC2Parser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(DecafOLC2Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(DecafOLC2Parser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(DecafOLC2Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(DecafOLC2Parser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(DecafOLC2Parser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(DecafOLC2Parser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#switchItem}.
	 * @param ctx the parse tree
	 */
	void enterSwitchItem(DecafOLC2Parser.SwitchItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#switchItem}.
	 * @param ctx the parse tree
	 */
	void exitSwitchItem(DecafOLC2Parser.SwitchItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(DecafOLC2Parser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(DecafOLC2Parser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DecafOLC2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DecafOLC2Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#asignacionExpr}.
	 * @param ctx the parse tree
	 */
	void enterAsignacionExpr(DecafOLC2Parser.AsignacionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#asignacionExpr}.
	 * @param ctx the parse tree
	 */
	void exitAsignacionExpr(DecafOLC2Parser.AsignacionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#opAsig}.
	 * @param ctx the parse tree
	 */
	void enterOpAsig(DecafOLC2Parser.OpAsigContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#opAsig}.
	 * @param ctx the parse tree
	 */
	void exitOpAsig(DecafOLC2Parser.OpAsigContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(DecafOLC2Parser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(DecafOLC2Parser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(DecafOLC2Parser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(DecafOLC2Parser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#igualdadExpr}.
	 * @param ctx the parse tree
	 */
	void enterIgualdadExpr(DecafOLC2Parser.IgualdadExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#igualdadExpr}.
	 * @param ctx the parse tree
	 */
	void exitIgualdadExpr(DecafOLC2Parser.IgualdadExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(DecafOLC2Parser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(DecafOLC2Parser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#aditivoExpr}.
	 * @param ctx the parse tree
	 */
	void enterAditivoExpr(DecafOLC2Parser.AditivoExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#aditivoExpr}.
	 * @param ctx the parse tree
	 */
	void exitAditivoExpr(DecafOLC2Parser.AditivoExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(DecafOLC2Parser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(DecafOLC2Parser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(DecafOLC2Parser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(DecafOLC2Parser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(DecafOLC2Parser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(DecafOLC2Parser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOp(DecafOLC2Parser.PostfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOp(DecafOLC2Parser.PostfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#primaria}.
	 * @param ctx the parse tree
	 */
	void enterPrimaria(DecafOLC2Parser.PrimariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#primaria}.
	 * @param ctx the parse tree
	 */
	void exitPrimaria(DecafOLC2Parser.PrimariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(DecafOLC2Parser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(DecafOLC2Parser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafOLC2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(DecafOLC2Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafOLC2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(DecafOLC2Parser.LiteralContext ctx);
}