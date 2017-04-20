import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String[] catagoryHeader = {"S Number", "First", "Last", "Class"};
	
	private static final JFileChooser fc = new JFileChooser();
	private File openFile;
	Object[][] datao;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAddNew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		//Integer n = testDialog(new JFrame());
		//processOption(n);
		datao = new Object[1][4];
		datao[0][0] = "";
		datao[0][1] = "";
		datao[0][2] = "";
		datao[0][3] = "";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel topPanel = new JPanel();
			topPanel.setBorder(null);
			contentPane.add(topPanel, BorderLayout.NORTH);
			
			btnAddNew = new JButton("Add New");
			topPanel.add(btnAddNew);
			//
			textField = new JTextField();
			topPanel.add(textField);			
			textField.setColumns(25);
			
			JButton searchButton = new JButton("New button");
			searchButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
	
				}
			});
			topPanel.add(searchButton);
			
			scrollPane = new JScrollPane();
			contentPane.add(scrollPane, BorderLayout.CENTER);
			table = new JTable(datao,catagoryHeader);
			scrollPane.setViewportView(table);

	}
	
	public void processOption(int n)
	{
		switch(n)
		{
		case 0:
			openFile = openFileChooser(); 
			this.setTitle(openFile.toString());
			break;
		case 1:
			ArrayList<Person> people;
			try{	 people = new Teacher().reader();
			System.out.println("win1");
			}catch(Exception e){people = null;}
			datao = getFormattedList(people);
			break;
		case 2:
			//System.exit(0);
			//break;
		default:
			datao = new Object[1][4];
			datao[0][0] = "";
			datao[0][1] = "";
			datao[0][2] = "";
			datao[0][3] = "";
			break;
		}
	}
	
	public int testDialog(JFrame frame)
	{
		Object[] options = {"Open Existing Database",
                "Open Teacher Database",
                "Quit"};
		int n = JOptionPane.showOptionDialog(frame,
		"Would you like some green eggs to go "
		+ "with that ham?",
		"A Silly Question",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[2]);
		
		return n;
	}
	
	public static File openFileChooser()
	{
		int returnVal = fc.showOpenDialog(new JFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION) 
            return fc.getSelectedFile();
		else 
			return new File("");
	}
	
	public static Object[][] getFormattedList(ArrayList<Person> list)
	{
		Object[][] objects = new Object[list.size()][]; 
		for(Person current : list)
		{
			objects[list.indexOf(current)] = current.toStringArray();
			System.out.println("Read in person: " + Arrays.toString(objects[list.indexOf(current)]));
			
		}
		System.out.println("win");
		//System.out.println(objects);
		return objects;
	}

}
