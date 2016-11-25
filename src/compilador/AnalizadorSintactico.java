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
public class AnalizadorSintactico {

    private ArrayList<String> cinta;
    private ArrayList<Integer> numero_lineas;

    public AnalizadorSintactico() {
        this.cinta = new ArrayList<>();
        this.cinta.add("START");//inicio
        this.cinta.add("KEY1");
        
        this.cinta.add("KEY1");
        this.cinta.add("KEY2");

        this.cinta.add("IF");
        this.cinta.add("PAR1");
        this.cinta.add("VARIABLE");
        this.cinta.add("LOGICO");
        this.cinta.add("VARIABLE");
        this.cinta.add("AND");
        this.cinta.add("VALORBOOL");
        this.cinta.add("PAR2");
        this.cinta.add("ENDLINE");

        this.cinta.add("IF");
        this.cinta.add("PAR1");
        this.cinta.add("VARIABLE");
        this.cinta.add("LOGICO");
        this.cinta.add("IF");
        this.cinta.add("AND");
        this.cinta.add("VALORBOOL");
        this.cinta.add("PAR2");
        this.cinta.add("ENDLINE");

        this.cinta.add("KEY2");
        this.cinta.add("END");

        this.numero_lineas = new ArrayList<>();
        this.numero_lineas.add(1);
        this.numero_lineas.add(1);
        
        this.numero_lineas.add(2);
        this.numero_lineas.add(2);

        this.numero_lineas.add(3);
        this.numero_lineas.add(3);
        this.numero_lineas.add(3);
        this.numero_lineas.add(3);
        this.numero_lineas.add(3);
        this.numero_lineas.add(3);
        this.numero_lineas.add(3);
        this.numero_lineas.add(3);
        this.numero_lineas.add(3);

        this.numero_lineas.add(4);
        this.numero_lineas.add(4);
        this.numero_lineas.add(4);
        this.numero_lineas.add(4);
        this.numero_lineas.add(4);
        this.numero_lineas.add(4);
        this.numero_lineas.add(4);
        this.numero_lineas.add(4);
        this.numero_lineas.add(4);

        this.numero_lineas.add(5);
        this.numero_lineas.add(5);
    }

    public void analizar() {
        if(contarLlaves()){
            inicio(this.cinta.get(0));
        }
    }

    public void inicio(String lexema) {
        System.out.println("inicio");
        if (lexema.equals("START")) {
            this.cinta.remove(0);
            try {
                p1(this.cinta.get(0));
            } catch (Exception e) {
                System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
                System.out.println("Token esperado: '{'");
                System.out.println("p1");
            }
        } else {
            System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
            System.out.println("Token esperado: 'inicio'");
            System.out.println("inicio");
        }
    }

    public void p1(String lexema) {
        System.out.println("p1");
        this.numero_lineas.remove(0);
        if (lexema.equals("KEY1")) {
            this.cinta.remove(0);
            try {
                p2(this.cinta.get(0));
            } catch (Exception e) {
                System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
                System.out.println("Token esperado: '}'");
                System.out.println("p3");
            }
        } else {
            System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
            System.out.println("Token esperado: '{'");
            System.out.println("p1");
        }
    }

    public void p2(String lexema) {
        System.out.println("p2");
        this.numero_lineas.remove(0);       
        if (lexema.equals("IF") || lexema.equals("WHILE")) {
            this.cinta.remove(0);
            try {
                AutomataCondicional automata_condicional = new AutomataCondicional(this.cinta, this.numero_lineas);
                automata_condicional.analizar();
                this.cinta = automata_condicional.getCinta();
                this.numero_lineas = automata_condicional.getNumero_lineas();
                if (!automata_condicional.getError()) {
                    p3(this.cinta.get(0));
                }
                
            } catch (Exception e) {
                System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
                System.out.println("Token esperado: '('");
                System.out.println("condicionPar");
            }
        } else if (lexema.equals("NUMTYPE")) {
            DeclaracionVariablesNumericas num = new DeclaracionVariablesNumericas(this.cinta);
            this.cinta = num.getCinta();
            if (num.isEstado()) {
                p2(this.cinta.get(0));
            }
        } else if (lexema.equals("STRING")) {
            DeclaracionVariableString cad = new DeclaracionVariableString(this.cinta);
            this.cinta = cad.getCinta();
            if (cad.isEstado()) {
                p2(this.cinta.get(0));
            }
        } else if (lexema.equals("BOOLEAN")) {
            DeclaracionVariablesBoolean tboolean = new DeclaracionVariablesBoolean(this.cinta);
            this.cinta = tboolean.getCinta();
            if (tboolean.isEstado()) {
                p2(this.cinta.get(0));
            }
        } else if (lexema.equals("CHAR")) {
            DeclaracionVariablesChar charcito = new DeclaracionVariablesChar(this.cinta);
            this.cinta = charcito.getCinta();
            if (charcito.isEstado()) {
                p2(this.cinta.get(0));
            }
        } else if (lexema.equals("KEY2")) {
            this.cinta.remove(0);
            try {
                if (this.cinta.get(0) == "END") {
                    fin(this.cinta.get(0));
                } else {
                    p2(this.cinta.get(0));
                }
            } catch (Exception e) {
                System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
                System.out.println("Palabra esperada: 'fin'");
                System.out.println("fin");
            }
        } else if (lexema.equals("KEY1")) {
            this.cinta.remove(0);
            try {
                p2(this.cinta.get(0));
            } catch (Exception e) {
                System.out.println("Error sintáctico en la linea " + numero_lineas.get(0));
                System.out.println("Token esperado: ')'");
                System.out.println("p2");
            }
        }else {
            System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
            System.out.println("Token esperado: '}'");
            System.out.println("p2");
        }
    }

    public void fin(String lexema) {
        System.out.println("fin");
        this.numero_lineas.remove(0);
        if (lexema.equalsIgnoreCase("END")) {
            System.out.println("Analisis de sintaxis exitosa");
        } else {
            System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
            System.out.println("Token esperado: 'fin'");
            System.out.println("fin");
        }
    }

    private void p3(String lexema) {
        System.out.println("p3");
        this.numero_lineas.remove(0);
        if (lexema.equals("ENDLINE")) {
            //cinta.remove(0);
            this.cinta.remove(0);
            p2(this.cinta.get(0));
        } else if (lexema.equals("KEY1")) {
            //cinta.remove(0);
            p1(this.cinta.get(0));
        } else {
            System.out.println("Error sintáctico en la linea " + this.numero_lineas.get(0));
            System.out.println("Token esperado: ';'");
            System.out.println("p3");
        }
    }

    public boolean contarLlaves() {
        //retornara valores positivos con la posicion del error, 
        //0 cuando es satisfactorio y un valor negativo para cuando se tiene llaves que no han sido cerradas.
        int cont = 0;
        int linea_error = 0;
        for (int i = 0; i < this.cinta.size(); i++) {
            if (this.cinta.get(i).equals("KEY1")) {
                cont++;
            }
            if (this.cinta.get(i).equals("KEY2")) {
                cont--;
            }
            if (cont < 0) {
                linea_error = this.numero_lineas.get(i);
                System.out.println("Error sintáctico en la linea " + linea_error);
                System.out.println("Token esperado: 'fin'");
                System.out.println("contarLlaves");
                return false;
            }
        }

        if (cont > 0) {
            linea_error = this.numero_lineas.get(this.numero_lineas.size() - 1);
            System.out.println("Error sintáctico en la linea " + linea_error);
            System.out.println("Token esperado: '}'");
            System.out.println("contarLlaves");
            return false;
        }
        
        return true;
    }
}