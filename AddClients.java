import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import reeption.DBUpdater;
import reeption.Reeption;

public class AddClients implements ActionListener{
      JFrame myframe = new JFrame("Add Clients");
      JPanel mypanel = new JPanel();
      // Table Panels
      JPanel tablePanel = new javax.swing.JPanel();
      JScrollPane scrollPanel = new javax.swing.JScrollPane();
      //JObjects
        JLabel firstnamelabel = new JLabel("First Name: ");
        JLabel lastnamelabel = new JLabel("Last Name: ");
        JLabel phonelabel = new JLabel("Phone No.: ");
        JLabel doblabel = new JLabel("Date Of Birth: ");
        JLabel genderlabel = new JLabel("Gender: ");
        //TextFields
        JTextField firstname = new JTextField();
        JTextField lastname = new JTextField();
        JTextField phone = new JTextField();
        SimpleDateFormat dob = new SimpleDateFormat("yyyy-MM-dd");
        com.toedter.calendar.JDateChooser jDate = new com.toedter.calendar.JDateChooser();
        JRadioButton genderm = new JRadioButton("Male");
        JRadioButton genderf = new JRadioButton("Female");
        ButtonGroup group = new ButtonGroup();
        JButton addbtn = new JButton("Add");
        JButton retrievebtn = new JButton("Retrieve");
        JButton updatebtn = new JButton("Update");
        JButton deletebtn = new JButton("Delete");
        JButton clearbtn = new JButton("Clear");
        //Table***************************************************************************
        JTable dataTable = new javax.swing.JTable();
        //********************************************************************************
        String infn,inln,inpn,indt = null;
        String gender = null;
        String date = null;
        Date t;
 
        int age = 0;
        Reeption x = new Reeption();
        
        AddClients(){
            GUI();
            
        }
      private void GUI(){
        firstname.setColumns(12);
        lastname.setColumns(12);
        phone.setColumns(12);
        
        mypanel.setLayout(null);
        mypanel.add(firstnamelabel);
        mypanel.add(firstname);
        mypanel.add(lastnamelabel);
        mypanel.add(lastname);
        mypanel.add(phonelabel);
        mypanel.add(phone);
        mypanel.add(doblabel);
        mypanel.add(jDate);
        mypanel.add(genderlabel);
        mypanel.add(genderm);
        mypanel.add(genderf);
        mypanel.add(addbtn);
        mypanel.add(retrievebtn);
        mypanel.add(deletebtn);
        mypanel.add(updatebtn);
        mypanel.add(clearbtn);
        mypanel.add(scrollPanel);
        
        mypanel.setBackground(new java.awt.Color(45, 155, 193));
        
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        
        //Action Listeners
         dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
         
         //Button Actions
        
        retrievebtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            retrieveBtnActionPerformed(evt);
        });

        addbtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            addBtnActionPerformed(evt);
        });
            
        updatebtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            updateBtnActionPerformed(evt);
        });

        deletebtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            DeleteActionPerformed(evt);
        });
            
        clearbtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            clearBtnActionPerformed(evt);
        });

         
        scrollPanel.setViewportView(dataTable);
        
        genderf.setActionCommand("Female");
        genderm.setActionCommand("Male");
        
        group.add(genderf);
        group.add(genderm);
      
        
        firstnamelabel.setBounds(10, 70, 80, 20);
        firstname.setBounds(100, 70, 120, 20);
        
        lastnamelabel.setBounds(10, 100, 80, 20);
        lastname.setBounds(100, 100, 120, 20);
        
        phonelabel.setBounds(10, 130, 80, 20);
        phone.setBounds(100, 130, 120, 20);
        
        doblabel.setBounds(10, 160, 100, 20);
        jDate.setBounds(100, 160, 120, 20);
        
        genderlabel.setBounds(10, 190, 80, 20);
        genderm.setBounds(100, 190, 120, 20);
        genderf.setBounds(100, 220, 120, 20);
        
        addbtn.setBounds(10, 260, 100, 25);
        retrievebtn.setBounds(160, 260, 100, 25);
        updatebtn.setBounds(10, 300, 100, 25);
        deletebtn.setBounds(160, 300, 100, 25);
        clearbtn.setBounds(85, 340, 100, 25);
        
        scrollPanel.setBounds(270, 70, 650, 400);
        myframe.add(mypanel);
        
        myframe.setSize(1000, 600);
        myframe.setVisible(true);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      /*private void Submit(){
          addbtn.addActionListener(this);
      }
      
      @Override
      public void actionPerformed(ActionEvent e){       
          if(genderm.isSelected() == true){
            gender = "Male";    
            String date = dob.format(jDate.getDate());
            int a = jDate.getDate().getYear();
            a = 2018 - a - 1900;
            
            insert = "insert into clientdetails(firstname,lastname,dateofbirth,gender,age)"+"Values('"+firstname.getText()+"','"+lastname.getText()+"','"+date+"','"+gender+"','"+a+"')";
             x.ExecuteDB(insert);
              //System.out.print(date + x);
        }
        
        if(genderf.isSelected() == true){
            gender = "Female";
            date = dob.format(jDate.getDate());
            int a = jDate.getDate().getYear();
            a = 2018 - a - 1900;
            
            insert = "insert into clientdetails(firstname,lastname,dateofbirth,gender,age)"+"Values('"+firstname.getText()+"','"+lastname.getText()+"','"+date+"','"+gender+"','"+a+"')";
            x.ExecuteDB(insert);
        }
      }*/
        private void retrieve()
    {
     DefaultTableModel dm = new DBUpdater().getData();

        dataTable.setModel(dm);
    }
      
          //RETRIEVE BUTTON CLICKED
    private void retrieveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        retrieve();

    }

    //ADD OR SAVE
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if(genderm.isSelected() == true)
            gender = "Male";   
        if(genderf.isSelected() == true)
            gender = "Female";
        
        age = jDate.getDate().getYear();
            age = 2018 - age - 1900;
        infn = firstname.getText();
        inln = lastname.getText();
        inpn = phone.getText();
        indt = dob.format(jDate.getDate());
            
        if (new DBUpdater().add(infn, inln,inpn , indt, gender, age)) {
            JOptionPane.showMessageDialog(null, "Successfully Inserted");

            //CLEAR TXT
            firstname.setText("");
            lastname.setText("");
            phone.setText("");         
 
            retrieve();
        } else {
            JOptionPane.showMessageDialog(null, "Not Saved");
        }
    }

    //SET SELECTED VALUE TO TEXTFIELDS
    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {
        String fname = dataTable.getValueAt(dataTable.getSelectedRow(), 1).toString();
        String lname = dataTable.getValueAt(dataTable.getSelectedRow(), 2).toString();
        String pnumber = dataTable.getValueAt(dataTable.getSelectedRow(), 3).toString();
        String birthdate = dataTable.getValueAt(dataTable.getSelectedRow(), 4).toString();
        String gendersex = dataTable.getValueAt(dataTable.getSelectedRow(), 5).toString();
      
        firstname.setText(fname);
        lastname.setText(lname);
        phone.setText(pnumber);
        if("Female".equals(gendersex))
            group.setSelected(genderf.getModel(), true);
        else
            group.setSelected(genderm.getModel(), true);
        
          try {
              jDate.setDate(dob.parse(birthdate));
          } catch (ParseException ex) {
              Logger.getLogger(AddClients.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    //UPDATE
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int index = dataTable.getSelectedRow();
        String id = dataTable.getValueAt(index, 0).toString();
        if(genderm.isSelected() == true)
            gender = "Male";   
        if(genderf.isSelected() == true)
            gender = "Female";
        
        age = jDate.getDate().getYear();
            age = 2018 - age - 1900;

        if (new DBUpdater().update(id, firstname.getText(), lastname.getText(), phone.getText(), (dob.format(jDate.getDate())),gender,age)) {
            JOptionPane.showMessageDialog(null, "Successfully Updated");

            //CLEAR TXT
           firstname.setText("");
           lastname.setText("");
           phone.setText("");

            retrieve();
        } else {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
    }

    //DELETE
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String[] options = {"Yes", "No"};
        int answ = JOptionPane.showOptionDialog(null, "Sure To Delete??", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (answ == 0) {
            int index = dataTable.getSelectedRow();
            String id = dataTable.getValueAt(index, 0).toString();

            if (new DBUpdater().delete(id)) {
                JOptionPane.showMessageDialog(null, "Deleted Updated");

                //CLEAR TXT
                firstname.setText("");
                lastname.setText("");
                phone.setText("");

           retrieve();
            } else
            {
                JOptionPane.showMessageDialog(null, "Not Deleted");
            }

        }
    }
//CLEAR BUTTON CLICKED
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
          dataTable.setModel(new DefaultTableModel());
    }
    public static void main(String[] args){
          AddClients addClients = new AddClients();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}