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
public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super("Coleccion vacia");
    }

    public EmptyStackException(String mensaje) {
        super(mensaje);
    }
    
    
    
    
}
