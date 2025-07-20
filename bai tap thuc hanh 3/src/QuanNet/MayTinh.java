package QuanNet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MayTinh {
    private int id;
    private double giaTienTheoGio;
    private TrangThaiMay trangThai;
    private List<String> danhSachPhanMem;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private String maKhachHangDangSuDung;

    public enum TrangThaiMay {
        DANG_RANH, DANG_SU_DUNG, DANG_BAO_TRI
    }

    public MayTinh(int id, double giaTienTheoGio) {
        this.id = id;
        this.giaTienTheoGio = giaTienTheoGio;
        this.trangThai = TrangThaiMay.DANG_RANH;
        this.danhSachPhanMem = new ArrayList<>();
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public double getGiaTienTheoGio() {
        return giaTienTheoGio;
    }

    public void setGiaTienTheoGio(double giaTienTheoGio) {
        this.giaTienTheoGio = giaTienTheoGio;
    }

    public TrangThaiMay getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiMay trangThai) {
        this.trangThai = trangThai;
    }

    public List<String> getDanhSachPhanMem() {
        return danhSachPhanMem;
    }

    public void themPhanMem(String phanMem) {
        if (!danhSachPhanMem.contains(phanMem)) {
            danhSachPhanMem.add(phanMem);
        }
    }

    public void xoaPhanMem(String phanMem) {
        danhSachPhanMem.remove(phanMem);
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDateTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaKhachHangDangSuDung() {
        return maKhachHangDangSuDung;
    }

    public void setMaKhachHangDangSuDung(String maKhachHangDangSuDung) {
        this.maKhachHangDangSuDung = maKhachHangDangSuDung;
    }
}