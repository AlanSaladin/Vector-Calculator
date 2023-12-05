import java.util.Stack;

public class calculateExpretion {

    static Operations operation = new Operations();
    static Vectors vect = new Vectors();

    public static double[] evaluator(String expresion) {
        Stack<Character> operadores = new Stack<>();
        Stack<double[]> operandos = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    realizarOperacionVectorial(operandos, operadores);
                }
                operadores.pop();
            } else if (Character.isLetter(c)) {
                StringBuilder nombreVector = new StringBuilder();
                while (i < expresion.length() && (Character.isLetter(c) || c == ' ')) {
                    nombreVector.append(c);
                    i++;
                    if (i < expresion.length()) {
                        c = expresion.charAt(i);
                    }
                }
                String nombre = nombreVector.toString().trim();
                if (nombre.isEmpty()) {
                    continue;
                }
                double[] vector = getVector(nombre);
                operandos.push(vector);
                i--;
            } else if (esOperador(c)) {
                while (!operadores.isEmpty() && prioridad(operadores.peek()) >= prioridad(c)) {
                    realizarOperacionVectorial(operandos, operadores);
                }
                operadores.push(c);
            } else if (esNumero(c)){
                double valor =  (double) Character.digit(c, 10);
                operandos.push(new double[]{valor, valor});
            }
        }
        while (!operadores.isEmpty()) {
            realizarOperacionVectorial(operandos, operadores);
        }

        return operandos.pop();
    }

    public static double[] getVector(String nombre) {

        if (nombre.equals("A")) {
            return vect.vectorA;
        } else if (nombre.equals("B")) {
            return vect.vectorB;
        } else if (nombre.equals("C")) {
            return vect.vectorC;
        } else if (nombre.equals("U")) {
            return vect.vectorU;
        } else if (nombre.equals("V")) {
            return vect.vectorV;
        } else if (nombre.equals("W")) {
            return vect.vectorW;

        }
        else {
            throw new IllegalArgumentException("Vector no encontrado: " + nombre);
        }
    }

    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '|';
    }

    public static boolean esNumero(char c){
        return  c == '1' || c == '2' || c == '3' || c == '4' || c == '5' ||  c == '6' || c == '7' || c == '8' || c == '9' || c == '0';
    }

    public static int prioridad(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        }
        if (operador == '*' || operador == '/') {
            return 2;
        }
        if (operador == '|'){
            return 3;
        }
        return 0;
    }

    public static void realizarOperacionVectorial(Stack<double[]> operandos, Stack<Character> operadores) {
        char operador = operadores.pop();
        double[] operand2 = operandos.pop();

        if (operador == '|') {
            operandos.push(operation.calculateMagnitude(operand2));
            return;
        }

        double[] operand1 = operandos.pop();

        if (operador == '+') {
            operandos.push(operation.sums(operand1, operand2));
        }
        if (operador == '-') {
            operandos.push(operation.rests(operand1, operand2));
        }
        if (operador == '*') {
            operandos.push(operation.multiVectors(operand1, operand2));
        }
        if (operador == 'x') {
            operandos.push(operation.crossProduct(operand1, operand2));
        }
    }
}



