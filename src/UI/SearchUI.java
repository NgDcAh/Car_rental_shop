package UI;

import Model.HopDong;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import static javax.swing.BoxLayout.*;

public class SearchUI extends JFrame{
    JTextField txtHoTen, txtBienSoXe, txtPrice;
    JComboBox cbo;
    JButton btnTim, btnPrice;
    DefaultTableModel dtmKH;
    JTable tblKH;
    ArrayList<HopDong> HD = new ArrayList<>();


    public SearchUI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
                xuLyTimKiem();
                clear();
            }
        });

        btnPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
                xuLyTimKiemPrice();
                clear();
            }
        });
    }

    private void hienThi() {
        HopDong hd = HD.get(HD.size() - 1);
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

    private void clear() {
        txtHoTen.setText("");
        txtBienSoXe.setText("");
        cbo.setSelectedItem("Lead");
        txtPrice.setText("");
    }

    private void clearTable() {
        if (dtmKH.getRowCount() > 0) {
            for (int i = dtmKH.getRowCount() - 1; i > -1; i--) {
                dtmKH.removeRow(i);
            }
        }
    }

    private void xuLyTimKiem() {
        for (int i = 0; i < View.dsHD.size(); i++) {
            if (txtHoTen.getText().equals(View.dsHD.get(i).getTenKH()) && txtBienSoXe.getText().equals(View.dsHD.get(i).getBienSoXe()) && cbo.getSelectedItem().equals(View.dsHD.get(i).getLoaiXe())) {
                HD.add(View.dsHD.get(i));
                hienThi();
            }
        }
    }

    private void xuLyTimKiemPrice() {
        for (int i = 0; i < View.dsHD.size(); i++) {
            if (Integer.parseInt(txtPrice.getText()) < View.dsHD.get(i).getChiPhi()) {
                HD.add(View.dsHD.get(i));
                hienThi();
            }
        }
    }

    private void addControls() {
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new BoxLayout(pnNorth, Y_AXIS));
        con.add(pnNorth, BorderLayout.NORTH);

        JLabel lblTieuDe = new JLabel("Tìm kiếm hợp đồng");
        Font font = new Font("arial", Font.BOLD, 40);
        lblTieuDe.setForeground(Color.RED);
        lblTieuDe.setFont(font);
        lblTieuDe.setHorizontalAlignment(JLabel.CENTER);
        pnNorth.add(lblTieuDe);

        JPanel pnNormal = new JPanel();
        pnNormal.setLayout(new FlowLayout());
        pnNorth.add(pnNormal);
        JLabel lblHoTen = new JLabel("Họ tên:");
        txtHoTen = new JTextField(20);
        JLabel lblBienSoXe = new JLabel("Biển số xe:");
        txtBienSoXe = new JTextField(20);
        JLabel lblLoaiXe = new JLabel("Loại xe");
        cbo = new JComboBox();
        cbo.addItem("Lead");
        cbo.addItem("SH");
        cbo.addItem("Dream");
        cbo.addItem("Moto");
        btnTim = new JButton("Tìm kiếm");
        pnNormal.add(lblHoTen);
        pnNormal.add(txtHoTen);
        pnNormal.add(lblBienSoXe);
        pnNormal.add(txtBienSoXe);
        pnNormal.add(lblLoaiXe);
        pnNormal.add(cbo);
        pnNormal.add(btnTim);

        JPanel pnPrice = new JPanel();
        pnPrice.setLayout(new FlowLayout());
        pnNorth.add(pnPrice);
        JLabel lblPrice = new JLabel("Nhập giá( tìm kiếm giá lớn hơn ):");
        txtPrice = new JTextField(30);
        btnPrice = new JButton("Tìm kiếm");
        pnPrice.add(lblPrice);
        pnPrice.add(txtPrice);
        pnPrice.add(btnPrice);


        JPanel pnCenter = new JPanel();
        con.add(pnCenter, BorderLayout.CENTER);
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
        pnCenter.add(scrollPane, BorderLayout.CENTER);

        TitledBorder borderDS = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE));
        scrollPane.setBorder(borderDS);

    }

    public void showWindow() {
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
