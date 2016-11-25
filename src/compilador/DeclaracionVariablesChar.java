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
    private ArrayList<String>cinta;
    private boolean estado = true;

    public DeclaracionVariablesChar(ArrayList<String> cinta) {
        this.cinta = cinta;
        principalDVC(this.cinta.get(0));
    }

    public ArrayList<String> getCinta() {
        return cinta;
    }

    public boolean isEstado() {
        return estado;
    }
     void principalDVC (String lexema){
	if(lexema.equals("CHAR")){
            cinta.remove(0);
            estadoDVC1(cinta.get(0));
	}else{
             estado=false;
             System.err.println("Error 4004C");
	}
    }
    void estadoDVC1(String lexema){
	if(lexema.equals("CAMPTEXT")){
		cinta.remove(0);
		estadoDVC2(cinta.get(0));
	}else{
             estado=false;
		System.err.println("Error de sintaxis DVC1");
	}

    }
    void estadoDVC2(String lexema){
	
	if(lexema.equals("ENDLINE")){
            cinta.remove(0);
            estadoDVC9();
	}else if(lexema.equalsIgnoreCase("SAME")){
            cinta.remove(0);
            estadoDVC3(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVC7(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("COR1")){
            cinta.remove(0);
            estadoDVC10(cinta.get(0));
        }else{
             estado=false;
            System.err.println("Error al declarar la variable DVC2");
	}
    }

    void estadoDVC3(String lexema){
	if(lexema.equals("COMILLASIMPLE")){
                cinta.remove(0);
                lexema=cinta.get(0);
            if(lexema.equals("FUNCION")||lexema.equals("CHARACT")){
                        cinta.remove(0);
                        lexema=cinta.get(0);
                    if(lexema.equals("COMILLASIMPLE")){
                        cinta.remove(0);
                        estadoDVC6(cinta.get(0));
                    }else{
                         estado=false;
                        System.err.println("Error de sintaxis faltan comillas DVC3");
                    }
                     
            }else{
                 estado=false;
            System.err.println("Error al declarar la variable DVC3");
            }
        }else{
             estado=false;
            System.err.println("Error de sitaxis faltan comillas DVC3");
        }
    }
    
    void estadoDVC6(String lexema){
	if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVC9();
        }else{
             estado=false;
            System.err.println("Error de sintaxis DVC6");
	}
	
    }
    void estadoDVC7(String lexema){
	if(lexema.equals("CAMPTEXT")){
			cinta.remove(0);
			estadoDVC8(cinta.get(0));
	}else{
             estado=false;
			System.err.println("error se sistaxis DV7");
	}
    }

    void estadoDVC8(String lexema){
      
	if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVC7(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVC9();
	}else{
             estado=false;
			System.err.println("error de sintaxis DVC8");
	}
    }

    void estadoDVC4(String lexema){
	if(lexema.equals("COMILLASIMPLE")){
                cinta.remove(0);
                lexema=cinta.get(0);
            if(lexema.equals("FUNCION")||lexema.equals("CHARACT")){
                        cinta.remove(0);
                        lexema=cinta.get(0);
                    if(lexema.equals("COMILLASIMPLE")){
                        cinta.remove(0);
                        estadoDVC5(cinta.get(0));
                    }else{
                         estado=false;
                        System.err.println("Error de sintaxis faltan comillas DVC4");
                    }
                     
            }else{
                 estado=false;
            System.err.println("Error al declarar la variable DVC4");
            }
        }else{
             estado=false;
            System.err.println("Error de sitaxis faltan comillas DVC4");
        }
    }
    void estadoDVC5(String lexema){
	
	if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVC4(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("KEY2")){
            cinta.remove(0);
            estadoDVC6(cinta.get(0));
	}else{ estado=false;
	System.err.println("Error de sintaxis DVC5");
	}
    }

    void estadoDVC9(){
    /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Declaracion de Variables(DV).
     
     */
        System.out.println("Declaracion exitosa");
        
    }
    void estadoDVC10(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVC12(cinta.get(0));
        }else if(lexema.equals("CAMPNUM")||lexema.equals("CAMPTEXT")||lexema.equals("FUNCION")){
            cinta.remove(0);
            estadoDVC11(cinta.get(0));
        }else{ estado=false;
            System.err.println("Error de DVC10 ");
        }
    }
    void estadoDVC11(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVC12(cinta.get(0));
        }else{ estado=false;
            System.err.println("Eror de sitaxis DVC11");
        }
    }
    void estadoDVC12(String lexema){
        if(lexema.equalsIgnoreCase("COR1")){
            cinta.remove(0);
            estadoDVC13(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("SAME")){
            cinta.remove(0);
            estadoDVC15(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVC9();
        }else{ estado=false;
            System.err.println("Eror de sitaxis DVC12"); 
        }
    }
    void estadoDVC13(String lexema){
        if(lexema.equals("CAMPNUM")||lexema.equals("CAMPTEXT")||lexema.equals("FUNCION")){
            cinta.remove(0);
            estadoDVC14(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVC6(cinta.get(0));
        }else{ estado=false;
            System.err.println("Error de sitaxis DVC13");
        }
    }
    void estadoDVC14(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVC6(cinta.get(0));
        }else{ estado=false;
           System.err.println("Error de sitaxis DVC14"); 
        }
    }
    void estadoDVC15(String lexema){
        if(lexema.equalsIgnoreCase("KEY1")){
            cinta.remove(0);
            estadoDVC4(cinta.get(0));
        }else{ estado=false;
            System.err.println("Error de sitaxis DVC15");
        }
    }
    void estadoDVC16(String lexema){
            if(lexema.equals("ENDLINE")){
                cinta.remove(0);
                estadoDVC9();  
            }else{ estado=false;
                System.err.println("Error de sitaxis DVC16");
            }
    }
   
    
    
}
