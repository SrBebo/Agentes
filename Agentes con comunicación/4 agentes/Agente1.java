
package agentes;


import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import jade.lang.acl.ACLMessage;


public class Agente1 extends Agent {
    
    @Override
    protected void setup(){
         
        addBehaviour(new Comportamiento());
       
    }
    
   
   
    class Comportamiento extends Behaviour{
        boolean terminado=true;
        @Override
        public void action() {
            System.out.println(getName()); 
            
            //elimino el agente, si elimino el agente, se crean los hijos in
            Mensajes.enviar(ACLMessage.INFORM, "Emisor", "Hola emisor, necesito respuesta", "COD0102", getAgent());
            ACLMessage msj= blockingReceive();
            System.out.println(msj.getContent());
            //Si quiero el codigo del mensaje
            System.out.println(msj.getConversationId());
            //blockingReceive();
           
        }

        @Override
        public boolean done() {
            return terminado;  
        }
       
    }
    
}
