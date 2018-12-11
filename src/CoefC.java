/* 
 * Nombre: Miroslav Krasimirov Vladimirov
 * email: mkrasimir4@alumno.uned.es / miro.kv89@gmail.com
 * NIE: X4780953N
 * tlfn: 676867565   
 */
import java.math.BigInteger;
public class CoefC implements Coef {
    //Implementacion con menor coste, pero sin traza
    BigInteger totaln= new BigInteger("1");
    BigInteger totalk= new BigInteger("1");
    BigInteger resultado= new BigInteger("0");
    int n,k;
    public CoefC(CoefC coef){
        new CoefC(coef.getN(),coef.getK());
       }
    public int getN(){return n;}
    public int getK(){return k;}
    public CoefC(int n, int k){
        this.n=n;
        this.k=k;
        calcular(n,k);
    }    
    public int calcular(int n, int k){
        boolean optimo=((2*k)>n);
        if(optimo){
            for(int i=n; i>k; i--){
                String miI=(i+"");
                totaln=totaln.multiply(new BigInteger(miI));    
            }           
            for (int j=1; j<=n-k; j++){
                String miJ=(j+"");
                totalk=totalk.multiply(new BigInteger(miJ));
            }
        }
        else{
            for(int i=n; i>(n-k); i--){
                String miI=(i+"");
                totaln=totaln.multiply(new BigInteger(miI));
            }
            for (int j=1; j<=k; j++){
                String miJ=(j+"");
                totalk=totalk.multiply(new BigInteger(miJ));
            }
            resultado=totaln.divide(totalk);
        }
        return resultado.intValue();
    }    
    public int getResultado(){
        return resultado.intValue();
    }
}
