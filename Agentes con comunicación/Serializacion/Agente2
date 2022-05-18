package agentes;

import contenidoSerializado.Sensores;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
            
            String idC=msj.getConversationId();
            
            
            if(idC.equalsIgnoreCase("COD0102")){
                try {
                    System.out.println(msj);
                    Sensores s= (Sensores)msj.getContentObject();
                    System.out.println(s.getMsjag3()+ "  ----------   "+ s.getMsjag1());
                    
                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            blockingReceive();
        }
    
    
    }
    
    
}
