import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A class representing a date with a day, month, year, hour and minute
 * @author Jakub Lemka
 * @version 1.0
 */
public class Date implements Serializable
{

   private int day;
   private int month;
   private int year;
   private int hour;
   private int minute;

   GregorianCalendar calendar = new GregorianCalendar();

   /**
    * Five-argument constructor.
    * 
    * @param day the day of the date
    * @param month the month of the date
    * @param year the year of the date
    * @param hour the hour of the date
    * @param minute the minute of the date
    */
   public Date(int day, int month, int year, int hour, int minute)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.hour = hour;
      this.minute = minute;
   }

   /**
    * Sets the day of the date
    * @param day what the date's day will be set to
    */
   public void setDay(int day)
   {
      this.day = day;
   }

   /**
    * Sets the month of the date
    * @param month what the date's month will be set to
    */
   public void setMonth(int month)
   {
      this.month = month;
   }

   /**
    * Sets the year of the date
    * @param year what the date's year will be set to
    */
   public void setYear(int year)
   {
      this.year = year;
   }

   /**
    * Sets the hour of the date
    * @param hourwhat the date's hour will be set to
    */
   public void setHour(int hour)
   {
      this.hour = hour;
   }

   /**
    * Sets the minute of the date
    * @param minute what the date's minute will be set to
    */
   public void setMinute(int minute)
   {
      this.minute = minute;
   }

   /**
    * Sets the whole date
    * 
    * @param day what the date's day will be set to
    * @param month what the date's month will be set to
    * @param year  what the date's year will be set to
    * @param hour what the date's hour will be set to
    * @param minute what the date's minute will be set to
    */
   public void setDate(int day, int month, int year, int hour, int minute) // Maybe

   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.hour = hour;
      this.minute = minute;
   }

   /**
    * Gets the day of the date
    * 
    * @return the day of the date
    */
   public int getDay()
   {
      return day;
   }

   /**
    * Gets the month of the date
    * 
    * @return the month of the date
    */
   public int getMonth()
   {
      return month;
   }

   /**
    * Gets the year of the date
    * 
    * @return the year of the date
    */
   public int getYear()
   {
      return year;
   }

   /**
    * Gets the hour of the date
    * 
    * @return the hour of the date
    */
   public int getHour()
   {
      return hour;
   }

   /**
    * Gets the minute of the date
    * 
    * @return the minute of the date
    */
   public int getMinute()
   {
      return minute;
   }

   /**
    * Gets the full date as a String
    * 
    * @return the full date as a String
    */
   public String getDate()
   {
      return day + "/" + month + "/" + year;
   }

   /**
    * Gets the full hour as a String
    * 
    * @return the full hour as a String
    */
   public String getFullHour()
   {

      String str = "";

      if (hour < 10)
      {
         str += "0";
      }
      str += hour + ":";

      if (minute < 10)
      {
         str += "0";
      }
      str += minute;

      return str;
   }

   /**
    * static method to get actual date and time
    * 
    * @return the current day and time
    */
   public static Date today() // should it be void?
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int day = currentDate.get(GregorianCalendar.DATE);
      int month = currentDate.get(GregorianCalendar.MONTH) + 1;
      int year = currentDate.get(GregorianCalendar.YEAR);
      int hour = currentDate.get(GregorianCalendar.HOUR_OF_DAY);
      int minute = currentDate.get(GregorianCalendar.MINUTE);
      return new Date(day, month, year, hour, minute);
   }

   /**
    * Compares the date with the today's date
    * 
    * @return true if the given object is from the future (higher that today's
    *         date)
    */
   public boolean isFuture()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int dayT = currentDate.get(GregorianCalendar.DATE);
      int monthT = currentDate.get(GregorianCalendar.MONTH) + 1;
      int yearT = currentDate.get(GregorianCalendar.YEAR);
      int hourT = currentDate.get(GregorianCalendar.HOUR_OF_DAY);
      int minuteT = currentDate.get(GregorianCalendar.MINUTE);

      if (yearT < year)
      {
         return true;
      }
      else if (yearT == year && monthT < month)
      {
         return true;
      }
      else if (yearT == year && monthT == month && dayT < day)
      {
         return true;
      }
      else if (yearT == year && monthT == month && dayT == day && hourT < hour)
      {
         return true;
      }
      else if (yearT == year && monthT == month && dayT == day && hourT == hour
            && minuteT < minute)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   /**
    * Compares the date with the given as an argument date
    * 
    * @param date2
    *           is the second date to be compared one
    * @return true if the given date is is before the other date ("lower")
    */
   public boolean isBefore(Date date2)
   {
      if (year < date2.year)
         return true;
      else if (year == date2.year && month < date2.month)
         return true;
      else if (year == date2.year && month == date2.month && day < date2.day)
         return true;
      else if (year == date2.year && month == date2.month && day == date2.day
            && hour < date2.hour)
         return true;
      else if (year == date2.year && month == date2.month && day == date2.day
            && hour == date2.hour && minute < date2.minute)
         return true;
      else
         return false;
   }

   /**
    * Adds minutes to the date.
    * @param minutes ads minutes to the date
    */
   public void addMinutes(int minutes)
   {

      int h = minutes / 60;
      int m = minutes - (h * 60);

      hour += h;

      if (minute == 30 && m == 30)
      {
         minute = 0;
         hour++;
      }
      else
      {
         minute += m;
      }
   }
   /**
    * Gets the name of the day of the week.
    * @return the name of the day of the week as a String
    */
   public String dayOfWeek()
   {

      int m;
      int y;

      if (month == 1)
      {
         m = 13;
         y = year - 1;
      }
      else if (month == 2)
      {
         m = 14;
         y = year - 1;
      }
      else
      {
         m = month;
         y = year;
      }
      int k = y % 100;
      int j = y / 100;
      int a = 13 * (m + 1);

      if ((day + a / 5 + k + k / 4 + j / 4 + 5 * j) % 7 == 0)
         return "Saturday";
      else if ((day + a / 5 + k + k / 4 + j / 4 + 5 * j) % 7 == 1)
         return "Sunday";
      else if ((day + a / 5 + k + k / 4 + j / 4 + 5 * j) % 7 == 2)
         return "Monday";
      else if ((day + a / 5 + k + k / 4 + j / 4 + 5 * j) % 7 == 3)
         return "Tuesday";
      else if ((day + a / 5 + k + k / 4 + j / 4 + 5 * j) % 7 == 4)
         return "Wednesday";
      else if ((day + a / 5 + k + k / 4 + j / 4 + 5 * j) % 7 == 5)
         return "Thursday";
      else if ((day + a / 5 + k + k / 4 + j / 4 + 5 * j) % 7 == 6)
         return "Friday";
      else
         return "ERROR";
   }

   /**
    * Returns a string representation of the date.
    * @return a string representation of the date and if some variable is less the 10 it adds "0" before it 
    */

   public String toString()
   {
      String str = "";

      if (day < 10)
      {
         str += "0";
      }
      str += day + "/";

      if (month < 10)
      {
         str += "0";
      }
      str += month + "/";

      str += year + "; ";

      if (hour < 10)
      {
         str += "0";
      }
      str += hour + ":";

      if (minute < 10)
      {
         str += "0";
      }
      str += minute;

      return str;
   }

   
   /**
    * Compares year, month, day, hour, minute of the date
    * @param obj the object to compare with
    * @return true if the given object is equal to this date
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Date))
      {
         return false;
      }

      Date other = (Date) obj;

      return day == other.day && month == other.month && year == other.year
            && hour == other.hour && minute == other.minute;
   }
}
