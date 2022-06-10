package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Helpers.DBConnection;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JPasswordField;
public class addadmin extends JFrame {

	protected static final String Kullaniciadi = null;
	private JPanel contentPane;
	private JTextField tfad;
	private JTextField tfadres;
	private JLabel lblNewLabel_4;
	private JTextField tfsoyad;
	private JPasswordField tfsifre;
	private JPasswordField tftsifre;
	private JButton btnNewButton_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addadmin frame = new addadmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public addadmin() {
		setTitle("Admin Ekleme");							
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad\u0131n\u0131z");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 63, 120, 46);
		contentPane.add(lblNewLabel);
		
		tfad = new JTextField();
		tfad.setBounds(195, 70, 258, 37);
		contentPane.add(tfad);
		tfad.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifreniz");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 198, 120, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u015Eifre Tekrar\u0131");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 269, 145, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adresinizi giriniz");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(28, 350, 120, 24);
		contentPane.add(lblNewLabel_3);
		
		tfadres = new JTextField();
		tfadres.setBounds(195, 349, 370, 32);
		contentPane.add(tfadres);
		tfadres.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Soyad\u0131n\u0131z");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(28, 119, 120, 46);
		contentPane.add(lblNewLabel_4);
		
		tfsoyad = new JTextField();
		tfsoyad.setBounds(195, 126, 258, 37);
		contentPane.add(tfsoyad);
		tfsoyad.setColumns(10);
		
		tfsifre = new JPasswordField();
		tfsifre.setBounds(195, 198, 258, 37);
		contentPane.add(tfsifre);
		
		tftsifre = new JPasswordField();
		tftsifre.setBounds(195, 278, 258, 37);
		contentPane.add(tftsifre);
		
		JButton btnNewButton = new JButton("Kay\u0131t ol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean adk=false,soyadk=false,sifrek=false,adressk=false;
				if(tfad.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Adýnýzý Girmediniz!");
				}
				else {adk=true;}
				if(tfsoyad.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Soyadýnýzý Girmediniz!");
				}
				else {soyadk=true;}
				if(tfsifre.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Þifrenizi Girmediniz!");
				}
				else {sifrek=true;}
				if(tfadres.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Adresinizi Girmediniz!");
				}
				else {adressk=true;}
				
				if(adk==true && soyadk==true && sifrek==true && adressk==true)
				{		
				try {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/market","furkan","1234");
                Statement st=con.createStatement();
                ResultSet rs =st.executeQuery("SELECT * FROM sign_up");
               String ad,soyad,sifre,adres; 
               ad=tfad.getText();
               soyad=tfsoyad.getText();
               sifre=tfsifre.getText();
               adres=tfadres.getText();
               boolean kontrol=true;
               while(rs.next())
               {
            	   if(rs.getString("Kullaniciadi").equals(tfad.getText()))
            	   {
            		 JOptionPane.showMessageDialog(null,"Bu Kullanýcý Adý Kullanýlmakta!");  
            		 kontrol=false;
            	   }
            	                
               }
               if(kontrol==true)
               {
               if(!tftsifre.getText().equals(sifre))
               {
            	   JOptionPane.showMessageDialog(null, "Þifreler Uyuþmuyor!");
               }
               else {        
            	   
                st.executeUpdate("INSERT INTO sign_up(Kullaniciadi,Kullanicisoyadi,Kullanicisifre,adress,admin)VALUES('"+ad+"','"+soyad+"','"+sifre+"','"+adres+"','"+"true"+"')");              
                
               
				dispose();
			
				}
				}
               st.close();
				}
				
				catch(SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "Kayýt yapýlamadý!");
                    e1.printStackTrace();
                }
				}
			}
		});
		btnNewButton.setBounds(248, 415, 163, 46);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Geri d\u00F6n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(129, 415, 109, 46);
		contentPane.add(btnNewButton_1);
		
	
	}
}
