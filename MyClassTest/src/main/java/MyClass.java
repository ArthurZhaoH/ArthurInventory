public class MyClass {

  private MyDependency dependency;

  public MyClass(MyDependency dependency) {
    this.dependency = dependency;
  }

  public String doSomething() {
    // you don't know what is in here
    dependency.getSomeResult("One",1);
    dependency.getSomeResult("Two",2);
    dependency.getSomeResult("Three",3);
    return null;
  }

}
