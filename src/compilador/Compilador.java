/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

/**
 *
 * @author Familia
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnalizadorSintactico analizador_sintactico = new AnalizadorSintactico();
        analizador_sintactico.analizar();
//        AnalizadorLexico analizador_lexico = new AnalizadorLexico();
        
//        System.out.println(analizador_lexico.obtenerLexemas(cadena));
    }
    
}
