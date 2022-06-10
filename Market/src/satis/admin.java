package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import Helpers.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Helpers.DBConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class admin extends JFrame {
	
	private JPanel contentPane;
	private JTextField c_fiyati;
	private JTextField c_urunadi;
	private JTextField c_uruncesit;
	private JTextField d_fiyati;
	private JTextField d_urunadi;
	private JTextField d_uruncesit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	int indexm=0,indexf=0,indeximg=0,indexi=0,indexif=0,indeximgi=0,indexc=0,indexcf=0,indeximgc=0,indexd=0,indexcd=0,indeximgd=0;
	   JSpinner[] spinner = new JSpinner[15];
	   JSpinner[] spinner1 = new JSpinner[15];
	   JSpinner[] spinner2 = new JSpinner[15];
	   JSpinner[] spinner3 = new JSpinner[15];
	   JTextField[] textbox = new JTextField[15];
		JTextField[] textbox1 = new JTextField[11];
		JTextField[] textbox2 = new JTextField[15];
		JTextField[] textbox3 = new JTextField[15];
		JLabel[] label = new JLabel[11];
		JLabel[] label1 = new JLabel[15];
		JLabel[] label2 = new JLabel[15];
		JLabel[] label3 = new JLabel[15];
	   int [] meyveprice=new int[15];
	   int [] meyvecount=new int[15];
		String [] meyveimg=new String[11];
		int [] icecekcount=new int[11];
		int [] icecekprice=new int[15];
		String [] icecekimg=new String[11];
		int [] coffeecount=new int[15];
		int [] coffeeprice=new int[15];
		String [] coffeeimg=new String[15];
		int [] dondurmacount=new int[15];
		int [] dondurmaprice=new int[15];
		String [] dondurmaimg=new String[15];
		String[] name=new String[13];
		String[] namei=new String[13];
		String[] namec=new String[13];
		String[] named=new String[13];
	public admin() {
		setTitle("Admin Formu");
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 573);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu hesap = new JMenu("Hesap");
		menuBar.add(hesap);
		

		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	       
	       ResultSet rs =st.executeQuery("select Kullaniciadi from active ");
	       while(rs.next())
	       {
	        hesap.setText(rs.getString("Kullaniciadi"));
	       }
	       st.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		
		JMenuItem sifre = new JMenuItem("\u015Eifre De\u011Fi\u015Fikli\u011Fi");
		sifre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_password f1=new new_password();
				f1.setVisible(true);
			}
		});
		hesap.add(sifre);
		
		JMenuItem newadmin = new JMenuItem("Yeni Admin Ekle");
		newadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addadmin f7=new addadmin();
				f7.setVisible(true);
			
			}
		});
		hesap.add(newadmin);
		
		JMenuItem exit = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();			       
			        st.executeUpdate("delete from active");	
			        st.close();
					}
				
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				dispose();
				member_login f1=new member_login();
				f1.setVisible(true);
			
			}
		});
		
		JMenuItem mnýtmNewMenuItem = new JMenuItem("Orders");
		mnýtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders f=new orders();
				f.setVisible(true);
			}
		});
		mnýtmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		hesap.add(mnýtmNewMenuItem);
		hesap.add(exit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBounds(10, 10, 902, 471);
		contentPane.add(tabbedPane);
	
		JPanel panel = new JPanel();
		tabbedPane.addTab("Meyveler", null, panel, null);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ýçecekler", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Kahveler", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton coffeeýnsert = new JButton("Yeni \u00DCr\u00FCn Ekle");
		coffeeýnsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();	
	       st.executeUpdate("INSERT INTO products(uruncesit,urunadi,fiyati) VALUES('"+c_uruncesit.getText()+"','"+c_urunadi.getText()+"','"+c_fiyati.getText()+"')");
			      JOptionPane.showMessageDialog(null,"Ürün Baþarýyla Eklenmiþtir" );
			      st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
			}
		});
		coffeeýnsert.setBounds(734, 389, 153, 28);
		panel_2.add(coffeeýnsert);
		
		c_fiyati = new JTextField();
		c_fiyati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c_fiyati.setText("");
			}
		});
		c_fiyati.setText("\u00DCr\u00FCn Fiyat\u0131n\u0131 Yaz\u0131n\u0131z");
		c_fiyati.setBounds(734, 360, 153, 19);
		panel_2.add(c_fiyati);
		c_fiyati.setColumns(10);
		
		c_urunadi = new JTextField();
		c_urunadi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c_urunadi.setText("");
			}
		});
		c_urunadi.setText("\u00DCr\u00FCn Ad\u0131n\u0131 Yaz\u0131\u0131n\u0131z");
		c_urunadi.setBounds(734, 331, 153, 19);
		panel_2.add(c_urunadi);
		c_urunadi.setColumns(10);
		
		c_uruncesit = new JTextField();
		c_uruncesit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c_uruncesit.setText("");
			}
		});
		c_uruncesit.setText("\u00DCr\u00FCn \u00C7esidini Yaz\u0131n\u0131z");
		c_uruncesit.setBounds(734, 302, 153, 19);
		panel_2.add(c_uruncesit);
		c_uruncesit.setColumns(10);
		
		JButton csil = new JButton("\u00DCr\u00FCn Sil");
		csil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();	
	              st.executeUpdate("DELETE from products where urunadi='"+c_urunadi.getText()+"' ");
			      JOptionPane.showMessageDialog(null,"Ürün Baþarýyla Silinmiþtir" );
			      st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
			}
		});
		csil.setBounds(639, 393, 85, 21);
		panel_2.add(csil);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Dondurmalar", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		
		d_fiyati = new JTextField();
		d_fiyati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d_fiyati.setText("");
			}
		});
		d_fiyati.setText("\u00DCr\u00FCn Fiyat\u0131n\u0131 Yaz\u0131n\u0131z");
		d_fiyati.setColumns(10);
		d_fiyati.setBounds(734, 360, 153, 19);
		panel_3.add(d_fiyati);
		
		d_urunadi = new JTextField();
		d_urunadi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d_urunadi.setText("");
			}
		});
		d_urunadi.setText("\u00DCr\u00FCn Ad\u0131n\u0131 Yaz\u0131\u0131n\u0131z");
		d_urunadi.setColumns(10);
		d_urunadi.setBounds(734, 331, 153, 19);
		panel_3.add(d_urunadi);
		
		d_uruncesit = new JTextField();
		d_uruncesit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d_uruncesit.setText("");
			}
		});
		d_uruncesit.setText("\u00DCr\u00FCn \u00C7esidini Yaz\u0131n\u0131z");
		d_uruncesit.setColumns(10);
		d_uruncesit.setBounds(734, 302, 153, 19);
		panel_3.add(d_uruncesit);
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       
	        
	        ResultSet rs =st.executeQuery("select ID,urunadi,fiyati from products where uruncesit='meyve' ");
	      
	        while(rs.next()) 
	        {
	        	indexm++;
	        	
	        	meyvecount[indexm]=rs.getInt("ID");
	            name[indexm-1]=rs.getString("urunadi");
	            meyveprice[indexm-1]=rs.getInt("fiyati");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		int x=10,y=109;
		for (int i = 0; i <name.length ; i++) 
		{		
			
		    textbox[i] = new JTextField("");
		    textbox[i].setText(name[i]+" Kg Fiyatý:"+meyveprice[i]);
		    textbox[i].setBounds(x, y, 150, 24);		    
		    panel.add(textbox[i]);
		    
		    x+=160;
		    if(x>700)
		    {
		    	x=10;
		    	y+=210;
		    		
		    }
		}
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       
	        
	        ResultSet rs =st.executeQuery("select ID,adress from products_img where uruncesit='meyve' ");
	      
	        while(rs.next()) 
	        {
	        	indeximg++;
	        	
	        	meyveimg[indeximg-1]=rs.getString("adress");
			
	            int z=10,t=10;
	    		
	    		for (int i = 0; i <rs.getRow(); i++) 
	    		{			
	    		    label[i] = new JLabel("");
	    		    label[i].setText("");
	    		    label[i].setBounds(z, t, 100, 100);
	    		    panel.add(label[i]);
	    		    Image img=new ImageIcon(this.getClass().getResource(meyveimg[i])).getImage();
	    		    label[i].setIcon(new ImageIcon(img));
	    		    z+=160;		
	    		    if(z>700)
	    		    {
	    		    	z=10;
	    		    	t+=210;
	    		    		
	    		    }
	    		}
	        }
	        st.close();
		}
		catch(SQLException e1) {

            e1.printStackTrace();
        }
	 
	    int a=120,b=44;
	   
	    for (int i = 0; i < 15; i++) 
	    {			
	    	spinner[i] = new JSpinner();
	    	spinner[i].setBounds(a, b, 40, 40);
	    	panel.add(spinner[i]);	  	    	
	    	a+=160;		
	    	if(a>800)
	    	 {
	    	 a=120;
	    	 b+=210;
	    	    		    		
	    	 }   	       
	    	       
	    }
	    		try {
	    			DBConnection conn=new DBConnection();
	    	        Connection con=conn.connDb();
	    	        Statement st=con.createStatement();			       
	    	        
	    	        ResultSet rs =st.executeQuery("select ID,urunadi,fiyati from products where uruncesit='icecek'");
	    	      
	    	        while(rs.next()) 
	    	        {
	    	        	indexi++;
	    	        	
	    	        	icecekcount[indexi]=rs.getInt("ID");
	    	        	
	    	            namei[indexi-1]=rs.getString("urunadi");
	    	            icecekprice[indexi-1]=rs.getInt("fiyati");
	    	       
	    	       
	    	        int xd=10,yd=109;
	        		
	        		for (int i = 0; i <rs.getRow() ; i++) 
	        		{		
	        			
	        		    textbox1[i] = new JTextField("");
	        		    textbox1[i].setText(namei[i]+" Adet Fiyatý:"+icecekprice[i]);
	        		    textbox1[i].setBounds(xd, yd, 150, 24);		    
	        		    panel_1.add(textbox1[i]);	    
	        		    xd+=160;
	        		    if(xd>700)
	        		    {
	        		    	xd=10;
	        		    	yd+=210;
	        		    		
	        		    }
	        		}
	    	        }
	    			}
	    			catch(SQLException e1) {

	    	            e1.printStackTrace();
	    	        }
	    		
	    		
	    		try {
	    			DBConnection conn=new DBConnection();
	    	        Connection con=conn.connDb();
	    	        Statement st=con.createStatement();			       
	    	        
	    	        ResultSet rs =st.executeQuery("select ID,adress from products_img where uruncesit='icecek' ");
	    	      
	    	        while(rs.next()) 
	    	        {
	    	        	indeximgi++;
	    	        	
	    	        	icecekimg[indeximgi-1]=rs.getString("adress");
	    			
	    	            int z=10,t=10;
	    	    		
	    	    		for (int i = 0; i <rs.getRow(); i++) 
	    	    		{			
	    	    		    label1[i] = new JLabel("");
	    	    		    label1[i].setText("");
	    	    		    label1[i].setBounds(z, t, 100, 100);
	    	    		    panel_1.add(label1[i]);
	    	    		    Image img=new ImageIcon(this.getClass().getResource(icecekimg[i])).getImage();
	    	    		    label1[i].setIcon(new ImageIcon(img));
	    	    		    z+=160;		
	    	    		    if(z>700)
	    	    		    {
	    	    		    	z=10;
	    	    		    	t+=210;
	    	    		    		
	    	    		    }
	    	    		}
	    	        }
	    		}
	    		catch(SQLException e1) {

	                e1.printStackTrace();
	            }
	    	    		
	    	    	
	    	    	        	int af=120,bf=44;
	    	    	    		
	    	    	    		for (int i = 0; i < namei.length; i++) 
	    	    	    		{			
	    	    	    			spinner1[i] = new JSpinner();
	    	    	    			spinner1[i].setBounds(af, bf, 40, 40);
	    	    	    			panel_1.add(spinner1[i]);	    	    			
	    	    	    		    af+=160;		
	    	    	    		    if(af>800)
	    	    	    		    {
	    	    	    		    	af=120;
	    	    	    		    	bf+=210;
	    	    	    		    		
	    	    	    		    }
	    	    	    		}
  	    	        
	    	    		
		
		
	    	    		try {
	    	    			DBConnection conn=new DBConnection();
	    	    	        Connection con=conn.connDb();
	    	    	        Statement st=con.createStatement();			       
	    	    	        
	    	    	        ResultSet rs =st.executeQuery("select ID,urunadi,fiyati from products where uruncesit='coffee'");
	    	    	      
	    	    	        while(rs.next()) 
	    	    	        {
	    	    	        	indexc++;
	    	    	        	
	    	    	        	coffeecount[indexc]=rs.getInt("ID");
	    	    	        	
	    	    	            namec[indexc-1]=rs.getString("urunadi");
	    	    	           coffeeprice[indexc-1]=rs.getInt("fiyati");
	    	    	       
	    	    	       
	    	    	      
	    	    	        }
	    	    	        st.close();
	    	    			}
	    	    			catch(SQLException e1) {

	    	    	            e1.printStackTrace();
	    	    	        }
	    	    		
	    	    		  int xa=10,ya=109;
	    	        		
	    	        		for (int i = 0; i <indexc ; i++) 
	    	        		{		
	    	        			
	    	        		    textbox2[i] = new JTextField("");
	    	        		    textbox2[i].setText(namec[i]+" Adet Fiyatý:"+coffeeprice[i]);
	    	        		    textbox2[i].setBounds(xa, ya, 150, 24);		    
	    	        		    panel_2.add(textbox2[i]);	    
	    	        		    xa+=160;
	    	        		    if(xa>700)
	    	        		    {
	    	        		    	xa=10;
	    	        		    	ya+=210;
	    	        		    		
	    	        		    }
	    	        		    
	    	        		}	
	    	    		
	    	    		
	    	    		try {
	    	    			DBConnection conn=new DBConnection();
	    	    	        Connection con=conn.connDb();
	    	    	        Statement st=con.createStatement();			       
	    	    	        
	    	    	        ResultSet rs =st.executeQuery("select ID,adress from products_img where uruncesit='coffee' ");
	    	    	      
	    	    	        while(rs.next()) 
	    	    	        {
	    	    	        	indeximgc++;
	    	    	        	
	    	    	        	coffeeimg[indeximgc-1]=rs.getString("adress");
	    	    			
	    	    	            int z=10,t=10;
	    	    	    		
	    	    	    		for (int i = 0; i <rs.getRow(); i++) 
	    	    	    		{			
	    	    	    		    label2[i] = new JLabel("");
	    	    	    		    label2[i].setText("");
	    	    	    		    label2[i].setBounds(z, t, 100, 100);
	    	    	    		    panel_2.add(label2[i]);
	    	    	    		    Image img=new ImageIcon(this.getClass().getResource(coffeeimg[i])).getImage();
	    	    	    		    label2[i].setIcon(new ImageIcon(img));
	    	    	    		    z+=160;		
	    	    	    		    if(z>700)
	    	    	    		    {
	    	    	    		    	z=10;
	    	    	    		    	t+=210;
	    	    	    		    		
	    	    	    		    }
	    	    	    		}
	    	    	        }
	    	    		}
	    	    		catch(SQLException e1) {

	    	                e1.printStackTrace();
	    	            }
	    	    	    		
	    	    	    	        	int as=120,bs=44;
	    	    	    	    		for(int i=0; i<indexc; i++)
	    	    	    	    		{
	    	    	    	        	spinner2[i] = new JSpinner();
    	    	    	    			spinner2[i].setBounds(as, bs, 40, 40);
    	    	    	    			panel_2.add(spinner2[i]);	    	    			
    	    	    	    		    as+=160;		
    	    	    	    		    if(as>800)
    	    	    	    		    {
    	    	    	    		    	as=120;
    	    	    	    		    	bs+=210;
    	    	    	    		    		
    	    	    	    		    }
	    	    	    	    		}
	    	    	    	       
	    	    	    	       
	    	    	    	       
		
	    	    	    		try {
	    	    	    			DBConnection conn=new DBConnection();
	    	    	    	        Connection con=conn.connDb();
	    	    	    	        Statement st=con.createStatement();			       
	    	    	    	        
	    	    	    	        ResultSet rs =st.executeQuery("select ID,urunadi,fiyati from products where uruncesit='dondurma'");
	    	    	    	      
	    	    	    	        while(rs.next()) 
	    	    	    	        {
	    	    	    	        	indexd++;
	    	    	    	        	
	    	    	    	        	dondurmacount[indexd]=rs.getInt("ID");
	    	    	    	        	
	    	    	    	            named[indexd-1]=rs.getString("urunadi");
	    	    	    	            dondurmaprice[indexd-1]=rs.getInt("fiyati");
	    	    	    	       
	    	    	    	       
	    	    	    	       
	    	    	    	        }
	    	    	    	        st.close();
	    	    	    			}
	    	    	    			catch(SQLException e1) {

	    	    	    	            e1.printStackTrace();
	    	    	    	        }
	    	    	    		 int xs=10,ys=109;
	    	    	        		
	    	    	        		for (int ia= 0; ia<indexd ; ia++) 
	    	    	        		{		
	    	    	        			
	    	    	        		    textbox3[ia] = new JTextField("");
	    	    	        		    textbox3[ia].setText(named[ia]+" Adet Fiyatý:"+dondurmaprice[ia]);
	    	    	        		    textbox3[ia].setBounds(xs, ys, 180, 24);		    
	    	    	        		    panel_3.add(textbox3[ia]);	    
	    	    	        		    xs+=210;
	    	    	        		    if(xs>500)
	    	    	        		    {
	    	    	        		    	xs=10;
	    	    	        		    	ys+=210;
	    	    	        		    		
	    	    	        		    }
	    	    	        		}	
	    	    	    		
	    	    	    		try {
	    	    	    			DBConnection conn=new DBConnection();
	    	    	    	        Connection con=conn.connDb();
	    	    	    	        Statement st=con.createStatement();			       
	    	    	    	        
	    	    	    	        ResultSet rs =st.executeQuery("select ID,adress from products_img where uruncesit='dondurma' ");
	    	    	    	      
	    	    	    	        while(rs.next()) 
	    	    	    	        {
	    	    	    	        	indeximgd++;
	    	    	    	        	
	    	    	    	        	dondurmaimg[indeximgd-1]=rs.getString("adress");
	    	    	    			
	    	    	    	            int z=20,t=10;
	    	    	    	    		
	    	    	    	    		for (int id = 0; id <rs.getRow(); id++) 
	    	    	    	    		{			
	    	    	    	    		    label3[id] = new JLabel("");
	    	    	    	    		    label3[id].setText("");
	    	    	    	    		    label3[id].setBounds(z, t, 100, 100);
	    	    	    	    		    panel_3.add(label3[id]);
	    	    	    	    		    Image img=new ImageIcon(this.getClass().getResource(dondurmaimg[id])).getImage();
	    	    	    	    		    label3[id].setIcon(new ImageIcon(img));
	    	    	    	    		    z+=210;		
	    	    	    	    		    if(z>500)
	    	    	    	    		    {
	    	    	    	    		    	z=20;
	    	    	    	    		    	t+=210;
	    	    	    	    		    		
	    	    	    	    		    }
	    	    	    	    		}
	    	    	    	        }
	    	    	    		}
	    	    	    		catch(SQLException e1) {

	    	    	                e1.printStackTrace();
	    	    	            }
	    	    	    	    		
	    	    	    	    	        	int ad=150,bd=44;
	    	    	    	    	    		
	    	    	    	    	    		for (int is = 0; is < indexd; is++) 
	    	    	    	    	    		{			
	    	    	    	    	    			spinner3[is] = new JSpinner();
	    	    	    	    	    			spinner3[is].setBounds(ad, bd, 40, 40);
	    	    	    	    	    			panel_3.add(spinner3[is]);	    	    			
	    	    	    	    	    		    ad+=210;		
	    	    	    	    	    		    if(ad>700)
	    	    	    	    	    		    {
	    	    	    	    	    		    	ad=150;
	    	    	    	    	    		    	bd+=210;
	    	    	    	    	    		    		
	    	    	    	    	    		    }
	    	    	    	    	    		}
		
		
		
		JButton dondurmaýnsert = new JButton("Yeni \u00DCr\u00FCn Ekle");
		dondurmaýnsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();	
	       st.executeUpdate("INSERT INTO products(uruncesit,urunadi,fiyati) VALUES('"+d_uruncesit.getText()+"','"+d_urunadi.getText()+"','"+d_fiyati.getText()+"')");
			      JOptionPane.showMessageDialog(null,"Ürün Baþarýyla Eklenmiþtir" );
			      st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
			}
		});
		dondurmaýnsert.setBounds(734, 389, 153, 28);
		panel_3.add(dondurmaýnsert);
		
		JButton dsil = new JButton("\u00DCr\u00FCn Sil");
		dsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();	
	              st.executeUpdate("DELETE from products where urunadi='"+d_urunadi.getText()+"' ");
			      JOptionPane.showMessageDialog(null,"Ürün Baþarýyla Silinmiþtir" );
			      st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
			}
		});
		dsil.setBounds(639, 393, 85, 21);
		panel_3.add(dsil);
		
		JButton btnyenile = new JButton("G\u00FCncelle");
		btnyenile.setBounds(743, 477, 169, 30);
		contentPane.add(btnyenile);
		
		
		btnyenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
									
				DBConnection conn=new DBConnection();
                 Connection con=conn.connDb();
                 Statement st=con.createStatement();
                 for(int i=0; i<name.length; i++)
                 {
                	 if((int)spinner[i].getValue()!=0) {
                    	 st.executeUpdate("UPDATE products SET fiyati="+spinner[i].getValue()+" where urunadi='"+name[i]+"'");
                     }
                 }
                 for(int i=0; i<namei.length; i++)
                 {
                	 if((int)spinner1[i].getValue()!=0) {
                    	 st.executeUpdate("UPDATE products SET fiyati="+spinner1[i].getValue()+" where urunadi='"+namei[i]+"'");
                     }
                 }
                 for(int i=0; i<indexc; i++)
                 {
                	 if((int)spinner2[i].getValue()!=0) {
                    	 st.executeUpdate("UPDATE products SET fiyati="+spinner2[i].getValue()+" where urunadi='"+namec[i]+"'");
                     }
                 }
           
                 for(int i=0; i<indexd; i++)
                 {
                	 if((int)spinner3[i].getValue()!=0) {
                         st.executeUpdate("UPDATE products SET fiyati="+spinner3[i].getValue()+" where urunadi='"+named[i]+"'");
        				}
                 }
               
          
               JOptionPane.showMessageDialog(null, "Deðiþiklikler Uygulandý!");
              dispose();
              admin f=new admin();
              f.setVisible(true);
               
                 }
				
				catch(SQLException e1) {

                    e1.printStackTrace();
                }
				
			}
		});
		
		
	}
}
