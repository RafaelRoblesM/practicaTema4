package es.studium.BlocDeNotas;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BlocDeNotas extends Frame implements WindowListener,
ActionListener
{

	private static final long serialVersionUID = 1L;
	MenuBar mnbMenu = new MenuBar();
	Menu mn1 = new Menu("Archivo");
	Menu mn2 = new Menu("Gestion");
	MenuItem mn11 = new MenuItem("Nuevo");
	MenuItem mn12 = new MenuItem("Abrir");
	MenuItem mn13 = new MenuItem("Guardar");
	MenuItem mn14 = new MenuItem("Salir");
	MenuItem mn22 = new MenuItem("Contar palabras");
	MenuItem mn23 = new MenuItem("Contar Letras");
	MenuItem mn24 = new MenuItem("Contar Vocales");
	TextArea TA = new TextArea("");
	Dialog dlg = new Dialog(this, "Diálogo con mensaje", true);
	
	public BlocDeNotas()
	{
		setTitle("Bloc De Notas");
		setLayout(new GridLayout());
		//texto
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		constraints.weighty = 1.0;
		constraints.weighty = 1.0;
		add (TA, constraints);
		//menu
		mn1.add(mn11);
		mn1.add(mn12);
		mn1.add(mn13);
		mn1.addSeparator();
		mn1.add(mn14);
		mn2.add(mn22);
		mn2.add(mn23);
		mn2.add(mn24);
		mnbMenu.add(mn1);
		mnbMenu.add(mn2);
		setMenuBar(mnbMenu);
		mn11.addActionListener(this);
		mn12.addActionListener(this);
		mn13.addActionListener(this);
		mn14.addActionListener(this);
		mn22.addActionListener(this);
		mn23.addActionListener(this);
		mn24.addActionListener(this);
		//fin menu
		addWindowListener(this);
		setLocationRelativeTo(null);
		setSize(550,250);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new BlocDeNotas();
	}
	//menu funciones
	public void actionPerformed(ActionEvent ae)
	{
		Object a;
		a=ae.getSource();
		if(a.equals(mn14))
		{
			System.exit(0);
		}
		if(a.equals(mn11))
		{
			TA.selectAll();
			TA.setText("");
		}
		if(a.equals(mn12))
		{
			FileDialog fd = new FileDialog(this, "Seleccionar archivo", FileDialog.LOAD);
			fd.setFile("*.txt");
			fd.setVisible(true);
			String filename = fd.getDirectory()+fd.getFile();
			if (filename == "")
			{
				dlg.setVisible(false);
				dlg.setLayout(new FlowLayout());
				dlg.setSize(200,150);
				dlg.addWindowListener(this);
			}
			else
			{
				try 
				{
					BufferedReader entrada = new BufferedReader(new FileReader(filename));
					String s;
					TA.selectAll();
					TA.setText("");
					while((s=entrada.readLine())!=null)
					{
						TA.append(s);
						TA.append("\n");
					}
					entrada.close();
				}
				catch(IOException i)
				{
					System.out.println("se ha producido un error");
				}
			}
		}
		if(a.equals(mn13))
		{
			FileDialog fd = new FileDialog(this, "Indicar nombre y ubicación del archivo", FileDialog.SAVE);
					fd.setVisible(true); 
		}
	}
	public void windowActivated(WindowEvent we) {}
	public void windowClosed(WindowEvent we) {}
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent we) {}
	public void windowDeiconified(WindowEvent we) {}
	public void windowIconified(WindowEvent we) {}
	public void windowOpened(WindowEvent we) {}
}
//local a server