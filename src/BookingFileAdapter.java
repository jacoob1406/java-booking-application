import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the bookings file, making it easy to retrieve and store information.
 * @author Jakub Lemka
 * @version 1.0
 */ 

public class BookingFileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * @param fileName the name and path of the file where bookings will be saved and retrieved
    */
   public BookingFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }

   /**
    * Uses the MyFileIO class to retrieve a BookingList object with all bookings.
    * @return a BookingList object with all stored bookings
    */
   public BookingList getAllBookings()
   {
      BookingList bookings = new BookingList();
      try
      {
         bookings = (BookingList) mfio.readObjectFromFile(fileName);
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
      return bookings;
   }
   
   /**
    * Use the MyFileIO class to save some bookings.
    * @param bookings the list of bookings that will be saved
    */   
   public void saveBookings(BookingList bookings)
   {
      try
      {
         mfio.writeToFile(fileName, bookings);
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
   
   
   /**
    * Use the MyFileIO class to retrieve all bookings of a given employee.
    * @param employee the employee to retrieve bookings of
    * @return a BookingList object all bookings of a given employee.
    */
  public BookingList getBookingsByEmployee(String employee)
   {
      BookingList bookings = new BookingList();

      try
      {
         BookingList emplBookings = (BookingList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < emplBookings.getSize(); i++)
         {
            if (emplBookings.getBooking(i).getEmployee().getName().equals(employee))
            {
               bookings.addBooking(emplBookings.getBooking(i));
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

      return bookings;
   }
  
  /**
   * Use the MyFileIO class to add a booking to a BookingList.
   * @param booking the booking that will be added
   */   
  public void addBooking (Booking booking)
  {
     BookingList all = getAllBookings();
     all.addBooking(booking);
     
     try
     {
        mfio.writeToFile(fileName, all);
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
