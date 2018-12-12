
public class CoefB implements Coef {
    int[][] matriz= null;
    int n,k;
    public CoefB(CoefB coef){
        new CoefC(coef.getN(),coef.getK());
    }
    public int getN(){return n;}
    public int getK(){return k;}
    public CoefB(int n, int k){ 
        this.n=n;
        this.k=k;
        this.matriz=new int[n][k];
    }        
    public int calcular(int n, int k){
        this.n=n;
        this.k=k;
        this.matriz=new int[n+1][k+1];
        if((n-k)==1){matriz[n][k]=n;return matriz[n][k];}
        if(k<1 || k==n){matriz[n][k]=1;return matriz[n][k];}
        else{
            for (int i=0; i<=n; i++) matriz[i][0]=1;
            for (int i=1; i<=n; i++) matriz[i][1]=i;
            for (int i=2; i<=k; i++) matriz[i][i]=1;
            for (int i=3; i<=n; i++){
                for(int j=2; j<=k; j++){                    
                    //if(j<=k && j<i){ 
                        matriz[i][j] = matriz[i-1][j-1]+matriz[i-1][j]; 
                    //}
                }
            }
        } 
        return matriz[n][k];
    }
    public int[][] getMatriz(){
        return matriz;
    }
    public int getResultado(){
        calcular(n,k);
        return matriz[n][k];
    }
    public void mostrarTraza(){
        new Traza(matriz,n,k);
    }
}
