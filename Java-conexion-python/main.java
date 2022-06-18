
package conexionjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionJava {

    
    public static void main(String[] args) {
        try {
            String parametros="\"a\"";
            //user.dir me da la ruta de mis archivos java
            String ruta="\""+System.getProperty("user.dir")+"\\src\\conexionjava\\prueba.py"+"\"";
            //System.out.println(ruta);
            //en mi caso uso py para poder hacer valer el programa
            ProcessBuilder builder =new ProcessBuilder("py",ruta,parametros);
            Process process= builder.start();
            BufferedReader reader= new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultado= null;
            String prediccion="";
            while((resultado=reader.readLine())!=null){
                prediccion +=resultado; 
            }
            System.out.println(prediccion);
        } catch (Exception ex) {
            Logger.getLogger(ConexionJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
