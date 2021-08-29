import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class CloudServer2 extends JFrame implements ActionListener {
		
		
		Container c;
		JButton j1,j2,j3;
		JMenuBar mb;
		JMenu m;
		JMenuItem m1,m2,m3,m4,m6,m5,m7,m22,m222,m11;
		
		
		
		Font f2 = new Font("Times new Roman",Font.BOLD,14);
		Font f1 = new Font("Times new Roman",Font.BOLD,13);
		ImageIcon con = new ImageIcon(this.getClass().getResource("connector.jpg"));
		ImageIcon cloud = new ImageIcon(this.getClass().getResource("cloud1.jpg"));
		ImageIcon bar = new ImageIcon(this.getClass().getResource("doarrow.png"));
		ImageIcon gar = new ImageIcon(this.getClass().getResource("greendoarrow.png"));

		JLabel lcon,lcloud,lar,l2,l3;
		
		/*ImageIcon bdc = new ImageIcon(this.getClass().getResource("bdc.png"));
		ImageIcon gdc = new ImageIcon(this.getClass().getResource("gdc.png"));
		
		
		ImageIcon bcs = new ImageIcon(this.getClass().getResource("bcs.png"));
		ImageIcon gcs = new ImageIcon(this.getClass().getResource("gcs.png"));
		
		ImageIcon bcsar = new ImageIcon(this.getClass().getResource("bcsar.png"));
		ImageIcon gcsar = new ImageIcon(this.getClass().getResource("gcsar.png"));*/
		
		JLabel lbdc,lbcs,lbcsar;
		
		CloudServer2()
		{
			
			setTitle("CloudServer2::A Hybrid Cloud Approach for Secure Authorized Deduplication");
			c = getContentPane();
			c.setLayout(null);
			mb = new JMenuBar();
			m = new JMenu("File");
			m1 =  new JMenuItem("ADD DATA OWNER");
			
			m.add(m1);
			m2 =  new JMenuItem("VIEW BLOCKED OWNERS");
			m.add(m2);
			m2.addActionListener(this);
			
			m3 =  new JMenuItem("GRANT DATA OWNER");
			m.add(m3);
			m3.addActionListener(this);
			m11 =  new JMenuItem("VIEW CLOUD USERS");
	
			m.add(m11);
			
			m1.addActionListener(this);
			m11.addActionListener(this);
			
Border b11=BorderFactory.createLineBorder(Color.black,3);
			
			
			TitledBorder b22=new TitledBorder(b11);
			b22.setTitle("Cloud Server2");
			b22.setTitleColor(Color.blue);
			b22.setTitleFont(f2);
			JLabel bord =new JLabel();
			bord.setBorder(b22);
			bord.setBackground(Color.black);
			bord.setBounds(0,-3,580,320);
			c.add(bord);
			
			j1 =  new JButton("DATA OWNERS DETAILS");
			j1.setFont(f1);
			j1.setBounds(10,250,182,30);
			c.add(j1);
			
			j2 =  new JButton("VIEW ALL OWNER FILES");
			j2.setFont(f1);
			j2.setBounds(200,250,181,30);
			c.add(j2);
			
			j3 =new JButton("ATTACKER DETAILS");
			j3.setBounds(390,250,157,30);
			j3.setFont(f1);
			c.add(j3);
			j3.addActionListener(this);
			
			m7 =  new JMenuItem("UNBLOCK USER");
			m.add(m7);
			m7.addActionListener(this);
			m4 =  new JMenuItem("EXIT");
			m.add(m4);
			
			m4.addActionListener(this);
			
			
			
			j1.addActionListener(this);
			j2.addActionListener(this);
			mb.add(m);
			setJMenuBar(mb);
			
			lcon=new JLabel();
			lcon.setIcon(con);
			lcon.setBounds(60,50,150,150);
			c.add(lcon);
			
			lcloud=new JLabel();
			lcloud.setIcon(cloud);
			lcloud.setBounds(340,45,150,150);
			c.add(lcloud);
			
			lar=new JLabel();
			lar.setIcon(bar);
			lar.setBounds(220,75,300,100);
			c.add(lar);
			
			l2=new JLabel("Connector");
			l2.setFont(f2);
			l2.setForeground(Color.BLUE);
			l2.setBounds(90, 80, 200, 200);
			c.add(l2);
			
			l3=new JLabel("Cloud Server");
			l3.setFont(f2);
			l3.setForeground(Color.BLUE);
			l3.setBounds(360, 80, 200, 200);
			c.add(l3);
			
			c.setBackground(Color.white);
			setSize(600,380);
			setVisible(true);
			
			
			
			int[] ports = new int[]{550,572,351,103,352,802,3000,7799,3002,6755,402,202,10014,106,2015,406,442};
			for(int i=0;i<17;i++)
			{
				Thread th = new Thread(new portlistener(ports[i]));
				th.start();
			}
			
		}
		
		public class portlistener implements Runnable
		{
			int port;
			portlistener(int port)
			{
				this.port=port;
			}
			
			public void run()
			{
				
				if(this.port==402)
				{
					try
					{
						ServerSocket sc = new ServerSocket(402);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							
							String content = din.readUTF();
							String filename = (String)din.readUTF();
							String owner = (String)din.readUTF();
							String sk = (String)din.readUTF();
							String hash = (String)din.readUTF();
							String cloudname = (String)din.readUTF();
							System.out.println("Encrypted contents in the cloud ="+content);
							
							lcon.setVisible(false);
							Thread.sleep(1000);
							lcon.setVisible(true);
							Thread.sleep(1000);
							lcon.setVisible(false);
							Thread.sleep(1000);
							lcon.setVisible(true);
							Thread.sleep(1000);
							lar.setVisible(false);
							lar.setIcon(gar);
							lar.setVisible(true);
							Thread.sleep(1000);
							lcloud.setVisible(false);
							Thread.sleep(1000);
							lcloud.setVisible(true);
							Thread.sleep(1000);
							lcloud.setVisible(false);
							Thread.sleep(1000);
							lcloud.setVisible(true);
							Thread.sleep(1000);
							DBCon db = new DBCon();
							Connection con = db.getConnection();
																			
							Statement stmt1 = con.createStatement();
							String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
							stmt1.executeUpdate(sql1);
						
							String path = "CloudServer2/"+owner;
							new File("CloudServer2/"+owner).mkdir();
							PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
							p.print(new String(content));
							
							DataOutputStream dout = new DataOutputStream(s.getOutputStream());
							dout.writeUTF("success");
							Thread.sleep(2000);
							lar.setVisible(false);
							lar.setIcon(bar);
							lar.setVisible(true);
						
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if(this.port==202)
				{
					try
					{
						ServerSocket sc = new ServerSocket(202);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String username = din.readUTF();
							String cloudname = din.readUTF();
							
							System.out.println(username);
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from owner where name='"+username+"' and cloudname='"+cloudname+"'";
							ResultSet rs = stmt.executeQuery(sql);
							if(rs.next()==true)
							{
								System.out.println("success");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("Success");
							}
							else if(rs.next()==false)
							{
								System.out.println("failure");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("failure");
							}
							
							
							
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if (this.port == 2015) {
					try {

						ServerSocket server3 = new ServerSocket(2015);
						Socket con2;
						while (true) {
							con2 = server3.accept();
							DataInputStream dis11 = new DataInputStream(
									con2.getInputStream());

							String name = dis11.readUTF();
							String password = dis11.readUTF();
							String email = dis11.readUTF();
							String org = dis11.readUTF();
							String city = dis11.readUTF();
							
								
								DBCon db = new DBCon();
								Connection con = db.getConnection();
								Statement stmt = con.createStatement();
								 String sql = "insert into owner values('"+name+"','"+password+"','"+email+"','"+org+"','"+city+"','CS2')";
								stmt.executeUpdate(sql);
								String message = "success";

								DataOutputStream os = new DataOutputStream(
										con2.getOutputStream());
								os.writeUTF(message);
							
							
						}
					}

					catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(this.port==802)
				{
					try
					{
						ServerSocket sc = new ServerSocket(802);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String name = din.readUTF();
							String amount = din.readUTF();
							String ip1 = din.readUTF();
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from power where pname='"+name+"'";
							ResultSet rs = stmt.executeQuery(sql);
							if(rs.next()==true)
							{
												
								Statement stmt1 = con.createStatement();
								String sql1 = "update power set psize='"+amount+"',status='Attacked',Attackerip='"+ip1+"' where pname='"+name+"'";
								stmt1.executeUpdate(sql1);
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("Success");
							}
							
							
						}
						
					}
					
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if(this.port==352)
				{
					try
					{
						ServerSocket sc = new ServerSocket(352);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String msg = din.readUTF();
							if(msg.equalsIgnoreCase("check"))
							{
							String name = din.readUTF();
							String owner = din.readUTF();
							String ip = din.readUTF();
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from remote where RemoteUser='"+name+"'and Owner='"+owner+"' and cloudname='CS2'";
							ResultSet rs = stmt.executeQuery(sql);
							
							
							if(rs.next()==true)
							{
								Statement block = con.createStatement();
								String blocksql = "select * from attacker where Attacker_name = '"+ name + "' and cloudname='CS2' ";
								ResultSet blockrs = block.executeQuery(blocksql);
								
								if (blockrs.next() == true) {
									System.out.println("in blocking");
									DataOutputStream ds = new DataOutputStream(s.getOutputStream());
									ds.writeUTF("block");
									
									
								}
								else if (blockrs.next() == false) {
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("success");	
								}
							}
							else if(rs.next()==false)
							{
								
									System.out.println("in unblocking");
									DataOutputStream ds = new DataOutputStream(s.getOutputStream());
									ds.writeUTF("unblock");
								
								
								/*Statement stmt1 = con.createStatement();
								String sql1 = "insert into attacker values('attacker','"+name+"','"+ip+"')";
								 stmt1.executeUpdate(sql1);*/
								
							}
							
							}
							else if(msg.equalsIgnoreCase("download"))
							{
								
								String name = din.readUTF();
								String owner = din.readUTF();
								String filename = din.readUTF();
								String sk = din.readUTF();
								String ip = din.readUTF();
								
								DBCon db = new DBCon();
								Connection con = db.getConnection();
								Statement stmt = con.createStatement();
								String sql = "select * from cloudfiles where Owner='"+owner+"'and filename='"+filename+"' and sk='"+sk+"' and cloudname='CS2'";
								ResultSet rs = stmt.executeQuery(sql);
							
								
								if(rs.next()==true)
								{
									
									FileInputStream fin = new FileInputStream("CloudServer2/"+owner+"/"+filename);
									byte[] b = new byte[fin.available()];
									fin.read(b);
									
									String st = new String(b);
									
									DataOutputStream oout = new DataOutputStream(s.getOutputStream());
									System.out.println("success");
									oout.writeUTF("success");
									oout.writeUTF(st);
									
									}
									
								else if(rs.next()==false)
								{
									
									Statement stmt2 = con.createStatement();
									String sql2 = "insert into attacker values('attacker','"+name+"','"+filename+"','"+sk+"','"+ip+"','CS2')";
									 stmt2.executeUpdate(sql2);
									DataOutputStream oout = new DataOutputStream(s.getOutputStream());
									oout.writeUTF("failure");
									
								}
								
								}
								
								
								
								}
							}
						
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				if(this.port==351)
				{
					try
					{
						ServerSocket sc = new ServerSocket(351);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String op = din.readUTF();
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from cloudfiles2";
							ResultSet rs = stmt.executeQuery(sql);
							/*ArrayList a1 = new ArrayList();
							ArrayList a2 = new ArrayList();*/
							
							String own = null;
							String file = null;
							
							
							while(rs.next()==true)
							{
								 own = rs.getString(1);
								 file = rs.getString(2);
								
								/*a1.add(own);
								a2.add(file);*/
							}
							
							DataOutputStream oout = new DataOutputStream(s.getOutputStream());
							oout.writeUTF(own);
							oout.writeUTF(file);
						
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				if(this.port==7799)
				{
					try
					{
						
						ServerSocket sc = new ServerSocket(7799);
						
						while(true)
						{
							
							Socket ss=sc.accept();
							DataInputStream din3 = new DataInputStream(ss.getInputStream());
							String name = din3.readUTF();
							String pass = din3.readUTF();
							
							DBCon db=new DBCon();
							Connection con=db.getConnection();
							Statement st=con.createStatement();
							String sql="select * from remote where RemoteUser='"+name+"' and Password='"+pass+"' and cloudname='CS2'";
							ResultSet rs=st.executeQuery(sql);
							
							if(rs.next()==true)
							{
								DataOutputStream don = new DataOutputStream(ss.getOutputStream());
								don.writeUTF("SUCCESS");
							}
							else
							{
								DataOutputStream don = new DataOutputStream(ss.getOutputStream());
								don.writeUTF("Failure");
							}
							
							
						}
					}catch(Exception es){System.out.println(es);}
				}
				if(this.port==6755)
				{
					try
					{
						
						ServerSocket sc = new ServerSocket(6755);
						
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String name = din.readUTF();
							String email = din.readUTF();
							String ph = din.readUTF();
							String comp = din.readUTF();
							String add = din.readUTF();
							String city = din.readUTF();
							int pw = din.readInt();
							String oname = din.readUTF();
							
							
							String pass=Integer.toString(pw);
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "insert into remote values('"+name+"','"+oname+"','"+email+"','"+ph+"','"+comp+"','"+add+"','"+city+"','"+pass+"','CS2')";
							stmt.executeUpdate(sql);
							
							
							DataOutputStream don = new DataOutputStream(s.getOutputStream());
							 don.writeUTF("SUCCESS");
							
							
						}
						
					}catch(Exception es ){System.out.println(es);}
				}
				if(this.port==550)
				{
					try
					{
						ServerSocket sc = new ServerSocket(550);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String username = din.readUTF();
							String password = din.readUTF();
							System.out.println(username);
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from owner where name='"+username+"' and pass='"+password+"' and cloudname='CS2'";
							ResultSet rs = stmt.executeQuery(sql);
							if(rs.next()==true)
							{
								System.out.println("success");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("Success");
							}
							else if(rs.next()==false)
							{
								System.out.println("failure");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("failure");
							}
							
							
							
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if(this.port==572)
				{
					try
					{
						ServerSocket sc = new ServerSocket(572);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String content = din.readUTF();
							String filename = (String)din.readUTF();
							String owner = (String)din.readUTF();
							String sk = (String)din.readUTF();
							
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							
										
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles2 values('"+owner+"','"+filename+"','"+sk+"')";
										stmt1.executeUpdate(sql1);
										String path = "CloudServer2/"+owner;
										new File("CloudServer2/"+owner).mkdir();
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
									/*	lbdc.setVisible(false);
										lbdc.setIcon(gdc);
										lbdc.setVisible(true);
										Thread.sleep(2000);
										
										lbcsar.setVisible(false);
										lbcsar.setIcon(gcsar);
										lbcsar.setVisible(true);
										Thread.sleep(2000);
										
										
										lbcs.setVisible(false);
										lbcs.setIcon(gcs);
										lbcs.setVisible(true);
										Thread.sleep(2000);*/
										
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									
										
										
									/*	Thread.sleep(4000);
																		
										lbcs.setVisible(false);
										lbcs.setIcon(bcs);
										lbcs.setVisible(true);
										Thread.sleep(2000);
										
										lbcsar.setVisible(false);
										lbcsar.setIcon(bcsar);
										lbcsar.setVisible(true);
										Thread.sleep(2000);
										
										lbdc.setVisible(false);
										lbdc.setIcon(bdc);
										lbdc.setVisible(true);
										Thread.sleep(2000);*/
										
										
							}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
							
				}
			}
		}
		
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==j3)
			{
				
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						Attackerdetails2 vm=new Attackerdetails2();
						vm.setSize(600,600);
						vm.setVisible(true);
					}
				});
				
				
				
			}
			if(e.getSource()==j1)
			{
				
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						CS2ViewUsersMemory vm=new CS2ViewUsersMemory();
						
						vm.setSize(600,600);
						vm.setVisible(true);
					}
				});
				
				
				
			}
			if(e.getSource()==j2)
			{
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						Cloud2Files csf=new Cloud2Files();
						csf.setSize(600,600);      
						csf.setVisible(true);
					}
				});
			}
			
			
			
			if(e.getSource()==m11)
			{
				//new ViewRemoteUsers2();
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new ViewRemoteUsers2();
					}
				});
			}
			
			
			
			
			if(e.getSource()==m4)
			{
				System.exit(0);
			}
			if(e.getSource()==m2)
			{
				//new blocked2();
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new blocked2();
					}
				});
			}
			if(e.getSource()==m3)
			{
				String uname = JOptionPane.showInputDialog(null,
						"Enter Owner name to be Grant..!!");
				if(uname.isEmpty())
				{
					
					JOptionPane.showMessageDialog(null, "Owner Name cannot be null ");
					
				}
				else
				{
					
				
				try {
					DBCon db = new DBCon();
					 Connection con = db.getConnection();
					Statement st = con.createStatement();
					String sql = "delete * from blocker where Owner= '" + uname+"' and cloudname='CS2'";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Owner Granted Successfully");

				} catch (Exception exx) {
					System.out.println(exx);
				}
				}
			}
			if(e.getSource()==m7)
			{
				String uname = JOptionPane.showInputDialog(null,
						"Enter username to be Unblock..!!");
				if(uname.isEmpty())
				{
					
					JOptionPane.showMessageDialog(null, "User Name cannot be null ");
					
				}
				else
				{
					
				
				try {
					DBCon db = new DBCon();
					 Connection con = db.getConnection();
					Statement st = con.createStatement();
					String sql = "delete * from attacker where Attacker_name = '" + uname+"' and cloudname='CS2'";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "User Unblocked Successfully");

				} catch (Exception exx) {
					System.out.println(exx);
				}
				}
			}
			
			if(e.getSource()==m1)
			{
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Register();
					}
				});
			}
		}
		
		public static void main(String[] args) {
			
			try {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new CloudServer2();
				}
			});
		}
}
