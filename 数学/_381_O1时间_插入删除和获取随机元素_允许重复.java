package 数学;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 *
 * @author beastars
 */
public class _381_O1时间_插入删除和获取随机元素_允许重复 {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public _381_O1时间_插入删除和获取随机元素_允许重复() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
