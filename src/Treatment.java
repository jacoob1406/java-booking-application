import java.io.Serializable;

/**
 * A class representing a treatment with its name and number of modules
 * @author Jakub Lemka
 * @version 1.0
 */ 
public class Treatment implements Serializable
{

   private String workToDo;
   private int howManyModules;

   /**
    * Two-argument constructor.
    * @param work to do the name of the treatment
    * @param howManyModules the number of modules that the treatment lasts
    */
   public Treatment(String workToDo, int howManyModules)
   {
      this.workToDo = workToDo;
      this.howManyModules = howManyModules;
   }

   /**
    * Gets the treatment's name
    * @return the treatment's name
    */
   public String getTreatment()
   {
      return workToDo;
   }
   /**
    * Gets the number of modules that the treatment lasts
    * @return the number of modules that the treatment lasts
    */
   public int getHowManyModules()
   {
      return howManyModules;
   }

   /**
    * Returns a string representation of the treatment.
    * @return a string representation of the treatment - just its name
    */
   public String toString()
   {
      return workToDo;
   }

   /**
    * Compares name of the treatment and number of modules
    * @param obj the object to compare with
    * @return true if the given object is equal to this treatment
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Treatment))
      {
         return false;
      }
      Treatment other = (Treatment) obj;
      return workToDo.equals(other.workToDo) && howManyModules == other.howManyModules;
   }

}
