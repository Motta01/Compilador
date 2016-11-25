/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;

/**
 *
 * @author Familia
 */
public class ValidadorParametosLlamada {

    ArrayList<String> cinta;
    ArrayList<Integer> numero_lineas;
    boolean error = false;

    public ValidadorParametosLlamada(ArrayList<String> cinta, ArrayList<Integer> numero_lineas) {
        this.cinta = cinta;
        this.numero_lineas = numero_lineas;
    }

    public ArrayList<String> getCinta() {
        return cinta;
    }

    public ArrayList<Integer> getNumero_lineas() {
        return numero_lineas;
    }

    public boolean getError() {
        return error;
    }

    public void analizar() {
        parametroPar(cinta.get(0));
    }

    public void parametroPar(String lexema) {
        System.out.println("parametroPar");
        numero_lineas.remove(0);
        if (lexema.equals("PAR1")) {
            cinta.remove(0);
            try {
                parametro1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Valor esperado: boolean");
                System.out.println("parametroPar");
            }
        } else {
            error = true;
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Token esperado: '('");
            System.out.println("parametroPar");
        }
    }

    public void parametro1(String lexema) {
        System.out.println("parametro1");
        numero_lineas.remove(0);
        if (lexema.equals("VALORBOOL") || lexema.equals("VALORNUM") || lexema.equals("CHARACT") || lexema.equals("VALORTEXTO")) {
            cinta.remove(0);
            try {
                parametro2(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: '}'");
                System.out.println("parametroPar");
            }
        } else if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            try {
                //parametro1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: '}'");
                System.out.println("parametroPar");
            }
        } else if (lexema.equals("NEGADOR")) {
            cinta.remove(0);
            try {
                //parametro1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Valor esperado: boolean");
                System.out.println("parametroPar");
            }
        } else if (lexema.equals("PAR2")) {
            cinta.remove(0);
            try {
                parametro3(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ';'");
                System.out.println("parametroPar");
            }
        } else {
            error = true;
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Token esperado: ')'");
            System.out.println("parametroPar");
        }
    }
    
    public void parametro2(String lexema) {
        System.out.println("parametro2");
        numero_lineas.remove(0);
        if (lexema.equals("OPLOGICO") || lexema.equals("COMA") || lexema.equals("MAS") || lexema.equals("AND") || lexema.equals("EQUALS")) {
            cinta.remove(0);
            try {
                parametro1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Valor esperado despues de " + lexema);
                System.out.println("parametro1");
            }
        } else if (lexema.equals("PAR2")) {
            cinta.remove(0);
            try {
                parametro3(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ';'");
                System.out.println("parametro3");
            }
        } else {
            error = true;
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Token esperado: ')'");
            System.out.println("parametro2");
        }
    }
    
    public void parametro3(String lexema) {
        System.out.println("parametro3");
        numero_lineas.remove(0);
        if (lexema.equals("PAR2")) {
            cinta.remove(0);
            try {
                System.out.println("Parametros Bien");
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: '}'");
                System.out.println("parametroPar");
            }
        } else if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            try {
                //parametro1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: '}'");
                System.out.println("parametroPar");
            }
        } else {
            error = true;
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Token esperado: '('");
            System.out.println("parametroPar");
        }
    }
}
