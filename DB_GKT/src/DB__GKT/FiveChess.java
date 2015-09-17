package DB__GKT;
/**
 * 
 * @author DBing&Gketing
 *
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class FiveChess {

	// ���ô����С
	private int width = 800;
	private int height = 650;
	// �������ӳߴ�
	private int chessman_size = 20;
	// �������Ӹ���
	private int chessman_num = 20;
	// �������ӵ������
	private int point_x = -1;
	private int point_y = -1;
	// ����ȫ�ֱ��� ���ֺڰ���
	private int num = 0;
	// ���û���ͼƬ��
	private BufferedImage image = new BufferedImage(width - 100, height,
			BufferedImage.TYPE_INT_RGB);
	// ��ȡ�����ϵ������
	private List<Integer> chessBoardpointList = new ArrayList<Integer>();
	{
		for (int i = 0; i < chessman_num; i++) {
			chessBoardpointList.add(i, (i + 1) * 30);
		}
	}
	// ��һ����ʤ����Ϸ��ֹ
	private boolean isNext = true;
	// ��ȡ��ǰ���һ���������ӵ�����������ڴ�ʱ��������
	private String endPoint = null;
	// ��ȡ���ջ�ʤ�ߵ��������� ���ʤ����ʾ
	private String endType = null;
	// ΪBufferedImage������ӻ���
	private Graphics grap = image.getGraphics();
	// ��ȡ���������������Լ��ڰ��ӵ�����
	private ArrayList<String> chessman_list = new ArrayList<String>();
	private ArrayList<String> Black_list = new ArrayList<String>();
	private ArrayList<String> White_list = new ArrayList<String>();
	// ���ô�ȡ��ʤ�����ļ��ϣ������ο����磩
	private ArrayList<String> winner_list1 = new ArrayList<String>();
	private ArrayList<String> winner_list2 = new ArrayList<String>();
	private ArrayList<String> winner_list3 = new ArrayList<String>();
	private ArrayList<String> winner_list4 = new ArrayList<String>();
	private ArrayList<String> winner_list5 = new ArrayList<String>();
	private ArrayList<String> winner_list6 = new ArrayList<String>();
	private ArrayList<String> winner_list7 = new ArrayList<String>();
	private ArrayList<String> winner_list8 = new ArrayList<String>();
	private ArrayList<String> winner_list11 = new ArrayList<String>();
	private ArrayList<String> winner_list21 = new ArrayList<String>();
	private ArrayList<String> winner_list31 = new ArrayList<String>();
	private ArrayList<String> winner_list41 = new ArrayList<String>();
	private ArrayList<String> winner_list51 = new ArrayList<String>();
	private ArrayList<String> winner_list61 = new ArrayList<String>();
	private ArrayList<String> winner_list71 = new ArrayList<String>();
	private ArrayList<String> winner_list81 = new ArrayList<String>();
	private ArrayList<String> winner_list12 = new ArrayList<String>();
	private ArrayList<String> winner_list22 = new ArrayList<String>();
	private ArrayList<String> winner_list32 = new ArrayList<String>();
	private ArrayList<String> winner_list42 = new ArrayList<String>();
	private ArrayList<String> winner_list52 = new ArrayList<String>();
	private ArrayList<String> winner_list62 = new ArrayList<String>();
	private ArrayList<String> winner_list72 = new ArrayList<String>();
	private ArrayList<String> winner_list82 = new ArrayList<String>();
	private ArrayList<String> winner_list13 = new ArrayList<String>();
	private ArrayList<String> winner_list23 = new ArrayList<String>();
	private ArrayList<String> winner_list33 = new ArrayList<String>();
	private ArrayList<String> winner_list43 = new ArrayList<String>();
	private ArrayList<String> winner_list53 = new ArrayList<String>();
	private ArrayList<String> winner_list63 = new ArrayList<String>();
	private ArrayList<String> winner_list73 = new ArrayList<String>();
	private ArrayList<String> winner_list83 = new ArrayList<String>();

	// �ж������������ڵ��Ƿ��Ѿ�������
	private boolean getChessBoardPoint(int data1, int data2,
			ArrayList<String> data3) {
		boolean next = true;
		if (data3.size() != 0) {
			for (int i = 0; i < data3.size(); i++) {
				if ((data1 + "_" + data2).equals(data3.get(i))) {
					next = false;
					break;
				}
			}
		}
		return next;
	}

	// ��ͼ�����
	@SuppressWarnings("serial")
	class MyCanvas extends Canvas {

		@SuppressWarnings("deprecation")
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
			if (endType != null) {
				if (endType.equals("�������")) {
					g.setColor(Color.BLACK);
					g.setFont(new Font("����", Font.BOLD, 25));
					g.drawString("��ɫ��ʤ������!", 250, 20);
					File f = new File("image/2.wav");
					URL cb = null;
					try {
						cb = f.toURL();
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
					AudioClip aau;
					aau = Applet.newAudioClip(cb);
					aau.loop();
					try {
						Thread.sleep(3500);
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					aau.stop();
					chessman_list.size();
					isNext = false;
					Black_list.size();
					endType = null;
				} else if (endType.equals("�������")) {
					g.setColor(Color.WHITE);
					g.setFont(new Font("����", Font.BOLD, 25));
					g.drawString("��ɫ��ʤ������!", 250, 20);
					File f = new File("image/2.wav");
					URL cb = null;
					try {
						cb = f.toURL();
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
					AudioClip aau;
					aau = Applet.newAudioClip(cb);
					aau.loop();
					try {
						Thread.sleep(3500);
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					aau.stop();
					chessman_list.size();
					isNext = false;
					White_list.size();
					endType = null;
				}

			}
		}
	}

	// �õ���ʤ����������ɫ�������ο����磩
	public String getWinner(int data1, int data2) {

		String type = null;
		for (int i = 0; i < 5; i++) {
			winner_list1.add((data1 - i * 30) + "_" + data2);
			winner_list11.add((data1 - (i - 1) * 30) + "_" + data2);
			winner_list12.add((data1 - (i - 2) * 30) + "_" + data2);
			winner_list13.add((data1 - (i - 3) * 30) + "_" + data2);
		}
		for (int i = 0; i < 5; i++) {
			winner_list5.add((data1 + i * 30) + "_" + data2);
			winner_list51.add((data1 + (i - 1) * 30) + "_" + data2);
			winner_list52.add((data1 + (i - 2) * 30) + "_" + data2);
			winner_list53.add((data1 + (i - 3) * 30) + "_" + data2);
		}
		for (int i = 0; i < 5; i++) {
			winner_list2.add(data1 + "_" + (data2 + i * 30));
			winner_list21.add(data1 + "_" + (data2 + (i - 1) * 30));
			winner_list22.add(data1 + "_" + (data2 + (i - 2) * 30));
			winner_list23.add(data1 + "_" + (data2 + (i - 3) * 30));
		}
		for (int i = 0; i < 5; i++) {
			winner_list6.add(data1 + "_" + (data2 - i * 30));
			winner_list61.add(data1 + "_" + (data2 - (i - 1) * 30));
			winner_list62.add(data1 + "_" + (data2 - (i - 2) * 30));
			winner_list63.add(data1 + "_" + (data2 - (i - 3) * 30));
		}
		for (int i = 0; i < 5; i++) {
			winner_list3.add((data1 + i * 30) + "_" + (data2 - i * 30));
			winner_list31.add((data1 + (i - 1) * 30) + "_"
					+ (data2 - (i - 1) * 30));
			winner_list32.add((data1 + (i - 2) * 30) + "_"
					+ (data2 - (i - 2) * 30));
			winner_list33.add((data1 + (i - 3) * 30) + "_"
					+ (data2 - (i - 3) * 30));
		}
		for (int i = 0; i < 5; i++) {
			winner_list4.add((data1 - i * 30) + "_" + (data2 + i * 30));
			winner_list41.add((data1 - (i - 1) * 30) + "_"
					+ (data2 + (i - 1) * 30));
			winner_list42.add((data1 - (i - 2) * 30) + "_"
					+ (data2 + (i - 2) * 30));
			winner_list43.add((data1 - (i - 3) * 30) + "_"
					+ (data2 + (i - 3) * 30));
		}
		for (int i = 0; i < 5; i++) {
			winner_list7.add((data1 - i * 30) + "_" + (data2 - i * 30));
			winner_list71.add((data1 - (i - 1) * 30) + "_"
					+ (data2 - (i - 1) * 30));
			winner_list72.add((data1 - (i - 2) * 30) + "_"
					+ (data2 - (i - 2) * 30));
			winner_list73.add((data1 - (i - 3) * 30) + "_"
					+ (data2 - (i - 3) * 30));
		}
		for (int i = 0; i < 5; i++) {
			winner_list8.add((data1 + i * 30) + "_" + (data2 + i * 30));
			winner_list81.add((data1 + (i - 1) * 30) + "_"
					+ (data2 + (i - 1) * 30));
			winner_list82.add((data1 + (i - 2) * 30) + "_"
					+ (data2 + (i - 2) * 30));
			winner_list83.add((data1 + (i - 3) * 30) + "_"
					+ (data2 + (i - 3) * 30));
		}
		if (num % 2 == 0) {
			if (Black_list.containsAll(winner_list1)
					|| Black_list.containsAll(winner_list2)
					|| Black_list.containsAll(winner_list3)
					|| Black_list.containsAll(winner_list4)
					|| Black_list.containsAll(winner_list5)
					|| Black_list.containsAll(winner_list6)
					|| Black_list.containsAll(winner_list7)
					|| Black_list.containsAll(winner_list8)
					|| Black_list.containsAll(winner_list11)
					|| Black_list.containsAll(winner_list21)
					|| Black_list.containsAll(winner_list31)
					|| Black_list.containsAll(winner_list41)
					|| Black_list.containsAll(winner_list51)
					|| Black_list.containsAll(winner_list61)
					|| Black_list.containsAll(winner_list71)
					|| Black_list.containsAll(winner_list81)
					|| Black_list.containsAll(winner_list12)
					|| Black_list.containsAll(winner_list22)
					|| Black_list.containsAll(winner_list32)
					|| Black_list.containsAll(winner_list42)
					|| Black_list.containsAll(winner_list52)
					|| Black_list.containsAll(winner_list62)
					|| Black_list.containsAll(winner_list72)
					|| Black_list.containsAll(winner_list82)
					|| Black_list.containsAll(winner_list13)
					|| Black_list.containsAll(winner_list23)
					|| Black_list.containsAll(winner_list33)
					|| Black_list.containsAll(winner_list43)
					|| Black_list.containsAll(winner_list53)
					|| Black_list.containsAll(winner_list63)
					|| Black_list.containsAll(winner_list73)
					|| Black_list.containsAll(winner_list83)) {
				type = "�������";
			}
		} else {
			if (White_list.containsAll(winner_list1)
					|| White_list.containsAll(winner_list2)
					|| White_list.containsAll(winner_list3)
					|| White_list.containsAll(winner_list4)
					|| White_list.containsAll(winner_list5)
					|| White_list.containsAll(winner_list6)
					|| White_list.containsAll(winner_list7)
					|| White_list.containsAll(winner_list8)
					|| White_list.containsAll(winner_list11)
					|| White_list.containsAll(winner_list21)
					|| White_list.containsAll(winner_list31)
					|| White_list.containsAll(winner_list41)
					|| White_list.containsAll(winner_list51)
					|| White_list.containsAll(winner_list61)
					|| White_list.containsAll(winner_list71)
					|| White_list.containsAll(winner_list81)
					|| White_list.containsAll(winner_list12)
					|| White_list.containsAll(winner_list22)
					|| White_list.containsAll(winner_list32)
					|| White_list.containsAll(winner_list42)
					|| White_list.containsAll(winner_list52)
					|| White_list.containsAll(winner_list62)
					|| White_list.containsAll(winner_list72)
					|| White_list.containsAll(winner_list82)
					|| White_list.containsAll(winner_list13)
					|| White_list.containsAll(winner_list23)
					|| White_list.containsAll(winner_list33)
					|| White_list.containsAll(winner_list43)
					|| White_list.containsAll(winner_list53)
					|| White_list.containsAll(winner_list63)
					|| White_list.containsAll(winner_list73)
					|| White_list.containsAll(winner_list83)) {
				type = "�������";
			}
		}

		return type;
	}

	// ����ʼ����
	@SuppressWarnings("deprecation")
	public void start() throws Exception {
		
		File f = new File("image/4.wav");
		URL cb = null;
		try {
			cb = f.toURL();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		final AudioClip aau1;
		aau1 = Applet.newAudioClip(cb);
		aau1.loop();
		final Frame frame = new Frame("��������Ϸ");
		// ��������ͼ
		final Image img = ImageIO.read(new File("image/2.jpg"));
		
		// ������
		final Panel myPanel = new Panel();
		myPanel.setLayout(null);
		myPanel.setBackground(Color.cyan);
		myPanel.setSize(150, 200);
		frame.add(myPanel, BorderLayout.EAST);
		
		// ��ӡ����塱��ť
		Button retract = new Button("����");
		retract.setLocation(30, 250);
		retract.setSize(80, 30);
		retract.setBackground(Color.DARK_GRAY);
		retract.setForeground(Color.WHITE);
		myPanel.add(retract);
		
		//��ӡ�����������������ť
		Button total = new Button("������������");
		total.setLocation(30, 100);
		total.setSize(80, 30);
		total.setBackground(Color.DARK_GRAY);
		total.setForeground(Color.WHITE);
		myPanel.add(total);
		
		// ������������ı���
		final TextField tf = new TextField("    ");
		tf.setLocation(30, 150);
		tf.setSize(80, 22);
		myPanel.add(tf);

		// ��Ӳ˵����
		MenuBar bar = new MenuBar();
		frame.setMenuBar(bar);
		Menu game = new Menu("��Ϸ");
		Menu select = new Menu("ѡ��");
		Menu help = new Menu("����");
		bar.add(game);
		bar.add(select);
		bar.add(help);
		//����Ϸ����ť����
		MenuItem newGame = new MenuItem("     ��ʼ����Ϸ");
		MenuItem exitGame = new MenuItem("        �˳�");
		//��ѡ���ť����
		MenuItem musicOn = new MenuItem("     ����-��");
		MenuItem musicClose = new MenuItem("     ����-��");
		//����������ť����
		MenuItem helpMenuItem = new MenuItem("��Ϸ˵��");
		game.add(newGame);
		game.addSeparator();
		game.add(exitGame);
		select.add(musicOn);
		select.addSeparator();
		select.add(musicClose);
		help.add(helpMenuItem);
		final MyCanvas mc = new MyCanvas();
		grap.drawImage(img, 0, 0, width - 150, height, null);
		grap.setColor(Color.BLACK);
		
		// ������
		for (int i = 1; i <= 20; i++) {
			grap.drawLine(i * 30, 30, i * 30, 600);
		}
		for (int i = 1; i <= 20; i++) {
			grap.drawLine(30, i * 30, 600, i * 30);
		}
		mc.repaint();
		frame.add(mc);
		mc.setPreferredSize(new Dimension(width, height));
		
		// Ϊ��������������
		mc.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				point_x = e.getX();
				point_y = e.getY();
				// ��������
				boolean flag = true;
				// �������ӵķ��ñ߽� �������ϲſ��Ի���
				if (e.getX() < 30 - chessman_size / 2
						|| e.getX() > 600 + chessman_size / 2
						|| e.getY() < 30 - chessman_size / 2
						|| e.getY() > 600 + chessman_size / 2) {
					flag = false;
				}
				// ����������ŵ����������ϵ������
				for (Integer in : chessBoardpointList) {
					if (point_x >= (in - 15) && point_x <= (in + 15)) {
						point_x = in;
						break;
					}
				}
				for (Integer in : chessBoardpointList) {
					if (point_y >= (in - 15) && point_y <= (in + 15)) {
						point_y = in;
						break;
					}
				}
				// �ж����̵ĵ����Ƿ��������
				boolean next = true;
				// �����������ϲ���û�л�ʤ��
				if (flag && isNext) {
					// ����Ϊ0 ������
					if (num % 2 == 0) {
						// ���÷����ж��������Ƿ�Ӧ�����ڸ�����
						next = getChessBoardPoint(point_x, point_y,
								chessman_list);
						// �����ϲ�����������
						if (next) {
							grap.setColor(Color.BLACK);
							grap.fillOval(point_x - 10, point_y - 10,
									chessman_size, chessman_size);
							File f = new File("image/1.wav");
							URL cb = null;
							try {
								cb = f.toURL();
							} catch (MalformedURLException e1) {
								e1.printStackTrace();
							}
							AudioClip aau;
							aau = Applet.newAudioClip(cb);
							aau.loop();
							try {
								Thread.sleep(400);
							} catch (InterruptedException e2) {
								e2.printStackTrace();
							}
							aau.stop();
							Black_list.add(point_x + "_" + point_y);
							chessman_list.add(point_x + "_" + point_y);
							chessman_list.size();
							endType = getWinner(point_x, point_y);
							endPoint = Black_list.get(Black_list.size() - 1);
							num++;
							String line = String.valueOf(chessman_list.size());
							tf.setText(line);
							winner_list1.clear();
							winner_list2.clear();
							winner_list3.clear();
							winner_list4.clear();
							winner_list5.clear();
							winner_list6.clear();
							winner_list7.clear();
							winner_list8.clear();
							winner_list11.clear();
							winner_list21.clear();
							winner_list31.clear();
							winner_list41.clear();
							winner_list51.clear();
							winner_list61.clear();
							winner_list71.clear();
							winner_list81.clear();
							winner_list12.clear();
							winner_list22.clear();
							winner_list32.clear();
							winner_list42.clear();
							winner_list52.clear();
							winner_list62.clear();
							winner_list72.clear();
							winner_list82.clear();
							winner_list13.clear();
							winner_list23.clear();
							winner_list33.clear();
							winner_list43.clear();
							winner_list53.clear();
							winner_list63.clear();
							winner_list73.clear();
							winner_list83.clear();
						}

					} else {
						next = getChessBoardPoint(point_x, point_y,
								chessman_list);
						// �����ϲ�����������
						if (next) {
							grap.setColor(Color.WHITE);
							grap.fillOval(point_x - 10, point_y - 10,
									chessman_size, chessman_size);
							File f = new File("image/1.wav");
							URL cb = null;
							try {
								cb = f.toURL();
							} catch (MalformedURLException e1) {
								e1.printStackTrace();
							}
							AudioClip aau;
							aau = Applet.newAudioClip(cb);
							aau.loop();
							try {
								Thread.sleep(400);
							} catch (InterruptedException e2) {
								e2.printStackTrace();
							}
							aau.stop();
							White_list.add(point_x + "_" + point_y);
							chessman_list.add(point_x + "_" + point_y);
							chessman_list.size();
							endType = getWinner(point_x, point_y);
							endPoint = White_list.get(White_list.size() - 1);
							num++;
							String line = String.valueOf(chessman_list.size());
							tf.setText(line);
							winner_list1.clear();
							winner_list2.clear();
							winner_list3.clear();
							winner_list4.clear();
							winner_list5.clear();
							winner_list6.clear();
							winner_list7.clear();
							winner_list8.clear();
							winner_list11.clear();
							winner_list21.clear();
							winner_list31.clear();
							winner_list41.clear();
							winner_list51.clear();
							winner_list61.clear();
							winner_list71.clear();
							winner_list81.clear();
							winner_list12.clear();
							winner_list22.clear();
							winner_list32.clear();
							winner_list42.clear();
							winner_list52.clear();
							winner_list62.clear();
							winner_list72.clear();
							winner_list82.clear();
							winner_list13.clear();
							winner_list23.clear();
							winner_list33.clear();
							winner_list43.clear();
							winner_list53.clear();
							winner_list63.clear();
							winner_list73.clear();
							winner_list83.clear();

						}
					}
					mc.repaint();
				}
			}
		});

		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// �滭����
				grap.drawImage(img, 0, 0, width - 150, height, null);
				grap.setColor(Color.BLACK);

				for (int i = 1; i <= 20; i++) {
					grap.drawLine(i * 30, 30, i * 30, 600);
				}
				for (int i = 1; i <= 20; i++) {
					grap.drawLine(30, i * 30, 600, i * 30);
				}
				mc.repaint();
				// �����������
				chessman_list.clear();
				Black_list.clear();
				White_list.clear();
				num = 0;
				endType = null;
				endPoint = null;
				isNext = true;
			}
		});

        //���ֹرշ������
		musicClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				aau1.stop();
			}
		});
		
		//���ֿ����������
		musicOn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				aau1.loop();
			}
		});

        //�˳���Ϸ�������
		exitGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
        //���¿�ʼ��Ϸ�������
		retract.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (endPoint != null && isNext && chessman_list.size() - 1 > 0) {
					if (chessman_list.contains(endPoint)) {
						chessman_list.remove(endPoint);
					}
					if (Black_list.contains(endPoint)) {
						Black_list.remove(endPoint);
					}
					if (White_list.contains(endPoint)) {
						White_list.remove(endPoint);
					}
					grap.drawImage(img, 0, 0, width - 150, height, null);
					grap.setColor(Color.BLACK);
					for (int i = 1; i <= 20; i++) {
						grap.drawLine(i * 30, 30, i * 30, 600);
					}
					for (int i = 1; i <= 20; i++) {
						grap.drawLine(30, i * 30, 600, i * 30);
					}
					for (int i = 0; i < Black_list.size(); i++) {
						String[] a = Black_list.get(i).split("_");
						int x = Integer.parseInt(a[0]);
						int y = Integer.parseInt(a[1]);
						grap.setColor(Color.BLACK);
						grap.fillOval(x - 10, y - 10, chessman_size,
								chessman_size);
					}
					for (int i = 0; i < White_list.size(); i++) {
						String[] a = White_list.get(i).split("_");
						int x = Integer.parseInt(a[0]);
						int y = Integer.parseInt(a[1]);
						grap.setColor(Color.WHITE);
						grap.fillOval(x - 10, y - 10, chessman_size,
								chessman_size);
					}
					num--;
					endPoint = chessman_list.get(chessman_list.size() - 1);
				} else {
					endPoint = null;
				}
				mc.repaint();
				String line = String.valueOf(chessman_list.size());
				tf.setText(line);
			}
		});
        //����˵���������
		helpMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				final Dialog d = new Dialog(frame, " ��Ϸ˵�� ", true);
				TextArea ta = new TextArea("", 2, 10, TextArea.SCROLLBARS_BOTH);
				ta.setSize(300, 300);
				ta.setFont(new Font("", Font.BOLD, 18));
				d.add(ta);

				d.setBounds(100, 20, 300, 300);
				try {
					Scanner scan = new Scanner(new File("image/��Ϸ˵��.txt"));
					while (scan.hasNextLine()) {
						String line = scan.nextLine();
						ta.append(line);
						ta.append("\r\n");
					}
					scan.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				d.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						d.setVisible(false);
					}
				});
				d.setVisible(true);
			}
		});

		frame.setBounds(200, 10, width, height + 30);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	

	
	public static void main(String[] args) throws Exception {
		new FiveChess().start();
	}
}
