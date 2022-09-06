package core.common;

import io.cucumber.java.After;

public class Hooks {
    @After
    public void beforeScenario()  {
      System.out.print("Closing connection.");
      
    }

}

