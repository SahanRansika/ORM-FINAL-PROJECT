package healthcarecenter.dao;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(String id);
    String generateNewId();
}
