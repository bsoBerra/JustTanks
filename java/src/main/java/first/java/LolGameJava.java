package first.java;

import first.core.Game;
import playn.core.PlayN;
import playn.java.JavaPlatform;

public class LolGameJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new Game());
  }
}
