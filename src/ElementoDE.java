public class ElementoDE<T> {
    T dato;
    ElementoDE<T> siguiente;
    ElementoDE<T> anterior;
    //Creamos vagon, el NODO
    ElementoDE(T dato){
        this.dato=dato;//Variable con la dirección del dato
        this.siguiente=null;//Variable con la direccion de otros nodos
        this.anterior=null;
    }
    public T getDato() {
        return this.dato;
    }
}
