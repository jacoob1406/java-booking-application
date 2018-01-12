import java.io.Serializable;

/**
 * A class representing an employee with a first name
 * @author Jakub Lemka
 * @version 1.0
 */ 

public class Employee implements Serializable
{

   private String name;

   /**
    * One-argument constructor.
    * @param name the employee's name
    */

   public Employee(String name)
   {
      this.name = name;
   }

   /**
    * Gets the employee's name.
    * @return the employee's name
    */
   public String getName()
   {
      return name;
   }
   /**
    * Sets the employee's name.
    * @param name what the employee's name will be set to
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Compares name of two employees
    * @param obj the object to compare with
    * @return true if the given object is equal to this employee
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Employee))
      {
         return false;
      }

      Employee other = (Employee) obj;
      return name.equals(other.name);
   }

   /**
    * Returns a string representation of the employee
    * @return a string representation of the employee 
    */
   public String toString()
   {
      return "" + name;
   }
}
