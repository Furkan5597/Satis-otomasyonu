package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Helpers.DBConnection;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class orders extends JFrame {

	private JPanel contentPane;
	private JTextField tfsource;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orders frame = new orders();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public int top;
	DefaultTableModel modelim=new DefaultTableModel();
    Object[] kolonlar= {"Kullanýcý Numarasý","Adý","Soyadý","Adres","Tutar","Tarih"};
    Object[] Urun= {"Ürün Çesidi","Ürün Adý","Fiyatý","Ýcon Adresi"};
	Object[] satýrlar=new Object[6];
	Object[] grup= {"Kullanýcý Adý","Sipariþ Sayýsý"};
	private JTextField tfurun;
	public orders() {
		setTitle("Ge\u00E7mi\u015F Sipari\u015Fler");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbtop = new JLabel("0");
		lbtop.setHorizontalAlignment(SwingConstants.CENTER);
		lbtop.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbtop.setBounds(188, 454, 45, 13);
		contentPane.add(lbtop);
		
		JLabel lbl = new JLabel("Yap\u0131lan Toplam Sat\u0131\u015F Tutar\u0131:");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(20, 454, 168, 13);
		contentPane.add(lbl);
		
		
		tfsource = new JTextField();
		tfsource.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			  
				try {
				     
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			    modelim.setRowCount(0);
			     String liste="select * from orders where  Kullaniciadi LIKE '"+tfsource.getText()+"%' ";
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
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				
			}
		});
		tfsource.setBounds(10, 29, 192, 19);
		contentPane.add(tfsource);
		tfsource.setColumns(10);
		 
		tfsource.setVisible(false);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 746, 370);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(664, 451, 85, 21);
		contentPane.add(btnNewButton);
		
		tfurun = new JTextField();
		tfurun.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				try {
				
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        modelim.setRowCount(0);
			     String liste="select * from orders_and_img where  urunadi LIKE '"+tfurun.getText()+"%' ";
			     ResultSet rs =st.executeQuery(liste);
			     modelim.setColumnIdentifiers(Urun);
			        while(rs.next())
			        {
			        	
			        	satýrlar[0]=rs.getString("uruncesit");
			        	satýrlar[1]=rs.getString("urunadi");
			        	satýrlar[2]=rs.getString("fiyati");
			        	satýrlar[3]=rs.getString("adress");		        	
			        	modelim.addRow(satýrlar);	
			        }
			       table.setModel(modelim);
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				
			}
		});
		tfurun.setColumns(10);
		tfurun.setBounds(10, 29, 192, 19);
		contentPane.add(tfurun);
		
		tfurun.setVisible(false);
		
		
		JButton urunb = new JButton("\u00DCr\u00FCn Bilgieri");
		urunb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					lbl.setText("Toplam Ürün Adeti");
					tfurun.setText("");
					tfsource.setVisible(false);
					tfurun.setVisible(true);
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			    modelim.setRowCount(0);
			    ResultSet rs =st.executeQuery("select* from orders_and_img");
			    modelim.setColumnIdentifiers(Urun);
			    while(rs.next())
		        {		        	
			    	satýrlar[0]=rs.getString("uruncesit");
		        	satýrlar[1]=rs.getString("urunadi");
		        	satýrlar[2]=rs.getString("fiyati");
		        	satýrlar[3]=rs.getString("adress");		        	
		        	modelim.addRow(satýrlar);	
		        	
		        }
		       table.setModel(modelim);
		       lbtop.setText(""+modelim.getRowCount());
		       st.close();
				}
				catch(SQLException e1) {

		            e1.printStackTrace();
		        }
			    
			}
		});
		urunb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		urunb.setBounds(764, 211, 117, 21);
		contentPane.add(urunb);
		
		JButton order = new JButton("Sipari\u015Fler");
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					top=0;
					lbl.setText("Yapýlan Toplam Satýþ Tutarý:");
					tfsource.setText("");
					tfurun.setVisible(false);
					tfsource.setVisible(true);
					modelim.setRowCount(0);	
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        		    
			     ResultSet rs =st.executeQuery("select * from orders  ");
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
			        	top+=rs.getInt("tutar");
			        }
			       table.setModel(modelim);
			       lbtop.setText(""+top);
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				
			}
		});
		order.setFont(new Font("Tahoma", Font.PLAIN, 13));
		order.setBounds(764, 262, 117, 21);
		contentPane.add(order);
		
		JButton btnGrupla = new JButton("Grupla");
		btnGrupla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					top=0;
					lbl.setText("Toplam Sipariþ Sayýsý");
					tfsource.setText("");
					tfurun.setVisible(false);
					tfsource.setVisible(true);
					modelim.setRowCount(0);	
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        		    
			     ResultSet rs =st.executeQuery("select Kullaniciadi,count(tutar) as \"siparis_sayisi\" from orders group by Kullaniciadi \r\n"
			     		+ "order by  Kullaniciadi ASC");
			     modelim.setColumnIdentifiers(grup);
			        while(rs.next())
			        {
			        		satýrlar[0]=rs.getString("Kullaniciadi");
			        		satýrlar[1]=rs.getInt("siparis_sayisi");
			        		top+=rs.getInt("siparis_sayisi");
			        	modelim.addRow(satýrlar);	
			        	
			        }
			       table.setModel(modelim);
			       lbtop.setText(""+top);
			       
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
			}
		});
		btnGrupla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGrupla.setBounds(764, 312, 117, 21);
		contentPane.add(btnGrupla);
		
	
		
		
		
	}
}
