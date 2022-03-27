/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliancesinfo;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hp
 */
public class AppliancesInfo extends javax.swing.JFrame {
    /**
     * Creates new form AppliancesInfo
     */
    public AppliancesInfo() {
        initComponents();
        
        String []arrayFirst = {"1", "Samsung Note 10", "Earphone", "Samsung", "116000", "8 GB", "64 GB", "3500 mAh", "12 mpx", "10Inch", "SnapDragon", "Yes"};
        String []arraySecond = {"2", "Huawei Nova 3i", "Ear Pods", "Huawei", "35000", "4 GB", "128 GB", "3200 mAh", "18 mpx", "9.5Inch", "Kerin 650", "Yes"};
        String []arrayThird = {"3", "Nokia 8", "Data Cable", "Nokia", "27750", "4 GB", "64 GB", "3090 mAh", "13 mpx", "5.3Inch", "SnapDragon 835", "Yes"};
        String []arrayForth = {"4", "iPhone 12 Pro Max", "Mobile Charger", "Apple", "185990", "8 GB", "128 GB", "3500 mAh", "48 mpx", "9Inch", "Six-core", "Yes"};
        String []arrayFifth = {"5", "Redmi 8", "Tempered Glass", "Redmi", "15999", "4 GB", "64GB", "5000 mAh", "12 mpx", "6.22 Inch", "SnapDragon 439", "Yes"};
        String []arraySixth = {"6", "Microsoft Lumia 540", "Mobile Case", "Microsoft", "15000", "4 GB", "64GB", "2500 mAh", "10 mpx", "5.45Inch", "SnapDragon", "No"};
        String []arraySeventh = {"7", "Samsung Galaxy A50 ", "Earphone", "Samsung", "26699", "4 GB", "64GB", "4000 mAh", "25 mpx", "6.4Inch", "Octa-Core", "Yes"};
        String []arrayEighth = {"8", "Huawei Mate 40 Pro", "Mobile Charger", "Huawei", "128000", "8 GB", "256GB", "4200 mAh", "52 mpx", "9.7Inch", "Kerin 970", "Yes"};
        String []arrayNinth = {"9", "Asus Rog Phone 2", "Earphone", "Asus", "113000", "12 GB", "1 TB", "6000 mAh", "61 mpx", "6.59Inch", "SnapDragon 855 Plus", "Yes"};
        String []arrayTen = {"10", "Blackberry Key2 Le", "Mobile Case", "BlackBerry", "45600", "4 GB", "64GB", "2600 mAh", "13 mpx", "4.5Inch", "SnapDragon", "No"};
        String []arrayEleventh = {"11", "Asus Rog Phone 1", "Ear Pods", "Asus", "112000", "12 GB", "1 TB", "6000 mAh", "61 mpx", "6.59Inch", "SnapDragon 855 Plus", "Yes"};
        String []arrayTwelveth = {"12", "iPhone 10", "Earphone", "Apple", "110000", "4 GB", "256 GB", "3500 mAh", "61 mpx", "6.59Inch", "SnapDragon 855 Plus", "Yes"};

        for(int i=0; i<12; i++){
            applianceInformationSystemTable.setValueAt(arrayFirst[i], 0, i);
            applianceInformationSystemTable.setValueAt(arraySecond[i], 1, i);
            applianceInformationSystemTable.setValueAt(arrayThird[i], 2, i);
            applianceInformationSystemTable.setValueAt(arrayForth[i], 3, i);
            applianceInformationSystemTable.setValueAt(arrayFifth[i], 4, i);
            applianceInformationSystemTable.setValueAt(arraySixth[i], 5, i);
            applianceInformationSystemTable.setValueAt(arraySeventh[i], 6, i);
            applianceInformationSystemTable.setValueAt(arrayEighth[i], 7, i);
            applianceInformationSystemTable.setValueAt(arrayNinth[i], 8, i);
            applianceInformationSystemTable.setValueAt(arrayTen[i], 9, i);   
            applianceInformationSystemTable.setValueAt(arrayEleventh[i], 10, i); 
            applianceInformationSystemTable.setValueAt(arrayTwelveth[i], 11, i); 
        }
    }

    //linear search for search mobile by category
    public String applianceCategory(String[]b, String value){
        int rowCount=applianceInformationSystemTable.getRowCount();
        int colCount=0;
        
        for(int list=0; list<b.length; list++){
            if(b[list]==value){
                for(int j=0; j<rowCount; j++){
                    if(applianceInformationSystemTable.getValueAt(j,3)==value){
                        //System.out.println("App found");
                       JOptionPane.showMessageDialog(null,value+" found\n" +"Mobile_ID :"+ applianceInformationSystemTable.getValueAt(j,0)+"\n"+"Name :"+applianceInformationSystemTable.getValueAt(j,1)+"\n"+ "Accessories :"+ applianceInformationSystemTable.getValueAt(j,2)+"\n"+"Company :"+applianceInformationSystemTable.getValueAt(j,3)+"\n"+"Price :"+applianceInformationSystemTable.getValueAt(j,4),"RAM",JOptionPane.INFORMATION_MESSAGE);
                     colCount+=1;                   
                    }
                }
                break;
            }
        }
        if(colCount==0){
            JOptionPane.showMessageDialog(null, "Mobile not found..");
        }
        return "String";
    }
    
    
    
    
    //binary search for searching Mobile by price
    
    //merge sort for sorting
    public static void sort(int[] a)
     {  
      if (a.length <= 1) { return; }
      int[] first = new int[a.length / 2];
      int[] second = new int[a.length - first.length];
      // Copy the first half of a into first, the second half into second
      for (int list = 0; list < first.length; list++) 
      { 
         first[list] = a[list]; 
      }
      for (int list = 0; list < second.length; list++) 
      { 
         second[list] = a[first.length + list]; 
      }
      sort(first);
      sort(second);
      merge(first, second, a);
      
   }
    private static void merge(int[] first, int[] second, int[] a)
    {  
      int iFirst = 0; // Next element to consider in the first array
      int iSecond = 0; // Next element to consider in the second array
      int j = 0; // Next open position in a

      // As long as neither iFirst nor iSecond is past the end, move
      // the smaller element into a
      while (iFirst < first.length && iSecond < second.length)
      {  
         if (first[iFirst] < second[iSecond])
         {  
            a[j] = first[iFirst];
            iFirst++;
         }
         else
         {  
            a[j] = second[iSecond];
            iSecond++;
         }
         j++;
      }
   
    while (iFirst < first.length) 
      { 
         a[j] = first[iFirst]; 
         iFirst++; j++;
      }
    while (iSecond < second.length) 
      { 
         a[j] = second[iSecond]; 
         iSecond++; j++;
      }
       
   }
    
    //binary search
    public int search (int[]a,int low,int high,int value){
       
        int rowcount=applianceInformationSystemTable.getRowCount();  
        if (low<=high){
            int mid=(low+high)/2;            
            if (a[mid]==value){
               for (int z=0; z<rowcount;z++){
                    //converting the value of object string to integer
                    if(applianceInformationSystemTable.getValueAt(z, 4)!=null){
                        if (Integer.valueOf((String)applianceInformationSystemTable.getValueAt(z,4))==a[mid]){
                            //System.out.println("price found");
                            JOptionPane.showMessageDialog(null,value+" found\n" +"Mobile_ID :"+ applianceInformationSystemTable.getValueAt(z,0)+"\n"+"Name :"+applianceInformationSystemTable.getValueAt(z,1)+"\n"+ "Accessory :"+ applianceInformationSystemTable.getValueAt(z,2)+"\n"+"Company :"+applianceInformationSystemTable.getValueAt(z,3)+"\n"+"Price :"+applianceInformationSystemTable.getValueAt(z,4),"RAM",JOptionPane.INFORMATION_MESSAGE);
                        }  
                    }else{
                        //display nothing if it is null
                    }
                }
                return mid;                 
            }
            else if (a[mid]<value){
                return search(a,mid-1,high,value);                
            }
            else{
                return search(a,low,mid+1,value);                
            }        
        }
        else{
        JOptionPane.showMessageDialog(null,"Not found","Result",JOptionPane.INFORMATION_MESSAGE);        
        }        
        return -1;
    }
       
    //for import of csv file
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ramButtonGroup = new javax.swing.ButtonGroup();
        fingerPrintButtonGroup = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMobileID = new javax.swing.JTextField();
        txtMobileName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtManufactureCompany = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStorage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBattery = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCamera = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDisplay = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtProcessor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rdb4GB = new javax.swing.JRadioButton();
        rdb8GB = new javax.swing.JRadioButton();
        rdb16GB = new javax.swing.JRadioButton();
        rdbYes = new javax.swing.JRadioButton();
        rdbNo = new javax.swing.JRadioButton();
        cmbMobileAccessory = new javax.swing.JComboBox<>();
        btnAddMobileInformation = new javax.swing.JButton();
        btnClearMobileInformation = new javax.swing.JButton();
        btnCloseMobileInformation = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtSearchByPrice = new javax.swing.JTextField();
        searchByPrice = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        searchByCategory = new javax.swing.JComboBox<>();
        availableMobileCategory = new javax.swing.JButton();
        resetTableButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        applianceInformationSystemTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openItem = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        closeItem = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        helpItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mobile Information System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mobile Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mobile ID");

        txtMobileID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMobileIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMobileIDKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Mobile Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Mobile Accessory");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Manufacture Company");

        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPriceKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Price");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("RAM");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Storage");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Battery");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Camera");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Display");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Processor");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Fingerprint Sensor");

        ramButtonGroup.add(rdb4GB);
        rdb4GB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdb4GB.setText("4 GB");
        rdb4GB.setContentAreaFilled(false);

        ramButtonGroup.add(rdb8GB);
        rdb8GB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdb8GB.setText("8 GB");

        ramButtonGroup.add(rdb16GB);
        rdb16GB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdb16GB.setText("16 GB");

        fingerPrintButtonGroup.add(rdbYes);
        rdbYes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbYes.setText("Yes");

        fingerPrintButtonGroup.add(rdbNo);
        rdbNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbNo.setText("No");

        cmbMobileAccessory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----Select-----", "Mobile Case", "Mobile Charger", "Tempered Glass", "Earphone", "Ear Pods", "Data Cable" }));

        btnAddMobileInformation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddMobileInformation.setText("Add");
        btnAddMobileInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMobileInformationActionPerformed(evt);
            }
        });

        btnClearMobileInformation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClearMobileInformation.setText("Clear");
        btnClearMobileInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMobileInformationActionPerformed(evt);
            }
        });

        btnCloseMobileInformation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCloseMobileInformation.setText("Close");
        btnCloseMobileInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseMobileInformationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMobileID, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtManufactureCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbMobileAccessory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMobileName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBattery, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdbYes)
                                .addGap(18, 18, 18)
                                .addComponent(rdbNo)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddMobileInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdb4GB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdb8GB, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdb16GB))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnClearMobileInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCloseMobileInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBattery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbYes)
                            .addComponent(rdbNo)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMobileID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMobileName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMobileAccessory, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtManufactureCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdb4GB)
                            .addComponent(rdb8GB)
                            .addComponent(rdb16GB))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMobileInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearMobileInformation, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnCloseMobileInformation, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("“Appliances Information System”");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reset and Search Buttons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txtSearchByPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchByPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        searchByPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchByPrice.setText("Search Mobile");
        searchByPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByPriceActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Search By");

        searchByCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchByCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select---", "Samsung", "Nokia", "Apple", "Huawei", "Redmi", "BlackBerry", "Microsoft" }));

        availableMobileCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        availableMobileCategory.setText("Available Mobile in Category");
        availableMobileCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableMobileCategoryActionPerformed(evt);
            }
        });

        resetTableButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resetTableButton.setText("Reset Table");
        resetTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(searchByCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(availableMobileCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(txtSearchByPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(searchByPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(resetTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchByPrice)
                    .addComponent(searchByPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchByCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availableMobileCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        applianceInformationSystemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mobile ID", "Mobile Name", "Mobile Accessory", "Manufacture Company", "Price", "RAM", "Storage", "Battery", "Camera", "Display", "Processor", "Fingerprint Sensor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        applianceInformationSystemTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(applianceInformationSystemTable);
        if (applianceInformationSystemTable.getColumnModel().getColumnCount() > 0) {
            applianceInformationSystemTable.getColumnModel().getColumn(0).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(1).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(2).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(3).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(4).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(5).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(6).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(7).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(8).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(9).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(10).setResizable(false);
            applianceInformationSystemTable.getColumnModel().getColumn(11).setResizable(false);
        }

        jMenu1.setText("File");

        openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        jMenu1.add(openItem);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        closeItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        closeItem.setText("Close");
        closeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeItemActionPerformed(evt);
            }
        });
        jMenu1.add(closeItem);

        jMenuBar1.add(jMenu1);

        jMenu7.setText("Help");

        helpItem.setText("Project Guidence");
        helpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpItemActionPerformed(evt);
            }
        });
        jMenu7.add(helpItem);

        jMenuBar1.add(jMenu7);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(374, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMobileInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMobileInformationActionPerformed
        
            String mobile_id = txtMobileID.getText();
            String name = txtMobileName.getText();
            String accessory = cmbMobileAccessory.getSelectedItem().toString();
            String company = txtManufactureCompany.getText();
            String mobile_price = txtPrice.getText();
            
            String ram="";
                if(rdb4GB.isSelected()){
                    ram = "4 GB";
                }
                if(rdb8GB.isSelected()){
                    ram = "8 GB";
                }
                if(rdb16GB.isSelected()){
                    ram = "16 GB";
                }
            String storage = txtStorage.getText();
            String battery = txtBattery.getText();
            String camera = txtCamera.getText();
            String display = txtDisplay.getText();
            String processor = txtProcessor.getText();
            String fingerPrint="";
                if(rdbYes.isSelected()){
                    fingerPrint = "Yes";
                }
                if(rdbNo.isSelected()){
                    fingerPrint = "No";
                }
            
            
            String mobile_detail[] = {mobile_id, name, accessory, company, mobile_price, ram, storage, battery, camera, display, processor, fingerPrint};
            
            int nextRow = 0;
            
            int rowCount = applianceInformationSystemTable.getRowCount();
            int colCount = applianceInformationSystemTable.getColumnCount();
            boolean empty = false;
            
            
            if(!mobile_id.isEmpty()){
                if(!name.isEmpty()){
                    if(cmbMobileAccessory.getSelectedIndex() != 0){
                        if(!company.isEmpty()){
                            if(!mobile_price.isEmpty()){
                                if(!ram.isEmpty()){
                                    if(!storage.isEmpty()){
                                        if(!battery.isEmpty()){
                                            if(!camera.isEmpty()){
                                                if(!display.isEmpty()){
                                                    if(!processor.isEmpty()){
                                                        if(!fingerPrint.isEmpty()){
                                                      
                                                            do{
                                                                String value = (String)applianceInformationSystemTable.getValueAt(nextRow, 0);
                                                                    if(value != null && value.length() != 0){
                                                                    nextRow++;
                                                                }else{
                                                                    empty = true;
                                                                }
                                                                }while(nextRow<rowCount && !empty);
                                                                for(int i=0; i<colCount; i++){
                                                                    applianceInformationSystemTable.setValueAt(mobile_detail[i], nextRow, i);
                                                                }
                                                                JOptionPane.showMessageDialog(null, "Mobile Information Added");
                                                        }else{ //for fingerprint
                                                            JOptionPane.showMessageDialog(null, "Fingerprint Field is empty.");
                                                        }
                                                    }else{//for processor
                                                        JOptionPane.showMessageDialog(null, "Processor Field is empty.");
                                                    }
                                                }else{//for display
                                                   JOptionPane.showMessageDialog(null, "Display Field is empty.");
                                                }
                                            }else{//for camera
                                               JOptionPane.showMessageDialog(null, "Camera Field is empty.");
                                            }
                                        }else{//for battery
                                            JOptionPane.showMessageDialog(null, "Battery Field is empty.");
                                        }
                                    }else{//for storage
                                       JOptionPane.showMessageDialog(null, "Storage Field is empty.");
                                    }
                                }else{//for ram
                                    JOptionPane.showMessageDialog(null, "RAM Field is empty");
                                }
                            }else{//for mobile_price
                                JOptionPane.showMessageDialog(null, "Mobile Price Field is empty");
                            }
                        }else{//for company
                            JOptionPane.showMessageDialog(null, "Company Field is empty.");
                        }
                    }else{//for accessory
                        JOptionPane.showMessageDialog(null, "Accessory Field is empty.");
                    }
                }else{//for name
                    JOptionPane.showMessageDialog(null, "Name Field is empty.");
                }
            }else{//for mobile ID
                JOptionPane.showMessageDialog(null, "Mobile ID Field is empty.");                
            }
        
    }//GEN-LAST:event_btnAddMobileInformationActionPerformed

    private void btnCloseMobileInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseMobileInformationActionPerformed
        JOptionPane.showConfirmDialog(null, "Do you want to close application");
        System.exit(0);
    }//GEN-LAST:event_btnCloseMobileInformationActionPerformed

    private void txtMobileIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileIDKeyTyped
//        try {
//            int mob_id = Integer.parseInt(txtMobileID.getText());
//                       
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "You cannot enter string value in this field.");
//        }
    }//GEN-LAST:event_txtMobileIDKeyTyped

    private void txtMobileIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileIDKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            txtMobileID.setEditable(false);
            JOptionPane.showMessageDialog(null, "Please Enter Numbers Only.");
        }else{
            txtMobileID.setEditable(true);
        }
    }//GEN-LAST:event_txtMobileIDKeyPressed

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
         char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            txtPrice.setEditable(false);
            JOptionPane.showMessageDialog(null, "Please Enter Numbers Only.");
        }else{
            txtPrice.setEditable(true);
        }
    }//GEN-LAST:event_txtPriceKeyPressed

    private void btnClearMobileInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMobileInformationActionPerformed
        JOptionPane.showConfirmDialog(null, "Do you want to clear textfields, combobox and radiobuttons.");
        txtMobileID.setText("");
        txtMobileName.setText("");
        cmbMobileAccessory.setSelectedIndex(0);
        txtManufactureCompany.setText("");
        txtPrice.setText("");
        ramButtonGroup.clearSelection();
        txtStorage.setText("");
        txtBattery.setText("");
        txtCamera.setText("");
        txtDisplay.setText("");
        txtProcessor.setText("");
        fingerPrintButtonGroup.clearSelection();
    }//GEN-LAST:event_btnClearMobileInformationActionPerformed

    private void searchByPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByPriceActionPerformed
      int rowcount=applianceInformationSystemTable.getRowCount();
      int b [] = new int [rowcount];
      for (int list=0; list<rowcount; list++)
      {          
          String check= (String) applianceInformationSystemTable.getValueAt(list,4);
          
          if (check!=null && !check.isEmpty())
          {
              System.out.println(check);
              int chk= Integer.parseInt(check); 
              b[list]=chk;          
          }
      }
    System.out.println(Arrays.toString(b));  
    int low=0;
    int high=rowcount;    
    AppliancesInfo api = new AppliancesInfo();
    AppliancesInfo.sort(b);
    int value = Integer.parseInt(txtSearchByPrice.getText());
    api.search(b,low,high,value);
    }//GEN-LAST:event_searchByPriceActionPerformed

    private void availableMobileCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableMobileCategoryActionPerformed
        int rowCount=applianceInformationSystemTable.getRowCount();
        String s[] = new String[rowCount];
        for(int list = 0; list<rowCount; list++){
            String check = (String) applianceInformationSystemTable.getValueAt(list, 3);
            s[list]=check;
        }        
        System.out.println(Arrays.toString(s));
        String value = (String) searchByCategory.getSelectedItem();
        AppliancesInfo ai = new AppliancesInfo();
        ai.applianceCategory(s, value);        
    }//GEN-LAST:event_availableMobileCategoryActionPerformed

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
       String filePath="C:/Users/Hp/Desktop/abc.txt";
        try {
            BufferedReader bufferReader=new BufferedReader(new FileReader(filePath));
            String fLine = bufferReader.readLine().trim();
            String [] colName = fLine.split(",");
            DefaultTableModel model = (DefaultTableModel) applianceInformationSystemTable.getModel();
            model.setColumnIdentifiers(colName);
            Object [] tabLines = bufferReader.lines().toArray();
            
            for(int i=0; i<tabLines.length; i++){
                String line = tabLines[i].toString().trim();
                String [] dataRow = line.split(",");
                model.addRow(dataRow);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            
        }
       
    }//GEN-LAST:event_openItemActionPerformed

    private void helpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpItemActionPerformed
        File file=new File("C:/Users/Hp/Desktop/User Manual.pdf");
        try {
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "error, file not found");
        }
    }//GEN-LAST:event_helpItemActionPerformed

    private void closeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeItemActionPerformed

    private void resetTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTableButtonActionPerformed
        int rowCount = applianceInformationSystemTable.getRowCount();
        int colCount = applianceInformationSystemTable.getColumnCount();
                        
        JOptionPane.showConfirmDialog(null, "Do you want to clear table");
        String [] array = {"", "", "", "", "", "", "", "", "", "", "", ""};
        
        for(int j=0; j<rowCount; j++){
            for(int i=0; i<colCount; i++){
                applianceInformationSystemTable.setValueAt(array[i], j, i);
            }
        }
    }//GEN-LAST:event_resetTableButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppliancesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppliancesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppliancesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppliancesInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppliancesInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable applianceInformationSystemTable;
    private javax.swing.JButton availableMobileCategory;
    private javax.swing.JButton btnAddMobileInformation;
    private javax.swing.JButton btnClearMobileInformation;
    private javax.swing.JButton btnCloseMobileInformation;
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JComboBox<String> cmbMobileAccessory;
    private javax.swing.ButtonGroup fingerPrintButtonGroup;
    private javax.swing.JMenuItem helpItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem openItem;
    private javax.swing.ButtonGroup ramButtonGroup;
    private javax.swing.JRadioButton rdb16GB;
    private javax.swing.JRadioButton rdb4GB;
    private javax.swing.JRadioButton rdb8GB;
    private javax.swing.JRadioButton rdbNo;
    private javax.swing.JRadioButton rdbYes;
    private javax.swing.JButton resetTableButton;
    private javax.swing.JComboBox<String> searchByCategory;
    private javax.swing.JButton searchByPrice;
    private javax.swing.JTextField txtBattery;
    private javax.swing.JTextField txtCamera;
    private javax.swing.JTextField txtDisplay;
    private javax.swing.JTextField txtManufactureCompany;
    private javax.swing.JTextField txtMobileID;
    private javax.swing.JTextField txtMobileName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProcessor;
    private javax.swing.JTextField txtSearchByPrice;
    private javax.swing.JTextField txtStorage;
    // End of variables declaration//GEN-END:variables

}
