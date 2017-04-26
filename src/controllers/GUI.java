package controllers;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import utils.FileIO;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Panel;
import java.awt.FlowLayout;

public class GUI {

	public static boolean DEBUG_FLAG = true;


	public static boolean isDEBUG() {
		return DEBUG_FLAG;
	}

	
	private JFrame frmHuffmanEncoderdecoder;
	FileIO files = new FileIO();

	String encFileName = null;
	String decFileName = null;
	File encFile;
	File decFile;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmHuffmanEncoderdecoder.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHuffmanEncoderdecoder = new JFrame();
		frmHuffmanEncoderdecoder.setTitle("Huffman encoder/decoder");
		frmHuffmanEncoderdecoder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHuffmanEncoderdecoder.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		panel.setLayout(null);

		// Start of encode section
		JLabel lblChooseFileTo = new JLabel("Choose File to encode");
		lblChooseFileTo.setBounds(10, 33, 106, 14);
		lblChooseFileTo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblChooseFileTo);

		JButton btnOpenEncFile = new JButton("Open and encode file");
		btnOpenEncFile.setBounds(10, 58, 414, 23);
		btnOpenEncFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser encodeFc = new JFileChooser();
				encodeFc.setCurrentDirectory(new java.io.File("C:/Users/"));
				encodeFc.setDialogTitle("Choose File");
				encodeFc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				FileNameExtensionFilter encFileFilter = new FileNameExtensionFilter("Text Files", "txt");
//				encodeFc.addChoosableFileFilter((javax.swing.filechooser.FileFilter) encFileFilter);
//				encodeFc.setFileFilter(encFileFilter);

				encodeFc.showOpenDialog(null);
				if (encodeFc.getSelectedFile() != null) {
					

					//encFileName = encFile.getAbsolutePath();

					JTextArea encFileText = new JTextArea();
					encFileText.setBounds(143, 35, 281, 22);
					panel.add(encFileText);
					File encFile = encodeFc.getSelectedFile();

					encFileText.setText(encFileName);
					try {
						FileIO.textParser(encFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnOpenEncFile);

		JLabel lblChooseFileToDecode = new JLabel("Choose file to decode");
		lblChooseFileToDecode.setBounds(12, 151, 104, 14);
		panel.add(lblChooseFileToDecode);

		JButton btnOpenDecFile = new JButton("Open and decode file");
		btnOpenDecFile.setBounds(10, 176, 414, 23);
		btnOpenDecFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser decodeFc = new JFileChooser();
				decodeFc.setCurrentDirectory(new java.io.File(""));
				decodeFc.setDialogTitle("Choose File");
				decodeFc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				decodeFc.showOpenDialog(null);

				FileNameExtensionFilter decFileFilter = new FileNameExtensionFilter("DAT Files", "dat", "DAT");
				decodeFc.addChoosableFileFilter((javax.swing.filechooser.FileFilter) decFileFilter);
				decodeFc.setFileFilter(decFileFilter);
				if (decodeFc.getSelectedFile() != null) {
					File decFile = decodeFc.getSelectedFile();
					decFileName = decFile.getName();

					JTextArea decFileText = new JTextArea();
					decFileText.setBounds(143, 177, 281, 22);
					panel.add(decFileText);
					decFileText.setText(decFileName);
					
					FileIO.binaryIn(decFile);
				}

			}
		});
		panel.add(btnOpenDecFile);
		frmHuffmanEncoderdecoder.getContentPane().setLayout(null);
		frmHuffmanEncoderdecoder.getContentPane().add(panel);

		
	}
}
