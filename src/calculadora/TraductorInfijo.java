/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;

/**
 *
 * @author R
 */
public class TraductorInfijo {

    private PilaA<Character> pila; //Pila para trabajar
    private ArrayList<String> postfija; // Para guardar la expresion PostFija
    private String infija;
    private String auxiliar;

    public TraductorInfijo() {
        pila = new PilaA();
        postfija = new ArrayList<String>();
        auxiliar = "";
    }

    public TraductorInfijo(String infija) {
        this();
        this.infija = infija;
    }

    public void setInfija(String infija) {
        this.infija = infija;
    }

    public void infijoAPostfijo() {
        /* Si es un numero, lo mete al ArrayList "postfija"
        sino, es un operador, y se mete a la pila
         */

        for (int i = 0; i < infija.length(); i++) {
            if (Character.isDigit(infija.charAt(i)) || infija.charAt(i) == '.' || infija.charAt(i) == 'm') {
                /* Si encontramos un digito, un punto, o el signo de un numero negativo (representado por m) lee todos los digitos al lado y los agrega a la cadena auxiliar
                hasta que encuentra un operador
                 */
                auxiliar += infija.charAt(i);

                while ((i + 1) < infija.length() && (Character.isDigit(infija.charAt(i + 1)) || infija.charAt(i + 1) == '.') ) {
                    i++;
                    auxiliar += infija.charAt(i);
                }


                /* Si acaba el while, es que:
                1. Encontro un operador
                2. Se acabo la cadena
                Asi que metemos el auxiliar en el arrayList "postfija" y borramos el auxiliar para el siguiente uso
                 */
                postfija.add(auxiliar);
                auxiliar = "";
            } else {
                checarOperador(i);
            }

        }
        
        while (!pila.isEmpty()) {
            postfija.add(pila.pop().toString());
        }

    }//fin del metodo traductor infijo

    private void checarOperador(int i) {
        char operador = infija.charAt(i);

        if (pila.isEmpty() || operador == '(') {
            pila.push(operador);
        } else {
            if (operador == ')') {
                while (!pila.peek().equals('(')) {
                    postfija.add(pila.pop().toString());
                }
                pila.pop();
            } else {
                if (pila.peek().equals('(') ) {
                    pila.push(operador);
                } else {
                    while (!pila.isEmpty() && !pila.peek().equals('(') && getJerarquia(operador) <= getJerarquia(pila.peek())) {
                        postfija.add(pila.pop().toString());
                    }
                    pila.push(operador);
                }
            }
        }//fin de 1er else
    }//checarOperador

    private int getJerarquia(char operador) {
        int jerarquia = 0;

        switch (operador) {
            case '+':
                jerarquia = 1;
                break;
            case '-':
                jerarquia = 1;
                break;
            case '/':
                jerarquia = 2;
                break;
            case '*':
                jerarquia = 2;
                break;
            case '^':
                jerarquia = 3;
                break;
        }//switch
        return jerarquia;

    }

    public ArrayList<String> getPostfija() {
        return postfija;
    }

    public String getCadenaPostfija() {
        String cad = "";
        for (int i = 0; i < postfija.size(); i++) {
            cad += (postfija.get(i) + " ");
        }
        return cad;
    }


}
