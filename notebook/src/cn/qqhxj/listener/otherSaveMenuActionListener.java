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

public class otherSaveMenuActionListener implements ActionListener {
	private TextEdit textEdit = null;

	public otherSaveMenuActionListener(TextEdit textEdit) {
		super();
		this.textEdit = textEdit;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("otherSaveMenuActionListener");

		TextArea editTextArea = textEdit.getEditTextArea();

		String text = editTextArea.getText();

		if (text != null && text != "") {
			//File editFile = textEdit.getEditFile();
			File otherFile = null;
			JFrame openJFrame = new JFrame("保存文件");
			// 打开一个文件选择框到新建的窗体中
			System.out.println("保存文件，请选择怎恶魔的保存路径");
			FileDialog fileDialog = new FileDialog(openJFrame);
			fileDialog.setMode(FileDialog.SAVE);
			fileDialog.setVisible(true);
			otherFile = new File(fileDialog.getDirectory() + File.separator
					+ fileDialog.getFile());
			TextArea textArea = textEdit.getEditTextArea();

			Utils.savaTextAreaToFile(textArea, otherFile);

			JOptionPane.showMessageDialog(new JFrame(), "保存成功");
			textEdit.setSave(true);

			System.out.println("保存文件成功");
			textEdit.setSave(true);
			textEdit.setEditFile(otherFile);
		}
		String title = textEdit.getEditFile().getName();

		textEdit.getjFrame().setTitle(title);

	}

}
