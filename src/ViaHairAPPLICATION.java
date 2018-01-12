import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 * A user interface that allows employees of VIA Hair Design Studio to make a
 * booking
 * @author Jakub Lemka
 * @version 1.0
 */

public class ViaHairAPPLICATION extends JFrame
{
   Toolkit tk = Toolkit.getDefaultToolkit();
   private int xsize = (int) tk.getScreenSize().getWidth();
   private int ysize = (int) tk.getScreenSize().getHeight();

   private JMenuBar menuBar;

   private JMenu fileMenu;
   private JMenu statsMenu;
   private JMenu aboutMenu;

   private JMenuItem exitMenuItem;
   private JMenuItem newBookingMenuItem;

   private JPanel mainPanel;
   private JPanel titlePanel;
   private JPanel chooseWorkerPanel;
   private JPanel logoPanel;

   private JLabel jol;

   private JButton ellse;
   private JButton karin;
   private JButton anette;
   private JButton helle;
   private JButton anni;

   private ImageIcon logoIcon;
   private JLabel logoLabel;

   private TreatmentFileAdapter adapterTreatment;
   private EmployeeFileAdapter adapterEmployee;
   private BookingFileAdapter adapterBooking;

   private JMenuItem ellseMenuItem;
   private JMenuItem karinMenuItem;
   private JMenuItem anetteMenuItem;
   private JMenuItem helleMenuItem;
   private JMenuItem anniMenuItem;

   private JMenuItem aboutMenuItem;

   private JTabbedPane tabPane;

   private JPanel booking;

   private JLabel firstNameLabel;
   private JLabel secondNameLabel;
   private JLabel thirdNameLabel;
   private JLabel fourthNameLabel;
   private JLabel fivthNameLabel;

   private JPanel firstNamePanel;
   private JPanel secondNamePanel;
   private JPanel thirdNamePanel;
   private JPanel fourthNamePanel;
   private JPanel fivthNamePanel;

   private JPanel dayPanel;
   private JComboBox<Integer> dayBox;
   private JLabel dayLabel;

   private JPanel monthPanel;
   private JComboBox<Integer> monthBox;
   private JLabel monthLabel;

   private JPanel yearPanel;
   private JComboBox<Integer> yearBox;
   private JLabel yearLabel;

   private JPanel hourPanel;
   private JComboBox<Integer> hourBox;
   private JLabel hourLabel;

   private JPanel minutePanel;
   private JComboBox<Integer> minuteBox;
   private JLabel minuteLabel;

   private JPanel treatmentPanel;
   private JComboBox<Treatment> treatmentBox;
   private JLabel treatmentLabel;

   private JPanel modulesPanel;
   private JTextField modulesField;
   private JLabel modulesLabel;

   private JPanel finish1Panel;
   private JTextField finish1Field;
   private JLabel finish1Label;

   private JPanel finish2Panel;
   private JTextField finish2Field;
   private JLabel finish2Label;

   private JPanel customerPanel;
   private JTextField customerField;
   private JLabel customerNumLabel;

   private JPanel employeePanel;
   private JTextField employeeField;
   private JLabel employeeLabel;

   private JButton addBookingButton;

   private JTable allBookingsCalendarTable;
   private JScrollPane allBookingsCalendarScrollPane;
   private String[] columnNames2;
   private DefaultTableModel dtm2;

   // all bookings tab:
   private JPanel allBookingsPanel;
   private JTable allBookingsTable;
   private String[] columnNames;
   private DefaultTableModel dtm;
   private JScrollPane allBookingsScrollPane;

   private JButton getButton;
   private JButton getEmployeeButton;
   private JButton getNotShowUpButton;
   
   private JPanel getsButPanel;
   private JLabel labelBetween ;

   private JPanel comboPanel;

   private JLabel getEmplLabel;
   private JComboBox<Employee> employeeBox;

   private JPanel updateShowUpPanel;
   private JTextField bookNum;
   private JButton updateShowUpButton;
   private JLabel updateShowUpLabel;

   private JTextField bookNum2;
   private JButton removeButton;
   private JLabel removeLabel;

   private MyButtonListener buttonListener;
   private MyTabListener tabListener;

   // ========= stat panel

   private JPanel statisticsPanel;
   private JPanel statTitlePanel;
   private JPanel statWorkerPanel;
   private JPanel logo2Panel;

   private JLabel statLabel;

   private JTextField elseField;
   private JTextField karinField;
   private JTextField anetteField;
   private JTextField helleField;
   private JTextField anniField;

   private JLabel firstNameLabel2;
   private JLabel secondNameLabel2;
   private JLabel thirdNameLabel2;
   private JLabel fourthNameLabel2;
   private JLabel fivthNameLabel2;

   private JLabel firstNameLabel3;
   private JLabel secondNameLabel3;
   private JLabel thirdNameLabel3;
   private JLabel fourthNameLabel3;
   private JLabel fivthNameLabel3;

   private JPanel firstNamePanel2;
   private JPanel secondNamePanel2;
   private JPanel thirdNamePanel2;
   private JPanel fourthNamePanel2;
   private JPanel fivthNamePanel2;

   /**
    * No-argument constructor initializing the GUI components
    */

   public ViaHairAPPLICATION()
   {
      super("VIA HAIR DESIGN STUDIO");

      setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));

      adapterBooking = new BookingFileAdapter("bookings.bin");
      adapterTreatment = new TreatmentFileAdapter("treatments.bin");
      adapterEmployee = new EmployeeFileAdapter("employees.bin");

      buttonListener = new MyButtonListener();
      tabListener = new MyTabListener();
      menuBar = new JMenuBar();

      exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.addActionListener(buttonListener);

      newBookingMenuItem = new JMenuItem("Make booking");
      newBookingMenuItem.addActionListener(buttonListener);

      ellseMenuItem = new JMenuItem("Else");
      ellseMenuItem.addActionListener(buttonListener);

      karinMenuItem = new JMenuItem("Karin");
      karinMenuItem.addActionListener(buttonListener);

      anetteMenuItem = new JMenuItem("Anette");
      anetteMenuItem.addActionListener(buttonListener);

      helleMenuItem = new JMenuItem("Helle");
      helleMenuItem.addActionListener(buttonListener);

      anniMenuItem = new JMenuItem("Anni");
      anniMenuItem.addActionListener(buttonListener);

      aboutMenuItem = new JMenuItem("About");
      aboutMenuItem.addActionListener(buttonListener);

      fileMenu = new JMenu("File");
      statsMenu = new JMenu("Statistics");
      aboutMenu = new JMenu("About");

      fileMenu.add(exitMenuItem);
      fileMenu.add(newBookingMenuItem);
      aboutMenu.add(aboutMenuItem);

      statsMenu.add(ellseMenuItem);
      statsMenu.add(karinMenuItem);
      statsMenu.add(anetteMenuItem);
      statsMenu.add(helleMenuItem);
      statsMenu.add(anniMenuItem);

      menuBar.add(fileMenu);
      menuBar.add(statsMenu);
      menuBar.add(aboutMenu);
      setJMenuBar(menuBar);

      Font font1 = new Font("SansSerif", Font.BOLD, 20);
      statsMenu.setFont(font1);
      fileMenu.setFont(font1);
      aboutMenu.setFont(font1);
      menuBar.setBackground(Color.WHITE);
      menuBar.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 20));

      Font font2 = new Font("SansSerif", Font.BOLD, 30);
      exitMenuItem.setFont(font2);
      newBookingMenuItem.setFont(font2);
      aboutMenuItem.setFont(font2);
      ellseMenuItem.setFont(font2);
      karinMenuItem.setFont(font2);
      anetteMenuItem.setFont(font2);
      helleMenuItem.setFont(font2);
      anniMenuItem.setFont(font2);
      // =================================================================================
      ImageIcon photo1 = new ImageIcon("fryzjer1.jpg");
      ImageIcon photo2 = new ImageIcon("fryzjer2.jpg");
      ImageIcon photo3 = new ImageIcon("fryzjer3.jpg");
      ImageIcon photo4 = new ImageIcon("fryzjer4.jpg");
      ImageIcon photo5 = new ImageIcon("fryzjer5.jpg");

      titlePanel = new JPanel();

      jol = new JLabel("VIA HAIR DESIGN STUDIO");
      titlePanel.add(jol);
      titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 10));
      jol.setBackground(Color.WHITE);
      Font font3 = new Font("SansSerif", Font.BOLD, 70);
      Font font6 = new Font("SansSerif", Font.BOLD, 100);
      jol.setFont(font6);
      jol.setSize(200, 30);

      chooseWorkerPanel = new JPanel();
      chooseWorkerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 66, 15));

      logoPanel = new JPanel();

      firstNamePanel = new JPanel();
      firstNameLabel = new JLabel("              ELSE");
      firstNamePanel.setBackground(new Color(255, 255, 204));
      firstNameLabel.setFont(font2);
      firstNameLabel.setBackground(Color.lightGray);
      ellse = new JButton(photo1);
      firstNamePanel.add(ellse);
      firstNamePanel.add(firstNameLabel);
      firstNamePanel.setLayout(new BoxLayout(firstNamePanel, BoxLayout.Y_AXIS));
      chooseWorkerPanel.add(firstNamePanel);
      ellse.addActionListener(buttonListener);

      secondNamePanel = new JPanel();
      secondNameLabel = new JLabel("             KARIN");
      secondNamePanel.setBackground(new Color(255, 255, 204));
      secondNameLabel.setFont(font2);
      karin = new JButton(photo2);
      secondNamePanel.add(karin);
      secondNamePanel.add(secondNameLabel);
      secondNamePanel
            .setLayout(new BoxLayout(secondNamePanel, BoxLayout.Y_AXIS));
      chooseWorkerPanel.add(secondNamePanel);
      karin.addActionListener(buttonListener);

      thirdNamePanel = new JPanel();
      thirdNameLabel = new JLabel("           ANETTE");
      thirdNamePanel.setBackground(new Color(255, 255, 204));
      thirdNameLabel.setFont(font2);
      anette = new JButton(photo3);
      thirdNamePanel.add(anette);
      thirdNamePanel.add(thirdNameLabel);
      thirdNamePanel.setLayout(new BoxLayout(thirdNamePanel, BoxLayout.Y_AXIS));
      chooseWorkerPanel.add(thirdNamePanel);
      anette.addActionListener(buttonListener);

      fourthNamePanel = new JPanel();
      fourthNameLabel = new JLabel("             HELLE");
      fourthNamePanel.setBackground(new Color(255, 255, 204));
      fourthNameLabel.setFont(font2);
      helle = new JButton(photo4);
      fourthNamePanel.add(helle);
      fourthNamePanel.add(fourthNameLabel);
      fourthNamePanel
            .setLayout(new BoxLayout(fourthNamePanel, BoxLayout.Y_AXIS));
      chooseWorkerPanel.add(fourthNamePanel);
      helle.addActionListener(buttonListener);

      fivthNamePanel = new JPanel();
      fivthNameLabel = new JLabel("             ANNI");
      fivthNamePanel.setBackground(new Color(255, 255, 204));
      fivthNameLabel.setFont(font2);
      anni = new JButton(photo5);
      fivthNamePanel.add(anni);
      fivthNamePanel.add(fivthNameLabel);
      fivthNamePanel.setLayout(new BoxLayout(fivthNamePanel, BoxLayout.Y_AXIS));
      chooseWorkerPanel.add(fivthNamePanel);
      anni.addActionListener(buttonListener);

      Dimension d = new Dimension(300, 300);
      ellse.setPreferredSize(d);
      karin.setPreferredSize(d);
      anette.setPreferredSize(d);
      helle.setPreferredSize(d);
      anni.setPreferredSize(d);

      logoIcon = new ImageIcon("logologo.jpg");
      logoLabel = new JLabel();
      logoLabel.setIcon(logoIcon);

      logoPanel.add(logoLabel);
      logoLabel.setPreferredSize(new Dimension(220, 250));

      titlePanel.setBackground(new Color(194, 194, 163));
      chooseWorkerPanel.setBackground(Color.BLACK);
      logoPanel.setBackground(Color.BLACK);

      mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

      mainPanel.add(titlePanel);
      mainPanel.add(chooseWorkerPanel);
      mainPanel.add(logoPanel);

      // ==========================make
      // booking======================================================
      employeePanel = new JPanel();
      employeeLabel = new JLabel("EMPLOYEE: ");
      employeeField = new JTextField();
      employeeLabel.setFont(font1);
      employeeField.setFont(font1);
      employeeField.setEditable(false);
      employeeField.setPreferredSize(new Dimension(150, 30));
      employeeField.addActionListener(buttonListener);
      Color col1 = new Color(194, 194, 163);
      Color col2 = new Color(255, 255, 204);
      Color col3 = new Color(255, 255, 102);
      Color col4 = new Color(255, 255, 230);
      employeePanel.setBorder(new LineBorder(col1, 5));
      employeePanel.setBackground(col2);
      employeeField.setBackground(col4);
      employeePanel.add(employeeLabel);
      employeePanel.add(employeeField);

      monthPanel = new JPanel();
      monthLabel = new JLabel("MONTH");
      monthBox = new JComboBox<Integer>();
      monthLabel.setFont(font1);
      monthBox.setFont(font1);
      monthBox.addItem(1);
      monthBox.addItem(2);
      monthBox.addItem(3);
      monthBox.addItem(4);
      monthBox.addItem(5);
      monthBox.addItem(6);
      monthBox.addItem(7);
      monthBox.addItem(8);
      monthBox.addItem(8);
      monthBox.addItem(10);
      monthBox.addItem(11);
      monthBox.addItem(12);
      monthBox.setPreferredSize(new Dimension(150, 30));
      monthBox.addActionListener(buttonListener);
      monthPanel.setBorder(new LineBorder(col1, 5));
      monthPanel.setBackground(col2);
      monthBox.setBackground(col3);
      monthPanel.add(monthLabel);
      monthPanel.add(monthBox);

      dayPanel = new JPanel();
      dayLabel = new JLabel("DAY");
      dayLabel.setFont(font1);
      dayBox = new JComboBox<Integer>();
      dayBox.setFont(font1);
      dayBox.setPreferredSize(new Dimension(150, 30));
      dayBox.addActionListener(buttonListener);
      dayPanel.setBorder(new LineBorder(col1, 5));
      dayPanel.setBackground(col2);
      dayBox.setBackground(col3);
      dayPanel.add(dayLabel);
      dayPanel.add(dayBox);

      yearPanel = new JPanel();
      yearLabel = new JLabel("YEAR");
      yearBox = new JComboBox<Integer>();
      yearLabel.setFont(font1);
      yearBox.setFont(font1);
      yearBox.addItem(2016);
      yearBox.addItem(2017);
      yearBox.addItem(2018);
      yearBox.addItem(2019);
      yearBox.addItem(2020);
      yearBox.setPreferredSize(new Dimension(150, 30));
      yearBox.addActionListener(buttonListener);
      yearPanel.setBorder(new LineBorder(col1, 5));
      yearPanel.setBackground(col2);
      yearBox.setBackground(col3);
      yearPanel.add(yearLabel);
      yearPanel.add(yearBox);

      hourPanel = new JPanel();
      hourLabel = new JLabel("HOUR");
      hourBox = new JComboBox<Integer>();
      hourBox.setFont(font1);
      hourLabel.setFont(font1);
      hourBox.addItem(9);
      hourBox.addItem(10);
      hourBox.addItem(11);
      hourBox.addItem(12);
      hourBox.addItem(13);
      hourBox.addItem(14);
      hourBox.addItem(15);
      hourBox.setPreferredSize(new Dimension(150, 30));
      hourBox.addActionListener(buttonListener);
      hourPanel.setBorder(new LineBorder(col1, 5));
      hourPanel.setBackground(col2);
      hourBox.setBackground(col3);
      hourPanel.add(hourLabel);
      hourPanel.add(hourBox);

      minutePanel = new JPanel();
      minuteLabel = new JLabel("MINUTE");
      minuteBox = new JComboBox<Integer>();
      minuteLabel.setFont(font1);
      minuteBox.setFont(font1);
      minuteBox.addItem(00);
      minuteBox.addItem(30);
      minuteBox.setPreferredSize(new Dimension(150, 30));
      minuteBox.addActionListener(buttonListener);
      minutePanel.setBorder(new LineBorder(col1, 5));
      minutePanel.setBackground(col2);
      minuteBox.setBackground(col3);
      minutePanel.add(minuteLabel);
      minutePanel.add(minuteBox);

      treatmentPanel = new JPanel();
      treatmentLabel = new JLabel("TREATMENT");
      treatmentBox = new JComboBox<Treatment>();
      treatmentLabel.setFont(font1);
      treatmentBox.setFont(font1);
      treatmentBox.setPreferredSize(new Dimension(250, 30));
      treatmentBox.addActionListener(buttonListener);
      treatmentPanel.setBorder(new LineBorder(col1, 5));
      treatmentPanel.setBackground(col2);
      treatmentBox.setBackground(col3);
      treatmentPanel.add(treatmentLabel);
      treatmentPanel.add(treatmentBox);

      modulesPanel = new JPanel();
      modulesLabel = new JLabel("MODULES");
      modulesField = new JTextField();
      modulesLabel.setFont(font1);
      modulesField.setFont(font1);
      modulesField.setEditable(false);
      modulesField.setPreferredSize(new Dimension(250, 30));
      modulesField.addActionListener(buttonListener);
      modulesPanel.setBorder(new LineBorder(col1, 5));
      modulesPanel.setBackground(col2);
      modulesField.setBackground(col4);
      modulesPanel.add(modulesLabel);
      modulesPanel.add(modulesField);

      finish1Panel = new JPanel();
      finish1Label = new JLabel("FINISH (hour): ");
      finish1Field = new JTextField();
      finish1Label.setFont(font1);
      finish1Field.setFont(font1);
      finish1Field.setEditable(false);
      finish1Field.setPreferredSize(new Dimension(150, 30));
      finish1Field.addActionListener(buttonListener);
      finish1Panel.setBorder(new LineBorder(col1, 5));
      finish1Panel.setBackground(col2);
      finish1Field.setBackground(col4);
      finish1Panel.add(finish1Label);
      finish1Panel.add(finish1Field);

      finish2Panel = new JPanel();
      finish2Label = new JLabel("FINISH (minute): ");
      finish2Field = new JTextField();
      finish2Label.setFont(font1);
      finish2Field.setFont(font1);
      finish2Field.setEditable(false);
      finish2Field.setPreferredSize(new Dimension(150, 30));
      finish2Field.addActionListener(buttonListener);
      finish2Panel.setBorder(new LineBorder(col1, 5));
      finish2Panel.setBackground(col2);
      finish2Field.setBackground(col4);
      finish2Panel.add(finish2Label);
      finish2Panel.add(finish2Field);

      customerPanel = new JPanel();
      customerNumLabel = new JLabel("CUSTOMER NUM.");
      customerField = new JTextField();
      customerNumLabel.setFont(font1);
      customerField.setFont(font1);
      customerField.setPreferredSize(new Dimension(150, 30));
      customerField.addActionListener(buttonListener);
      customerPanel.setBorder(new LineBorder(col1, 5));
      customerPanel.setBackground(col2);
      customerField.setBackground(col3);
      customerPanel.add(customerNumLabel);
      customerPanel.add(customerField);

      addBookingButton = new JButton("ADD BOOKING");
      addBookingButton.setFont(font3);
      addBookingButton.addActionListener(buttonListener);
      addBookingButton.setBackground(col1);
      addBookingButton.setBorder(new LineBorder(col2, 9));


      booking = new JPanel();

      booking.add(employeePanel);
      booking.add(yearPanel);
      booking.add(monthPanel);
      booking.add(dayPanel);
      booking.add(hourPanel);
      booking.add(minutePanel);
      booking.add(treatmentPanel);
      booking.add(modulesPanel);
      booking.add(finish1Panel);
      booking.add(finish2Panel);
      booking.add(customerPanel);
      booking.add(addBookingButton);
      booking.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

      booking.setBackground(Color.black);

      columnNames2 = new String[4];
      columnNames2[0] = "Employee";
      columnNames2[1] = "Date";
      columnNames2[2] = "Hour";
      columnNames2[3] = "Modules";

      dtm2 = new DefaultTableModel(columnNames2, 0);

      allBookingsCalendarTable = new JTable(dtm2);
      allBookingsCalendarTable.setEnabled(false);
      allBookingsCalendarTable.getTableHeader().setReorderingAllowed(false);
      allBookingsCalendarTable.getTableHeader().setResizingAllowed(false);
      allBookingsCalendarTable.setRowHeight(25);
      allBookingsCalendarTable
            .setPreferredScrollableViewportSize(new Dimension(600,
                  allBookingsCalendarTable.getRowHeight() * 10));
      Font font4 = new Font("SansSerif", Font.ROMAN_BASELINE, 18);
      allBookingsCalendarTable.setFont(font4);
      allBookingsCalendarTable.setBackground(col2);

      allBookingsCalendarScrollPane = new JScrollPane(allBookingsCalendarTable);
      allBookingsCalendarScrollPane
            .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      booking.add(allBookingsCalendarScrollPane);



      // ==============all bookings panel==========================
      allBookingsPanel = new JPanel();
      allBookingsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
      columnNames = new String[7];
      columnNames[0] = "Booking number";
      columnNames[1] = "Date";
      columnNames[2] = "Finish";
      columnNames[3] = "Employee";
      columnNames[4] = "Treatment";
      columnNames[5] = "Customer number";
      columnNames[6] = "Show up?";

      dtm = new DefaultTableModel(columnNames, 0);

      allBookingsTable = new JTable(dtm);
      allBookingsTable.setEnabled(false);
      allBookingsTable.getTableHeader().setReorderingAllowed(false);
      allBookingsTable.getTableHeader().setResizingAllowed(false);
      allBookingsTable.setRowHeight(25);
      allBookingsTable.setPreferredScrollableViewportSize(new Dimension(1200,
            allBookingsTable.getRowHeight() * 30));
      allBookingsTable.setFont(font4);
      allBookingsTable.setBackground(col4);
      allBookingsScrollPane = new JScrollPane(allBookingsTable);
      allBookingsScrollPane
            .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      allBookingsPanel.add(allBookingsScrollPane);

      getButton = new JButton("     Get all bookings     ");
      getButton.addActionListener(buttonListener);
      getButton.setFont(font1);
      getButton.setBackground(col2);
      getButton.setBorder(new LineBorder(col1, 3));
      
      getEmployeeButton = new JButton(" Get employee's bookings ");
      getEmployeeButton.addActionListener(buttonListener);

      getNotShowUpButton = new JButton("Not-show-up bookings");
      getNotShowUpButton.addActionListener(buttonListener);
      getNotShowUpButton.setFont(font1);
      getNotShowUpButton.setBackground(col2);
      getNotShowUpButton.setBorder(new LineBorder(col1, 3));

      getsButPanel = new JPanel();
      labelBetween = new JLabel("         ");
      getsButPanel.setBackground(col3);
      getsButPanel.add(getButton);
      getsButPanel.add(labelBetween);
      getsButPanel.add(getNotShowUpButton);
      getsButPanel.setLayout(new BoxLayout(getsButPanel, BoxLayout.Y_AXIS));
      allBookingsPanel.add(getsButPanel);
      
     
      comboPanel = new JPanel();

      employeeBox = new JComboBox<Employee>();
      employeeBox.setPreferredSize(new Dimension(250, 30));
      employeeBox.addActionListener(buttonListener);
      employeeBox.setBackground(new Color(255, 230, 153));

      getEmplLabel = new JLabel(" CHOOSE AN EMPLOYEE:");
      getEmplLabel.setPreferredSize(new Dimension(260, 30));
      getEmplLabel.setFont(font1);
      comboPanel.add(getEmplLabel);
      comboPanel.add(employeeBox);
      comboPanel.add(getEmployeeButton);
      getButton.setFont(font1);
      employeeBox.setFont(font1);
      getEmployeeButton.setFont(font1);
      getEmployeeButton.setBackground(col2);
      getEmployeeButton.setBorder(new LineBorder(col1, 3));
      allBookingsPanel.add(comboPanel);
      comboPanel.setPreferredSize(new Dimension(300, 130));
      allBookingsPanel.setBackground(Color.BLACK);
      comboPanel.setBackground(new Color(255, 217, 102));
      updateShowUpPanel = new JPanel();
      updateShowUpPanel.setBackground(col2);
      bookNum = new JTextField();
      updateShowUpLabel = new JLabel("Enter booking nr");
      updateShowUpButton = new JButton("CLICK IF SHOW UP");
      updateShowUpButton.setFont(font1);
      updateShowUpButton.setBackground(col2);
      updateShowUpButton.setBorder(new LineBorder(col1, 3));
      bookNum.setPreferredSize(new Dimension(260, 30));
      bookNum.setBackground(col4);
      updateShowUpLabel.setPreferredSize(new Dimension(165, 30));
      updateShowUpLabel.setFont(font1);
      updateShowUpButton.setPreferredSize(new Dimension(260, 30));
      updateShowUpPanel.add(updateShowUpLabel);
      updateShowUpPanel.add(bookNum);
      updateShowUpPanel.add(updateShowUpButton);
      updateShowUpButton.addActionListener(buttonListener);
      bookNum2 = new JTextField();
      bookNum2.setBackground(col4);
      removeLabel = new JLabel("                Enter booking nr");
      removeButton = new JButton("CLICK TO REMOVE");
      removeButton.setFont(font1);
      removeButton.setBackground(col2);
      removeButton.setBorder(new LineBorder(col1, 3));
      bookNum2.setPreferredSize(new Dimension(260, 30));
      removeLabel.setPreferredSize(new Dimension(265, 30));
      removeLabel.setFont(font1);
      removeButton.setPreferredSize(new Dimension(260, 30));
      updateShowUpPanel.add(removeLabel);
      updateShowUpPanel.add(bookNum2);
      updateShowUpPanel.add(removeButton);
      allBookingsPanel.add(updateShowUpPanel);
      removeButton.addActionListener(buttonListener);

      // stats panel

      statTitlePanel = new JPanel();

      statLabel = new JLabel("OUR TEAM - STATISTICS");
      statTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
      Font font5 = new Font("SansSerif", Font.BOLD, 50);
      statLabel.setFont(font5);
      statLabel.setSize(40, 40);
      statTitlePanel.add(statLabel);

      statWorkerPanel = new JPanel();
      statWorkerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 120, 20));

      firstNamePanel2 = new JPanel();
      firstNameLabel3 = new JLabel(photo1);
      firstNameLabel2 = new JLabel("        ELSE");
      firstNameLabel2.setFont(font2);
      elseField = new JTextField();
      elseField.setBackground(new Color(242, 255, 230));
      elseField.setFont(font3);
      elseField.setEditable(false);
      elseField.setHorizontalAlignment(JTextField.CENTER);
      firstNamePanel2.add(firstNameLabel2);
      firstNamePanel2.add(firstNameLabel3);
      firstNamePanel2.add(elseField);
      firstNamePanel2
            .setLayout(new BoxLayout(firstNamePanel2, BoxLayout.Y_AXIS));
      statWorkerPanel.add(firstNamePanel2);

      secondNamePanel2 = new JPanel();
      secondNameLabel3 = new JLabel(photo2);
      secondNameLabel2 = new JLabel("       KARIN");
      secondNameLabel2.setFont(font2);
      karinField = new JTextField();
      karinField.setBackground(new Color(242, 255, 230));
      karinField.setFont(font3);
      karinField.setEditable(false);
      karinField.setHorizontalAlignment(JTextField.CENTER);
      secondNamePanel2.add(secondNameLabel2);
      secondNamePanel2.add(secondNameLabel3);
      secondNamePanel2.add(karinField);
      secondNamePanel2.setLayout(new BoxLayout(secondNamePanel2,
            BoxLayout.Y_AXIS));
      statWorkerPanel.add(secondNamePanel2);

      thirdNamePanel2 = new JPanel();
      thirdNameLabel3 = new JLabel(photo3);
      thirdNameLabel2 = new JLabel("     ANETTE");
      thirdNameLabel2.setFont(font2);
      anetteField = new JTextField();
      anetteField.setBackground(new Color(242, 255, 230));
      anetteField.setFont(font3);
      anetteField.setEditable(false);
      anetteField.setHorizontalAlignment(JTextField.CENTER);
      thirdNamePanel2.add(thirdNameLabel2);
      thirdNamePanel2.add(thirdNameLabel3);
      thirdNamePanel2.add(anetteField);
      thirdNamePanel2
            .setLayout(new BoxLayout(thirdNamePanel2, BoxLayout.Y_AXIS));
      statWorkerPanel.add(thirdNamePanel2);

      fourthNamePanel2 = new JPanel();
      fourthNameLabel3 = new JLabel(photo4);
      fourthNameLabel2 = new JLabel("     HELLE");
      fourthNameLabel2.setFont(font2);
      helleField = new JTextField();
      helleField.setBackground(new Color(242, 255, 230));
      helleField.setFont(font3);
      helleField.setEditable(false);
      helleField.setHorizontalAlignment(JTextField.CENTER);
      fourthNamePanel2.add(fourthNameLabel2);
      fourthNamePanel2.add(fourthNameLabel3);
      fourthNamePanel2.add(helleField);
      fourthNamePanel2.setLayout(new BoxLayout(fourthNamePanel2,
            BoxLayout.Y_AXIS));
      statWorkerPanel.add(fourthNamePanel2);

      fivthNamePanel2 = new JPanel();
      fivthNameLabel3 = new JLabel(photo5);
      fivthNameLabel2 = new JLabel("        ANNI");
      fivthNameLabel2.setFont(font2);
      anniField = new JTextField();
      anniField.setBackground(new Color(242, 255, 230));
      anniField.setFont(font3);
      anniField.setEditable(false);
      anniField.setHorizontalAlignment(JTextField.CENTER);
      fivthNamePanel2.add(fivthNameLabel2);
      fivthNamePanel2.add(fivthNameLabel3);
      fivthNamePanel2.add(anniField);
      fivthNamePanel2
            .setLayout(new BoxLayout(fivthNamePanel2, BoxLayout.Y_AXIS));
      statWorkerPanel.add(fivthNamePanel2);

      Dimension d3 = new Dimension(220, 600);
      firstNamePanel2.setPreferredSize(d3);
      secondNamePanel2.setPreferredSize(d3);
      thirdNamePanel2.setPreferredSize(d3);
      fourthNamePanel2.setPreferredSize(d3);
      fivthNamePanel2.setPreferredSize(d3);

      firstNamePanel2.setBackground(new Color(230, 255, 230));
      secondNamePanel2.setBackground(new Color(230, 255, 230));
      thirdNamePanel2.setBackground(new Color(230, 255, 230));
      fourthNamePanel2.setBackground(new Color(230, 255, 230));
      fivthNamePanel2.setBackground(new Color(230, 255, 230));

      Dimension d2 = new Dimension(50, 50);
      elseField.setPreferredSize(d2);
      karinField.setPreferredSize(d2);
      anetteField.setPreferredSize(d2);
      helleField.setPreferredSize(d2);
      anniField.setPreferredSize(d2);

      statTitlePanel.setBackground(new Color(255, 255, 179));
      statWorkerPanel.setBackground(Color.BLACK);

      statisticsPanel = new JPanel();
      statisticsPanel.setBackground(Color.black);
      // statisticsPanel.setLayout(new BoxLayout(statisticsPanel,
      // BoxLayout.Y_AXIS));

      statisticsPanel.add(statTitlePanel);
      statisticsPanel.add(statWorkerPanel);

      // ====================================================

      tabPane = new JTabbedPane();
      tabPane.addTab("Choose a worker", mainPanel);
      tabPane.addTab("Make a booking", booking);
      tabPane.addTab("All bookings", allBookingsPanel);
      tabPane.addTab("Statistics", statisticsPanel);
      tabPane.addChangeListener(tabListener);

      tabPane.setFont(font1);
      tabPane.setBackground(Color.WHITE);

      add(tabPane);
      setSize(xsize, ysize - 47);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // Center window on screen
      setBackground(Color.BLACK);
      setFont(font2);
   }

   /*
    * updates the treatmentBox JComboBox with information from the treatment
    * file
    */

   private void updateTreatmentBox()
   {
      int currentIndex = treatmentBox.getSelectedIndex();

      treatmentBox.removeAllItems();

      TreatmentList treatments = adapterTreatment.getAllTreatments();
      for (int i = 0; i < treatments.getSize(); i++)
      {
         treatmentBox.addItem(treatments.getTreatment(i));
      }

      if (currentIndex == -1 && treatmentBox.getItemCount() > 0)
      {
         treatmentBox.setSelectedIndex(0);
      }
      else
      {
         treatmentBox.setSelectedIndex(currentIndex);
      }
   }

   /*
    * updates the employeeBox JComboBox with information from the employees file
    */

   private void updateEmployeeBox()
   {
      int currentIndex = employeeBox.getSelectedIndex();

      employeeBox.removeAllItems();

      EmployeeList employees = adapterEmployee.getAllEmployees();

      for (int i = 0; i < employees.getSize(); i++)
      {
         employeeBox.addItem(employees.getEmployee(i));
      }

      if (currentIndex == -1 && employeeBox.getItemCount() > 0)
      {
         employeeBox.setSelectedIndex(0);
      }
      else
      {
         employeeBox.setSelectedIndex(currentIndex);
      }
   }

   /*
    * updates all bookings in the table
    */

   private void updateBookingTable()
   {
      BookingList bookings = adapterBooking.getAllBookings();
      Object[][] data = new Object[bookings.getSize()][7];

      for (int i = 0; i < bookings.getSize(); i++)
      {
         data[i][0] = i;
         data[i][1] = bookings.getBooking(i).getDate();
         data[i][2] = bookings.getBooking(i).getFinishDate();
         data[i][3] = bookings.getBooking(i).getEmployee();
         data[i][4] = bookings.getBooking(i).getTreatment();
         data[i][5] = bookings.getBooking(i).getCustomerNum();
         data[i][6] = bookings.getBooking(i).getShowUp();

      }
      dtm = new DefaultTableModel(data, columnNames);
      allBookingsTable.setModel(dtm);
   }

   /*
    * updates the chosen employee's all bookings in the table
    */

   private void updateEmployeeBookingTable()
   {
      BookingList bookings = adapterBooking
            .getBookingsByEmployee(((Employee) employeeBox.getSelectedItem())
                  .getName());
      Object[][] data = new Object[bookings.getSize()][7];

      for (int i = 0; i < bookings.getSize(); i++)
      {
         data[i][0] = i;
         data[i][1] = bookings.getBooking(i).getDate();
         data[i][2] = bookings.getBooking(i).getFinishDate();
         data[i][3] = bookings.getBooking(i).getEmployee();
         data[i][4] = bookings.getBooking(i).getTreatment();
         data[i][5] = bookings.getBooking(i).getCustomerNum();
         data[i][6] = bookings.getBooking(i).getShowUp();
      }
      dtm = new DefaultTableModel(data, columnNames);
      allBookingsTable.setModel(dtm);
   }

   /*
    * updates the chosen employee's bookings in the future in the table-calendar
    */

   private void updateEmployeeCalendar()
   {
      BookingList bookings = adapterBooking.getBookingsByEmployee(employeeField
            .getText());

      int size = 0;

      for (int i = 0; i < bookings.getSize(); i++)
      {
         if (bookings.getBooking(i).getDate().isFuture())
         {
            size++;
         }
      }

      Object[][] data2 = new Object[size][4];

      for (int i = 0; i < bookings.getSize(); i++)
      {
         if (bookings.getBooking(i).getDate().isFuture() == true)
         {
            data2[i][0] = bookings.getBooking(i).getEmployee();
            data2[i][1] = bookings.getBooking(i).getDate().getDate();
            data2[i][2] = bookings.getBooking(i).getDate().getFullHour();
            data2[i][3] = bookings.getBooking(i).getTreatment()
                  .getHowManyModules();
         }
      }
      dtm2 = new DefaultTableModel(data2, columnNames2);
      allBookingsCalendarTable.setModel(dtm2);
   }
   /*
    * updates the all bookings table by showing all when customer didn't show up
    */
   private void updateTableByShowUp() 
   {
      BookingList bookings = adapterBooking.getAllBookings();

      int size = 0;

      for (int i = 0; i < bookings.getSize(); i++)
      {
         if (bookings.getBooking(i).getShowUp() == false)
         {
            size++;
         }
      }

      Object[][] data2 = new Object[size][7];

      int j = 0;
      for (int i = 0; i < bookings.getSize(); i++)
      {
         if (bookings.getBooking(i).getShowUp() == false)
         {
            data2[j][0] = i;
            data2[j][1] = bookings.getBooking(i).getDate();
            data2[j][2] = bookings.getBooking(i).getFinishDate();
            data2[j][3] = bookings.getBooking(i).getEmployee();
            data2[j][4] = bookings.getBooking(i).getTreatment();
            data2[j][5] = bookings.getBooking(i).getCustomerNum();
            data2[j][6] = bookings.getBooking(i).getShowUp();
            j++;
         }
      }
      dtm = new DefaultTableModel(data2, columnNames);
      allBookingsTable.setModel(dtm);
   }

   /*
    * Inner action listener class
    * @author Jakub Lemka
    * @version 1.0
    */

   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == getButton)
         {
            updateBookingTable();
         }

         if (e.getSource() == exitMenuItem)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Do you really want to exit the program?", "Exit",
                  JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }

         if (e.getSource() == newBookingMenuItem)
         {

            JOptionPane.showMessageDialog(null,
                  "Please click on the chosen assistant picture in "
                        + "the main tab to start making a booking ",
                  "New booking", JOptionPane.PLAIN_MESSAGE);
         }

         Font font6 = new Font("SansSerif", Font.BOLD, 130);
         Font font7 = new Font("SansSerif", Font.BOLD, 80);
         if (e.getSource() == ellseMenuItem)
         {
            tabPane.setSelectedIndex(3);
            elseField.setFont(font6);
            elseField.setForeground(new Color(120, 178, 0));
            karinField.setForeground(Color.black);
            karinField.setFont(font7);
            anetteField.setForeground(Color.black);
            anetteField.setFont(font7);
            helleField.setForeground(Color.black);
            helleField.setFont(font7);
            anniField.setForeground(Color.black);
            anniField.setFont(font7);

         }
         if (e.getSource() == karinMenuItem)
         {
            tabPane.setSelectedIndex(3);
            karinField.setFont(font6);
            karinField.setForeground(new Color(120, 178, 0));
            elseField.setForeground(Color.black);
            elseField.setFont(font7);
            anetteField.setForeground(Color.black);
            anetteField.setFont(font7);
            helleField.setForeground(Color.black);
            helleField.setFont(font7);
            anniField.setForeground(Color.black);
            anniField.setFont(font7);

         }
         if (e.getSource() == anetteMenuItem)
         {
            tabPane.setSelectedIndex(3);
            anetteField.setFont(font6);
            anetteField.setForeground(new Color(120, 178, 0));
            elseField.setForeground(Color.black);
            elseField.setFont(font7);
            karinField.setForeground(Color.black);
            karinField.setFont(font7);
            helleField.setForeground(Color.black);
            helleField.setFont(font7);
            anniField.setForeground(Color.black);
            anniField.setFont(font7);

         }
         if (e.getSource() == helleMenuItem)
         {
            tabPane.setSelectedIndex(3);
            helleField.setFont(font6);
            helleField.setForeground(new Color(120, 178, 0));
            elseField.setForeground(Color.black);
            elseField.setFont(font7);
            karinField.setForeground(Color.black);
            karinField.setFont(font7);
            anetteField.setForeground(Color.black);
            anetteField.setFont(font7);
            anniField.setForeground(Color.black);
            anniField.setFont(font7);

         }
         if (e.getSource() == anniMenuItem)
         {
            tabPane.setSelectedIndex(3);
            anniField.setFont(font6);
            anniField.setForeground(new Color(120, 178, 0));
            elseField.setForeground(Color.black);
            elseField.setFont(font7);
            karinField.setForeground(Color.black);
            karinField.setFont(font7);
            anetteField.setForeground(Color.black);
            anetteField.setFont(font7);
            helleField.setForeground(Color.black);
            helleField.setFont(font7);

         }

         if (e.getSource() == aboutMenuItem)
         {
            JOptionPane
                  .showMessageDialog(
                        null,
                        "Application improving booking system of VIA Hair Design Studio "
                              + "\n"
                              + "                                              version 0.72"
                              + "\n"
                              + "                     made by Anna, Filip, Tomasz, Jakub, Roberto",
                        "About", JOptionPane.PLAIN_MESSAGE);
         }

         if (e.getSource() == monthBox)
         {

            if (monthBox.getSelectedIndex() == 1)
            {
               if (yearBox.getSelectedIndex() == 0
                     || yearBox.getSelectedIndex() == 4)
               {
                  dayBox.removeAllItems();
                  for (int i = 1; i <= 29; i++)
                  {
                     dayBox.addItem(i);
                  }
               }
               if ((yearBox.getSelectedIndex() == 1
                     || yearBox.getSelectedIndex() == 2 || yearBox
                        .getSelectedIndex() == 3))
               {
                  dayBox.removeAllItems();
                  for (int i = 1; i <= 28; i++)
                  {
                     dayBox.addItem(i);
                  }
               }
            }
            if (monthBox.getSelectedIndex() == 0
                  || monthBox.getSelectedIndex() == 2
                  || monthBox.getSelectedIndex() == 4
                  || monthBox.getSelectedIndex() == 6
                  || monthBox.getSelectedIndex() == 7
                  || monthBox.getSelectedIndex() == 9
                  || monthBox.getSelectedIndex() == 11)
            {
               dayBox.removeAllItems();
               for (int i = 1; i <= 31; i++)
               {
                  dayBox.addItem(i);
               }
            }
            if (monthBox.getSelectedIndex() == 3
                  || monthBox.getSelectedIndex() == 5
                  || monthBox.getSelectedIndex() == 8
                  || monthBox.getSelectedIndex() == 10)
            {
               dayBox.removeAllItems();
               for (int i = 1; i <= 30; i++)
               {
                  dayBox.addItem(i);
               }

            }
         }

         if (e.getSource() == dayBox)
         {
            if (dayBox.getSelectedIndex() != -1)
            {
               Treatment temp = (Treatment) treatmentBox.getSelectedItem();
               Date d1 = new Date((Integer) dayBox.getSelectedItem(),
                     (Integer) monthBox.getSelectedItem(),
                     (Integer) yearBox.getSelectedItem(),
                     (Integer) hourBox.getSelectedItem(),
                     (Integer) minuteBox.getSelectedItem());

               int modules = temp.getHowManyModules();

               d1.addMinutes(modules * 30);
               finish1Field.setText(String.valueOf(d1.getHour()));
               finish2Field.setText(String.valueOf(d1.getMinute()));
            }
         }

         if (e.getSource() == hourBox)
         {

            Treatment temp = (Treatment) treatmentBox.getSelectedItem();
            Date d1 = new Date((Integer) dayBox.getSelectedItem(),
                  (Integer) monthBox.getSelectedItem(),
                  (Integer) yearBox.getSelectedItem(),
                  (Integer) hourBox.getSelectedItem(),
                  (Integer) minuteBox.getSelectedItem());

            int modules = temp.getHowManyModules();

            d1.addMinutes(modules * 30);
            finish1Field.setText(String.valueOf(d1.getHour()));
            finish2Field.setText(String.valueOf(d1.getMinute()));

         }

         if (e.getSource() == minuteBox)
         {

            Treatment temp = (Treatment) treatmentBox.getSelectedItem();
            Date d1 = new Date((Integer) dayBox.getSelectedItem(),
                  (Integer) monthBox.getSelectedItem(),
                  (Integer) yearBox.getSelectedItem(),
                  (Integer) hourBox.getSelectedItem(),
                  (Integer) minuteBox.getSelectedItem());

            int modules = temp.getHowManyModules();

            d1.addMinutes(modules * 30);
            finish1Field.setText(String.valueOf(d1.getHour()));
            finish2Field.setText(String.valueOf(d1.getMinute()));

         }

         if (e.getSource() == treatmentBox)
         {
            if (treatmentBox.getSelectedItem() instanceof Treatment)
            {

               Treatment temp = (Treatment) treatmentBox.getSelectedItem();
               modulesField.setText(String.valueOf(temp.getHowManyModules()));

               if (dayBox.getSelectedIndex() != -1)
               {
                  Date d1 = new Date((Integer) dayBox.getSelectedItem(),
                        (Integer) monthBox.getSelectedItem(),
                        (Integer) yearBox.getSelectedItem(),
                        (Integer) hourBox.getSelectedItem(),
                        (Integer) minuteBox.getSelectedItem());

                  int modules = temp.getHowManyModules();
                  d1.addMinutes(modules * 30);
                  finish1Field.setText(String.valueOf(d1.getHour()));
                  finish2Field.setText(String.valueOf(d1.getMinute()));
               }
            }
         }

         if (e.getSource() == ellse)
         {
            employeeField.setText("Else");
            updateEmployeeCalendar();
            tabPane.setSelectedIndex(1);

         }
         if (e.getSource() == karin)
         {
            employeeField.setText("Karin");
            updateEmployeeCalendar();
            tabPane.setSelectedIndex(1);

         }
         if (e.getSource() == anette)
         {
            employeeField.setText("Anette");
            updateEmployeeCalendar();
            tabPane.setSelectedIndex(1);

         }
         if (e.getSource() == helle)
         {
            employeeField.setText("Helle");
            updateEmployeeCalendar();
            tabPane.setSelectedIndex(1);

         }
         if (e.getSource() == anni)
         {
            employeeField.setText("Anni");
            updateEmployeeCalendar();
            tabPane.setSelectedIndex(1);

         }
         if (e.getSource() == addBookingButton)
         {
            boolean success = true;

            if (customerField.getText().equals(""))
            {
               JOptionPane.showMessageDialog(null,
                     "PLEASE ENTER CUSTOMER'S NUMBER", "ERROR",
                     JOptionPane.ERROR_MESSAGE);
               success = false;
            }
            
            if (employeeField.getText().equals(""))
            {
               JOptionPane.showMessageDialog(null,
                     "PLEASE SELECT AN ASSISTANT", "ERROR",
                     JOptionPane.ERROR_MESSAGE);
               success = false;
               tabPane.setSelectedIndex(0);
            }


            int finishH = Integer.parseInt(finish1Field.getText());
            int finishM = Integer.parseInt(finish2Field.getText());

            int numberg = Integer.parseInt(customerField.getText());

            // ----------------------

            Date dd1 = new Date((Integer) dayBox.getSelectedItem(),
                  (Integer) monthBox.getSelectedItem(),
                  (Integer) yearBox.getSelectedItem(),
                  (Integer) hourBox.getSelectedItem(),
                  (Integer) minuteBox.getSelectedItem());

            if (dd1.isFuture() == false)
            {
               JOptionPane.showMessageDialog(null,
                     "Choose the date from the future!", "ERROR",
                     JOptionPane.ERROR_MESSAGE);
               success = false;

            }
            // =====================

            if (dd1.dayOfWeek().equals("Saturday")
                  || dd1.dayOfWeek().equals("Sunday"))
            {
               JOptionPane.showMessageDialog(null,
                     "WEEKEND! Studio is closed.", "ERROR",
                     JOptionPane.ERROR_MESSAGE);
               success = false;
            }

            if (finishH > 16 || (finishH == 16 && finishM == 30))
            {
               JOptionPane.showMessageDialog(null,
                     "SALOON WILL BE CLOSED THAT TIME", "ERROR",
                     JOptionPane.ERROR_MESSAGE);
               success = false;
            }
            else if (numberg > 99999999 || numberg < 10000000)
            {
               JOptionPane.showMessageDialog(null, "PUT THE CORRECT NUMBER"
                     + "\n" + "correct number contains of 8 digits", "ERROR",
                     JOptionPane.ERROR_MESSAGE);
               success = false;
            }


            Date d1 = new Date((Integer) dayBox.getSelectedItem(),
                  (Integer) monthBox.getSelectedItem(),
                  (Integer) yearBox.getSelectedItem(),
                  (Integer) hourBox.getSelectedItem(),
                  (Integer) minuteBox.getSelectedItem());

            Employee e1 = adapterEmployee.getEmployee(employeeField.getText());
            Treatment t1 = (Treatment) treatmentBox.getSelectedItem();

            int cust = Integer.parseInt(customerField.getText());

            Booking b = new Booking(d1, e1, t1, cust);

            // =========================================
            Treatment temp = (Treatment) treatmentBox.getSelectedItem();
            Date d2 = new Date((Integer) dayBox.getSelectedItem(),
                  (Integer) monthBox.getSelectedItem(),
                  (Integer) yearBox.getSelectedItem(),
                  (Integer) hourBox.getSelectedItem(),
                  (Integer) minuteBox.getSelectedItem());

            Date d3 = new Date((Integer) dayBox.getSelectedItem(),
                  (Integer) monthBox.getSelectedItem(),
                  (Integer) yearBox.getSelectedItem(),
                  (Integer) hourBox.getSelectedItem(),
                  (Integer) minuteBox.getSelectedItem());

            int modules = Integer.parseInt(modulesField.getText());
            d3.addMinutes(modules * 30);

            BookingList allForEmp = adapterBooking
                  .getBookingsByEmployee(employeeField.getText());

            for (int i = 0; i < allForEmp.getSize(); i++)
            {

               Date start = allForEmp.getBooking(i).getDate();
               Date end = allForEmp.getBooking(i).getFinishDate();

               if (d2.isBefore(end) && end.isBefore(d3)
                     || (d2.isBefore(start) && start.isBefore(d3))
                     || (start.isBefore(d2) && d2.isBefore(end))
                     || (d2.isBefore(start) && start.isBefore(d2))
                     || (d2.equals(start)))

               {
                  JOptionPane.showMessageDialog(null,
                        "The selected assistant is not available "
                              + "at this time, please change the time.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                  success = false;
                  break;
               }
            }
            // ==================================================================

            if (success)

            {
               adapterBooking.addBooking(b);
               tabPane.setSelectedIndex(2);
            }

         }

         // }

         if (e.getSource() == getEmployeeButton)
         {
            updateEmployeeBookingTable();
         }

         if (e.getSource() == getNotShowUpButton)
         {
            updateTableByShowUp();
         }

         if (e.getSource() == updateShowUpButton)
         {

            int bookingNumber = Integer.parseInt(bookNum.getText());

            BookingList all = adapterBooking.getAllBookings();
            all.getBooking(bookingNumber).showUp();
            adapterBooking.saveBookings(all);
            updateBookingTable();
         }

         if (e.getSource() == removeButton)
         {

            int bookingNumber = Integer.parseInt(bookNum2.getText());

            BookingList all = adapterBooking.getAllBookings();
            all.removeBooking2(bookingNumber);
            adapterBooking.saveBookings(all);
            updateBookingTable();
         }

      }
   }

   /*
    * Inner change listener class.
    * @author Jakub Lemka
    * @version 1.0
    */

   private class MyTabListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         if (((JTabbedPane) e.getSource()).getSelectedIndex() == 1)
         {
            updateTreatmentBox();
            dayBox.removeAllItems();
            for (int i = 1; i <= 31; i++)
            {
               dayBox.addItem(i);
            }
         }
         if (((JTabbedPane) e.getSource()).getSelectedIndex() == 2)
         {
            updateEmployeeBox();
            updateBookingTable();
         }

         if (((JTabbedPane) e.getSource()).getSelectedIndex() == 3)
         {

            Font font6 = new Font("SansSerif", Font.BOLD, 80);
            elseField.setFont(font6);
            elseField.setForeground(Color.black);
            elseField.setText(String.valueOf(adapterBooking.getAllBookings()
                  .getNumOfBookings("Else")));

            karinField.setText(String.valueOf(adapterBooking.getAllBookings()
                  .getNumOfBookings("Karin")));
            karinField.setFont(font6);
            karinField.setForeground(Color.black);

            anetteField.setText(String.valueOf(adapterBooking.getAllBookings()
                  .getNumOfBookings("Anette")));
            anetteField.setFont(font6);
            anetteField.setForeground(Color.black);

            helleField.setText(String.valueOf(adapterBooking.getAllBookings()
                  .getNumOfBookings("Helle")));
            helleField.setFont(font6);
            helleField.setForeground(Color.black);

            anniField.setText(String.valueOf(adapterBooking.getAllBookings()
                  .getNumOfBookings("Anni")));
            anniField.setFont(font6);
            anniField.setForeground(Color.black);
         }
      }
   }

   public static void main(String[] args)
   {

      ViaHairAPPLICATION hair = new ViaHairAPPLICATION();
   }
}