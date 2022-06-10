package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import Helpers.*;


public class member_login extends JFrame {

	private JPanel contentPane;
	private JTextField klad;
	private JPasswordField klsifre;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member_login frame = new member_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public member_login() {
		setTitle("G\u00F6t\u00FCrd\u00FCm Giri\u015F");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 546);
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                             HO\u015EGELD\u0130N\u0130Z");
		lblNewLabel.setBounds(193, 31, 250, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lbkullaniciadi = new JLabel("Kullan\u0131c\u0131 Ad\u0131n\u0131z");
		lbkullaniciadi.setForeground(Color.RED);
		lbkullaniciadi.setBounds(70, 110, 97, 38);
		contentPane.add(lbkullaniciadi);
		
		JLabel lbkullanýcýsifre = new JLabel("\u015Eifreniz");
		lbkullanýcýsifre.setForeground(Color.RED);
		lbkullanýcýsifre.setBounds(70, 168, 97, 38);
		contentPane.add(lbkullanýcýsifre);
		
		klsifre = new JPasswordField();
		klsifre.setBounds(168, 169, 250, 38);
		contentPane.add(klsifre);
		
		klad = new JTextField();
		klad.setBounds(168, 111, 250, 38);
		contentPane.add(klad);
		klad.setColumns(10);
		
		JButton btngiris = new JButton("Giri\u015F");
		btngiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				boolean giris=false;
				if(klad.getText().length()==0 || klsifre.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanlarý doldurunuz!");
                } 
				else {
				try {
                   DBConnection conn=new DBConnection();
                        Connection con=conn.connDb();
                        Statement st=con.createStatement();
                        ResultSet rs =st.executeQuery("SELECT * FROM sign_up");
                        while(rs.next()) {
                            if(klad.getText().equals(rs.getString("Kullaniciadi"))&& klsifre.getText().equals(rs.getString("Kullanicisifre"))) 
                            {
                            	if(rs.getString("admin").equals("true"))
                            	{
                            		st.executeUpdate("INSERT INTO active(KullaniciID,Kullaniciadi,Kullanicisifre)VALUES"
                                     		+ "('"+rs.getString("KullaniciID")+"','"+rs.getString("Kullaniciadi")+"','"+rs.getString("Kullanicisifre")+"')");
                            		admin f4=new admin();
                            		f4.setVisible(true);                           		
                            		 giris=true;                            		 
                            		 dispose();
                            	}
                            	if(rs.getString("admin").equals("false")){
                            giris=true;
                            st.executeUpdate("INSERT INTO active(KullaniciID,Kullaniciadi,Kullanicisifre)VALUES"
                            		+ "('"+rs.getString("KullaniciID")+"','"+rs.getString("Kullaniciadi")+"','"+rs.getString("Kullanicisifre")+"')");
                            shopping f3=new shopping();
                            f3.setVisible(true);                            
                            dispose();                           
                            	}
                           }                         
                        }
                        if(giris==false)
        				{
                        	JOptionPane.showMessageDialog(null, "Kullanýcý Adý ve Þifrenizi Kontrol Ediniz");
        				}
                        st.close();
				}
				
				 catch (SQLException e1) {

                     e1.printStackTrace();
                 }

				}       
			}});
		btngiris.setBounds(203, 254, 172, 38);
		contentPane.add(btngiris);	
		JButton btnuyeol = new JButton("\u00DCye ol");
		btnuyeol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				sign_up f2=new sign_up();				
				f2.setVisible(true);
			   dispose();
				
			}
		});
		btnuyeol.setBounds(470, 385, 126, 38);
		contentPane.add(btnuyeol);
		
		
	}
}