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
public class AsignacionVariablesNum {

    private ArrayList<String> cinta;
    private boolean estado = true;

    public AsignacionVariablesNum(ArrayList<String> cinta) {
        this.cinta = cinta;
        estadoAV1(this.cinta.get(0));
    }

    void estadoAV1(String lexema) {
        if (lexema.equals("CAMPTEXT")) {
            cinta.remove(0);
            estadoAV2(cinta.get(0));
        } else {
            System.err.println("error de sitaxis AV1");
        }

    }

    void estadoAV2(String lexema) {
        if (lexema.equals("SAME")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoAV9(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV2");
        }
    }

    void estadoAV3(String lexema) {
        if (lexema.equals("CAMPTEXT")) {
            cinta.remove(0);
            estadoAV4(cinta.get(0));
        } else {
            System.err.println("error de sitaxis AV3");
        }
    }

    void estadoAV4(String lexema) {

        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoAV8();
        } else if (lexema.equalsIgnoreCase("PAR1")) {
            cinta.remove(0);
            estadoAV6(cinta.get(0));
        } else if (lexema.equals("ARITMETICO")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        } else {
            System.err.println("error de sitaxis AV4");
        }

    }

    void estadoAV6(String lexema) {
        if (lexema.equalsIgnoreCase("par2")) {
            cinta.remove(0);
            estadoAV7(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV6");
        }
    }

    void estadoAV7(String lexema) {

        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoAV8();
        } else if (lexema.equals("ARITMETICO")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV7");
        }
    }

    void estadoAV8() {
        /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Asignacion de Valores(AV).        
         */

        System.out.println("Asignacion Exitosa");
    }

    void estadoAV9(String lexema) {

        if (lexema.equals("CAMPTEXT")) {
            cinta.remove(0);
            estadoAV10(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV9");
        }
    }

    void estadoAV10(String lexema) {

        if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoAV11(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV10");
        }
    }

    void estadoAV11(String lexema) {

        if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR")) {
            cinta.remove(0);
            estadoAV12(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV11");
        }
    }

    void estadoAV12(String lexema) {

        if (lexema.equals("CAMPTEXT")) {
            cinta.remove(0);
            estadoAV13(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV12");
        }
    }

    void estadoAV13(String lexema) {

        if (lexema.equalsIgnoreCase("cor2")) {
            cinta.remove(0);
            estadoAV14(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV13");
        }
    }

    void estadoAV14(String lexema) {

        if (lexema.equalsIgnoreCase("SAME")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        } else {
            System.err.println("erorr de sintaxis AV7");
        }
    }
}
