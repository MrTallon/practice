package hutool;

import cn.hutool.script.ScriptRuntimeException;
import cn.hutool.script.ScriptUtil;

import javax.script.CompiledScript;
import javax.script.ScriptException;

/**
 * script
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-09-04 13:50
 */
public class ScriptMethod {
    public static void main(String[] args) {
        CompiledScript script = ScriptUtil.compile("print('Script test!');");
        try {
            script.eval();
        } catch (ScriptException e) {
            throw new ScriptRuntimeException(e);
        }

    }
}
