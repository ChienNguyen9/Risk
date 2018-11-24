import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestBinaryObserver {

  @Test
  public void testPositiveState() {
    Subject subject = new Subject();
    subject.setState(1);
    subject.getState();
    subject.notifyAllObservers();

    BinaryObserver binaryObserver = new BinaryObserver(subject);
    binaryObserver.update();
  }

  @Test
  public void testNegativeState() {
    Subject subject = new Subject();
    subject.setState(-1);
    subject.getState();
    subject.notifyAllObservers();

    BinaryObserver binaryObserver = new BinaryObserver(subject);
    binaryObserver.update();
  }


}
