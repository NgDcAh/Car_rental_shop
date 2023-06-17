package UI;

import Model.HopDong;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class View extends JFrame {

    JTextField txtMaHD, txtHoten, txtCC, txtSDT, txtDiaChi, txtTime, txtBienSoXe;
    JButton btnLuu, btnXoa, btnCapNhat, btnTimKiem, btnThoat, btnDoanhThu;
    JComboBox cbo, cbTime;
    JDateChooser cdStartTime, cdStart, cdEnd;

    DefaultTableModel dtmKH;
    JTable tblKH;


    static ArrayList<HopDong> dsHD;


    public View(String tieuDe){
        super(tieuDe);
        dsHD = new ArrayList<>();
        addControls();
        addEvents();
        fiveDataDefautl();
    }


    private void hienThi(){
        HopDong hd = dsHD.get(dsHD.size()-1);
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        String startTime = sdf.format(hd.getTGs());
        dtmKH.addRow(new Object[]{
                hd.getMaHD(),
                hd.getTenKH(),
                hd.getCCCD(),
                hd.getSDT(),
                hd.getDiaChi(),
                startTime,
                hd.getQuantity() + " " + hd.getTime(),
                hd.getBienSoXe(),
                hd.getLoaiXe(),
                hd.getChiPhi(),
        });
    }

    public void showWindow(){
        this.setSize(1200,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void addEvents(){
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchUI s = new SearchUI("Tìm kiếm hợp đồng");
                s.showWindow();
            }
        });

        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyLuu();

            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ma = txtMaHD.getText();
                xuLyXoa(ma);
                int row = tblKH.getSelectedRow();
                if (row == -1)return;
                dtmKH.removeRow(row);
                clear();
            }
        });

        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ma = txtMaHD.getText();
                xuLyCapNhat(ma);
                clear();


            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        tblKH.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblKH.getSelectedRow();
                if (row == -1)return;
                String ma = tblKH.getValueAt(row, 0)+ "";
                hienThiTheoMa(ma);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        btnDoanhThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhDoanhThu();
            }
        });
    }

    private void fiveDataDefautl(){
        HopDong h1 = new HopDong();
        h1.setMaHD("A001");
        h1.setTenKH("Nguyễn Thái An");
        h1.setCCCD("012345678910");
        h1.setSDT("0121212121");
        h1.setDiaChi("Thái Nguyên");
        try {
            h1.setTGs(new SimpleDateFormat("dd/MM/yyyy").parse("17/12/2021"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        h1.setQuantity(3);
        h1.setTime("Tháng");
        h1.setBienSoXe("ABC-9999");
        h1.setLoaiXe("SH");
        h1.setChiPhi(getChiPhi(h1));

        dsHD.add(h1);
        hienThi();


        HopDong h2 = new HopDong();
        h2.setMaHD("B002");
        h2.setTenKH("Nguyễn Đức Anh");
        h2.setCCCD("012345678910");
        h2.setSDT("0999999999");
        h2.setDiaChi("Hà Nội");
        try {
            h2.setTGs(new SimpleDateFormat("dd/MM/yyyy").parse("18/12/2021"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        h2.setQuantity(3);
        h2.setTime("Ngày");
        h2.setBienSoXe("ABC-0000");
        h2.setLoaiXe("Moto");
        h2.setChiPhi(getChiPhi(h2));

        dsHD.add(h2);
        hienThi();

        HopDong h3 = new HopDong();
        h3.setMaHD("C003");
        h3.setTenKH("Nguyễn Trường Việt");
        h3.setCCCD("012345678910");
        h3.setSDT("0563874529");
        h3.setDiaChi("Hà Nội");
        try {
            h3.setTGs(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2021"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        h3.setQuantity(5);
        h3.setTime("Tháng");
        h3.setBienSoXe("ABC-1111");
        h3.setLoaiXe("Lead");
        h3.setChiPhi(getChiPhi(h3));

        dsHD.add(h3);
        hienThi();

        HopDong h4 = new HopDong();
        h4.setMaHD("D004");
        h4.setTenKH("Lê văn A");
        h4.setCCCD("012345678910");
        h4.setSDT("0912764826");
        h4.setDiaChi("Bắc Ninh");
        try {
            h4.setTGs(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2021"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        h4.setQuantity(20);
        h4.setTime("Ngày");
        h4.setBienSoXe("ABC-2222");
        h4.setLoaiXe("Lead");
        h4.setChiPhi(getChiPhi(h4));

        dsHD.add(h4);
        hienThi();

        HopDong h5 = new HopDong();
        h5.setMaHD("E005");
        h5.setTenKH("Trần Đức B");
        h5.setCCCD("012345678910");
        h5.setSDT("0912764826");
        h5.setDiaChi("Nghệ An");
        try {
            h5.setTGs(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2021"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        h5.setQuantity(10);
        h5.setTime("Tháng");
        h5.setBienSoXe("ABC-3333");
        h5.setLoaiXe("Lead");
        h5.setChiPhi(getChiPhi(h5));

        dsHD.add(h5);
        hienThi();

    }

    private int getChiPhi(HopDong hd){
        if (hd.getTime().equals("Ngày")){
            return hd.getQuantity() * 150000;
        }
        else {
            return hd.getQuantity() * 3000000 + 1000000;
        }

    }


    private void clear(){
        txtMaHD.setText("");
        txtHoten.setText("");
        txtCC.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        cdStartTime.setDate(null);
        txtTime.setText("");
        cbTime.setSelectedItem("Ngày");
        txtBienSoXe.setText("");
        cbo.setSelectedItem("Lead");
    }

    private void xuLyLuu() {
        for(int i=0; i < dsHD.size(); i++){
            if (txtMaHD.getText().equals(dsHD.get(i).getMaHD())){
                JOptionPane.showMessageDialog(null, "Mã " + dsHD.get(i).getMaHD() + " đã tồn tại!");
                break;
            }
            if (txtMaHD.getText().equals("") || txtHoten.getText().equals("") || txtCC.getText().equals("") || txtSDT.getText().equals("") || txtDiaChi.getText().equals("") || txtTime.getText().equals("") || txtBienSoXe.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
                break;
            }
            else {
                HopDong hd = new HopDong();
                hd.setMaHD(txtMaHD.getText());
                hd.setTenKH(txtHoten.getText());
                hd.setCCCD(txtCC.getText());
                hd.setSDT(txtSDT.getText());
                hd.setDiaChi(txtDiaChi.getText());
                hd.setTGs(cdStartTime.getDate());
                hd.setQuantity(Integer.parseInt(txtTime.getText()));
                hd.setTime(cbTime.getSelectedItem().toString());
                hd.setBienSoXe(txtBienSoXe.getText());
                hd.setLoaiXe(cbo.getSelectedItem().toString());
                hd.setChiPhi(getChiPhi(hd));

                dsHD.add(hd);
                JOptionPane.showMessageDialog(null, "Lưu thành công");
                hienThi();
                clear();
                break;
            }
        }

    }



    protected void xuLyXoa(String ma){
        for(int i=0; i < dsHD.size(); i++) {
            if (ma.equals(dsHD.get(i).getMaHD())){
                dsHD.remove(i);
            }
        }
    }

    private void xuLyCapNhat(String ma){
        int row = tblKH.getSelectedRow();
        if (row == -1)return;
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        for(int i=0; i < dsHD.size(); i++){
            if (ma.equals(dsHD.get(i).getMaHD())){

                dsHD.get(i).setTenKH(txtHoten.getText());
                dsHD.get(i).setCCCD(txtCC.getText());
                dsHD.get(i).setSDT(txtSDT.getText());
                dsHD.get(i).setDiaChi(txtDiaChi.getText());
                dsHD.get(i).setTGs(cdStartTime.getDate());
                dsHD.get(i).setQuantity(Integer.parseInt(txtTime.getText()));
                dsHD.get(i).setTime(cbTime.getSelectedItem().toString());
                dsHD.get(i).setBienSoXe(txtBienSoXe.getText());
                dsHD.get(i).setLoaiXe(cbo.getSelectedItem().toString());
                dsHD.get(i).setChiPhi(getChiPhi(dsHD.get(i)));

                String startTime = sdf.format(dsHD.get(i).getTGs());

                tblKH.setValueAt(dsHD.get(i).getTenKH(),row,1);
                tblKH.setValueAt(dsHD.get(i).getCCCD(),row,2);
                tblKH.setValueAt(dsHD.get(i).getSDT(),row,3);
                tblKH.setValueAt(dsHD.get(i).getDiaChi(),row,4);
                tblKH.setValueAt(startTime,row,5);
                tblKH.setValueAt(dsHD.get(i).getQuantity() + " " + dsHD.get(i).getTime(),row,6);
                tblKH.setValueAt(dsHD.get(i).getBienSoXe(),row,7);
                tblKH.setValueAt(dsHD.get(i).getLoaiXe(),row,8);
                tblKH.setValueAt(dsHD.get(i).getChiPhi(),row,9);
            }
        }
    }



    private void hienThiTheoMa (String ma){
        for(int i=0; i < dsHD.size(); i++){
            if (ma.equals(dsHD.get(i).getMaHD())){
                txtMaHD.setText(dsHD.get(i).getMaHD());
                txtHoten.setText(dsHD.get(i).getTenKH());
                txtCC.setText(dsHD.get(i).getCCCD());
                txtSDT.setText(dsHD.get(i).getSDT());
                txtDiaChi.setText(dsHD.get(i).getDiaChi());
                cdStartTime.setDate(dsHD.get(i).getTGs());
                txtTime.setText(String.valueOf(dsHD.get(i).getQuantity()));
                cbTime.setSelectedItem(dsHD.get(i).getTime());
                txtBienSoXe.setText(dsHD.get(i).getBienSoXe());
                cbo.setSelectedItem(dsHD.get(i).getLoaiXe());
            }
        }
    }

    private boolean soSanh_2_Ngay(JDateChooser d1, JDateChooser d2){
        if (d1.getDate().before(d2.getDate())) return true;

        else return false;
    }

    private boolean soSanh_3_Ngay(JDateChooser d1, Date d2, JDateChooser d3){
        if (d1.getDate().before(d2) && d3.getDate().after(d2)) return true;
        else return false;
    }

    private void tinhDoanhThu(){
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        String ST = sdf.format(cdStart.getDate());
        String ET = sdf.format(cdEnd.getDate());
        int dt = 0;

        if (soSanh_2_Ngay(cdStart, cdEnd)){
            for(int i=0; i < dsHD.size(); i++) {
                if (soSanh_3_Ngay(cdStart, dsHD.get(i).getTGs(), cdEnd)){
                    dt += dsHD.get(i).getChiPhi();
                }
            }
            JOptionPane.showMessageDialog(null, "Doanh thu từ " + ST + " đến " + ET +" là: " + dt);
        }
        else {
            JOptionPane.showMessageDialog(null,"Sai khoảng thời gian!");
        }
    }

    private void addControls(){
        Container con = getContentPane();

        JPanel pnNorth = new JPanel();
        JPanel pnCenter = new JPanel();
        JPanel pnSouth = new JPanel();
        con.add(pnNorth, BorderLayout.NORTH);
        con.add(pnCenter, BorderLayout.CENTER);
        con.add(pnSouth, BorderLayout.SOUTH);

        pnNorth.setLayout(new BorderLayout());
        JLabel lblTitle = new JLabel("Quản lý cửa hàng thuê xe");
        Font font = new Font("arial", Font.BOLD, 40);
        lblTitle.setForeground(Color.RED);
        lblTitle.setFont(font);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);


        pnNorth.add(lblTitle, BorderLayout.NORTH);
        JPanel pnMain = new JPanel();
        pnNorth.add(pnMain, BorderLayout.CENTER);
        JPanel pnAction = new JPanel();
        pnNorth.add(pnAction, BorderLayout.EAST);

        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnMa = new JPanel();
        JLabel lblMa = new JLabel("Mã hợp đồng:");
        txtMaHD = new JTextField(30);
        pnMa.add(lblMa);
        pnMa.add(txtMaHD);
        pnMain.add(pnMa);

        JPanel pnHoten = new JPanel();
        JLabel lblHoten = new JLabel("Họ và tên:");
        txtHoten = new JTextField(30);
        pnHoten.add(lblHoten);
        pnHoten.add(txtHoten);
        pnMain.add(pnHoten);

        JPanel pnCC = new JPanel();
        JLabel lblCC = new JLabel("Số CCCD:");
        txtCC = new JTextField(30);
        pnCC.add(lblCC);
        pnCC.add(txtCC);
        pnMain.add(pnCC);

        JPanel pnSDT = new JPanel();
        JLabel lblSDT = new JLabel("Số DT:");
        txtSDT = new JTextField(30);
        pnSDT.add(lblSDT);
        pnSDT.add(txtSDT);
        pnMain.add(pnSDT);

        JPanel pnDiaChi = new JPanel();
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        txtDiaChi = new JTextField(30);
        pnDiaChi.add(lblDiaChi);
        pnDiaChi.add(txtDiaChi);
        pnMain.add(pnDiaChi);

        JPanel pnStartTime = new JPanel();
        JLabel lblStartTime = new JLabel("Thời gian bắt đầu thuê:");
        cdStartTime = new JDateChooser();
        pnStartTime.add(lblStartTime);
        pnStartTime.add(cdStartTime);
        pnMain.add(pnStartTime);

        JPanel pnTime = new JPanel();
        JLabel lblTime = new JLabel("Thời gian thuê:");
        cbTime = new JComboBox<>();
        cbTime.addItem("Ngày");
        cbTime.addItem("Tháng");
        txtTime = new JTextField(20);
        pnTime.add(lblTime);
        pnTime.add(txtTime);
        pnTime.add(cbTime);
        pnMain.add(pnTime);

        JPanel pnBienSoXe = new JPanel();
        JLabel lblBienSoXe = new JLabel("Biển số xe:");
        txtBienSoXe = new JTextField(30);
        pnBienSoXe.add(lblBienSoXe);
        pnBienSoXe.add(txtBienSoXe);
        pnMain.add(pnBienSoXe);

        JPanel pnLoaiXe = new JPanel();
        JLabel lblLoaiXe = new JLabel("Loại xe:");
        cbo = new JComboBox();
        cbo.addItem("Lead");
        cbo.addItem("SH");
        cbo.addItem("Dream");
        cbo.addItem("Moto");
        pnLoaiXe.add(lblLoaiXe);
        pnLoaiXe.add(cbo);
        pnMain.add(pnLoaiXe);



        pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
        pnAction.setPreferredSize(new Dimension(300, 0));

        JPanel pnLuu = new JPanel();
        pnAction.add(pnLuu);
        btnLuu = new JButton("Lưu");
        pnLuu.add(btnLuu);


        JPanel pnXoa = new JPanel();
        pnAction.add(pnXoa);
        btnXoa = new JButton("Xóa");
        pnXoa.add(btnXoa);

        JPanel pnCapNhat = new JPanel();
        pnAction.add(pnCapNhat);
        btnCapNhat = new JButton("Cập nhật");
        pnCapNhat.add(btnCapNhat);

        JPanel pnTimKiem = new JPanel();
        pnAction.add(pnTimKiem);
        btnTimKiem = new JButton("Tìm kiếm");
        pnTimKiem.add(btnTimKiem);

        JPanel pnThoat = new JPanel();
        pnAction.add(pnThoat);
        btnThoat = new JButton("Thoát");
        pnThoat.add(btnThoat);

        pnCenter.setLayout(new BorderLayout());
        JLabel lblDS = new JLabel("Danh sách hợp đồng");
        lblDS.setForeground(Color.BLUE);
        lblDS.setFont(font);
        lblDS.setHorizontalAlignment(JLabel.CENTER);
        pnCenter.add(lblDS, BorderLayout.NORTH);

        dtmKH = new DefaultTableModel();
        dtmKH.addColumn("Mã HĐ");
        dtmKH.addColumn("Tên KH");
        dtmKH.addColumn("Số CCCD");
        dtmKH.addColumn("Số DT");
        dtmKH.addColumn("Địa chỉ");
        dtmKH.addColumn("Thời gian bắt đầu");
        dtmKH.addColumn("Thời gian thuê");
        dtmKH.addColumn("Biển số");
        dtmKH.addColumn("Loại xe");
        dtmKH.addColumn("Chi phí");
        tblKH = new JTable(dtmKH);
        JScrollPane scrollPane = new JScrollPane(tblKH, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnCenter.add(scrollPane,BorderLayout.CENTER);

        pnSouth.setLayout(new FlowLayout());
        JLabel lblStart = new JLabel("Thời gian bắt đầu:");
        cdStart = new JDateChooser();
        JLabel lblEnd = new JLabel("Thời gian kết thúc: ");
        cdEnd = new JDateChooser();
        btnDoanhThu = new JButton("Tính doanh thu");
        pnSouth.add(lblStart);
        pnSouth.add(cdStart);
        pnSouth.add(lblEnd);
        pnSouth.add(cdEnd);
        pnSouth.add(btnDoanhThu);

        TitledBorder borderMain = new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Thông tin khách hàng");
        borderMain.setTitleColor(Color.RED);
        Font fontBorder = new Font("arial", Font.CENTER_BASELINE, 20);
        borderMain.setTitleFont(fontBorder);
        pnMain.setBorder(borderMain);

        TitledBorder borderAction = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Thực hiện");
        borderAction.setTitleColor(Color.BLUE);
        borderAction.setTitleFont(fontBorder);
        pnAction.setBorder(borderAction);

        TitledBorder borderTable = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE));
        scrollPane.setBorder(borderTable);

        lblMa.setPreferredSize(lblStartTime.getPreferredSize());
        lblHoten.setPreferredSize(lblStartTime.getPreferredSize());
        lblDiaChi.setPreferredSize(lblStartTime.getPreferredSize());
        lblCC.setPreferredSize(lblStartTime.getPreferredSize());
        lblSDT.setPreferredSize(lblStartTime.getPreferredSize());
        lblTime.setPreferredSize(lblStartTime.getPreferredSize());
        lblBienSoXe.setPreferredSize(lblStartTime.getPreferredSize());
        lblLoaiXe.setPreferredSize(lblStartTime.getPreferredSize());

        cdStartTime.setPreferredSize(txtHoten.getPreferredSize());
        cbo.setPreferredSize(txtHoten.getPreferredSize());
        cbTime.setPreferredSize(new Dimension(100, 20));
        cdStart.setPreferredSize(new Dimension(150,20));
        cdEnd.setPreferredSize(new Dimension(150,20));

        btnLuu.setIcon(new ImageIcon("imgs/save.png"));
        btnXoa.setIcon(new ImageIcon("imgs/delete.png"));
        btnCapNhat.setIcon(new ImageIcon("imgs/update.png"));
        btnTimKiem.setIcon(new ImageIcon("imgs/search.png"));
        btnThoat.setIcon(new ImageIcon("imgs/cancel.png"));
        btnDoanhThu.setIcon(new ImageIcon("imgs/calculator.png"));


        btnCapNhat.setPreferredSize(new Dimension(150, 30));
        btnLuu.setPreferredSize(btnCapNhat.getPreferredSize());
        btnXoa.setPreferredSize(btnCapNhat.getPreferredSize());
        btnTimKiem.setPreferredSize(btnCapNhat.getPreferredSize());
        btnThoat.setPreferredSize(btnCapNhat.getPreferredSize());


    }

}
