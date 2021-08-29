import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.*;

import javax.swing.*;

public class Attacker extends JFrame implements ActionListener
{
	Container c;
	JButton jb,jb2;
	JLabel al;
	JTextArea tf;
	String keyword = "ef50a0ef2c3e3a5fdf803ae9752c8c66";
	public Font f1 = new Font("Times new roman", Font.BOLD, 18);
	
	Attacker()
	{
		JScrollPane pane = new JScrollPane();
		setTitle("Remote Cloud Attacker");
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.green);
		
		al=new JLabel("Enter VM Size");
		jb = new JButton("Attack MSP");
		jb.setBounds(50,450,120,30);
		al.setBounds(200,100,100,50);
		
		
		
		jb2 = new JButton("Exit");
		jb2.setBounds(300,450,100,30);
		
		jb.addActionListener(this);

		jb2.addActionListener(this);
	
		
		c.add(jb);

		c.add(jb2);

		//c.add(al);	
		tf = new JTextArea();
		tf.setColumns(100);
		tf.setForeground(Color.black);
		tf.setFont(f1);
		tf.setRows(200);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);
		pane.setBounds(250, 50, 350, 350);
		
		//c.add(pane, BorderLayout.CENTER);
		//c.add(tf);
		setSize(650,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jb)
		{
			
			
			String amount =JOptionPane.showInputDialog("Enter the Power Size");
			String[] csname = { "Select Cloud Server", "CS1", "CS2", "CS3" };
			
			String cloudname = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null,  csname,  csname[0]);
			String ip = JOptionPane.showInputDialog("Enter the Cloud Server Ip Address");
			
			try
			{
			InetAddress ia = InetAddress.getLocalHost();
			String ip1 = ia.getHostAddress();
				
			if(cloudname.equalsIgnoreCase("CS1"))
			{	
				String[] dsname = { "Select the MSP", "MSP1", "MSP2", "MSP3", "MSP4", "MSP5" };
				
				String dataname = (String) JOptionPane.showInputDialog(null,
						"Select the MSP", "MSP Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
			Socket sc = new Socket(ip,801);
			DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
			dout.writeUTF(dataname);
			dout.writeUTF(amount);
			dout.writeUTF(ip1);
			DataInputStream din = new DataInputStream(sc.getInputStream());
			String msg = din.readUTF();
			if(msg.equalsIgnoreCase("Success"))
			{
			 JOptionPane.showMessageDialog(null, "Attack Completed");
			}
			}
			else if(cloudname.equalsIgnoreCase("CS2"))
			{
				String[] dsname = { "Select the MSP", "MSP6", "MSP7", "MSP8", "MSP9", "MSP10" };
				
				String dataname = (String) JOptionPane.showInputDialog(null,
						"Select the MSP", "MSP Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
				Socket sc = new Socket(ip,802);
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				dout.writeUTF(dataname);
				dout.writeUTF(amount);
				dout.writeUTF(ip1);
				DataInputStream din = new DataInputStream(sc.getInputStream());
				String msg = din.readUTF();
				if(msg.equalsIgnoreCase("Success"))
				{
				 JOptionPane.showMessageDialog(null, "Attack Completed");
				}
			}
			
			else if(cloudname.equalsIgnoreCase("CS3"))
			{	
				String[] dsname = { "Select the MSP", "MSP11", "MSP12", "MSP13", "MSP14", "MSP15" };
				
				String dataname = (String) JOptionPane.showInputDialog(null,
						"Select the MSP", "MSP Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
			Socket sc = new Socket(ip,803);
			DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
			dout.writeUTF(dataname);
			dout.writeUTF(amount);
			dout.writeUTF(ip1);
			DataInputStream din = new DataInputStream(sc.getInputStream());
			String msg = din.readUTF();
			if(msg.equalsIgnoreCase("Success"))
			{
			 JOptionPane.showMessageDialog(null, "Attack Completed");
			}
			}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
			
			
		}
		
		
		if(e.getSource()==jb2)
		{
			System.exit(0);
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
				new Attacker();
			}
		});
	}

}
