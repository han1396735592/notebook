package cn.qqhxj.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import cn.qqhxj.main.FindDialog;
import cn.qqhxj.main.TextEdit;

public class findMenuActionListener implements ActionListener {

	private TextEdit textEdit = null;

	public findMenuActionListener(TextEdit textEdit) {
		super();
		this.textEdit = textEdit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		FindDialog findDialog = new FindDialog(textEdit);
		findDialogLoginEvent(findDialog);
			
		System.out.println("findMenuActionListener");
		
		// System.out.println("没有找到匹配的字符串");
	}

	private void findDialogLoginEvent(FindDialog findDialog) {
	JButton findJButton = findDialog.getFindJButton();
		// TODO Auto-generated method stub
		findJButton.addActionListener(new FindButtonActionListener(findDialog));
		JButton replaceJButton = findDialog.getReplaceJButton();	
		replaceJButton.addActionListener(new replaceButtonActionListener(
				findDialog));
	}

}
