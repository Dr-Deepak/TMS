/**
 * Name: Shivam Gulati, Deepak Sharma
 * Assignment 2
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DbInfo;

/**
 *
 * @author Deepak
 */
public class TMSGui extends JFrame {

    //panels
    private JPanel greetPanel, HrTab, InvTab, createEmployeePanel, searchEmployeePanel, searchEmployeeInfoPanel,
            createEmployeeInfoPanel, createEmployeePositionPanel, productTab, manufacturerTab, customerInfoPanel,
            createProductPanel, searchProductPanel, createProductInfoPanel, searchProductInfoPanel,salesSearchPanel,
            createManufacturerPanel, searchManufacturerPanel, createManufactureInfoPanel, searchManufacturerInfoPanel,
            exitBtnPanel, createBtnPanel, searchBtnPanel, createEmployeeSouthPanel, salesInfoPanel,saleTotalWithBtnPanel,
            SalesTab,newSalePanel,saleSearchInfo,southSalePanel;
    //labels
    private JLabel lblFirstName, lblLastName, lblDOB, lblGender, lblSalary, lblEmail, lblSinNumber, lblPhone, lblPrice,lblCxForSearch,
            lblProductName, lblBarcode, lblQuantity, lblDepartment, lblPosition, lblGreeting, lblEmpType,
            lblManufacturerName, lblManufacturerPhone, lblManufacturerEmail, lblManufacturerCity, lblProductSold,lblTransNum,
            lblPotComm,lblExistCust,lblCusName,lblCusAddress,lblCusEmail, lblSellingEmployee,lblTotalAmount,lblDisplayTotal;
    //text fields
    private JTextField txtFldFirstName, txtFldLastName, txtFldSearchFirstName, txtFldDateOfBirth, txtFldSearchLastName, txtFldGender,
            txtFldEmail, txtFldSalary, txtFldSinNum, txtFldPhone, txtFldDepartment, txtFldPosition, txtFldSearchDepartment,
            txtFldSearchPosition, txtFldQuantity, txtFldBarcode, txtFldPackSize, txtFldManufacturerName, txtFldManufacturerPh,
            txtFldProductName, txtFldManufactureAddress, txtFldManufacturerCity, txtFldSearchProductName, txtFldProductPrice,
            txtFldSearchManufacturer, txtFldPotCom,txtFldCusName,txtFldCusAddress,txtFldCusEmail,txtTransNum,txtCxSearch;
    //buttons
    private JButton btnExit, btnCreateEmployee, btnCreateProduct, btnCreateManufacturer, btnSearchEmployee, btnSearchProduct,
            btnSearchManufacturer,btnSearchSale,btnCreateNewSale;
    //tabbed panes
    private JTabbedPane HRTabPane, InvTabPane, ProductTabPane, ManufacturerTabPane,SalesTabPane;
    //ComboBoxes
    private JComboBox comboBoxEmployeeType, comBoxSellEmployee, productComboBox,existCxComboBox  ;
    private String[] EmployeeTypes = {"Base + Commission", "Commissioned", "Salaried", "Hourly -Full-Time", "Hourly -Part-Time"};
    private String employeePosition ="";

    public TMSGui() {
        
        
        //super call with title
        super("The Management System");
//        Login();
//define layout manager
        setLayout(new BorderLayout());
//create tabbed pane
        JTabbedPane masterTabPane = new JTabbedPane();
//call gui builder methods
        buildGreetingPanel("The Management System");
        buildHrTabPanel();
        buidInventoryTab();
        buildSalesTab();
        buildExitButtonPanel();
        
        masterTabPane.addTab("Human Resources", null, HrTab, "HR Module");
        masterTabPane.addTab("Inventory", null, InvTab, "Inventory Module");
        masterTabPane.addTab("Sale", null,SalesTab, "Sales Module");
        //adding the components to main panel
        add(greetPanel, BorderLayout.NORTH);
        add(masterTabPane, BorderLayout.CENTER);
        add(exitBtnPanel, BorderLayout.SOUTH);
        }
       
    
    private void buildGreetingPanel(String lblTxt) {
        this.greetPanel = new JPanel();
        lblGreeting = new JLabel(lblTxt);
        lblGreeting.setFont(new Font("Arial", Font.BOLD & Font.ITALIC, 24));
        greetPanel.add(this.lblGreeting);
    }

/**TAB BuildingMethods STARTS*/
    //HR Tab building methods starts
    private void buildHrTabPanel() {
        HrTab = new JPanel();
        HRTabPane = new JTabbedPane();
        buildCreateEmployeePanel();
        buildSearchEmployeePanel();

        HrTab.setLayout(new BorderLayout());
        HRTabPane.addTab("Create", null, createEmployeePanel, "Create new Employee");
        HRTabPane.addTab("Search", null, searchEmployeePanel, "Search employees, products, maufacturer");
        HrTab.add(HRTabPane, BorderLayout.CENTER);
    }
    //HR sub builder methods
    private void buildCreateEmployeePanel() {
//Master panelyee");
//set the layout manager for the main p that holds every thing in create tab        
        createEmployeePanel = new JPanel();
        createEmployeeInfoPanel = new JPanel();
        createEmployeePositionPanel = new JPanel();
        createEmployeeSouthPanel = new JPanel();
        comboBoxEmployeeType = new JComboBox(EmployeeTypes);
        comboBoxEmployeeType.setToolTipText("Select type below");
        buildCreateButtonPanel("Employee");
//set the layout manager for the main page in the tab one
        createEmployeePanel.setLayout(new BorderLayout());
        createEmployeeInfoPanel.setLayout(new GridLayout(8, 2));
        createEmployeePositionPanel.setLayout(new GridLayout(3, 2));
        createEmployeeSouthPanel.setLayout(new FlowLayout());
//create a border around the pannel
        createEmployeeInfoPanel.setBorder(BorderFactory.createTitledBorder("Employee Information"));
        createEmployeePositionPanel.setBorder(BorderFactory.createTitledBorder("Position Information"));

//initiallize the components
        //initialize Labels
        // employee info labels
        lblFirstName = new JLabel("First Name");
        lblLastName = new JLabel("Last Name");
        lblDOB = new JLabel("Date of Birth");
        lblGender = new JLabel("Gender");
        lblSalary = new JLabel("Hourly Rate");
        lblEmail = new JLabel("Email");
        lblSinNumber = new JLabel("Sin");
        lblPhone = new JLabel("Phone");
        //employee position info labels
        lblDepartment = new JLabel("Department");
        lblPosition = new JLabel("Position");

        //assign labels to textfields
        lblFirstName.setLabelFor(this.txtFldFirstName);
        lblLastName.setLabelFor(this.txtFldLastName);
        lblDOB.setLabelFor(this.txtFldDateOfBirth);
        lblGender.setLabelFor(this.txtFldGender);
        lblSalary.setLabelFor(this.txtFldSalary);
        lblEmail.setLabelFor(this.txtFldEmail);
        lblSinNumber.setLabelFor(this.txtFldSinNum);
        lblPhone.setLabelFor(this.txtFldPhone);
        lblDepartment.setLabelFor(this.txtFldDepartment);
        lblPosition.setLabelFor(this.txtFldPosition);

        //initialize textfields    
        txtFldFirstName = new JTextField(15);
        txtFldLastName = new JTextField(15);
        txtFldDateOfBirth = new JTextField(15);
        txtFldGender = new JTextField(15);
        txtFldSalary = new JTextField(10);
        txtFldEmail = new JTextField(20);
        txtFldSinNum = new JTextField(11);
        txtFldPhone = new JTextField(12);
        txtFldDepartment = new JTextField(15);
        txtFldPosition = new JTextField(15);

        //add components to panel
        createEmployeeInfoPanel.add(this.lblFirstName);
        createEmployeeInfoPanel.add(this.txtFldFirstName);
        createEmployeeInfoPanel.add(this.lblLastName);
        createEmployeeInfoPanel.add(this.txtFldLastName);
        createEmployeeInfoPanel.add(this.lblPhone);
        createEmployeeInfoPanel.add(this.txtFldPhone);
        createEmployeeInfoPanel.add(this.lblDOB);
        createEmployeeInfoPanel.add(this.txtFldDateOfBirth);
        createEmployeeInfoPanel.add(this.lblGender);
        createEmployeeInfoPanel.add(this.txtFldGender);
        createEmployeeInfoPanel.add(this.lblSalary);
        createEmployeeInfoPanel.add(this.txtFldSalary);
        createEmployeeInfoPanel.add(this.lblEmail);
        createEmployeeInfoPanel.add(this.txtFldEmail);
        createEmployeeInfoPanel.add(this.lblSinNumber);
        createEmployeeInfoPanel.add(this.txtFldSinNum);

//Creating position information of employee panel
//add components to the panel
        createEmployeePositionPanel.add(this.lblDepartment);
        createEmployeePositionPanel.add(this.txtFldDepartment);
        createEmployeePositionPanel.add(this.lblPosition);
        createEmployeePositionPanel.add(this.txtFldPosition);

//add button and combobox to south panel
        lblEmpType = new JLabel("Select employee type: ");
        lblEmpType.setLabelFor(comboBoxEmployeeType);
        createEmployeeSouthPanel.add(lblEmpType);
        createEmployeeSouthPanel.add(comboBoxEmployeeType);
        createEmployeeSouthPanel.add(createBtnPanel);

//add the panels of employeeInfo, positon and button inside the create panel
        createEmployeePanel.add(createEmployeeInfoPanel, BorderLayout.NORTH);
        createEmployeePanel.add(createEmployeePositionPanel, BorderLayout.CENTER);
        createEmployeePanel.add(createEmployeeSouthPanel, BorderLayout.SOUTH);
    }
    private void buildSearchEmployeePanel() {
//Master panel that holds every thing in create tab

        searchEmployeePanel = new JPanel();
        //set the layout manager for the main page in the tab one
        searchEmployeePanel.setLayout(new BorderLayout());
//Build search button
        buildSearchButtonPanel("Employee");

//Creating Employee information panel
        searchEmployeeInfoPanel = new JPanel();
//set the layout
        searchEmployeeInfoPanel.setLayout(new GridLayout(2, 2));
//ceate a border around the panel
        searchEmployeeInfoPanel.setBorder(BorderFactory.createTitledBorder("Search Employee"));

//initiallize the components
        lblFirstName = new JLabel("First Name");
        lblLastName = new JLabel("Last Name");
        lblPosition = new JLabel("Position");
        lblDepartment = new JLabel("Department");

        // intialize TextFields
        txtFldSearchFirstName = new JTextField(15);
        txtFldSearchLastName = new JTextField(15);
        txtFldSearchPosition = new JTextField(15);
        txtFldSearchDepartment = new JTextField(15);

        //assign labels to textfields
        lblFirstName.setLabelFor(this.txtFldSearchFirstName);
        lblLastName.setLabelFor(this.txtFldSearchLastName);
        lblPosition.setLabelFor(this.txtFldSearchPosition);
        lblDepartment.setLabelFor(this.txtFldSearchDepartment);

        searchEmployeeInfoPanel.add(lblFirstName);
        searchEmployeeInfoPanel.add(txtFldSearchFirstName);
        searchEmployeeInfoPanel.add(lblLastName);
        searchEmployeeInfoPanel.add(txtFldSearchLastName);
        searchEmployeeInfoPanel.add(lblPosition);
        searchEmployeeInfoPanel.add(txtFldSearchPosition);
        searchEmployeeInfoPanel.add(lblDepartment);
        searchEmployeeInfoPanel.add(txtFldSearchDepartment);

//add search panel and button to tab
        searchEmployeePanel.add(searchEmployeeInfoPanel, BorderLayout.NORTH);
        searchEmployeePanel.add(this.searchBtnPanel, BorderLayout.SOUTH);
    }
    //HR Tab building methods Ends

/**Inventory TAB Builder methods Starts*/
    private void buidInventoryTab() {
        InvTab = new JPanel();
        InvTabPane = new JTabbedPane();
        buildProductTab();
        buildManufacturerTab();
        InvTab.setLayout(new BorderLayout());
        InvTabPane.addTab("Product", null, productTab, "Create new or Search products ");
        InvTabPane.addTab("Manufacturer", null, manufacturerTab, "Search employees, products, maufacturer");
        InvTab.add(InvTabPane, BorderLayout.CENTER);
    }
    
// Product TAB builder methods
    private void buildProductTab() {
        productTab = new JPanel();
        ProductTabPane = new JTabbedPane();
        buildCreateProductTab();
        buildSearchProductTab();
        productTab.setLayout(new BorderLayout());
        ProductTabPane.addTab("Create", null, createProductPanel, "Create new Employee");
        ProductTabPane.addTab("Search", null, searchProductPanel, "Search employees, products, maufacturer");
        productTab.add(ProductTabPane, BorderLayout.NORTH);
    }
    //product sub Tabs
    private void buildCreateProductTab() {
        //Master panel that holds every thing in create tab
        buildCreateButtonPanel("Product");
        createProductPanel = new JPanel();
//set the layout manager for the main page in the tab one
        createProductPanel.setLayout(new BorderLayout());

//Creating Employee information panel
        createProductInfoPanel = new JPanel();

//set the layout
        createProductInfoPanel.setLayout(new GridLayout(2, 2));

//create a border around the pannel
        createProductInfoPanel.setBorder(BorderFactory.createTitledBorder("Enter Product Information"));
//initiallize the components  
        lblProductName      = new JLabel("First Name");
        lblManufacturerName = new JLabel("ManufacturerName");
        lblQuantity         = new JLabel("Quantity");
        lblBarcode          = new JLabel("Barcode");               
        txtFldProductName      = new JTextField(15);
        txtFldManufacturerName = new JTextField(15);
        txtFldQuantity         = new JTextField(15);
        txtFldBarcode          = new JTextField(15);
        
        //assign labels to textfields
        lblFirstName.setLabelFor(this.txtFldProductName);
        lblManufacturerName.setLabelFor(this.txtFldManufacturerName);
        lblQuantity.setLabelFor(this.txtFldQuantity);
        lblBarcode.setLabelFor(this.txtFldBarcode);

        //add components to panel
        createProductInfoPanel.add(this.lblProductName);
        createProductInfoPanel.add(this.txtFldProductName);
        createProductInfoPanel.add(this.lblManufacturerName);
        createProductInfoPanel.add(this.txtFldManufacturerName);
        createProductInfoPanel.add(this.lblQuantity);
        createProductInfoPanel.add(this.txtFldQuantity);
        createProductInfoPanel.add(this.lblBarcode);
        createProductInfoPanel.add(this.txtFldBarcode);

        //add product information panel to product panel
        createProductPanel.add(createProductInfoPanel, BorderLayout.NORTH);
        createProductPanel.add(this.createBtnPanel, BorderLayout.SOUTH);
    }
    private void buildSearchProductTab() {
        searchProductPanel = new JPanel();
        //set the layout manager for the main page in the tab one
        searchProductPanel.setLayout(new BorderLayout());
//Build search button
        buildSearchButtonPanel("Product");
//Creating Product information panel
        searchProductInfoPanel = new JPanel();
//set the layout
        searchProductInfoPanel.setLayout(new GridLayout(2, 2));
//ceate a border around the panel
        searchProductInfoPanel.setBorder(BorderFactory.createTitledBorder("Search Product"));
//initiallize the components
        // intialize labels
        lblProductName = new JLabel("Product Name");
        lblManufacturerName = new JLabel("ManufacturerName");

        //assign labels to textfields
        lblFirstName.setLabelFor(this.txtFldProductName);
        lblManufacturerName.setLabelFor(this.txtFldManufacturerName);

        // intialize TextFields
        txtFldSearchProductName = new JTextField(15);
        txtFldSearchManufacturer = new JTextField(15);

//add search panel and button to tab
        searchProductPanel.add(searchProductInfoPanel, BorderLayout.NORTH);
        searchProductPanel.add(this.searchBtnPanel, BorderLayout.SOUTH);
    }
    
// Manufacturer TAB builder methods
    private void buildManufacturerTab() {
        manufacturerTab = new JPanel();
        buildCreateManufacturerTab();
        buildSearchManufacturerTab();
        ManufacturerTabPane = new JTabbedPane();
        manufacturerTab.setLayout(new BorderLayout());
        ManufacturerTabPane.addTab("Create", null, createManufacturerPanel, "Create new manufacturer");
        ManufacturerTabPane.addTab("Search", null, searchManufacturerPanel, "Search maufacturer");
        manufacturerTab.add(ManufacturerTabPane, BorderLayout.CENTER);
    }
    //Manufacture sub tabs
    private void buildCreateManufacturerTab() {
        createManufacturerPanel = new JPanel();
        createManufactureInfoPanel = new JPanel();
        buildCreateButtonPanel("Manufacturer");
//set the layout
        createManufacturerPanel.setLayout(new BorderLayout());
        createManufactureInfoPanel.setLayout(new GridLayout(2, 2));
//create a border around the pannel
        createManufactureInfoPanel.setBorder(BorderFactory.createTitledBorder("Enter Manufacture Info"));
//initiallize the components
        lblManufacturerName = new JLabel("Manufacturer Name");
        lblManufacturerPhone = new JLabel("Phone");
        lblManufacturerEmail = new JLabel("Email");
        lblManufacturerCity = new JLabel("City");

        txtFldManufacturerName = new JTextField(15);
        txtFldManufacturerPh = new JTextField(15);
        txtFldManufactureAddress = new JTextField(15);
        txtFldManufacturerCity = new JTextField(15);
        //assign labels to related textfields
        lblManufacturerName.setLabelFor(txtFldManufacturerName);
        lblManufacturerPhone.setLabelFor(txtFldManufacturerPh);
        lblManufacturerEmail.setLabelFor(txtFldManufactureAddress);
        lblManufacturerCity.setLabelFor(txtFldManufacturerCity);
        //Add initiated components to panel
        createManufactureInfoPanel.add(lblManufacturerName);
        createManufactureInfoPanel.add(txtFldManufacturerName);
        createManufactureInfoPanel.add(lblManufacturerPhone);
        createManufactureInfoPanel.add(txtFldManufacturerPh);
        createManufactureInfoPanel.add(lblManufacturerEmail);
        createManufactureInfoPanel.add(txtFldManufactureAddress);
        createManufactureInfoPanel.add(lblManufacturerCity);
        createManufactureInfoPanel.add(txtFldManufacturerCity);
        //add components to panel
        createManufacturerPanel.add(createManufactureInfoPanel, BorderLayout.NORTH);
        createManufacturerPanel.add(createBtnPanel, BorderLayout.SOUTH);
    }
    private void buildSearchManufacturerTab() {
        searchManufacturerPanel = new JPanel();
        searchManufacturerInfoPanel = new JPanel();
        //set the layout manager for the main page in the tab one
        searchManufacturerPanel.setLayout(new BorderLayout());
        searchManufacturerInfoPanel.setLayout(new GridLayout(2, 2));
        buildSearchButtonPanel("Manufacturer");
//ceate a border around the panel
        searchManufacturerInfoPanel.setBorder(BorderFactory.createTitledBorder("Search Manufacture"));
//initiallize the components
        lblManufacturerName = new JLabel("Manufacturer Name");
        lblManufacturerPhone = new JLabel("Phone");
        txtFldManufacturerName = new JTextField(15);
        txtFldManufacturerPh = new JTextField(15);
        //assign labels to related textfields
        lblManufacturerName.setLabelFor(txtFldManufacturerName);
        lblManufacturerPhone.setLabelFor(txtFldManufacturerPh);
        //Add initiated components to panel
        searchManufacturerInfoPanel.add(lblManufacturerName);
        searchManufacturerInfoPanel.add(txtFldManufacturerName);
        searchManufacturerInfoPanel.add(lblManufacturerPhone);
        searchManufacturerInfoPanel.add(txtFldManufacturerPh);
        //add search panel and button to tab
        searchManufacturerPanel.add(searchManufacturerInfoPanel, BorderLayout.NORTH);
        searchManufacturerPanel.add(searchBtnPanel, BorderLayout.SOUTH);
    }
/**Inventory TAB Builder methods ENDS*/
    
/** Sales TAB builder methods starts */
    private void buildSalesTab() {
        SalesTab = new JPanel();
        SalesTabPane = new JTabbedPane();        
        buildNewSaleTab();
        buildSearchSalesPanel();
//        
//        //new sales panel and its components
//        //search panel for searching the transaction
//        salesSearchPanel1.add(salesSearchPanel, BorderLayout.NORTH);
//        salesSearchPanel1.add(salesSearchBtnPanel, BorderLayout.SOUTH);
//        //adding the sales tab to the main tab 
        
        SalesTab.setLayout(new BorderLayout());
        SalesTabPane.addTab("New Sale", null, newSalePanel, "New Sale");
        SalesTabPane.addTab("Search", null, salesSearchPanel, "Search the sale/transaction");
        
        SalesTab.add(SalesTabPane, BorderLayout.NORTH);
        SalesTab.setVisible(true);
        
    }
    //Sales sub tabs
    private void buildNewSaleTab() {
        //instantiating components       
             newSalePanel = new JPanel();
    saleTotalWithBtnPanel = new JPanel();        
        salesInfoPanel    = new JPanel();
        customerInfoPanel = new JPanel();     
        lblProductSold    = new JLabel("Product");
        lblPrice          = new JLabel("Price");
        lblPotComm        = new JLabel("Potential Commission");
        lblSellingEmployee= new JLabel("Select selling employee");
        lblExistCust      = new JLabel("Select if existing Customer");
        lblCusName        = new JLabel("Name");
        lblCusAddress     = new JLabel("Address");
        lblCusEmail       = new JLabel("Email");
        lblTotalAmount    = new JLabel("Total Amount:");
        lblDisplayTotal   = new JLabel("$$$ Total in $$$");        
        productComboBox   = new JComboBox();
        comBoxSellEmployee= new JComboBox();
        existCxComboBox   = new JComboBox();         
        txtFldProductPrice= new JTextField(15);
        txtFldPotCom      = new JTextField(15);
        txtFldCusName     = new JTextField(15);
        txtFldCusAddress  = new JTextField(30);
        txtFldCusEmail    = new JTextField(30);
        buildCreateButtonPanel("New Sale");
        
        //set layouts of allthe pannels in new sale tab
        newSalePanel.setLayout(new BorderLayout());
        salesInfoPanel.setLayout(new GridLayout(4, 2));
        customerInfoPanel.setLayout(new GridLayout(4, 2));
        saleTotalWithBtnPanel.setLayout(new FlowLayout());        
        
        //add the titled border
        salesInfoPanel.setBorder(BorderFactory.createTitledBorder("New Sale Info"));
        customerInfoPanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));
        saleTotalWithBtnPanel.setBorder(BorderFactory.createTitledBorder("Sale Totals"));
        
        //adding instantiated sales info components to salesInfo Panel
        salesInfoPanel.add(lblSellingEmployee);
        salesInfoPanel.add(comBoxSellEmployee);
        salesInfoPanel.add(lblProductSold);
        salesInfoPanel.add(productComboBox);
        salesInfoPanel.add(lblPrice);
        salesInfoPanel.add(txtFldProductPrice);
        salesInfoPanel.add(lblPotComm);
        salesInfoPanel.add(txtFldPotCom);      
      
        //adding instantiated customer info components to customerInfo Panel
        customerInfoPanel.add(lblExistCust);
        customerInfoPanel.add(existCxComboBox);
        customerInfoPanel.add(lblCusName);
        customerInfoPanel.add(txtFldCusName);
        customerInfoPanel.add(lblCusAddress);
        customerInfoPanel.add(txtFldCusAddress);
        customerInfoPanel.add(lblCusEmail);
        customerInfoPanel.add(txtFldCusEmail);
       
        //seperate panel to add total & diaplay total amount and create button
        saleTotalWithBtnPanel.add(lblTotalAmount);
        saleTotalWithBtnPanel.add(lblDisplayTotal);
        saleTotalWithBtnPanel.add(btnCreateNewSale);
        
//add customer and sale info panels to new sale Tab
        newSalePanel.add(customerInfoPanel, BorderLayout.NORTH);
        newSalePanel.add(salesInfoPanel, BorderLayout.CENTER);
        newSalePanel.add(saleTotalWithBtnPanel, BorderLayout.SOUTH);
        newSalePanel.setVisible(true);
    }      
    private void buildSearchSalesPanel() {
        
        salesSearchPanel= new JPanel();  
        saleSearchInfo  = new JPanel();
        southSalePanel  = new JPanel();
        lblTransNum     = new JLabel("Transaction Number");
        lblCxForSearch  = new JLabel("Customer Name");      
        txtTransNum     = new JTextField(15);
        txtCxSearch     = new JTextField(15);        
        buildSearchButtonPanel("Search Transaction");        
        saleSearchInfo.setLayout(new GridLayout(2,1));
        salesSearchPanel.setLayout(new BorderLayout());
        southSalePanel.setLayout(new FlowLayout());
        
        salesSearchPanel.setBorder(BorderFactory.createTitledBorder("Search using the following the criteria"));
        
        //adding the labels and panels
        saleSearchInfo.add(lblTransNum);
        saleSearchInfo.add(txtTransNum);
        saleSearchInfo.add(lblCxForSearch);
        saleSearchInfo.add(txtCxSearch);
        southSalePanel.add(btnSearchSale);
        
        salesSearchPanel.add(saleSearchInfo, BorderLayout.NORTH);
        salesSearchPanel.add(southSalePanel, BorderLayout.CENTER);
    }  
/** All Tab building methods ENDS */

/**Button builder methods for all buttons Exit,Create,Search- STARTS  */
    private void buildExitButtonPanel() {
        exitBtnPanel = new JPanel();
        btnExit = new JButton("Exit");
        exitBtnPanel.add(btnExit);
        btnExit.addActionListener(new ExitButtonListener());
    }
    
//builds create button according to given parameters
    private void buildCreateButtonPanel(String str) {
        createBtnPanel = new JPanel();
        if (str.equalsIgnoreCase("Employee")) {
            btnCreateEmployee = new JButton("Create");
            btnCreateEmployee.addActionListener(new CreateButtonListener());
            createBtnPanel.add(btnCreateEmployee);
        } else if (str.equalsIgnoreCase("Product")) {
            btnCreateProduct = new JButton("Create");
            btnCreateProduct.addActionListener(new CreateButtonListener());
            createBtnPanel.add(btnCreateProduct);
        } else if (str.equalsIgnoreCase("Manufacturer")) {
            btnCreateManufacturer = new JButton("Create");
            btnCreateManufacturer.addActionListener(new CreateButtonListener());
            createBtnPanel.add(btnCreateManufacturer);
        }else if (str.equalsIgnoreCase("New Sale")) {
            btnCreateNewSale = new JButton("Create New Sale");
            btnCreateNewSale.addActionListener(new CreateButtonListener());
            createBtnPanel.add(btnCreateNewSale);
        }
    }
    
//builds search button according to given parameters
    private void buildSearchButtonPanel(String str) {
        searchBtnPanel = new JPanel();
        if (str.equalsIgnoreCase("Employee")) {
            btnSearchEmployee = new JButton("Search");
            btnSearchEmployee.addActionListener(new SearchButtonListener());
            searchBtnPanel.add(btnSearchEmployee);
        } else if (str.equalsIgnoreCase("Product")) {
            btnSearchProduct = new JButton("Search");
            btnSearchProduct.addActionListener(new SearchButtonListener());
            searchBtnPanel.add(btnSearchProduct);
        } else if (str.equalsIgnoreCase("Manufacturer")) {
            btnSearchManufacturer = new JButton("Search");
            btnSearchManufacturer.addActionListener(new SearchButtonListener());
            searchBtnPanel.add(btnSearchManufacturer);
        }else if (str.equalsIgnoreCase("Search Transaction")) {
            btnSearchSale = new JButton("Search Sale");
            btnSearchSale.addActionListener(new SearchButtonListener());
            searchBtnPanel.add(btnSearchSale);
        }
    }
/**All Button builder methods ENDS*/
    private boolean Login (){
        Connection conn ;     
        Statement stat ;
        ResultSet rs;
        DbInfo db = new DbInfo();
        JPanel panel = new JPanel();
        
        //login components
        JLabel lblUserName = new JLabel("Enter Username"),
                lblPassword = new JLabel("Enter Password");
        JTextField txtFldUserName = new JTextField(15);
        JPasswordField txtFldPassword = new JPasswordField(15);
        int counter = 0;
        boolean dbCredCheck = false;
        
        panel.add(lblUserName);
        panel.add(txtFldUserName);
        panel.add(lblPassword);
        panel.add(txtFldPassword);
        
        
        //loop asking user to authenticate user
        String[] buttonOps = new String[]{"OK", "Cancel"};
        
        do {
            JOptionPane loginJoP = null;
            int result = JOptionPane.showOptionDialog(null, panel, "Enter Login Info",
                    JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttonOps, buttonOps[0]);
            
            if (result == 0) {
                try {                  
                  // Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("Class.forname processed");
                    
//                conn = DriverManager.getConnection(db.getDB_URL(),db.getDB_UsName(),db.getDB_PsWord());
                
conn = DriverManager.getConnection("jdbc:mysql://sql.computerstudi.es:3306/gc200329873","gc200329873","Jhm-JFa^");
                  System.out.println("text field:"+txtFldUserName.getText());
                stat = conn.createStatement();             
                  
//                rs = stat.executeQuery("Select * from login where uName ="+"'"+txtFldUserName.getText()+"'"+
//                        "and Password="+"'"+(new String(txtFldPassword.getPassword()))+"'" );
                rs = stat.executeQuery("Select * from login where uName ='gc200329873'and pWord='Jhm-JFa^" );
                
                        if(rs.next()){
                            employeePosition =rs.getString(3);
                        }
                      System.out.println(employeePosition);
                    conn.close();
                    dbCredCheck = true;                    
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password" + "\n Please try again");

                    // reset  the loop check 
                    dbCredCheck = false;

                    // increment the counter
                    counter++;
                    if (counter > 3) {
                        JOptionPane.showMessageDialog(null, "Faliure to authenicate. "
                                + "The system will shut down");
                        System.exit(0);
                    }
                }
            } else {
                System.exit(0);
            }
        } while (!dbCredCheck);
        return employeePosition !="" ;
    }

/**Button Listeners methods for Exit,Create,Search starts */
    private class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if (JOptionPane.showConfirmDialog(null, "Are you sure want to close ?", "Exit", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }
    }

    private class CreateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

//            if (JOptionPane.showConfirmDialog(null, "Are you sure want to close ?", "Exit", JOptionPane.YES_NO_OPTION) == 0) {
//                System.exit(0);
//            }
        }
    }

    private class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

//            if (JOptionPane.showConfirmDialog(null, "Are you sure want to close ?", "Exit", JOptionPane.YES_NO_OPTION) == 0) {
//                System.exit(0);
//            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        TMSGui gui = new TMSGui();       
        gui.setBounds(300, 150, 600, 600);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);

    }
}
