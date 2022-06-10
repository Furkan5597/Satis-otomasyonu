package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Helpers.DBConnection;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class myinformation extends JFrame {

	private JPanel contentPane;
	private JLabel lbad;
	private JTable table;
    DefaultTableModel modelim=new DefaultTableModel();
    Object[] kolonlar= {"Sipariþ Numaranýz","Kullanýcý adý","Kullanýcý Soyadý","Adres","Tutar","Tarih"};
    Object[] satýrlar=new Object[6];
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myinformation frame = new myinformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
String ad;
	public myinformation() {
		setTitle("Sipari\u015F Bilgilerim");
		
		  
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();
	         ad="select Kullaniciadi from active";
        ResultSet rs =st.executeQuery(ad);
       while(rs.next())
       {
    	   ad=rs.getString("Kullaniciadi");
       }
     
		}
		catch(SQLException e1) {

            e1.printStackTrace();
        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbad = new JLabel("Geçmiþ Sipariþleriniz");
		lbad.setHorizontalAlignment(SwingConstants.CENTER);
		lbad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbad.setBounds(154, 12, 364, 25);
		contentPane.add(lbad);
		
		JButton btnNewButton = new JButton("Al\u0131\u015FVeri\u015Fe d\u00F6n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton.setBounds(540, 15, 127, 41);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 657, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	        
			try {
				DBConnection conn=new DBConnection();
		        Connection con=conn.connDb();
		        Statement st=con.createStatement();
		    
		     String liste="select * from orders where Kullaniciadi='"+ad+"' ";
		     ResultSet rs =st.executeQuery(liste);
		     modelim.setColumnIdentifiers(kolonlar);
		        while(rs.next())
		        {
		        	satýrlar[0]=rs.getString("SiparisID");
		        	satýrlar[1]=rs.getString("Kullaniciadi");
		        	satýrlar[2]=rs.getString("Kullanicisoyadi");
		        	satýrlar[3]=rs.getString("adress");		        	
		        	satýrlar[4]=rs.getString("tutar");
		        	satýrlar[5]=rs.getString("time");
		        	modelim.addRow(satýrlar);		        	
		        }
		        table.setModel(modelim);
				}
				catch(SQLException e1) {

		            e1.printStackTrace();
		        }
			
		        
		    }
}
