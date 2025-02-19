package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.PhanCongDao;
import entity.CongDoan;
import entity.CongNhan;
import entity.PhanCong;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PhanCongDaoImpl extends UnicastRemoteObject  implements PhanCongDao {

	private EntityManagerFactory emf;

	public PhanCongDaoImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		 emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	
	public int getMaxPhanCongNumber() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(pc.maPhanCong, 3, LENGTH(pc.maPhanCong) - 2) AS int)) FROM PhanCong pc",
					Integer.class);

			Integer maxPhanCongNumber = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả

			// Nếu không có kết quả, trả về 0
			if (maxPhanCongNumber == null) {
				return 0;
			}
			return maxPhanCongNumber;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return 0; // Trả về giá trị mặc định nếu có lỗi
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean themPhanCong(PhanCong pc) throws RemoteException {
		// Viết phương thức thêm 1 công đoạn vào cơ sở dữ liệu trả về boolean
					EntityManager em = emf.createEntityManager(); // Mở EntityManager
					EntityTransaction tx = em.getTransaction();
					try {
						tx.begin();
						em.persist(pc);
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
	public boolean xoaPhanCong(String maPhanCong) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
            PhanCong pc = em.find(PhanCong.class, maPhanCong);
            em.remove(pc);
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
	public boolean suaPhanCong(PhanCong pc) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(pc);
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
	public List<PhanCong> getDSPhanCong() throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<PhanCong> query = em.createQuery("SELECT pc FROM PhanCong pc", PhanCong.class);

			List<PhanCong> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null;
	}

	@Override
	public List<SanPham> getDSSanPham() throws RemoteException {
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
	public List<String> getDSMaCongNhan() throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<String> query = em.createQuery("SELECT nv.maCongNhan FROM CongNhan nv", String.class);

			List<String> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
		
	}

	@Override
	public List<CongDoan> getDSCongDoan() throws RemoteException {
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
	public String GetTenCongDoanTheoMa(String maCongDoan) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		CongDoan cd = null;
		try {
			tx.begin();
             cd = em.find(CongDoan.class, maCongDoan);
            tx.commit();
 
     
        } catch (Exception e) {
        	// Nếu có lỗi, rollback lại các thay đổi
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close(); // Đóng EntityManager sau khi sử dụng
        }
		
		return cd.getTenCongDoan();
		
	}

	@Override
	public String GetTenCongNhanTheoMa(String maCongNhan) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		CongNhan cn = null;
		try {
			tx.begin();
             cn = em.find(CongNhan.class, maCongNhan);
            tx.commit();
 
     
        } catch (Exception e) {
        	// Nếu có lỗi, rollback lại các thay đổi
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close(); // Đóng EntityManager sau khi sử dụng
        }
		
		return cn.getHoTen();
	}
	@Override
	public int getSoLuongDaPhanCong(String maCongDoan) {
	    long soLuongDaPhanCong = 0;
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    try {
	        // Sử dụng JPQL để truy vấn tổng số lượng đã phân công cho công đoàn có mã là maCongDoan
	        TypedQuery<Long> query = em.createQuery("SELECT SUM(pc.soLuongSanPhamCanLam) FROM PhanCong pc WHERE pc.CongDoan.maCongDoan = :maCongDoan", Long.class);
	        query.setParameter("maCongDoan", maCongDoan);

	        Long result = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả

	        if (result != null) {
	            soLuongDaPhanCong = result;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }

	    return (int) soLuongDaPhanCong; // Chuyển đổi từ Long sang int
	}
	@Override
	public List<PhanCong> getAlltbPhanCong() {
		EntityManager em = emf.createEntityManager(); 
		
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<PhanCong> query = em.createQuery("SELECT pc FROM PhanCong pc", PhanCong.class);

			List<PhanCong> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}
	
	public int getTongSoLuongSanPhamDaPhanCong(String maCongNhan, String maCongDoan) {
	    EntityManager em = emf.createEntityManager(); 
	    int tongSoLuong = 0;

	    try {
	        // Sử dụng JPQL để tính tổng số lượng sản phẩm đã phân công cho cặp mã công nhân và mã công đoạn
	        TypedQuery<Long> query = em.createQuery("SELECT SUM(pc.soLuongSanPhamCanLam) FROM PhanCong pc WHERE pc.maCongNhan.maCongNhan = :maCongNhan AND pc.CongDoan.maCongDoan = :maCongDoan", Long.class);
	        query.setParameter("maCongNhan", maCongNhan);
	        query.setParameter("maCongDoan", maCongDoan);

	        Long result = query.getSingleResult(); // Lấy kết quả tổng số lượng

	        if (result != null) {
	            tongSoLuong = result.intValue(); // Chuyển đổi Long thành int
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }

	    return tongSoLuong;
	}


	public  String getMaCongDoanDaLamTheoMaCongNhan(String maCongNhan) {
	    EntityManager em = emf.createEntityManager(); 
	    String maCongDoan = null;

	    try {
	        // Sử dụng JPQL để truy vấn mã công đoàn đã làm dựa trên mã công nhân
	        TypedQuery<String> query = em.createQuery("SELECT DISTINCT pc.CongDoan.maCongDoan FROM PhanCong pc WHERE pc.maCongNhan.maCongNhan = :maCongNhan", String.class);
	        query.setParameter("maCongNhan", maCongNhan);

	        List<String> results = query.getResultList(); // Lấy danh sách mã công đoàn đã làm

	        if (!results.isEmpty()) {
	            maCongDoan = results.get(0); // Lấy mã công đoàn đầu tiên trong danh sách kết quả
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }

	    return maCongDoan;
	}

	



	
}
