
package agentes;



import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;


public class Agente4 extends Agent {
    
    @Override
    protected void setup(){ 
        addBehaviour(new Comportamiento());  
    }
    
   
    
    
    class Comportamiento extends Behaviour{
        boolean terminado=true;
        @Override
        public void action() {
            System.out.println(getName()); 
            
            ACLMessage msj= blockingReceive();
            String idC=msj.getConversationId();
       
            if(idC.equalsIgnoreCase("COD0204")){
                Mensajes.enviar(ACLMessage.INFORM, "Emisor", "Soy el agente 4", "COD0402", getAgent());
                System.out.println(msj.getContent());
                System.out.println(msj.getConversationId());
                System.out.println("");
            }
            blockingReceive();
        }

        @Override
        public boolean done() {
            return terminado;  
        }
       
    }
    
}

