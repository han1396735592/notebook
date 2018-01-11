package cn.qqhxj.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.qqhxj.main.TextEdit;

public class exitMenuActionListener implements ActionListener {

	private TextEdit textEdit =null;
		
	public exitMenuActionListener(TextEdit textEdit) {
		super();
		this.textEdit = textEdit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("exitMenuActionListener");
	
		if(textEdit.getSave()==true){
			int n = JOptionPane.showConfirmDialog(null, "确认退出吗?", "确认对话框", JOptionPane.YES_NO_OPTION);   
			if (n == JOptionPane.YES_OPTION) {   
				System.exit(0);
			  
			} 
		}else{
			  JOptionPane.showMessageDialog(new JFrame(),"文件未保存，请先保存文件");  
		}
		
		
		
	}

}
