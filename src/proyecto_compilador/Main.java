
package proyecto_compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //String          fileDir           = "C:\\Users\\gadia\\Documents\\UMG\\OneDrive - Universidad Mariano Gálvez\\Semestre7\\Compiladores\\Input.txt";
        String          fileDir           = "C:\\Users\\gadia\\Documents\\UMG\\OneDrive - Universidad Mariano Gálvez\\Semestre7\\Compiladores\\Input.txt";
        // String          fileDir           = "C:\\Users\\k-47e\\Desktop\\proyecto compi\\Input.txt";
        FileReader      leerArchivo       = null;
        BufferedReader  textoArchivo      = null;
        List            contenido         = new ArrayList();
        String          lineContent       = "";
        int             p                 = 0;
        int             lineNumber        = 0;
        int             largo             = 0;
        String          temp              = "";
        String          temp2             = "";
        String          constantes[][]    = new String[5][5];
        String[]        operadores        = {"=","+","-","*","/",};
        String[]        doperadores       = {"OPERADOR IGUAL","OPERADOR SUMA","OPERADOR SUSTRACCION","OPERADOR MULTIPLICADOR","OPERADOR DIVISION"};
        int             va1;
        int             va2;
        int             va3;
        int             va4;
        String          t1                = "";
        String          t2                = ""; 
        String          t3                = ""; 
        String          t4                = "";
        String          t5                = "";
        
        try{
            leerArchivo = new FileReader(new File(fileDir));
            textoArchivo = new BufferedReader(leerArchivo);
            
            System.out.println("LECTURA DE ARCHIVO-----------------------------------------------------");
            
            while (lineContent != null) {
                try {
                    lineContent = textoArchivo.readLine();
                } catch (IOException ex) {
                System.err.println(
                   "Error lectura de linea: " + lineNumber + " -> " + ex);
                }
                if (lineContent != null && ! lineContent.equals("")) {
                    System.out.println("Datos leidos : " + lineContent);
                    String[] lineElements = lineContent.split("\n");
                    contenido.add(lineElements);
                }
                lineNumber++;
            }
        }catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("LECTURA DE DATOS CARGADOS-----------------------------------------------");
        String[] datos = new String[contenido.size()];
        for(int i = 0; i < contenido.size(); i++) {
            String[] lineElements = (String[]) contenido.get(i);
            for (String lineElement : lineElements) {
                datos[i]=lineElement;
                System.out.print("linea "+i+": "+datos[i] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------\n");
        //CONSTANTES
        for (int i = 0; i < constantes.length; i++) {
            System.out.println("");
            for (int j = 0; j < constantes[i].length; j++) {
                int k=i+5;
                if(datos[k].indexOf(" ")<0){
                   largo=datos[k].length();
                }else{
                    largo=datos[k].indexOf(" ")+1;
                }
                constantes[i][j]=datos[k].substring(0,largo).replace(" ", "");
                temp=datos[k].substring(largo);
                datos[k]=temp;
                System.out.print(constantes[i][j]+"\t");
            }
            
        }
       
         System.out.println("\n------------------------------------------------------------------------\n");       
        //CREACION DE TABLA DE SIMBOLOS -- FORMULA 1
        System.out.println("\n\nVALIDACION FORMULA 1----------------------------------------------------");
        p=10;
        String tabla1[][] = new String[11][5];
        System.out.println(datos[p]);
        
        
        /////validacion si hay operadores juntos
        
            try {
     String val="" ; 
        val= datos[p];
        
        String formula = "";
         
        int bandera=0;
        
  
         for (int a = 9; a <=29; a++) {
  formula= val.substring(9,a);
  
  
  if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0))){
      
    if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0)))  
    
    {
      
          bandera=1;
      }
    else if (bandera==0){
              System.out.println("todo bien");
         }
    
  }
  }
         System.out.println(bandera);
         if (bandera==1){
              System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
         }


        } catch (Exception a){
             System.out.println("");
        } finally {

        
        
        
      
        
        
        
             
        temp=datos[p];
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
                if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf(")")>0){
            temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        
        
        if(temp.indexOf(";")<0){
            System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
        }
            
        
        largo=temp.indexOf("=");
        if(largo<0){
            System.out.println("ERROR: FALTA SIGNO '='");
        }else{
            tabla1[0][0]=temp.substring(0,largo);
            tabla1[0][1]="VARIABLE";
            temp=temp.substring(largo);
            for(int x = 1 ; x < tabla1.length;x++){
                va1=99;
                va2=99;
                va3=99;
                va4=0;
                for(int z = 0; z < operadores.length ; z++){
                    if(va1==99){
                        if(va1>temp.indexOf(operadores[z])){
                            va1=temp.indexOf(operadores[z]);
                            t1=operadores[z];
                            t5=doperadores[z];
                            if (va1<0){
                                va1=99;
                            }
                        }    
                    }
                }
                for(int z = 0; z < constantes.length ; z++){
                    if(va2==99){
                        if(va2>temp.indexOf(constantes[z][0])){
                            va2=temp.indexOf(constantes[z][0]);
                            t2=constantes[z][0];
                            t4=constantes[z][2];
                            if(va2<0){
                                va2=99;
                            }
                        }    
                    }
                }
                for (int z = 10; z < 100; z++) {
                    if(va3==99){
                        if(va3>temp.substring(0,2).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.substring(0,2).indexOf(t3);
                            if (va3<0){
                             va3=99;
                            }
                        }    
                    }
                }
                if(va3==99){
                    for (int z = 10; z > 0; z--) {
                        if(va3>temp.substring(0,1).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.indexOf(t3);
                        }
                        if(va3<0){
                            va3=99;
                        }
                    }    
                }
                if(va1<va2 & va1<va3){
                    va4=1;
                }else if(va2<va1 & va2<va3){
                    va4=2;
                }else if(va3<va1 & va3<va2){
                    va4=3;
                }

                switch(va4){
                    case 1:
                        tabla1[x][0]=temp.substring(0,t1.length());
                        tabla1[x][1]=t5;
                        tabla1[x][2]="N/A";
                        tabla1[x][3]="N/A";
                        temp=temp.substring(t1.length(),temp.length());
                        break;
                    case 2:
                        tabla1[x][0]=temp.substring(0, t2.length());
                        tabla1[x][1]="VARIABLE";
                        tabla1[x][2]=t4;
                        tabla1[x][3]="N/A";                        
                        temp=temp.substring(t2.length(),temp.length());
                        break;
                    case 3:
                        tabla1[x][0]=temp.substring(0, t3.length());
                        tabla1[x][1]="CONSTANTE";
                        tabla1[x][2]="Integer";
                        tabla1[x][3]=t3;                        
                        temp=temp.substring(t3.length(),temp.length());
                        break;                   
                }
            }                 
            }
        System.out.println("#\tTOKEN\t\t\tCATEGORIA\t\t\tTIPO\t\t\tVALOR\t\t\tPRIORIDAD");
        for(int x = 0 ; x < tabla1.length;x++){
            System.out.print(" "+(x+1)+"\t");
            for(int y =0 ; y < tabla1[x].length;y++){
                System.out.print(tabla1[x][y]+"\t\t\t");
            }
            System.out.println("");
        }
        
    }
        
////////////////////////////////////////////////////////////////////////////////////////formula 2/////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        System.out.println("\n------------------------------------------------------------------------\n");        
                //CREACION DE TABLA DE SIMBOLOS -- FORMULA 2
        System.out.println("\n\nVALIDACION FORMULA 2----------------------------------------------------");
        p=11;
        String tabla2[][] = new String[9][5];
        System.out.println(datos[p]);
             
        
        
        ///////////////////////////validacion operadores juntos//////////////////////////////////////////////
        
        
        try {
     String val="" ; 
        val= datos[p];
        
        String formula = "";
         
        int bandera=0;
        
  
         for (int a = 9; a <=29; a++) {
  formula= val.substring(9,a);
  
  
  if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0))){
      
    if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0)))  
    
    {
      
          bandera=1;
      }
    else if (bandera==0){
              System.out.println("todo bien");
         }
    
  }
  }
         
         if (bandera==1){
              System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
         }


        } catch (Exception a){
             System.out.println("");
        } finally {

        
        
        
        
        
        
        temp=datos[p];
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
                if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        
        
        if(temp.indexOf(";")<0){
            System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
        }
            
        
        largo=temp.indexOf("=");
        if(largo<0){
            System.out.println("ERROR: FALTA SIGNO '='");
        }else{
            tabla2[0][0]=temp.substring(0,largo);
            tabla2[0][1]="VARIABLE";
            temp=temp.substring(largo);
            for(int x = 1 ; x < tabla2.length;x++){
                va1=99;
                va2=99;
                va3=99;
                va4=0;
                for(int z = 0; z < operadores.length ; z++){
                    if(va1==99){
                        if(va1>temp.indexOf(operadores[z])){
                            va1=temp.indexOf(operadores[z]);
                            t1=operadores[z];
                            t5=doperadores[z];
                            if (va1<0){
                                va1=99;
                            }
                        }    
                    }
                }
                for(int z = 0; z < constantes.length ; z++){
                    if(va2==99){
                        if(va2>temp.indexOf(constantes[z][0])){
                            va2=temp.indexOf(constantes[z][0]);
                            t2=constantes[z][0];
                            t4=constantes[z][2];
                            if(va2<0){
                                va2=99;
                            }
                        }    
                    }
                }
                for (int z = 10; z < 100; z++) {
                    if(va3==99){
                        if(va3>temp.substring(0,2).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.substring(0,2).indexOf(t3);
                            if (va3<0){
                             va3=99;
                            }
                        }    
                    }
                }
                if(va3==99){
                    for (int z = 10; z > 0; z--) {
                        if(va3>temp.substring(0,1).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.indexOf(t3);
                        }
                        if(va3<0){
                            va3=99;
                        }
                    }    
                }
                if(va1<va2 & va1<va3){
                    va4=1;
                }else if(va2<va1 & va2<va3){
                    va4=2;
                }else if(va3<va1 & va3<va2){
                    va4=3;
                }

                switch(va4){
                    case 1:
                        tabla2[x][0]=temp.substring(0,t1.length());
                        tabla2[x][1]=t5;
                        tabla2[x][2]="N/A";
                        tabla2[x][3]="N/A";
                        temp=temp.substring(t1.length(),temp.length());
                        break;
                    case 2:
                        tabla2[x][0]=temp.substring(0, t2.length());
                        tabla2[x][1]="VARIABLE";
                        tabla2[x][2]=t4;
                        tabla2[x][3]="N/A";                        
                        temp=temp.substring(t2.length(),temp.length());
                        break;
                    case 3:
                        tabla2[x][0]=temp.substring(0, t3.length());
                        tabla2[x][1]="CONSTANTE";
                        tabla2[x][2]="Integer";
                        tabla2[x][3]=t3;                        
                        temp=temp.substring(t3.length(),temp.length());
                        break;  
                }
            }                 
            }
        System.out.println("#\tTOKEN\t\t\tCATEGORIA\t\t\tTIPO\t\t\tVALOR\t\t\tPRIORIDAD");
        for(int x = 0 ; x < tabla2.length;x++){
            System.out.print(" "+(x+1)+"\t");
            for(int y =0 ; y < tabla2[x].length;y++){
                System.out.print(tabla2[x][y]+"\t\t\t");
            }
            System.out.println("");
        }
        }
  /////////////////////////////////////////////////////////////////////////formula 3/////////////////////////////////////////////////////////////////////////////////////////////////////////      
        System.out.println("\n------------------------------------------------------------------------\n");        
                //CREACION DE TABLA DE SIMBOLOS -- FORMULA 3
        System.out.println("\n\nVALIDACION FORMULA 3----------------------------------------------------");
        p=12;
        String tabla3[][] = new String[9][5];
        System.out.println(datos[p]);
        
        //////////////////////////validacion operadores juntos
        
        try {
     String val="" ; 
        val= datos[p];
        
        String formula = "";
         
        int bandera3=0;
        
  
         for (int a = 9; a <=29; a++) {
  formula= val.substring(9,a);
  
  
  if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))){
      
    if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0)))  
    
    {
      
          bandera3=1;
      }
    else if (bandera3==0){
              System.out.println("todo bien");
         }
    
  }
  }
        
         if (bandera3==1){
              System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
         }


        } catch (Exception a){
             System.out.println("");
        } finally {

        
        
        
        
             
        temp=datos[p];
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
                if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        
        
        if(temp.indexOf(";")<0){
            System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
        }
            
        
        largo=temp.indexOf("=");
        if(largo<0){
            System.out.println("ERROR: FALTA SIGNO '='");
        }else{
            tabla3[0][0]=temp.substring(0,largo);
            tabla3[0][1]="VARIABLE";
            temp=temp.substring(largo);
            for(int x = 1 ; x < tabla3.length;x++){
                va1=99;
                va2=99;
                va3=99;
                va4=0;
                for(int z = 0; z < operadores.length ; z++){
                    if(va1==99){
                        if(va1>temp.indexOf(operadores[z])){
                            va1=temp.indexOf(operadores[z]);
                            t1=operadores[z];
                            t5=doperadores[z];
                            if (va1<0){
                                va1=99;
                            }
                        }    
                    }
                }
                for(int z = 0; z < constantes.length ; z++){
                    if(va2==99){
                        if(va2>temp.indexOf(constantes[z][0])){
                            va2=temp.indexOf(constantes[z][0]);
                            t2=constantes[z][0];
                            t4=constantes[z][2];
                            if(va2<0){
                                va2=99;
                            }
                        }    
                    }
                }
                for (int z = 10; z < 100; z++) {
                    if(va3==99){
                        if(va3>temp.substring(0,2).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.substring(0,2).indexOf(t3);
                            if (va3<0){
                             va3=99;
                            }
                        }    
                    }
                }
                if(va3==99){
                    for (int z = 10; z > 0; z--) {
                        if(va3>temp.substring(0,1).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.indexOf(t3);
                        }
                        if(va3<0){
                            va3=99;
                        }
                    }    
                }
                if(va1<va2 & va1<va3){
                    va4=1;
                }else if(va2<va1 & va2<va3){
                    va4=2;
                }else if(va3<va1 & va3<va2){
                    va4=3;
                }
                
                switch(va4){
                    case 1:
                        tabla3[x][0]=temp.substring(0,t1.length());
                        tabla3[x][1]=t5;
                        tabla3[x][2]="N/A";
                        tabla3[x][3]="N/A";
                        temp=temp.substring(t1.length(),temp.length());
                        break;
                    case 2:
                        tabla3[x][0]=temp.substring(0, t2.length());
                        tabla3[x][1]="VARIABLE";
                        tabla3[x][2]=t4;
                        tabla3[x][3]="N/A";                        
                        temp=temp.substring(t2.length(),temp.length());
                        break;
                    case 3:
                        tabla3[x][0]=temp.substring(0, t3.length());
                        tabla3[x][1]="CONSTANTE";
                        tabla3[x][2]="Integer";
                        tabla3[x][3]=t3;                        
                        temp=temp.substring(t3.length(),temp.length());
                        break;  
                }
            }                 
            }
        System.out.println("#\tTOKEN\t\t\tCATEGORIA\t\t\tTIPO\t\t\tVALOR\t\t\tPRIORIDAD");
        for(int x = 0 ; x < tabla3.length;x++){
            System.out.print(" "+(x+1)+"\t");
            for(int y =0 ; y < tabla3[x].length;y++){
                System.out.print(tabla3[x][y]+"\t\t\t");
            }
            System.out.println("");
        }
        }
 ////////////////////////////////////////////////////////////////////////////////// formula 4 /////////////////////////////////////////////////////////////////////////////////////////////       
        
        System.out.println("\n------------------------------------------------------------------------\n");        
                //CREACION DE TABLA DE SIMBOLOS -- FORMULA 4
        System.out.println("\n\nVALIDACION FORMULA 4----------------------------------------------------");
        p=13;
        String tabla4[][] = new String[9][5];
        System.out.println(datos[p]);
             
        //////////////////////////validacion operadores juntos
        
        
            try {
     String val="" ; 
        val= datos[p];
        
        String formula = "";
         
        int bandera=0;
        
  
         for (int a = 9; a <=val.length(); a++) {
  formula= val.substring(9,a);
  
  
  if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0))){
      
    if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0)))  
    
    {
      
          bandera=1;
      }
    else if (bandera==0){
              System.out.println("todo bien");
         }
    
  }
  }
         
         if (bandera==1){
              System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
         }


        } catch (Exception a){
             System.out.println("");
        } finally {

         
        
        temp=datos[p];
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
                if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        
        
        if(temp.indexOf(";")<0){
            System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
        }
            
        
        largo=temp.indexOf("=");
        if(largo<0){
            System.out.println("ERROR: FALTA SIGNO '='");
        }else{
            tabla4[0][0]=temp.substring(0,largo);
            tabla4[0][1]="VARIABLE";
            temp=temp.substring(largo);
            for(int x = 1 ; x < tabla4.length;x++){
                va1=99;
                va2=99;
                va3=99;
                va4=0;
                for(int z = 0; z < operadores.length ; z++){
                    if(va1==99){
                        if(va1>temp.indexOf(operadores[z])){
                            va1=temp.indexOf(operadores[z]);
                            t1=operadores[z];
                            t5=doperadores[z];
                            if (va1<0){
                                va1=99;
                            }
                        }    
                    }
                }
                for(int z = 0; z < constantes.length ; z++){
                    if(va2==99){
                        if(va2>temp.indexOf(constantes[z][0])){
                            va2=temp.indexOf(constantes[z][0]);
                            t2=constantes[z][0];
                            t4=constantes[z][2];
                            if(va2<0){
                                va2=99;
                            }
                        }    
                    }
                }
                for (int z = 10; z < 100; z++) {
                    if(va3==99){
                        if(va3>temp.substring(0,2).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.substring(0,2).indexOf(t3);
                            if (va3<0){
                             va3=99;
                            }
                        }    
                    }
                }
                if(va3==99){
                    for (int z = 10; z > 0; z--) {
                        if(va3>temp.substring(0,1).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.indexOf(t3);
                        }
                        if(va3<0){
                            va3=99;
                        }
                    }    
                }
                if(va1<va2 & va1<va3){
                    va4=1;
                }else if(va2<va1 & va2<va3){
                    va4=2;
                }else if(va3<va1 & va3<va2){
                    va4=3;
                }
                
                switch(va4){
                    case 1:
                        tabla4[x][0]=temp.substring(0,t1.length());
                        tabla4[x][1]=t5;
                        tabla4[x][2]="N/A";
                        tabla4[x][3]="N/A";
                        temp=temp.substring(t1.length(),temp.length());
                        break;
                    case 2:
                        tabla4[x][0]=temp.substring(0, t2.length());
                        tabla4[x][1]="VARIABLE";
                        tabla4[x][2]=t4;
                        tabla4[x][3]="N/A";                        
                        temp=temp.substring(t2.length(),temp.length());
                        break;
                    case 3:
                        tabla4[x][0]=temp.substring(0, t3.length());
                        tabla4[x][1]="CONSTANTE";
                        tabla4[x][2]="Integer";
                        tabla4[x][3]=t3;                        
                        temp=temp.substring(t3.length(),temp.length());
                        break;  
                }
            }                 
            }
        System.out.println("#\tTOKEN\t\t\tCATEGORIA\t\t\tTIPO\t\t\tVALOR\t\t\tPRIORIDAD");
        for(int x = 0 ; x < tabla4.length;x++){
            System.out.print(" "+(x+1)+"\t");
            for(int y =0 ; y < tabla4[x].length;y++){
                System.out.print(tabla4[x][y]+"\t\t\t");
            }
            System.out.println("");
        }
            }
 ///////////////////////////////////////////////////////////////////////////////////////formula 5 ///////////////////////////////////////////////////////////////////////////////////////       
        System.out.println("\n------------------------------------------------------------------------\n");        
                //CREACION DE TABLA DE SIMBOLOS -- FORMULA 5
        System.out.println("\n\nVALIDACION FORMULA 5----------------------------------------------------");
        p=14;
        String tabla5[][] = new String[8][5];
        System.out.println(datos[p]);
        
        
        //////////////validacion operadores juntos
        
            try {
     String val="" ; 
        val= datos[p];
        
        String formula = "";
         
        int bandera=0;
        
  
         for (int a = 9; a <=val.length(); a++) {
  formula= val.substring(9,a);
  
  
  if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0))||((formula.indexOf(")")>0))){
      
    if (((formula.indexOf("+")>0))||((formula.indexOf("*")>0)) || ((formula.indexOf("-")>0))|| ((formula.indexOf("/")>0))||((formula.indexOf(";")>0))||((formula.indexOf(")")>0)))  
    
    {
      
          bandera=1;
      }
    else if (bandera==0){
              System.out.println("todo bien");
         }
    
  }
  }
         
         if (bandera==1){
              System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
         }


        } catch (Exception a){
             System.out.println("");
        } finally {

         
   
        
      
        
             
        temp=datos[p];
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
                if(temp.indexOf("(")>0){
            temp=temp.substring(0,temp.indexOf("("))+temp.substring(temp.indexOf("(")+1,temp.length());
            if(temp.indexOf(")")>0){
                temp=temp.substring(0,temp.indexOf(")"))+temp.substring(temp.indexOf(")")+1,temp.length());
            }else{
                System.out.println("ERROR: FALTA CERRAR PARENTESIS");
            }
        }
        if(temp.indexOf(")")>0){
            temp=temp.replace(")","");
            System.out.println("ERROR: FALTA ABRIR PARENTESIS");
        }
        
        
        if(temp.indexOf(";")<0){
            System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
        }
            
        
        largo=temp.indexOf("=");
        if(largo<0){
            System.out.println("ERROR: FALTA SIGNO '='");
        }else{
            tabla5[0][0]=temp.substring(0,largo);
            tabla5[0][1]="VARIABLE";
            temp=temp.substring(largo);
            for(int x = 1 ; x < tabla5.length;x++){
                va1=99;
                va2=99;
                va3=99;
                va4=0;

                for(int z = 0; z < operadores.length ; z++){
                    if(va1==99){
                        if(va1>temp.indexOf(operadores[z])){
                            va1=temp.indexOf(operadores[z]);
                            t1=operadores[z];
                            t5=doperadores[z];
                            if (va1<0){
                                va1=99;
                            }
                        }    
                    }
                }
                for(int z = 0; z < constantes.length ; z++){
                    if(va2==99){
                        if(va2>temp.indexOf(constantes[z][0])){
                            va2=temp.indexOf(constantes[z][0]);
                            t2=constantes[z][0];
                            t4=constantes[z][2];
                            if(va2<0){
                                va2=99;
                            }
                        }    
                    }
                }
                for (int z = 10; z < 100; z++) {
                    if(temp.length()==1){
                    }else if(va3==99){
                        if(va3>temp.substring(0,2).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.substring(0,2).indexOf(t3);
                            if (va3<0){
                             va3=99;
                            }
                        }    
                    }
                }
                if(va3==99){
                    for (int z = 10; z > 0; z--) {
                        if(va3>temp.substring(0,1).indexOf(String.valueOf(z))){
                            t3 =String.valueOf(z);
                            va3=temp.indexOf(t3);
                        }
                        if(va3<0){
                            va3=99;
                        }
                    }    
                }
                if(va1<va2 & va1<va3){
                    va4=1;
                }else if(va2<va1 & va2<va3){
                    va4=2;
                }else if(va3<va1 & va3<va2){
                    va4=3;
                }
                switch(va4){
                    case 1:
                        tabla5[x][0]=temp.substring(0,t1.length());
                        tabla5[x][1]=t5;
                        tabla5[x][2]="N/A";
                        tabla5[x][3]="N/A";
                        temp=temp.substring(t1.length(),temp.length());
                        break;
                    case 2:
                        tabla5[x][0]=temp.substring(0, t2.length());
                        tabla5[x][1]="VARIABLE";
                        tabla5[x][2]=t4;
                        tabla5[x][3]="N/A";                        
                        temp=temp.substring(t2.length(),temp.length());
                        break;
                    case 3:
                        tabla5[x][0]=temp.substring(0, t3.length());
                        tabla5[x][1]="CONSTANTE";
                        tabla5[x][2]="Integer";
                        tabla5[x][3]=t3;                        
                        temp=temp.substring(t3.length(),temp.length());
                        break;  
                }
            }                 
            }
        System.out.println("#\tTOKEN\t\t\tCATEGORIA\t\t\tTIPO\t\t\tVALOR\t\t\tPRIORIDAD");
        for(int x = 0 ; x < tabla5.length;x++){
            System.out.print(" "+(x+1)+"\t");
            for(int y =0 ; y < tabla5[x].length;y++){
                System.out.print(tabla5[x][y]+"\t\t\t");
            }
            System.out.println("");
        }

    }
}
}