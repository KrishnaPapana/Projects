import java.applet.Applet;  
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList; 
import java.util.List; 

public class stack extends Applet implements ActionListener
{  
	Button push,pop,clear;  
	TextField tf;
	int i=130,j=620,y1=585,y2=588;
	List<Integer> arr = new ArrayList<>();
	public void init()
	{  
		tf=new TextField("      ");  
		tf.setText(null);
		tf.setBounds(90,500,200,200);  
  		push=new Button("push");
  		pop=new Button("pop");
  		clear=new Button("clear");  
		add(clear);
		add(pop);
		add(push);
		add(tf);
  		clear.addActionListener(this);  
		push.addActionListener(this);
		pop.addActionListener(this); 
	}  
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		char ch=str.charAt(0);
		if(str.equals("push"))
		{
			repaint();
			data();
			clearFields();
			topinc();	
		}
		else if(str.equals("pop"))
		{
			removeData();
			topdec();
			repaint();
		}
		else if(str.equals("clear"))
		{
			clearData();
			topcle();
			repaint();
		}
	}
	public void clearData()
	{
		arr.clear();
	}
	public void removeData()
	{
		arr.remove(arr.size()-1);
	}
	public void clearFields()
	{
		tf.setText(null);
	}
	public void data()
	{
		int v1=Integer.parseInt(tf.getText());
       	arr.add(v1);
	}  
	public void topinc()
	{
		y1=y1-30;
		y2=y2-30;
	}
	public void topdec()
	{
		y1=y1+30;
		y2=y2+30;
	}
	public void topcle()
	{
		y1=585;
		y2=588;
	}  
	public void paint(Graphics g)
	{  
		j=590;
		int l=570;
		g.setColor(Color.blue);  
		g.drawString("Welcome To Stack Animation",50, 50);  
    	g.drawLine(80,600,200,600);               
    	g.drawLine(80,600,80,160);                 
    	g.drawLine(200,600,200,160);
    	for(int k=0;k<=13;k++)
    	{
    		g.drawLine(80,l,200,l);
    		l=l-30;	
    	} 	 
    	g.drawLine(50,y1,80,y1);
    	g.drawString("Top",28,y2); 
    	for(int k=0;k<arr.size();k++) 
    	{
    		g.drawString(""+arr.get(k),i, j);
    		j=j-30;
    	}
	}
}  
