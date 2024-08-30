package container;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.core.Runtime;



public class ContainerVendeur {
  public static void main(String[] args) throws Exception {
    Runtime runtime = Runtime.instance();
    ProfileImpl profile = new ProfileImpl();
    profile.setParameter(Profile.MAIN_HOST, "localhost");
    AgentContainer container = runtime.createAgentContainer(profile);
    
    AgentController consumerAgent = container.createNewAgent("vendeur", "agents.Vendeur", new Object[]{});
    consumerAgent.start();
  }
}