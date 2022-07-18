package agentes;

import agentesc.Contenedor;
import agentesc.GUIExample1;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

        

public class Agente4 extends Agent {
    
    @Override
    protected void setup(){ //configurar el agente para que realice las acciones
        addBehaviour(new Comportamiento());
    }

  
    class Comportamiento extends Behaviour{
        boolean terminado = false;
        @Override
      
        public void action() {
            ACLMessage msj = blockingReceive();//Se recibe el mensaje que ha sido enviado hacia AG4
            System.out.println("El mensaje enviado desde AG3 hacia AG4 ha sido recibido");//se confirma que se recibió el mensaje
          
            String prediccion = msj.getContent();// se obtiene el contenido del mensaje
            GUIExample1 gui = (GUIExample1)getArguments()[0];//cramos un objeto GUI para poder mostrar los datos recibidos en este agente
            gui.txaDatos.append("La prediccion del precio del vehiculo es: " + prediccion + "\n");//Se muestra en el area de texto de GUI la predicción del auto
          
            System.out.println("Enviando mensaje desde AG4 hacia AG2");
            Mensajes.enviar(ACLMessage.INFORM, "Ag2", "Activar Datos", "COD0402", getAgent());// Se envia un mensaje a Ag2 para poder volver hacer otra predicción
        }

        @Override
        public boolean done() {
            return terminado; //true = una sola vez; false = ciclico
        }
        
    }
}
