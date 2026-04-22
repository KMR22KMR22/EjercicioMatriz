package org.KMR22;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App 
{


    public static final int WIDTH = 10;
    public static final int HEIGTH = 10;

    public static void main(String[] args ) {

        int[][] arrayRandom = new int[WIDTH][HEIGTH];

        int[][] romanDigits = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };









    }
    //Rellenar array con numeros aleatorios
    //public void generarNumerosAleatorios() {
    //    for (int i = 0; i < WIDTH; i++) {
    //        int[] fila = arrayRandom[i];
//
    //        for (int j = 0; j < HEIGTH; j++) {
    //            fila[j] = new Random().nextInt(10);
    //        }
    //    }
    //}

    //public static void pintarMatriz(int[][] matrix){
    //    for (int i = 0; i < matrix.length; i++) {
    //        int[] fila = matrix[i];
//
    //        for (int j = 0; j < fila.length; j++) {
    //            System.out.print(String.format("%20d", fila[j]) + "");
    //        }
    //        System.out.println("");
    //        System.out.println("-".repeat(200));
    //    }
    //}

    public static void pintarMatriz(int[][] matrix){
        pMatriz(matrix,
                n -> System.out.println(String.format("%20d", n) + ""));
    }

    public static void pMatriz(int[][] matrix, Consumer<Integer> body){
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
}
