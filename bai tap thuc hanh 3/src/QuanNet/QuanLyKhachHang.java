import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHang {
    private List<KhachHang> danhSachKhachHang;

    public QuanLyKhachHang() {
        this.danhSachKhachHang = new ArrayList<>();
    }

    public void themKhachHang(KhachHang khachHang) {
        danhSachKhachHang.add(khachHang);
    }

    public boolean xoaKhachHang(String maKhachHang) {
        return danhSachKhachHang.removeIf(kh -> kh.getMaKhachHang().equals(maKhachHang));
    }

    public KhachHang timKhachHang(String maKhachHang) {
        return danhSachKhachHang.stream()
                .filter(kh -> kh.getMaKhachHang().equals(maKhachHang))
                .findFirst()
                .orElse(null);
    }

    public List<KhachHang> getDanhSachKhachHang() {
        return new ArrayList<>(danhSachKhachHang);
    }

    public boolean napTien(String maKhachHang, double soTien) {
        KhachHang kh = timKhachHang(maKhachHang);
        if (kh != null) {
            kh.napTien(soTien);
            return true;
        }
        return false;
    }
}