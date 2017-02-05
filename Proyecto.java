import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Proyecto {

	private JFrame frame;
	private JTree tree_1;
    public static String lenguage =  "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz+-*/%|&!<>{}()[].;,";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto window = new Proyecto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Proyecto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 755);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(144, 586, 594, 87);
		frame.getContentPane().add(scrollPane_2);
		JTextArea textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 726, 560);
		frame.getContentPane().add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		JTextArea txtrClassProgramVoid = new JTextArea();
		txtrClassProgramVoid.setText("class Program{\r\n\tint var1;\r\n\tvoid main(){\r\n\t\tvar1 = 4;\r\n\t\tvar1 = var1 +1;\r\n\t\r\n\t\r\n\t}\r\n\r\n\r\n}");
		scrollPane_1.setViewportView(txtrClassProgramVoid);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		tree_1 = new JTree();
		tree_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(tree_1);
		tree_1.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Arbol") {
				{
				}
			}
		));
		
		JButton btnCompiilar = new JButton("Compiilar");
		btnCompiilar.setBounds(12, 586, 117, 87);
		frame.getContentPane().add(btnCompiilar);
		btnCompiilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Click");
				
				 ANTLRInputStream input = new ANTLRInputStream(txtrClassProgramVoid.getText());
				 HelloLexer lexer = new HelloLexer(input);
				 
			        CommonTokenStream tokens = new CommonTokenStream(lexer);

			        
			        
			        MyErrorListener errorr = new MyErrorListener();
			        
			        lexer.removeErrorListeners();
			        
			        lexer.addErrorListener(errorr); 
			        
			        
			        HelloParser parser = new HelloParser(tokens);
			        
			        parser.removeErrorListeners();
			        parser.addErrorListener(errorr); 
			       
			       //parser.removeErrorListeners();
			       
			        
			        ParseTree tree = parser.program(); // begin parsing at rule 'r'
			        
			        
			        int errores = parser.getNumberOfSyntaxErrors();
			        
			        
			       // System.out.println(errores);
			        
			        String s = "";
			        for (int i =0;i<errorr.ErrorMessages.size();i++){
			        	//System.out.println(errorr.ErrorMessages.get(i));
			        	s = s + errorr.ErrorMessages.get(i)+'\n';
			        }
			        
			        
			        textArea_1.setText(s);
			        
			        
			        
			       //System.out.println(tree.getPayload());
			       //System.out.println(tree.getChild(0).getPayload());
			       //System.out.println(tree.getChild(1).getPayload()); 
			       //System.out.println(tree.getChild(2).getPayload()); 
			       
			        tree_1.setModel(null);
			        if(errores ==0){
			        	Arbol arbol = new Arbol(tree);
				       
				        
				        
				        arbol.AsignarBloques(arbol.raiz,"Global");
				        
				       
				        
				        Simbolos simbolos = new Simbolos();
				        
				        simbolos.tablaDeSimbolos(arbol.raiz);
				        //simbolos.imprimir();
				        
				        Semantica semantica = new Semantica(simbolos);
				        
				        semantica.Evaluar(arbol.raiz);
				        
				       
				        semantica.AsignarTipos(arbol.raiz);
				        
				        
				        
				        DefaultMutableTreeNode node = new DefaultMutableTreeNode (arbol.raiz.getData()+" - "+arbol.raiz.getTipo());
				        arbol.MostrarArbol(arbol.raiz, -1,node);
				        tree_1.setModel(new DefaultTreeModel(node));
				        
				        
				        
			        }
			        
			       
			      
			      
			       
			        
			        
			        
			        
			        
			        

			}
		});
		
		
		
		
		
		
	}
	
	public static boolean lexicoError(String s){
		
		for(int i=0; i<s.length(); i++){
			if(lenguage.contains(s.charAt(i)+"")){
				
				
				
			}else{
				return true;
			}
			
			
		}
		return false;
		
	}
}
