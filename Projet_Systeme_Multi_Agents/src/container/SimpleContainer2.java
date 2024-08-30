package container;


import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class SimpleContainer2 {
  public static void main(String[] args) throws Exception {
    Runtime runtime = Runtime.instance();
    ProfileImpl profile = new ProfileImpl();
    profile.setParameter(Profile.MAIN_HOST, "localhost");
    AgentContainer container2 = runtime.createAgentContainer(profile);
    
    AgentController buyerAgent2 = container2.createNewAgent("Buyer2", "agents.Vendeur", new Object[]{"Buyer2", 650, 595});
    buyerAgent2.start();
  }
}
