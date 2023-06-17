package Model;

import java.util.Date;

public class HopDong {

    private String MaHD;
    private String TenKH;
    private String CCCD;
    private String SDT;
    private String DiaChi;
    private Date TGs;
    private int Quantity;
    private String Time;
    private String BienSoXe;
    private String LoaiXe;
    private int ChiPhi;

    public HopDong(){

    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public Date getTGs() {
        return TGs;
    }

    public void setTGs(Date TGs) {
        this.TGs = TGs;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getBienSoXe() {
        return BienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        BienSoXe = bienSoXe;
    }

    public String getLoaiXe() {
        return LoaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        LoaiXe = loaiXe;
    }

    public int getChiPhi() {
        return ChiPhi;
    }

    public void setChiPhi(int chiPhi) {
        ChiPhi = chiPhi;
    }

}