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
    private ArrayList<String>cinta;
    private boolean estado = true;

    public DeclaracionVariableString(ArrayList<String> cinta) {
        this.cinta = cinta;
        principalDVS(cinta.get(0));
    }

    public ArrayList<String> getCinta() {
        return cinta;
    }

    public boolean isEstado() {
        return estado;
    }
    
     void principalDVS (String lexema){
	if(lexema.equals("STRING")){
            cinta.remove(0);
            estadoDVS1(cinta.get(0));
	}else{
            estado=false;
             System.err.println("Error 4004S");
	}
    }
    void estadoDVS1(String lexema){
	if(lexema.equals("VARIABLE")){
		cinta.remove(0);
		estadoDVS2(cinta.get(0));
	}else{
            estado=false;
		System.err.println("Error de sintaxis DVS1");
	}

    }
    void estadoDVS2(String lexema){
	
	if(lexema.equals("ENDLINE")){
            cinta.remove(0);
            estadoDVS9();
	}else if(lexema.equalsIgnoreCase("SAME")){
            cinta.remove(0);
            estadoDVS3(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVS7(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("COR1")){
            cinta.remove(0);
            estadoDVS10(cinta.get(0));
        }else{
            estado=false;
            System.err.println("Error al declarar la variable DVS2");
	}
    }

    void estadoDVS3(String lexema){
     
            if(lexema.equals("VALORTEXTO")||lexema.equals("FUNCION")||lexema.equals("VARIABLE")){
                    cinta.remove(0);
                    estadoDVS6(cinta.get(0));
        }else{
            estado=false;
            System.err.println("Error de sitaxis faltan comillas DVS3");
        }
    }
    
    void estadoDVS6(String lexema){
	if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVS9();
	}else if(lexema.equals("MAS")){//aqui solo es +
            cinta.remove(0);
            estadoDVS3(cinta.remove(0));
        }else{
            estado=false;
            System.err.println("Error de sintaxis DVS6");
	}
	
    }
    void estadoDVS7(String lexema){
	if(lexema.equals("VARIABLE")){
			cinta.remove(0);
			estadoDVS8(cinta.get(0));
	}else{
                        estado=false;
			System.err.println("error se sistaxis DVS7");
	}
    }

    void estadoDVS8(String lexema){
      
	if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVS7(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVS9();
	}else{
                        estado=false;
            		System.err.println("error de sintaxis DVS8");
	}
    }

    void estadoDVS4(String lexema){
	
            if(lexema.equals("VARIABLE")||lexema.equals("FUNCION")||lexema.equals("VALORTEXT")){
                        cinta.remove(0);
                        estadoDVS5(cinta.get(0));
        }else{
            estado=false;
            System.err.println("Error de sitaxis faltan comillas DVS4");
        }
    }
    void estadoDVS5(String lexema){
	
	if(lexema.equalsIgnoreCase("COMA")){
            cinta.remove(0);
            estadoDVS4(cinta.get(0));
	}else if(lexema.equalsIgnoreCase("KEY2")){
            cinta.remove(0);
            estadoDVS6(cinta.get(0));
	}else{
        estado=false;
	System.err.println("Error de sintaxis DVS5");
	}
    }

    void estadoDVS9(){
    /*esta funcion se encarga de regresar a los estados del automaton principal(P).
     estado final de Declaracion de Variables(DV).
     
     */
      
        System.out.println("Declaracion exitosa");
        
    }
    void estadoDVS10(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVS12(cinta.get(0));
        }else if(lexema.equals("VALORNUM")||lexema.equals("VARIABLE")||lexema.equals("FUNCION")){
            cinta.remove(0);
            estadoDVS11(cinta.get(0));
        }else{
            estado=false;
            System.err.println("Error de DVS10 ");
        }
    }
    void estadoDVS11(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVS12(cinta.get(0));
        }else{
            estado=false;
            System.err.println("Eror de sitaxis DVS11");
        }
    }
    void estadoDVS12(String lexema){
        if(lexema.equalsIgnoreCase("COR1")){
            cinta.remove(0);
            estadoDVS13(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("SAME")){
            cinta.remove(0);
            estadoDVS15(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("ENDLINE")){
            cinta.remove(0);
            estadoDVS9();
        }else{
            estado=false;
            System.err.println("Eror de sitaxis DVS12"); 
        }
    }
    void estadoDVS13(String lexema){
        if(lexema.equals("VALORNUM")||lexema.equals("VARIABLE")||lexema.equals("FUNCION")){
            cinta.remove(0);
            estadoDVS14(cinta.get(0));
        }else if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVS6(cinta.get(0));
        }else{
            estado=false;
            System.err.println("Error de sitaxis DVS13");
        }
    }
    void estadoDVS14(String lexema){
        if(lexema.equalsIgnoreCase("COR2")){
            cinta.remove(0);
            estadoDVS6(cinta.get(0));
        }else{
           estado=false;
           System.err.println("Error de sitaxis DVS14"); 
        }
    }
    void estadoDVS15(String lexema){
        if(lexema.equalsIgnoreCase("KEY1")){
            cinta.remove(0);
            estadoDVS4(cinta.get(0));
        }else{
            estado=false;
            System.err.println("Error de sitaxis DVS15");
        }
    }
    void estadoDVS16(String lexema){
            if(lexema.equals("ENDLINE")){
                cinta.remove(0);
                estadoDVS9();  
            }else{
                estado=false;
                System.err.println("Error de sitaxis DVS16");
            }
    }
}
