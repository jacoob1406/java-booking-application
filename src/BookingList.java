import java.io.Serializable;
import java.util.ArrayList;


/**
 * A class containing a list of Booking objects.
 * @author Jakub Lemka
 * @version 1.0
 */

public class BookingList implements Serializable 
{
   
   private ArrayList<Booking> bookings;

   /**
    * No-argument constructor initializing the BookingList.
    */
   public BookingList()
   {
      bookings = new ArrayList<Booking>();
   }

   /**
   * Gets a Booking object from position index from the list. 
   * @param index the position in the list of the Booking object  
   * @return the Booking object at position index if one exists, else null
   */
   public Booking getBooking(int index)
   {
      if (index < bookings.size())
      {
         return bookings.get(index);
      }
      else
      {
         return null;
      }
   }
   

   /**
    * Adds a Booking to the list.
    * @param booking the booking to add to the list
    */ 

   public void addBooking(Booking booking)
   {
      bookings.add(booking);
   }

   /**
    * Removes a Booking from the list.
    * @param booking the booking to be removed from the list
    */ 
   public void removeBooking(Booking Booking)
   {
      bookings.remove(Booking);
   }
   /**
    * Removes a Booking from the list.
    * @param i the index of the booking to be removed from the list
    */ 
   public void removeBooking2(int i)
   {
      bookings.remove(i);
   }


   /**
    * Gets how many Booking objects are in the list.
    * @return the number of Booking objects in the list
    */

   public int getSize()
   {
      return bookings.size();
   }

   /**
    * Gets the number of bookings of the selected employee
    * @param name the name of the chosen employee  
    * @return the number of bookings of the selected employee (just those, when customer showed up)
    */
   public int getNumOfBookings(String name)
   {
      int k = 0;
      for (int i = 0; i < bookings.size(); i++)
      {

         if (name.equals(bookings.get(i).getEmployee().getName()) && bookings.get(i).getShowUp())
         {
            k++;
         }
      }
      return k;
   }

   /**
    * Gets a String representation of the BookingList.
    * @return a String containing information about all Booking objects in the list - each Booking object followed by a new line character    
    */
   public String toString()
   {
      String returnStr = "";

      for (int i = 0; i < bookings.size(); i++)
      {
         returnStr += bookings.get(i) + "\n";
      }
      return returnStr;
   }

}
