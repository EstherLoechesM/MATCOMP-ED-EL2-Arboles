public class MainTest2 {
    static ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
    public static void main(String[] args) {

        //i.Añadir los números de 0 a 128 aleatoriamente
        addAleatorios(128);
        //ii. Calcular la suma (getSuma())
        int sumaNormal = arbol.getSuma();
        System.out.println("la suma total es: " + sumaNormal);
        //iii. Verifica que la suma es la misma accediendo en los 3 tipos de recorridos posibles.
        int sumaCentral = arbol.sumarMiLista(arbol.getListaOrdenCentral());
        int sumaPre = arbol.sumarMiLista(arbol.getListaPreOrden());
        int sumaPost = arbol.sumarMiLista(arbol.getListaPostOrden());

        System.out.println("Suma Orden Central: " + sumaCentral);
        System.out.println("Suma PreOrden: " + sumaPre);
        System.out.println("Suma PostOrden: " + sumaPost);

        //iv. Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho
        MiLista ramaIzq = arbol.getSubArbolIzquierda();
        MiLista ramaDer = arbol.getSubArbolDerecha();
        int sumaTotal = arbol.sumarMiLista(ramaIzq) + arbol.sumarMiLista(ramaDer);

        System.out.println("Suma rama der mas izq: " + sumaTotal);
        //La suma de las dos ramas es siempre diferente a la suma total, porque no contamos la raiz
        //v.¿Cuál es la altura del árbol?
        System.out.println("Altura total: " + arbol.getAltura());
        //vi.¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino?
        MiLista camino = arbol.getCamino(110);
        System.out.println("Camino: " + camino);
        System.out.println("Longitud del camino: " + camino.size());

        }

    static void addAleatorios ( int cantidad){
        //Creamos un array de 'cantidad' posiciones
        int[] usados = new int[cantidad];
        int contador = 0;

        while (contador < cantidad) {
            //Generamos un numero entre 0 y maximo
            int numero = (int) (Math.random() * cantidad);
            //Comprobamos que los numeros no estan repetidos y si no los metemos
            if (!repetidos(usados, numero, contador)) {
                usados[contador] = numero;
                arbol.add(numero);
                contador++;

            }
        }
    }
    public static boolean repetidos(int[] arr, int num, int limite) {
        for (int i = 0; i < limite; i++) {
            if (arr[i] == num) return true;
        }
        return false;
    }

}