package SystemsController;

import Observer.NoticeObservable;
import dao.NoticeObservableDAO;
import java.util.List;

public class NoticeObservableSystem {

    private NoticeObservableDAO noticeObservableDAO;
    private NoticeObservable noticeObservable;

    private List<NoticeObservable> noticeList;

    public void create() {
        this.getNoticeObservableDAO().insert(this.noticeObservable);
    }

    public void update() {
        this.getNoticeObservableDAO().update(this.noticeObservable);
    }

    public void delete() {
        this.getNoticeObservableDAO().delete(this.noticeObservable);
    }

    public NoticeObservableDAO getNoticeObservableDAO() {
        if (this.noticeObservableDAO == null) {
            this.noticeObservableDAO = new NoticeObservableDAO();
        }
        return noticeObservableDAO;
    }

    public void setNoticeObservableDAO(NoticeObservableDAO noticeObservableDAO) {
        this.noticeObservableDAO = noticeObservableDAO;
    }

    public NoticeObservable getNoticeObservable() {
        if (this.noticeObservable == null) {
            this.noticeObservable = new NoticeObservable();
        }
        return noticeObservable;
    }

    public void setNoticeObservable(NoticeObservable noticeObservable) {
        this.noticeObservable = noticeObservable;
    }

    public List<NoticeObservable> getNoticeList() {
        this.noticeList = this.getNoticeObservableDAO().read();
        return noticeList;
    }

    public void setNoticeList(List<NoticeObservable> noticeList) {
        this.noticeList = noticeList;
    }

}
