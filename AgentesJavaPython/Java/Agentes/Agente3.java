
import agentesc.Contenedor;
import agentesc.GUIExample1;
import contenidoSerializado.Carro;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
        

public class Agente3 extends Agent {
    
    @Override
    protected void setup(){ //es lo primero que hará el agente y dentro de esta funcion se puede ingresar el resto del comportamiento del agente
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour{
        boolean terminado = false;
        @Override
        public void action() {
            try {
                
                GUIExample1 gui = (GUIExample1)getArguments()[0];
                ACLMessage msj = blockingReceive();//recibimos el mensaje que fue enviado hacia este AG3
                System.out.println("El mensaje enviado desde AG2 hacia AG2 ha sido recibido");//confirmamos que el AG3 recibio el mensaje
                Carro carro = (Carro)msj.getContentObject();//creamos un objeto carro y lo igualamos a los valores recibidos en el mensaje
              
              
                String parametros = carro.toString();//invoamos la función toString para imprimir los datos recibidos desde la GUI
                String ruta = "\"" + System.getProperty("user.dir")+"\\src\\modelo\\prueba.py"+"\"";//sacamos la ruta de donde esta alojado nuestro .py
                
                ProcessBuilder builder = new ProcessBuilder("python", ruta, parametros);//lo invocamos como proceso al .py
                Process process = builder.start();//lo iniciamos
              
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));//iniciamos la lectura de parametros que serán recibidos por el .py
                String resultado = null;
                String prediccion = "";
                while ((resultado = reader.readLine())!=null){
                    if(resultado.contains("1/1") == false)
                        prediccion += resultado;
                }
                System.out.println(prediccion);//se imprime la predicción del precio del auto
                System.out.println("Enviando mensaje desde AG3 hacia AG4");//Aviso de que se enviará mensaje desde AG3 hacia AG4
                Mensajes.enviar(ACLMessage.INFORM, "Ag4", prediccion, "COD0304", getAgent());//Envia mensaje con la predicción como contenido
            } catch (IOException ex) {
                Logger.getLogger(Agente3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public boolean done() {
            return terminado; //true = una sola vez; false = ciclico
        }
        
    }
}
