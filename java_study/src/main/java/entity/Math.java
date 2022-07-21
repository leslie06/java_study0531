package entity;

/**
 * @Description 批量插入的math实体
 * @Author leslie
 * @Date 2022/7/14 18:56
 **/
public class Math {
    private Integer id;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Math{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }


}
