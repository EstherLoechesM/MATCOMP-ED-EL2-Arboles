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
    }

    @Test
    void getSubArbolDerecha() {
    }

    @Test
    void isArbolHomogeneo() {
    }

    @Test
    void isArbolCompleto() {
    }

    @Test
    void isArbolCasiCompleto() {
    }

    @Test
    void contarNodos() {
    }

    @Test
    void compararPosiciones() {
    }

    @Test
    void getListaDatosNivel() {
    }

    @Test
    void getCamino() {
    }

    @Test
    void getAltura() {
    }

    @Test
    void getGrado() {
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