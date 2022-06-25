
package factory.dogsexample;

class DogFactory
{
  public static Dog getDog(String criteria)
  {
    if ( criteria.equals("small") )
      return new Poodle();
    else if ( criteria.equals("big") )
      return new Rottweiler();
    else if ( criteria.equals("medium") )
      return new SiberianHusky();
    
    /*Runtime exception - nao exige tratamento preventivo*/
    throw new IllegalArgumentException("No such dog size");
  }
}