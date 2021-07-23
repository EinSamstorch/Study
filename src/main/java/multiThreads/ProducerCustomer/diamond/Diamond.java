package multiThreads.ProducerCustomer.diamond;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 10:04
 */
@Setter
@Getter
public class Diamond {
    private Integer id;
    private String manufacturer;

    public Diamond() {
    }

    public Diamond(Integer id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }


    @Override
    public String toString() {
        return "diamond{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

