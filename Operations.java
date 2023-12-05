import java.util.Arrays;

public class Operations {

    public Operations(){
    }

    public double[] sums (double[] vector1, double[] vector2){

        if(vector1.length != vector2.length)
            throw new IllegalStateException("Los vectores no coinciden");

        double result [] = new double[vector1.length];

        for (int x = 0; x < result.length; x++){
            result[x] = vector1[x] + vector2[x];
        }

        return result;
    }

    public double[] rests (double[] vector1, double[] vector2){

        if(vector1.length != vector2.length)
            throw new IllegalStateException("Los vectores no coinciden");

        double result [] = new double[vector1.length];

        for (int x = 0; x < result.length; x++){
            result[x] = vector1[x] - vector2[x];
        }
        return result;
    }

    public double[] multi (double multiplier, double[] vector) {
        for (int x = 0; x < vector.length; x++) {
            vector[x] *= multiplier;
        }
        return vector;
    }

    public double [] calculateMagnitude (double [] vector){

        double sumSquare = 0.0;

        for (int x = 0; x < vector.length; x++){
            sumSquare += vector[x] * vector[x];
        }

        double magnitude = Math.sqrt (sumSquare);
        double[] result = {magnitude};


        return result;
    }

    public double[] multiVectors (double[] vector1, double[] vector2) {

        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Opearacion invalida ");
        }

        double[] result = new double[vector1.length];

        for (int i = 0; i < vector1.length; i++) {
            result[i] = vector1[i] * vector2[i];
        }
        return result;
    }

    public static double[] crossProduct (double[] vector1, double[] vector2) {

        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Los vectores deben tener la misma longitud");
        }

        double [] result = new double [1];

        for (int i = 0; i < vector1.length; i++) {
            result[0] += vector1[i] * vector2[i];
        }

        System.out.println("");
        System.out.println("El producto punto es: ");
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        return result;
    }


    public static double[] productoEscalar(double[] a, double[] b) {
        if (a.length != b.length) {
            System.out.println("Los vectores deben tener la misma longitud para el producto escalar.");
            System.exit(1);
        }

        double[] resultado = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            resultado[i] = a[i] * b[i];
        }
        return resultado;
    }
}
