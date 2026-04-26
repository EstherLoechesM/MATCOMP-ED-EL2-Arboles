import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest2 {
    ArbolBinarioDeBusquedaEnteros arbol= new ArbolBinarioDeBusquedaEnteros();
    //Necesitamos un metodo especifico para sumar MiLista
    public int sumarMiLista(MiLista<Integer> lista){
        int total=0;
        for(int i=0; i<lista.size();i++){
            total+=lista.getActual(i);
        }
        return total;
    }
    public void addAleatorios(int cantidad){
        //Creamos un array de 'cantidad' posiciones
        int[] usados = new int[cantidad];
        int contador=0;

        while(contador<cantidad){
            //Generamos un numero entre 0 y maximo
            int numero = (int) (Math.random() * cantidad);
            //Comprobamos que los numeros no estan repetidos y si no los metemos
            if(!repetidos(usados, numero, contador)){
                usados[contador]=numero;
                arbol.add(numero);
                contador++;

            }
        }
    }
    public boolean repetidos(int[] array, int numero, int cantidad){
        for(int i=0; i<cantidad;i++){
            if(array[i]==numero){
                return true;
            }
        }
        return false;
    }
    @Test
    void comprobarSumas(){
        //i.Añadir los números de 0 a 128 aleatoriamente
        addAleatorios(128);
        //ii. Calcular la suma (getSuma())
        int sumaNormal=arbol.getSuma();
        System.out.println("la suma total es: "+sumaNormal);
        //iii. Verifica que la suma es la misma accediendo en los 3 tipos de recorridos posibles.
        int sumaCentral = sumarMiLista(arbol.getListaOrdenCentral());
        int sumaPre = sumarMiLista(arbol.getListaPreOrden());
        int sumaPost = sumarMiLista(arbol.getListaPostOrden());

        System.out.println("Suma Orden Central: " + sumaCentral);
        System.out.println("Suma PreOrden: " + sumaPre);
        System.out.println("Suma PostOrden: " + sumaPost);

        //¿Dan lo mismo?
        assertEquals(sumaNormal, sumaCentral, "La suma central coincide");
        assertEquals(sumaNormal, sumaPre, "La suma pre coincide");
        assertEquals(sumaNormal, sumaPost, "La suma post coincide");

        //iv. Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho
        MiLista ramaIzq= arbol.getSubArbolIzquierda();
        MiLista ramaDer= arbol.getSubArbolDerecha();
        int sumaTotal= sumarMiLista(ramaIzq)+ sumarMiLista(ramaDer);

        System.out.println("Suma rama der mas izq: " +sumaTotal);
        //La suma de las dos ramas es siempre diferente a la suma total, porque no contamos la raiz
        //v.¿Cuál es la altura del árbol?
        System.out.println("Altura total: "+arbol.getAltura());
        //vi.¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino?
        MiLista camino=arbol.getCamino(110);
        System.out.println("Camino: "+camino);
        System.out.println("Longitud del camino: "+camino.size());



    }
}
