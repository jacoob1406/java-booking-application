import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * An adapter to the employee file, making it easy to retrieve and store information.
 * @author Jakub Lemka
 * @version 1.0
 */
public class EmployeeFileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * @param fileName the name and path of the file where employees will be saved and retrieved
    */
   public EmployeeFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }

   /**
    * Uses the MyFileIO class to retrieve an EmployeeList object with all Employees.
    * @return an EmployeeList object with all stored employees
    */
   public EmployeeList getAllEmployees()
   {
      EmployeeList employees = new EmployeeList();
      try
      {
         employees = (EmployeeList) mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return employees;
   }
   
   /**
    * Use the MyFileIO class to retrieve an employee with a given name
    * @param name the name to retrieve employees of
    * @return a EmployeeList object an employee with a given name
    */
   public Employee getEmployee(String name)
   {
      EmployeeList employees = new EmployeeList();
      Employee emp = null;
      
      try
      {
         employees = (EmployeeList) mfio.readObjectFromFile(fileName);
     
         for (int i = 0; i < employees.getSize(); i++)
         {
            if(employees.getEmployee(i).getName().equals(name))
            {
               emp = employees.getEmployee(i);
               break;
            }
         }
      
      
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return emp;
   }
   
   
   /**
    * Use the MyFileIO class to save some employees.
    * @param employees the list of employees that will be saved
    */   public void saveEmployees(EmployeeList employees)
   {
      try
      {
         mfio.writeToFile(fileName, employees);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
}
