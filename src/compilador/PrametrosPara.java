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
public class PrametrosPara {

    ArrayList<String> cinta;
    ArrayList<Integer> numero_lineas;
    boolean error = false;
    String info_error = "";

    public PrametrosPara(ArrayList<String> cinta, ArrayList<Integer> numero_lineas) {
        this.cinta = cinta;
        this.numero_lineas = numero_lineas;
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

    public boolean getError() {
        return error;
    }

    public void analizar() {
        paraPar(cinta.get(0));
    }

    public void paraPar(String lexema) {
        System.out.println("paraPar");
        numero_lineas.remove(0);
        if (lexema.equals("PAR1")) {
            cinta.remove(0);
            try {
                para1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Valor esperado: boolean");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            //System.out.println("Token esperado: '('");
        }
    }

    public void para1(String lexema) {
        System.out.println("para1");
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            try {
                para2(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Token esperado: ';'");
            }
        } else if (lexema.equals("NUMTYPE")) {
            cinta.remove(0);
            try {
                para3(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Token esperado: ';'");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            //System.out.println("Token esperado: ';'");
        }
    }

    public void para2(String lexema) {
        System.out.println("para2");
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            try {
                para7(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Token esperado: ')'");
            }
        } else if (lexema.equals("VARIABLE") || lexema.equals("VALORNUM")) {
            cinta.remove(0);
            try {
                para8(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Token esperado: ';'");
            }
        } else {
            error = true;
             this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            //System.out.println("Token esperado: ';'");
        }
    }

    public void para3(String lexema) {
        System.out.println("para3");
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE")) {
            cinta.remove(0);
            try {
                para4(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Token esperado: '='");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            //System.out.println("Valor esperado");
        }
    }

    public void para4(String lexema) {
        System.out.println("para4");
        numero_lineas.remove(0);
        if (lexema.equals("SAME")) {
            cinta.remove(0);
            try {
                para5(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Valor esperado");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            //System.out.println("Token esperado: '='");
        }
    }

    public void para5(String lexema) {
        System.out.println("para5");
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE") || lexema.equals("VALORNUM")) {
            cinta.remove(0);
            try {
                para2(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Valor esperado");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            //System.out.println("Valor esperado");
        }
    }

    public void para6(String lexema) {
        System.out.println("para6");
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            try {
                para2(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                //System.out.println("Token esperado: '}'");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            //System.out.println("Token esperado: '}'");
        }
    }

    public void para7(String lexema) {
        System.out.println("para7");
        numero_lineas.remove(0);
        if (lexema.equals("PAR2")) {
            cinta.remove(0);
            try {
                para10(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//                System.out.println("Token esperado: ';'");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//            System.out.println("Token esperado: ')'");
        }
    }

    public void para8(String lexema) {
        System.out.println("para8");
        numero_lineas.remove(0);
        if (lexema.equals("OPLOGICO") || lexema.equals("EQUALS")) {
            cinta.remove(0);
            try {
                para9(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//                System.out.println("Token esperado: ';'");
            }
        } else if (lexema.equals("ENDLINE")) {
            cinta.remove(0);
            try {
                para7(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//                System.out.println("Token esperado: ';'");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//            System.out.println("Token esperado: ';'");
        }
    }

    public void para9(String lexema) {
        System.out.println("para9");
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE") || lexema.equals("VALORNUM")) {
            cinta.remove(0);
            try {
                para7(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//                System.out.println("Token esperado: ';'");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//            System.out.println("Valor esperado");
        }
    }

    public void para10(String lexema) {
        System.out.println("para7");
        numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            System.out.println("Pametros FOR Exitosos");
        } else if (lexema.equals("KEY1")) {
            System.out.println("Pametros FOR Exitosos");
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
//            System.out.println("Token esperado: ';'");
        }
    }
}
