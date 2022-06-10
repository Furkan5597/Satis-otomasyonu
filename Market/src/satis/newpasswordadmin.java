package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import Helpers.DBConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class newpasswordadmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField tfsifre;
	private JPasswordField tftsifre;
	private JTextField yadress;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newpasswordadmin frame = new newpasswordadmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String ad;
	private JPasswordField sifre;
	public newpasswordadmin() {
		setTitle("\u015Eifre ve Adres De\u011Fi\u015Fikli\u011Fi");
		try {					
			DBConnection conn=new DBConnection();
             Connection con=conn.connDb();
             Statement st=con.createStatement();
             ResultSet rs =st.executeQuery("SELECT Kullaniciadi FROM active");
             while(rs.next())
             {
            	 ad=rs.getString("Kullaniciadi");
             }
             
		}catch(SQLException e1) {

            e1.printStackTrace();
        }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mevcut \u015Eifreniz");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 124, 125, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Yeni \u015Eifreniz");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 162, 125, 28);
		contentPane.add(lblNewLabel_2);
		
		tfsifre = new JPasswordField();
		tfsifre.setBounds(146, 199, 143, 23);
		contentPane.add(tfsifre);
		
		tftsifre = new JPasswordField();
		tftsifre.setBounds(146, 165, 143, 23);
		contentPane.add(tftsifre);
		
		JButton btnsave = new JButton("De\u011Fi\u015Fiklikleri Kaydet");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean degis=false;	
				if(sifre.getText().length()==0 || tftsifre.getText().length()==0 || sifre.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Lütfen Ýlgili Alanlarý Doldurunuz!");
				}
				else
				{
				if(!tfsifre.getText().equals(tftsifre.getText()))
				{
					JOptionPane.showMessageDialog(null, "Þifreler Uyuþmuyor tekrar deneyin");
				}
				
				else {
				try {					
					DBConnection conn=new DBConnection();
	                 Connection con=conn.connDb();
	                 Statement st=con.createStatement();
	                 ResultSet rs =st.executeQuery("SELECT * FROM sign_up");
	                 while(rs.next())
	                 {
	                	 if((tfsifre.getText().length()!=0 || tftsifre.getText().length()!=0)&& yadress.getText().length()==0)
	                	 {
	                 if(sifre.getText().equals(rs.getString("Kullanicisifre")))
	                 { 
	                	
	                	 st.executeUpdate("UPDATE sign_up SET Kullanicisifre='"+tfsifre.getText()+"' where Kullaniciadi='"+ad+"' ");                	 
	                	 degis=true;
	                	 JOptionPane.showMessageDialog(null, "Þifreniz Deðiþtirilmiþtir");	
	                	 dispose();
	                 }
	                	 }
	                	if(yadress.getText().length()!=0 && tfsifre.getText().length()==0)
	                	 {
	                 	 st.executeUpdate("UPDATE sign_up SET adress='"+yadress.getText()+"' where Kullaniciadi='"+ad+"' ");
	                	 JOptionPane.showMessageDialog(null, "Adresiniz Deðiþtirilmiþtir");
	                	 dispose();
	                	
	                	 }
	                	if(sifre.getText().length()!=0 && tftsifre.getText().length()!=0 && yadress.getText().length()!=0)
	                	{
	                		 
		                	 st.executeUpdate("UPDATE sign_up SET Kullanicisifre='"+tfsifre.getText()+"' where Kullaniciadi='"+ad+"' ");
		                	 st.executeUpdate("UPDATE sign_up SET adress='"+yadress.getText()+"' where Kullaniciadi='"+ad+"' ");
		                	 degis=true;
		                	 JOptionPane.showMessageDialog(null, "Þifreniz ve Adresiniz Deðiþtirilmiþtir");	
		                	 dispose();
	                	}
	                	
	                 if(!tfsifre.getText().equals(rs.getString("Kullanicisifre")))
	                 {	                	
	                	 degis=false;
	                 }
	            
	                 }
	                 if(degis==false)
	                 {
	                	 JOptionPane.showMessageDialog(null, "Mevcut Þifrenizi Kontrol Ediniz");
	                 }
	              
	               
	                 st.close();
				}
				
				catch(SQLException e1) {

                    e1.printStackTrace();
                }
				}
			}
				 
			}
		});
		btnsave.setBounds(442, 375, 165, 48);
		contentPane.add(btnsave);
		
		JButton btnNewButton = new JButton("Geri d\u00F6n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(328, 375, 104, 48);
		contentPane.add(btnNewButton);
		
		JLabel lbadres = new JLabel("Yeni Adresiniz:");
		lbadres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbadres.setBounds(10, 258, 125, 28);
		contentPane.add(lbadres);
		
		yadress = new JTextField();
		yadress.setColumns(10);
		yadress.setBounds(122, 258, 468, 28);
		contentPane.add(yadress);
		
		sifre = new JPasswordField();
		sifre.setBounds(146, 130, 143, 23);
		contentPane.add(sifre);
		
		JLabel lbsifre = new JLabel("\u015Eifre Tekrar Giriniz:");
		lbsifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbsifre.setBounds(10, 195, 156, 28);
		contentPane.add(lbsifre);
	}
}
