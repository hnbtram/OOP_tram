package testQuannet;

public class TestQuanlyMayTinh {
    public static void test() {
        QuanNet.QuanLyMayTinh quanLy = new QuanNet.QuanLyMayTinh();
        
        // Create some MayTinh objects
        QuanNet.MayTinh mt1 = new QuanNet.MayTinh(1, 10000);
        QuanNet.MayTinh mt2 = new QuanNet.MayTinh(2, 15000);
        
        // Add MayTinh objects
        quanLy.themMayTinh(mt1);
        quanLy.themMayTinh(mt2);

        // Phan mem 
        mt1.themPhanMem("Liên Minh Huyền Thoại");
        mt1.themPhanMem("Valorant");
        
       // 
        System.out.println("Danh sach phan mem tren may tinh 1: " + mt1.getDanhSachPhanMem());
        System.out.println("Danh sach phan mem tren may tinh 2: " + mt2.getDanhSachPhanMem());
        // Display all MayTinh
        System.out.println("Danh sach may tinh:");
        for (QuanNet.MayTinh mt : quanLy.getDanhSachMayTinh()) {
            System.out.println(mt);
        }
        
        // Find a MayTinh
        System.out.println("Tim may tinh voi ID 1: " + quanLy.timMayTinh(1));
        
        // Update a MayTinh
        QuanNet.MayTinh mtUpdate = new QuanNet.MayTinh(1, 20000);
        quanLy.capNhatMayTinh(mtUpdate);
        System.out.println("Sau khi cap nhat:");
        System.out.println(quanLy.timMayTinh(1));
        
        // Delete a MayTinh
        quanLy.xoaMayTinh(2);
        System.out.println("Danh sach may tinh sau khi xoa:");
        for (QuanNet.MayTinh mt : quanLy.getDanhSachMayTinh()) {
            System.out.println(mt);
        }
        

    }

}