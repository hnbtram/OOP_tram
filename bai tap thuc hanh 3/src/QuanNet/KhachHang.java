import java.util.ArrayList;
import java.util.List;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private double soDuTaiKhoan;
    private List<String> lichSuDichVu;

    public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.soDuTaiKhoan = 0;
        this.lichSuDichVu = new ArrayList<>();
    }

    // Getter và Setter
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public double getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void napTien(double soTien) {
        this.soDuTaiKhoan += soTien;
    }

    public boolean truTien(double soTien) {
        if (soDuTaiKhoan >= soTien) {
            soDuTaiKhoan -= soTien;
            return true;
        }
        return false;
    }

    public List<String> getLichSuDichVu() {
        return lichSuDichVu;
    }

    public void themLichSuDichVu(String dichVu) {
        lichSuDichVu.add(dichVu);
    }
}