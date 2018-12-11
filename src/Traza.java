/* 
 * Nombre: Miroslav Krasimirov Vladimirov
 * email: mkrasimir4@alumno.uned.es / miro.kv89@gmail.com
 * NIE: X4780953N
 * tlfn: 676867565   
 */
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
public class Traza extends JFrame {
     public Traza(int[][] matriz,int n,int k) {
         final JTable tabla = new JTable(n+1, k+1);
         //Creamos un JscrollPane y le agregamos la JTable         
         JScrollPane scrollPane = new JScrollPane(tabla);
         tabla.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
         //Agregamos el JScrollPane al contenedor
         getContentPane().add(scrollPane, BorderLayout.CENTER);
         //manejamos la salida
         addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {System.exit(0);}
         });
         this.setSize(500, 500);
         this.setExtendedState(MAXIMIZED_BOTH);    
         tabla.setEnabled(false);
         setVisible(true);
            for (int i=0; i<=n; i++) {
                 matriz[i][0]=1;
                 	try {	Thread.sleep (100);
                            } catch (Exception e) {
                            System.out.println("Error indeterminado");
                            }
                 tabla.setValueAt(matriz[i][0],i,0);
            }
            for (int i=1; i<=n; i++) {
                matriz[i][1]=i;
                	try {   Thread.sleep (100);
                            } catch (Exception e) {
                            System.out.println("Error indeterminado");
                            }
                tabla.setValueAt(matriz[i][1],i,1);
            }
            for (int i=2; i<=k; i++) {
                matriz[i][i]=1;
                	try {	Thread.sleep (100);
                            } catch (Exception e) {
                            System.out.println("Error indeterminado");
                            }
                tabla.setValueAt(matriz[i][i],i,i);
            }
            for (int i=3; i<=n; i++){
                for(int j=2; j<n; j++){ 
                    if(j<=k && j<i){                        
                        try {Thread.sleep (100);
                            } catch (Exception e) {
                            System.out.println("Error indeterminado");
                            }
                        tabla.setValueAt(matriz[i][j],i,j);                       
                    }
                }
            }
        }
}
  