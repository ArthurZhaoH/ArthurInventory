public class MyDependencyImpl {

  public String getSomeResult(String paramStr, int paramInt) {
    return "the contents of this string are irrelevant, but if it's null MyClass.doSomething will fail. Was sent: '" + paramStr + "', " + paramInt;
  }

}
