import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class Simbolos {
	public static ArrayList<ArrayList<String>> variables;
	public static ArrayList<ArrayList<String>> metodos;
	
	public  Simbolos(){
		variables = new  ArrayList<ArrayList<String>>();
		metodos = new  ArrayList<ArrayList<String>>();
	}
	
	public static void tablaDeSimbolos(Node arbol){
		
		if(arbol.getHijos().size()==0){
			
			
    		return;
    	}
    	else
    	{
    	
    		if(arbol.getData().equals("VarDeclaration")){
    			
    			nuevaVariable(arbol);
    			
    		}
    		
    		else if(arbol.getData().equals("MethodDeclaration")){
    			
    			nuevoMetodo(arbol);
    			
    		}
    		
    		else if(arbol.getData().equals("Location")){
    			noDeclarada(arbol);
    		}
    		for(int i=0;i<arbol.getHijos().size();i++ ){
    			tablaDeSimbolos(arbol.getHijos().get(i));
    		}
    	}
	}
	
	
	private static void nuevaVariable(Node variable){
		ArrayList<String> nuevaVar = new ArrayList<String>();
		nuevaVar.add(variable.getHijos().get(1).getData());
		nuevaVar.add(variable.getHijos().get(0).getHijos().get(0).getData());
		if(variable.getHijos().size()==6){
			if(Integer.parseInt(variable.getHijos().get(3).getData()) <=0){
				System.out.println("Error. El arreglo "+nuevaVar.get(0)+" no tiene una declaracion valida");
				
			}
				
			nuevaVar.add(variable.getHijos().get(3).getData());
		}else{
			nuevaVar.add("0");
		}
		nuevaVar.add(variable.getAmbito());
		variables.add(nuevaVar);
	}
	
	
	private static void nuevoMetodo(Node metodo){
		ArrayList<String> nuevoMet = new ArrayList<String>();
		nuevoMet.add(metodo.getHijos().get(1).getData());
		nuevoMet.add(metodo.getHijos().get(0).getHijos().get(0).getData());
		nuevoMet.add(parametros(metodo));
		nuevoMet.add(metodo.getHijos().get(metodo.getHijos().size()-1).getHijos().get(0).getAmbito().replaceAll("Global-", ""));
		
		metodos.add(nuevoMet);
	}
	
	private static String parametros(Node metodo){
		String s = "";
		for(int i=2;i<(metodo.getHijos().size()-1);i++ ){
			if(metodo.getHijos().get(i).getData().equals("Parameter")){
				String nombre = metodo.getHijos().get(i).getHijos().get(1).getData();
				String tipo = metodo.getHijos().get(i).getHijos().get(0).getHijos().get(0).getData();
				s=s+nombre+"-"+tipo+";";
				
			}
		}
		return s;
	}
	
	
	private static void noDeclarada(Node variable){
		String nom1 =  variable.getHijos().get(0).getData();
		String block1 = variable.getHijos().get(0).getAmbito();
		boolean esta = false;
		for(int i=0;i<variables.size()  ;i++ ){
			String nom2 =  variables.get(i).get(0);
			String block2 = variables.get(i).get(3);
			if (nom1.equals(nom2)  &&  block1.contains(block2)){
				esta = true;
		
			}
		}
		
		if(esta){
			
		}
		else{
			System.out.println("La variable " + nom1 + " es llamada sin ser declarada");
		}
	}
	
	
	public static  void imprimir(){
		
		for(int i=0;i<variables.size()  ;i++ ){
			System.out.println(variables.get(i));
		}
		
		System.out.println();
		for(int i=0;i<metodos.size()  ;i++ ){
			System.out.println(metodos.get(i));
		}
		
	}
	
}
