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

	// 设置窗体大小
	private int width = 800;
	private int height = 650;
	// 设置棋子尺寸
	private int chessman_size = 20;
	// 设置棋子个数
	private int chessman_num = 20;
	// 设置棋子点的坐标
	private int point_x = -1;
	private int point_y = -1;
	// 设置全局变量 区分黑白子
	private int num = 0;
	// 设置缓冲图片流
	private BufferedImage image = new BufferedImage(width - 100, height,
			BufferedImage.TYPE_INT_RGB);
	// 获取棋盘上点的坐标
	private List<Integer> chessBoardpointList = new ArrayList<Integer>();
	{
		for (int i = 0; i < chessman_num; i++) {
			chessBoardpointList.add(i, (i + 1) * 30);
		}
	}
	// 当一方获胜，游戏中止
	private boolean isNext = true;
	// 获取当前最后一步所下棋子的坐标和棋盘内此时棋子总数
	private String endPoint = null;
	// 获取最终获胜者的棋子类型 绘出胜利提示
	private String endType = null;
	// 为BufferedImage对象添加画笔
	private Graphics grap = image.getGraphics();
	// 存取棋盘上所有棋子以及黑白子的坐标
	private ArrayList<String> chessman_list = new ArrayList<String>();
	private ArrayList<String> Black_list = new ArrayList<String>();
	private ArrayList<String> White_list = new ArrayList<String>();
	// 设置存取获胜条件的集合（方法参考网络）
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

	// 判断所画棋子所在点是否已经有棋子
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

	// 画图及结果
	@SuppressWarnings("serial")
	class MyCanvas extends Canvas {

		@SuppressWarnings("deprecation")
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
			if (endType != null) {
				if (endType.equals("黑棋玩家")) {
					g.setColor(Color.BLACK);
					g.setFont(new Font("隶书", Font.BOLD, 25));
					g.drawString("黑色方胜利！！!", 250, 20);
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
				} else if (endType.equals("白棋玩家")) {
					g.setColor(Color.WHITE);
					g.setFont(new Font("隶书", Font.BOLD, 25));
					g.drawString("白色方胜利！！!", 250, 20);
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

	// 得到获胜方的棋子颜色（方法参考网络）
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
				type = "黑棋玩家";
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
				type = "白棋玩家";
			}
		}

		return type;
	}

	// 程序开始运行
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
		final Frame frame = new Frame("五子棋游戏");
		// 画布背景图
		final Image img = ImageIO.read(new File("image/2.jpg"));
		
		// 添加面板
		final Panel myPanel = new Panel();
		myPanel.setLayout(null);
		myPanel.setBackground(Color.cyan);
		myPanel.setSize(150, 200);
		frame.add(myPanel, BorderLayout.EAST);
		
		// 添加“悔棋”按钮
		Button retract = new Button("悔棋");
		retract.setLocation(30, 250);
		retract.setSize(80, 30);
		retract.setBackground(Color.DARK_GRAY);
		retract.setForeground(Color.WHITE);
		myPanel.add(retract);
		
		//添加“棋盘总棋子数”按钮
		Button total = new Button("棋盘总棋子数");
		total.setLocation(30, 100);
		total.setSize(80, 30);
		total.setBackground(Color.DARK_GRAY);
		total.setForeground(Color.WHITE);
		myPanel.add(total);
		
		// 棋子总数添加文本域
		final TextField tf = new TextField("    ");
		tf.setLocation(30, 150);
		tf.setSize(80, 22);
		myPanel.add(tf);

		// 添加菜单组件
		MenuBar bar = new MenuBar();
		frame.setMenuBar(bar);
		Menu game = new Menu("游戏");
		Menu select = new Menu("选项");
		Menu help = new Menu("帮助");
		bar.add(game);
		bar.add(select);
		bar.add(help);
		//“游戏”按钮内容
		MenuItem newGame = new MenuItem("     开始新游戏");
		MenuItem exitGame = new MenuItem("        退出");
		//“选项”按钮内容
		MenuItem musicOn = new MenuItem("     音乐-开");
		MenuItem musicClose = new MenuItem("     音乐-关");
		//“帮助”按钮内容
		MenuItem helpMenuItem = new MenuItem("游戏说明");
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
		
		// 画棋盘
		for (int i = 1; i <= 20; i++) {
			grap.drawLine(i * 30, 30, i * 30, 600);
		}
		for (int i = 1; i <= 20; i++) {
			grap.drawLine(30, i * 30, 600, i * 30);
		}
		mc.repaint();
		frame.add(mc);
		mc.setPreferredSize(new Dimension(width, height));
		
		// 为画布设置鼠标监听
		mc.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				point_x = e.getX();
				point_y = e.getY();
				// 在棋盘上
				boolean flag = true;
				// 设置棋子的放置边界 在棋盘上才可以绘制
				if (e.getX() < 30 - chessman_size / 2
						|| e.getX() > 600 + chessman_size / 2
						|| e.getY() < 30 - chessman_size / 2
						|| e.getY() > 600 + chessman_size / 2) {
					flag = false;
				}
				// 将棋子坐标放到距离棋盘上的最近点
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
				// 判断棋盘的点上是否存在棋子
				boolean next = true;
				// 棋子在棋盘上并且没有获胜者
				if (flag && isNext) {
					// 余数为0 画黑子
					if (num % 2 == 0) {
						// 调用方法判断棋盘上是否应经存在该棋子
						next = getChessBoardPoint(point_x, point_y,
								chessman_list);
						// 棋盘上不包含该棋子
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
						// 棋盘上不包含该棋子
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
				// 绘画棋盘
				grap.drawImage(img, 0, 0, width - 150, height, null);
				grap.setColor(Color.BLACK);

				for (int i = 1; i <= 20; i++) {
					grap.drawLine(i * 30, 30, i * 30, 600);
				}
				for (int i = 1; i <= 20; i++) {
					grap.drawLine(30, i * 30, 600, i * 30);
				}
				mc.repaint();
				// 相关数据清零
				chessman_list.clear();
				Black_list.clear();
				White_list.clear();
				num = 0;
				endType = null;
				endPoint = null;
				isNext = true;
			}
		});

        //音乐关闭服务程序
		musicClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				aau1.stop();
			}
		});
		
		//音乐开启服务程序
		musicOn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				aau1.loop();
			}
		});

        //退出游戏服务程序
		exitGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
        //重新开始游戏服务程序
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
        //帮助说明服务程序
		helpMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				final Dialog d = new Dialog(frame, " 游戏说明 ", true);
				TextArea ta = new TextArea("", 2, 10, TextArea.SCROLLBARS_BOTH);
				ta.setSize(300, 300);
				ta.setFont(new Font("", Font.BOLD, 18));
				d.add(ta);

				d.setBounds(100, 20, 300, 300);
				try {
					Scanner scan = new Scanner(new File("image/游戏说明.txt"));
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
