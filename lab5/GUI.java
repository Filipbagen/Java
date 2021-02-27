package lab5;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener, KeyListener {
	
	private PhoneBook phoneBook;
	private Font myFont;
	private JButton load, save, search, next, add, delete;
	private JPanel panelButton, panelText;
	JTextField searchField, nameField, numberField;
//	private JLabel nameField, numberField;
	private int person;
	private ArrayList<Person> result;
	
	public GUI() {
		
		phoneBook = new PhoneBook();
		
		setTitle("Interactive phone book");
		myFont = new Font("Futura", Font.PLAIN, 20);
		
		// Buttons
		load = new JButton("Load Phonebook");
		load.setFont(myFont);
		load.setEnabled(true);
		load.addActionListener(this);
		load.setEnabled(true);
		
		save = new JButton("Save Phonebook");
		save.setFont(myFont);
		save.setEnabled(true);
		save.addActionListener(this);
		save.setEnabled(false);
		
		search = new JButton("Search");
		search.setFont(myFont);
		search.setEnabled(true);
		search.addActionListener(this);
		search.setEnabled(false);
		
		next = new JButton("Next name");
		next.setFont(myFont);
		next.setEnabled(true);
		next.addActionListener(this);
		next.setEnabled(false);
		
		add = new JButton("Add person");
		add.setFont(myFont);
		add.setEnabled(true);
		add.addActionListener(this);
		add.setEnabled(false);
		
		delete = new JButton("Delete person");
		delete.setFont(myFont);
		delete.setEnabled(true);
		delete.addActionListener(this);
		delete.setEnabled(false);
		
		searchField = new JTextField();
		searchField.setFont(myFont);
		searchField.addActionListener(this);
		searchField.addKeyListener(this);
		
		nameField = new JTextField();
		nameField.setFont(myFont);
		nameField.setEnabled(false);
		
		numberField = new JTextField();
		numberField.setFont(myFont);
		numberField.setEnabled(false);
		
		panelButton = new JPanel(new GridLayout(3, 2));
		panelButton.add(load);
		panelButton.add(save);
		panelButton.add(search);
		panelButton.add(next);
		panelButton.add(add);
		panelButton.add(delete);
		
		panelText = new JPanel(new GridLayout(3, 1));
		panelText.add(searchField);
		panelText.add(nameField);
		panelText.add(numberField);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 2));
		c.add(panelButton);
		c.add(panelText);
		c.setBackground(Color.WHITE);
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			load.doClick();
		}
		
	}

	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
	
	
	public void actionPerformed(ActionEvent e) {
		
		// Click load
		if (e.getSource().equals(load)) { // Or press enter
			String file = phoneBook.load(searchField.getText());
			searchField.setText("");
			
			if(file.equals("Phone book loaded")) {
				nameField.setText("Phone book loaded");
				
				load.setEnabled(true);
				save.setEnabled(true);
				search.setEnabled(true);
				add.setEnabled(true);
				delete.setEnabled(true);
				
			} else {
				nameField.setText("Try again");
			}	
		}
		
		
		// Click save
		if (e.getSource().equals(save)) {
			String filename = searchField.getText();	
			searchField.setText("");
		
			if (filename.isEmpty() || !filename.contains(".txt") || filename.contains(" ")) {
				nameField.setText("Provide a valid file name");
				
			} else {
				String file = phoneBook.save(filename);
				nameField.setText(file);
			}
		}
		
		
		// Click search
		if (e.getSource().equals(search)) {
			String searchInput = searchField.getText();
			searchField.setText("");
			
			result = phoneBook.search(searchInput);
			
			if (result.size() == 0) {
				nameField.setText("Provide a name");
				numberField.setText("");
				
			} else if (result.size() == 1) {
				nameField.setText(result.get(0).getFullName());
				numberField.setText(String.valueOf(result.get(0).getPhoneNumber()));
				
			} else if (result.size() > 1) {
				person = 0;
				next.setEnabled(true);
				nameField.setText(result.get(person).getFullName());
				numberField.setText(String.valueOf(result.get(person).getPhoneNumber()));
			}
		}
		
		

		// Click next
		if (e.getSource().equals(next)) {
			person++;
			nameField.setText(result.get(person).getFullName());
			numberField.setText(String.valueOf(result.get(person).getPhoneNumber()));
			
			if (person == result.size() - 1) {
				person = 0;
				next.setEnabled(false);
			}
		}
		
		
		// Click delete
		if (e.getSource().equals(delete)) { // Error with numbers
			
			if (nameField.getText().isEmpty() || numberField.getText().isEmpty()) {
				searchField.setText("Provide name and number");
				nameField.setEnabled(true);
				numberField.setEnabled(true);
				nameField.setText("");
				numberField.setText("");
				
			} else {
				String deletedPerson = nameField.getText();
				int number = Integer.parseInt(numberField.getText());
				
				String result = phoneBook.deletePerson(deletedPerson, number);
				searchField.setText(result);
				nameField.setText("");
				numberField.setText("");
				nameField.setEnabled(false);
				numberField.setEnabled(false);
			}
		}
		
		
		// Click add
		if (e.getSource().equals(add)) {
			
			if (!nameField.isEnabled() && !numberField.isEnabled()) {
				searchField.setEnabled(false);
				searchField.setText("Type in the name and phone number");
				nameField.setText("");
				numberField.setText("");
				nameField.setEnabled(true);
				numberField.setEnabled(true);
				
			} else if (!nameField.getText().isEmpty() && !numberField.getText().isEmpty()) {
					
				if (phoneBook.addPerson(nameField.getText(), Integer.parseInt(numberField.getText()))) {
					searchField.setText("Person added");
					nameField.setText("");
					numberField.setText("");
					
					searchField.setEnabled(true);
					nameField.setEnabled(false);
					numberField.setEnabled(false);
					
				} else {
					searchField.setText("Number already exists");
				}
				
			} else {
				searchField.setText("Type in the name and phone number");
				nameField.setEnabled(true);
				numberField.setEnabled(true);
			}
		}
			
	}
	
	
	
	public static void main(String[] args) {
		new GUI();
		
		StringSelection selection = new StringSelection("PhoneList.txt");
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(selection, selection);
	    
//	    System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}


}
