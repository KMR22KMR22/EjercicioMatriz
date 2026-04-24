package org.KMR22;

import java.util.Random;

public class EjerciciosPedro {
    public static final int W = 20;
    public static final int H = 20;

    public static final double CAP_RANDOM = 20;
    public static final double DESVIACION = 20;

    public static double calcularMediaVecinos(Double[][] matriz, int i, int j){
        int suma = 0;
        int countador = 0;

        for (int x = -1; x < 1; x++){
            for (int y = -1; y < 1; y++){
                //Precondicion
                if (i + x < 0 || i + x > matriz.length || j + y < 0 || j + y > matriz[0].length)continue;

                if (matriz[i][j] == null)continue;

                //Cuerpo
                suma += matriz[i][j];
                countador++;
            }
        }

        if (countador == 0){
            return new Random().nextDouble(CAP_RANDOM);
        }

        return suma / countador;
    }


    public static void main(String[] args) {

        var matriz = new Double[W][H];

        for (int i = 0; i < W; i++){
            for (int j = 0; j < H; j++){
                var media = calcularMediaVecinos(matriz, i, j);

                matriz[i][j] = new Random().nextDouble(media - DESVIACION, media + DESVIACION);
            }
        }

        for (int i = 0; i < W; i++){
            for (int j = 0; j < H; j++){
                System.out.printf("%-20.2f");
            }
        }
    }
}
