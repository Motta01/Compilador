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
public class DeclaracionVariablesBoolean {
    private ArrayList<String>cinta;
    private boolean estado = true;

    public DeclaracionVariablesBoolean(ArrayList<String> cinta) {
        this.cinta = cinta;
        principalDVB(this.cinta.get(0));
    }
    
    public ArrayList<String> getCinta() {
        return cinta;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
    
    void principalDVB(String lexema){
	if(lexema.equals("BOOLEAN")){
            cinta.remove(0);
            estadoDVB1(cinta.get(0));
	}else{
             estado=false;
             System.err.println("Error 4004B");
             char a[][];
	}
        
    }
    void estadoDVB1(String lexema){
	if(lexema.equals("VARIABLE")){
		cinta.remove(0);
		estadoDVB2(cinta.get(0));
	}else{ estado=false;
		System.err.println("Error de sintaxis DVB1");
	}
    }
    void estadoDVB2(String lexema){
	
	if(lexema.equals("ENDLINE")){
            cinta.remove(0);
            estadoDVB9();
	}else if(lexema.equalsIgnoreCase("SAME")){
            cinta.remove(0);
            estadoDVB3(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVB7(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("COR1")){
            cinta.remove(0);
            estadoDVB10(cinta.get(0));
        }else{ estado=false;
            System.err.println("Error al declarar la variable DVB2");
	}
    }

    void estadoDVB3(String lexema){
	
            if(lexema.equals("VALORBOOL")||lexema.equals("FUNCION")||lexema.equals("VARIABLE")){
                        cinta.remove(0);
                        estadoDVB6(cinta.get(0));
            }else{ estado=false;
            System.err.println("Error al declarar la variable DVB3");
            }
        
    }
    
    void estadoDVB6(String lexema){
	if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVB9();
	}else if(lexema.equals("OR")||lexema.equals("EQUAL")||lexema.equals("AND")){//aqui solo es && == ||
            cinta.remove(0);
            estadoDVB3(cinta.remove(0));
        }else{ estado=false;
            System.err.println("Error de sintaxis DVB6");
	}
	
    }
    void estadoDVB7(String lexema){
	if(lexema.equals("VARIABLE")){
			cinta.remove(0);
			estadoDVB8(cinta.get(0));
	}else{
             estado=false;
			System.err.println("error se sistaxis DVB7");
	}
    }

    void estadoDVB8(String lexema){
      
	if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVB7(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVB9();
	}else{
             estado=false;
			System.err.println("error de sintaxis DVB8");
	}
    }

    void estadoDVB4(String lexema){
	
            if(lexema.equals("VALORBOOL")||lexema.equals("FUNCION")||lexema.equals("VARIABLE")){
                        cinta.remove(0);
                        estadoDVB5(cinta.get(0)); 
            }else{
                 estado=false;
            System.err.println("Error al declarar la variable DVB4");
            }
    }
    void estadoDVB5(String lexema){
	
	if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVB4(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("KEY2")){
            cinta.remove(0);
            estadoDVB6(cinta.get(0));
	}else{
             estado=false;
	System.err.println("Error de sintaxis DVB5");
	}
    }

    void estadoDVB9(){
    /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Declaracion de Variables(DV).
     
     */
        
        System.out.println("Declaracion exitosa");
        
    }
    void estadoDVB10(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVB12(cinta.get(0));
        }else if(lexema.equals("VALORNUM")||lexema.equals("VARIABLE")||lexema.equals("FUNCION")){
            cinta.remove(0);
            estadoDVB11(cinta.get(0));
        }else{
             estado=false;
            System.err.println("Error de DVB10 ");
        }
    }
    void estadoDVB11(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVB12(cinta.get(0));
        }else{
             estado=false;
            System.err.println("Eror de sitaxis DVB11");
        }
    }
    void estadoDVB12(String lexema){
        if(lexema.equalsIgnoreCase("COR1")){
            cinta.remove(0);
            estadoDVB13(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("SAME")){
            cinta.remove(0);
            estadoDVB15(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVB9();
        }else{
             estado=false;
            System.err.println("Eror de sitaxis DVB12"); 
        }
    }
    void estadoDVB13(String lexema){
        if(lexema.equals("VALORNUM")||lexema.equals("VARIABLE")||lexema.equals("FUNCION")){
            cinta.remove(0);
            estadoDVB14(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVB6(cinta.get(0));
        }else{
             estado=false;
            System.err.println("Error de sitaxis DVB13");
        }
    }
    void estadoDVB14(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVB6(cinta.get(0));
        }else{
             estado=false;
           System.err.println("Error de sitaxis DVB14"); 
        }
    }
    void estadoDVB15(String lexema){
        if(lexema.equalsIgnoreCase("KEY1")){
            cinta.remove(0);
            estadoDVB4(cinta.get(0));
        }else{
             estado=false;
            System.err.println("Error de sitaxis DVB15");
        }
    }
    void estadoDVB16(String lexema){
            if(lexema.equals("ENDLINE")){
                cinta.remove(0);
                estadoDVB9();  
            }else{
                 estado=false;
                System.err.println("Error de sitaxis DVB16");
            }
    }
}
