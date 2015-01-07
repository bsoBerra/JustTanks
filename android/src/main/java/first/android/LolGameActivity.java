package first.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import first.core.LolGame;

public class LolGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new LolGame());
  }
}
