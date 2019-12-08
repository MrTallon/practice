package stream;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/03/07
 */
@Data
@AllArgsConstructor
public class People {

    private Integer id;
    private String name;
    private Integer age;
    private String place;
    private String direction;


}
