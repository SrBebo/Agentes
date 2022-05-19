
package agentesC;

import agentes.Agente1;
import agentes.Agente2;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OMEN
 */
public class Contenedor {
    AgentContainer agentContainer; 
    public void contenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile p = new ProfileImpl(null, 1099, " en Contenedor principal" );
        agentContainer = runtime.createMainContainer(p);//metodo para crear un contenedor principal, contenedor de agentes
        //AgentContainer me sirve para crear nuevos agentes al contenedor  
        agregarAgentes();
    }
    private void agregarAgentes(){
        
        try {
            agentContainer.createNewAgent("Receptor", Agente1.class.getName(), new Object[]{this,1 }).start();
            if(!"Receptor".equals(Agente1.class.getName())){
                //los print, apareceran primero ya que el proceso es mas rapido que crear el agente
                //despues de los prints aparecera los datos del agente
                System.out.println("Agente receptor ha sido creado, agente emisor en proceso");
                agentContainer.createNewAgent("Emisor", Agente2.class.getName(), null).start(); 
                System.out.println("Agente emisor ha sido creado, agente emisor en proceso");
            }
            
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void crearHijos(String alias, Object [] conocimiento){
        try {
            agentContainer.createNewAgent(alias, Agente1.class.getName(), conocimiento).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
