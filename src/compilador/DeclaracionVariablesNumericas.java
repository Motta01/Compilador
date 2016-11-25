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
public class DeclaracionVariablesNumericas {

    private ArrayList<String> cinta;
    private ArrayList<Integer> numero_lineas;
    private boolean estado = true;
    String info_error = "";

    public DeclaracionVariablesNumericas(ArrayList<String> cinta, ArrayList<Integer> numero_lineas) {
        this.cinta = cinta;
        this.numero_lineas = numero_lineas;
        principalDV(cinta.get(0));
    }

    public String getInfo_error() {
        return info_error;
    }

    public ArrayList<String> getCinta() {
        return cinta;
    }

    public ArrayList<Integer> getNumero_lineas() {
        return numero_lineas;
    }

    public boolean isEstado() {
        return estado;
    }

    void principalDV(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("NUMTYPE")) {
            cinta.remove(0);
            estadoDV1(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error 4004(DEclaracion invalida)-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV1(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDV2(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DV1-line:  " + numero_lineas.get(0));
        }

    }

    void estadoDV2(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDV7(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoDV3(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoDV10(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error al declarar la variable DV2-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV7(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDV8(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error se sistaxis DV7-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV8(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDV7(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error de sintaxis DV8-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV3(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VALORNUM") || lexema.equals("FUNCION") || lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error al declarar la variable DV3-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV6(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else if (lexema.equals("ARITMETICO") || lexema.equals("MAS")) {
            cinta.remove(0);
            estadoDV3(cinta.remove(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DV6-line:  " + numero_lineas.get(0));
        }

    }

    void estadoDV4(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDV5(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error de sintaxis DV4-line:  " + numero_lineas.get(0));
        }

    }

    void estadoDV5(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDV4(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("KEY2")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DV5-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV9() {
        /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Declaracion de Variables(DV).
     
         */
        System.out.println("Declaracion exitosa");

    }

    void estadoDV10(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV12(cinta.get(0));
        } else if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDV11(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de DV10-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV11(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV12(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Eror de sitaxis DV11-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV12(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoDV13(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoDV15(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Eror de sitaxis DV12-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV13(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDV14(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DV13-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV14(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DV14-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV15(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("KEY1")) {
            cinta.remove(0);
            estadoDV4(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DV15-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDV16(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DV16-line:  " + numero_lineas.get(0));
        }
    }
}
