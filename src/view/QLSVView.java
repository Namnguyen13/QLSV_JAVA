package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;
import controller.QLSVController;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_maThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_hoVaTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_mon1;
	public JTextField textField_mon2;
	public JTextField textField_mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton rdbtnNewRadioButton_nam;
	public JRadioButton rdbtnNewRadioButton_nu;
	public JComboBox comboBox_queQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.model = new QLSVModel(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 599);
		
		Action action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuFile = new JMenu("File");
		MenuFile.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		menuBar.add(MenuFile);
		
		JMenuItem MenuOpen = new JMenuItem("Open");
		MenuOpen.addActionListener(action);
		MenuFile.add(MenuOpen);
		
		JMenuItem MenuSave = new JMenuItem("Save");
		MenuSave.addActionListener(action);
		MenuFile.add(MenuSave);
		
		JSeparator separator = new JSeparator();
		MenuFile.add(separator);
		
		JMenuItem MenuExit = new JMenuItem("Exit");
		MenuExit.addActionListener(action);
		MenuFile.add(MenuExit);
		
		JMenu MenuAbout = new JMenu("About");
		MenuAbout.addActionListener(action);
		MenuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(MenuAbout);
		
		JMenuItem MenuAboutMe = new JMenuItem("About Me");
		MenuAboutMe.addActionListener(action);
		MenuAbout.add(MenuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label_queQuan = new JLabel("Quê Quán");
		Label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_queQuan.setBounds(10, 11, 90, 45);
		contentPane.add(Label_queQuan);
		
		JLabel Label_MaSinhVien = new JLabel("Mã Sinh Viên");
		Label_MaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_MaSinhVien.setBounds(267, 11, 90, 45);
		contentPane.add(Label_MaSinhVien);
		
		textField_maThiSinh_TimKiem = new JTextField();
		textField_maThiSinh_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_maThiSinh_TimKiem.setColumns(10);
		textField_maThiSinh_TimKiem.setBounds(367, 11, 147, 45);
		contentPane.add(textField_maThiSinh_TimKiem);
		
		JButton Button_timKiem = new JButton("Tìm Kiếm");
		Button_timKiem.addActionListener(action);
		Button_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_timKiem.setBounds(525, 11, 103, 45);
		contentPane.add(Button_timKiem);
		
		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
			}
		comboBox_queQuan_timKiem.setBounds(85, 13, 156, 45);
		contentPane.add(comboBox_queQuan_timKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(195, 79, 1, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 79, 740, 2);
		contentPane.add(separator_2);
		
		JLabel Label_queQuan_1 = new JLabel("Danh sách sinh viên");
		Label_queQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_queQuan_1.setBounds(10, 81, 162, 45);
		contentPane.add(Label_queQuan_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Sinh Vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày Sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3",
			}
		));
		
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 124, 740, 147);
		contentPane.add(scrollPane);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 282, 740, 2);
		contentPane.add(separator_2_1);
		
		JLabel Label_MaSinhVien_1 = new JLabel("Thông tin sinh viên ");
		Label_MaSinhVien_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_MaSinhVien_1.setBounds(10, 280, 162, 45);
		contentPane.add(Label_MaSinhVien_1);
		
		JLabel Label_ID = new JLabel("Mã Sinh Viên");
		Label_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_ID.setBounds(35, 314, 90, 45);
		contentPane.add(Label_ID);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_ID.setColumns(10);
		textField_ID.setBounds(141, 324, 136, 25);
		contentPane.add(textField_ID);
		
		JLabel Label_hoVaTen = new JLabel("Họ và tên ");
		Label_hoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_hoVaTen.setBounds(35, 352, 90, 45);
		contentPane.add(Label_hoVaTen);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_hoVaTen.setColumns(10);
		textField_hoVaTen.setBounds(141, 360, 136, 25);
		contentPane.add(textField_hoVaTen);
		
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
			}
		comboBox_queQuan.setBounds(141, 396, 136, 22);
		contentPane.add(comboBox_queQuan);
		
		JLabel Label_queQuan_2 = new JLabel("Quê Quán");
		Label_queQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_queQuan_2.setBounds(35, 383, 90, 45);
		contentPane.add(Label_queQuan_2);
		
		JLabel Label_ngaySinh = new JLabel("Ngày sinh");
		Label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_ngaySinh.setBounds(35, 419, 90, 45);
		contentPane.add(Label_ngaySinh);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(141, 429, 136, 25);
		contentPane.add(textField_ngaySinh);
		
		JLabel Label_gioiTinh = new JLabel("Giới tính");
		Label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_gioiTinh.setBounds(425, 314, 72, 45);
		contentPane.add(Label_gioiTinh);
		
		rdbtnNewRadioButton_nam = new JRadioButton("Nam");
		rdbtnNewRadioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_nam.setBounds(525, 325, 72, 23);
		contentPane.add(rdbtnNewRadioButton_nam);
		
		rdbtnNewRadioButton_nu = new JRadioButton("Nữ");
		rdbtnNewRadioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_nu.setBounds(606, 325, 55, 23);
		contentPane.add(rdbtnNewRadioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(rdbtnNewRadioButton_nam);
		btn_gioiTinh.add(rdbtnNewRadioButton_nu);
		
		JLabel Label_mon1 = new JLabel("Môn 1");
		Label_mon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_mon1.setBounds(425, 352, 90, 45);
		contentPane.add(Label_mon1);
		
		textField_mon1 = new JTextField();
		textField_mon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(525, 362, 136, 25);
		contentPane.add(textField_mon1);
		
		JLabel Label_mon2 = new JLabel("Môn 2");
		Label_mon2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_mon2.setBounds(425, 383, 90, 45);
		contentPane.add(Label_mon2);
		
		textField_mon2 = new JTextField();
		textField_mon2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(525, 393, 136, 25);
		contentPane.add(textField_mon2);
		
		JLabel Label_mon3 = new JLabel("Môn 3");
		Label_mon3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_mon3.setBounds(425, 419, 90, 45);
		contentPane.add(Label_mon3);
		
		textField_mon3 = new JTextField();
		textField_mon3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(525, 429, 136, 25);
		contentPane.add(textField_mon3);
		
		JButton Button_them = new JButton("Thêm");
		Button_them.addActionListener(action);
		Button_them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_them.setBounds(21, 475, 103, 45);
		contentPane.add(Button_them);
		
		JButton Button_xoa = new JButton("Xóa");
		Button_xoa.addActionListener(action);
		Button_xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_xoa.setBounds(174, 475, 103, 45);
		contentPane.add(Button_xoa);
		
		JButton Button_capNhat = new JButton("Cập nhật");
		Button_capNhat.addActionListener(action);
		Button_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_capNhat.setBounds(336, 475, 103, 45);
		contentPane.add(Button_capNhat);
		
		JButton Button_luu = new JButton("Lưu");
		Button_luu.addActionListener(action);
		Button_luu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_luu.setBounds(492, 475, 103, 45);
		contentPane.add(Button_luu);
		
		JButton btnHyB = new JButton("Hủy Bỏ");
		btnHyB.addActionListener(action);
		btnHyB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHyB.setBounds(647, 475, 103, 45);
		contentPane.add(btnHyB);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(21, 465, 729, 2);
		contentPane.add(separator_3);
		
		JButton btnHuyTim = new JButton("Hủy Tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuyTim.setBounds(638, 11, 103, 45);
		contentPane.add(btnHuyTim);
		this.setVisible(true);
	}

	public void xoaFrom() {
		textField_ID.setText("");
		textField_hoVaTen.setText("");
		textField_maThiSinh_TimKiem.setText("");
		textField_ngaySinh.setText("");
		textField_mon1.setText("");
		textField_mon2.setText("");
		textField_mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection(); 
				
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(
				new Object[] {
						ts.getMaThiSinh()+"",
						ts.getTenThiSinh(),
						ts.getQueQuan().getTenTinh(),
						ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900),
						(ts.isGioiTinh()?"Nam":"Nữ"),
						ts.getDiemMon1()+"",
						ts.getDiemMon2()+"",
						ts.getDiemMon3()+"",
				});
	}
	
	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String id =  model_table.getValueAt(i, 0)+"";
				if(id.equals(ts.getMaThiSinh()+"")) {
					model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
					model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900)+"", i, 3);
					model_table.setValueAt((ts.isGioiTinh()?"Nam":"Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
					model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
					model_table.setValueAt(ts.getDiemMon3()+"", i, 7);
					
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
			return ts;
	}
	
	public void hienThongTinThiSinhDaChon() {
		
		ThiSinh ts = getThiSinhDangChon();
		this.textField_ID.setText(ts.getMaThiSinh()+"");
		this.textField_hoVaTen.setText(ts.getTenThiSinh()+"");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
		this.textField_ngaySinh.setText(s_ngaySinh+"");
		if(ts.isGioiTinh()) {
			rdbtnNewRadioButton_nam.setSelected(true);
		} else {
			rdbtnNewRadioButton_nu.setSelected(true);
		}
		this.textField_mon1.setText(ts.getDiemMon1()+"");
		this.textField_mon2.setText(ts.getDiemMon2()+"");
		this.textField_mon3.setText(ts.getDiemMon3()+"");
	
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn ?");
		if(luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemThiSinh() {
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_hoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_ngaySinh.getText());
		boolean gioiTinh = true;
		if(this.rdbtnNewRadioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if(this.rdbtnNewRadioButton_nu.isSelected()){
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_mon3.getText());
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);                    
		this.themHoacCapNhatThiSinh(ts);
		 
	}

	public void thucHienTimKiem() {
		//goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		
		//Thuc hien tim kiem
		
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex()-1;
		String maThiSinhTimKiem = this.textField_maThiSinh_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>(); 
		if(queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
		for(int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id =  model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if(maThiSinhTimKiem.length() > 0) {
			for(int i = 0; i < soLuongDong; i++) {
				String id =  model_table.getValueAt(i, 0)+"";
				if(!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String idTrongTable =  model_table.getValueAt(i, 0)+"";
				System.out.println("idTrongTable: "+idTrongTable);
				if(idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: "+i);
					try {
						model_table.removeRow(i);
					} catch(Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	

	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong == 0 )
				break;
			else 
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();				}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh!");		
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
				this,
			    "Bạn có muốn thoát khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();		
			}
	}
	
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();

		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject()) != null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());			}
		this.model.setDsThiSinh(ds);
	}
	
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
	}
}
