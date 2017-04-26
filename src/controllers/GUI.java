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

public class GUI {

	public static boolean DEBUG_FLAG = true;


	public static boolean isDEBUG() {
		return DEBUG_FLAG;
	}

	
	private JFrame frmHuffmanEncoderdecoder;
	FileIO files = new FileIO();

	String encFileName = null;
	String decFileName = null;

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
		lblChooseFileTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblChooseFileTo.setBounds(28, 9, 106, 14);
		panel.add(lblChooseFileTo);

		JButton btnOpenEncFile = new JButton("Open File");
		btnOpenEncFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser encodeFc = new JFileChooser();
				encodeFc.setCurrentDirectory(new java.io.File("/"));
				encodeFc.setDialogTitle("Choose File");
				encodeFc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				FileNameExtensionFilter encFileFilter = new FileNameExtensionFilter("Text Files", "txt", "TXT");
				encodeFc.addChoosableFileFilter((javax.swing.filechooser.FileFilter) encFileFilter);
				encodeFc.setFileFilter(encFileFilter);

				encodeFc.showOpenDialog(null);
				if (encodeFc.getSelectedFile() != null) {
					File encFile = encodeFc.getSelectedFile();
					encFileName = encFile.getAbsolutePath();

					JTextArea encFileText = new JTextArea();
					encFileText.setBounds(143, 35, 281, 22);
					panel.add(encFileText);
					encFileText.setText(encFileName);
				}

			}
		});
		btnOpenEncFile.setBounds(10, 33, 95, 23);
		panel.add(btnOpenEncFile);

		JLabel lblChooseFileToDecode = new JLabel("Choose file to decode");
		lblChooseFileToDecode.setBounds(28, 140, 104, 14);
		panel.add(lblChooseFileToDecode);

		JButton btnOpenDecFile = new JButton("Open file");
		btnOpenDecFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser decodeFc = new JFileChooser();
				decodeFc.setCurrentDirectory(new java.io.File("/"));
				decodeFc.setDialogTitle("Choose File");
				decodeFc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				decodeFc.showOpenDialog(null);

				FileNameExtensionFilter decFileFilter = new FileNameExtensionFilter("DAT Files", "dat", "DAT");
				decodeFc.addChoosableFileFilter((javax.swing.filechooser.FileFilter) decFileFilter);
				decodeFc.setFileFilter(decFileFilter);
				if (decodeFc.getSelectedFile() != null) {
					File decFile = decodeFc.getSelectedFile();
					decFileName = decFile.getAbsolutePath();

					JTextArea decFileText = new JTextArea();
					decFileText.setBounds(143, 177, 281, 22);
					panel.add(decFileText);
					decFileText.setText(decFileName);
				}

			}
		});
		btnOpenDecFile.setBounds(10, 165, 95, 23);
		panel.add(btnOpenDecFile);

		JButton btnEncode = new JButton("Encode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// call encode method with the filename as param
				try {
					FileIO.textParser(encFileName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});
		btnEncode.setBounds(10, 67, 414, 23);
		panel.add(btnEncode);

		JButton btnDecode = new JButton("Decode");
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call decode method with filename as param

			}
		});
		frmHuffmanEncoderdecoder.getContentPane().setLayout(null);
		btnDecode.setBounds(10, 198, 414, 23);
		panel.add(btnDecode);
		frmHuffmanEncoderdecoder.getContentPane().add(panel);

	}

}
