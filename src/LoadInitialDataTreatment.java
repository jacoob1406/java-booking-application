import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * A simple program used for importing data. It creates a TreatmentList object, adds there couple of treatments 
 * and saves it as a binary file
 * @author Jakub Lemka
 * @version 1.0
 */ 
public class LoadInitialDataTreatment
{
   public static void main(String[] args)
   {
      TreatmentList treatments = new TreatmentList();
  
      Treatment t1 = new Treatment("Women's haircut", 3);
      treatments.addTreatment(t1);
      Treatment t2 = new Treatment("Men's haircut", 1);
      treatments.addTreatment(t2);
      Treatment t3 = new Treatment("Children's haircut", 1);
      treatments.addTreatment(t3);
      Treatment t4 = new Treatment("Women's haircut special", 4);
      treatments.addTreatment(t4);
      Treatment t5 = new Treatment("Permanent curl", 4);
      treatments.addTreatment(t5);
      Treatment t6 = new Treatment("Dye", 4);
      treatments.addTreatment(t6);
      Treatment t7 = new Treatment("Make-up mini", 2);
      treatments.addTreatment(t7);
      Treatment t8 = new Treatment("Make-up full", 4);
      treatments.addTreatment(t8);

      
      MyFileIO mfio = new MyFileIO();
      
      try
      {
         mfio.writeToFile("treatments.bin", treatments);
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
