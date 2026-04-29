public class MiLista<T> {
    private ElementoDE<T> primero;
    private ElementoDE<T> ultimo;
    private int tamaño;

    public MiLista(){
        this.primero=null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    public boolean isEmpty(){
        return primero==null;
    }
    public int size(){
        return tamaño;
    }
    public T getDato(int indice){
        ElementoDE<T> actual=primero;
        for(int i=0; i<indice;i++){
            actual=actual.siguiente;
        }
        return actual.dato;
    }
    //No usamos un add de una lista doble ordenada porque sino no dejariamos que el arbol se organice correctamente
    public void add(T dato) {
        ElementoDE<T> nuevo=new ElementoDE<>(dato);
        if(isEmpty()){
            primero=nuevo;
            ultimo=nuevo;
        }else{
            ultimo.siguiente=nuevo;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
        }
        tamaño++;
    }
    public void addAll(MiLista<T> another){
        if (another == null || another.primero == null) return;

        ElementoDE<T> actual = another.primero;
        while (actual != null) {
            this.add(actual.dato);
            actual = actual.siguiente;
        }
    }
    @Override
    public String toString() {
        //A resultado le vamos añadiendo el corchete, los datos separados por comas y el ultimo corchete
        String resultado = "[ ";
        ElementoDE<T> actual = primero;

        while (actual != null) {
            // Concatenamos el dato
            resultado += actual.dato;

            if (actual.siguiente != null) {
                resultado += ", ";
            }
            actual = actual.siguiente;
        }

        resultado += " ]";
        return resultado;
    }

}
