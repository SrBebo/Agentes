package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Mensajes {
    public static  void enviar(int tipo, String receptor, Serializable object, String codigoConversacionID,
            Agent emisor){//metodo que envia el msg, se puede llamar en cualquier agente
        ACLMessage acl=new ACLMessage(tipo);
        
        AID aid = new AID();//identificador de agente
        aid.setLocalName(receptor);
        
        
        acl.addReceiver(aid);//agente que recibe
        acl.setSender(emisor.getAID());//agente que envia
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        try {
            
            acl.setContentObject(object);//se envia el objeto serializado
        } catch (IOException ex) {
            Logger.getLogger(Mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        acl.setConversationId(codigoConversacionID);
        
        
        emisor.send(acl);
    }
    
    
    
    
    
}
