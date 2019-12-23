package chapter2.permiaaion;

/**
 * 第一版
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-19 14:24
 */
public class FunOne {
    public String judge(String roleName){
        String result = "";
        // 系统管理员拥有A权限
        if ("ROLE_ROOT_ADMIN".equals(roleName)) {
            result = "ROLE_ROOT_ADMIN has AAA permission";
        }
        // 订单管理员拥有B权限
        else if("ROLE_ORDER_ADMIN".equals(roleName)){
            result = "ROLE_ORDER_ADMIN has BBB permission";
        }
        // 普通用户拥有C权限
        else if ("ROLE_NORMAL".equals(roleName)) {
            result = "ROLE_NORMAL has CCC permission";
        }
        // 游客用户拥有D权限
        else {
            result = "EXCURSIONIST has DDD permission";
        }
        return result;
    }
}
