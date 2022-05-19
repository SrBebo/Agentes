
package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Agente2 extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
        
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage msj= blockingReceive();
            //System.out.println(msj);
            //si quiero que solo emprima el mensaje puedo poner
            System.out.println(msj.getContent());
            //Si quiero el codigo del mensaje
            System.out.println(msj.getConversationId());
            
            Mensajes.enviar(ACLMessage.INFORM, "Receptor", "Emisor presente, me copia receptor?", "COD0201", getAgent());
            blockingReceive();
        }
    
    
    }
    
    
}
