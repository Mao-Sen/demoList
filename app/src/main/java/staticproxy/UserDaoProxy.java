package staticproxy;

public class UserDaoProxy implements DAOInterface {
    UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        userDao.add();
    }

    @Override
    public void update() {
        userDao.update();
    }

    @Override
    public void delete() {
        userDao.delete();
    }

    @Override
    public void query() {
        userDao.query();
    }
}
