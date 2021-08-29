import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;



public class Connector extends JFrame implements ActionListener {

	
	Container c;
	JButton j1,j2;
	JMenuBar mb;
	JMenu m;
	JMenuItem m1,m2,m3,m4,m6,m5,m7,m66;
	
	
	
	Font f1 = new Font("Times new Roman",Font.BOLD,18);
	Font f2 = new Font("Times new Roman",Font.BOLD,14);
	
	ImageIcon da = new ImageIcon(this.getClass().getResource("do.jpg"));
	ImageIcon bcs1 = new ImageIcon(this.getClass().getResource("bcs1.png"));
	ImageIcon bcs2 = new ImageIcon(this.getClass().getResource("bcs2.png"));
	ImageIcon bcs3 = new ImageIcon(this.getClass().getResource("bcs3.png"));
	
	ImageIcon gcs1 = new ImageIcon(this.getClass().getResource("gcs1.png"));
	ImageIcon gcs2 = new ImageIcon(this.getClass().getResource("gcs2.png"));
	ImageIcon gcs3 = new ImageIcon(this.getClass().getResource("gcs3.png"));
	
	ImageIcon rcs1 = new ImageIcon(this.getClass().getResource("rcs1.png"));
	ImageIcon rcs2 = new ImageIcon(this.getClass().getResource("rcs2.png"));
	ImageIcon rcs3 = new ImageIcon(this.getClass().getResource("rcs3.png"));
	
	ImageIcon con = new ImageIcon(this.getClass().getResource("connector.jpg"));
	ImageIcon cloud = new ImageIcon(this.getClass().getResource("cloud.jpg"));
	ImageIcon analyser = new ImageIcon(this.getClass().getResource("analyser.jpg"));
	ImageIcon redcloud = new ImageIcon(this.getClass().getResource("redcloud.jpg"));
	ImageIcon block = new ImageIcon(this.getClass().getResource("blockar.png"));
	
	
	JLabel lda,lda1,lbcs1,lbcs2,lbcs3,lbcs11,lbcs12,lbcs13,ldoar1,ldoar2,lcon1,lcon2,lcl1,lcl2,lcl3,lcl11,lcl12,lcl13;
	JLabel l1,l2,l3,l4,l5,l11,l12,l13,l14,l15,lblock,lblock1,l6,l7;
	
	Connector()
	{
		setTitle("Connector::A Hybrid Cloud Approach for Secure Authorized Deduplication");
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		setSize(650,700);
		setVisible(true);
		
		
Border b11=BorderFactory.createLineBorder(Color.black,3);
	
		
		TitledBorder b22=new TitledBorder(b11);
		b22.setTitle("Checking Duplication");
		b22.setTitleColor(Color.blue);
		b22.setTitleFont(f2);
		JLabel bord =new JLabel();
		bord.setBorder(b22);
		bord.setBackground(Color.black);
		bord.setBounds(5,-3,600,310);
		c.add(bord);
		
		TitledBorder b33=new TitledBorder(b11);
		b33.setTitle("Uploading File");
		b33.setTitleColor(Color.blue);
		b33.setTitleFont(f2);
		JLabel bord2 =new JLabel();
		bord2.setBorder(b33);
		bord2.setBackground(Color.black);
		bord2.setBounds(5,330,600,300);
		c.add(bord2);
		
		
		
		lda=new JLabel();
		lda.setIcon(da);
		lda.setBounds(50, 25, 200, 200);
		c.add(lda);
		
		ldoar1=new JLabel();
		ldoar1.setIcon(bcs2);
		ldoar1.setBounds(150, 80, 150, 100);
		c.add(ldoar1);
		
		lcon1=new JLabel();
		lcon1.setIcon(con);
		lcon1.setBounds(250, 60, 150, 150);
		c.add(lcon1);
		
		lbcs1=new JLabel();
		lbcs1.setIcon(bcs1);
		lbcs1.setBounds(400, 60, 150, 50);
		c.add(lbcs1);
		
		lbcs2=new JLabel();
		lbcs2.setIcon(bcs2);
		lbcs2.setBounds(400, 107, 150, 50);
		c.add(lbcs2);
		
		lbcs3=new JLabel();
		lbcs3.setIcon(bcs3);
		lbcs3.setBounds(405, 150, 150, 50);
		c.add(lbcs3);
		
		lcl1=new JLabel();
		lcl1.setIcon(cloud);
		lcl1.setBounds(520, -30, 150, 150);
		c.add(lcl1);
		
		lcl2=new JLabel();
		lcl2.setIcon(cloud);
		lcl2.setBounds(520, 60, 150, 150);
		c.add(lcl2);
		
		lcl3=new JLabel();
		lcl3.setIcon(cloud);
		lcl3.setBounds(520, 150, 150, 150);
		c.add(lcl3);
		
		l1=new JLabel("Data  Owner");
		l1.setFont(f2);
		l1.setForeground(Color.BLUE);
		l1.setBounds(60, 90, 200, 200);
		c.add(l1);
		
		l2=new JLabel("Connector");
		l2.setFont(f2);
		l2.setForeground(Color.BLUE);
		l2.setBounds(290, 95, 200, 200);
		c.add(l2);
		
		l3=new JLabel("CS1");
		l3.setFont(f2);
		l3.setForeground(Color.BLUE);
		l3.setBounds(550, -10, 200, 200);
		c.add(l3);
		
		l4=new JLabel("CS2");
		l4.setFont(f2);
		l4.setForeground(Color.BLUE);
		l4.setBounds(550, 80, 200, 200);
		c.add(l4);
		
		l5=new JLabel("CS3");
		l5.setFont(f2);
		l5.setForeground(Color.BLUE);
		l5.setBounds(550, 170, 200, 200);
		c.add(l5);
		
		lblock=new JLabel();
		lblock.setIcon(block);
		lblock.setBounds(80, 120, 150, 150);
		c.add(lblock);
		
		l6=new JLabel("Duplicate File Found");
		l6.setFont(f2);
		l6.setForeground(Color.red);
		l6.setBounds(35, 150, 200, 200);
		c.add(l6);
		
		lda1=new JLabel();
		lda1.setIcon(da);
		lda1.setBounds(50, 365, 200, 200);
		c.add(lda1);
		
		ldoar2=new JLabel();
		ldoar2.setIcon(bcs2);
		ldoar2.setBounds(150, 420, 150, 100);
		c.add(ldoar2);
		
		lcon2=new JLabel();
		lcon2.setIcon(con);
		lcon2.setBounds(250, 400, 150, 150);
		c.add(lcon2);
		
		lbcs11=new JLabel();
		lbcs11.setIcon(bcs1);
		lbcs11.setBounds(400, 400, 150, 50);
		c.add(lbcs11);
		
		lbcs12=new JLabel();
		lbcs12.setIcon(bcs2);
		lbcs12.setBounds(400, 447, 150, 50);
		c.add(lbcs12);
		
		lbcs13=new JLabel();
		lbcs13.setIcon(bcs3);
		lbcs13.setBounds(405, 490, 150, 50);
		c.add(lbcs13);
		
		lcl11=new JLabel();
		lcl11.setIcon(cloud);
		lcl11.setBounds(520, 310, 150, 150);
		c.add(lcl11);
		
		lcl12=new JLabel();
		lcl12.setIcon(cloud);
		lcl12.setBounds(520, 400, 150, 150);
		c.add(lcl12);
		
		lcl13=new JLabel();
		lcl13.setIcon(cloud);
		lcl13.setBounds(520, 490, 150, 150);
		c.add(lcl13);
		
		l11=new JLabel("Data  Owner");
		l11.setFont(f2);
		l11.setForeground(Color.BLUE);
		l11.setBounds(60, 430, 200, 200);
		c.add(l11);
		
		l12=new JLabel("Connector");
		l12.setFont(f2);
		l12.setForeground(Color.BLUE);
		l12.setBounds(290, 435, 200, 200);
		c.add(l12);
		
		l13=new JLabel("CS1");
		l13.setFont(f2);
		l13.setForeground(Color.BLUE);
		l13.setBounds(550, 330, 200, 200);
		c.add(l13);
		
		l14=new JLabel("CS2");
		l14.setFont(f2);
		l14.setForeground(Color.BLUE);
		l14.setBounds(550, 420, 200, 200);
		c.add(l14);
		
		l15=new JLabel("CS3");
		l15.setFont(f2);
		l15.setForeground(Color.BLUE);
		l15.setBounds(550, 510, 200, 200);
		c.add(l15);
		
		lblock1=new JLabel();
		lblock1.setIcon(block);
		lblock1.setBounds(80, 460, 150, 150);
		c.add(lblock1);
		
		
		l7=new JLabel("Owner Uploaded Duplicate File");
		l7.setFont(f2);
		l7.setForeground(Color.red);
		l7.setBounds(35, 490, 200, 200);
		c.add(l7);
		
		lblock.setVisible(false);
		l6.setVisible(false);
		lblock1.setVisible(false);
		l7.setVisible(false);
		
		int[] ports = new int[]{501,502,503,102,103,104,3000,3001,3002,6789,6699,9005,10014,100,2014,402,442};
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
			if (this.port == 104) {
				try {

					ServerSocket server3 = new ServerSocket(104);
					Socket con2;
					while (true) {
						con2 = server3.accept();
						DataInputStream dis11 = new DataInputStream(
								con2.getInputStream());

						String request = dis11.readUTF();
						String filename = dis11.readUTF();
						String owner = dis11.readUTF();
						String hash = dis11.readUTF();
						
						
						System.out.println(request);
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						
						if (request.equals("VerifyFile")) {

							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							ldoar1.setVisible(false);
							ldoar1.setIcon(gcs2);
							ldoar1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lbcs3.setVisible(false);
							lbcs3.setIcon(gcs3);
							lbcs3.setVisible(true);
							Thread.sleep(1000);
							lcl3.setVisible(false);
							lcl3.setIcon(analyser);
							lcl3.setVisible(true);
							Thread.sleep(1000);
							lcl3.setVisible(false);
							lcl3.setIcon(analyser);
							lcl3.setVisible(true);
							Thread.sleep(1000);
							
							Statement stmt = con.createStatement();
							String sql = "select * from cloudfiles where Owner='"+owner+"' and filename='"+filename+"' and mackey='"+hash+"' and cloudname='CS3'";
							ResultSet rs = stmt.executeQuery(sql);
								if (rs.next() == true) {
									
									
									
									lcl3.setVisible(false);
									lcl3.setIcon(redcloud);
									lcl3.setVisible(true);
									Thread.sleep(1000);
									
									lbcs3.setVisible(false);
									lbcs3.setIcon(rcs3);
									lbcs3.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									
									lblock.setVisible(false);
									lblock.setIcon(block);
									lblock.setVisible(true);
									Thread.sleep(1000);
									
									l6.setVisible(false);
									l6.setVisible(true);
									Thread.sleep(3000);
									String message = "Duplicate Filename Found in Cloud";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
									refresh();
								} 
								else if (rs.next() == false) {
									
									
									lcl3.setVisible(false);
									lcl3.setIcon(cloud);
									lcl3.setVisible(true);
									Thread.sleep(1000);
									
									lcl3.setVisible(false);
									lcl3.setIcon(cloud);
									lcl3.setVisible(true);
									Thread.sleep(2000);
									String message = "File not Found in Cloud";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
									refresh();
								}
							}

							
						}
					}
				

				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (this.port == 103) {
				try {

					ServerSocket server3 = new ServerSocket(103);
					Socket con2;
					while (true) {
						con2 = server3.accept();
						DataInputStream dis11 = new DataInputStream(
								con2.getInputStream());

						String request = dis11.readUTF();
						String filename = dis11.readUTF();
						String owner = dis11.readUTF();
						String hash = dis11.readUTF();
						
						
						System.out.println(request);
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						
						if (request.equals("VerifyFile")) {

							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							ldoar1.setVisible(false);
							ldoar1.setIcon(gcs2);
							ldoar1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lbcs2.setVisible(false);
							lbcs2.setIcon(gcs2);
							lbcs2.setVisible(true);
							Thread.sleep(1000);
							lcl2.setVisible(false);
							lcl2.setIcon(analyser);
							lcl2.setVisible(true);
							Thread.sleep(1000);
							lcl2.setVisible(false);
							lcl2.setIcon(analyser);
							lcl2.setVisible(true);
							Thread.sleep(1000);
							
							Statement stmt = con.createStatement();
							String sql = "select * from cloudfiles where Owner='"+owner+"' and filename='"+filename+"' and mackey='"+hash+"' and cloudname='CS2'";
							ResultSet rs = stmt.executeQuery(sql);
								if (rs.next() == true) {
									
									
									
									lcl2.setVisible(false);
									lcl2.setIcon(redcloud);
									lcl2.setVisible(true);
									Thread.sleep(1000);
									
									lbcs2.setVisible(false);
									lbcs2.setIcon(rcs2);
									lbcs2.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									
									lblock.setVisible(false);
									lblock.setIcon(block);
									lblock.setVisible(true);
									Thread.sleep(1000);
									
									l6.setVisible(false);
									l6.setVisible(true);
									Thread.sleep(3000);
									String message = "Duplicate Filename Found in Cloud";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
									refresh();
								} 
								else if (rs.next() == false) {
									
									
									lcl2.setVisible(false);
									lcl2.setIcon(cloud);
									lcl2.setVisible(true);
									Thread.sleep(1000);
									
									lcl2.setVisible(false);
									lcl2.setIcon(cloud);
									lcl2.setVisible(true);
									Thread.sleep(3000);
									String message = "File not Found in Cloud";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
									refresh();
								}
							}

							
						}
					}
				

				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (this.port == 102) {
				try {

					ServerSocket server3 = new ServerSocket(102);
					Socket con2;
					while (true) {
						con2 = server3.accept();
						DataInputStream dis11 = new DataInputStream(
								con2.getInputStream());

						String request = dis11.readUTF();
						String filename = dis11.readUTF();
						String owner = dis11.readUTF();
						String hash = dis11.readUTF();
						
						
						System.out.println(request);
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						
						if (request.equals("VerifyFile")) {

							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							ldoar1.setVisible(false);
							ldoar1.setIcon(gcs2);
							ldoar1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lbcs1.setVisible(false);
							lbcs1.setIcon(gcs1);
							lbcs1.setVisible(true);
							Thread.sleep(1000);
							lcl1.setVisible(false);
							lcl1.setIcon(analyser);
							lcl1.setVisible(true);
							Thread.sleep(1000);
							lcl1.setVisible(false);
							lcl1.setIcon(analyser);
							lcl1.setVisible(true);
							Thread.sleep(1000);
							
							Statement stmt = con.createStatement();
							String sql = "select * from cloudfiles where Owner='"+owner+"' and filename='"+filename+"' and mackey='"+hash+"' and cloudname='CS1'";
							ResultSet rs = stmt.executeQuery(sql);
								if (rs.next() == true) {
									
									
									
									lcl1.setVisible(false);
									lcl1.setIcon(redcloud);
									lcl1.setVisible(true);
									Thread.sleep(1000);
									
									lbcs1.setVisible(false);
									lbcs1.setIcon(rcs1);
									lbcs1.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									
									lblock.setVisible(false);
									lblock.setIcon(block);
									lblock.setVisible(true);
									Thread.sleep(1000);
									
									l6.setVisible(false);
									l6.setVisible(true);
									Thread.sleep(3000);
									String message = "Duplicate Filename Found in Cloud";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
									refresh();
								} 
								else if (rs.next() == false) {
									
									
									lcl1.setVisible(false);
									lcl1.setIcon(cloud);
									lcl1.setVisible(true);
									Thread.sleep(1000);
									
									lcl1.setVisible(false);
									lcl1.setIcon(cloud);
									lcl1.setVisible(true);
									Thread.sleep(1000);
									String message = "File not Found in Cloud";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
									refresh();
								}
							}

							
						}
					}
				

				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(this.port==501)
			{
				try
				{
					ServerSocket sc = new ServerSocket(501);
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
						
						
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						
						Statement stmt2 = con.createStatement();
						String sql2 = "select * from blocker where Owner='"+owner+"' and cloudname='"+cloudname+"'  ";
						ResultSet rs2 = stmt2.executeQuery(sql2);
						if(rs2.next()==true)
						{
							DataOutputStream dout = new DataOutputStream(s.getOutputStream());
							dout.writeUTF("block");
							//break;
						}	
						else if(rs2.next()==false)
						{
						
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							ldoar2.setVisible(false);
							ldoar2.setIcon(gcs2);
							ldoar2.setVisible(true);
							Thread.sleep(1000);
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							lbcs11.setVisible(false);
							lbcs11.setIcon(gcs1);
							lbcs11.setVisible(true);
							Thread.sleep(1000);
							lcl11.setVisible(false);
							lcl11.setIcon(analyser);
							lcl11.setVisible(true);
							Thread.sleep(1000);
							lcl11.setVisible(false);
							lcl11.setIcon(analyser);
							lcl11.setVisible(true);
							Thread.sleep(1000);
							
							
						Statement stmt = con.createStatement();
						String sql = "select * from cloudfiles where Owner='"+owner+"' and filename='"+filename+"' and mackey='"+hash+"' and cloudname='"+cloudname+"' ";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()==true)
						{	
							lcl11.setVisible(false);
							lcl11.setIcon(redcloud);
							lcl11.setVisible(true);
							Thread.sleep(1000);
							
							lbcs11.setVisible(false);
							lbcs11.setIcon(rcs1);
							lbcs11.setVisible(true);
							Thread.sleep(1000);
							
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							
							ldoar2.setVisible(false);
							ldoar2.setIcon(rcs2);
							ldoar2.setVisible(true);
							Thread.sleep(1000);
							
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							
							lblock1.setVisible(false);
							lblock1.setIcon(block);
							lblock1.setVisible(true);
							Thread.sleep(1000);
							
							l7.setVisible(false);
							l7.setVisible(true);
							Thread.sleep(1000);
							
							Statement stmt1 = con.createStatement();
							String sql1 = "insert into blocker values('"+owner+"','"+filename+"','"+hash+"','"+cloudname+"')";
							stmt1.executeUpdate(sql1);
							System.out.println("in failure");
							DataOutputStream dout = new DataOutputStream(s.getOutputStream());
							dout.writeUTF("failure");
							
							Thread.sleep(3000);
							refresh();
							//break;
						}
						else if(rs.next()==false)
						{
						
							lcl11.setVisible(false);
							lcl11.setIcon(analyser);
							lcl11.setVisible(true);
							Thread.sleep(1000);
							
							 Socket sc1 = new Socket("localhost",401);
							 DataOutputStream dout = new DataOutputStream(sc1.getOutputStream());
							 
							 dout.writeUTF(content);
							 dout.writeUTF(filename);
							 dout.writeUTF(owner);
							 dout.writeUTF(sk);
							 dout.writeUTF(hash);
							 dout.writeUTF(cloudname);
						
							 DataInputStream din1 = new DataInputStream(sc1.getInputStream());
							 String msg = din1.readUTF();
							 if(msg.equalsIgnoreCase("success"))
							 {
						
						DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
						dout1.writeUTF("success");
							 
						lcl11.setVisible(false);
						lcl11.setIcon(cloud);
						lcl11.setVisible(true);
						Thread.sleep(1000);
						
						lcl11.setVisible(false);
						lcl11.setIcon(cloud);
						lcl11.setVisible(true);
						Thread.sleep(3000);
						refresh();
							 }
						}
					}
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(this.port==502)
			{
				try
				{
					ServerSocket sc = new ServerSocket(502);
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
						
						
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						
						Statement stmt2 = con.createStatement();
						String sql2 = "select * from blocker where Owner='"+owner+"' and cloudname='"+cloudname+"'  ";
						ResultSet rs2 = stmt2.executeQuery(sql2);
						if(rs2.next()==true)
						{
							DataOutputStream dout = new DataOutputStream(s.getOutputStream());
							dout.writeUTF("block");
							
						}	
						else if(rs2.next()==false)
						{
						
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							ldoar2.setVisible(false);
							ldoar2.setIcon(gcs2);
							ldoar2.setVisible(true);
							Thread.sleep(1000);
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							lbcs12.setVisible(false);
							lbcs12.setIcon(gcs2);
							lbcs12.setVisible(true);
							Thread.sleep(1000);
							lcl12.setVisible(false);
							lcl12.setIcon(analyser);
							lcl12.setVisible(true);
							Thread.sleep(1000);
							lcl12.setVisible(false);
							lcl12.setIcon(analyser);
							lcl12.setVisible(true);
							Thread.sleep(1000);
							
							
						Statement stmt = con.createStatement();
						String sql = "select * from cloudfiles where Owner='"+owner+"' and filename='"+filename+"' and mackey='"+hash+"' and cloudname='"+cloudname+"' ";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()==true)
						{	
							lcl12.setVisible(false);
							lcl12.setIcon(redcloud);
							lcl12.setVisible(true);
							Thread.sleep(1000);
							
							lbcs12.setVisible(false);
							lbcs12.setIcon(rcs2);
							lbcs12.setVisible(true);
							Thread.sleep(1000);
							
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							
							ldoar2.setVisible(false);
							ldoar2.setIcon(rcs2);
							ldoar2.setVisible(true);
							Thread.sleep(1000);
							
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							
							lblock1.setVisible(false);
							lblock1.setIcon(block);
							lblock1.setVisible(true);
							Thread.sleep(1000);
							
							l7.setVisible(false);
							l7.setVisible(true);
							Thread.sleep(1000);
							
							Statement stmt1 = con.createStatement();
							String sql1 = "insert into blocker values('"+owner+"','"+filename+"','"+hash+"','"+cloudname+"')";
							stmt1.executeUpdate(sql1);
							System.out.println("in failure");
							DataOutputStream dout = new DataOutputStream(s.getOutputStream());
							dout.writeUTF("failure");
							
							Thread.sleep(3000);
							refresh();
						}
						else if(rs.next()==false)
						{
						
							lcl12.setVisible(false);
							lcl12.setIcon(analyser);
							lcl12.setVisible(true);
							Thread.sleep(1000);
							
							 Socket sc1 = new Socket("localhost",402);
							 DataOutputStream dout = new DataOutputStream(sc1.getOutputStream());
							 
							 dout.writeUTF(content);
							 dout.writeUTF(filename);
							 dout.writeUTF(owner);
							 dout.writeUTF(sk);
							 dout.writeUTF(hash);
							 dout.writeUTF(cloudname);
						
							 DataInputStream din1 = new DataInputStream(sc1.getInputStream());
							 String msg = din1.readUTF();
							 if(msg.equalsIgnoreCase("success"))
							 {
						
						DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
						dout1.writeUTF("success");
							 
						lcl12.setVisible(false);
						lcl12.setIcon(cloud);
						lcl12.setVisible(true);
						Thread.sleep(1000);
						
						lcl12.setVisible(false);
						lcl12.setIcon(cloud);
						lcl12.setVisible(true);
						Thread.sleep(3000);
						refresh();
							 }
						}
					}
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(this.port==503)
			{
				try
				{
					ServerSocket sc = new ServerSocket(503);
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
						
						
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						
						Statement stmt2 = con.createStatement();
						String sql2 = "select * from blocker where Owner='"+owner+"' and cloudname='"+cloudname+"'  ";
						ResultSet rs2 = stmt2.executeQuery(sql2);
						if(rs2.next()==true)
						{
							DataOutputStream dout = new DataOutputStream(s.getOutputStream());
							dout.writeUTF("block");
							
						}	
						else if(rs2.next()==false)
						{
						
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							ldoar2.setVisible(false);
							ldoar2.setIcon(gcs2);
							ldoar2.setVisible(true);
							Thread.sleep(1000);
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							lbcs13.setVisible(false);
							lbcs13.setIcon(gcs3);
							lbcs13.setVisible(true);
							Thread.sleep(1000);
							lcl13.setVisible(false);
							lcl13.setIcon(analyser);
							lcl13.setVisible(true);
							Thread.sleep(1000);
							lcl13.setVisible(false);
							lcl13.setIcon(analyser);
							lcl13.setVisible(true);
							Thread.sleep(1000);
							
							
						Statement stmt = con.createStatement();
						String sql = "select * from cloudfiles where Owner='"+owner+"' and filename='"+filename+"' and mackey='"+hash+"' and cloudname='"+cloudname+"' ";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()==true)
						{	
							lcl13.setVisible(false);
							lcl13.setIcon(redcloud);
							lcl13.setVisible(true);
							Thread.sleep(1000);
							
							lbcs13.setVisible(false);
							lbcs13.setIcon(rcs3);
							lbcs13.setVisible(true);
							Thread.sleep(1000);
							
							lcon2.setVisible(false);
							Thread.sleep(1000);
							lcon2.setVisible(true);
							Thread.sleep(1000);
							
							ldoar2.setVisible(false);
							ldoar2.setIcon(rcs2);
							ldoar2.setVisible(true);
							Thread.sleep(1000);
							
							lda1.setVisible(false);
							Thread.sleep(1000);
							lda1.setVisible(true);
							Thread.sleep(1000);
							
							lblock1.setVisible(false);
							lblock1.setIcon(block);
							lblock1.setVisible(true);
							Thread.sleep(1000);
							
							l7.setVisible(false);
							l7.setVisible(true);
							Thread.sleep(1000);
							
							Statement stmt1 = con.createStatement();
							String sql1 = "insert into blocker values('"+owner+"','"+filename+"','"+hash+"','"+cloudname+"')";
							stmt1.executeUpdate(sql1);
							System.out.println("in failure");
							DataOutputStream dout = new DataOutputStream(s.getOutputStream());
							dout.writeUTF("failure");
							
							Thread.sleep(3000);
							refresh();
						}
						else if(rs.next()==false)
						{
						
							lcl13.setVisible(false);
							lcl13.setIcon(analyser);
							lcl13.setVisible(true);
							Thread.sleep(1000);
							
							 Socket sc1 = new Socket("localhost",403);
							 DataOutputStream dout = new DataOutputStream(sc1.getOutputStream());
							 
							 dout.writeUTF(content);
							 dout.writeUTF(filename);
							 dout.writeUTF(owner);
							 dout.writeUTF(sk);
							 dout.writeUTF(hash);
							 dout.writeUTF(cloudname);
						
							 DataInputStream din1 = new DataInputStream(sc1.getInputStream());
							 String msg = din1.readUTF();
							 if(msg.equalsIgnoreCase("success"))
							 {
						
						DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
						dout1.writeUTF("success");
							 
						lcl13.setVisible(false);
						lcl13.setIcon(cloud);
						lcl13.setVisible(true);
						Thread.sleep(1000);
						
						lcl13.setVisible(false);
						lcl13.setIcon(cloud);
						lcl13.setVisible(true);
						Thread.sleep(3000);
						refresh();
							 }
						}
					}
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void refresh()
	{
		
		try
		{
			
			lcl11.setVisible(false);
			lcl11.setIcon(cloud);
			lcl11.setVisible(true);
			
			lcl12.setVisible(false);
			lcl12.setIcon(cloud);
			lcl12.setVisible(true);
			
			lcl13.setVisible(false);
			lcl13.setIcon(cloud);
			lcl13.setVisible(true);
			
			lbcs11.setVisible(false);
			lbcs11.setIcon(bcs1);
			lbcs11.setVisible(true);
			
			lbcs12.setVisible(false);
			lbcs12.setIcon(bcs2);
			lbcs12.setVisible(true);
			
			lbcs13.setVisible(false);
			lbcs13.setIcon(bcs3);
			lbcs13.setVisible(true);
			
			lcon2.setVisible(false);
			lcon2.setIcon(con);
			lcon2.setVisible(true);
			
			ldoar2.setVisible(false);
			ldoar2.setIcon(bcs2);
			ldoar2.setVisible(true);
			
			lda1.setVisible(false);
			lda1.setIcon(da);
			lda1.setVisible(true);
			
			lblock1.setVisible(false);
			l7.setVisible(false);
			
			lcl1.setVisible(false);
			lcl1.setIcon(cloud);
			lcl1.setVisible(true);
			
			lcl2.setVisible(false);
			lcl2.setIcon(cloud);
			lcl2.setVisible(true);
			
			lcl3.setVisible(false);
			lcl3.setIcon(cloud);
			lcl3.setVisible(true);
			
			lbcs1.setVisible(false);
			lbcs1.setIcon(bcs1);
			lbcs1.setVisible(true);
			
			lbcs2.setVisible(false);
			lbcs2.setIcon(bcs2);
			lbcs2.setVisible(true);
			
			lbcs3.setVisible(false);
			lbcs3.setIcon(bcs3);
			lbcs3.setVisible(true);
			
			lcon1.setVisible(false);
			lcon1.setIcon(con);
			lcon1.setVisible(true);
			
			ldoar1.setVisible(false);
			ldoar1.setIcon(bcs2);
			ldoar1.setVisible(true);
			
			lda.setVisible(false);
			lda.setIcon(da);
			lda.setVisible(true);
			
			lblock.setVisible(false);
			l6.setVisible(false);

			
			
		}
	
	catch(Exception e1)
	{
		e1.printStackTrace();
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
			new Connector();
		}
	});
}
}