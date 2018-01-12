import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the treatments file, making it easy to retrieve and store information.
 * @author Jakub Lemka
 * @version 1.0
 */ 
public class TreatmentFileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * @param fileName the name and path of the file where treatments will be saved and retrieved
    */
   public TreatmentFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }

   /**
    * Uses the MyFileIO class to retrieve a TreatmentList object with all treatments.
    * @return a TreatmentList object with all stored treatments
    */
   public TreatmentList getAllTreatments()
   {
      TreatmentList treatments = new TreatmentList();
      try
      {
         treatments = (TreatmentList) mfio.readObjectFromFile(fileName);
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
      return treatments;
   }
   
   /**
    * Use the MyFileIO class to save some treatments.
    * @param treatments the list of treatments that will be saved
    */   
   public void saveTreatments(TreatmentList treatments)
   {
      try
      {
         mfio.writeToFile(fileName, treatments);
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
