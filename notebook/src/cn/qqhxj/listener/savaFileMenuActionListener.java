package cn.qqhxj.listener;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.qqhxj.main.TextEdit;
import cn.qqhxj.main.Utils;

public class savaFileMenuActionListener implements ActionListener {

	private TextEdit textEdit = null;

	public savaFileMenuActionListener(TextEdit textEdit) {
		super();
		this.textEdit = textEdit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("savaFileMenuActionListener");

		TextArea editTextArea = textEdit.getEditTextArea();

		String text = editTextArea.getText();
		if (text != null && text != "") {
			File editFile = textEdit.getEditFile();
			if (editFile != null) {
				Utils.savaTextAreaToFile(editTextArea, editFile);
				JOptionPane.showMessageDialog(new JFrame(), "保存成功");
				textEdit.setSave(true);
			}else{
				JFrame openJFrame = new JFrame("保存文件");
				// 打开一个文件选择框到新建的窗体中
				System.out.println("保存文件，请选择怎恶魔的保存路径");
				FileDialog fileDialog = new FileDialog(openJFrame);
				fileDialog.setMode(FileDialog.SAVE);
				fileDialog.setVisible(true);
				editFile = new File(fileDialog.getDirectory() + File.separator
						+ fileDialog.getFile());
				//TextArea textArea = textEdit.getEditTextArea();
			
				
				Utils.savaTextAreaToFile(editTextArea , editFile);
				System.out.println("保存文件成功");
				textEdit.setEditFile(editFile);
				textEdit.setSave(true);
			}
		}else{
			System.out.println("文件已经保存，无需重复保存");
		}
		String title = textEdit.getjFrame().getTitle();
		textEdit.getjFrame().setTitle(title.substring(1) );

	}

}
