import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class main extends JFrame {
	private JLabel verseLabel;
	private static JTextField verseTextField;
	private JButton saveButton;
	private JComboBox<String> rootsComboBox;
	private JComboBox<String> wordsComboBox;
	private JButton tokenizeButton;
	private static DefaultTableModel tableModel;

	public main() throws IOException {
// First Section
		verseLabel = new JLabel("Verse:");
		verseTextField = new JTextField();
		saveButton = new JButton("Save");
		JPanel firstSectionPanel = new JPanel();
		firstSectionPanel.setLayout(new GridLayout(2, 2));
		firstSectionPanel.add(verseLabel);
		firstSectionPanel.add(verseTextField);
		firstSectionPanel.add(saveButton);
// Second Section
		String[] roots = readRootsFromFile();
		rootsComboBox = new JComboBox<>(roots);
		JPanel secondSectionPanel = new JPanel();
		secondSectionPanel.add(new JLabel("Roots:"));
		secondSectionPanel.add(rootsComboBox);
		String[] words = readWordsFromFile();
		wordsComboBox = new JComboBox<>(words);
		secondSectionPanel.add(new JLabel("Words:"));
		secondSectionPanel.add(wordsComboBox);
		tableModel = new DefaultTableModel();
		JTable dataTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(dataTable);
		scrollPane.setBounds(10, 180, 50, 50);
		tableModel.addColumn("Word");
		tableModel.addColumn("Root");
// Third Section
		tokenizeButton = new JButton("Tokenize");
		JPanel thirdSectionPanel = new JPanel();
		thirdSectionPanel.add(tokenizeButton);
// Add action listeners to buttons
		thirdSectionPanel.add(scrollPane);
// Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 1));
		mainPanel.add(firstSectionPanel);
		mainPanel.add(secondSectionPanel);
		mainPanel.add(thirdSectionPanel);
		getContentPane().add(mainPanel);
		setTitle("My GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 500);
		setVisible(true);
	}

	private static String[] readRootsFromFile() throws IOException {
		String[] arr={"none"};
		return arr;
	}

	private static String[] readWordsFromFile() throws IOException {
		String[] arr={"none"};
		return arr;
	}

	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(() -> {
			try {
				new main();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
