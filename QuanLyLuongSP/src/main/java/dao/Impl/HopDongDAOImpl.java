package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.HopDongDAO;
import entity.HopDong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class HopDongDAOImpl extends UnicastRemoteObject implements HopDongDAO{

	
	private static final long serialVersionUID = 5929402348281005333L;
	private EntityManagerFactory emf;
	
	public HopDongDAOImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	
    public int getMaxEmployeeNumber() {
        EntityManager em = emf.createEntityManager(); // Mở EntityManager
        try {
            // Sử dụng JPQL để truy vấn mã nhân viên lớn nhất
            TypedQuery<Integer> query = em.createQuery("SELECT MAX(CAST(SUBSTRING(sp.maSanPham, 3, LENGTH(sp.maSanPham) - 2) AS int)) FROM SanPham sp", Integer.class);
            
            Integer maxEmployeeNumber = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
            
            // Nếu không có kết quả, trả về 0
            if (maxEmployeeNumber == null) {
                return 0;
            }
            
            return maxEmployeeNumber;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close(); // Đóng EntityManager sau khi sử dụng
        }
        
        return 0; // Trả về giá trị mặc định nếu có lỗi
    }

	@Override
	public boolean ThemHopDong(HopDong hd) throws RemoteException {
        EntityManager em = emf.createEntityManager(); // Mở EntityManager
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            em.persist(hd); // Thêm hợp đồng vào bảng
            
            tx.commit();
            
            return true;
        }catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close(); // Đóng EntityManager sau khi sử dụng
        }
        
        return false;
	}

	@Override
	public boolean CapNhatHopDong(HopDong hd) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(hd); // Cập nhật hợp đồng vào bảng

			tx.commit();

			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return false;
	}

	@Override
	public String XoaHopDong(String maHD) throws RemoteException {
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();

	        // Tìm sản phẩm dựa trên mã sản phẩm
	        HopDong hd = em.find(HopDong.class, maHD);

	        if (hd != null) {
	            em.remove(hd); // Xóa hợp đồng từ cơ sở dữ liệu
	            tx.commit();
	            return "Xóa hợp đồng thành công";
	        } else {
	            return "Không tìm thấy hợp đồng với mã: " + maHD;
	        }
	    } catch (Exception e) {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	        return "Xóa hợp đồng thất bại";
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }
	}

	@Override
	public List<HopDong> getDanhSachHopDong() throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<HopDong> query = em.createQuery("SELECT hd FROM HopDong hd", HopDong.class);

			List<HopDong> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}
	//Viết hàm tìm hợp đồng theo mã nhân viên trả về list hợp đồng
	@Override
	public List<HopDong> getHopDongTheoMaNV(String maNV)  {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<HopDong> query = em.createQuery("SELECT hd FROM HopDong hd WHERE hd.maNhanVien.maNhanVien = :maNV",
					HopDong.class);
			query.setParameter("maNV", maNV);
			List<HopDong> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}
	
	
	////Viết hàm tìm hợp đồng theo tên khách hàng trả về list hợp đồng
	@Override
	public List<HopDong> getHopDongTheoTenKH(String tenKH)  {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<HopDong> query = em.createQuery("SELECT hd FROM HopDong hd WHERE hd.tenKhachHang = :tenKH",
					HopDong.class);
			query.setParameter("tenKH", tenKH);
			List<HopDong> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}
	
	

}
