import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {
    public int sumarMiLista(MiLista<Integer> lista){
        int total=0;
        for(int i=0; i<lista.size();i++){
            total+=lista.getActual(i);
        }
        return total;
    }
    @Test
    void comprobarSumas(){
        ArbolBinarioDeBusquedaEnteros arbol= new ArbolBinarioDeBusquedaEnteros();
        //i.Añadir los números de 0 a 128 en orden
        for(int i=0; i<=128;i++){
            arbol.add(i);
        }
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
        //La suma de la rama izquierda es 0, porque cada elemento es mayor que el anterior y se acumulan todos a la derecha
        //v.¿Cuál es la altura del árbol?
        System.out.println("Altura total: "+arbol.getAltura());
        //vi.¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino?
        MiLista camino=arbol.getCamino(110);
        System.out.println("Camino: "+camino);
        System.out.println("Longitud del camino: "+camino.size());



    }
}