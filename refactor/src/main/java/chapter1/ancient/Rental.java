package chapter1.ancient;

/**
 * 租赁
 *  表示顾客租借了一部影片
 *
 * @author YangBo
 * @date 2019/04/29
 */
public class Rental {

    private Movie _movie;
    private int _dayRented;

    public Movie get_movie() {
        return _movie;
    }

    public void set_movie(Movie _movie) {
        this._movie = _movie;
    }

    public int get_dayRented() {
        return _dayRented;
    }

    public void set_dayRented(int _dayRented) {
        this._dayRented = _dayRented;
    }
}
