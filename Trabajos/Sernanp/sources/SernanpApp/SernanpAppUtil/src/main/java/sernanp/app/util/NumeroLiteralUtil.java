package sernanp.app.util;

import java.util.regex.Pattern;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class NumeroLiteralUtil {

    private final String[] UNIDADES = {"", "Un ", "Dos ", "Tres ", "Cuatro ", "Cinco ", "Seis ", "Siete ", "Ocho ", "Nueve "};
    private final String[] DECENAS = {"Diez ", "Once ", "Doce ", "Trece ", "Catorce ", "Quince ", "Dieciseis ",
        "Diecisiete ", "Dieciocho ", "Diecinueve", "Veinte ", "Treinta ", "Cuarenta ",
        "Cincuenta ", "Sesenta ", "Setenta ", "Ochenta ", "Noventa "};
    private final String[] CENTENAS = {"", "Ciento ", "Doscientos ", "Trescientos ", "Cuatrocientos ", "Quinientos ", "Seiscientos ",
        "Setecientos ", "Ochocientos ", "Novecientos "};

   public NumeroLiteralUtil() {
   }
   
   public static NumeroLiteralUtil getInstance(){
	   return new NumeroLiteralUtil();
   }

    public String Convertir(String numero, boolean mayusculas) {
        String literal = "";
        String parte_decimal;    
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        numero = numero.replace(".", ",");
        //si el numero no tiene parte decimal, se le agrega ,00
        if(numero.indexOf(",")==-1){
            numero = numero + ",00";
        }
        //se valida formato de entrada -> 0,00 y 999 999 999,00
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            //se divide el numero 0000000,00 -> entero y decimal
            String Num[] = numero.split(",");            
            //de da formato al numero decimal
            if(Num[1].equals("0")){
//            	parte_decimal = "00/100 Nuevos Soles";
            	parte_decimal = "00/100 Soles";
            	numero = Num[0];
            }else if(Num[1].length() == 1){
//            	parte_decimal = Num[1] + "0/100 Nuevos Soles";
            	parte_decimal = Num[1] + "0/100 Soles";
            	numero = Num[1]+Num[0]+"0";
            }else{
//            	parte_decimal = Num[1] + "/100 Nuevos Soles";
            	parte_decimal = Num[1] + "/100 Soles";
            }
            
            //se convierte el numero a literal
            if (Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                literal = getDecenas(Num[0]);
            } else {//sino unidades -> 9
                literal = getUnidades(Num[0]);
            }
            //devuelve el resultado en mayusculas o minusculas
            if (mayusculas) {
//                return ("S/. "+numero+" "+literal+"con " + parte_decimal).toUpperCase();
                return ("S/ "+numero+" "+literal+"con " + parte_decimal).toUpperCase();
            } else {
//                return ("S/. "+numero+" "+ capitalizeFirstLetter(literal)+"con "  + parte_decimal);
                return ("S/ "+numero+" "+ capitalizeFirstLetter(literal)+"con "  + parte_decimal);
            }
        } else {//error, no se puede convertir
            return literal = null;
        }
    }

    /* ADD 28-01-2016  DAVID, Para convertir número en letras*/
    public String ConvertirToLetras(String numero, boolean mayusculas) {
        String literal = "";

            
            //se convierte el numero a literal
            if (Integer.parseInt(numero) == 0) {//si el valor es cero
                literal = "cero ";
            } else if (Integer.parseInt(numero) > 999999) {//si es millon
                literal = getMillones(numero);
            } else if (Integer.parseInt(numero) > 999) {//si es miles
                literal = getMiles(numero);
            } else if (Integer.parseInt(numero) > 99) {//si es centena
                literal = getCentenas(numero);
            } else if (Integer.parseInt(numero) > 9) {//si es decena
                literal = getDecenas(numero);
            } else {//sino unidades -> 9
                literal = getUnidades(numero);
            }
            //devuelve el resultado en mayusculas o minusculas
            if (mayusculas) {
//                return ("S/. "+numero+" "+literal+"con " + parte_decimal).toUpperCase();
                return (literal).toUpperCase();
            } else {
//                return ("S/. "+numero+" "+ capitalizeFirstLetter(literal)+"con "  + parte_decimal);
                return (capitalizeFirstLetter(literal));
            }

    }    
    
    /* END */
    
    /* funciones para convertir los numeros a literales */

    private String getUnidades(String numero) {// 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private String getDecenas(String num) {// 99                        
        int n = Integer.parseInt(num);
        if (n < 10) {//para casos como -> 01 - 09
            return getUnidades(num);
        } else if (n > 19) {//para 20...99
            String u = getUnidades(num);
            if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {//numeros entre 11 y 19
            return DECENAS[n - 10];
        }
    }

    private String getCentenas(String num) {// 999 o 099
        if( Integer.parseInt(num)>99 ){//es centena
            if (Integer.parseInt(num) == 100) {//caso especial
                return " Cien ";
            } else {
                 return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            } 
        }else{//por Ej. 099 
            //se quita el 0 antes de convertir a decenas
            return getDecenas(Integer.parseInt(num)+"");            
        }        
    }

    private String getMiles(String numero) {// 999 999
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n="";
        //se comprueba que miles tenga valor entero
        if (Integer.parseInt(m) > 0) {
            n = getCentenas(m);           
            return n + "Mil " + getCentenas(c);
        } else {
            return "" + getCentenas(c);
        }

    }

    private String getMillones(String numero) { //000 000 000        
        //se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        //se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if(millon.length()>1){
            n = getCentenas(millon) + "Millones ";
        }else{
            n = getUnidades(millon) + "Millon ";
        }
        return n + getMiles(miles);        
    }
    public String capitalizeFirstLetter(String original){
        if(original.length() == 0)
            return original;
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
}