import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaEnterosTest {

    @Test
    void getSuma() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        // Caso árbol vacío
        assertEquals(0, arbol.getSuma(), "La suma de un árbol vacío debe ser 0");

        // Caso con datos
        arbol.add(4);
        arbol.add(2);
        arbol.add(6);

        assertEquals(12, arbol.getSuma(), "La suma de 4, 2 y 6 debería ser 12");
    }

    @Test
    void add() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();

        assertTrue(arbol.isEmpty(), "El árbol debería estar vacío al inicio");
        arbol.add(10);
        arbol.add(5);
        arbol.add(15);

        assertEquals(3, arbol.getSize(), "El árbol debería tener 3 nodos");
    }


}