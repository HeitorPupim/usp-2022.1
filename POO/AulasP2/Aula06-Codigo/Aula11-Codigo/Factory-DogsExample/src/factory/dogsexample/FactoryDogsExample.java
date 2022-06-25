
package factory.dogsexample;


public class FactoryDogsExample {

public static void main(String[] args)
  {
    // create a small dog
    Dog dog = DogFactory.getDog("small");
    dog.speak();

    // create a big dog
    dog = DogFactory.getDog("big");
    dog.speak();

    // create a working dog
    dog = DogFactory.getDog("medium");
    dog.speak();
  }
}
