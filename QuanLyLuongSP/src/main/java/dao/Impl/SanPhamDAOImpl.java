package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.SanPhamDAO;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class SanPhamDAOImpl extends UnicastRemoteObject implements SanPhamDAO {



	private static final long serialVersionUID = 5929402348281005333L;
	private EntityManagerFactory emf;


	public SanPhamDAOImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}

    public int getMaxSPNumber() {
        EntityManager em = emf.createEntityManager(); // Mở EntityManager
        try {
            // Sử dụng JPQL để truy vấn mã nhân viên lớn nhất
            TypedQuery<Integer> query = em.createQuery("SELECT MAX(CAST(SUBSTRING(sp.maSanPham, 3, LENGTH(sp.maSanPham) - 2) AS int)) FROM SanPham sp", Integer.class);
            
            Integer maxSPNumber = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
            
            // Nếu không có kết quả, trả về 0
            if (maxSPNumber == null) {
                return 0;
            }
            
            return maxSPNumber;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close(); // Đóng EntityManager sau khi sử dụng
        }
        
        return 0; // Trả về giá trị mặc định nếu có lỗi
    }

	
	//Viết phương thức thêm 1 sản phẩm vào cơ sở dữ liệu trả về boolean
	@Override
	public boolean ThemSanPham(SanPham sp){
        EntityManager em = emf.createEntityManager(); // Mở EntityManager
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            em.persist(sp); // Thêm sản phẩm vào bảng
            
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
	
	//Viết phương thức cập nhật 1 sản phẩm vào cơ sở dữ liệu trả về boolean
	@Override
	public boolean CapNhatSanPham(SanPham sp) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(sp); // Cập nhật sản phẩm vào bảng

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
	
	//Viết phương thức xóa 1 sản phẩm vào cơ sở dữ liệu trả về String
	@Override
	public String XoaSanPham(String maSP) {
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();

	        // Tìm sản phẩm dựa trên mã sản phẩm
	        SanPham sp = em.find(SanPham.class, maSP);

	        if (sp != null) {
	            em.remove(sp); // Xóa sản phẩm từ cơ sở dữ liệu
	            tx.commit();
	            return "Xóa sản phẩm thành công";
	        } else {
	            return "Không tìm thấy sản phẩm với mã: " + maSP;
	        }
	    } catch (Exception e) {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	        return "Xóa sản phẩm thất bại";
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }
	}
	
	// Viết phương thức trả về danh sách nhân viên có trong cơ sở dữ liệu
	@Override
	public List<SanPham> getDanhSachSanPham() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<SanPham> query = em.createQuery("SELECT sp FROM SanPham sp", SanPham.class);

			List<SanPham> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}
	//Viết phương thức tìm sản phẩm theo tên sản phẩm trả về danh sách sản phẩm
	@Override
	public List<SanPham> TimSanPhamTheoTen(String tenSP) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<SanPham> query = em.createQuery("SELECT sp FROM SanPham sp WHERE sp.tenSanPham LIKE :tenSP",
					SanPham.class);
			query.setParameter("tenSP", "%" + tenSP + "%");

			List<SanPham> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}
	//Viết phương thức tìm sản phẩm theo kiểu dáng trả về danh sách sản phẩm
	@Override
	public List<SanPham> TimSanPhamTheoKieuDang(String kieuDang) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<SanPham> query = em.createQuery("SELECT sp FROM SanPham sp WHERE sp.kieuDang LIKE :kieuDang",
					SanPham.class);
			query.setParameter("kieuDang", "%" + kieuDang + "%");

			List<SanPham> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}
	@Override
	public int getSoLuong(String maSanPham) {
	    int soLuong = 0;
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    try {
	        // Sử dụng JPQL để truy vấn số lượng của sản phẩm có mã là maSanPham
	        TypedQuery<Integer> query = em.createQuery("SELECT sp.soLuong FROM SanPham sp WHERE sp.maSanPham = :maSanPham", Integer.class);
	        query.setParameter("maSanPham", maSanPham);

	        Integer result = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả

	        if (result != null) {
	            soLuong = result;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }

	    return soLuong;
	}


}
