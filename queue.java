import java.applet.Applet;  
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList; 
import java.util.List; 

public class queue extends Applet implements ActionListener
{  
	Button enqueue,dequeue,clear;  
	TextField tf;
	int i=130,j=620,y1=615,y2=618,cnt=0;
	List<Integer> arr = new ArrayList<>();
	public void init()
	{  
		tf=new TextField("      ");  
		tf.setText(null);
		tf.setBounds(90,500,200,200);  
  		enqueue=new Button("enqueue");
  		dequeue=new Button("dequeue");
  		clear=new Button("clear");  
		add(clear);
		add(dequeue);  
  		add(enqueue);add(tf);
  		clear.addActionListener(this);  
		enqueue.addActionListener(this);
		dequeue.addActionListener(this); 
	}  
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		char ch=str.charAt(0);
		if(str.equals("enqueue"))
		{
			repaint();
			data();
			clearFields();
			frontinc();	
		}
		else if(str.equals("dequeue"))
		{
			removeData();
			frontdec();
			repaint();
		}
		else if(str.equals("clear"))
		{
			clearData();
			frontcle();
			repaint();
		}
	}
	public void clearData()
	{
		arr.clear();
	}
	public void removeData()
	{
		arr.remove(0);
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
	public void frontinc()
	{
		y1=y1-30;
		y2=y2-30;
	}
	public void frontdec()
	{
		y1=y1+30;
		y2=y2+30;
	}
	public void frontcle()
	{
		y1=615;
		y2=618;
	}  
	public void paint(Graphics g)
	{  
		j=590;
		int l=570;
		g.setColor(Color.blue);  
		g.drawString("Welcome To Queue Animation",50, 50);  
    	g.drawLine(80,600,200,600);               
    	g.drawLine(80,600,80,160);                 
    	g.drawLine(200,600,200,160);
    	for(int k=0;k<=13;k++)
    	{
    		g.drawLine(80,l,200,l);
    		l=l-30;	
    	}
    	if(cnt>3)
    	{
    		g.drawLine(50,y1,80,y1);
    		g.drawString("Front",20,y2);
    	} 	 
    	g.drawLine(200,585,230,585);
    	g.drawString("Rear",233,588); 
    	for(int k=arr.size()-1;k>=0;k--) 
    	{
    		g.drawString(""+arr.get(k),i, j);
    		j=j-30;
    	}
    	cnt=cnt+1;
	}
}  
