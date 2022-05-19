package agentes;

import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.Sensores;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agente2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());

    }
    
    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            //System.out.println(getName());
            ACLMessage msj = blockingReceive();

            String idC = msj.getConversationId();

            if (idC.equalsIgnoreCase("COD0102")) {
                try {
                    //System.out.println(msj);
                    Cliente cliente = (Cliente) msj.getContentObject();
                    System.out.println(cliente);
                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(idC.equalsIgnoreCase("COD0302")){
                //System.out.println(msj);
                try {
                    Object[] pagosVentas=(Object[])msj.getContentObject();
                    Pagos pago = (Pagos)pagosVentas[0];
                    Ventas venta= (Ventas)pagosVentas[1];
                    System.out.println(pago);
                    System.out.println(venta);
                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            blockingReceive();
        }

    }

}
