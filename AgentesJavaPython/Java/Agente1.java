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
            
            //Creamos un objeto GUI y lo hacemos visible
            GUIExample1 gui = (GUIExample1)getArguments()[0];
            gui.setVisible(true);
            //Comenzamos a llenar los datos de la GUI desde este agente
            if(gui.isIspressBotonCliente()){//validamos si presiona el boton cliente para poder enviar los datos
                //invocamos el constructor y pasamos los datos recibidos 
                Carro carro = new Carro(Integer.parseInt(gui.getCarro()[0]),Integer.parseInt(gui.getCarro()[1]),Integer.parseInt(gui.getCarro()[2]),
                        Integer.parseInt(gui.getCarro()[3]),Float.parseFloat(gui.getCarro()[4]),
                        Integer.parseInt(gui.getCarro()[5]), Integer.parseInt(gui.getCarro()[6]),
                        Integer.parseInt(gui.getCarro()[7]),Integer.parseInt(gui.getCarro()[8]),
                        Integer.parseInt(gui.getCarro()[9]),Integer.parseInt(gui.getCarro()[10]), 
                        Integer.parseInt(gui.getCarro()[11]), Integer.parseInt(gui.getCarro()[12]), 
                        Integer.parseInt(gui.getCarro()[13]), Integer.parseInt(gui.getCarro()[14]),
                        Integer.parseInt(gui.getCarro()[15]), Integer.parseInt(gui.getCarro()[16]), 
                        Integer.parseInt(gui.getCarro()[17]));
                System.out.println("Enviando mensaje con datos del auto hacia AG2 desde AG1");//Aviso de que se enviarán los datos recibidos de la GUI
                Mensajes.enviarS(ACLMessage.INFORM, "Ag2", carro, "COD0102", getAgent());//en envia el mensaje con los datos de GUI
                gui.setIspressBotonCliente(false);//confirmamos que boton cliente ya no esta presionaado
                ACLMessage acl = blockingReceive();//Se recibe el mensaje para Ag1
                System.out.println("El mensaje enviado desde Ag2 hacia Ag1 ha sido recibido");//Se imprime un mensaje de confirmación
                String mensaje = acl.getContent();//obtenemos el contenido del mensaje
                if(mensaje.equalsIgnoreCase("Activar Datos")){//validamos que el mensaje sea de activación
                    gui.btnGuardarC.setEnabled(true);//se habilita el boton de guardar datos, dado que los datos ya han sido registrados y se puede volver hacer otra predicción
                }
            }
            
            
        }

        @Override
        public boolean done() {
            return terminado; //true = una sola vez; false = ciclico
        }

    }
}
