/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;

/**
 *
 * @author segundo
 */
public class DeclaracionVariablesChar {

    private ArrayList<String> cinta;
    private ArrayList<Integer> numero_lineas;
    private boolean estado = true;
    String info_error = "";

    public DeclaracionVariablesChar(ArrayList<String> cinta, ArrayList<Integer> numero_lineas) {
        this.cinta = cinta;
        this.numero_lineas = numero_lineas;
        principalDVC(this.cinta.get(0));
    }

    public ArrayList<String> getCinta() {
        return cinta;
    }

    public String getInfo_error() {
        return info_error;
    }

    public ArrayList<Integer> getNumero_lineas() {
        return numero_lineas;
    }

    public boolean isEstado() {
        return estado;
    }

    void principalDVC(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("CHAR")) {
            cinta.remove(0);
            estadoDVC1(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error 4004C(Declaracion invalida)-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC1(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDVC2(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DVC1-line:  " + numero_lineas.get(0));
        }

    }

    void estadoDVC2(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            estadoDVC9();
        } else if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoDVC3(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDVC7(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoDVC10(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error al declarar la variable DVC2-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC3(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("FUNCION") || lexema.equals("CHARACT")) {

            cinta.remove(0);
            estadoDVC6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis faltan comillas DVC3-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC6(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDVC9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DVC6-line:  " + numero_lineas.get(0));
        }

    }

    void estadoDVC7(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDVC8(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error se sistaxis DV7-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC8(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDVC7(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDVC9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error de sintaxis DVC8-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC4(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("FUNCION") || lexema.equals("CHARACT")) {
            cinta.remove(0);
            estadoDVC5(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis faltan comillas DVC4-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC5(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDVC4(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("KEY2")) {
            cinta.remove(0);
            estadoDVC6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DVC5-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC9() {
        /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Declaracion de Variables(DV).
     
         */
        System.out.println("Declaracion exitosa");

    }

    void estadoDVC10(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVC12(cinta.get(0));
        } else if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDVC11(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de DVC10 -line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC11(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVC12(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Eror de sitaxis DVC11-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC12(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoDVC13(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoDVC15(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDVC9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Eror de sitaxis DVC12-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC13(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDVC14(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVC6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVC13-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC14(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVC6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVC14-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC15(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("KEY1")) {
            cinta.remove(0);
            estadoDVC4(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVC15-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVC16(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            estadoDVC9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVC16-line:  " + numero_lineas.get(0));
        }
    }

}
