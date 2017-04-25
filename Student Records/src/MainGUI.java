import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


/**
 * @authors Gabriel, Ryan Wheeler, Aidan Hubert, Daniel Silva, Jose??
 *
 */
public class MainGUI extends JFrame
{
	
	///////////////////////////////////////////////////////////////////////////////////
	//Attributes
	///////////////////////////////////////////////////////////////////////////////////
	private JPanel contentPane;
	private JTextField searchBox;
	private String[] catagoryHeader = {"ID Number", "First", "Last", ""};
	private String[] searchCatagories = {"By First Name","By Last Name","By ID Number"};
	private static final JFileChooser fc = new JFileChooser();
	Object[][] datao;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton addNewButton;
	private JPanel bottomTopPanel;
	private JPanel topTopPanel;
	private JPanel topPanel;
	private JComboBox comboBox;
	private JButton searchButton;
	private JButton saveDatabaseButton;
	private JButton openDatabaseButton;
	private ArrayList<Person> currentList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
				
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI()
	{
		Integer n = openOptionDialog(new JFrame());
		processOption(n);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			topPanel = new JPanel();
			topPanel.setBorder(null);
			contentPane.add(topPanel, BorderLayout.NORTH);
			topPanel.setLayout(new BorderLayout(0, 0));
			
			topTopPanel = new JPanel();
			topPanel.add(topTopPanel, BorderLayout.NORTH);
			topTopPanel.setLayout(new BorderLayout(0, 0));
			
			openDatabaseButton = new JButton("Open Another Database");
			topTopPanel.add(openDatabaseButton, BorderLayout.WEST);
			
			saveDatabaseButton = new JButton("Save Database");
			saveDatabaseButton.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					if(saveDatabaseButton.isEnabled())
					{
						try 
						{
							LookupEdit.createFile(openFileChooser().toString(), LookupEdit.students);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
			topTopPanel.add(saveDatabaseButton, BorderLayout.EAST);
			openDatabaseButton.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent arg0) {
					processOption(openOptionDialog(new JFrame()));
				}
			});
			
			bottomTopPanel = new JPanel();
			topPanel.add(bottomTopPanel, BorderLayout.SOUTH);
			
			addNewButton = new JButton("Add New");
			bottomTopPanel.add(addNewButton);
			//
			searchBox = new JTextField();
			bottomTopPanel.add(searchBox);
			searchBox.setColumns(25);
			
			comboBox = new JComboBox(searchCatagories);
			bottomTopPanel.add(comboBox);
			
			searchButton = new JButton("Search");
			searchButton.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					processSearch();
					
				}
			});
			bottomTopPanel.add(searchButton);
			addNewButton.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					if(addNewButton.isEnabled())
					{
						LookupEdit.addStudent();
						datao = getFormattedList(LookupEdit.students);
						tableModel = new DefaultTableModel(datao,catagoryHeader);
						table.setModel(tableModel);
					}
				}
			});
			
			scrollPane = new JScrollPane();
			contentPane.add(scrollPane, BorderLayout.CENTER);
			table = new JTable();
			table.putClientProperty("terminateEditOnFocusLost", true);
			updateTable();
			scrollPane.setViewportView(table);
			addNewButton.setEnabled(n != 1);
			saveDatabaseButton.setEnabled(n != 1);

	}
	
	/**
	 * This method receives input from the initial JOptionPane that is prompted
	 * when the program is ran.
	 * @param n
	 * @see openOptionDialog()
	 */
	public void processOption(int n)
	{
		switch(n)
		{
		case 0:
			try
			{					
				currentList = Person.reader();
			}catch(Exception e){break;}
				catagoryHeader[3] = "GPA";
				datao = getFormattedList(currentList);
				LookupEdit.students = currentList;			
			break;
		case 1:
			try
			{	 
				currentList = Teacher.reader();
				System.out.println("win1");
			}catch(Exception e){
				currentList = null;
				JOptionPane.showMessageDialog(new JFrame(), "Cannot Find Teacher Database File");
				break;
				}
				catagoryHeader[3] = "Class";
				datao = getFormattedList(currentList);
			break;
		case 2:
			System.exit(0);
		default:
			datao = new Object[1][4];
			datao[0][0] = "";
			datao[0][1] = "";
			datao[0][2] = "";
			datao[0][3] = "";
			break;
		}
		updateTable();
		try{addNewButton.setEnabled(n != 1);saveDatabaseButton.setEnabled(n != 1);}catch(Exception e){}
	}
	public void processSearch()
	{
		switch(comboBox.getSelectedIndex())
		{
		case 0:
			datao = getFormattedList(LookupEdit.searchFirstName(currentList, searchBox.getText()));
			break;
		case 1:
			datao = getFormattedList(LookupEdit.searchLastName(currentList, searchBox.getText()));			
			break;
		case 2:
			datao = getFormattedList(LookupEdit.searchSNumber(currentList,searchBox.getText()));			
			break;
		default:
			break;
		}
		updateTable();
	}
	
	/**
	 * Creates the JOptionPane that asks the user whether they want to open
	 * an existing database, open up the teacher database or quit. If the user 
	 * chooses quit.
	 * 
	 * @param frame
	 * @return
	 */
	public static int openOptionDialog(JFrame frame)
	{
		Object[] options = {"Open Existing Student Database",
                "Open Teacher Database",
                "Quit"};
		int n = JOptionPane.showOptionDialog(frame,
		"Please select an option"
		+ "",
		"",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[2]);
		
		return n;
	}
	
	/**
	 * This method creates the file chooser so the end user can
	 * select a file to upload it to the database.
	 * 
	 * @return
	 */
	public static File openFileChooser()
	{
		int returnVal = fc.showOpenDialog(new JFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION) 
            return fc.getSelectedFile();
		else 
			return new File("");
	}
	
	/**
	 * Creates the input field for the dialog prompt.
	 * 
	 * @param prompt
	 * @return
	 */
	public static String openInputField(String prompt)
	{
		return JOptionPane.showInputDialog(prompt);
	}
	
	public void updateTable()
	{
		try
		{
			tableModel = new DefaultTableModel(datao,catagoryHeader);
			table.setModel(tableModel);
		}catch(NullPointerException e){}
	}
	
	/**
	 * 
	 * @param list
	 * 	The list of people to be formatted for display
	 * @return Returns a multi-dimensional array of Objects so the table can display the list
	 */
	public static Object[][] getFormattedList(ArrayList<Person> list)
	{
		Object[][] objects = new Object[list.size()][]; 
		for(Person current : list)
		{
			objects[list.indexOf(current)] = current.toStringArray();
			System.out.println("Read in person: " + Arrays.toString(objects[list.indexOf(current)]));
			
		}
		return objects;
	}

}
