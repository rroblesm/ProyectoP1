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
public class mainDePruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//1. Validar que sea una expresion correcta

//Control con botones de calculadora
//checar operandos seguidos
//checar balanceo de parentesis
//negativo



//2. Convertir en notacion postfija
        TraductorInfijo nuevaExpresion = new TraductorInfijo("10.2*(m8-6)/3+112.5");
        nuevaExpresion.infijoAPostfijo();
        
        
        System.out.println("");
        System.out.println(nuevaExpresion.getCadenaPostfija());
        
        
        
//3. Hacer operacion en notacion postfija y mostrarlo en la calculadora





        
    }
    
}
