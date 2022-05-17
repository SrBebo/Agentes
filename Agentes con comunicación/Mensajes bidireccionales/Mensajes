
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;


public class Mensajes {
    public static  void enviar(int tipo, String receptor, String contenidoMSJ, String codigoConversacionID,
            Agent emisor){//metodo que envia el msg, se puede llamar en cualquier agente
        ACLMessage acl=new ACLMessage(tipo);
        
        AID aid = new AID();//identificador de agente
        aid.setLocalName(receptor);
        
        
        acl.addReceiver(aid);//agente que recibe
        acl.setSender(emisor.getAID());//agente que envia
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setContent(contenidoMSJ);
        acl.setConversationId(codigoConversacionID);
        
        
        emisor.send(acl);
    }
    
    
    
    
    
}
