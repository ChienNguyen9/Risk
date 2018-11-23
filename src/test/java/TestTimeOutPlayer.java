import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestTimeOutPlayer {

  @Test
  public void ThirtySeconds(){
		Thread threadTimeOut;
    threadTimeOut = new Thread(new TimeoutPlayer(30));
    threadTimeOut.start();
	}

  @Test
  public void getTimeValue(){
    TimeoutPlayer threadTimeOut = new TimeoutPlayer(30);
    System.out.println(threadTimeOut.getTimeLeft());
	}

  @Test
  public void runningFiveSeconds(){
    // Five second until end
    TimeoutPlayer threadTimeOut = new TimeoutPlayer(5);
    threadTimeOut.run();
	}

  @Test
  public void runningNegativeSeconds(){
    // -1 second until end
    TimeoutPlayer threadTimeOut = new TimeoutPlayer(-1);
    threadTimeOut.run();
	}

}
