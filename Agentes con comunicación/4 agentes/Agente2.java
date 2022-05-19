
package agentes;


import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Agente2 extends Agent{
    int contador=0;
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
                Mensajes.enviar(ACLMessage.INFORM, "Receptor", "Emisor presente, me copia receptor?", "COD0201", getAgent());
                System.out.println(msj.getContent());
                System.out.println(msj.getConversationId());
                System.out.println("");
                contador++;
                if(contador == 2){ 
                    Mensajes.enviar(ACLMessage.INFORM, "Agente4", "Se envio mensaje agente 4", "COD0204", getAgent());
                }
            }
            
            if(idC.equalsIgnoreCase("COD0302")){    
                System.out.println(msj.getContent());
                System.out.println(msj.getConversationId());
                Mensajes.enviar(ACLMessage.INFORM, "Agente3", "Confirmo mensaje agente3", "COD0203", getAgent());
                System.out.println("");
                contador++;
                if(contador == 2){ 
                    Mensajes.enviar(ACLMessage.INFORM, "Agente4", "Se envio mensaje agente 4", "COD0204", getAgent());
                }
            }
           
            System.out.println("");
            if(idC.equalsIgnoreCase("COD0402")){
                System.out.println(msj.getContent());
                System.out.println(msj.getConversationId());
                System.out.println("");
                contador=0;
            }
            
            
            
            System.out.println("");
            //blockingReceive();
            
        }
    }  
}
