package assignment5;

import java.io.*;

import javax.swing.JFrame;

import studio4.PrintStreamPanel;

public class ViewOutputStream extends FilterOutputStream {

	final private PrintStreamPanel psp;
	final private PrintStream ps;


	public ViewOutputStream(OutputStream out) {
		super(out);
		JFrame f = new JFrame("ViewOutputStream");
		f.setBounds(100, 100, 225, 300);
		psp = new PrintStreamPanel();
		f.getContentPane().add(psp);
		f.setVisible(true);
		ps = psp.getPrintStream();
	}

	public void write(int a) throws IOException {
		//int x = System.in.read();
		super.write(a);
		String hex = Integer.toHexString(a);
		System.out.println(hex);
		ps.println(hex);

	}

}
