import java.io.Serializable;

public class Booking implements Serializable
{
   /**
    * A class creating Booking objects
    * @author Jakub Lemka
    * @version 1.0
    */
   private Date dateOfBooking;
   private Employee employee;
   private Treatment treatment;
   private long customerNum;
   private boolean showUp;

   /**
    * Five argument constructor.
    * @param dateOfBooking the date of the booking (type Date)
    * @param employee the employees name (type Employee)
    * @param treatment the treatment (type Treatment)
    * @param customerNum the customer number
    * @param showUp the info if the client showed up as a boolean value
    */
   public Booking(Date dateOfBooking, Employee employee, Treatment treatment,
         int customerNum)
   {
      this.dateOfBooking = dateOfBooking;
      this.employee = employee;
      this.treatment = treatment;
      this.customerNum = customerNum;
      this.showUp = false;
   }

  /**
   * Gets the date
   * @return the date of the booking
   */
   public Date getDate()
   {
      return dateOfBooking;
   }
   
   /**
    * Gets the finish hour of the booking
    * @return the finish hour of the booking
    */
   public Date getFinishDate()
   {
      Date d2 = new Date(dateOfBooking.getDay(), dateOfBooking.getMonth(), dateOfBooking.getYear(), dateOfBooking.getHour(), dateOfBooking.getMinute());
      d2.addMinutes(30 * treatment.getHowManyModules());
      return d2;
   }
/**
 * gets the employee
 * @return the employee
 */
   public Employee getEmployee()
   {
      return employee;
   }
   
   /**
    * gets the customer number
    * @return the customer number
    */

   public long getCustomerNum()
   {
      return customerNum;
   }

   /**
    * gets the treatment
    * @return the treatment
    */
   public Treatment getTreatment()
   {
      return treatment;
   }
   
   /**
    * gets the show up value
    * @return the show up value
    */

   public boolean getShowUp()
   {
      return showUp;
   }

   /**
    * sets the show up value to true
    */
   public void showUp()
   {
      showUp = true;
   }
   

/**
 * Returns a string representation of the booking
 * @return a string representation of the booking
 */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Booking))
      {
         return false;
      }

      Booking other = (Booking) obj;
      return dateOfBooking.equals(other.dateOfBooking)
            && employee.equals(other.employee)
            && treatment.equals(other.treatment)
            && customerNum == (other.customerNum);
   }

   /**
    * Compares employee, customer number, date of booking, the treatment and the show up value of two bookings.
    * @param obj the object to compare with
    * @return true if the given object is equal to this bookings
    */
   public String toString()
   {

      return employee + "\n" + "Customer's number: " + customerNum + "\n"
            + dateOfBooking + "\n" + treatment + "\n" + "show up: " + showUp;

   }
}
