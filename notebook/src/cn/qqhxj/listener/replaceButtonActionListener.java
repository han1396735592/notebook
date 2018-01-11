package cn.qqhxj.listener;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.qqhxj.main.FindDialog;
import cn.qqhxj.main.TextEdit;

public class replaceButtonActionListener implements ActionListener {

	private FindDialog findDialog = null;
	private TextEdit textEdit = null;

	public replaceButtonActionListener(FindDialog findDialog) {
		super();
		this.findDialog = findDialog;
		this.textEdit = findDialog.getTextEdit();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		System.out.println("replaceButtonActionListener");
		System.out.println(e);
		System.out.println("FindButtonActionListener");
		System.out.println(e);
		TextArea editTextArea = textEdit.getEditTextArea();
		String text = editTextArea.getText();
		StringBuffer sb = null;
		System.out.println(text);
		String oldStr = findDialog.getFindText().getText();
System.out.println(oldStr+"======");
		int indexOf = text.indexOf(oldStr);
		if (indexOf != -1) {
			System.out.println(indexOf);
			int start = indexOf;
			//String[] split = text.split(oldStr);
			int lineSeparatorLength = text.substring(0, start).split(
					System.getProperty("line.separator")).length;

			//System.out.println("" + split.length);
			int end = indexOf + oldStr.length();
			editTextArea.select(start - lineSeparatorLength + 1, end
					- lineSeparatorLength + 1);
			String str = findDialog.getReplaceText().getText();
			sb = new StringBuffer(text).replace(indexOf, end, str);
			//System.out.println("||" + sb + "||");

			editTextArea.setText(new String(sb));
		}

	}
}
