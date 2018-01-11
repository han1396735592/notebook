package cn.qqhxj.main;

import java.awt.TextArea;

import java.io.File;
import javax.swing.*;

public class TextEdit {
	// 主窗体
	private  JFrame jFrame = null;
	// 菜单栏
	private JMenuBar jMenuBar = null;
	// 菜单栏中的文件菜单、 编辑菜单
	private JMenu fileMenu = null;
	// 文件菜单中的新建菜单项
	private JMenuItem newFileMenu = null;
	// 文件菜单中的打开文件菜单
	private JMenuItem openFileMenu = null;
	// 文件菜单中的保存文件菜单
	private  JMenuItem saveFileMenu = null;
	// 编辑菜单下的另存为菜单
	private  JMenuItem otherSaveMenu = null;// new JMenuItem("粘帖");
	// 编辑菜单下的查找菜单
	private  JMenuItem findMenu = null;// new JMenuItem("查找")
	// 文件菜单下的退出按钮
	private  JMenuItem exitMenu = null;// new JMenuItem("退出");
	
	// 文本的编辑域
	private  TextArea editTextArea = null;// null;
	// 当前要编辑的文件
	private  File editFile = null;
	// 文件是否保存
	private  boolean save ;
	// 初始化程序
	 {
		try {
			
			jFrame = new JFrame("记事本");
			jMenuBar= new JMenuBar();
			fileMenu=new JMenu("文件");
			newFileMenu=new JMenuItem("新建");
			openFileMenu = new JMenuItem("打开");
			saveFileMenu=new JMenuItem("保存");
			otherSaveMenu =new JMenuItem("另存为");
			findMenu=new JMenuItem("查找");
			exitMenu =new JMenuItem("退出");
			
			
			editTextArea=new TextArea();
		
			editFile=null;
			save=true;
			// 文件菜单添加菜单项
			fileMenu.add(newFileMenu);
			fileMenu.add(openFileMenu);
			fileMenu.add(saveFileMenu);
			fileMenu.add(otherSaveMenu);
			fileMenu.add(findMenu);
			
			fileMenu.add(exitMenu);
		
			// 菜单栏添加菜单项
			jMenuBar.add(fileMenu);
		
			// 窗口添加组件
			jFrame.setJMenuBar(jMenuBar);
			jFrame.add(editTextArea);
			// 窗口的外观设置
			jFrame.setSize(800, 600);
			jFrame.setVisible(true);
			// Class.forName("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public JFrame getjFrame() {
		return jFrame;
	}
	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}
	public JMenuBar getjMenuBar() {
		return jMenuBar;
	}
	public void setjMenuBar(JMenuBar jMenuBar) {
		this.jMenuBar = jMenuBar;
	}
	public JMenu getFileMenu() {
		return fileMenu;
	}
	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}

	public JMenuItem getNewFileMenu() {
		return newFileMenu;
	}
	public void setNewFileMenu(JMenuItem newFileMenu) {
		this.newFileMenu = newFileMenu;
	}
	public JMenuItem getOpenFileMenu() {
		return openFileMenu;
	}
	public void setOpenFileMenu(JMenuItem openFileMenu) {
		this.openFileMenu = openFileMenu;
	}
	public JMenuItem getSaveFileMenu() {
		return saveFileMenu;
	}
	public void setSaveFileMenu(JMenuItem saveFileMenu) {
		this.saveFileMenu = saveFileMenu;
	}
	public JMenuItem getExitMenu() {
		return exitMenu;
	}
	public void setExitMenu(JMenuItem exitMenu) {
		this.exitMenu = exitMenu;
	}

	public JMenuItem getFindMenu() {
		return findMenu;
	}
	public void setFindMenu(JMenuItem findMenu) {
		this.findMenu = findMenu;
	}
	public TextArea getEditTextArea() {
		return editTextArea;
	}
	public void setEditTextArea(TextArea editTextArea) {
		this.editTextArea = editTextArea;
	}
	public File getEditFile() {
		return editFile;
	}
	public void setEditFile(File editFile) {
		this.editFile = editFile;
	}
	
	public JMenuItem getOtherSaveMenu() {
		return otherSaveMenu;
	}
	public void setOtherSaveMenu(JMenuItem otherSaveMenu) {
		this.otherSaveMenu = otherSaveMenu;
	}
	public boolean getSave() {
		return save;
	}
	public void setSave(boolean save) {
		this.save = save;
	}
}