package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ControllerException;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.MessageTemplate;

public class Vendeur extends Agent {
	
	
	
	
    @Override
    protected void setup() {
    	System.out.println("Initialisation de l'acheteur: "+this.getAID().getName());
    	
    	
    	
    	
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {

                // Envoyer le message aux deux acheteurs
            	
                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
            	message.addReceiver(new AID ("Buyer1", AID.ISLOCALNAME));
            	message.setContent("Je veut Echanger mes Euro");
            	send(message);
            }});
    	
    	
        addBehaviour(new CyclicBehaviour() {
        	
            @Override
            public void action() {
            	
            	MessageTemplate messageTemplate1 = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            	ACLMessage aclMessage1 = receive(messageTemplate1);
            	
                 if(aclMessage1!=null) {
                	 System.out.println("Acheteur: "+aclMessage1.getSender().getName());
                	 System.out.println("Message: "+aclMessage1.getContent());

                      } else block();
                 }
            });
    }

    
    @Override
    protected void beforeMove() {
    	try {
			System.out.println("Migration du vendeur: "+this.getAID().getName()+" dans le conteneur "
    	          +this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @Override
    protected void afterMove() {
    	try {
			System.out.println("Arrivé du vendeur: "+this.getAID().getName()+" dans le conteneur "
    	            +this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    protected void takeDown() {
    	System.out.println("Destruction du vendeur "+this.getAID().getName());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
