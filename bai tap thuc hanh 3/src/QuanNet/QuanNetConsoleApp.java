package QuanNet;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.text.NumberFormat;
import java.util.stream.Collectors;

public class QuanNetConsoleApp {
    private static QuanLyMayTinh quanLyMayTinh = new QuanLyMayTinh();
    private static QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static QuanLyThanhToan quanLyThanhToan = new QuanLyThanhToan(quanLyKhachHang, quanLyMayTinh);
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private static NumberFormat nf = NumberFormat.getNumberInstance(new Locale("vi", "VN"));

    public static void main(String[] args) {
        khoiTaoDuLieuMau();
        
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║   HỆ THỐNG QUẢN LÝ QUÁN NET    ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Quản lý máy tính           ║");
            System.out.println("║ 2. Quản lý khách hàng         ║");
            System.out.println("║ 3. Quản lý thanh toán         ║");
            System.out.println("║ 4. Thống kê doanh thu         ║");
            System.out.println("║ 5. Thoát chương trình         ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-5): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        quanLyMayTinhMenu();
                        break;
                    case 2:
                        quanLyKhachHangMenu();
                        break;
                    case 3:
                        quanLyThanhToan.hienThiMenu();
                        break;
                    case 4:
                        thongKeDoanhThu();
                        break;
                    case 5:
                        System.out.println("\nCảm ơn đã sử dụng chương trình!");
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 5!");
            }
        }
    }

    private static void khoiTaoDuLieuMau() {
        // Thêm máy tính mẫu
        quanLyMayTinh.themMayTinh(new MayTinh(1, 15000));
        quanLyMayTinh.themMayTinh(new MayTinh(2, 20000));
        quanLyMayTinh.themMayTinh(new MayTinh(3, 18000));
        
        // Thêm khách hàng mẫu
        quanLyKhachHang.themKhachHang(new KhachHang("KH001", "Nguyễn Văn A", "0912345678"));
        quanLyKhachHang.themKhachHang(new KhachHang("KH002", "Trần Thị B", "0987654321"));
    }

    private static void quanLyMayTinhMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      QUẢN LÝ MÁY TÍNH        ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Thêm máy tính mới         ║");
            System.out.println("║ 2. Hiển thị danh sách máy    ║");
            System.out.println("║ 3. Cập nhật giá máy          ║");
            System.out.println("║ 4. Xóa máy tính              ║");
            System.out.println("║ 5. Quản lý trạng thái máy    ║");
            System.out.println("║ 6. Quản lý phần mềm          ║");
            System.out.println("║ 7. Bắt đầu sử dụng máy       ║");
            System.out.println("║ 8. Kết thúc sử dụng máy      ║");
            System.out.println("║ 9. Quay lại menu chính       ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-9): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 9) break;

                switch (choice) {
                    case 1:
                        themMayTinh();
                        break;
                    case 2:
                        hienThiDanhSachMayTinh();
                        break;
                    case 3:
                        capNhatGiaMayTinh();
                        break;
                    case 4:
                        xoaMayTinh();
                        break;
                    case 5:
                        quanLyTrangThaiMayTinh();
                        break;
                    case 6:
                        quanLyPhanMemMayTinh();
                        break;
                    case 7:
                        batDauSuDungMay();
                        break;
                    case 8:
                        ketThucSuDungMay();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 9!");
            }
        }
    }

    private static void quanLyKhachHangMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      QUẢN LÝ KHÁCH HÀNG       ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Thêm khách hàng mới        ║");
            System.out.println("║ 2. Hiển thị danh sách KH      ║");
            System.out.println("║ 3. Cập nhật thông tin KH      ║");
            System.out.println("║ 4. Xóa khách hàng             ║");
            System.out.println("║ 5. Nạp tiền cho KH            ║");
            System.out.println("║ 6. Xem lịch sử dịch vụ        ║");
            System.out.println("║ 7. Quay lại menu chính        ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-7): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 7) break;

                switch (choice) {
                    case 1:
                        themKhachHang();
                        break;
                    case 2:
                        hienThiDanhSachKhachHang();
                        break;
                    case 3:
                        capNhatKhachHang();
                        break;
                    case 4:
                        xoaKhachHang();
                        break;
                    case 5:
                        napTienKhachHang();
                        break;
                    case 6:
                        xemLichSuDichVuKhachHang();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 7!");
            }
        }
    }

    // Các phương thức quản lý máy tính
    private static void themMayTinh() {
        System.out.println("\n--- THÊM MÁY TÍNH MỚI ---");
        System.out.print("Nhập ID máy tính: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nhập giá tiền theo giờ (VND): ");
        double giaTien = Double.parseDouble(scanner.nextLine());
        
        MayTinh mayTinh = new MayTinh(id, giaTien);
        quanLyMayTinh.themMayTinh(mayTinh);
        System.out.println("Đã thêm máy tính thành công!");
    }

    private static void hienThiDanhSachMayTinh() {
        System.out.println("\n--- DANH SÁCH MÁY TÍNH ---");
        List<MayTinh> danhSach = quanLyMayTinh.getDanhSachMayTinh();
        
        if (danhSach.isEmpty()) {
            System.out.println("Không có máy tính nào trong hệ thống!");
            return;
        }
        
        System.out.printf("%-5s %-15s %-20s %-15s %-20s%n", 
            "ID", "Trạng thái", "Giá/giờ", "Phần mềm", "Thời gian sử dụng");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (MayTinh may : danhSach) {
            String trangThai = may.getTrangThai().toString();
            String giaTien = nf.format(may.getGiaTienTheoGio()) + " VND";
            String phanMem = may.getDanhSachPhanMem().isEmpty() ? "Không có" 
                : String.join(", ", may.getDanhSachPhanMem());
            
            String thoiGian = "Chưa sử dụng";
            if (may.getThoiGianBatDau() != null) {
                if (may.getThoiGianKetThuc() != null) {
                    long phut = Duration.between(may.getThoiGianBatDau(), may.getThoiGianKetThuc()).toMinutes();
                    thoiGian = String.format("%d phút", phut);
                } else {
                    thoiGian = "Đang sử dụng từ " + may.getThoiGianBatDau().format(dtf);
                }
            }
            
            System.out.printf("%-5d %-15s %-20s %-15s %-20s%n", 
                may.getId(), trangThai, giaTien, phanMem, thoiGian);
        }
    }

    // ... (Các phương thức khác tương tự)

    private static void thongKeDoanhThu() {
        System.out.println("\n--- THỐNG KÊ DOANH THU ---");
        
        // Thống kê theo ngày
        Map<LocalDate, Double> doanhThuTheoNgay = quanLyThanhToan.getDanhSachHoaDon().stream()
            .collect(Collectors.groupingBy(
                hd -> hd.getThoiGianThanhToan().toLocalDate(),
                Collectors.summingDouble(ThanhToan::getThanhTien)
            ));
        
        System.out.println("\nDoanh thu theo ngày:");
        System.out.printf("%-15s %-15s%n", "Ngày", "Doanh thu");
        System.out.println("-------------------------------");
        doanhThuTheoNgay.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.printf("%-15s %15s VND%n", 
                    entry.getKey().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
                    nf.format(entry.getValue()));
            });
        
        // Tổng doanh thu
        double tongDoanhThu = quanLyThanhToan.getDanhSachHoaDon().stream()
            .mapToDouble(ThanhToan::getThanhTien)
            .sum();
        
        System.out.println("\nTổng doanh thu: " + nf.format(tongDoanhThu) + " VND");
    }
}