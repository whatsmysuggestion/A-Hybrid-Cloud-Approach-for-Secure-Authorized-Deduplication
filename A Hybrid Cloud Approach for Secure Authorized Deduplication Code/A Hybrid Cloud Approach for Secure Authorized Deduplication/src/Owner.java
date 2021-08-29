import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Owner implements ActionListener {
	String str;
	Socket client;
	String filename;
	String content;
	String us;
	byte[] b;
	String hash;
	public Font f = new Font("Times new roman", Font.BOLD, 25);
	public Font f1 = new Font("Times new roman", Font.BOLD, 16);
	public Font f2 = new Font("Times new roman", Font.BOLD, 16);
	public Font f3 = new Font("Times new roman", Font.BOLD, 14);
	public Font f4 = new Font("Times new roman", Font.BOLD, 15);
	public JLabel T0 = new JLabel("User");

	public JLabel T11 = new JLabel("Signature");

	public JLabel T12 = new JLabel("                    ");

	public JTextField head = new JTextField();

	public JButton upload = new JButton("UPLOAD");
	public JButton verify = new JButton("CHECK DUPLICATION");

	public JTextArea tf = new JTextArea();

	public JScrollPane pane = new JScrollPane();

	public JButton browse = new JButton("BROWSE");

	JLabel imageLabel = new JLabel();
	JLabel image = new JLabel();
	JLabel imageLabel1 = new JLabel();
	JLabel image1 = new JLabel();

	JLabel imageLabel2 = new JLabel();
	JLabel image12 = new JLabel();

	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();

	public JFrame jf;
	public Container c;
	DataOutputStream out;

	Key secKey;
	final static String strPassword = "password12345678";
	static SecretKeySpec key = new SecretKeySpec(strPassword.getBytes(), "AES");

	Cipher encoder = null;
	Key prKey;
	public static Key pubKey;

	String priKey, fname, publKey, path1, path2, path3, path4, f1Sign, f2Sign,
			f3Sign;
	JLabel image11,image122;
	ImageIcon im,im1;

	JButton sign = new JButton("FIND SIGN");
	JButton update = new JButton("UPDATE");

	MenuBar mbr = new MenuBar();
	Menu file = new Menu("FILE");
	MenuItem item1 = new MenuItem("Add user");
	MenuItem item2 = new MenuItem("Revoke user");
	MenuItem item3 = new MenuItem("Attacker Details");
	MenuItem item4 = new MenuItem("Exit");

	private static Connection con;

	String keyword = "2d2b3bef2bfa3a8cfdb0277b25ed94d79ca0cb99";

	Owner(String username) {
		this.us=username;
		jf = new JFrame();
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(660, 610);
		jf.setTitle(us+"->A Hybrid Cloud Approach for Secure Authorized Deduplication");

		jf.setMenuBar(mbr);
		mbr.add(file);
		file.add(item1);
		//file.add(item2);
		//file.add(item3);
		file.add(item4);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("DataOwnerTitle.png"));
		 JLabel title = new JLabel();
		 title.setIcon(banner);
		 title.setBounds(0, -10, 650,110);
		 
		 
			
			ImageIcon banner1 = new ImageIcon(this.getClass().getResource("DataOwner.png"));
			JLabel title1 = new JLabel();
			title1.setIcon(banner1);
			title1.setBounds(0, 120, 350,350);
		 
		

		
		head.setBounds(320, 100, 300, 25);
		head.setFont(f2);
		head.setForeground(Color.black);
		c.add(head);
		
		
		T11.setBounds(250, 100, 200, 25);
		T12.setBounds(230, 29, 1000, 50);
		//T12.setForeground(Color.MAGENTA);
		//T11.setForeground(Color.MAGENTA);
		T11.setFont(f2);
		
		T12.setFont(f);
		c.add(T11);
		//im = new ImageIcon(this.getClass().getResource("DataOwner.png"));

		Border b11=BorderFactory.createLineBorder(Color.black,2);
		TitledBorder t1=new TitledBorder(b11);
		//t1.setTitle("Adding Query");
		t1.setTitleColor(Color.RED);
		t1.setTitleFont(f1);
		
		JLabel l1=new JLabel();
		l1.setBorder(t1);
		l1.setBounds(5,90,630,350);
		c.add(l1);
		
		
		TitledBorder t2=new TitledBorder(b11);
		//t2.setTitle("Query Retrival Using RASP");
		t2.setTitleColor(Color.RED);
		t2.setTitleFont(f1);
		
		JLabel l2=new JLabel();
		l2.setBorder(t2);
		l2.setBounds(5,450,630,90);
		c.add(l2);
		image11 = new JLabel();
		image11.setIcon(im);
		image11.setBounds(0, -20, 1200, 110);
		
		//im1 = new ImageIcon(this.getClass().getResource("douser.png"));

		image122 = new JLabel();
		image122.setIcon(im1);
		image122.setBounds(70, -50, 500, 500);

		c.setBackground(Color.white);
		T0.setBounds(440, 60, 350, 45);
		T0.setFont(f);

		T0.setForeground(Color.RED);

		
		
		browse.setBounds(20, 480, 95, 30);
		browse.setFont(f3);
		//browse.setBackground(Color.black);
		//browse.setForeground(Color.WHITE);
		
		sign.setBounds(150, 480, 110, 30);
		sign.setFont(f3);

		jp.setBounds(40, 80, 800, 540);
		jp.setBackground(Color.yellow);

		jp1.setBounds(35, 75, 765, 550);
     
		upload.setBounds(290, 480, 100, 30);
		upload.setFont(f3);
		//upload.setBackground(Color.black);
		//upload.setForeground(Color.WHITE);
		
		verify.setBounds(430, 480, 180, 30);
		verify.setFont(f3);

		update.setBounds(360, 550, 130, 30);
		update.setFont(f3);
		//update.setBackground(Color.black);
		//update.setForeground(Color.WHITE);

		
		//verify.setBackground(Color.black);
		//verify.setForeground(Color.WHITE);

		
		//delete.setBackground(Color.black);
		//delete.setForeground(Color.WHITE);

		pane.setBounds(320, 130, 300, 300);

		tf.setColumns(100);
		tf.setForeground(Color.black);
		tf.setFont(f1);
		tf.setRows(200);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);

		upload.addActionListener(this);

		browse.setMnemonic(KeyEvent.VK_B);
		upload.setMnemonic(KeyEvent.VK_S);
		jf.setVisible(true);

		c.add(upload);
		c.add(sign);
		//c.add(update);
		c.add(pane, BorderLayout.CENTER);
		c.add(browse);
		c.add(verify);
		c.add(imageLabel1);
		//c.add(jp);
		//c.add(jp1);
		//c.add(image11);
	    c.add(title);
	    c.add(title1);

		verify.addActionListener(this);
		browse.addActionListener(this);
		sign.addActionListener(this);
		update.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});

		/*int[] ports = new int[] {102,10012};
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();
		}*/
	}

/*	class PortListener implements Runnable {

		int port;
		ServerSocket server1 = null;
		Socket so1 = null;
		DataInputStream ds1 = null;

		public PortListener(int port) {
			this.port = port;
		}

		public void run() {

			if (this.port == 10012) {
				try {

					DBCon db = new DBCon();
					Connection con = db.getConnection();

					ServerSocket server3 = new ServerSocket(10012);
					Socket con2;
					while (true) {
						con2 = server3.accept();
						DataInputStream dis11 = new DataInputStream(
								con2.getInputStream());

						String fname = dis11.readUTF();
						String owner = dis11.readUTF();

						String sql = "select * from OwnerFiles where owner='"+owner+"' and FName='" + fname + "'";
						Statement stmt = con.createStatement();

						System.out.println(fname);
						System.out.println(owner);

						

							ResultSet rs = stmt.executeQuery(sql);
							while (rs.next() == true) {
								DataOutputStream out;

								try {
									String h1 = rs.getString(3);
									System.out.println(h1);

									out = new DataOutputStream(
											con2.getOutputStream());
									out.writeUTF(h1);
									out.writeUTF(fname);
									out.writeUTF(owner);

								} catch (Exception e) {
									e.printStackTrace();

								}
							}
						} 
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if (this.port == 500)

			{

				try {
					System.out.println("here ssssssssss");
					server1 = new ServerSocket(500);
					so1 = server1.accept();
					ds1 = new DataInputStream(so1.getInputStream());
					String message = ds1.readUTF();
					System.out.println(message);
					JOptionPane.showMessageDialog(null, message);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (this.port == 501) {
				ServerSocket server2 = null;
				Socket so2 = null;
				DataInputStream ds2 = null;

				try {

					System.out.println("here ssssssssss");
					server2 = new ServerSocket(501);
					so2 = server2.accept();
					ds2 = new DataInputStream(so2.getInputStream());
					String message = ds2.readUTF();
					System.out.println(message);
					JOptionPane.showMessageDialog(null, message);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (this.port == 201) {
				ServerSocket server2 = null;
				Socket so2 = null;
				DataInputStream ds2 = null;

				try {
					System.out.println("here ssssssssss");
					server2 = new ServerSocket(201);
					so2 = server2.accept();
					ds2 = new DataInputStream(so2.getInputStream());
					String message = ds2.readUTF();
					System.out.println(message);
					JOptionPane.showMessageDialog(null, message);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}*/

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {

		String strLine = null;
		
		
			
			
			
		
		if (e.getSource() == item1) {
			//new UserRegistration();
			try {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new UserRegistration();
				}
			});
		}
		

		
		if (e.getSource() == item4) {System.exit(0);}
		

		

		
			
		if (e.getSource() == browse) {

			

			JFileChooser chooser = new JFileChooser();

			try {

				File f = new File(new File("filename.txt").getCanonicalPath());

				chooser.setSelectedFile(f);
			} catch (IOException e1) {
			}

			chooser.showOpenDialog(browse);
			int retval = chooser.showOpenDialog(browse);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File field = chooser.getSelectedFile();
				 path1=field.getAbsolutePath();
				 filename = field.getName();
			}
			File curFile = chooser.getSelectedFile();

			try {
				
				FileInputStream fstream = new FileInputStream(curFile);
				b = new byte[fstream.available()];
				fstream.read(b);
				 content = new String(b);
				tf.setText(content);
				System.out.println(content);
				AES a2= new AES();
				 String path = "Owner/"+us;
					new File("Owner/"+us).mkdir();
					PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
					p.print(new String(a2.encrypt(content,keyword)));
					
					
					MessageDigest md = MessageDigest.getInstance("SHA1");
					FileInputStream fstream1 = new FileInputStream("Owner\\"+us+"\\"+filename);
					DigestInputStream dis1 = new DigestInputStream(fstream1, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
					BigInteger bi1 = new BigInteger(md.digest());
					hash = bi1.toString(16);
					
					System.out.println(hash);
					
					
				

			} catch (Exception e1) {
				System.err.println("Error: " + e1.getMessage());
			}

		}
		if (e.getSource() == sign) {
	
				head.setText(hash);
			
		}
		if (e.getSource() == verify) {

		
			if(tf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please Browse the File to Check");
			}
			if(head.getText().isEmpty())
					{
				JOptionPane.showMessageDialog(null, "Please Generate the Sign to Check");
					}
			else{
			/*	String fname = JOptionPane.showInputDialog(jf,
					"Please Enter the File Name");*/
			String[] csname = { "Select Cloud Server", "CS1", "CS2" , "CS3"};
			
			String cloudname = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null,  csname,  csname[0]);
			String ip = JOptionPane.showInputDialog(jf,
					"Please Enter the IP Address Of Cloud Server");
			
			if(cloudname.equalsIgnoreCase("CS1"))
			 {
			try {

				Socket soc1 = new Socket(ip, 102);
				DataOutputStream dos2 = new DataOutputStream(
						soc1.getOutputStream());
				dos2.writeUTF("VerifyFile");
				dos2.writeUTF(filename);
				dos2.writeUTF(us);
				dos2.writeUTF(hash);

				DataInputStream din = new DataInputStream(soc1.getInputStream());
				String message = din.readUTF();
				System.out.println(message);

				JOptionPane.showMessageDialog(null, message);
				int i = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
				if(i==0)
				{
					String[] csname2 = { "Select Cloud Server","CS2" , "CS3"};
					
					String cloudname2 = (String) JOptionPane.showInputDialog(null,
							"Select Cloud Server", "CloudName",
							JOptionPane.QUESTION_MESSAGE, null,  csname2,  csname2[0]);
					String ip2 = JOptionPane.showInputDialog(jf,
							"Please Enter the IP Address Of Cloud Server");
					
					if(cloudname2.equalsIgnoreCase("CS2"))
					 {
					try {

						Socket soc2 = new Socket(ip2, 103);
						DataOutputStream dos3 = new DataOutputStream(soc2.getOutputStream());
						dos3.writeUTF("VerifyFile");
						dos3.writeUTF(filename);
						dos3.writeUTF(us);
						dos3.writeUTF(hash);

						DataInputStream din3 = new DataInputStream(soc2.getInputStream());
						String message2 = din3.readUTF();
						System.out.println(message2);

						JOptionPane.showMessageDialog(null, message2);
						int i1 = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
						if(i1==0)
						{
							String[] csname3 = { "Select Cloud Server", "CS3"};
							
							String cloudname3 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
							String ip3 = JOptionPane.showInputDialog(jf,
									"Please Enter the IP Address Of Cloud Server");
							
							
						
							if(cloudname3.equalsIgnoreCase("CS3"))
							 {
							try {

								Socket soc3 = new Socket(ip3, 104);
								DataOutputStream dos4 = new DataOutputStream(
										soc3.getOutputStream());
								dos4.writeUTF("VerifyFile");
								dos4.writeUTF(filename);
								dos4.writeUTF(us);
								dos4.writeUTF(hash);

								DataInputStream din4 = new DataInputStream(soc3.getInputStream());
								String message4 = din4.readUTF();
								System.out.println(message4);

								JOptionPane.showMessageDialog(null, message4);

							} catch (Exception e2) {

								e2.printStackTrace();
							}
						}
							
						}
						else if(i1==1)
						{
							
						}

						

					} catch (Exception e2) {

						e2.printStackTrace();
					}
				}
					
				
					if(cloudname2.equalsIgnoreCase("CS3"))
					 {
					try {

						Socket soc2 = new Socket(ip2, 104);
						DataOutputStream dos3 = new DataOutputStream(
								soc2.getOutputStream());
						dos3.writeUTF("VerifyFile");
						dos3.writeUTF(filename);
						dos3.writeUTF(us);
						dos3.writeUTF(hash);

						DataInputStream din3 = new DataInputStream(soc2.getInputStream());
						String message3 = din3.readUTF();
						System.out.println(message3);

						JOptionPane.showMessageDialog(null, message3);

					} catch (Exception e2) {

						e2.printStackTrace();
					}
				}
					
				}
				else if(i==1)
				{
					
				}

			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
			//cs1 completed
			if(cloudname.equalsIgnoreCase("CS2"))
			 {
			try {

				Socket soc1 = new Socket(ip, 103);
				DataOutputStream dos2 = new DataOutputStream(
						soc1.getOutputStream());
				dos2.writeUTF("VerifyFile");
				dos2.writeUTF(filename);
				dos2.writeUTF(us);
				dos2.writeUTF(hash);

				DataInputStream din = new DataInputStream(soc1.getInputStream());
				String message = din.readUTF();
				System.out.println(message);

				JOptionPane.showMessageDialog(null, message);
				
				int i = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
				if(i==0)
				{
					String[] csname2 = { "Select Cloud Server","CS1" , "CS3"};
					
					String cloudname2 = (String) JOptionPane.showInputDialog(null,
							"Select Cloud Server", "CloudName",
							JOptionPane.QUESTION_MESSAGE, null,  csname2,  csname2[0]);
					String ip2 = JOptionPane.showInputDialog(jf,
							"Please Enter the IP Address Of Cloud Server");
					
					if(cloudname2.equalsIgnoreCase("CS1"))
					 {
					try {

						Socket soc2 = new Socket(ip2, 102);
						DataOutputStream dos3 = new DataOutputStream(soc2.getOutputStream());
						dos3.writeUTF("VerifyFile");
						dos3.writeUTF(filename);
						dos3.writeUTF(us);
						dos3.writeUTF(hash);

						DataInputStream din3 = new DataInputStream(soc2.getInputStream());
						String message2 = din3.readUTF();
						System.out.println(message2);

						JOptionPane.showMessageDialog(null, message2);
						int i1 = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
						if(i1==0)
						{
							String[] csname3 = { "Select Cloud Server", "CS3"};
							
							String cloudname3 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
							String ip3 = JOptionPane.showInputDialog(jf,
									"Please Enter the IP Address Of Cloud Server");
							
							
						
							if(cloudname3.equalsIgnoreCase("CS3"))
							 {
							try {

								Socket soc3 = new Socket(ip3, 104);
								DataOutputStream dos4 = new DataOutputStream(
										soc3.getOutputStream());
								dos4.writeUTF("VerifyFile");
								dos4.writeUTF(filename);
								dos4.writeUTF(us);
								dos4.writeUTF(hash);

								DataInputStream din4 = new DataInputStream(soc3.getInputStream());
								String message4 = din4.readUTF();
								System.out.println(message4);

								JOptionPane.showMessageDialog(null, message4);

							} catch (Exception e2) {

								e2.printStackTrace();
							}
						}
							
						}
						else if(i1==1)
						{
							
						}

						

					} catch (Exception e2) {

						e2.printStackTrace();
					}
				}
					
				
					if(cloudname2.equalsIgnoreCase("CS3"))
					 {
					try {

						Socket soc2 = new Socket(ip2, 104);
						DataOutputStream dos3 = new DataOutputStream(
								soc2.getOutputStream());
						dos3.writeUTF("VerifyFile");
						dos3.writeUTF(filename);
						dos3.writeUTF(us);
						dos3.writeUTF(hash);

						DataInputStream din3 = new DataInputStream(soc2.getInputStream());
						String message3 = din3.readUTF();
						System.out.println(message3);

						JOptionPane.showMessageDialog(null, message3);
						int i1 = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
						if(i1==0)
						{
							String[] csname3 = { "Select Cloud Server", "CS1"};
							
							String cloudname3 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
							String ip3 = JOptionPane.showInputDialog(jf,
									"Please Enter the IP Address Of Cloud Server");
							
							
						
							if(cloudname3.equalsIgnoreCase("CS1"))
							 {
							try {

								Socket soc3 = new Socket(ip3, 102);
								DataOutputStream dos4 = new DataOutputStream(
										soc3.getOutputStream());
								dos4.writeUTF("VerifyFile");
								dos4.writeUTF(filename);
								dos4.writeUTF(us);
								dos4.writeUTF(hash);

								DataInputStream din4 = new DataInputStream(soc3.getInputStream());
								String message4 = din4.readUTF();
								System.out.println(message4);

								JOptionPane.showMessageDialog(null, message4);

							} catch (Exception e2) {

								e2.printStackTrace();
							}
						}
							
						}
						else if(i1==1)
						{
							
						}


					} catch (Exception e2) {

						e2.printStackTrace();
					}
				}
					
				}
				else if(i==1)
				{
					
				}


			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
			
			//cs2 completed
			if(cloudname.equalsIgnoreCase("CS3"))
			 {
			try {

				Socket soc1 = new Socket(ip, 104);
				DataOutputStream dos2 = new DataOutputStream(
						soc1.getOutputStream());
				dos2.writeUTF("VerifyFile");
				dos2.writeUTF(filename);
				dos2.writeUTF(us);
				dos2.writeUTF(hash);

				DataInputStream din = new DataInputStream(soc1.getInputStream());
				String message = din.readUTF();
				System.out.println(message);

				JOptionPane.showMessageDialog(null, message);
				int i = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
				if(i==0)
				{
					String[] csname2 = { "Select Cloud Server","CS1" , "CS2"};
					
					String cloudname2 = (String) JOptionPane.showInputDialog(null,
							"Select Cloud Server", "CloudName",
							JOptionPane.QUESTION_MESSAGE, null,  csname2,  csname2[0]);
					String ip2 = JOptionPane.showInputDialog(jf,
							"Please Enter the IP Address Of Cloud Server");
					
					if(cloudname2.equalsIgnoreCase("CS1"))
					 {
					try {

						Socket soc2 = new Socket(ip2, 102);
						DataOutputStream dos3 = new DataOutputStream(soc2.getOutputStream());
						dos3.writeUTF("VerifyFile");
						dos3.writeUTF(filename);
						dos3.writeUTF(us);
						dos3.writeUTF(hash);

						DataInputStream din3 = new DataInputStream(soc2.getInputStream());
						String message2 = din3.readUTF();
						System.out.println(message2);

						JOptionPane.showMessageDialog(null, message2);
						int i1 = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
						if(i1==0)
						{
							String[] csname3 = { "Select Cloud Server", "CS2"};
							
							String cloudname3 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
							String ip3 = JOptionPane.showInputDialog(jf,
									"Please Enter the IP Address Of Cloud Server");
							
							
						
							if(cloudname3.equalsIgnoreCase("CS2"))
							 {
							try {

								Socket soc3 = new Socket(ip3, 103);
								DataOutputStream dos4 = new DataOutputStream(
										soc3.getOutputStream());
								dos4.writeUTF("VerifyFile");
								dos4.writeUTF(filename);
								dos4.writeUTF(us);
								dos4.writeUTF(hash);

								DataInputStream din4 = new DataInputStream(soc3.getInputStream());
								String message4 = din4.readUTF();
								System.out.println(message4);

								JOptionPane.showMessageDialog(null, message4);

							} catch (Exception e2) {

								e2.printStackTrace();
							}
						}
							
						}
						else if(i1==1)
						{
							
						}

						

					} catch (Exception e2) {

						e2.printStackTrace();
					}
				}
					
				
					if(cloudname2.equalsIgnoreCase("CS2"))
					 {
					try {

						Socket soc2 = new Socket(ip2, 103);
						DataOutputStream dos3 = new DataOutputStream(
								soc2.getOutputStream());
						dos3.writeUTF("VerifyFile");
						dos3.writeUTF(filename);
						dos3.writeUTF(us);
						dos3.writeUTF(hash);

						DataInputStream din3 = new DataInputStream(soc2.getInputStream());
						String message3 = din3.readUTF();
						System.out.println(message3);

						JOptionPane.showMessageDialog(null, message3);
						int i1 = JOptionPane.showConfirmDialog(null, "Do you want to check in another Cloud");
						if(i1==0)
						{
							String[] csname3 = { "Select Cloud Server", "CS1"};
							
							String cloudname3 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
							String ip3 = JOptionPane.showInputDialog(jf,
									"Please Enter the IP Address Of Cloud Server");
							
							
						
							if(cloudname3.equalsIgnoreCase("CS1"))
							 {
							try {

								Socket soc3 = new Socket(ip3, 102);
								DataOutputStream dos4 = new DataOutputStream(
										soc3.getOutputStream());
								dos4.writeUTF("VerifyFile");
								dos4.writeUTF(filename);
								dos4.writeUTF(us);
								dos4.writeUTF(hash);

								DataInputStream din4 = new DataInputStream(soc3.getInputStream());
								String message4 = din4.readUTF();
								System.out.println(message4);

								JOptionPane.showMessageDialog(null, message4);

							} catch (Exception e2) {

								e2.printStackTrace();
							}
						}
							
						}
						else if(i1==1)
						{
							
						}


					} catch (Exception e2) {

						e2.printStackTrace();
					}
				}
					
				}
				else if(i==1)
				{
					
				}

			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
			
			}
		}
		if (e.getSource() == upload) {

			
			if(tf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
			}
			if(head.getText().isEmpty())
					{
				JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
					}
			else{
				
			
			JFrame frame = new JFrame();

			
			String[] csname = { "Select Cloud Server", "CS1", "CS2", "CS3" };
			
			String cloudname = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null,  csname,  csname[0]);
			
				 
			String ip = JOptionPane.showInputDialog(frame,
					"Please Enter the IP Address Of Cloud Server");

			
			Socket socket1;
			DataOutputStream dos1;

			try
			 {
				KeyGenerator kgenerate = new KeyGenerator();
				 String sk = String.valueOf(kgenerate.getKeys());
					
				 
				 DBCon db = new DBCon();
				 Connection con = db.getConnection();
				 Statement stmt = con.createStatement();
				 String sql = "insert into OwnerFiles values('"+filename+"','"+sk+"','"+hash+"','"+us+"','"+cloudname+"')";
				 stmt.executeUpdate(sql);
				 
				 if(cloudname.equalsIgnoreCase("CS1"))
				 {
					 try
						{
							System.out.println("Data Sent");
						Socket sc1 = new Socket(ip,200);
						DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
						dout1.writeUTF(us);
						dout1.writeUTF(cloudname);
						
						DataInputStream din1 = new DataInputStream(sc1.getInputStream());
						String msg1 = din1.readUTF();
						if(msg1.equalsIgnoreCase("success"))
						{
							System.out.println("success");
				 AES a2= new AES();
				 Socket sc = new Socket(ip,501);
				 DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				 
				 System.out.println(a2.encrypt(content,keyword));
				 
				
				 dout.writeUTF(a2.encrypt(content,keyword));
				 dout.writeUTF(filename);
				 dout.writeUTF(us);
				 dout.writeUTF(sk);
				 dout.writeUTF(hash);
				 dout.writeUTF(cloudname);
				 
				 
				 DataInputStream din = new DataInputStream(sc.getInputStream());
				 String msg = din.readUTF();
				 if(msg.equalsIgnoreCase("success"))
				 {
					 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
					 head.setText(null);
					 tf.setText(null);
					 
				 }
				 else if(msg.equalsIgnoreCase("block"))
				 {
					 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
					 head.setText(null);
					 tf.setText(null);
				 }
				 else if(msg.equalsIgnoreCase("failure"))
				 {
					 JOptionPane.showMessageDialog(null, "Duplicate File Found in Cloud so Upload to different Cloud ");
					
					 int i = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
						if(i==0)
						{
							if(tf.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
							}
							if(head.getText().isEmpty())
									{
								JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
									}
							else{
								
							
							

							
							String[] csname2 = { "Select Cloud Server", "CS2", "CS3" };
							
							String cloudname2 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname2,  csname2[0]);
							
								 
							String ip2 = JOptionPane.showInputDialog(frame,
									"Please Enter the IP Address Of Cloud Server");

							
							Socket socket2;
							DataOutputStream dos2;

							try
							 {
								KeyGenerator kgenerate2 = new KeyGenerator();
								 String sk2 = String.valueOf(kgenerate.getKeys());
									
								 
								 DBCon db2 = new DBCon();
								 Connection con2 = db2.getConnection();
								 Statement stmt2 = con2.createStatement();
								 String sql2 = "insert into OwnerFiles values('"+filename+"','"+sk2+"','"+hash+"','"+us+"','"+cloudname2+"')";
								 stmt2.executeUpdate(sql2);
								 
								
								 if(cloudname2.equalsIgnoreCase("CS2"))
								 {
									 try
										{
											System.out.println("Data Sent");
										Socket sc2 = new Socket(ip2,202);
										DataOutputStream dout2 = new DataOutputStream(sc2.getOutputStream());
										dout2.writeUTF(us);
										dout2.writeUTF(cloudname2);
										
										DataInputStream din2 = new DataInputStream(sc2.getInputStream());
										String msg2 = din2.readUTF();
										if(msg2.equalsIgnoreCase("success"))
										{
											System.out.println("success");
											
								 AES a3= new AES();
								 Socket sc3 = new Socket(ip2,502);
								 DataOutputStream dout3 = new DataOutputStream(sc3.getOutputStream());
								 
								 System.out.println(a3.encrypt(content,keyword));
								 
								
								 dout3.writeUTF(a3.encrypt(content,keyword));
								 dout3.writeUTF(filename);
								 dout3.writeUTF(us);
								 dout3.writeUTF(sk2);
								 dout3.writeUTF(hash);
								 dout3.writeUTF(cloudname2);
								 
								 
								 DataInputStream din3 = new DataInputStream(sc3.getInputStream());
								 String msg3 = din3.readUTF();
								 if(msg3.equalsIgnoreCase("success"))
								 {
									 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
									 head.setText(null);
									 tf.setText(null);
									 
								 }
								 else if(msg3.equalsIgnoreCase("block"))
								 {
									 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
									 head.setText(null);
									 tf.setText(null);
								 }
								 else if(msg3.equalsIgnoreCase("failure"))
								 {
									 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
									 int i1 = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
										if(i1==0)
										{
											if(tf.getText().isEmpty())
											{
												JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
											}
											if(head.getText().isEmpty())
													{
												JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
													}
											else{
												
											
											

											
											String[] csname3 = { "Select Cloud Server", "CS3" };
											
											String cloudname3 = (String) JOptionPane.showInputDialog(null,
													"Select Cloud Server", "CloudName",
													JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
											
												 
											String ip3 = JOptionPane.showInputDialog(frame,
													"Please Enter the IP Address Of Cloud Server");

											
											Socket socket3;
											DataOutputStream dos3;

											try
											 {
												KeyGenerator kgenerate3 = new KeyGenerator();
												 String sk3 = String.valueOf(kgenerate.getKeys());
													
												 
												 DBCon db3 = new DBCon();
												 Connection con3 = db3.getConnection();
												 Statement stmt3 = con3.createStatement();
												 String sql3 = "insert into OwnerFiles values('"+filename+"','"+sk3+"','"+hash+"','"+us+"','"+cloudname3+"')";
												 stmt3.executeUpdate(sql3);
												 
												
												 if(cloudname3.equalsIgnoreCase("CS3"))
												 {
													 try
														{
															System.out.println("Data Sent");
														Socket sc4 = new Socket(ip3,203);
														DataOutputStream dout4 = new DataOutputStream(sc4.getOutputStream());
														dout4.writeUTF(us);
														dout4.writeUTF(cloudname3);
														
														DataInputStream din4 = new DataInputStream(sc4.getInputStream());
														String msg4 = din4.readUTF();
														if(msg4.equalsIgnoreCase("success"))
														{
															System.out.println("success");
															
												 AES a4= new AES();
												 Socket sc5 = new Socket(ip3,503);
												 DataOutputStream dout5 = new DataOutputStream(sc5.getOutputStream());
												 
												 System.out.println(a4.encrypt(content,keyword));
												 
												
												 dout5.writeUTF(a4.encrypt(content,keyword));
												 dout5.writeUTF(filename);
												 dout5.writeUTF(us);
												 dout5.writeUTF(sk3);
												 dout5.writeUTF(hash);
												 dout5.writeUTF(cloudname3);
												 
												 
												 DataInputStream din5 = new DataInputStream(sc5.getInputStream());
												 String msg5 = din5.readUTF();
												 if(msg5.equalsIgnoreCase("success"))
												 {
													 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
													 head.setText(null);
													 tf.setText(null);
													 
												 }
												 else if(msg5.equalsIgnoreCase("block"))
												 {
													 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
													 head.setText(null);
													 tf.setText(null);
												 }
												 else if(msg5.equalsIgnoreCase("failure"))
												 {
													 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
													 head.setText(null);
													 tf.setText(null);
												 }
														}
														 else if(msg4.equalsIgnoreCase("failure"))
															{
																System.out.println("failure");
																JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
															}
															
															
															}
															catch(Exception e1)
															{
																e1.printStackTrace();
															}
												
												 }
												  
												 
												
											 }
											 catch(Exception e1)
											 {
												 e1.printStackTrace();
											 }
												
											
											}
											
										}
										else if(i1==1)
										{
											
										}
								
									 
								 }
										}
										 else if(msg2.equalsIgnoreCase("failure"))
											{
												System.out.println("failure");
												JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
											}
											
											
											}
											catch(Exception e1)
											{
												e1.printStackTrace();
											}
								
								 }
								 if(cloudname2.equalsIgnoreCase("CS3"))
								 {
									 try
										{
											System.out.println("Data Sent");
										Socket sc2 = new Socket(ip2,203);
										DataOutputStream dout2 = new DataOutputStream(sc2.getOutputStream());
										dout2.writeUTF(us);
										dout2.writeUTF(cloudname2);
										
										DataInputStream din2 = new DataInputStream(sc2.getInputStream());
										String msg2 = din2.readUTF();
										if(msg2.equalsIgnoreCase("success"))
										{
											System.out.println("success");
											
								 AES a3= new AES();
								 Socket sc3 = new Socket(ip2,503);
								 DataOutputStream dout3 = new DataOutputStream(sc3.getOutputStream());
								 
								 System.out.println(a3.encrypt(content,keyword));
								 
								
								 dout3.writeUTF(a3.encrypt(content,keyword));
								 dout3.writeUTF(filename);
								 dout3.writeUTF(us);
								 dout3.writeUTF(sk2);
								 dout3.writeUTF(hash);
								 dout3.writeUTF(cloudname2);
								 
								 
								 DataInputStream din3 = new DataInputStream(sc3.getInputStream());
								 String msg3 = din3.readUTF();
								 if(msg3.equalsIgnoreCase("success"))
								 {
									 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
									 head.setText(null);
									 tf.setText(null);
									 
								 }
								 else if(msg3.equalsIgnoreCase("block"))
								 {
									 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
									 head.setText(null);
									 tf.setText(null);
								 }
								 else if(msg3.equalsIgnoreCase("failure"))
								 {
									 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
									 head.setText(null);
									 tf.setText(null);
								 }
										}
										 else if(msg2.equalsIgnoreCase("failure"))
											{
												System.out.println("failure");
												JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
											}
											
											
											}
											catch(Exception e1)
											{
												e1.printStackTrace();
											}
								
								 }
								  
								 
								
							 }
							 catch(Exception e1)
							 {
								 e1.printStackTrace();
							 }
								
							
							}
							
						}
						else if(i==1)
						{
							
						}
					 
					 
				 }
						}
						 else if(msg1.equalsIgnoreCase("failure"))
							{
								System.out.println("failure");
								JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
							}
							
							
							}
							catch(Exception e1)
							{
								e1.printStackTrace();
							}
				
				 }
//cs1 completed			
				 
				 
				 else if(cloudname.equalsIgnoreCase("CS2"))
				 {
					 try
						{
							System.out.println("Data Sent");
						Socket sc1 = new Socket(ip,202);
						DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
						dout1.writeUTF(us);
						dout1.writeUTF(cloudname);
						
						DataInputStream din1 = new DataInputStream(sc1.getInputStream());
						String msg1 = din1.readUTF();
						if(msg1.equalsIgnoreCase("success"))
						{
							System.out.println("success");
				 AES a2= new AES();
				 Socket sc = new Socket(ip,502);
				 DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				 
				 System.out.println(a2.encrypt(content,keyword));
				 
				
				 dout.writeUTF(a2.encrypt(content,keyword));
				 dout.writeUTF(filename);
				 dout.writeUTF(us);
				 dout.writeUTF(sk);
				 dout.writeUTF(hash);
				 dout.writeUTF(cloudname);
				 
				 
				 DataInputStream din = new DataInputStream(sc.getInputStream());
				 String msg = din.readUTF();
				 if(msg.equalsIgnoreCase("success"))
				 {
					 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
					 head.setText(null);
					 tf.setText(null);
					 
				 }
				 else if(msg.equalsIgnoreCase("block"))
				 {
					 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
					 head.setText(null);
					 tf.setText(null);
				 }
				 else if(msg.equalsIgnoreCase("failure"))
				 {
					 JOptionPane.showMessageDialog(null, "Duplicate File Found in Cloud so Upload to different Cloud ");
					 int i = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
						if(i==0)
						{
							if(tf.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
							}
							if(head.getText().isEmpty())
									{
								JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
									}
							else{
								
							
							

							
							String[] csname2 = { "Select Cloud Server", "CS1", "CS3" };
							
							String cloudname2 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname2,  csname2[0]);
							
								 
							String ip2 = JOptionPane.showInputDialog(frame,
									"Please Enter the IP Address Of Cloud Server");

							
							Socket socket2;
							DataOutputStream dos2;

							try
							 {
								KeyGenerator kgenerate2 = new KeyGenerator();
								 String sk2 = String.valueOf(kgenerate.getKeys());
									
								 
								 DBCon db2 = new DBCon();
								 Connection con2 = db2.getConnection();
								 Statement stmt2 = con2.createStatement();
								 String sql2 = "insert into OwnerFiles values('"+filename+"','"+sk2+"','"+hash+"','"+us+"','"+cloudname2+"')";
								 stmt2.executeUpdate(sql2);
								 
								 if(cloudname2.equalsIgnoreCase("CS1"))
								 {
									 try
										{
											System.out.println("Data Sent");
										Socket sc2 = new Socket(ip2,200);
										DataOutputStream dout2 = new DataOutputStream(sc2.getOutputStream());
										dout2.writeUTF(us);
										dout2.writeUTF(cloudname2);
										
										DataInputStream din2 = new DataInputStream(sc2.getInputStream());
										String msg2 = din2.readUTF();
										if(msg2.equalsIgnoreCase("success"))
										{
											System.out.println("success");
											
								 AES a3= new AES();
								 Socket sc3 = new Socket(ip2,501);
								 DataOutputStream dout3 = new DataOutputStream(sc3.getOutputStream());
								 
								 System.out.println(a3.encrypt(content,keyword));
								 
								
								 dout3.writeUTF(a3.encrypt(content,keyword));
								 dout3.writeUTF(filename);
								 dout3.writeUTF(us);
								 dout3.writeUTF(sk2);
								 dout3.writeUTF(hash);
								 dout3.writeUTF(cloudname2);
								 
								 
								 DataInputStream din3 = new DataInputStream(sc3.getInputStream());
								 String msg3 = din3.readUTF();
								 if(msg3.equalsIgnoreCase("success"))
								 {
									 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
									 head.setText(null);
									 tf.setText(null);
									 
								 }
								 else if(msg3.equalsIgnoreCase("block"))
								 {
									 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
									 head.setText(null);
									 tf.setText(null);
								 }
								 else if(msg3.equalsIgnoreCase("failure"))
								 {
									 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
									 int i1 = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
										if(i1==0)
										{
											if(tf.getText().isEmpty())
											{
												JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
											}
											if(head.getText().isEmpty())
													{
												JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
													}
											else{
												
											
											

											
											String[] csname3 = { "Select Cloud Server", "CS3" };
											
											String cloudname3 = (String) JOptionPane.showInputDialog(null,
													"Select Cloud Server", "CloudName",
													JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
											
												 
											String ip3 = JOptionPane.showInputDialog(frame,
													"Please Enter the IP Address Of Cloud Server");

											
											Socket socket3;
											DataOutputStream dos3;

											try
											 {
												KeyGenerator kgenerate3 = new KeyGenerator();
												 String sk3 = String.valueOf(kgenerate.getKeys());
													
												 
												 DBCon db3 = new DBCon();
												 Connection con3 = db3.getConnection();
												 Statement stmt3 = con3.createStatement();
												 String sql3 = "insert into OwnerFiles values('"+filename+"','"+sk3+"','"+hash+"','"+us+"','"+cloudname3+"')";
												 stmt3.executeUpdate(sql3);
												 
												
												 if(cloudname3.equalsIgnoreCase("CS3"))
												 {
													 try
														{
															System.out.println("Data Sent");
														Socket sc4 = new Socket(ip3,203);
														DataOutputStream dout4 = new DataOutputStream(sc4.getOutputStream());
														dout4.writeUTF(us);
														dout4.writeUTF(cloudname3);
														
														DataInputStream din4 = new DataInputStream(sc4.getInputStream());
														String msg4 = din4.readUTF();
														if(msg4.equalsIgnoreCase("success"))
														{
															System.out.println("success");
															
												 AES a4= new AES();
												 Socket sc5 = new Socket(ip3,503);
												 DataOutputStream dout5 = new DataOutputStream(sc5.getOutputStream());
												 
												 System.out.println(a4.encrypt(content,keyword));
												 
												
												 dout5.writeUTF(a4.encrypt(content,keyword));
												 dout5.writeUTF(filename);
												 dout5.writeUTF(us);
												 dout5.writeUTF(sk3);
												 dout5.writeUTF(hash);
												 dout5.writeUTF(cloudname3);
												 
												 
												 DataInputStream din5 = new DataInputStream(sc5.getInputStream());
												 String msg5 = din5.readUTF();
												 if(msg5.equalsIgnoreCase("success"))
												 {
													 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
													 head.setText(null);
													 tf.setText(null);
													 
												 }
												 else if(msg5.equalsIgnoreCase("block"))
												 {
													 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
													 head.setText(null);
													 tf.setText(null);
												 }
												 else if(msg5.equalsIgnoreCase("failure"))
												 {
													 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
													 head.setText(null);
													 tf.setText(null);
												 }
														}
														 else if(msg4.equalsIgnoreCase("failure"))
															{
																System.out.println("failure");
																JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
															}
															
															
															}
															catch(Exception e1)
															{
																e1.printStackTrace();
															}
												
												 }
												  
												 
												
											 }
											 catch(Exception e1)
											 {
												 e1.printStackTrace();
											 }
												
											
											}
											
										}
										else if(i1==1)
										{
											
										}
								 }
										}
										 else if(msg2.equalsIgnoreCase("failure"))
											{
												System.out.println("failure");
												JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
											}
											
											
											}
											catch(Exception e1)
											{
												e1.printStackTrace();
											}
								
								 }
								
								 if(cloudname2.equalsIgnoreCase("CS3"))
								 {
									 try
										{
											System.out.println("Data Sent");
										Socket sc2 = new Socket(ip2,203);
										DataOutputStream dout2 = new DataOutputStream(sc2.getOutputStream());
										dout2.writeUTF(us);
										dout2.writeUTF(cloudname2);
										
										DataInputStream din2 = new DataInputStream(sc2.getInputStream());
										String msg2 = din2.readUTF();
										if(msg2.equalsIgnoreCase("success"))
										{
											System.out.println("success");
											
								 AES a3= new AES();
								 Socket sc3 = new Socket(ip2,503);
								 DataOutputStream dout3 = new DataOutputStream(sc3.getOutputStream());
								 
								 System.out.println(a3.encrypt(content,keyword));
								 
								
								 dout3.writeUTF(a3.encrypt(content,keyword));
								 dout3.writeUTF(filename);
								 dout3.writeUTF(us);
								 dout3.writeUTF(sk2);
								 dout3.writeUTF(hash);
								 dout3.writeUTF(cloudname2);
								 
								 
								 DataInputStream din3 = new DataInputStream(sc3.getInputStream());
								 String msg3 = din3.readUTF();
								 if(msg3.equalsIgnoreCase("success"))
								 {
									 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
									 head.setText(null);
									 tf.setText(null);
									 
								 }
								 else if(msg3.equalsIgnoreCase("block"))
								 {
									 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
									 head.setText(null);
									 tf.setText(null);
								 }
								 else if(msg3.equalsIgnoreCase("failure"))
								 {
									 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
									 int i1 = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
										if(i1==0)
										{
											if(tf.getText().isEmpty())
											{
												JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
											}
											if(head.getText().isEmpty())
													{
												JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
													}
											else{
												
											
											

											
											String[] csname3 = { "Select Cloud Server", "CS1" };
											
											String cloudname3 = (String) JOptionPane.showInputDialog(null,
													"Select Cloud Server", "CloudName",
													JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
											
												 
											String ip3 = JOptionPane.showInputDialog(frame,
													"Please Enter the IP Address Of Cloud Server");

											
											Socket socket3;
											DataOutputStream dos3;

											try
											 {
												KeyGenerator kgenerate3 = new KeyGenerator();
												 String sk3 = String.valueOf(kgenerate.getKeys());
													
												 
												 DBCon db3 = new DBCon();
												 Connection con3 = db3.getConnection();
												 Statement stmt3 = con3.createStatement();
												 String sql3 = "insert into OwnerFiles values('"+filename+"','"+sk3+"','"+hash+"','"+us+"','"+cloudname3+"')";
												 stmt3.executeUpdate(sql3);
												 
												
												 if(cloudname3.equalsIgnoreCase("CS1"))
												 {
													 try
														{
															System.out.println("Data Sent");
														Socket sc4 = new Socket(ip3,200);
														DataOutputStream dout4 = new DataOutputStream(sc4.getOutputStream());
														dout4.writeUTF(us);
														dout4.writeUTF(cloudname3);
														
														DataInputStream din4 = new DataInputStream(sc4.getInputStream());
														String msg4 = din4.readUTF();
														if(msg4.equalsIgnoreCase("success"))
														{
															System.out.println("success");
															
												 AES a4= new AES();
												 Socket sc5 = new Socket(ip3,501);
												 DataOutputStream dout5 = new DataOutputStream(sc5.getOutputStream());
												 
												 System.out.println(a4.encrypt(content,keyword));
												 
												
												 dout5.writeUTF(a4.encrypt(content,keyword));
												 dout5.writeUTF(filename);
												 dout5.writeUTF(us);
												 dout5.writeUTF(sk3);
												 dout5.writeUTF(hash);
												 dout5.writeUTF(cloudname3);
												 
												 
												 DataInputStream din5 = new DataInputStream(sc5.getInputStream());
												 String msg5 = din5.readUTF();
												 if(msg5.equalsIgnoreCase("success"))
												 {
													 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
													 head.setText(null);
													 tf.setText(null);
													 
												 }
												 else if(msg5.equalsIgnoreCase("block"))
												 {
													 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
													 head.setText(null);
													 tf.setText(null);
												 }
												 else if(msg5.equalsIgnoreCase("failure"))
												 {
													 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
													 head.setText(null);
													 tf.setText(null);
												 }
														}
														 else if(msg4.equalsIgnoreCase("failure"))
															{
																System.out.println("failure");
																JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
															}
															
															
															}
															catch(Exception e1)
															{
																e1.printStackTrace();
															}
												
												 }
												  
												 
												
											 }
											 catch(Exception e1)
											 {
												 e1.printStackTrace();
											 }
												
											
											}
											
										}
										else if(i1==1)
										{
											
										}
									 
									 
								 }
										}
										 else if(msg2.equalsIgnoreCase("failure"))
											{
												System.out.println("failure");
												JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
											}
											
											
											}
											catch(Exception e1)
											{
												e1.printStackTrace();
											}
								
								 }
								  
								 
								
							 }
							 catch(Exception e1)
							 {
								 e1.printStackTrace();
							 }
								
							
							}
							
						}
						else if(i==1)
						{
							
						}
				 }
				
						}
						 else if(msg1.equalsIgnoreCase("failure"))
							{
								System.out.println("failure");
								JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
							}
							
							
							}
							catch(Exception e1)
							{
								e1.printStackTrace();
							}
						}
				 
				 
				 //cs2completed
				 else if(cloudname.equalsIgnoreCase("CS3"))
				 {
					 try
						{
							System.out.println("Data Sent");
						Socket sc1 = new Socket(ip,203);
						DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
						dout1.writeUTF(us);
						dout1.writeUTF(cloudname);
						
						DataInputStream din1 = new DataInputStream(sc1.getInputStream());
						String msg1 = din1.readUTF();
						if(msg1.equalsIgnoreCase("success"))
						{
							System.out.println("success");
					 AES a2= new AES();
				 Socket sc = new Socket(ip,503);
				 DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				 
				 System.out.println(a2.encrypt(content,keyword));
				 
				
				 dout.writeUTF(a2.encrypt(content,keyword));
				 dout.writeUTF(filename);
				 dout.writeUTF(us);
				 dout.writeUTF(sk);
				 dout.writeUTF(hash);
				 dout.writeUTF(cloudname);
				 
				 
				 DataInputStream din = new DataInputStream(sc.getInputStream());
				 String msg = din.readUTF();
				 if(msg.equalsIgnoreCase("success"))
				 {
					 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
					 head.setText(null);
					 tf.setText(null);
					 
				 }
				 else if(msg.equalsIgnoreCase("block"))
				 {
					 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
					 head.setText(null);
					 tf.setText(null);
				 }
				 else if(msg.equalsIgnoreCase("failure"))
				 {
					 JOptionPane.showMessageDialog(null, "Duplicate File Found in Cloud so Upload to different Cloud ");
					 int i = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
						if(i==0)
						{
							if(tf.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
							}
							if(head.getText().isEmpty())
									{
								JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
									}
							else{
								
							
							

							
							String[] csname2 = { "Select Cloud Server", "CS1", "CS2"};
							
							String cloudname2 = (String) JOptionPane.showInputDialog(null,
									"Select Cloud Server", "CloudName",
									JOptionPane.QUESTION_MESSAGE, null,  csname2,  csname2[0]);
							
								 
							String ip2 = JOptionPane.showInputDialog(frame,
									"Please Enter the IP Address Of Cloud Server");

							
							Socket socket2;
							DataOutputStream dos2;

							try
							 {
								KeyGenerator kgenerate2 = new KeyGenerator();
								 String sk2 = String.valueOf(kgenerate.getKeys());
									
								 
								 DBCon db2 = new DBCon();
								 Connection con2 = db2.getConnection();
								 Statement stmt2 = con2.createStatement();
								 String sql2 = "insert into OwnerFiles values('"+filename+"','"+sk2+"','"+hash+"','"+us+"','"+cloudname2+"')";
								 stmt2.executeUpdate(sql2);
								 
								 if(cloudname2.equalsIgnoreCase("CS1"))
								 {
									 try
										{
											System.out.println("Data Sent");
										Socket sc2 = new Socket(ip2,200);
										DataOutputStream dout2 = new DataOutputStream(sc2.getOutputStream());
										dout2.writeUTF(us);
										dout2.writeUTF(cloudname2);
										
										DataInputStream din2 = new DataInputStream(sc2.getInputStream());
										String msg2 = din2.readUTF();
										if(msg2.equalsIgnoreCase("success"))
										{
											System.out.println("success");
											
								 AES a3= new AES();
								 Socket sc3 = new Socket(ip2,501);
								 DataOutputStream dout3 = new DataOutputStream(sc3.getOutputStream());
								 
								 System.out.println(a3.encrypt(content,keyword));
								 
								
								 dout3.writeUTF(a3.encrypt(content,keyword));
								 dout3.writeUTF(filename);
								 dout3.writeUTF(us);
								 dout3.writeUTF(sk2);
								 dout3.writeUTF(hash);
								 dout3.writeUTF(cloudname2);
								 
								 
								 DataInputStream din3 = new DataInputStream(sc3.getInputStream());
								 String msg3 = din3.readUTF();
								 if(msg3.equalsIgnoreCase("success"))
								 {
									 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
									 head.setText(null);
									 tf.setText(null);
									 
								 }
								 else if(msg3.equalsIgnoreCase("block"))
								 {
									 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
									 head.setText(null);
									 tf.setText(null);
								 }
								 else if(msg3.equalsIgnoreCase("failure"))
								 {
									 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
									 int i1 = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
										if(i1==0)
										{
											if(tf.getText().isEmpty())
											{
												JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
											}
											if(head.getText().isEmpty())
													{
												JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
													}
											else{
												
											
											

											
											String[] csname3 = { "Select Cloud Server", "CS2" };
											
											String cloudname3 = (String) JOptionPane.showInputDialog(null,
													"Select Cloud Server", "CloudName",
													JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
											
												 
											String ip3 = JOptionPane.showInputDialog(frame,
													"Please Enter the IP Address Of Cloud Server");

											
											Socket socket3;
											DataOutputStream dos3;

											try
											 {
												KeyGenerator kgenerate3 = new KeyGenerator();
												 String sk3 = String.valueOf(kgenerate.getKeys());
													
												 
												 DBCon db3 = new DBCon();
												 Connection con3 = db3.getConnection();
												 Statement stmt3 = con3.createStatement();
												 String sql3 = "insert into OwnerFiles values('"+filename+"','"+sk3+"','"+hash+"','"+us+"','"+cloudname3+"')";
												 stmt3.executeUpdate(sql3);
												 
												
												 if(cloudname3.equalsIgnoreCase("CS2"))
												 {
													 try
														{
															System.out.println("Data Sent");
														Socket sc4 = new Socket(ip3,202);
														DataOutputStream dout4 = new DataOutputStream(sc4.getOutputStream());
														dout4.writeUTF(us);
														dout4.writeUTF(cloudname3);
														
														DataInputStream din4 = new DataInputStream(sc4.getInputStream());
														String msg4 = din4.readUTF();
														if(msg4.equalsIgnoreCase("success"))
														{
															System.out.println("success");
															
												 AES a4= new AES();
												 Socket sc5 = new Socket(ip3,502);
												 DataOutputStream dout5 = new DataOutputStream(sc5.getOutputStream());
												 
												 System.out.println(a4.encrypt(content,keyword));
												 
												
												 dout5.writeUTF(a4.encrypt(content,keyword));
												 dout5.writeUTF(filename);
												 dout5.writeUTF(us);
												 dout5.writeUTF(sk3);
												 dout5.writeUTF(hash);
												 dout5.writeUTF(cloudname3);
												 
												 
												 DataInputStream din5 = new DataInputStream(sc5.getInputStream());
												 String msg5 = din5.readUTF();
												 if(msg5.equalsIgnoreCase("success"))
												 {
													 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
													 head.setText(null);
													 tf.setText(null);
													 
												 }
												 else if(msg5.equalsIgnoreCase("block"))
												 {
													 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
													 head.setText(null);
													 tf.setText(null);
												 }
												 else if(msg5.equalsIgnoreCase("failure"))
												 {
													 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
													 head.setText(null);
													 tf.setText(null);
												 }
														}
														 else if(msg4.equalsIgnoreCase("failure"))
															{
																System.out.println("failure");
																JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
															}
															
															
															}
															catch(Exception e1)
															{
																e1.printStackTrace();
															}
												
												 }
												  
												 
												
											 }
											 catch(Exception e1)
											 {
												 e1.printStackTrace();
											 }
												
											
											}
											
										}
										else if(i1==1)
										{
											
										}
								 }
										}
										 else if(msg2.equalsIgnoreCase("failure"))
											{
												System.out.println("failure");
												JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
											}
											
											
											}
											catch(Exception e1)
											{
												e1.printStackTrace();
											}
								
								 }
								 else if(cloudname2.equalsIgnoreCase("CS2"))
								 {
									 try
										{
											System.out.println("Data Sent");
										Socket sc2 = new Socket(ip2,202);
										DataOutputStream dout2 = new DataOutputStream(sc2.getOutputStream());
										dout2.writeUTF(us);
										dout2.writeUTF(cloudname2);
										
										DataInputStream din2 = new DataInputStream(sc2.getInputStream());
										String msg2 = din2.readUTF();
										if(msg2.equalsIgnoreCase("success"))
										{
											System.out.println("success");
											
								 AES a3= new AES();
								 Socket sc3 = new Socket(ip2,502);
								 DataOutputStream dout3 = new DataOutputStream(sc3.getOutputStream());
								 
								 System.out.println(a3.encrypt(content,keyword));
								 
								
								 dout3.writeUTF(a3.encrypt(content,keyword));
								 dout3.writeUTF(filename);
								 dout3.writeUTF(us);
								 dout3.writeUTF(sk2);
								 dout3.writeUTF(hash);
								 dout3.writeUTF(cloudname2);
								 
								 
								 DataInputStream din3 = new DataInputStream(sc3.getInputStream());
								 String msg3 = din3.readUTF();
								 if(msg3.equalsIgnoreCase("success"))
								 {
									 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
									 head.setText(null);
									 tf.setText(null);
									 
								 }
								 else if(msg3.equalsIgnoreCase("block"))
								 {
									 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
									 head.setText(null);
									 tf.setText(null);
								 }
								 else if(msg3.equalsIgnoreCase("failure"))
								 {
									 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
									 int i1 = JOptionPane.showConfirmDialog(null, "Do you want to Upload to Another Cloud");
										if(i1==0)
										{
											if(tf.getText().isEmpty())
											{
												JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
											}
											if(head.getText().isEmpty())
													{
												JOptionPane.showMessageDialog(null, "Please Generate the Sign and Upload");
													}
											else{
												
											
											

											
											String[] csname3 = { "Select Cloud Server", "CS1" };
											
											String cloudname3 = (String) JOptionPane.showInputDialog(null,
													"Select Cloud Server", "CloudName",
													JOptionPane.QUESTION_MESSAGE, null,  csname3,  csname3[0]);
											
												 
											String ip3 = JOptionPane.showInputDialog(frame,
													"Please Enter the IP Address Of Cloud Server");

											
											Socket socket3;
											DataOutputStream dos3;

											try
											 {
												KeyGenerator kgenerate3 = new KeyGenerator();
												 String sk3 = String.valueOf(kgenerate.getKeys());
													
												 
												 DBCon db3 = new DBCon();
												 Connection con3 = db3.getConnection();
												 Statement stmt3 = con3.createStatement();
												 String sql3 = "insert into OwnerFiles values('"+filename+"','"+sk3+"','"+hash+"','"+us+"','"+cloudname3+"')";
												 stmt3.executeUpdate(sql3);
												 
												
												 if(cloudname3.equalsIgnoreCase("CS1"))
												 {
													 try
														{
															System.out.println("Data Sent");
														Socket sc4 = new Socket(ip3,200);
														DataOutputStream dout4 = new DataOutputStream(sc4.getOutputStream());
														dout4.writeUTF(us);
														dout4.writeUTF(cloudname3);
														
														DataInputStream din4 = new DataInputStream(sc4.getInputStream());
														String msg4 = din4.readUTF();
														if(msg4.equalsIgnoreCase("success"))
														{
															System.out.println("success");
															
												 AES a4= new AES();
												 Socket sc5 = new Socket(ip3,501);
												 DataOutputStream dout5 = new DataOutputStream(sc5.getOutputStream());
												 
												 System.out.println(a4.encrypt(content,keyword));
												 
												
												 dout5.writeUTF(a4.encrypt(content,keyword));
												 dout5.writeUTF(filename);
												 dout5.writeUTF(us);
												 dout5.writeUTF(sk3);
												 dout5.writeUTF(hash);
												 dout5.writeUTF(cloudname3);
												 
												 
												 DataInputStream din5 = new DataInputStream(sc5.getInputStream());
												 String msg5 = din5.readUTF();
												 if(msg5.equalsIgnoreCase("success"))
												 {
													 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
													 head.setText(null);
													 tf.setText(null);
													 
												 }
												 else if(msg5.equalsIgnoreCase("block"))
												 {
													 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
													 head.setText(null);
													 tf.setText(null);
												 }
												 else if(msg5.equalsIgnoreCase("failure"))
												 {
													 JOptionPane.showMessageDialog(null, "Duplicate File Found ");
													 head.setText(null);
													 tf.setText(null);
												 }
														}
														 else if(msg4.equalsIgnoreCase("failure"))
															{
																System.out.println("failure");
																JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
															}
															
															
															}
															catch(Exception e1)
															{
																e1.printStackTrace();
															}
												
												 }
												  
												 
												
											 }
											 catch(Exception e1)
											 {
												 e1.printStackTrace();
											 }
												
											
											}
											
										}
										else if(i1==1)
										{
											
										}
								 }
										}
										 else if(msg2.equalsIgnoreCase("failure"))
											{
												System.out.println("failure");
												JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
											}
											
											
											}
											catch(Exception e1)
											{
												e1.printStackTrace();
											}
								
								 }
								
								  
								 
								
							 }
							 catch(Exception e1)
							 {
								 e1.printStackTrace();
							 }
								
							
							}
							
						}
						else if(i==1)
						{
							
						}
				 }
						}
						 else if(msg1.equalsIgnoreCase("failure"))
							{
								System.out.println("failure");
								JOptionPane.showMessageDialog(null,"UnAuthorised DataOwner");
							}
							
							
							}
							catch(Exception e1)
							{
								e1.printStackTrace();
							}
				 }
			 }
			 catch(Exception e1)
			 {
				 e1.printStackTrace();
			 }
				
			
			}
		}
	}

	public static void main(String args[]) {
		//new DataOwner(" ");
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Owner("rak");
			}
		});
	}
}
