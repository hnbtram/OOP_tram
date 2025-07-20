
package QuanNet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyThanhToan {
    private List<ThanhToan> danhSachHoaDon;
    private Scanner scanner;
    private QuanLyKhachHang quanLyKhachHang;
    private QuanLyMayTinh quanLyMayTinh;

    public QuanLyThanhToan(QuanLyKhachHang qlkh, QuanLyMayTinh qlmt) {
        this.danhSachHoaDon = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.quanLyKhachHang = qlkh;
        this.quanLyMayTinh = qlmt;
    }

    // Tạo hóa đơn mới
    public void taoHoaDon() {
        System.out.println("\n--- TẠO HÓA ĐƠN THANH TOÁN ---");
        
        // Chọn khách hàng
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        KhachHang kh = quanLyKhachHang.timKhachHang(maKH);
        if (kh == null) {
            System.out.println("Không tìm thấy khách hàng!");
            return;
        }
        
        // Chọn máy tính
        System.out.print("Nhập ID máy tính: ");
        int idMay = Integer.parseInt(scanner.nextLine());
        MayTinh may = quanLyMayTinh.timMayTinh(idMay);
        if (may == null || may.getThoiGianBatDau() == null) {
            System.out.println("Máy tính không tồn tại hoặc chưa được sử dụng!");
            return;
        }
        
        ThanhToan hoaDon = new ThanhToan(kh, may);
        hoaDon.tinhTienMayTinh();
        
        // Thêm dịch vụ
        while (true) {
            System.out.print("Thêm dịch vụ? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) break;
            
            System.out.print("Tên dịch vụ: ");
            String tenDV = scanner.nextLine();
            System.out.print("Giá tiền: ");
            double giaTien = Double.parseDouble(scanner.nextLine());
            
            hoaDon.themDichVu(tenDV, giaTien);
        }
        
        // Áp dụng khuyến mãi
        System.out.print("Áp dụng khuyến mãi (%): ");
        double khuyenMai = Double.parseDouble(scanner.nextLine());
        hoaDon.apDungKhuyenMai(khuyenMai);
        
        // Xác nhận thanh toán
        hoaDon.xacNhanThanhToan();
        danhSachHoaDon.add(hoaDon);
        
        // In hóa đơn
        System.out.println("\nĐÃ THANH TOÁN THÀNH CÔNG!");
        hoaDon.inHoaDon();
    }

    // Xem lịch sử hóa đơn
    public void xemDanhSachHoaDon() {
        System.out.println("\n--- DANH SÁCH HÓA ĐƠN ---");
        if (danhSachHoaDon.isEmpty()) {
            System.out.println("Chưa có hóa đơn nào!");
            return;
        }
        
        for (ThanhToan hd : danhSachHoaDon) {
            System.out.println("Mã HD: " + hd.getMaHoaDon());
            System.out.println("KH: " + hd.getKhachHang().getHoTen());
            System.out.println("Máy: #" + hd.getMayTinh().getId());
            System.out.println("Thành tiền: " + String.format("%,.0f", hd.getThanhTien()) + " VND");
            System.out.println("----------------------------------");
        }
    }

    // Tìm hóa đơn theo mã
    public ThanhToan timHoaDon(String maHoaDon) {
        for (ThanhToan hd : danhSachHoaDon) {
            if (hd.getMaHoaDon().equals(maHoaDon)) {
                return hd;
            }
        }
        return null;
    }

    // Xóa hóa đơn
    public boolean xoaHoaDon(String maHoaDon) {
        return danhSachHoaDon.removeIf(hd -> hd.getMaHoaDon().equals(maHoaDon));
    }

    // Menu quản lý thanh toán
    public void hienThiMenu() {
        while (true) {
            System.out.println("\n===== QUẢN LÝ THANH TOÁN =====");
            System.out.println("1. Tạo hóa đơn thanh toán");
            System.out.println("2. Xem danh sách hóa đơn");
            System.out.println("3. Xem chi tiết hóa đơn");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn chức năng (1-5): ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            if (choice == 5) break;
            
            switch (choice) {
                case 1:
                    taoHoaDon();
                    break;
                case 2:
                    xemDanhSachHoaDon();
                    break;
                case 3:
                    System.out.print("Nhập mã hóa đơn: ");
                    String maHD = scanner.nextLine();
                    ThanhToan hd = timHoaDon(maHD);
                    if (hd != null) {
                        hd.inHoaDon();
                    } else {
                        System.out.println("Không tìm thấy hóa đơn!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã hóa đơn cần xóa: ");
                    maHD = scanner.nextLine();
                    if (xoaHoaDon(maHD)) {
                        System.out.println("Đã xóa hóa đơn thành công!");
                    } else {
                        System.out.println("Không tìm thấy hóa đơn!");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}