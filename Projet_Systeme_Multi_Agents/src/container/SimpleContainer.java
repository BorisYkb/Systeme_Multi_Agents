package container;


import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class SimpleContainer {
  public static void main(String[] args) throws Exception {
    Runtime runtime = Runtime.instance();
    ProfileImpl profile = new ProfileImpl();
    profile.setParameter(Profile.MAIN_HOST, "localhost");
    AgentContainer container1 = runtime.createAgentContainer(profile);
    
    
    AgentController buyerAgent1 = container1.createNewAgent("Buyer1", "agents.Vendeur", new Object[]{"Buyer1", 640, 590});
    buyerAgent1.start();
  }
}
