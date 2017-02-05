// Generated from Hello.txt by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(HelloParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(HelloParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(HelloParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(HelloParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(HelloParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(HelloParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(HelloParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(HelloParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(HelloParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(HelloParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(HelloParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(HelloParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(HelloParser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(HelloParser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(HelloParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(HelloParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(HelloParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(HelloParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(HelloParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(HelloParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HelloParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HelloParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(HelloParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(HelloParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterOperacion(HelloParser.OperacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitOperacion(HelloParser.OperacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(HelloParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(HelloParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(HelloParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(HelloParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(HelloParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(HelloParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(HelloParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(HelloParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(HelloParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(HelloParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(HelloParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(HelloParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(HelloParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(HelloParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#arith_opa}.
	 * @param ctx the parse tree
	 */
	void enterArith_opa(HelloParser.Arith_opaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#arith_opa}.
	 * @param ctx the parse tree
	 */
	void exitArith_opa(HelloParser.Arith_opaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#arith_opb}.
	 * @param ctx the parse tree
	 */
	void enterArith_opb(HelloParser.Arith_opbContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#arith_opb}.
	 * @param ctx the parse tree
	 */
	void exitArith_opb(HelloParser.Arith_opbContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(HelloParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(HelloParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(HelloParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(HelloParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(HelloParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(HelloParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(HelloParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(HelloParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(HelloParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(HelloParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(HelloParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(HelloParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(HelloParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(HelloParser.Bool_literalContext ctx);
}