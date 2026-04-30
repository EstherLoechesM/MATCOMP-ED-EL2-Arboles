import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {

    @Test
    void add() {
        ArbolBinarioDeBusqueda<Integer> arbol=new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.isEmpty(), "El arbol está vacío");
        arbol.add(1);
        arbol.add(2);
        arbol.add(3);
        assertEquals(3, arbol.contarNodos(), "El número de nodos debe ser tres (1,2,3)");
    }

    @Test
    void getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<Integer> arbol=new ArbolBinarioDeBusqueda<>();
        arbol.add(3);
        arbol.add(1);
        arbol.add(2);
        arbol.add(4);
        arbol.add(5);

        MiLista<Integer> arbol1= arbol.getSubArbolIzquierda();

        assertEquals(2, arbol1.size(), "Debe haber 2 nodos en el lado izquierdo");
    }

    @Test
    void getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<Integer> arbol=new ArbolBinarioDeBusqueda<>();
        arbol.add(3);
        arbol.add(1);
        arbol.add(2);
        arbol.add(4);
        arbol.add(5);

        MiLista<Integer> arbol1= arbol.getSubArbolDerecha();

        assertEquals(2, arbol1.size(), "Debe haber 2 nodos en el lado izquierdo");
    }

    @Test
    void isArbolHomogeneo() {
        ArbolBinarioDeBusqueda<Integer> arbol=new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.isArbolHomogeneo(), "Un arbol vacío es homogeneo");
        arbol.add(3);
        arbol.add(1);
        arbol.add(2);
        arbol.add(4);
        arbol.add(5);

        assertFalse(arbol.isArbolHomogeneo(), "El arbol no es homogéneo");

        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        arbol1.add(3);
        arbol1.add(2);
        arbol1.add(4);

        assertTrue(arbol1.isArbolHomogeneo(), "El arbol es homogéneo");

    }

    @Test
    void isArbolCompleto() {
        ArbolBinarioDeBusqueda<Integer> arbol=new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.isArbolCompleto(), "Un arbol vacío es completo");
        arbol.add(3);
        arbol.add(1);
        arbol.add(2);
        arbol.add(4);
        arbol.add(5);

        assertFalse(arbol.isArbolCompleto(), "El arbol no es completo");

        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        //Rama izq
        arbol1.add(3);//Raiz
        arbol1.add(1);
        arbol1.add(2);
        arbol1.add(0);

        //Rama der
        arbol1.add(5);
        arbol1.add(4);
        arbol1.add(6);

        assertTrue(arbol1.isArbolCompleto(), "El arbol es completo");
    }

    @Test
    void isArbolCasiCompleto() {
        ArbolBinarioDeBusqueda<Integer> arbol=new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.isArbolCasiCompleto(), "Un arbol vacío es casi completo");
        arbol.add(3);
        arbol.add(1);
        arbol.add(2);
        arbol.add(4);
        arbol.add(5);

        assertFalse(arbol.isArbolCasiCompleto(), "El arbol no es casi completo");

        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        arbol1.add(4);
        arbol1.add(2);
        arbol1.add(5);
        arbol1.add(1);
        arbol1.add(3);

        assertTrue(arbol1.isArbolCasiCompleto(), "El arbol es casi completo");
    }


    @Test
    void contarNodos() {
        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol1.isEmpty(), "El árbol esta vacío");
        arbol1.add(4);
        assertEquals(1,arbol1.contarNodos(), "El arbol tiene un nodo");
        arbol1.add(2);
        assertEquals(2,arbol1.contarNodos(), "El arbol tiene dos nodos");
        arbol1.add(5);
        assertEquals(3,arbol1.contarNodos(), "El arbol tiene tres nodos");
    }

    @Test
    void compararPosiciones() {
        ArbolBinarioDeBusqueda<Integer> arbol=new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.compararPosiciones(0,0), "Si no tiene elementos que comparar es true");
        arbol.add(3);
        arbol.add(1);
        arbol.add(2);
        arbol.add(4);
        arbol.add(5);//Indice:2*2+2=6

        assertFalse(arbol.compararPosiciones(0,5), "El arbol tiene huecos a la izquierda");

        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        arbol1.add(4);
        arbol1.add(2);
        arbol1.add(5);
        arbol1.add(1);
        arbol1.add(3);

        assertTrue(arbol1.compararPosiciones(0,5), "El arbol no tiene huecos");
    }

    @Test
    void getListaDatosNivel() {
        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        arbol1.add(4);
        arbol1.add(2);
        arbol1.add(5);
        arbol1.add(1);
        arbol1.add(3);
        assertEquals(2, arbol1.getListaDatosNivel(1).getPrimero().getDato(), "El numero debería ser dos");
        assertEquals(5, arbol1.getListaDatosNivel(1).getUltimo().getDato(), "El numero debería ser cinco");
        int num1=arbol1.getListaDatosNivel(1).size();
        assertEquals(2, num1, "El tiene dos nodos en el nivel dos");


    }

    @Test
    void getCamino() {
        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        arbol1.add(4);
        arbol1.add(2);
        arbol1.add(5);
        arbol1.add(1);
        arbol1.add(3);
        arbol1.add(7);
        MiLista<Integer> camino=arbol1.getCamino(7);
        assertEquals(3, camino.size(), "El camino tiene tres elementos");
        MiLista<Integer> camino2=arbol1.getCamino(1);
        assertEquals(3, camino2.size(), "El camino tiene tres elementos");

    }

    @Test
    void getAltura() {
        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        assertEquals(0, arbol1.getAltura(), "El arbol debería tener altura 0 pues está vacío");
        arbol1.add(4);
        arbol1.add(2);
        arbol1.add(5);
        arbol1.add(1);
        arbol1.add(3);
        arbol1.add(7);
        assertEquals(3, arbol1.getAltura(), "El arbol debería tener altura 3");
    }

    @Test
    void getGrado() {
        ArbolBinarioDeBusqueda<Integer> arbol1=new ArbolBinarioDeBusqueda<>();
        assertEquals(2,arbol1.getGrado(), "El grado en un arbol binario siempre es 2");
        arbol1.add(4);
        arbol1.add(2);
        arbol1.add(5);
        assertEquals(2,arbol1.getGrado(), "El grado en un arbol binario siempre es 2");
    }

    @Test
    void getListaOrdenCentral() {
    }

    @Test
    void getListaPreOrden() {
    }

    @Test
    void getListaPostOrden() {
    }
}