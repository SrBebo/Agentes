
package agentes;

import agentesC.Contenedor;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Agente1 extends Agent {
    
    @Override
    protected void setup(){
         
        addBehaviour(new Comportamiento());
        System.out.println("Se muere receptor");
    }
    
    @Override
    protected void takeDown(){//esta accion la hace antes de morir, solo si muere
       // Contenedor c = (Contenedor)getArguments()[0];
       //int i = Integer.parseInt(getArguments()[1].toString());
       //i++;
       //c.crearHijos("AgenteHijo"+i, new Object[]{c, i});//este es otro aparte
        
    }
    
    
    class Comportamiento extends Behaviour{
        boolean terminado=false;
        @Override
        public void action() {
            System.out.println(getName()); 
            
            //doDelete();//elimino el agente, si elimino el agente, se crean los hijos in
            Mensajes.enviar(ACLMessage.INFORM, "Emisor", "Hola emisor, necesito respuesta", "COD0102", getAgent());
            ACLMessage msj= blockingReceive();
            System.out.println(msj.getContent());
            //Si quiero el codigo del mensaje
            System.out.println(msj.getConversationId());
            blockingReceive();
        }

        @Override
        public boolean done() {
            return terminado;  
        }
       
    }
    
}
