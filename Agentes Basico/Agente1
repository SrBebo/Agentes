
package agentesC;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;


public class Agente1 extends Agent {
    
    @Override
    protected void setup(){//el agente siempre va a ejecutar esta parte primero, siempre, sin esto no se hará nada
        //System.out.println(getName());
        //otra forma de imprimir datos del agente1
        System.out.println(getLocalName()); 
 
        //Si deseo que haga las acciones que puse abajo implemento las siguientes lineas
        addBehaviour(new Comportamiento());
    }
    
    
//se van todos los comportamientos o lo que haga el agente
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            //acciones que va hacer el agente1
            System.out.println("Accion1");
            blockingReceive();//para bloquear agente
        }
    
    }
    
}
