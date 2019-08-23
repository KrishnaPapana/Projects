import java.applet.Applet;  
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList; 
import java.util.List;
import java.util.*;

public class array extends Applet implements ActionListener
{  
	Button insert_beginnig,insert_end,insert_before,delete,clear,sort;  
	TextField tf,tf1,tf2,tf3,tf4;
	int i=93,j=215;
	Label l1,l2;
	ArrayList<Integer> arr = new ArrayList<>();
	public void init()
	{  
		tf=new TextField("      ");
		tf1=new TextField("      ");
		tf2=new TextField("      ");
		tf3=new TextField("      ");
		tf4=new TextField("      ");
		l1=new Label("Element to be inserted :");
		l2=new Label("Element before which new to be inserted :");  
		tf.setText(null);
		tf1.setText(null);
		tf2.setText(null);
		tf3.setText(null);
		tf4.setText(null);  
  		insert_beginnig=new Button("insert_beginnig");
  		insert_end=new Button("insert_end");
  		insert_before=new Button("insert_before");
  		delete=new Button("delete");
  		clear=new Button("clear");
  		sort=new Button("sort");  
		add(clear);
		add(sort);
		add(delete);add(tf1);  
  		add(insert_beginnig);add(tf);
  		add(insert_end);add(tf2);
  		add(insert_before);add(l2);add(tf3);add(l1);add(tf4);
  		clear.addActionListener(this);  
		delete.addActionListener(this);
		insert_beginnig.addActionListener(this);
		insert_end.addActionListener(this);
		insert_before.addActionListener(this);
		sort.addActionListener(this); 
	}  
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		char ch=str.charAt(0);
		if(str.equals("insert_beginnig"))
		{
			repaint();
			data_beginnig();
			clearFields();
		}
		else if(str.equals("insert_end"))
		{
			repaint();
			data_end();
			clearFields();
		}
		else if(str.equals("insert_before"))
		{
			repaint();
			data_before();
			clearFields();
		}
		else if(str.equals("delete"))
		{
			removeData();
			clearFields();
			repaint();
		}
		else if(str.equals("clear"))
		{
			clearData();
			repaint();
		}
		else if(str.equals("sort"))
		{
			sort();
			repaint();
		}
	}
	public void sort()
	{
		Collections.sort(arr);
	}
	public void clearData()
	{
		arr.clear();
	}
	public void removeData()
	{
		int num=Integer.parseInt(tf1.getText());
		boolean ans=arr.contains(num);
		if(ans)
		{
			arr.remove(new Integer(num));	
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null, "The Entered number is not in the array");
		}
	}
	public void clearFields()
	{
		tf.setText(null);
		tf1.setText(null);
		tf2.setText(null);
		tf3.setText(null);
		tf4.setText(null);
	}
	public void data_beginnig()
	{
		int v1=Integer.parseInt(tf.getText());
       	arr.add(0,v1);
	}
	public void data_end()
	{
		int v2=Integer.parseInt(tf2.getText());
       	arr.add(v2);
	}  
	public void data_before()
	{
		int v3=Integer.parseInt(tf4.getText());
		int before=Integer.parseInt(tf3.getText());
		boolean ans=arr.contains(before);
		if(ans)
		{
			int pos=arr.indexOf(before); 
       		arr.add(pos,v3);	
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null, "The entered element is not in the array");	
		}
	}
	public void paint(Graphics g)
	{  
		i=95;
		int l=80;
		g.setColor(Color.blue);  
		g.drawString("Welcome To Array Animation",500, 500);  
    	g.drawLine(80,180,1330,180);
    	g.drawLine(80,240,1330,240);
    	for(int k=0;k<=30;k++)
    	{
    		g.drawLine(l,180,l,240);
    		l=l+50;	
    	} 	 
    	for(int k=0;k<arr.size();k++) 
    	{
    		g.drawString(""+arr.get(k),i, j);
    		i=i+50;
    	}
	}
}  
