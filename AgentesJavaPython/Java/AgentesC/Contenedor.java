
package agentesc;

import agentes.*;//sirve para importar todas las clases del un paquete eje: nombrepaquete.*
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contenedor {
    
    AgentContainer agentContainer;
    
    public void contenedor(){
        jade.core.Runtime runtine = jade.core.Runtime.instance();
        Profile p = new ProfileImpl(null, 1099, null);
        agentContainer = runtine.createMainContainer(p);
        agregarAgentes();
    }
    
    private void agregarAgentes(){
        try {
            Object[] gui = new Object[]{new GUIExample1()};//creamos un objeto GUI
            agentContainer.createNewAgent("Ag1", Agente1.class.getName(), gui).start(); 
            agentContainer.createNewAgent("Ag2", Agente2.class.getName(), null).start();
            agentContainer.createNewAgent("Ag3", Agente3.class.getName(), gui).start();    
            agentContainer.createNewAgent("Ag4", Agente4.class.getName(), gui).start(); 
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void crearHijos(String alias, Object[] conocimiento){
        try {
            agentContainer.createNewAgent(alias, Agente1.class.getName(), conocimiento).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
