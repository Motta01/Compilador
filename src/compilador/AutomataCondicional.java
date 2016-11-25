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
public class AutomataCondicional {
    
    ArrayList<String> cinta;
    ArrayList<Integer> numero_lineas;
    boolean error = false;
    String info_error = "";
    
    public AutomataCondicional(ArrayList<String> cinta, ArrayList<Integer> numero_lineas) {
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
        condicionPar(cinta.get(0));
    }
    
    public void condicionPar(String lexema) {
        System.out.println("condicionPar");
        numero_lineas.remove(0);
        if (lexema.equals("PAR1")) {
            cinta.remove(0);
            try {
                condicion1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Valor esperado: boolean");
                System.out.println("condicionPar");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Token esperado: '('");
            System.out.println("condicionPar");
        }
    }
    
    //Validacion condicionales para la estructura SI
    public void condicion1(String lexema) {
        System.out.println("condicion1");
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE") || lexema.equals("VALORNUM") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            try {
                condicion2(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ')'");
                System.out.println("condicion1");
            }
        } else if (lexema.equals("VALORBOOL")) {
            cinta.remove(0);
            try {
                condicion6(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ')'");
                System.out.println("condicion1");
            }
        } else if (lexema.equals("NEGADOR")) {
            cinta.remove(0);
            try {
                condicion3(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Valor esperado: boolean");
                System.out.println("condicion1");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Valor esperado: boolean");
            System.out.println("condicion1");
        }
    }

    private void condicion2(String lexema) {
        System.out.println("condicion2");        
        numero_lineas.remove(0);
        if (lexema.equals("PAR2")) {
            cinta.remove(0);
            try {
//                condicion7(cinta.get(0));
                System.out.println("Condicional Bien");
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ';'");
                System.out.println("condicion2");
            }
        } else if (lexema.equals("OPLOGICO") || lexema.equals("OR")||lexema.equals("AND")||lexema.equals("EQUALS")) {
            cinta.remove(0);
            try {
                condicion4(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Valor esperado");
                System.out.println("condicion2");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Token esperado: ')'");
            System.out.println("condicion2");
        }
    }

    private void condicion3(String lexema) {
        System.out.println("condicion3");        
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE") || lexema.equals("VALORBOOL") || lexema.equals("FUNCION")) {
            cinta.remove(0);
            try {
                condicion6(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ')'");
                System.out.println("condicion3");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Valor esperado: boolean");
            System.out.println("condicion3");
        }
    }

    public void condicion4(String lexema) {
        System.out.println("condicion4");
        numero_lineas.remove(0);
        if (lexema.equals("VARIABLE") || lexema.equals("VALORNUM") || lexema.equals("VALORBOOL")) {
            cinta.remove(0);
            try {
                condicion5(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ')'");
                System.out.println("condicion4");
            }
        } else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Valor esperado");
            System.out.println("condicion4");
        }
    }

    private void condicion5(String lexema) {
        System.out.println("condicion5");
        numero_lineas.remove(0);
        if (lexema.equals("PAR2")) {
            cinta.remove(0);
            try {
//                condicion7(cinta.get(0));
                System.out.println("Condicional Bien");
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ';'");
                System.out.println("condicion5");
            }
        } else if(lexema.equals("EQUAL") || lexema.equals("OR") || lexema.equals("AND")){
            cinta.remove(0);
            try {
                condicion1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Valor esperado");
                System.out.println("condicion5");
            }
        }else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Token esperado: ')'");
            System.out.println("condicion5");
        }
    }

    private void condicion6(String lexema) {
        System.out.println("condicion6");
        numero_lineas.remove(0);
        if (lexema.equals("OR") || lexema.equals("AND") || lexema.equals("EQUAL") ) {
            cinta.remove(0);
            try {
                condicion1(cinta.get(0));
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ')'");
                System.out.println("condicion6");
            }
        } else if(lexema.equals("PAR2")){
            cinta.remove(0);
            try {
//                condicion7(cinta.get(0));
                System.out.println("Condicional Bien");
            } catch (Exception e) {
                error = true;
                this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ')'");
                System.out.println("condicion6");
            }
        }else {
            error = true;
            this.info_error = "Error sintáctico en la linea " + this.numero_lineas.get(0);
            System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
            System.out.println("Valor esperado: boolean");
            System.out.println("condicion6");
        }
    }    
}
