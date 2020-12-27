package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @author beastars
 */
public class _205_同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0)
            return true;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            char v = t.charAt(i);
            if (map.get(k) == null) { // 一一对应，key不存在，对应的value也一定不存在
                if (map.containsValue(v))
                    return false;
                map.put(k, v);
            } else if (v != map.get(k)) {
                return false;
            }
        }

        return true;
    }
}
