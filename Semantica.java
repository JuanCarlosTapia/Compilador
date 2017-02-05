import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class Semantica {
	public ArrayList<String> errores;
	public Simbolos simbolos;
	
	public Semantica(Simbolos sim){
		simbolos = sim;
		errores = new  ArrayList<String>();
	}
	
	
	
   public void Evaluar(Node arbol){
	   HayMain();
	   IdentificadoresIguales();
	   
	   for(int i=0;i<errores.size();i++ ){
		   System.out.println(errores.get(i));
	   }
   }
	
	public void HayMain(){
		ArrayList<String> correcto = new ArrayList<String>();
		
		boolean hay = false;
		for(int i=0;i<simbolos.metodos.size();i++ ){
			String nom = simbolos.metodos.get(i).get(0);
			String type = simbolos.metodos.get(i).get(1);
			String par = simbolos.metodos.get(i).get(2);
			if (nom.equals("main") && type.equals("void") && par.equals("") ){
				hay = true;
			}
			
		}
		
		if(hay){
			
		}else{
			errores.add("Error. No hay un metodo main sin parametros");
		}
	}
	
	boolean error;
	public void IdentificadoresIguales(){
		
		
		error = false;
		ArrayList<ArrayList<String>> revisar = new ArrayList<ArrayList<String>>();
		
		
		
		
		for(int i=0;i<simbolos.variables.size();i++ ){
			ArrayList<String> actual1 = simbolos.variables.get(i);
			for(int j=0;j<simbolos.variables.size();j++ ){
				ArrayList<String> actual2 = simbolos.variables.get(j);
				
				if (i!=j)
				if(actual1.get(0).equals(actual2.get(0)) &&  actual1.get(3).equals(actual2.get(3))){
					errores.add("Error. La variable "+ simbolos.variables.get(0).get(0)+ " esta declarada mas de una vez en el mismo ambito");
				}
			}
			
			
			
			
			
			revisar.add(simbolos.variables.get(i));
			
		}
		
		
	}
	
	
	public String AsignarTipos(Node tree){
		
		if(tree.getHijos().size()==0){
			
		
    		return "";
    	}
    	else
    	{
    	    
    		
    		if(tree.getData().equals("Program")){
    			boolean valido = true;
    			String tipo = "";
    			
    			for(int i=3;i<tree.getHijos().size()-1;i++ ){
    				
    				tipo = AsignarTipos(tree.getHijos().get(i));
    				//if (!tipo.equals("void"))
    				//	valido = false;
    				
    			}
    			
    			if(valido){
    				tipo="void";
    			}else{
    				tipo="Error";
    			}
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		
    		if(tree.getData().equals("Declaration")){
    			String tipo = "";
    			
    			tipo = AsignarTipos(tree.getHijos().get(0));
    				
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		if(tree.getData().equals("MethodDeclaration")){
    			String tipo = "";
    			for(int i=0;i<tree.getHijos().size();i++ ){
    				if(tree.getHijos().get(i).getData().equals("Block")){
    					tipo = AsignarTipos(tree.getHijos().get(i));
    				}
    			}
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		
    		if(tree.getData().equals("VarDeclaration")){
    			tree.setTipo("void");
    			return "void";
    		}
    		
    		
    		//Block
    		if(tree.getData().equals("Block")){
    			boolean valido = true;
    			String tipo = "";
    			
    			for(int i=1;i<tree.getHijos().size()-1;i++ ){
    				
    				tipo = AsignarTipos(tree.getHijos().get(i));
    				if (!tipo.equals("void"))
    					valido = false;
    				
    			}
    			
    			if(valido){
    				tipo="void";
    			}else{
    				tipo="Error";
    			}
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		
    		
    		//   Asignar tipos a Statements
    		if(tree.getData().equals("Statement")){
    			String tipo="";
    			
    			
    			if(tree.getHijos().get(0).getData().equals("Location")){
    				Node izq = tree.getHijos().get(0);
    				Node der = tree.getHijos().get(2);
    				if (AsignarTipos(izq).equals(AsignarTipos(der))){
    					tipo = "void";
    				}else{
    					tipo = "Error";
    				}
    				
    				tree.setTipo(tipo);
        			return tipo;
    			
    				
    			}
    			
    			
    			
    			if(tree.getHijos().get(0).getData().equals("if")){
    				
    				if (tree.getHijos().size()==5){
    					String  exp = AsignarTipos(tree.getHijos().get(2));
    					String  blk = AsignarTipos(tree.getHijos().get(4));
    					
    					if (exp.equals("boolean") && blk.equals("void")){
    						tipo = "void";
    					}
    					
    				}else{
    					String  exp = AsignarTipos(tree.getHijos().get(2));
    					String  blk = AsignarTipos(tree.getHijos().get(4));
    					String  blk2 = AsignarTipos(tree.getHijos().get(6));
    					
    					if (exp.equals("boolean") && blk.equals("void") && blk2.equals("void")){
    						tipo = "void";
    					}
    					
    				}
    				
    				
    				
    				tree.setTipo(tipo);
        			return tipo;
    			
    				
    			}
    			
    			if(tree.getHijos().get(0).getData().equals("while")){
    				
    				
   					String  exp = AsignarTipos(tree.getHijos().get(2));
    				String  blk = AsignarTipos(tree.getHijos().get(4));
    				
    				if (exp.equals("boolean") && blk.equals("void")){
    					tipo = "void";
    				}
    			
    				
    				
    				
    				tree.setTipo(tipo);
        			return tipo;
    			
    				
    			}
    			
    			
    			if(tree.getHijos().get(0).getData().equals("Block")){
    				tipo = AsignarTipos(tree.getHijos().get(0));
    				tree.setTipo(tipo);
        			return tipo;
    			}
    				
    			
    			
    		}
    		
    		// Asignar tipos a Expression
    		
    		if(tree.getData().equals("Expression")){
    			String tipo="";
    			
    			if(tree.getHijos().get(0).getData().equals("Location")){
    				tipo = AsignarTipos(tree.getHijos().get(0));
    			}
    			
    			
    			if(tree.getHijos().get(0).getData().equals("Literal")){
    				tipo = AsignarTipos(tree.getHijos().get(0));
    			}
    			
    			
    			
    			
    			
    			
    			if(tree.getHijos().get(0).getData().equals("-")){
    				tipo = AsignarTipos(tree.getHijos().get(1));
    				if(!tipo.equals("int"))
    					tipo = "Error";
    			}
    			
    			if(tree.getHijos().get(0).getData().equals("!")){
    				tipo = AsignarTipos(tree.getHijos().get(1));
    				if(!tipo.equals("boolean"))
    					tipo = "Error";
    			}
    			
    			if(tree.getHijos().get(0).getData().equals("(")){
    				tipo = AsignarTipos(tree.getHijos().get(1));
    				
    			}
    			
    			
    			
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		
    		if(tree.getData().equals("Location")){
    			String tipo = BuscarVariable(tree.getHijos().get(0).getData(),tree.getAmbito());
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		
    		if(tree.getData().equals("Cond")){
    			String tipo ="";
    			boolean valido=true;
    			if(tree.getHijos().size()==1){
    				tipo = AsignarTipos(tree.getHijos().get(0));
    			}else{
    				for(int i=0;i<tree.getHijos().size()  ;i=i+2 ){
    					tipo = AsignarTipos(tree.getHijos().get(i));
    					if(!tipo.equals("boolean"))
    						valido=false;
    				}
    				
    				if(valido){
        				tipo="boolean";
        			}else{
        				tipo="Error";
        			}
    				
    			}
    				
    			
    			
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		if(tree.getData().equals("Eq")){
    			String tipo ="";
    			if(tree.getHijos().size()==1){
    				 tipo = AsignarTipos(tree.getHijos().get(0));
    			}else{
    				if(AsignarTipos(tree.getHijos().get(0)).equals(AsignarTipos(tree.getHijos().get(2)))){
    					tipo = "boolean";
    				}
    				else{
    					tipo = "Error";
    				}
    			}
    		
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		
    		if(tree.getData().equals("Rel")){
    			String tipo ="";
    			if(tree.getHijos().size()==1){
    				 tipo = AsignarTipos(tree.getHijos().get(0));
    			}
    			else{
    				if(AsignarTipos(tree.getHijos().get(0)).equals("int") &&  AsignarTipos(tree.getHijos().get(2)).equals("int")    ){
    					tipo = "boolean";
    				}
    				else{
    					tipo = "Error";
    				}
    			}
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		if(tree.getData().equals("Term")){
    			String tipo ="";
    			boolean valido=true;
    			if(tree.getHijos().size()==1){
    				tipo = AsignarTipos(tree.getHijos().get(0));
    			}else{
    				for(int i=0;i<tree.getHijos().size()  ;i=i+2 ){
    					tipo = AsignarTipos(tree.getHijos().get(i));
    					if(!tipo.equals("int"))
    						valido=false;
    				}
    				if(valido){
        				tipo="int";
        			}else{
        				tipo="Error";
        			}
    				
    			}
    				
    			
    			
    			
    			
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		if(tree.getData().equals("Operacion")){
    			String tipo ="";
    			boolean valido=true;
    			if(tree.getHijos().size()==1){
    				tipo = AsignarTipos(tree.getHijos().get(0));
    			}else{
    				for(int i=0;i<tree.getHijos().size()  ;i=i+2 ){
    					tipo = AsignarTipos(tree.getHijos().get(i));
    					if(!tipo.equals("int"))
    						valido=false;
    				}
    				if(valido){
        				tipo="int";
        			}else{
        				tipo="Error";
        			}
    				
    			}
    				
    			
    			
    				
    			
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		
    		if(tree.getData().equals("Literal")){
    			String tipo = AsignarTipos(tree.getHijos().get(0));
    			tree.setTipo(tipo);
    			return tipo;
    		}
    		
    		if(tree.getData().equals("Int_literal")){
    			tree.setTipo("int");
    			return "int";
    		}
    		
    		if(tree.getData().equals("Char_literal")){
    			tree.setTipo("char");
    			return "char";
    		}
    		
    		if(tree.getData().equals("Bool_literal")){
    			tree.setTipo("boolean");
    			return "boolean";
    		}
    		
    		
    		
	    	for(int i=0;i<tree.getHijos().size();i++ ){
	    			AsignarTipos(tree.getHijos().get(i));
	    		}
    		
    		
    		
    	}
		return null;
	}
	
	
	public String BuscarVariable(String var, String block){
		String tipo;
		int encaja=0;
		int ambG = 1000;
		for(int i=0;i<simbolos.variables.size()  ;i++ ){
			String nomActual = simbolos.variables.get(i).get(0);
			String blkActual = simbolos.variables.get(i).get(3);
			if(nomActual.equals(var)){
				int amb = block.replace(blkActual, "").length();				
				
				if(amb<ambG){
					encaja = i;
					ambG=amb;
				}
			}
		}
		return simbolos.variables.get(encaja).get(1);
		
	}

	public  ArrayList<String> getErrores() {
		return this.errores;
	}

	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}
	
	
	
	
}
