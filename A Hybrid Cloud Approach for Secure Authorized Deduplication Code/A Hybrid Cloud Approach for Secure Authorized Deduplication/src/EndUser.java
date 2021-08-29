import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class EndUser extends JFrame implements ActionListener
{
	Container c;
	JButton j1,j2,j3;
	JMenuBar mb;
	JMenu m;
	JMenuItem m1;
	String keyword = "ef50a0ef2c3e3a5fdf803ae9752c8c66";
	public Font f1 = new Font("Times new roman", Font.BOLD, 14);
	public Font f2 = new Font("Times new roman", Font.BOLD, 16);
	public JTextArea tf = new JTextArea();
	public JScrollPane pane = new JScrollPane();
	EndUser()
	{
		setTitle("RemoteUser::A Hybrid Cloud Approach for Secure Authorized Deduplication");
		c = getContentPane();
		c.setLayout(null);
		
	/*	 ImageIcon banner = new ImageIcon(this.getClass().getResource("EndUser.png"));
		 JLabel title = new JLabel();
		 title.setIcon(banner);
		 title.setBounds(-10, 0, 650,100);*/
		 
		pane.setBounds(250, 100, 320, 280);

		tf.setColumns(100);
		tf.setForeground(Color.black);
		tf.setFont(f1);
		tf.setRows(200);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);
		c.add(pane, BorderLayout.CENTER);
		
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("RemoteUser.png"));
		 JLabel title = new JLabel();
		 title.setIcon(banner);
		 title.setBounds(0, -10, 600,110);
		 
		 
		 ImageIcon banner1 = new ImageIcon(this.getClass().getResource("EndUserBanner.jpg"));
		 JLabel title1 = new JLabel();
		 title1.setIcon(banner1);
		 title1.setBounds(-20, 100, 400,250);
		 
		
		 
	
		j2 = new JButton("Download File");
		j2.setFont(f2);
		j2.setBounds(80,420,130,30);
		j2.addActionListener(this);
		c.add(j2);
		
		   /* ImageIcon banner = new ImageIcon(this.getClass().getResource("EndUser.jpeg"));
			JLabel title = new JLabel();
			title.setIcon(banner);
			title.setBounds(25, -10, 700,600);*/
		
		
		Border b11=BorderFactory.createLineBorder(Color.black,2);
		TitledBorder t1=new TitledBorder(b11);
		//t1.setTitle("Adding Query");
		t1.setTitleColor(Color.RED);
		//t1.setTitleFont(f1);
		
		JLabel l1=new JLabel();
		l1.setBorder(t1);
		l1.setBounds(5,90,570,300);
		c.add(l1);
		
	
		TitledBorder t2=new TitledBorder(b11);
		//t2.setTitle("Query Retrival Using RASP");
		t2.setTitleColor(Color.RED);
		//t2.setTitleFont(f1);
		
		JLabel l2=new JLabel();
		l2.setBorder(t2);
		l2.setBounds(5,400,570,70);
		c.add(l2);
		
		j1 = new JButton("Exit");
		j1.setFont(f2);
		j1.setBounds(350,420,80,30);
		j1.addActionListener(this);
		c.add(j1);
		
		
		j3 = new JButton("View Cloud Files");
		j3.setFont(f2);
		j3.setBounds(350,450,180,30);
		//j3.setBounds(550,600,150,30);
		j3.addActionListener(this);
		//c.add(j3);
		
		c.setBackground(Color.white);
		c.add(title);
		c.add(title1);
		setSize(600,515);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==j1)
		{
			System.exit(0);
		}
		if(e.getSource()==j2)
		{
			
			try
			{
			InetAddress ia = InetAddress.getLocalHost();
			String ip = ia.getHostAddress();
			
			String name = JOptionPane.showInputDialog("Enter Your name");
			String owner = JOptionPane.showInputDialog("Enter Owner Name");
			String[] csname = { "Select Cloud Server", "CS1", "CS2", "CS3" };
			
			String cloudname = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null,  csname,  csname[0]);
		
			if(cloudname.equalsIgnoreCase("CS1"))
			{
			Socket sc = new Socket("localhost",302);
			DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
			dout.writeUTF("check");
			dout.writeUTF(name);
			dout.writeUTF(owner);
			dout.writeUTF(ip);
			
			DataInputStream din = new DataInputStream(sc.getInputStream());
			String msg = din.readUTF();
			if(msg.equalsIgnoreCase("success"))
			{
				String filename1=JOptionPane.showInputDialog("Enter the filename");
				String sec=JOptionPane.showInputDialog("Enter secretkey");
				String ip1=JOptionPane.showInputDialog("Enter cloud Ip address");
				
				Socket sc1 = new Socket(ip1,302);
				DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
				dout1.writeUTF("download");
				dout1.writeUTF(name);
				dout1.writeUTF(owner);
				dout1.writeUTF(filename1);
				dout1.writeUTF(sec);
				dout1.writeUTF(ip);
				
				
				DataInputStream oin = new DataInputStream(sc1.getInputStream());
				String msg1 =oin.readUTF();
				System.out.println(msg1);
				
				
				if(msg1.equalsIgnoreCase("success"))
				{
					System.out.println("success");
					AES a3 = new AES();
					String data1 =oin.readUTF();
					String data = a3.decrypt(data1, keyword);
					tf.setText(data);
					PrintStream p = new PrintStream("user/"+filename1);
					p.write(data.getBytes());
					
					JOptionPane.showMessageDialog(null, "FileDownloaded Successfully");
					int i = JOptionPane.showConfirmDialog(null, "Do you want to open file Downloaded Folder");
					if(i==0)
					{
						File f= new File("user");
						Desktop desktop = Desktop.getDesktop();
						 desktop.open(f);
						
					}
					else if(i==1)
					{
						
					}
				}
				else if(msg1.equalsIgnoreCase("failure"))
				{
					JOptionPane.showMessageDialog(null, "you are trying to attack the file, You are Automatically blocked" );
				}
				else if(msg1.equalsIgnoreCase("not"))
				{
					JOptionPane.showMessageDialog(null, "File Not Found in Cloud Server" );
				}
				
				
				
			}
			else if(msg.equalsIgnoreCase("block"))
			{
				JOptionPane
				.showMessageDialog(null,
						"You are Curently blocked ..!!!! \n To access Contact Cloud Server");
			}
			else if(msg.equalsIgnoreCase("unblock"))
			{
				JOptionPane
				.showMessageDialog(null,
						"Remote user not Registered in Cloud Server");
			}
			
			}
			else if(cloudname.equalsIgnoreCase("CS2"))
			{
				Socket sc = new Socket("localhost",352);
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				dout.writeUTF("check");
				dout.writeUTF(name);
				dout.writeUTF(owner);
				dout.writeUTF(ip);
				
				DataInputStream din = new DataInputStream(sc.getInputStream());
				String msg = din.readUTF();
				if(msg.equalsIgnoreCase("success"))
				{
					String filename1=JOptionPane.showInputDialog("Enter the filename");
					String sec=JOptionPane.showInputDialog("Enter secretkey");
					String ip1=JOptionPane.showInputDialog("Enter cloud Ip address");
					
					Socket sc1 = new Socket(ip1,352);
					DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
					dout1.writeUTF("download");
					dout1.writeUTF(name);
					dout1.writeUTF(owner);
					dout1.writeUTF(filename1);
					dout1.writeUTF(sec);
					dout1.writeUTF(ip);
					
					
					DataInputStream oin = new DataInputStream(sc1.getInputStream());
					String msg1 =oin.readUTF();
					System.out.println(msg1);
					
					
					if(msg1.equalsIgnoreCase("success"))
					{
						System.out.println("success");
						AES a3 = new AES();
						String data1 =oin.readUTF();
						String data = a3.decrypt(data1, keyword);
						tf.setText(data);
						PrintStream p = new PrintStream("user/"+filename1);
						p.write(data.getBytes());
						
						JOptionPane.showMessageDialog(null, "FileDownloaded Successfully");
						int i = JOptionPane.showConfirmDialog(null, "Do you want to open file Downloaded Folder");
						if(i==0)
						{
							File f= new File("user");
							Desktop desktop = Desktop.getDesktop();
							 desktop.open(f);
							
						}
						else if(i==1)
						{
							
						}
					}
					else if(msg1.equalsIgnoreCase("failure"))
					{
						JOptionPane.showMessageDialog(null, "you are trying to attack the file, You are Automatically blocked" );
					}
					else if(msg1.equalsIgnoreCase("not"))
					{
						JOptionPane.showMessageDialog(null, "File Not Found in Cloud Server" );
					}
					
					
				}
				else if(msg.equalsIgnoreCase("block"))
				{
					JOptionPane
					.showMessageDialog(null,
							"You are Curently blocked ..!!!! \n To access Contact Cloud Server");
				}
				else if(msg.equalsIgnoreCase("unblock"))
				{
					JOptionPane
					.showMessageDialog(null,
							"Remote user not Registered in Cloud Server");
				}
				
			}
			
			else if(cloudname.equalsIgnoreCase("CS3"))
			{
				Socket sc = new Socket("localhost",362);
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				dout.writeUTF("check");
				dout.writeUTF(name);
				dout.writeUTF(owner);
				dout.writeUTF(ip);
				
				DataInputStream din = new DataInputStream(sc.getInputStream());
				String msg = din.readUTF();
				if(msg.equalsIgnoreCase("success"))
				{
					String filename1=JOptionPane.showInputDialog("Enter the filename");
					String sec=JOptionPane.showInputDialog("Enter secretkey");
					String ip1=JOptionPane.showInputDialog("Enter cloud Ip address");
					
					Socket sc1 = new Socket(ip1,362);
					DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
					dout1.writeUTF("download");
					dout1.writeUTF(name);
					dout1.writeUTF(owner);
					dout1.writeUTF(filename1);
					dout1.writeUTF(sec);
					dout1.writeUTF(ip);
					
					
					DataInputStream oin = new DataInputStream(sc1.getInputStream());
					String msg1 =oin.readUTF();
					System.out.println(msg1);
					
					
					if(msg1.equalsIgnoreCase("success"))
					{
						System.out.println("success");
						AES a3 = new AES();
						String data1 =oin.readUTF();
						String data = a3.decrypt(data1, keyword);
						tf.setText(data);
						PrintStream p = new PrintStream("user/"+filename1);
						p.write(data.getBytes());
						
						JOptionPane.showMessageDialog(null, "FileDownloaded Successfully");
						int i = JOptionPane.showConfirmDialog(null, "Do you want to open file Downloaded Folder");
						if(i==0)
						{
							File f= new File("user");
							Desktop desktop = Desktop.getDesktop();
							 desktop.open(f);
							
						}
						else if(i==1)
						{
							
						}
					}
					else if(msg1.equalsIgnoreCase("failure"))
					{
						JOptionPane.showMessageDialog(null, "you are trying to attack the file, You are Automatically blocked" );
					}
					else if(msg1.equalsIgnoreCase("not"))
					{
						JOptionPane.showMessageDialog(null, "File Not Found in Cloud Server" );
					}
					
					
				}
				else if(msg.equalsIgnoreCase("block"))
				{
					JOptionPane
					.showMessageDialog(null,
							"You are Curently blocked ..!!!! \n To access Contact Cloud Server");
				}
				else if(msg.equalsIgnoreCase("unblock"))
				{
					JOptionPane
					.showMessageDialog(null,
							"Remote user not Registered in Cloud Server");
				}
				
			}
			
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
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
				new EndUser();
			}
		});
	}

}
