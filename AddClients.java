import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import reeption.Reeption;

public class AddClients implements ActionListener{
      JFrame myframe = new JFrame("Add Clients");
      JPanel mypanel = new JPanel();
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
        JTextField dob = new JTextField();
        JRadioButton genderm = new JRadioButton("Male");
        JRadioButton genderf = new JRadioButton("Female");
        JButton submit = new JButton("Submit");
        
        String insert = null;
        String gender = null;
        String date_s = null;
 
        int age = 0;
        Reeption x = new Reeption();
        
        AddClients(){
            GUI();
            Submit();
        }
      private void GUI(){
        firstname.setColumns(12);
        lastname.setColumns(12);
        phone.setColumns(12);
        dob.setColumns(12);
        
        mypanel.setLayout(null);
        mypanel.add(firstnamelabel);
        mypanel.add(firstname);
        mypanel.add(lastnamelabel);
        mypanel.add(lastname);
        mypanel.add(phonelabel);
        mypanel.add(phone);
        mypanel.add(doblabel);
        mypanel.add(dob);
        mypanel.add(genderlabel);
        mypanel.add(genderm);
        mypanel.add(genderf);
        mypanel.add(submit);
        
        genderf.setActionCommand("Female");
        genderm.setActionCommand("Male");
        ButtonGroup group = new ButtonGroup();
        group.add(genderf);
        group.add(genderm);
        
        firstnamelabel.setBounds(10, 70, 80, 20);
        firstname.setBounds(100, 70, 120, 20);
        
        lastnamelabel.setBounds(10, 100, 80, 20);
        lastname.setBounds(100, 100, 120, 20);
        
        phonelabel.setBounds(10, 130, 80, 20);
        phone.setBounds(100, 130, 120, 20);
        
        doblabel.setBounds(10, 160, 100, 20);
        dob.setBounds(100, 160, 120, 20);
        
        genderlabel.setBounds(10, 190, 80, 20);
        genderm.setBounds(100, 190, 120, 20);
        genderf.setBounds(100, 220, 120, 20);
        
        submit.setBounds(250, 80, 200, 150);
        dob.setText("yyyy-mm-dd");
        myframe.add(mypanel);
        myframe.setSize(800, 400);
        myframe.setVisible(true);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      private void Submit(){
          submit.addActionListener(this);
      }
      
      @Override
      public void actionPerformed(ActionEvent e){
          if(genderm.isSelected() == true){
            gender = "Male";    
             Date birth = Date.valueOf(dob.getText());
             int xy = birth.getYear();
             xy = 2018 - xy-1900;
            insert = "insert into clientdetails(firstname,lastname,dateofbirth,gender,age)"+"Values('"+firstname.getText()+"','"+lastname.getText()+"','"+dob.getText()+"','"+gender+"','"+xy+"'";
              x.InsertDB(insert);
              System.out.print(insert);
        }
        
        if(genderf.isSelected() == true){
            gender = "Female";
            Date birth = Date.valueOf(dob.getText());
            int xy = birth.getYear();
            xy = 2018 - xy-1900;
            insert = "insert into clientdetails(firstname,lastname,dateofbirth,gender,age)"+"Values('"+firstname.getText()+"','"+lastname.getText()+"','"+dob.getText()+"','"+gender+"','"+xy+"'";
            x.InsertDB(insert);
        }
      }
    public static void main(String[] args){
       new AddClients();
    }
}