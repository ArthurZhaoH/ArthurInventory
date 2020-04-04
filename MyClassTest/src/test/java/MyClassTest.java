import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyClassTest {

  private MyDependency myDependency;
  private ArrayList<String> strings = new ArrayList<>();
  private int ints[] = new int[2];
  private int callTimes = 0;

  @Before
  public void setupTest() {
    myDependency = mock(MyDependency.class);
    when(myDependency.getSomeResult(anyString(),anyInt())).thenAnswer(invocation -> {
      Object[] args = invocation.getArguments();
      String paramStr = (String) args[0];
      int paramInt = (int) args[1];
      strings.add(paramStr);
      if(callTimes < 2) {
        ints[callTimes] = paramInt;
      }
      callTimes++;
      // System.out.println("Result= "+paramStr+" , "+paramInt);
      return null;
    });
  }

  @Test
  public void doSomethingTest() {
    MyClass myClass = new MyClass(myDependency);
    myClass.doSomething();
    // Mockito.verify(myDependency,Mockito.never()).getSomeResult(anyString(),anyInt());
    if(callTimes == 0) {
      System.out.println("******************************");
      System.out.println("MyClass.doSomething Test Results:");
      System.out.println("Number of times MyDependency.getSomeResult was called: 0");
      System.out.println("String parameter given to first MyDependency.getSomeResult call (if any): ");
      System.out.println("String parameter given to second MyDependency.getSomeResult call (if any): ");
      System.out.println("int parameter given to first MyDependency.getSomeResult call (if any): ");
      System.out.println("int parameter given to second MyDependency.getSomeResult call (if any): ");
      System.out.println("******************************");
    } else {
      System.out.println("******************************");
      System.out.println("MyClass.doSomething Test Results:");
      System.out.println("Number of times MyDependency.getSomeResult was called: " + callTimes);
      System.out.println("String parameter given to first MyDependency.getSomeResult call (if any): " + strings.get(0));
      System.out.println("String parameter given to second MyDependency.getSomeResult call (if any): " + strings.get(1));
      System.out.println("int parameter given to first MyDependency.getSomeResult call (if any): " + ints[0]);
      System.out.println("int parameter given to second MyDependency.getSomeResult call (if any): " + ints[1]);
      System.out.println("******************************");
    }
  }


}
