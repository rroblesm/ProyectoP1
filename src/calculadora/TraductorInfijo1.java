/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author R
 */
public class TraductorInfijo1 {

    //
    //
    private static int Prescedencia(char ch) {
        int prescedencia = -1;

        switch (ch) {
            case '+':
            case '-':
                prescedencia = 1;
                break;
            case '*':
            case '/':
                prescedencia = 2;
                break;

            case '^':
                prescedencia = 3;
                break;
        }
        return prescedencia;
    }

    // The main method that converts  
    // given infix expression 
    // to postfix expression.  
    public static String infixToPostfix(String infija) {
        // initializing empty String for result 
        String expresionPostfija = "";
        char aux;
        // initializing empty stack 
        PilaA<Character> pila = new PilaA<>();

        for (int i = 0; i < infija.length(); ++i) {
            aux = infija.charAt(i);

            // If the scanned character is an 
            // operand, add it to output.             
            if (Character.isDigit(aux)) {
                expresionPostfija += aux;
            } // If the scanned character is an '(',  
            // push it to the stack. 
            else if (aux == '(') {
                pila.push(aux);
            } //  If the scanned character is an ')',  
            // pop and output from the stack  
            // until an '(' is encountered. 
            else if (aux == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    expresionPostfija += pila.pop();
                }

                pila.pop();
            } else // an operator is encountered 
            {
                while (!pila.isEmpty() && Prescedencia(aux)
                        <= Prescedencia(pila.peek())) {

                    expresionPostfija += pila.pop();
                }//while del operador
                pila.push(aux);
            }//else

        }//for

        
        // pop all the operators from the stack 
        while (!pila.isEmpty()) {
            if (pila.peek() == '(') {
                return "Invalid Expression";
            }
            expresionPostfija += pila.pop();
        }
        return expresionPostfija;
    }

}//clase
