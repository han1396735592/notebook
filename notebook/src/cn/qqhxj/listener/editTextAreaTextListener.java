package cn.qqhxj.listener;

import java.awt.Frame;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.File;

import cn.qqhxj.main.TextEdit;

public class editTextAreaTextListener implements TextListener {
	private TextEdit textEdit = null;
	

	public editTextAreaTextListener(TextEdit textEdit) {
		this.textEdit = textEdit;	
	}

	public void textValueChanged(TextEvent e) {
		System.out.println("editTextAreaTextListener");
		File editFile = textEdit.getEditFile();
		
		Frame jFrame  = textEdit.getjFrame();
		if (editFile  == null) {
			jFrame  .setTitle("未命名");
		} else {

			jFrame.setTitle("*" + editFile.getName());
		}
		this.textEdit.setSave(false);
	}
}
