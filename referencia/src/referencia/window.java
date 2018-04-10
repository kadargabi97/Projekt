package referencia;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.util.Random;

public class window extends JFrame implements ActionListener{
	private JButton gomb;
	private JLabel szoveg,eredmeny;
	private JTextField tipp;
	private JPanel alap, also, kozepso_tipp,felso, also_eredmeny;
	private BorderLayout bl;
	private FlowLayout fl;
	private int szam;
	public window() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,150);
		this.setTitle("Tippelõs Játék");
		bl= new BorderLayout();
		alap = (JPanel) this.getContentPane();
		alap.setLayout(bl);
		
		felso = new JPanel();
		also = new JPanel();
		kozepso_tipp = new JPanel();
		also_eredmeny = new JPanel();
		fl = new FlowLayout();
		also.setLayout(fl);
		
		szoveg = new JLabel("Adja meg a tippjét 1 és 100 között");
		add(szoveg);
		tipp = new JTextField(10);
		tipp.setToolTipText("Egész számot adjon meg!");
		eredmeny = new JLabel("");
		Random r = new Random();
		szam = r.nextInt(100);
		szam++;
		//eredmeny.setText(""+szam);    GENERALT SZAM KIJELZÉSE
		gomb = new JButton("Tippelek");
		gomb.addActionListener(this);
		also.add(gomb); 
		felso.add(szoveg);
		felso.add(tipp);
		also_eredmeny.add(eredmeny);
		alap.add(felso,BorderLayout.PAGE_START);
		
		alap.add(also_eredmeny,BorderLayout.CENTER);
		alap.add(also,BorderLayout.PAGE_END);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(gomb.getText().equals("Új játék")) {
			dispose();
			window w = new window();
			w.setVisible(true);
		}else {
			if(Integer.parseInt(tipp.getText())>szam) {
				eredmeny.setText("Kisebbet");
			}else if(Integer.parseInt(tipp.getText())<szam){
				eredmeny.setText("Nagyobat");
			}else {
				eredmeny.setText("Talalt");
				gomb.setText("Új játék");
				
			}
		}
		
	}

}
