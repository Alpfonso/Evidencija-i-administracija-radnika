package eiar.GUI_modules;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import eiar.DB_Connect;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;


//import net.miginfocom.swing.MigLayout;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Izvjesce_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField imeIzvjesca;
	private JTable table;
	private JTextField imeIzvjescaInput;
	private JTextField izvjescePrihod;
	private JTextField izvjesceRashod;
	private JTextField izvjesceUkupno;
	private JTable inputTable;
	/**
	 * Create the frame.
	 * @param id 
	 * @throws SQLException 
	 */
	public Izvjesce_GUI(int zaposlenik_id) throws SQLException {
		setTitle("Izvjesca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 666, 393);
		contentPane.add(tabbedPane);
		
		JPanel pregledPanel = new JPanel();
		tabbedPane.addTab("Pregled izvjesca", null, pregledPanel, null);
		pregledPanel.setLayout(null);
		
		JComboBox<String> izvjesceSelect = new JComboBox<String>();

		izvjesceSelect.setBounds(7, 7, 397, 21);
		pregledPanel.add(izvjesceSelect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 87, 394, 119);
		pregledPanel.add(scrollPane);
	    JSONArray jsArray = new JSONArray();
	    
		DefaultTableModel table = new DefaultTableModel();
		JTable tableView = new JTable(table);
		scrollPane.setViewportView(tableView);
		
		imeIzvjesca = new JTextField();
		imeIzvjesca.setEditable(false);
		imeIzvjesca.setBounds(82, 38, 322, 19);
		pregledPanel.add(imeIzvjesca);
		imeIzvjesca.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ime izvjesca");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 38, 96, 21);
		pregledPanel.add(lblNewLabel);
		
		JPanel kreiranjePanel = new JPanel();
		tabbedPane.addTab("Novo izvjesce", null, kreiranjePanel, null);
		kreiranjePanel.setLayout(null);
		
		JPanel izvjescePanel = new JPanel();
		izvjescePanel.setBounds(10, 10, 641, 315);
		kreiranjePanel.add(izvjescePanel);
		izvjescePanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Unos izvjesca");
		lblNewLabel_1.setBounds(0, 0, 391, 13);
		izvjescePanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Ime izvjesca");
		lblNewLabel_2.setBounds(0, 23, 96, 13);
		izvjescePanel.add(lblNewLabel_2);
		
		imeIzvjescaInput = new JTextField();
		imeIzvjescaInput.setBounds(106, 20, 96, 19);
		izvjescePanel.add(imeIzvjescaInput);
		imeIzvjescaInput.setColumns(10);
		
		JComboBox imeProjektaOdabir = new JComboBox();
		imeProjektaOdabir.setBounds(106, 49, 96, 19);
		izvjescePanel.add(imeProjektaOdabir);
		
		JLabel lbl = new JLabel("Pripadni projekt");
		lbl.setBounds(0, 52, 96, 13);
		izvjescePanel.add(lbl);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prihod");
		lblNewLabel_2_1.setBounds(0, 81, 96, 13);
		izvjescePanel.add(lblNewLabel_2_1);
		
		izvjescePrihod = new JTextField();
		izvjescePrihod.setBounds(106, 78, 96, 19);
		izvjescePanel.add(izvjescePrihod);
		izvjescePrihod.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Rashod");
		lblNewLabel_2_1_1.setBounds(0, 107, 96, 13);
		izvjescePanel.add(lblNewLabel_2_1_1);
		
		izvjesceRashod = new JTextField();
		izvjesceRashod.setBounds(106, 104, 96, 19);
		izvjescePanel.add(izvjesceRashod);
		izvjesceRashod.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Ukupno");
		lblNewLabel_2_1_1_1.setBounds(0, 133, 96, 13);
		izvjescePanel.add(lblNewLabel_2_1_1_1);
		
		izvjesceUkupno = new JTextField();
		izvjesceUkupno.setEditable(false);
		izvjesceUkupno.setBounds(106, 130, 96, 19);
		izvjescePanel.add(izvjesceUkupno);
		izvjesceUkupno.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(212, 0, 391, 146);
		izvjescePanel.add(scrollPane_1);
		String column[]={"PROJEKT_ID","PROJEKT_IME","PRIHOD", "RASHOD", "UKUPNO"};
		
		DefaultTableModel tableModel = new DefaultTableModel();
		JTable inputTable = new JTable(tableModel);
		scrollPane_1.setViewportView(inputTable);
		for(int i = 0;i < column.length;i++)
		{
			tableModel.addColumn(column[i]);
			table.addColumn(column[i]);
		}
		DB_Connect db_object = new DB_Connect();
		ResultSet rs = db_object.Fetch_table_data("financijska_izvjesca");
		while(rs.next()) {
			izvjesceSelect.addItem(rs.getString("ime"));
		}
		
		ResultSet rs_init = db_object.Fetch_table_data("financijska_izvjesca", izvjesceSelect.getSelectedItem(), "ime");
		
		String JSON_string = new String();
		try {
			while(rs_init.next()) {
				JSON_string = rs_init.getString("opis");
				imeIzvjesca.setText(rs_init.getString("ime"));
			}
			JSONArray JSON_array_string = new JSONArray();
			JSON_array_string = (JSONArray) JSONValue.parse(JSON_string);
			
			int rowCount = table.getRowCount();
			for (int i = rowCount - 1; i >= 0; i--) {
			    table.removeRow(i);
			}
			
			System.out.println(JSON_array_string.size()/5);
			for(int i = 0, j = 0; i < JSON_array_string.size() / 5;i++) {
				String[] insertion_data = new String[5];
				insertion_data[0] = (String) JSON_array_string.get(j);
				insertion_data[1] = (String) JSON_array_string.get(j+1);
				insertion_data[2] = (String) JSON_array_string.get(j+2);
				insertion_data[3] = (String) JSON_array_string.get(j+3);
				insertion_data[4] = (String) JSON_array_string.get(j+4);
				j+= 5;
				table.insertRow(i, insertion_data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton unesiBtn = new JButton("Unesi podatke");

		unesiBtn.setBounds(10, 159, 192, 21);
		izvjescePanel.add(unesiBtn);
		
		JButton spremi = new JButton("Spremi izvjesce");
		spremi.setBounds(10, 335, 202, 21);
		kreiranjePanel.add(spremi);
		
		JButton potvrdi = new JButton("Potvrdi!");
		potvrdi.setBounds(10, 335, 100, 21);
		kreiranjePanel.add(potvrdi);
		
		JButton ponisti = new JButton("Ponisti");
		ponisti.setBounds(110, 335, 100, 21);
		kreiranjePanel.add(ponisti);
		ponisti.setVisible(false);
		potvrdi.setVisible(false);
		
		ResultSet set_zadaci = db_object.Fetch_table_data("projekti");
		while (set_zadaci.next()) {
				imeProjektaOdabir.addItem(set_zadaci.getString("ime"));
		}
		
		spremi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component component : izvjescePanel.getComponents())
					component.setEnabled(false);
				spremi.setVisible(false);
				potvrdi.setVisible(true);
				ponisti.setVisible(true);
				inputTable.setEnabled(false);
			}
		});
		
		ponisti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component component : izvjescePanel.getComponents())
					component.setEnabled(true);
				spremi.setVisible(true);
				potvrdi.setVisible(false);
				ponisti.setVisible(false);
				inputTable.setEnabled(true);
			}
		});
		
		unesiBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] inputTableData = new String[5]; 
				DB_Connect db_object = new DB_Connect();
				String data_fetch_var = imeProjektaOdabir.getSelectedItem().toString();
				
				ResultSet set_zadaci = db_object.Fetch_table_data("projekti", data_fetch_var, "ime");
				String proj_id = null;
				String proj_name = null;
				try {
					while(set_zadaci.next()) {
						proj_id = set_zadaci.getString("id");
						proj_name = set_zadaci.getString("ime");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				inputTableData[0] = proj_id;
				inputTableData[1] = proj_name;
				inputTableData[2] = izvjescePrihod.getText();
				inputTableData[3] = izvjesceRashod.getText();
				Double ukupno_int = Double.parseDouble(inputTableData[2]) - Double.parseDouble(inputTableData[3]);
				inputTableData[4] = Double.toString(ukupno_int);
				
				tableModel.insertRow(0, inputTableData);
			}
		});
		
		potvrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DB_Connect db_object = new DB_Connect();
				String[] attributes = {"ime", "autor", "opis", "vrijeme_kreiranja"};
				
				tabbedPane.setSelectedComponent(pregledPanel);
				
				try {
					ResultSet set_zadaci = db_object.Fetch_table_data("projekti");
					while (set_zadaci.next()) {
							imeProjektaOdabir.addItem(set_zadaci.getString("ime"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[][] input_array_data = new String[tableModel.getRowCount()][5];
				for(int i = 0;i < tableModel.getRowCount();i++) {
					for(int j = 0;j < tableModel.getColumnCount();j++) {
						input_array_data[i][j] = (String) tableModel.getValueAt(i, j);
					}
				}
			    JSONArray inputArrayJSON = new JSONArray();
			    for(int i = 0;i < input_array_data.length; i++) {
			    	for(int j = 0;j < input_array_data[i].length;j++) {
			    		inputArrayJSON.add(input_array_data[i][j]);
			    	}
			    }
			    
				Object[] input_data = {imeIzvjescaInput.getText(), zaposlenik_id, inputArrayJSON, LocalDate.now()};
				db_object.Insert_table_data(attributes, input_data, "financijska_izvjesca");
				
				
			}
		});
		
		izvjesceSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ResultSet rs = db_object.Fetch_table_data("financijska_izvjesca", izvjesceSelect.getSelectedItem(), "ime");
				String JSON_string = new String();
				try {
					imeIzvjesca.setText(rs.getString("ime"));
					while(rs.next()) {
						JSON_string = rs.getString("opis");
					}
					JSONArray JSON_array_string = new JSONArray();
					JSON_array_string = (JSONArray) JSONValue.parse(JSON_string);
					
					int rowCount = table.getRowCount();
					for (int i = rowCount - 1; i >= 0; i--) {
					    table.removeRow(i);
					}
					
					System.out.println(JSON_array_string.size()/5);
					for(int i = 0, j = 0; i < JSON_array_string.size() / 5;i++) {
						String[] insertion_data = new String[5];
						insertion_data[0] = (String) JSON_array_string.get(j);
						insertion_data[1] = (String) JSON_array_string.get(j+1);
						insertion_data[2] = (String) JSON_array_string.get(j+2);
						insertion_data[3] = (String) JSON_array_string.get(j+3);
						insertion_data[4] = (String) JSON_array_string.get(j+4);
						j+= 5;
						table.insertRow(i, insertion_data);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		/*
		DB_Connect db_object = new DB_Connect();
		ResultSet set_zadaci = db_object.Fetch_table_data("zadaci", zaposlenik_id, "zadano_zaposleniku");
		while (set_zadaci.next()) {
				imeIzvjesca.setText(set_zadaci.getString("ime"));
				opisIzvjesca.setText(set_zadaci.getString("opis"));
				izvjesceSelect.addItem(set_zadaci.getString("ime"));
		}*/
	}
}
