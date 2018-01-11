package cn.qqhxj.main;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import cn.qqhxj.listener.NewFileMenuActionListener;
import cn.qqhxj.listener.editTextAreaTextListener;
import cn.qqhxj.listener.exitMenuActionListener;
import cn.qqhxj.listener.findMenuActionListener;
import cn.qqhxj.listener.openFileMenuActionListener;
import cn.qqhxj.listener.otherSaveMenuActionListener;
import cn.qqhxj.listener.savaFileMenuActionListener;

public class Main {

	private static TextEdit textEdit = null;

	public static void main(String[] args) {

		System.out.println("程序启动成功");
		// 建立记事本
		textEdit = new TextEdit();
		// 初始化记事本
		init(textEdit);
		// 给记事本呢绑定快捷键
		textEditBingKey(textEdit);
		// 给记事本添加事件监听对象
		textEditLoginEvevt(textEdit);
	}

	// 初始化记事本 设置编辑文本区的字体
	private static void init(TextEdit textEdit2) {
		TextArea editTextArea = textEdit.getEditTextArea();
		Font f = new Font("宋体", Font.PLAIN, 20);
		editTextArea.setFont(f);
	}

/* 
 * 
 * 
 */
	private static void textEditLoginEvevt(final TextEdit textEdit) {

		//获取记事本中需要监听的对象
		JMenuItem newFileMenu = textEdit.getNewFileMenu();
		JMenuItem openFileMenu = textEdit.getOpenFileMenu();
		JMenuItem saveFileMenu = textEdit.getSaveFileMenu();
		JMenuItem findMenu = textEdit.getFindMenu();
		JMenuItem otherSaveMenu = textEdit.getOtherSaveMenu();
		TextArea editTextArea = textEdit.getEditTextArea();
		JMenuItem exitMenu = textEdit.getExitMenu();
		JFrame jFrame = textEdit.getjFrame();

		// 给打开文件注册监听事件
		newFileMenu.addActionListener(new NewFileMenuActionListener(textEdit));
		openFileMenu
				.addActionListener(new openFileMenuActionListener(textEdit));
		saveFileMenu
				.addActionListener(new savaFileMenuActionListener(textEdit));
		editTextArea.addTextListener(new editTextAreaTextListener(textEdit));
		exitMenu.addActionListener(new exitMenuActionListener(textEdit));
		findMenu.addActionListener(new findMenuActionListener(textEdit));
		otherSaveMenu.addActionListener(new otherSaveMenuActionListener(
				textEdit));
		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (textEdit.getSave() == true) {
					int n = JOptionPane.showConfirmDialog(null, "确认退出吗?",
							"确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						System.exit(0);

					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "文件未保存，请先保存文件");
				}

			}

		});
	}

	private static void textEditBingKey(TextEdit textEdit) {
		JMenuItem newFileMenu = textEdit.getNewFileMenu();
		JMenuItem openFileMenu = textEdit.getOpenFileMenu();
		JMenuItem saveFileMenu = textEdit.getSaveFileMenu();
		JMenuItem findMenu = textEdit.getFindMenu();

		newFileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		openFileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		saveFileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));

		findMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
				ActionEvent.CTRL_MASK));

	}

}
