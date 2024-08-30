package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.ControllerException;

public class Acheteurs extends Agent {
    private String name;
    private double euroPrice = 640;
    private double dollarPrice = 590;

    @Override
    protected void setup() {
    	System.out.println("Initialisation de l'acheteur: "+this.getAID().getName());


        addBehaviour(new CyclicBehaviour() {
        	
            @Override
            public void action() {
            	
            	MessageTemplate messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            	ACLMessage aclMessage = receive(messageTemplate);
            	
                 if(aclMessage!=null) {
                	 System.out.println("Client "+aclMessage.getSender().getName());
                	 System.out.println("Message "+aclMessage.getContent());
                	 
                	 
                	 ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
                	 reply.addReceiver(aclMessage.getSender());
                	 reply.setContent("Mon prix est: 600fr l'Euro");
                	 send(reply);

                      } else block();
                 }
            });
        }
    
    
    @Override
    protected void beforeMove() {
    	try {
			System.out.println("Migration de l'acheteur: "+this.getAID().getName()+" dans le conteneur "
    	            +this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @Override
    protected void afterMove() {
    	try {
			System.out.println("Arrivé de l'acheteur: "+this.getAID().getName()+" dans le conteneur "
    	               +this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    protected void takeDown() {
    	System.out.println("Destruction de l'acheur "+this.getAID().getName());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
