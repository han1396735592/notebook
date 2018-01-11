package cn.qqhxj.listener;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;

import cn.qqhxj.main.TextEdit;
import cn.qqhxj.main.Utils;

public class NewFileMenuActionListener implements ActionListener{

	private TextEdit textEdit =  null;
	
	public NewFileMenuActionListener(TextEdit textEdit) {
		this.textEdit = textEdit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 如果当前编辑的文本不是null
		System.out.println("NewFileMenuActionListener");
		
		boolean save = textEdit.getSave();
		if(save==false){	
			TextArea editTextArea = textEdit.getEditTextArea();
			String text = editTextArea.getText();
			File editFile = textEdit.getEditFile();
			if(text!=null || text!=""){
				System.out.println("文件需要先保存");		
				if(editFile==null){
					JFrame openJFrame = new JFrame("打开文件");
					// 打开一个文件选择框到新建的窗体中
					FileDialog fileDialog = new FileDialog(openJFrame);
					fileDialog.setMode(FileDialog.SAVE);
					fileDialog.setVisible(true);
					editFile = new File(fileDialog.getDirectory()
							+ File.separator + fileDialog.getFile());
					
				}
				textEdit.setEditFile(editFile);
			}
			System.out.println(editFile);
			Utils.savaTextAreaToFile(editTextArea, editFile);
			textEdit.setSave(true);
			
		}
		textEdit.setEditFile(null);
		textEdit.getEditTextArea().setText(null);
		System.out.println("新建文件成功");
		textEdit.setSave(true);
		

	}
}
