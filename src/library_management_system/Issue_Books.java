
package library_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;


public class Issue_Books extends javax.swing.JFrame 
{
    Connection Con = null;
    PreparedStatement Pst;
    ResultSet Rs = null,Rs1 = null;
    Statement St = null,St1 = null;
   
    
    public Issue_Books() 
    {
        initComponents();
        DisplayBook();  
        GetMember();
        DisplayIssue_Books();      
    }

    
    private void DisplayBook()
    {   
        try
        {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("select*from book");
            booktb.setModel(DbUtils.resultSetToTableModel(Rs));
        } 
        catch (SQLException e){
        }
    }
    
    
    private void GetMember()
    {
        try    
        {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select*from member");
            while(Rs1.next())
            {
                int mem = Rs1.getInt("MID");
                String m = Integer.toString(mem);
                memberid.addItem(m);         
            }
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

   
    
    
    int quantity;
    private void CountBooks()
    {
        try    
        {
           St1 = Con.createStatement();
           Rs1 = St1.executeQuery("select quantity from book where BID='"+BID.getText()+"'");
           Rs1.next();
           quantity = Rs1.getInt(1);       
        }
        catch (SQLException e)
        {
          
        }
    }
    
    
  
    int IID;
    private void CountIssue_Books()
    {   
        try   
        {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select Max(INO)from issued_book");
            Rs1.next();
            IID = Rs1.getInt(1)+1;
        } 
        catch (SQLException e){
        }
    }

    
    int Issue;
    private void CountIssued()
    {
        try   
        {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select count(*) from issued_book where MID='"+memberid.getSelectedItem()+"'");
            Rs1.next();
            Issue = Rs1.getInt(1);
        } 
        catch (SQLException e){
        }
    }

    
    
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        issuetb = new javax.swing.JTable();
        back = new javax.swing.JButton();
        issuedate = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        booktb = new javax.swing.JTable();
        issues = new javax.swing.JButton();
        memberid = new javax.swing.JComboBox<>();
        BID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sundhus IT\\Desktop\\images\\fin.jfif")); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(1181, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(388, 388, 388)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(389, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1234, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1228, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 675, 1228, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("Member ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 100, 19));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Issued_Date");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 100, 19));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Issue Books");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 164, 45));

        reset.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, -1, -1));

        issuetb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Member ID", "BooK ID", "Issued Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issuetb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuetbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(issuetb);
        if (issuetb.getColumnModel().getColumnCount() > 0) {
            issuetb.getColumnModel().getColumn(0).setResizable(false);
            issuetb.getColumnModel().getColumn(1).setResizable(false);
            issuetb.getColumnModel().getColumn(2).setResizable(false);
            issuetb.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 520, 340));

        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, -1, -1));

        issuedate.setDateFormatString("yyyy-m-dd");
        getContentPane().add(issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 120, -1));

        booktb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Book ID", "Book Name", "Author", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booktb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                booktbAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        booktb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booktbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(booktb);
        if (booktb.getColumnModel().getColumnCount() > 0) {
            booktb.getColumnModel().getColumn(0).setResizable(false);
            booktb.getColumnModel().getColumn(1).setResizable(false);
            booktb.getColumnModel().getColumn(2).setResizable(false);
            booktb.getColumnModel().getColumn(3).setResizable(false);
            booktb.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 300, 500, 340));

        issues.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        issues.setText("Issues");
        issues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuesMouseClicked(evt);
            }
        });
        issues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuesActionPerformed(evt);
            }
        });
        getContentPane().add(issues, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        memberid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberidActionPerformed(evt);
            }
        });
        getContentPane().add(memberid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 120, -1));

        BID.setEditable(false);
        BID.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BID.setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().add(BID, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 120, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("Book ID");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 100, 19));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Issued Books Details");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 170, 19));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 255));
        jLabel13.setText("Books Details");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 120, 19));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void DisplayIssue_Books()
    {
        try      
        {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("select*from issued_book");
            issuetb.setModel(DbUtils.resultSetToTableModel(Rs));
        } 
        catch (SQLException e){
        }
    }
    
    
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
      //  BID.setText("");
      // Book_ID = -1;      
    }//GEN-LAST:event_resetActionPerformed
    
    int newquantity;
    private void Update_Books()
    {
        CountBooks();
        try
        {  
            newquantity = (quantity-1);  
            String sql = "Update book set quantity =? where BID = ?";
            Con =DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
            PreparedStatement Pst = Con.prepareStatement(sql);
                Pst.setInt(1, newquantity);
                Pst.setString(2, BID.getText());
            
            if( Pst.executeUpdate()==1)
            {
                JOptionPane.showMessageDialog(this, "Book Updated"); 
                DisplayBook(); 
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Something went wrong");                    
            }  

        }
        catch ( SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    
    }
    
    
    private void issuetbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuetbMouseClicked
    
    }//GEN-LAST:event_issuetbMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        new MainMenu().setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

    }//GEN-LAST:event_backActionPerformed

    
    int Book_ID ;
    private void booktbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booktbMouseClicked
      
        DefaultTableModel model = (DefaultTableModel)booktb.getModel();
        int MyIndex = booktb.getSelectedRow();
        Book_ID = Integer.valueOf(model.getValueAt(MyIndex, 1).toString());
        BID.setText(model.getValueAt(MyIndex, 1).toString());
        quantity = Integer.valueOf(model.getValueAt(MyIndex, 1).toString());
    }//GEN-LAST:event_booktbMouseClicked

    
    
    
    private void issuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuesActionPerformed
         
        CountBooks();
        CountIssued();
        if(BID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Select a Book");
        } 
        else if(quantity == 0)
        { 
            JOptionPane.showMessageDialog(this, "Book Not Available");
        }
        else if (Issue >3)
        {
            JOptionPane.showMessageDialog(this, "2 Books Pending");
        }
        else
        {
            try
            {
                CountIssue_Books();
                Connection Con =DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
                String sql = "insert into issued_book (INO,MID,BID,issued_date) values(?,?,?,?)";
                PreparedStatement Pst = Con.prepareStatement(sql);
                    Pst.setInt(1, IID);
                    Pst.setInt(2, Integer.valueOf(memberid.getSelectedItem().toString()));
                    Pst.setString(3, BID.getText());
                    Pst.setString(4, ((JTextField)issuedate.getDateEditor().getUiComponent()).getText());
                int row = Pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Book Added"); 
                Con.close();
                Update_Books();
                DisplayIssue_Books();
            }
            catch (SQLException e)
            {
                JOptionPane.showMessageDialog(this, e);  
            }
        } 
    }//GEN-LAST:event_issuesActionPerformed

    
    private void memberidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberidActionPerformed
       
    }//GEN-LAST:event_memberidActionPerformed

    private void booktbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_booktbAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_booktbAncestorAdded

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void issuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuesMouseClicked
   
    }//GEN-LAST:event_issuesMouseClicked
 
  
    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Issue_Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BID;
    private javax.swing.JButton back;
    private javax.swing.JTable booktb;
    private com.toedter.calendar.JDateChooser issuedate;
    private javax.swing.JButton issues;
    private javax.swing.JTable issuetb;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> memberid;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}

