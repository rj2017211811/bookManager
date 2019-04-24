package team.javaGroup.bookManageSystem.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import team.javaGroup.bookManageSystem.bean.Book;
import team.javaGroup.bookManageSystem.bean.BorrowSituation;
import team.javaGroup.bookManageSystem.bean.User;
import team.javaGroup.bookManageSystem.dao.BookDao;
import team.javaGroup.bookManageSystem.dao.BookDaoImpl;
import team.javaGroup.bookManageSystem.dao.BorSituationDaoImpl;
import team.javaGroup.bookManageSystem.dao.UserDaoImpl;
import team.javaGroup.bookManageSystem.service.BookService;
import team.javaGroup.bookManageSystem.service.BookServiceImpl;
import team.javaGroup.bookManageSystem.service.BorService;
import team.javaGroup.bookManageSystem.service.BorServiceImpl;
import team.javaGroup.bookManageSystem.service.UserService;
import team.javaGroup.bookManageSystem.service.UserServiceImpl;

public class UserPanel extends RefreshPal {
	private InformationPal infoPal;
	private List<String> lblItemNames;
	private List<JComponent> cptItems;
	private List<JButton> btnCommond;
	private UserService userService;
	private BookService bookService;
	private List<User> userList;
	private List<Book> bookList;
	private BorService service;
	private boolean state;

	public void setIsVisible(boolean state) {
		setVisible(state);
	}

	public boolean getIsVisible() {
		return state;
	}

	public UserPanel(String userName) {
		// System.out.println(userName);
		bookService = new BookServiceImpl(new BookDaoImpl());
		bookList = new ArrayList<Book>();
		bookList = bookService.searchAll();
		lblItemNames = new ArrayList<String>();
		lblItemNames.add("���");
		lblItemNames.add("����");
		lblItemNames.add("����");
		lblItemNames.add("�۸�");
		lblItemNames.add("����");
		cptItems = new ArrayList<JComponent>();
		for (int i = 0; i < 5; i++) {
			JTextField t = new JTextField(20);
			t.setMaximumSize(t.getPreferredSize());
			cptItems.add(t);
		}

		btnCommond = new ArrayList<JButton>();
		JButton btnSearch = new JButton("�����鼮");
		team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnSearch);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bookName = ((JTextField) cptItems.get(1)).getText();
				if (bookName.equals("")) {
					JOptionPane.showMessageDialog(null, "����������!", "��ʾ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					bookList = new ArrayList<Book>();
					bookService = new BookServiceImpl(new BookDaoImpl());
					bookList = bookService.searchBooks(bookName);
					infoPal.freshTable(bookList);
				}

			}
		});

		JButton btnRefresh = new JButton("ˢ��");
		team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnRefresh);
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				bookList = new ArrayList<Book>();
				bookService = new BookServiceImpl(new BookDaoImpl());
				bookList = bookService.searchAll();

				infoPal.freshTable(bookList);

			}
		});

		JButton btnModifyPsd = new JButton("�޸�����");
		team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnModifyPsd);
		btnModifyPsd.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				new ModifyPasswordGui(userName);

			}
		});
		JButton btnInfo = new JButton("�鿴������Ϣ");
		team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnInfo);
		btnInfo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				service = new BorServiceImpl(new BorSituationDaoImpl()); 
				List<BorrowSituation> b = new ArrayList<BorrowSituation>();
				b.addAll(service.searchLikeUId(userName));

				// b=service.searchLikeUId(userName);
				if (!b.isEmpty()) {
					new UBorrowGui(userName);
				} else {
					JOptionPane.showMessageDialog(null, "��û�н��Ĺ��鼮��");
				}
			}
		});
		JButton btnLend = new JButton("�����鼮");
		team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnLend);
		btnLend.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				String strId = new String("");
				String bookName = new String("");
				strId = ((JTextField) cptItems.get(0)).getText();
				bookName = ((JTextField) cptItems.get(1)).getText();
				if (strId.equals("") || bookName.equals("")) {
					JOptionPane.showMessageDialog(null, "�����������ͱ��!", "��ʾ",
							JOptionPane.WARNING_MESSAGE);

				} else {
					int bookId = Integer.valueOf(strId).intValue();

					if (bookService.lendBooks(new User(userName), new Book(
							bookId, bookName)) == 1) {
						JOptionPane.showMessageDialog(null, "���ĳɹ�,�����������ڹ黹�鼮��");
						bookList = new ArrayList<Book>();
						bookService = new BookServiceImpl(new BookDaoImpl());
						bookList = bookService.searchAll();

						infoPal.freshTable(bookList);

					} else if (bookService.lendBooks(new User(userName),
							new Book(bookId, bookName)) == 0) {
						JOptionPane.showMessageDialog(null, "�鼮�����ڣ�");
					} else if (bookService.lendBooks(new User(userName),
							new Book(bookId, bookName)) == -1) {
						JOptionPane.showMessageDialog(null, "���Ѿ����ĸ��鼮��");
					}

				}

			}
		});
		JButton btnReturn = new JButton("�黹�鼮");
		team.javaGroup.bookManageSystem.gui.style.ComponentStyle.setButtonStyle2(btnReturn);
		btnReturn.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				String strId = new String("");
				String bookName = new String("");
				strId = ((JTextField) cptItems.get(0)).getText();
				bookName = ((JTextField) cptItems.get(1)).getText();
				if (strId.equals("") || bookName.equals("")) {
					JOptionPane.showMessageDialog(null, "�����������ͱ��!", "��ʾ",
							JOptionPane.WARNING_MESSAGE);

				} else {
					int bookId = Integer.valueOf(strId).intValue();

					if (bookService.returnBooks(new User(userName), new Book(
							bookId, bookName))) {
						JOptionPane.showMessageDialog(null, "�黹�ɹ���");
						bookList = new ArrayList<Book>();
						bookService = new BookServiceImpl(new BookDaoImpl());
						bookList = bookService.searchAll();

						infoPal.freshTable(bookList);

					} else {
						JOptionPane.showMessageDialog(null, "��δ���ĸ��鼮��");
					}
				}

			}
		});

		btnCommond.add(btnSearch);
		btnCommond.add(btnLend);
		btnCommond.add(btnReturn);
		btnCommond.add(btnModifyPsd);
		btnCommond.add(btnInfo);

		btnCommond.add(btnRefresh);
		try {
			infoPal = new InformationPal(lblItemNames, cptItems, btnCommond, 1,
					1, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(infoPal);

		fresh();
		
	}

	@Override
	public void fresh() {
		infoPal.freshTable(bookList);

	}

}
