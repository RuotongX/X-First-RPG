package gui;

import java.awt.Color;
import java.awt.Font;

import start.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GuiRunner extends JFrame{
	public MapDisplay md;
	
	 public void changeP(JPanel changeTo)
	 {
		  this.getContentPane().removeAll();
		  this.getContentPane().add(changeTo);
		  this.repaint();
		  
	 }
	
	public void eventHandleMove(Map m,KeyEvent userInput) {
		
		 if(keyVaildCheck(userInput)) {
			 switch (Character.toUpperCase(userInput.getKeyChar())) {
				case 'W':
					
					m.moveup(m.getFloor());
					
					break;
				case 'S':
					
					m.movedown(m.getFloor());
					break;
				case 'A':
					
					m.moveleft(m.getFloor());
					break;
				case 'D':
					m.moveright(m.getFloor());
					break;
				}
		 }
		
	}
	

	public void eventHandleCheckAbilityDisplay(Map m) {
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		switch (m.getP().ablist.getAbilitylist().length) {
		case 1:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			break;
		case 2:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			b = m.getP().ablist.getAbilitylist()[1].getName();
			break;
		case 3:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			b = m.getP().ablist.getAbilitylist()[1].getName();
			c = m.getP().ablist.getAbilitylist()[2].getName();
			break;
		case 4:
			a = m.getP().ablist.getAbilitylist()[0].getName();
			b = m.getP().ablist.getAbilitylist()[1].getName();
			c = m.getP().ablist.getAbilitylist()[2].getName();
			d = m.getP().ablist.getAbilitylist()[3].getName();
			break;
		}
		
		JOptionPane.showMessageDialog(null, a + "\n" + b + "\n" + c + "\n" + d, "Ability",
				JOptionPane.INFORMATION_MESSAGE);
		
	}
	 private boolean keyVaildCheck(KeyEvent userInput) {
		 return userInput.getKeyChar()=='a'||
				 userInput.getKeyChar()=='s'||
				 userInput.getKeyChar()=='w'||
				 userInput.getKeyChar()=='d'||
				 userInput.getKeyChar()=='A'||
				 userInput.getKeyChar()=='S'||
				 userInput.getKeyChar()=='W'||
				 userInput.getKeyChar()=='D';
	 }

	public GuiRunner(Map m) {
		this.md = new MapDisplay(m, 1);
		this.md.getCheckAbility().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventHandleCheckAbilityDisplay(m);
			}

		});
		this.md.setFocusable(true);
		this.md.addKeyListener(new KeyListener (){
            @Override
            public void keyPressed(KeyEvent e) {
            	
                   eventHandleMove(m,e);
                   md.update(m, 1);
                   changeP(md);
                 
            }
            @Override
            public void keyReleased(KeyEvent e) {
//            	System.out.println("2");
//            	eventHandleMove(m,e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
            
            }
           
        });
		
		this.getContentPane().add(this.md);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1600, 900);
		
		
		

	}
}



// this.md.getCheckAbility().addActionListener(new ActionListener()
// {
// @Override
// public void actionPerformed(ActionEvent e)
// {
//
// }
// });
// }