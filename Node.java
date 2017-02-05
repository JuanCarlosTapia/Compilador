
import java.util.ArrayList;

public class Node {
	
	// Atributos
	
		 private String data;
       
        private ArrayList<Node>  hijos = new ArrayList<Node>();
       
        private String ambito;
        private String tipo;
        
        
      
        public Node(String data) {
			super();
			this.data = data;
		}



		public String getData() {
			return data;
		}



		public void setData(String data) {
			this.data = data;
		}



		public String getTipo() {
			return tipo;
		}



		public void setTipo(String tipo) {
			this.tipo = tipo;
		}



		public ArrayList<Node> getHijos() {
			return hijos;
		}



		public void setHijos(ArrayList<Node> hijos) {
			this.hijos = hijos;
		}
        
        public void addHijos(Node hijo){
        	
        	hijos.add(hijo);
        }



		public String getAmbito() {
			return ambito;
		}



		public void setAmbito(String ambito) {
			this.ambito = ambito;
		}
        
        
}
        
        
 
        
       
		
		
		