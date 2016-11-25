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
public class AsignacionVariables {

    private ArrayList<String> cinta;
    private ArrayList<Integer> numero_lineas;
    private boolean estado = true;
    String info_error = "";

    public AsignacionVariables(ArrayList<String> cinta, ArrayList<Integer> numero_lineas) {
        this.cinta = cinta;
        this.numero_lineas = numero_lineas;
        estadoAV2(this.cinta.get(0));
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
    

    void estadoAV2(String lexema) {numero_lineas.remove(0);
        if (lexema.equals("SAME")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        } else if (lexema.equalsIgnoreCase("COR1")) {
            cinta.remove(0);
            estadoAV4(cinta.get(0));
        } else {
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("erorr de sintaxis AV2-line:  "+ numero_lineas.get(0));
        }
    }

    void estadoAV3(String lexema) {numero_lineas.remove(0);
        if (lexema.equals("VALORNUM")||lexema.equals("VALORBOOL")||lexema.equals("VALORTEXTO")) {
            cinta.remove(0);
            estadoAV6(cinta.get(0));
        } else if (lexema.equals("VARIABLE")){
            cinta.remove(0);
            estadoAV7(cinta.get(0));
        }else{
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error de sitaxis AV3-line:  "+ numero_lineas.get(0));
        }
    }

    void estadoAV4(String lexema) {numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("VARIABLE")||lexema.equalsIgnoreCase("VALORNUM")) {
            cinta.remove(0);
            estadoAV5(cinta.get(0));
        } else {
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("error de sitaxis AV4-line:  "+ numero_lineas.get(0));
        }

    }
     void estadoAV5(String lexema) {numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("COR2")) {
            cinta.remove(0);
            estadoAV2(cinta.get(0));
        } else {
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("erorr de sintaxis AV5-line:  "+ numero_lineas.get(0));
        }
    }

    void estadoAV6(String lexema) {numero_lineas.remove(0);
        if (lexema.equals("ARITMETICO")||lexema.equals("MAS")||lexema.equals("OR")
                ||lexema.equals("AND")||lexema.equals("OPLOGICO")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        } else if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            estadoAV8();
        }else {
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("erorr de sintaxis AV6-line:  "+ numero_lineas.get(0));
        }
    }

    void estadoAV7(String lexema) {numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoAV8();
        } else if (lexema.equals("COR1")) {
            cinta.remove(0);
            estadoAV11(cinta.get(0));
        } else {
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("erorr de sintaxis AV7-line:  "+ numero_lineas.get(0));
        }
    }

    void estadoAV8() {
        /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Asignacion de Valores(AV).        
         */

        System.out.println("Asignacion Exitosa");
    }

    void estadoAV9(String lexema) {numero_lineas.remove(0);

        if (lexema.equals("COR2")) {
            cinta.remove(0);
            estadoAV10(cinta.get(0));
        } else {
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("erorr de sintaxis AV9-line:  "+ numero_lineas.get(0));
        }
    }

    void estadoAV10(String lexema) {numero_lineas.remove(0);

        if (lexema.equalsIgnoreCase("ENDLINE")) {
            cinta.remove(0);
            estadoAV8();
        } else if (lexema.equals("ARITMETICO")||lexema.equals("MAS")||lexema.equals("OR")
                ||lexema.equals("AND")||lexema.equals("OPLOGICO")) {
            cinta.remove(0);
            estadoAV3(cinta.get(0));
        }else{
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("erorr de sintaxis AV10-line:  "+ numero_lineas.get(0));
        }
    }

    void estadoAV11(String lexema) {numero_lineas.remove(0);

        if (lexema.equalsIgnoreCase("VARIABLE")||lexema.equalsIgnoreCase("VALORNUM")) {
            cinta.remove(0);
            estadoAV9(cinta.get(0));
        } else {
            estado=false;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.err.println("erorr de sintaxis AV11-line:  "+ numero_lineas.get(0));
        }
    }

}
