package chapter2.permiaaion;

/**
 * 枚举方式
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-19 14:30
 */
public interface RoleOperation {
    String op();
}

enum RoleEnum implements RoleOperation {
    // 系统管理员拥有A权限
    ROLE_ROOT_ADMIN{
        @Override
        public String op() {
            return "ROLE_ROOT_ADMIN has AAA permission";
        }
    },
    // 订单管理员拥有B权限
    ROLE_ORDER_ADMIN{
        @Override
        public String op() {
            return "ROLE_ORDER_ADMIN has BBB permission";
        }
    },
    // 普通用户拥有C权限
    ROLE_NORMAL{
        @Override
        public String op() {
            return "ROLE_NORMAL has CCC permission";
        }
    },
    // 游客用户拥有D权限
    EXCURSIONIST{
        @Override
        public String op() {
            return "EXCURSIONIST has DDD permission";
        }
    }
}

class JudgeRole{
    public static void main(String[] args) {
        String a = RoleEnum.valueOf("ROLE_NORMAL").op();
        System.out.println(a);
    }
}
