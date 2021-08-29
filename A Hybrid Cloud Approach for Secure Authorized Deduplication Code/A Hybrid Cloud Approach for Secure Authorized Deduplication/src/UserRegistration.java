import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.*;
class UserRegistration implements ActionListener
{
JFrame f;
JPanel p;

JLabel l1, l2,l3,l4,l5,l6;

JTextField t1,t2,t5,t6,t3,t4;;



JButton b1,b2;

public UserRegistration()
{
	f = new JFrame("Remote User Registeration::A Hybrid Cloud Approach for Secure Authorized Deduplication");
	p= new JPanel();
	p.setLayout(null);
	
	l1=new JLabel("Name");
	l1.setBounds(50, 50, 100, 20);
	
	l2=new JLabel("Email");
	l2.setBounds(50,80, 100, 20);
	
	l3=new JLabel("phone no");
	l3.setBounds(50, 110, 100, 20);
	
	l4=new JLabel("Company");
	l4.setBounds(50, 140, 100, 20);
	
	l5=new JLabel("address");
	l5.setBounds(50, 170, 100, 20);
	
	l6=new JLabel("City");
	l6.setBounds(50, 200, 100, 20);
	
	t1=new JTextField();
	t1.setBounds(170, 50, 100, 20);
	
	t2=new JTextField();
	t2.setBounds(170, 80, 100, 20);
	
	t3=new JTextField();
	t3.setBounds(170, 110, 100, 20);
	
	t4=new JTextField();
	t4.setBounds(170, 140, 100, 20);
	
	t5=new JTextField();
	t5.setBounds(170, 170, 100, 20);
	
	t6=new JTextField();
	t6.setBounds(170, 200, 100, 20);
	
	
	b1=new JButton("Register");
	b1.setBounds(60, 250, 100, 20);
	
	b2=new JButton("reset");
	b2.setBounds(180, 250, 100, 20);

	p.add(l1);
	p.add(l2);
	p.add(l3);
	p.add(l4);
	p.add(l5);
	p.add(l6);
	
	p.add(t1);
	p.add(t2);
	p.add(t5);
	p.add(t6);
	
	p.add(t3);
	p.add(t4);
	
	p.add(b1);
	p.add(b2);
	
	f.add(p);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
p.setBackground(Color.WHITE);
	f.setSize(400,400);
	f.setVisible(true);
	f.setResizable(false);
	

}

;

public static void main(String[] args)
{
	//UserRegistration  ob =new UserRegistration ();

}

@Override
public void actionPerformed(ActionEvent ae) 
{
	if(ae.getSource()==b1)
	{
		KeyGenerator Generator = new KeyGenerator();

		String name=t1.getText();
		String email=t2.getText();
		String ph=t3.getText();
		String company=t4.getText();
		String address=t5.getText();
		String city=t6.getText();
		
		int pw=Generator.getKeys();
		int n=	t3.getText().length();
		System.out.println(n);
		if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty()||t6.getText().isEmpty())
		{
	
			JOptionPane.showMessageDialog(null, "Enter all the Fields");
			
		}
		if(n==10)
		{
		String ip=JOptionPane.showInputDialog("Enter cloud Ip");
		String owner=JOptionPane.showInputDialog("Enter owner Name");
		String[] csname = { "Select Cloud Server", "CS1", "CS2", "CS3" };
		
		String cloudname = (String) JOptionPane.showInputDialog(null,
				"Select Cloud Server", "CloudName",
				JOptionPane.QUESTION_MESSAGE, null,  csname,  csname[0]);
		
		if(cloudname.equalsIgnoreCase("CS1"))
		{
			
			try
			{
			
			Socket st=new Socket(ip,6789);
			
			DataOutputStream dos=new DataOutputStream(st.getOutputStream());
			dos.writeUTF(name);
			dos.writeUTF(email);
			dos.writeUTF(ph);
			dos.writeUTF(company);
			dos.writeUTF(address);
			dos.writeUTF(city);
			dos.writeInt(pw);
			dos.writeUTF(owner);
			
			DataInputStream din = new DataInputStream(st.getInputStream());
			String res = din.readUTF();
			
			if(res.equalsIgnoreCase("Success"))
			{
				JOptionPane.showMessageDialog(null,"Registered Successfully");
			}
			
			}catch(Exception es){System.out.println(es);
			}
		}
			
		
			
		
			
		if(cloudname.equalsIgnoreCase("CS2"))
		{
		
			try
			{
			
			Socket st=new Socket(ip,6755);
			
			DataOutputStream dos=new DataOutputStream(st.getOutputStream());
			dos.writeUTF(name);
			dos.writeUTF(email);
			dos.writeUTF(ph);
			dos.writeUTF(company);
			dos.writeUTF(address);
			dos.writeUTF(city);
			dos.writeInt(pw);
			dos.writeUTF(owner);
			
			DataInputStream din5 = new DataInputStream(st.getInputStream());
			String res = din5.readUTF();
			
			if(res.equalsIgnoreCase("Success"))
			{
				JOptionPane.showMessageDialog(null,"Registered Successfully");
			}
			
			}catch(Exception es){System.out.println(es);}
		}
		if(cloudname.equalsIgnoreCase("CS3"))
		{
		
			try
			{
			
			Socket st=new Socket(ip,6766);
			
			DataOutputStream dos=new DataOutputStream(st.getOutputStream());
			dos.writeUTF(name);
			dos.writeUTF(email);
			dos.writeUTF(ph);
			dos.writeUTF(company);
			dos.writeUTF(address);
			dos.writeUTF(city);
			dos.writeInt(pw);
			dos.writeUTF(owner);
			
			DataInputStream din5 = new DataInputStream(st.getInputStream());
			String res = din5.readUTF();
			
			if(res.equalsIgnoreCase("Success"))
			{
				JOptionPane.showMessageDialog(null,"Registered Successfully");
			}
			
			}catch(Exception es){System.out.println(es);}
		}
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Mobile no length Exceeded");
}
		
	}
	if(ae.getSource()==b2)
	{
		
		t1.setText(" ");
		t2.setText(" ");;
		t3.setText(" ");
		t4.setText(" ");
		t5.setText(" ");
		t6.setText(" ");
	}
}
}
