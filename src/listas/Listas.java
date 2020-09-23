/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.ArrayList;

/**
 *
 * @author samaniw
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Validar expresion matemática: "+validarExpresionMatematica("{8+7[3(4)]}"));//resultado: verdadero
        System.out.println("Validar expresion matemática: "+validarExpresionMatematica("{([5+7]/3)-66"));//resultado: falso
        System.out.println("");
        
        try {
            System.out.println("Conversión numérica: "+convertirBasesNumericas(14,8));//resultado: 16
            System.out.println("Conversión numérica: "+convertirBasesNumericas(3838,16));//E
            System.out.println("Conversión numérica: "+convertirBasesNumericas(14,2));//1110
            System.out.println("Conversión numérica: "+convertirBasesNumericas(14,7));//mostrar el error
            
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        
        
        ColaEnlazada atencionCiudadana = new ColaEnlazada();
        atencionCiudadana.agregar(11);
        atencionCiudadana.agregar(22);
        atencionCiudadana.agregar(33);
        atencionCiudadana.agregar(55);
        atencionCiudadana.agregar(77);
        atencionCiudadana.agregar(999);
        System.out.println("");
        atencionCiudadana.remover();
        System.out.println("");
        String conversion = convetirDecimalBinario(100);
        System.out.println("Conversion de decimal a binario: " + conversion);
        
        pruebaElement();
        pruebaPeek();
        
//        int a = 4, b = 8;
        //condicional en cortocircuito
        //https://es.wikipedia.org/wiki/Evaluaci%C3%B3n_de_cortocircuito
//        if (a > 0 || b > 0) {
//
//        }
//        if (a > 0 | b > 0) {
//
//        }

//        System.out.println("Validar parentesis");
//        System.out.println(validarBalanceParentesis("(()(()())())"));
//        
//        
//        // TODO code application logic here
//        LinkedStack<Double> pilaEnlazada = new LinkedStack<>();
//        pilaEnlazada.push(3.3);
//        pilaEnlazada.push(4.4);
//        pilaEnlazada.push(5.5);
//        pilaEnlazada.push(6.6);
//        try {
//            System.out.println("Mostrar el siguiente en salir:" + pilaEnlazada.peek());
//            pilaEnlazada.pop();
//            pilaEnlazada.pop();
//            pilaEnlazada.pop();
//            pilaEnlazada.pop();
//            pilaEnlazada.pop();
//            pilaEnlazada.pop();
//            pilaEnlazada.pop();
//            pilaEnlazada.pop();
//            System.out.println("Mostrar el siguiente en salir:" + pilaEnlazada.peek());
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        ArrayStack<Integer> pilaArreglo = new ArrayStack<>(3);
//        pilaArreglo.push(11);
//        pilaArreglo.push(22);
//        pilaArreglo.push(33);
//        try {
//            System.out.println("Antes de hacer pop");
//            System.out.println(pilaArreglo.peek());
//            pilaArreglo.pop();
//            pilaArreglo.pop();
//            pilaArreglo.pop();
//            pilaArreglo.pop();
//            System.out.println("Despues de hacer pop");
//            System.out.println(pilaArreglo.peek());
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        System.out.println();
    }

    public static String convetirDecimalBinario(int n){
        LinkedStack<Integer> residuos = new LinkedStack<>();
        String binario ="";
        while(n>0){
            residuos.push(n%2);
            n/=2;
        }
        while(!residuos.empty()){
            try {
                binario += residuos.pop();
            } catch (Exception e) {
                System.out.println("Error interno");
            }
            
        }
        return binario;
        
        
    }
    
    public static boolean validarBalanceParentesis(String expresion) {
        LinkedStack<String> parentesis = new LinkedStack<>();
        char[] expresionEnArreglo = expresion.toCharArray();
        for (int i = 0; i < expresionEnArreglo.length; i++) {
            if (expresionEnArreglo[i] == '(') {
                parentesis.push("(");
            } else if (expresionEnArreglo[i] == ')') {
                if (parentesis.empty()) {
                    return false;
                } else {
                    try {
                        parentesis.pop();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }

            }

        }

        return parentesis.empty();

    }
    
    
    
    /**
     * Verificar si una expresión matemática que utilice llaves, 
     * corchetes y paréntesis se encuentra balanceada
     * @param expresion Expresion matemática
     * @return Verdadero si esta balanceada, falso si no esta balanceada
     * Expresión balanceada: {[(5+7)/3]-66}
     * Expresión No balanceada: {([5+7]/3)-66
     */
    public static boolean validarExpresionMatematica(String expresion){
        String comp = "";
        char[] expresionEnArreglo = expresion.toCharArray();
        for (int i = 0; i < expresionEnArreglo.length; i++){
            if(expresionEnArreglo[i] == '('){
                comp += "(";
            }
            if(expresionEnArreglo[i] == ')'){
                comp += ")";
            }
            if(expresionEnArreglo[i] == '['){
                comp += "[";
            }
            if(expresionEnArreglo[i] == ']'){
                comp += "]";
            }
            if(expresionEnArreglo[i] == '{'){
                comp += "{";
            }
            if(expresionEnArreglo[i] == '}'){
                comp += "}";
            }
        }
        System.out.println(comp);
        if ("{[()]}".equals(comp)){
            return true;
        }
        if ("[()]".equals(comp)){
            return true;
        }
        
        if ("()".equals(comp)){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
    public static int convertirBasesNumericas(int n, int base)throws Exception{
        LinkedStack<Integer> residuos = new LinkedStack<>();
        String binario ="";
        String octal = "";
        String hexa = "";
        String acum = "";
        int guar = 0;
        int conver = 0;
            if(base != 2 && base != 8 && base != 16){
                throw new IllegalArgumentException("La base no válida");
            }else{
                if (base == 2){
                    while(n>0){
                        residuos.push(n%2);
                        n/=2;
                    }
                    while(!residuos.empty()){
                        try {
                            binario += residuos.pop();
                        } catch (Exception e) {
                        System.out.println("Error interno");
                        }
                    }
                    conver = Integer.parseInt(binario);
                }
                
                if (base == 8){
                    while(n>0){
                        residuos.push(n%8);
                        n/=8;
                    }
                    while(!residuos.empty()){
                        try {
                            octal += residuos.pop();
                        } catch (Exception e) {
                        System.out.println("Error interno");
                        }
                    }
                    conver = Integer.parseInt(octal);
                }
                
                if(base == 16){
                    while(n>0){
                        residuos.push(n%16);
                        n/=16;
                        guar = (int) residuos.peek();
                        
                        if(guar < 10){
                            acum = residuos.peek() + "" + acum;
                        }
                        
                        if(guar == 15){
                            acum = "F"+ acum;
                        }
                        
                        if(guar == 14){
                            acum = "E"+ acum;
                        }
                        
                        if(guar == 13){
                            acum = "D"+ acum;
                        }
                        
                        if(guar == 12){
                            acum = "C"+ acum;
                        }
                        
                        if(guar == 11){
                            acum = "B"+ acum;
                        }
                        
                        if(guar == 10){
                            acum = "A"+ acum;
                        }
                        
                    }
                    while(!residuos.empty()){
                        try {
                            hexa += residuos.pop();
                            conver = Integer.parseInt(hexa);
                        } catch (Exception e) {
                        System.out.println("Error interno");
                        }
                    }
                    System.out.println(acum);
                }
            }
            return conver;
    }
    
    public static void pruebaElement(){
        LinkedStack<Integer> prueba = new LinkedStack<>();
        try{
            prueba.element();
        }catch(Exception e){
            System.out.println("No hay elementos");
        }
    }
    
    public static String pruebaPeek(){
        LinkedStack<String> prueba = new LinkedStack<>();
        String pruebas = prueba.peek() + "";
        return pruebas;
    }
}
