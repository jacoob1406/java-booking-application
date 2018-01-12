import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Treatment objects.
 * @author Jakub Lemka
 * @version 1.0
 */
public class TreatmentList implements Serializable
{

   private ArrayList<Treatment> treatments;

   /**
    * No-argument constructor initializing the TreatmentList.
    */
   public TreatmentList()
   {
      treatments = new ArrayList<Treatment>();
   }

   /**
   * Gets a Treatment object from position index from the list. 
   * @param index the position in the list of the Treatment object  
   * @return the Treatment object at position index if one exists, else null
   */
   public Treatment getTreatment(int index)
   {
      if (index < treatments.size())
      {
         return treatments.get(index);
      }
      else
      {
         return null;
      }
   }

   /**
    * Adds a Treatment to the list.
    * @param treatment the treatment to add to the list
    */ 

   public void addTreatment(Treatment treatment)
   {
      treatments.add(treatment);
   }
   /**
    * Removes a Treatment from the list.
    * @param treatment the treatment to removed from the list
    */ 
   public void removeTreatment(Treatment treatment)
   {
      treatments.remove(treatment);
   }

   /**
    * Gets how many Treatment objects are in the list.
    * @return the number of Treatment objects in the list
    */

   public int getSize()
   {
      return treatments.size();
   }

   /**
    * Gets a String representation of the TreatmentList.
    * @return a String containing information about all Treatment objects in the list - each Treatment object followed by a new line character    
    */
   public String toString()
   {
      String returnStr = "";

      for (int i = 0; i < treatments.size(); i++)
      {
         returnStr += treatments.get(i) + "\n";
      }
      return returnStr;
   }

}
