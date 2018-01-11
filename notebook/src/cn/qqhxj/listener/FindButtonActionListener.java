package cn.qqhxj.listener;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.qqhxj.main.FindDialog;
import cn.qqhxj.main.TextEdit;

public class FindButtonActionListener implements ActionListener {

	private FindDialog findDialog = null;
	private TextEdit textEdit = null;
	private TextArea editTextArea = null;

	public FindButtonActionListener(FindDialog findDialog) {
		super();
		this.findDialog = findDialog;
		this.textEdit = findDialog.getTextEdit();
		this.editTextArea = textEdit.getEditTextArea();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("FindButtonActionListener");
		System.out.println(e);
		System.out.println(editTextArea);
		String text = editTextArea.getText();
		System.out.println(text);
		String oldStr = findDialog.getFindText().getText();
		System.out.println(oldStr.length() + "length");
		System.out.println(findDialog.getFindText());
		System.out.println(oldStr + "lll");
		int indexOf = text.indexOf(oldStr);
		if (indexOf != -1) {
			System.out.println(indexOf);
			int start = indexOf;
			int lineSeparatorLength = text.substring(0, start).split(
					System.getProperty("line.separator")).length;
			int end = indexOf + oldStr.length();
			editTextArea.requestFocus();
			editTextArea.select(start - lineSeparatorLength + 1, end
					- lineSeparatorLength + 1);
			System.out.println("select");

		} else {
			System.out.println("没有找到");
		}
	}

}
