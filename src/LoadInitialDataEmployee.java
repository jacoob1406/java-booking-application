import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for importing data. It creates a EmployeeList object, adds there five employees 
 * and saves it as a binary file
 * @author Jakub Lemka
 * @version 1.0
 */ 
public class LoadInitialDataEmployee
{
   public static void main(String[] args)
   {
      EmployeeList employees = new EmployeeList();
  
      Employee e1 = new Employee("Else");
      employees.addEmployee(e1);
      Employee e2 = new Employee("Karin");
      employees.addEmployee(e2);
      Employee e3 = new Employee("Anette");
      employees.addEmployee(e3);
      Employee e4 = new Employee("Helle");
      employees.addEmployee(e4);
      Employee e5 = new Employee("Anni");
      employees.addEmployee(e5);
  
      
     
     
      MyFileIO mfio = new MyFileIO();
      
      try
      {
         mfio.writeToFile("employees.bin", employees);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error opening file ");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file ");
      }
      
      System.out.println("Done");
   }
}
