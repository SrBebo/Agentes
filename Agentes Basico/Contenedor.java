
package agentes;

import agentesC.Agente1;
import agentesC.Agente2;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            agentContainer.createNewAgent("Receptor", Agente1.class.getName(), null);
            //start() sin esto, el agente se crea pero no hace nada
            agentContainer.createNewAgent("Emisor", Agente2.class.getName(), null).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
