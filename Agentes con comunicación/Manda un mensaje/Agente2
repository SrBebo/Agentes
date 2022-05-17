
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
            System.out.println(msj);
            blockingReceive();
        }
    
    
    }
    
    
}
