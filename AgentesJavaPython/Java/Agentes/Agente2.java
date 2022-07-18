
import contenidoSerializado.Carro;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
        

public class Agente2 extends Agent {
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            try {
                
                ACLMessage msj = blockingReceive();//recibe el mensaje del agente de AG1
                String idC = msj.getConversationId();//Obtiene el contenido del mensaje 
                if(idC.equalsIgnoreCase("COD0102")){//valida si el mensaje es del AG1
                    System.out.println("Se ha recibido el mensaje de AG1");//responde en el caso de que la validacion fue correcta
                    Carro carro = (Carro)msj.getContentObject();//creamos un objeto carro para enviar los datos correspondientes
                    System.out.println("Enviando mensaje a AG3 desde AG2");//antes de enviar el mensaje, avisa a donde va a enviar un mensaje
                    Mensajes.enviarS(ACLMessage.INFORM, "Ag3", carro, "COD0203", getAgent());//se envia el mensaje al agente correspondiente con el objeto carro
                }else{
                    if(idC.equalsIgnoreCase("COD0402")){//valida si el mensaje es del AG4
                        System.out.println("Sr ha recibido el mensaje de AG4");//responde que se ha recibido el mensaje
                        String mensaje = msj.getContent();//obtiene el contenido del mensaje
                        if(mensaje.equalsIgnoreCase("Activar Datos")){//Valida que sean los datos activados 
                            System.out.println("Enviando mensaje a AG1 desde AG2");//Avisa que se enviará un mensaje desde AG2 hacia AG3
                            Mensajes.enviar(ACLMessage.INFORM, "Ag1", "Activar Datos", "COD0201", getAgent());//Envia mensaje para activar datos hacia Ag1
                        }
                    }
                }
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
