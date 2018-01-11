package cn.qqhxj.main;

import java.awt.TextArea;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {

	public static void savaTextAreaToFile(TextArea textArea, File file) {
		if (file != null && textArea != null) {
			if (!file.exists()) {
				System.out.println("文件不存在");
				try {
					file.createNewFile();
					System.out.println("文件创建成功");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			FileOutputStream fileOutputStream = null;
			String text = textArea.getText();
			System.out.println(text);
			try {
				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(text.getBytes());
				System.out.println("文件写入成功");
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}

	public static void loadFileToTextArea(TextArea editTextArea, File file) {

		if (file != null) {
			System.out.println(file.getAbsolutePath());
			if (!file.exists()) {
				System.out.println("文件不存在，已经创建");
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(file);
				StringBuffer sb = new StringBuffer();

				int len = 0;
				byte[] buf = new byte[1024];
				while ((len = fileInputStream.read(buf)) != -1) {
					sb.append(new String(buf, 0, len));
				}
				String string = new String(sb);
				System.out.println("--------内容--------");
				System.out.println(string);
				System.out.println("------------------");
				editTextArea.setText(string);
				System.out.println("文件加载成功");

			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		} else {

		}

	}

}
