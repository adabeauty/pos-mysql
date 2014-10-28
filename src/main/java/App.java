import com.thoughtworks.mysql.Dao.ItemDao;
import com.thoughtworks.mysql.VO.Item;

public class App {

    public static void main(String[] args){
        Item item = new Item(0,"TF1003", "bb", "kg", 8.00);
        ItemDao itemDao = new ItemDao();
//        itemDao.insertItem(item);
        itemDao.deleteItem("TF1003");
    }
}
