package agentes;

import agentesC.Contenedor;
import contenidoSerializado.Cliente;
import contenidoSerializado.Sensores;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente1 extends Agent {

    @Override
    protected void setup() {

        addBehaviour(new Comportamiento());
        System.out.println("Se muere receptor");
    }

    @Override
    protected void takeDown() {//esta accion la hace antes de morir, solo si muere
        // Contenedor c = (Contenedor)getArguments()[0];
        //int i = Integer.parseInt(getArguments()[1].toString());
        //i++;
        //c.crearHijos("AgenteHijo"+i, new Object[]{c, i});//este es otro aparte

    }

    class Comportamiento extends Behaviour {

        boolean terminado = false;

        @Override
        public void action() {
            System.out.println(getName());

            Cliente cliente = new Cliente("Fabricio", "Lope", "tu casa", "09841056", "lco@blabla.com", "Quito", "Ecuador", 1, 2,
                    170170, 15, 500);
            Mensajes.enviar(ACLMessage.INFORM, "Informacion", cliente, "COD0102", getAgent());
            ACLMessage msj = blockingReceive();
            System.out.println(msj.getContent());
            System.out.println(msj.getConversationId());
            blockingReceive();

        }

        @Override
        public boolean done() {
            return terminado;
        }

    }

}
