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
    private boolean estado = true;

    public DeclaracionVariablesNumericas(ArrayList<String> cinta) {
        this.cinta = cinta;
        principalDV(cinta.get(0));
    }

    public ArrayList<String> getCinta() {
        return cinta;
    }

    public boolean isEstado() {
        return estado;
    }

    void principalDV(String lexema) {
        if (lexema.equals("NUMTYPE")) {
            cinta.remove(0);
            estadoDV1(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error 4004");
        }
    }

    void estadoDV1(String lexema) {
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDV2(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error de sintaxis DV1");
        }

    }

    void estadoDV2(String lexema) {

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
            System.err.println("Error al declarar la variable DV2");
        }
    }

    void estadoDV7(String lexema) {
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDV8(cinta.get(0));
        } else {
            estado = false;
            System.err.println("error se sistaxis DV7");
        }
    }

    void estadoDV8(String lexema) {

        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDV7(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else {
            estado = false;
            System.err.println("error de sintaxis DV8");
        }
    }

    void estadoDV3(String lexema) {

        if (lexema.equals("VALORNUM") || lexema.equals("FUNCION") || lexema.equals("VARIABLE")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error al declarar la variable DV3");
        }
    }

    void estadoDV6(String lexema) {
        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else if (lexema.equals("ARITMETICO")||lexema.equals("MAS")) {
            cinta.remove(0);
            estadoDV3(cinta.remove(0));
        } else {
            estado = false;
            System.err.println("Error de sintaxis DV6");
        }

    }

    void estadoDV4(String lexema) {

        if (lexema.equals("VALORMUN") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDV5(cinta.get(0));
        } else {
            estado = false;
            System.err.println("error de sintaxis DV4");
        }

    }

    void estadoDV5(String lexema) {

        if (lexema.equalsIgnoreCase("COMA")) {
            cinta.remove(0);
            estadoDV4(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("KEY2")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error de sintaxis DV5");
        }
    }

    void estadoDV9() {
        /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Declaracion de Variables(DV).
     
         */
        System.out.println("Declaracion exitosa");

    }

    void estadoDV10(String lexema) {
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV12(cinta.get(0));
        } else if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDV11(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error de DV10 ");
        }
    }

    void estadoDV11(String lexema) {
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV12(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Eror de sitaxis DV11");
        }
    }

    void estadoDV12(String lexema) {
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
            System.err.println("Eror de sitaxis DV12");
        }
    }

    void estadoDV13(String lexema) {
        if (lexema.equals("VALORNUM") || lexema.equals("VARIABLE") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            estadoDV14(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error de sitaxis DV13");
        }
    }

    void estadoDV14(String lexema) {
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoDV6(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error de sitaxis DV14");
        }
    }

    void estadoDV15(String lexema) {
        if (lexema.equalsIgnoreCase("KEY1")) {
            cinta.remove(0);
            estadoDV4(cinta.get(0));
        } else {
            estado = false;
            System.err.println("Error de sitaxis DV15");
        }
    }

    void estadoDV16(String lexema) {
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            estadoDV9();
        } else {
            estado = false;
            System.err.println("Error de sitaxis DV16");
        }
    }
}
