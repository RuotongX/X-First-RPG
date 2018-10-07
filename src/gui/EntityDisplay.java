package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import start.*;

public class EntityDisplay extends JFrame {
	private JScrollPane scrollPane;
	private JList<Entity> entityList;

	public EntityDisplay(Map m) {

		this.entityList = new JList<Entity>(m.getP().enlist.getentityList());
		this.entityList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(entityList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLocation(15, 15);
		scrollPane.setSize(240, 150);
		this.add(scrollPane);

		this.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1600, 900);
		setResizable(true);
	}

}
