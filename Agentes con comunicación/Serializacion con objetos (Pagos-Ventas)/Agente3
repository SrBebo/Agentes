
package agentes;

import agentesC.Contenedor;
import contenidoSerializado.Pagos;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Agente3 extends Agent {
    
    @Override
    protected void setup(){
         
        addBehaviour(new Comportamiento());
        
    }
    
    @Override
    protected void takeDown(){//esta accion la hace antes de morir, solo si muere
       // Contenedor c = (Contenedor)getArguments()[0];
       //int i = Integer.parseInt(getArguments()[1].toString());
       //i++;
       //c.crearHijos("AgenteHijo"+i, new Object[]{c, i});//este es otro aparte
        
    }
    
    
    class Comportamiento extends Behaviour{
        boolean terminado=false;
        @Override
        public void action() {
            System.out.println(getName()); 
            //para la GUI
            /*Pagos [] p=new Pagos [] {GUI};
            Ventas [] v= new Ventas []{GUI};
            
            PagosVentas pv =
            Mensajes.enviar(ACLMessage.INFORM, "Informacion", pv, "COD0302", getAgent());
            */
            Object[]pagosVentas=new Object[]{new Pagos(1, 1, 100, "2022-03-15"),
                new Ventas(1, 1, 20221, 100, true, "2022-03-48", "Producto 1 Descripcion")};
            
            Mensajes.enviar(ACLMessage.INFORM, "Informacion", pagosVentas, "COD0302", getAgent());
            ACLMessage acl= blockingReceive();
            //System.out.println(acl.getContent());
            //blockingReceive();
        }

        @Override
        public boolean done() {
            return terminado;  
        }
       
    }
    
}
