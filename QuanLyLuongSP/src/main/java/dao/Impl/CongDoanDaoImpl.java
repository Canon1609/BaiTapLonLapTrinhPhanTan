package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CongDoanDao;
import entity.CongDoan;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CongDoanDaoImpl extends UnicastRemoteObject  implements CongDoanDao{

	private EntityManagerFactory emf;

	public CongDoanDaoImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		 emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	public int getMaxCongDoanNumber() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(cd.maCongDoan, 3, LENGTH(cd.maCongDoan) - 2) AS int)) FROM CongDoan cd",
					Integer.class);

			Integer maxCongDoanNumber = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả

			// Nếu không có kết quả, trả về 0
			if (maxCongDoanNumber == null) {
				return 0;
			}
			return maxCongDoanNumber;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return 0; // Trả về giá trị mặc định nếu có lỗi
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	public boolean themCongDoan(CongDoan cd) {
		// Viết phương thức thêm 1 công đoạn vào cơ sở dữ liệu trả về boolean
			EntityManager em = emf.createEntityManager(); // Mở EntityManager
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				em.persist(cd);
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
	public boolean xoaCongDoan(String maCongDoan) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
            CongDoan cd = em.find(CongDoan.class, maCongDoan);
            em.remove(cd);
            tx.commit();

            return true;
        } catch (Exception e) {
        	// Nếu có lỗi, rollback lại các thay đổi
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
	public boolean capNhatCongDoan(CongDoan cd) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(cd);
			tx.commit();
			return true;
		}catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CongDoan> getDanhSachCongDoan() {
	
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<CongDoan> query = em.createQuery("SELECT cd FROM CongDoan cd", CongDoan.class);

			List<CongDoan> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
		
	}
	@Override
	public List<SanPham> getDanhSachSanPham() throws RemoteException {
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
	@Override
	public List<String> getCongDoanYeuCau() throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<String> query = em.createQuery("SELECT cd.congDoanYeuCau FROM CongDoan cd", String.class);

			List<String> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}

	public double getGiaCongDoanByMaCongDoan(String maCongDoan) {
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    double giaCongDoan = 0;

	    try {
	        // Sử dụng JPQL để truy vấn giá công đoạn dựa trên mã công đoàn
	        TypedQuery<Double> query = em.createQuery("SELECT cd.giaCongDoan FROM CongDoan cd WHERE cd.maCongDoan = :maCongDoan", Double.class);
	        query.setParameter("maCongDoan", maCongDoan);

	        Double result = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả

	        if (result != null) {
	            giaCongDoan = result;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }

	    return giaCongDoan;
	}

	

}
