
public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer>{
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
    @Override
    public void add(Integer nuevo) {
        if (this.dato == null) {
            this.dato = nuevo;
        } else {
            if (nuevo.compareTo(this.dato) < 0) {
                if (this.izq == null) {
                    // Creamos un hijo de tipo Enteros, no genérico
                    this.izq = new ArbolBinarioDeBusquedaEnteros();
                }
                this.izq.add(nuevo);
            } else if (nuevo.compareTo(this.dato) > 0) {
                if (this.der == null) {
                    // Creamos un hijo de tipo Enteros, no genérico
                    this.der = new ArbolBinarioDeBusquedaEnteros();
                }
                this.der.add(nuevo);
            }
        }
    }
    //Necesitamos un metodo especifico para sumar MiLista
    public int sumarMiLista(MiLista<Integer> lista){
        int total=0;
        for(int i=0; i<lista.size();i++){
            total+=lista.getDato(i);
        }
        return total;
    }
}
