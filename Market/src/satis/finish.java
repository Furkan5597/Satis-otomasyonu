package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Helpers.DBConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
public class finish extends JFrame {

	private JPanel contentPane;
	private JTextField adres;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finish frame = new finish();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String ad,adress,tutar;
	public int KID;
	public String Kadi,Ksoyad,Kadres;
	public finish(){
		setTitle("Fatura");
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();	
	       ResultSet rs =st.executeQuery("select Kullaniciadi,tutar from active");
	       while(rs.next())
	       {
	    	   ad=rs.getString("Kullaniciadi");
	    	   tutar=rs.getString("tutar");
	    	
	       }
          st.close();
          rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();	
	        ResultSet rs =st.executeQuery("select adress from sign_up where Kullaniciadi='"+ad+"'");
		       		      
	       while(rs.next())
	       {
	    	 adress=rs.getString("adress");
  	         
	       }
          st.close();
          rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adresiniz:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 45, 121, 40);
		contentPane.add(lblNewLabel);
		
		adres = new JTextField();
		adres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		adres.setBounds(153, 45, 458, 40);
		contentPane.add(adres);
		adres.setColumns(10);
		 adres.setText(adress);
		 
			JLabel lbtutar = new JLabel("New label");
			lbtutar.setHorizontalAlignment(SwingConstants.LEFT);
			lbtutar.setBounds(183, 208, 68, 43);
			contentPane.add(lbtutar);
			lbtutar.setText(tutar);
		
		JLabel odenecek = new JLabel("\"\"");
		odenecek.setHorizontalAlignment(SwingConstants.CENTER);
		odenecek.setBounds(22, 208, 219, 43);
		contentPane.add(odenecek);
		odenecek.setText("\u00D6denecek Tutar:"); 
	       
		JButton btnNewButton = new JButton("Onayla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cevap=JOptionPane.showConfirmDialog(null,"Satýn Alma Ýþlemini Onaylýyor Musunuz ?","Satýn al",JOptionPane.YES_NO_OPTION);
				if(cevap==0)
				{
				SimpleDateFormat sekil = new SimpleDateFormat();
		        Date tarih = new Date();
				    try {
					
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
		        		
			        ResultSet rs =st.executeQuery("SELECT * FROM sign_up where Kullaniciadi='"+ad+"' ");
			        
			   
			        while(rs.next())
			        {
			        	 KID=rs.getInt("KullaniciID");
			        	 Kadi=rs.getString("Kullaniciadi");
			        	 Ksoyad=rs.getString("Kullanicisoyadi");
			        	 Kadres=rs.getString("adress");
			      	
			        }		        
			        st.executeUpdate("INSERT INTO orders(KullaniciID,Kullaniciadi,Kullanicisoyadi,adress,tutar,time)"
	    					+ "VALUES('"+KID+"','"+Kadi+"',"
	    							+ "'"+Ksoyad+"','"+adres.getText()+"','"+lbtutar.getText()+"','"+sekil.format(tarih)+"')");
			        st.close();
	        	 JOptionPane.showMessageDialog(null, "Sipariþiniz Tamamlandý");	
	        	 dispose();	
	        	 shopping f3=new shopping();
	        	 f3.setVisible(true);
					}
				catch(SQLException e1) 
				    {

			            e1.printStackTrace();
			        }
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(313, 351, 184, 40);
		contentPane.add(btnNewButton);
		
		JLabel lbldemeeklikapdademe = new JLabel("\u00D6deme \u015Eekli:Kap\u0131da \u00D6deme\r\n");
		lbldemeeklikapdademe.setHorizontalAlignment(SwingConstants.CENTER);
		lbldemeeklikapdademe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbldemeeklikapdademe.setBounds(32, 263, 208, 40);
		contentPane.add(lbldemeeklikapdademe);
		
		JButton btnNewButton_1 = new JButton("\u0130ptal veya d\u00FCzenleme yap");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				shopping f3=new shopping();
				f3.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(695, 451, 184, 33);
		contentPane.add(btnNewButton_1);
		
	
		
	}
}
