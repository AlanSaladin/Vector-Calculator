public class Main {

    public static void main(String[] args) {

        String expretion = "|2*(A+B)|";

        double[] resultado = calculateExpretion.evaluator(expretion);
        System.out.print("El resultado es: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        /*
        vectorSumatory = sumatory.sums (vectorA,vectorB);
        vectorSubstraction = substraction.rests (vectorA,vectorB);
        vectorMultiplication = multiplication.multi (7,vectorSumatory);
        vectorSubstracion2 = substraction2.rests (vectorMultiplication,vectorC);
        vectorMultiplicationA = multiplication.multi (4,vectorA);
        vectorMultiplicationB = multiplication.multi (5,vectorB);
        vectorSumatory2 = sumatory.sums (vectorMultiplicationA,vectorMultiplicationB);
        vectorSubstracion2 = sumatory.rests (vectorSumatory2,vectorC);
        vectorMagnitude = magnitude.calculateMagnitude (vectorSubstracion2);
        vectorMultiplicationU = multiplication.multi (4,vectorU);
        vectorMultiplicationV = multiplication.multi (2,vectorV);
        vectorMultiplicationUV = multiplication.multiVectors (vectorMultiplicationU,vectorMultiplicationV);
        vectorMultiplicationUVC = multiplication.multiVectors(vectorMultiplicationUV,vectorC2);
        vectorCrossProductW = crossProduct.crossProduct(vectorMultiplicationUVC,vectorW);
        */

    }

}
