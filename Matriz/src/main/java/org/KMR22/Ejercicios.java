package org.KMR22;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Ejercicios {
    public static final int ALPHA = 4;
    public static final int WIDTH = 10;
    public static final int HEIGTH = 10;


    public static void main(String[] args) {

        int[][] arrayRandom = new int[WIDTH][HEIGTH];


    }

    //Rellenar array con numeros aleatorios
    public void generarNumerosAleatorios(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];

        int rangoSuperior;
        int rangoInferior;

        int valor = 0;

        for (int i = 0; i < WIDTH; i++) {
            int[] fila = array[i];

            for (int j = 0; j < HEIGTH; j++) {
                //Calculo la media de los vecinos para tener el numero que va a variar con el alpha
                valor = calcularMedia(newArray, i, j);
                rangoSuperior = valor + ALPHA;
                rangoInferior = valor - ALPHA;
                //Coloco un numero aleatorio en esa posicion teniendo en cuenta la variacion alpha
                fila[j] = new Random().nextInt(rangoSuperior - rangoInferior + 1);

            }
        }
    }

    public static void pintarMatriz(int[][] matrix) {
        pMatriz(matrix,
                n -> System.out.println(String.format("%20d", n) + ""));
    }

    public static void pMatriz(int[][] matrix, Consumer<Integer> body) {
        for (int i = 0; i < matrix.length; i++) {
            int[] fila = matrix[i];

            for (int j = 0; j < fila.length; j++) {
                int casilla = fila[j];
                body.accept(casilla);
            }
            System.out.println("");
            System.out.println("-".repeat(200));
        }
    }


    public int calcularMedia(int[][] matriz, int i, int j) {
        int bordeIzquierdo = 0;
        int bordeDerecho = matriz[0].length - 1;
        int bordeSuperior = 0;
        int bordeInferior = matriz.length - 1;


        List<Integer> lista = new ArrayList<>();
        int avg = 0;


        //Arriba Izquierda
        if (i == bordeIzquierdo && j == 0) {
            //Es el primero
        }

        //Arriba centro
        else if (i == bordeSuperior && j > 0 && j < bordeDerecho) {
            //Izquierda
            lista.add(matriz[i][j - 1]);

        }


        //Arriba Derecha
        else if (i == bordeSuperior && j == bordeDerecho) {
            //Izquierda
            lista.add(matriz[i][j - 1]);
        }

        //Centro Izquierda
        else if (i > bordeSuperior && i < bordeInferior && j == bordeIzquierdo) {
            //Arriba
            lista.add(matriz[i - 1][j]);
            //Arriba derecha
            lista.add(matriz[i - 1][j + 1]);
        }


        //Centro Derecha
        else if (i > bordeSuperior && i < bordeInferior && j == bordeDerecho) {
            //Arriba izquierda
            lista.add(matriz[i - 1][j - 1]);
            //Arriba
            lista.add(matriz[i - 1][j]);
            //Izquierda
            lista.add(matriz[i][j - 1]);
        }


        //Abajo Izquierda
        else if (i == bordeInferior && j == bordeIzquierdo) {
            //Arriba
            lista.add(matriz[i - 1][j]);
            //Arriba derecha
            lista.add(matriz[i - 1][j + 1]);
        }


        //Este sirve para cuadno quede en el centro o en el centro abajo o derecha abajo
        else {
            //Arriba izquierda
            lista.add(matriz[i - 1][j - 1]);
            //Arriba
            lista.add(matriz[i - 1][j]);
            //Arriba derecha
            lista.add(matriz[i - 1][j + 1]);
            //Izquierda
            lista.add(matriz[i][j - 1]);
        }

        for (int x = 0; x < lista.size(); x++) {
            avg = avg + lista.get(x);
        }
        avg = avg / lista.size();

        return avg;

    }

}
