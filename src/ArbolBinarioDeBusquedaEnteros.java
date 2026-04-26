import java.util.ArrayList;
import java.util.List;
public class ArbolBinarioDeBusquedaEnteros {
    protected Integer dato;
    protected ArbolBinarioDeBusquedaEnteros der;
    protected ArbolBinarioDeBusquedaEnteros izq;
    public ArbolBinarioDeBusquedaEnteros(){
        this.dato=null;
        this.izq=null;
        this.der=null;
    }
    public int getSuma(){
        if (this.dato==null){
            return 0;
        }
        //Caso base:
        int resultado=this.dato;
        //Suma izquierda
        if(this.izq!=null){
            resultado+=((ArbolBinarioDeBusquedaEnteros) this.izq).getSuma();
        }
        //Suma derecha
        if(this.der!=null){
            resultado+=((ArbolBinarioDeBusquedaEnteros) this.der).getSuma();
        }
        return resultado;
    }
}
