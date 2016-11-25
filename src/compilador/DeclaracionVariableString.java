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
public class DeclaracionVariableString {

    private ArrayList<String> cinta;
    private ArrayList<Integer> numero_lineas;
    private boolean estado = true;
    String info_error = "";

    public DeclaracionVariableString(ArrayList<String> cinta, ArrayList<Integer> numero_lineas) {
        this.cinta = cinta;
        this.numero_lineas = numero_lineas;
        principalDVS(cinta.get(0));
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

    void principalDVS(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("STRING")) {

            cinta.remove(0);
            estadoDVS1(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error 4004(Declaracion invalida) linea: " + numero_lineas.get(0));
        }
    }

    void estadoDVS1(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDVS2(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DVS1. line:  " + numero_lineas.get(0));
        }

    }

    void estadoDVS2(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            estadoDVS9();
        } else if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoDVS3(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDVS7(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoDVS10(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error al declarar la variable DVS2. linea: " + numero_lineas.get(0));

        }
    }

    void estadoDVS3(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VALORTEXTO") || lexema.equals("FUNCION") || lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDVS6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis faltan comillas DVS3 -line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS6(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDVS9();
        } else if (lexema.equals("MAS")) {//aqui solo es +
            cinta.remove(0);
            estadoDVS3(cinta.remove(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DVS6 -line:  " + numero_lineas.get(0));
        }

    }

    void estadoDVS7(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDVS8(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error se sistaxis DVS7 -line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS8(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDVS7(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDVS9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error de sintaxis DVS8 -line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS4(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE") || lexema.equals("FUNCION") || lexema.equals("VALORTEXTO")) {
            cinta.remove(0);
            estadoDVS5(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis faltan comillas DVS4 -line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS5(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDVS4(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("KEY2")) {
            cinta.remove(0);
            estadoDVS6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sintaxis DVS5-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS9() {
        /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Declaracion de Variables(DV).
     
         */

        System.out.println("Declaracion exitosa");

    }

    void estadoDVS10(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVS12(cinta.get(0));
        } else if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDVS11(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de DVS10-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS11(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVS12(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Eror de sitaxis DVS11-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS12(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoDVS13(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoDVS15(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDVS9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Eror de sitaxis DVS12-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS13(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDVS14(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVS6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVS13-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS14(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDVS6(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVS14-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS15(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("KEY1")) {
            cinta.remove(0);
            estadoDVS4(cinta.get(0));
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVS15-line:  " + numero_lineas.get(0));
        }
    }

    void estadoDVS16(String lexema) {
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {

            cinta.remove(0);
            estadoDVS9();
        } else {
            estado = false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("Error de sitaxis DVS16-line:  " + numero_lineas.get(0));
        }
    }
}
