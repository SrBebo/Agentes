import agentesc.GUIExample1;
import contenidoSerializado.Carro;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;


public class Agente1 extends Agent {
    
    int contadorCliente = 0;
    
    @Override
    protected void setup() { 
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour {

        boolean terminado = false;

        @Override
        public void action() {
            
            
            GUIExample1 gui = (GUIExample1)getArguments()[0];
            gui.setVisible(true);
            
            if(gui.isIspressBotonCliente()){

                Carro carro = new Carro(Integer.parseInt(gui.getCarro()[0]),Integer.parseInt(gui.getCarro()[1]),Integer.parseInt(gui.getCarro()[2]),
                        Integer.parseInt(gui.getCarro()[3]),Float.parseFloat(gui.getCarro()[4]),
                        Integer.parseInt(gui.getCarro()[5]), Integer.parseInt(gui.getCarro()[6]),
                        Integer.parseInt(gui.getCarro()[7]),Integer.parseInt(gui.getCarro()[8]),
                        Integer.parseInt(gui.getCarro()[9]),Integer.parseInt(gui.getCarro()[10]), 
                        Integer.parseInt(gui.getCarro()[11]), Integer.parseInt(gui.getCarro()[12]), 
                        Integer.parseInt(gui.getCarro()[13]), Integer.parseInt(gui.getCarro()[14]),
                        Integer.parseInt(gui.getCarro()[15]), Integer.parseInt(gui.getCarro()[16]), 
                        Integer.parseInt(gui.getCarro()[17]));
                System.out.println("Se envia msj a AG2 desde AG1");
                Mensajes.enviarS(ACLMessage.INFORM, "Ag2", carro, "COD0102", getAgent());
                gui.setIspressBotonCliente(false);
                ACLMessage acl = blockingReceive();
                System.out.println("Se ha recibido el mensaje desde AG2");
                String mensaje = acl.getContent();
                if(mensaje.equalsIgnoreCase("Activar Datos"))
                    gui.btnGuardarC.setEnabled(true);
            }
            
            
        }

        @Override
        public boolean done() {
            return terminado; //true = una sola vez; false = ciclico
        }

    }
}
