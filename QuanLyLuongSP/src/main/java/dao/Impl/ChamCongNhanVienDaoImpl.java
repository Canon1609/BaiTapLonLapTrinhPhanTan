package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChamCongNhanVienDao;
import entity.CongCuaNhanVien;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ChamCongNhanVienDaoImpl extends UnicastRemoteObject implements ChamCongNhanVienDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7032159903569655403L;
	private EntityManagerFactory emf;

	public ChamCongNhanVienDaoImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	//getMaxMaCongNV
	public int getMaxMaCongNV() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất, mã công nhân viên ví dụ: C01, C02, C03,...
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(ccnv.maCongCuaNhanVien, 2, LENGTH(ccnv.maCongCuaNhanVien) - 1) AS int)) FROM CongCuaNhanVien ccnv",
					Integer.class);
			Integer maxMaCongNV = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
			
			// Nếu không có kết quả, trả về 0
			if (maxMaCongNV == null) {
				return 0;
			}
			return maxMaCongNV;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return 0;
	}
	
	//Viết phương thức chấm công nhân viên vào cơ sở dữ liệu trả về boolean
	@Override
	public boolean ChamCongNhanVien(CongCuaNhanVien congNV)  {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(congNV);

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
	public boolean ChamCongChoTatCaNhanVien(CongCuaNhanVien congNV) {
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();

	        // Lấy danh sách tất cả nhân viên
	        List<NhanVien> danhSachNhanVien = em.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class).getResultList();

	        // Duyệt qua danh sách nhân viên và chấm công cho mỗi nhân viên
	        for (NhanVien nv : danhSachNhanVien) {
	            // Kiểm tra xem công của nhân viên đã tồn tại chưa
	            CongCuaNhanVien existingCong = em.find(CongCuaNhanVien.class, congNV.getMaCongCuaNhanVien());
	            if (existingCong == null) {
	                // Tạo một bản sao của đối tượng công cho mỗi nhân viên
	                CongCuaNhanVien congNhanVien = new CongCuaNhanVien();
	                congNhanVien.setMaCongCuaNhanVien(congNV.getMaCongCuaNhanVien());
	                congNhanVien.setMaNhanVien(nv);
	                congNhanVien.setNgayChamCong(congNV.getNgayChamCong());
	                congNhanVien.setCaLam(congNV.getCaLam());
	                congNhanVien.setGioLam(congNV.getGioLam());
	                congNhanVien.setLuongCaLam(congNV.getLuongCaLam());
	                congNhanVien.setTrangThai(congNV.getTrangThai());
	                congNhanVien.setNghiPhep(congNV.getNghiPhep());

	                // Persist công của nhân viên vào cơ sở dữ liệu
	                em.persist(congNhanVien);
	            }
	        }

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



	
	//Viết phương thức xóa 1 công nhân viên khỏi cơ sở dữ liệu trả về boolean
	@Override
	public boolean deleteCongNV(String maCongNV) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			CongCuaNhanVien congNV = em.find(CongCuaNhanVien.class, maCongNV);
			em.remove(congNV);

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
	
	//Viết phương thức trả về danh sách công nhân viên trả về List<CongCuaNhanVien>
	@Override
	public List<CongCuaNhanVien> getAllCongNV()  {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách công nhân viên
			TypedQuery<CongCuaNhanVien> query = em.createQuery("SELECT ccnv FROM CongCuaNhanVien ccnv",
					CongCuaNhanVien.class);
			List<CongCuaNhanVien> listCongNV = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return listCongNV;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}
		
	

}
