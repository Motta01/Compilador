/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;

/**
 *
 * @author El Gran Combo
 */
public class AnalizadorLexico {

    ArrayList<String> lexemas = new ArrayList<>();

    private ArrayList<Character> delimitadores;

    public AnalizadorLexico() {
        delimitadores = new ArrayList<>();
        this.delimitadores.add(' ');
        this.delimitadores.add('{');
        this.delimitadores.add('}');
        this.delimitadores.add('(');
        this.delimitadores.add(')');
        this.delimitadores.add('=');
        this.delimitadores.add('<');
        this.delimitadores.add('>');
        this.delimitadores.add('&');
        this.delimitadores.add(';');
        this.delimitadores.add('|');
        this.delimitadores.add('%');
        this.delimitadores.add('/');
        this.delimitadores.add('*');
        this.delimitadores.add('-');
        this.delimitadores.add('[');
        this.delimitadores.add(']');
        this.delimitadores.add('\n');
    }

    public boolean obtenerLexemas(String cadena) {
        boolean aprobado = false;
        char caracter;
        boolean validado = false;
        StringBuffer palabra = new StringBuffer();
        String lexema = "";

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.charAt(i);
            validado = delimitadores.contains(caracter);
                        
            if (validado) {
                lexema = palabra.toString();
                this.lexemas.add(lexema);

                palabra = new StringBuffer();

                if (caracter != ' ') {
                    System.out.println(i);
                    palabra.append(caracter);
                    lexema = palabra.toString();
                    this.lexemas.add(lexema);
                } 

                palabra = new StringBuffer();
                
            } else {
                palabra.append(caracter);
            }
        }
        
        System.out.println(this.lexemas.toString());

        return aprobado;
    }
}
