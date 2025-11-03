// Generated from com.enmer.compi2/DecafOLC2.g4 by ANTLR 4.13.2
package com.enmer.compi2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DecafOLC2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DecafOLC2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(DecafOLC2Parser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#claseDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClaseDecl(DecafOLC2Parser.ClaseDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#miembroClase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiembroClase(DecafOLC2Parser.MiembroClaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#campoDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampoDecl(DecafOLC2Parser.CampoDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#listaVars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaVars(DecafOLC2Parser.ListaVarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#varInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInit(DecafOLC2Parser.VarInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#constructorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDecl(DecafOLC2Parser.ConstructorDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#metodoDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetodoDecl(DecafOLC2Parser.MetodoDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(DecafOLC2Parser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(DecafOLC2Parser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(DecafOLC2Parser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#tipoBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoBase(DecafOLC2Parser.TipoBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(DecafOLC2Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#modificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModificador(DecafOLC2Parser.ModificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(DecafOLC2Parser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(DecafOLC2Parser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(DecafOLC2Parser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(DecafOLC2Parser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#doWhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmt(DecafOLC2Parser.DoWhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(DecafOLC2Parser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(DecafOLC2Parser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(DecafOLC2Parser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#switchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStmt(DecafOLC2Parser.SwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#switchItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchItem(DecafOLC2Parser.SwitchItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(DecafOLC2Parser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(DecafOLC2Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#asignacionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacionExpr(DecafOLC2Parser.AsignacionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#opAsig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpAsig(DecafOLC2Parser.OpAsigContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(DecafOLC2Parser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(DecafOLC2Parser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#igualdadExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualdadExpr(DecafOLC2Parser.IgualdadExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(DecafOLC2Parser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#aditivoExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAditivoExpr(DecafOLC2Parser.AditivoExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(DecafOLC2Parser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(DecafOLC2Parser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#postfixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(DecafOLC2Parser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#postfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOp(DecafOLC2Parser.PostfixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#primaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaria(DecafOLC2Parser.PrimariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(DecafOLC2Parser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafOLC2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(DecafOLC2Parser.LiteralContext ctx);
}