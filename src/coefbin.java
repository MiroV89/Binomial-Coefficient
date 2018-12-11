/* 
 * Nombre: Miroslav Krasimirov Vladimirov
 * email: mkrasimir4@alumno.uned.es / miro.kv89@gmail.com
 * NIE: X4780953N
 * tlfn: 676867565   
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.math.BigInteger;
public class coefbin{
    String cadena=""; // Variable utilizada para guardar el contenido del vector e imprimirlo
    CoefB cbb;     
    public coefbin(String select, String f_entrada, String f_salida){
        boolean traza=(select.trim().equals("-t") || select.trim().equals("-T"));
        boolean help=(select.trim().equals("-h") || select.trim().equals("-H"));
        //Booleano Coeficiente C, para calcular con el segundo algoritmo creado.
        boolean CC=(select.trim().equals("-c") || select.trim().equals("-C"));
        cbb = new CoefB(0,0);
        if(!traza && !help && !CC){
            f_salida=f_entrada;
            f_entrada=select;
        }
        if(f_entrada.isEmpty())System.out.println("Seleccione archivo de entrada");
        //Solo se permitiran archivos con formato *.txt, en caso de que no se ponga expresamente se añadira por el programa.
        if(!f_entrada.endsWith(".txt"))f_entrada=f_entrada+".txt";
        if(!f_salida.isEmpty() && !f_salida.endsWith(".txt"))f_salida=f_salida+".txt";
        
        //(-h)OPCION HELP o AYUDA
        if (help){
            System.out.println("SINTAXIS:");
            System.out.println("servicio [-t] [-h] [fichero_entrada] [fichero_salida]");
            System.out.println("-t\t\t\t Traza la construcción del triángulo de Pascal");
            System.out.println("-h\t\t\t Muestra esta ayuda");
            System.out.println("fichero_entrada\t\t Nombre del fiechero de entrada");
            System.out.println("fichero_salida\t\t Nombre del fichero de salida");
        }               
        //Caso con archivo de entrada
        else if(!f_entrada.isEmpty()){
            //Se utiliza 1 ArrayListde Coeficientes binomiales
            ArrayList<CoefB> listaB = new ArrayList<CoefB>();
            ArrayList<BigInteger> listaV= new ArrayList<BigInteger>();
            try {
                //Lectura del fichero de entrada
                BufferedReader lector = new BufferedReader(new FileReader(f_entrada));
                String linea = lector.readLine();
                while(linea != null){
                    String[] cadena = linea.split(" ");                         
                    cbb=new CoefB(Integer.parseInt(cadena[0]),Integer.parseInt(cadena[1]));
                    String numero = cbb.getResultado()+"";
                    if(CC){
                        BigInteger valor = new BigInteger(numero);
                        listaV.add(valor);
                    }         
                    //Se rellena el ArrayList con los coeficientes existentes
                    listaB.add(cbb);
                    linea = lector.readLine();
                }
                lector.close();
            }
            catch (Exception e){System.out.println("Ha ocurrido un error no previsto");}
            //Se calcula el resultado del coeficiente binomial: n
            //Se rellena la cadena de salida utilizando el orden de llegada con coste: nlog(n)
            if(CC){
                for(BigInteger i: listaV){cadena+=(i.intValue()+"\n");}
            }
            else{
                for(CoefB cbb: listaB){
                    cadena+=(cbb.getResultado()+"\n");
                    //(-t)OPCION TRAZA solo esta disponible con la implementacion del triangulo de Pascal
                    // y SOLO podra ser comprobada por pantalla
                    if (traza){ 
                        cbb.mostrarTraza();
                    }
                }
            }
            //Casos de salida de fichero
            try {
                //Sin archivo de salida, imprimimos por pantalla
                if(f_salida.isEmpty()){
                    System.out.println(cadena);    
                }
                //Guardamos el contenido en el archivo de salida
                else if(f_salida!=null || !f_salida.isEmpty()) {
                    File nuevo=new File(f_salida);
                    String ruta=nuevo.getAbsolutePath();
                    File archivo=new File(ruta);
                    if(archivo.exists()){
                        System.out.println("Error, no se permite sobreescribrir.");
                    }
                    else if(!archivo.exists()){
                        FileWriter escribir=new FileWriter(archivo,true);
                        escribir.write("\r\n");
                        escribir.write(cadena);
                        escribir.close();
                    }  
                }
            }
            catch(Exception e){System.out.println("Ha ocurrido un error no previsto");}
        }
        else{System.out.println("Comando incorrecto");}
    }
        public static void main(String[] args) {
        new coefbin(args[0],args[1],args[2]);
        //new coefbin("-t","doc_e","");
    }
}