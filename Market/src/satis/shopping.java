package satis;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Helpers.DBConnection;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class shopping extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shopping frame = new shopping();
					frame.setVisible(true);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String ad;
	public int topm,topi,topc,topd;
	public int tutar=0;
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
	 public shopping() {
	 	setTitle("G\u00F6t\u00FCrd\u00FCm");     		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 608);		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu hesap = new JMenu("Hesap");
		menuBar.add(hesap);
		
		JMenuItem menubilgiler = new JMenuItem("Bilgilerim");
		menubilgiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myinformation f6=new myinformation();
				f6.setVisible(true);
				
			}
		});
		hesap.add(menubilgiler);
		
		JMenuItem menusifre = new JMenuItem("\u015Eifre ve Adres De\u011Fi\u015F");
		menusifre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_password f5=new new_password();
				f5.setVisible(true);
			}
		});
		hesap.add(menusifre);
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();	
	         ad="select Kullaniciadi from active";
	       ResultSet rs =st.executeQuery(ad);
	       while(rs.next())
	       {
	        hesap.setText(rs.getString("Kullaniciadi"));
	       }
	       st.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
	
		
		JMenuItem menucikis = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		menucikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();			       
			        st.executeUpdate("delete from active");		       
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				dispose();
				member_login f1=new member_login();
				f1.setVisible(true);
			}
		});
		hesap.add(menucikis);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Monospaced", Font.PLAIN, 15));
		tabbedPane.setBounds(10, 10, 906, 487);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Meyveler", null, panel, null);
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ýçecekler", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		
		JLabel lbtoplam2 = new JLabel("");
		lbtoplam2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbtoplam2.setBounds(760, 378, 131, 24);
		panel_1.add(lbtoplam2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Kahveler", null, panel_2, null);
		panel_2.setLayout(null);
		
	
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Dondurmalar", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lbtoplam4 = new JLabel("");
		lbtoplam4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbtoplam4.setBounds(760, 378, 131, 24);
		panel_3.add(lbtoplam4);
		
		
		
		JLabel lbtoplam = new JLabel("");
		lbtoplam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbtoplam.setBounds(760, 378, 131, 24);
		panel.add(lbtoplam);
		
		JLabel lbtoplam3 = new JLabel("");
		lbtoplam3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbtoplam3.setBounds(760, 378, 131, 24);
		panel_2.add(lbtoplam3);
	
		
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
		for (int i = 0; i <indexm ; i++) 
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
	   
	    for (int i = 0; i <indexm; i++) 
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
	    	       
	    	       
	    	       
	    	        }
	    			}
	    			catch(SQLException e1) {

	    	            e1.printStackTrace();
	    	        }
	    		 int xd=10,yd=109;
	        		
	        		for (int i = 0; i <indexi ; i++) 
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
	    	    	    		
	    	    	    		for (int i = 0; i < indexi; i++) 
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
	    	    	    	    	       
	    
		
		JButton btngüncel = new JButton("G\u00FCncel Tutar\u0131 G\u00F6ster");
		btngüncel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			topm=0; topi=0; topc=0; topd=0;
			
				for(int i=0; i<indexm;i++)
				{
					topm+=(meyveprice[i]*(int)spinner[i].getValue());
				}
				for(int i=0; i<indexi; i++)
				{
					topi+=(icecekprice[i]*(int)spinner1[i].getValue());
				}
				for(int i=0; i<indexc; i++)
				{
					topc+=(coffeeprice[i]*(int)spinner2[i].getValue());
				}
				for(int i=0; i<indexd; i++)
				{
					topd+=(dondurmaprice[i]*(int)spinner3[i].getValue());
				}
				    tutar=topm+topi+topc+topd;
				    lbtoplam.setText("Toplam Tutarýnýz: "+tutar+"tl");
					lbtoplam2.setText(lbtoplam.getText());
					lbtoplam3.setText(lbtoplam.getText());
					lbtoplam4.setText(lbtoplam.getText());
								
			}
		});
			
		JButton btngüncel2 = new JButton("G\u00FCncel Tutar\u0131 G\u00F6ster");
		btngüncel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topm=0; topi=0; topc=0; topd=0;
			
		for(int i=0; i<indexm;i++)
		{
			topm+=(meyveprice[i]*(int)spinner[i].getValue());
		}
		for(int i=0; i<indexi; i++)
		{
			topi+=(icecekprice[i]*(int)spinner1[i].getValue());
		}
		for(int i=0; i<indexc; i++)
		{
			topc+=(coffeeprice[i]*(int)spinner2[i].getValue());
		}
		for(int i=0; i<indexd; i++)
		{
			topd+=(dondurmaprice[i]*(int)spinner3[i].getValue());
		}
				tutar=topm+topi+topc+topd;
				lbtoplam2.setText("Toplam Tutarýnýz: "+tutar+"tl");
				lbtoplam.setText(lbtoplam2.getText());
				lbtoplam3.setText(lbtoplam2.getText());
				lbtoplam4.setText(lbtoplam2.getText());
				
			}
		});
		btngüncel2.setBounds(706, 412, 185, 30);
		panel_1.add(btngüncel2);
		btngüncel.setBounds(706, 412, 185, 30);
		panel.add(btngüncel);
		
		
		JButton btngüncel3 = new JButton("G\u00FCncel Tutar\u0131 G\u00F6ster");
		btngüncel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topm=0; topi=0; topc=0; topd=0;
			
			
			for(int i=0; i<indexm;i++)
			{
				topm+=(meyveprice[i]*(int)spinner[i].getValue());
			}
			for(int i=0; i<indexi; i++)
			{
				topi+=(icecekprice[i]*(int)spinner1[i].getValue());
			}
			for(int i=0; i<indexc; i++)
			{
				topc+=(coffeeprice[i]*(int)spinner2[i].getValue());
			}
			for(int i=0; i<indexd; i++)
			{
				topd+=(dondurmaprice[i]*(int)spinner3[i].getValue());
			}
			tutar=topm+topi+topc+topd;
			    lbtoplam3.setText("Toplam Tutarýnýz: "+tutar+"tl");
				lbtoplam.setText(lbtoplam3.getText());
				lbtoplam2.setText(lbtoplam3.getText());
				lbtoplam4.setText(lbtoplam3.getText());
			}
		});
		btngüncel3.setBounds(706, 412, 185, 30);
		panel_2.add(btngüncel3);
		
	
		JButton btnguncel4 = new JButton("G\u00FCncel Tutar\u0131 G\u00F6ster");
		btnguncel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topm=0; topi=0; topc=0; topd=0;
			
				for(int i=0; i<indexm;i++)
				{
					topm+=(meyveprice[i]*(int)spinner[i].getValue());
				}
				for(int i=0; i<indexi; i++)
				{
					topi+=(icecekprice[i]*(int)spinner1[i].getValue());
				}
				for(int i=0; i<indexc; i++)
				{
					topc+=(coffeeprice[i]*(int)spinner2[i].getValue());
				}
				for(int i=0; i<indexd; i++)
				{
					topd+=(dondurmaprice[i]*(int)spinner3[i].getValue());
				}
				tutar=topm+topi+topc+topd;
				lbtoplam4.setText("Toplam Tutarýnýz: "+tutar+"tl");
				lbtoplam.setText(lbtoplam4.getText());
				lbtoplam2.setText(lbtoplam4.getText());
				lbtoplam3.setText(lbtoplam4.getText());
				
			}
		});
		btnguncel4.setBounds(706, 412, 185, 30);
		panel_3.add(btnguncel4);
	
		
		JButton finish = new JButton("Sat\u0131n al");
		finish.setBounds(785, 497, 131, 26);
		contentPane.add(finish);
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cevap=JOptionPane.showConfirmDialog(null,"Alýþveriþi tamamlamak istiyor musunuz ?","Satýn al",JOptionPane.YES_NO_OPTION);
				if(cevap==0)
				{
                  try {
					
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();		        		     			        
			        	st.executeUpdate("Update active SET  tutar='"+tutar+"'");
			        
                  }
                  catch(SQLException e1) 
				    {

			            e1.printStackTrace();
			        }	
				 finish f8=new finish();
					f8.setVisible(true);
					dispose();
				}
			}
		});
		
	}
}
