import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Insets;
import javax.swing.SwingConstants;
import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class TelaPrincipal {

	private JFrame frmNicescript;
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane scroll;
	private JTextField textField_2;
	private JTextField txtNDaColuna;
	private JLabel colunas;
	private String script;
	private String diretorio;
	private int cont = 0;
	private int i =0;
	private ArrayList<Integer> dadosColuna = new ArrayList<>();
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmNicescript.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNicescript = new JFrame();
		frmNicescript.getContentPane().setName("oi");
		frmNicescript.getContentPane().setFocusable(false);
		frmNicescript.getContentPane().setEnabled(false);
		frmNicescript.getContentPane().setBackground(new Color(6,21,60));
		frmNicescript.getContentPane().setLayout(null);
		
		JLabel lblNicescript = new JLabel("NiceScript");
		lblNicescript.setForeground(Color.WHITE);
		lblNicescript.setFont(new Font("Bahnschrift", Font.PLAIN, 55));
		lblNicescript.setBackground(Color.WHITE);
		lblNicescript.setBounds(new Rectangle(157, 80, 279, 60));
		
		frmNicescript.getContentPane().add(lblNicescript);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Muli", Font.PLAIN, 20));
		textArea.setBounds(130, 361, 1098, 239);
		scroll = new JScrollPane(textArea);
		scroll.setBounds(586, 204, 738, 374);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frmNicescript.getContentPane().add(scroll);
		
		JLabel lblScript = new JLabel("Script Gerado");
		lblScript.setForeground(new Color(112,112,112));
		lblScript.setFont(new Font("Muli", Font.PLAIN, 25));
		lblScript.setBounds(586, 149, 186, 38);
		frmNicescript.getContentPane().add(lblScript);
		
		JButton btnNewButton = new JButton("Associar");
		btnNewButton.setForeground(new Color(92, 87, 87));
		btnNewButton.setFont(new Font("Muli", Font.PLAIN, 18));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(390, 292, 109, 45);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		
		frmNicescript.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFocusable(false);
		textField.setIgnoreRepaint(true);
		textField.setBounds(43, 292, 337, 45);
		textField.setForeground(new Color(173,168,168));
		textField.setFont(new Font("Muli", Font.PLAIN, 15));
		textField.setText("Associar a um Banco de Dados");
		frmNicescript.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Selecione um arquivo");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV e XML", "csv", "xml");
				jfc.addChoosableFileFilter(filter);

				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					diretorio =jfc.getSelectedFile().getPath();
					textField_1.removeAll();
					textField_1.setText(diretorio);
				}
			}
			
		});
		btnImportar.setForeground(new Color(92, 87, 87));
		btnImportar.setFont(new Font("Muli", Font.PLAIN, 18));
		btnImportar.setBackground(Color.WHITE);
		btnImportar.setBounds(390, 207, 109, 45);
		btnImportar.setFocusPainted(false);
		btnImportar.setBorderPainted(false);
		frmNicescript.getContentPane().add(btnImportar);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(173,168,168));
		textField_1.setFont(new Font("Muli", Font.PLAIN, 15));
		textField_1.setText("Importe um arquivo CSV/XLSX");
		textField_1.setIgnoreRepaint(true);
		textField_1.setFocusable(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(43, 207, 337, 45);
		frmNicescript.getContentPane().add(textField_1);
		
		JButton btnApagar = new JButton("Gravar no Banco de Dados");
		btnApagar.setIcon(new ImageIcon("K:\\Faculdade\\Banco de Dados\\Trabalho\\NiceScript\\src\\icons\\icons8-banco-de-dados-24.png"));
		
		btnApagar.setBorder(new LineBorder(new Color(92, 87, 87), 1, true));
		btnApagar.setBounds(1031, 603, 293, 45);
		btnApagar.setForeground(new Color(92, 87, 87));
		btnApagar.setFont(new Font("Muli", Font.PLAIN, 17));
		btnApagar.setBackground(Color.WHITE);
		frmNicescript.getContentPane().add(btnApagar);
		
		JButton btnApagar_1 = new JButton("Apagar");
		btnApagar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < dadosColuna.size(); i++) {
					dadosColuna.remove(i);
				}
				cont = 0;
				textArea.setText("");
			}
		});
		btnApagar_1.setIcon(new ImageIcon("K:\\Faculdade\\Banco de Dados\\Trabalho\\NiceScript\\src\\icons\\garbage.png"));
		btnApagar_1.setMinimumSize(new Dimension(60, 17));
		btnApagar_1.setMaximumSize(new Dimension(60, 17));
		btnApagar_1.setBorder(new LineBorder(new Color(92, 87, 87), 1, true));
		btnApagar_1.setForeground(new Color(92, 87, 87));
		btnApagar_1.setFont(new Font("Muli", Font.PLAIN, 18));
		btnApagar_1.setFocusPainted(false);
		btnApagar_1.setBorderPainted(true);
		btnApagar_1.setBackground(Color.WHITE);
		btnApagar_1.setBounds(725, 603, 120, 45);
		frmNicescript.getContentPane().add(btnApagar_1);
		
		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();  

				ClipboardOwner selection = new StringSelection(textArea.getText());  

				board.setContents((Transferable) selection, selection); 
				
				JOptionPane.showMessageDialog(null, "Script Copiado Com Sucesso");
			}
		});
		btnCopiar.setIcon(new ImageIcon("K:\\Faculdade\\Banco de Dados\\Trabalho\\NiceScript\\src\\icons\\copy-content.png"));
		btnCopiar.setForeground(new Color(92, 87, 87));
		btnCopiar.setBorder(new LineBorder(new Color(92, 87, 87), 1, true));
		btnCopiar.setFont(new Font("Muli", Font.PLAIN, 18));
		btnCopiar.setFocusPainted(false);
		btnCopiar.setBorderPainted(true);
		btnCopiar.setBackground(Color.WHITE);
		btnCopiar.setBounds(586, 603, 120, 45);
		frmNicescript.getContentPane().add(btnCopiar);
		
		textField_2 = new JTextField();
		textField_2.setText("<INSERT INTO?>");
		textField_2.setIgnoreRepaint(true);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(92, 87, 87));
		textField_2.setFont(new Font("Muli", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(43, 417, 456, 45);
		frmNicescript.getContentPane().add(textField_2);
		
		txtNDaColuna = new JTextField();
		txtNDaColuna.setText("N\u00BA da Coluna ");
		txtNDaColuna.setIgnoreRepaint(true);
		txtNDaColuna.setHorizontalAlignment(SwingConstants.CENTER);
		txtNDaColuna.setForeground(new Color(92, 87, 87));
		txtNDaColuna.setFont(new Font("Muli", Font.PLAIN, 15));
		txtNDaColuna.setColumns(10);
		txtNDaColuna.setBounds(43, 501, 337, 45);
		frmNicescript.getContentPane().add(txtNDaColuna);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(txtNDaColuna.getText());
				colunas = new JLabel(""+numero);
				colunas.setForeground(Color.WHITE);
				colunas.setFont(new Font("Muli", Font.PLAIN, 20));
				colunas.setBounds(140 + cont, 547, 101, 31);
				colunas.setVisible(true);
				frmNicescript.getContentPane().add(colunas);
				frmNicescript.repaint();
				cont +=35;
				
				dadosColuna.add(numero);
			}
		});
		btnAdd.setForeground(new Color(92, 87, 87));
		btnAdd.setFont(new Font("Muli", Font.PLAIN, 18));
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(390, 501, 109, 45);
		frmNicescript.getContentPane().add(btnAdd);
		
		JButton btnGerarScript = new JButton("Gerar Script");
		btnGerarScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Sim", "Nao" };
                int escolha = JOptionPane.showOptionDialog(null,
				"Adicionar codigo identificador?", "Confirmação",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				boolean id= false;
				if (escolha == 0) {
					id = true;
				}
				LerCsv c= new LerCsv(dadosColuna, textField_2.getText(), diretorio,id);
				textArea.setText(c.devolveString());
                
			}
		});
		btnGerarScript.setForeground(Color.white);
		btnGerarScript.setFont(new Font("Muli", Font.PLAIN, 17));
		btnGerarScript.setFocusPainted(false);
		btnGerarScript.setBorderPainted(false);
		btnGerarScript.setBackground(new Color(46,86,126));
		btnGerarScript.setBounds(43, 616, 456, 45);
		frmNicescript.getContentPane().add(btnGerarScript);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(544, 0, 822, 731);
		panel.setLayout(null);
		frmNicescript.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("</>");
		lblNewLabel.setForeground(new Color(6,21,60));
		lblNewLabel.setBounds(210, 146, 69, 41);
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 27));
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(6, 21, 60));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(new Color(92, 87, 87));
		textField_3.setFont(new Font("Muli", Font.BOLD, 15));
		textField_3.setBounds(136, 550, 244, 31);
		textField_3.setFocusable(false);
		textField_3.setBorder(new LineBorder(new Color(92, 87, 87), 0, true));
		frmNicescript.getContentPane().add(textField_3);
		
		frmNicescript.setTitle("NiceScript");
		frmNicescript.setSize(1366, 768);
		frmNicescript.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNicescript.setLocationRelativeTo(null);
	}
}
