import java.io.Serializable;
import java.util.ArrayList;


/**
 * A class containing a list of Employee objects.
 * @author Jakub Lemka
 * @version 1.0
 */
public class EmployeeList implements Serializable
{


   private ArrayList<Employee> Employees;

   /**
    * No-argument constructor initializing the EmployeeList.
    */
   public EmployeeList()
   {
      Employees = new ArrayList<Employee>();
   }

   /**
   * Gets a Employee object from position index from the list. 
   * @param index the position in the list of the Employee object  
   * @return the Employee object at position index if one exists, else null
   */
   public Employee getEmployee(int index)
   {
      if (index < Employees.size())
      {
         return Employees.get(index);
      }
      else
      {
         return null;
      }
   }


   /**
    * Adds an Employee to the list.
    * @param Employee the employee to add to the list
    */ 
   public void addEmployee(Employee Employee)
   {
      Employees.add(Employee);
   }

   /**
    * Removes an Employee to the list.
    * @param Employee the employee to be removed from the list
    */ 
   public void removeEmployee(Employee Employee)
   {
      Employees.remove(Employee);
   }

   /**
    * Gets how many Employee objects are in the list.
    * @return the number of Employee objects in the list
    */

   public int getSize()
   {
      return Employees.size();
   }

   /**
    * Gets a String representation of the EmployeeList.
    * @return a String containing information about all Employee objects in the list - each Employee object followed by a new line character    
    */
   public String toString()
   {
      String returnStr = "";

      for (int i = 0; i < Employees.size(); i++)
      {
         returnStr += Employees.get(i) + "\n";
      }
      return returnStr;
   }

}
