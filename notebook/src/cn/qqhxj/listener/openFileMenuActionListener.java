package cn.qqhxj.listener;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import cn.qqhxj.main.TextEdit;
import cn.qqhxj.main.Utils;

public class openFileMenuActionListener implements ActionListener {
	private TextEdit textEdit = null;

	public openFileMenuActionListener(TextEdit textEdit) {
		super();
		
		this.textEdit = textEdit;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("openFileMenuActionListener");
		boolean save = textEdit.getSave();

		if (save == true) {
			System.out.println("文件已经保存可以打开文件");
			// 新建一个打开窗体
			JFrame openJFrame = new JFrame("打开文件");
			// 打开一个文件选择框到新建的窗体中
			// 首先判断当前文本域的文本是否保存
			
			FileDialog fileDialog = new FileDialog(openJFrame);
			fileDialog.setMode(FileDialog.LOAD);
			fileDialog.setVisible(true);
			File editFile = new File(fileDialog.getDirectory() + File.separator
					+ fileDialog.getFile());
			TextArea editTextArea = textEdit.getEditTextArea();
			Utils.loadFileToTextArea(editTextArea , editFile);
			System.out.println("已经打开新的文件");
			textEdit.setEditFile(editFile);
			textEdit.setSave(true);
		} else {
			TextArea editTextArea = textEdit.getEditTextArea();
			String text = editTextArea.getText();
			if (text != null || text != "") {
				System.out.println("文件需要先保存");
				System.out.println("提醒保存文件");
				File editFile  = textEdit.getEditFile();
				if (editFile!= null) {
					System.out.println("文件保存时没有选择保存的路径");
					JFrame openJFrame = new JFrame("打开文件");
					// 打开一个文件选择框到新建的窗体中
					FileDialog fileDialog = new FileDialog(openJFrame);
					fileDialog.setMode(FileDialog.SAVE);
					fileDialog.setVisible(true);
					editFile = new File(fileDialog.getDirectory()
							+ File.separator + fileDialog.getFile());
					textEdit.setEditFile(editFile);
					System.out.println(editFile);
					Utils.savaTextAreaToFile(editTextArea, editFile);
					save = true;
				} else {
					Utils.savaTextAreaToFile(editTextArea, editFile);
					save = true;
				}

			}
		}

	}

}
