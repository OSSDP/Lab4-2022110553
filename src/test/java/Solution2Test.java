import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 测试用例设计原则：
 * 1. 等价类划分：
 *    - 输入字符串中没有重复字符。
 *    - 输入字符串中有重复字符，且去重后有序。
 *    - 输入字符串中有重复字符，且去重后无序。
 *    - 空字符串或单字符输入。
 *    - 极端情况：超大长度字符串。
 * 2. 边界值分析：
 *    - 字符串长度为 0。
 *    - 字符串长度为 1。
 *    - 字符串长度为最大值（10^4）。
 * 3. 性能测试：
 *    - 验证算法在大输入规模下的时间效率。
 */
public class Solution2Test {
    /**
     * 测试目的：验证代码能够正确处理题目中的示例用例。
     * 测试用例：
     * - 示例 1: 输入 "bcabc"，输出 "abc"。
     * - 示例 2: 输入 "cbacdcbc"，输出 "acdb"。
     */
    @Test
    public void testExampleCases() {
        Solution2 solution = new Solution2();

        // 示例 1
        assertEquals("abc", solution.removeDuplicateLetters("bcabc"));

        // 示例 2
        assertEquals("acdb", solution.removeDuplicateLetters("cbacdcbc"));
    }
    /**
     * 测试目的：验证代码在空字符串、单字符、多重复字符等边界值条件下的表现。
     * 测试用例：
     * - 输入为空字符串 ""，应返回 ""。
     * - 输入为单字符 "a"，应返回 "a"。
     * - 输入为重复字符 "aaaa"，应返回 "a"。
     * - 输入为已排序字符串 "abcdef"，应返回 "abcdef"。
     * - 输入为全相同重复字符 "aaaaaaa"，应返回 "a"。
     */
    @Test
    public void testEdgeCases() {
        Solution2 solution = new Solution2();

        // 空字符串
        assertEquals("", solution.removeDuplicateLetters(""));

        // 单字符
        assertEquals("a", solution.removeDuplicateLetters("a"));

        // 重复单字符
        assertEquals("a", solution.removeDuplicateLetters("aaaa"));

        // 按字典序排列的字符串
        assertEquals("abc", solution.removeDuplicateLetters("abcdef"));

        // 全部相同的重复字符
        assertEquals("a", solution.removeDuplicateLetters("aaaaaaa"));

        // 字母反序
        assertEquals("abcdef", solution.removeDuplicateLetters("fedcbaabcdef"));
    }
    /**
     * 测试目的：验证代码在输入包含较多字符时是否能正确处理。
     * 测试用例：
     * - 输入 "zxy" + "abcdefghijklmnopqrstuvwxyz" 重复 1000 次，结果应为 "abcdefghijklmnopqrstuvwxyz"。
     */
    @Test
    public void testLargeInput() {
        Solution2 solution = new Solution2();

        // 较大的输入
        String largeInput = "zxy" + "abcdefghijklmnopqrstuvwxyz".repeat(1000);
        String expectedOutput = "abcdefghijklmnopqrstuvwxyz";
        assertEquals(expectedOutput, solution.removeDuplicateLetters(largeInput));
    }
    /**
     * 测试目的：验证代码在极端条件下的性能表现。
     * 测试用例：
     * - 输入为重复字符 "z" 的长度为 10^4 的字符串，输出应为 "z"。
     */
    @Test
    public void testPerformance() {
        Solution2 solution = new Solution2();

        // 极限输入测试，长度为 10^4
        String extremeInput = "z".repeat(10000);
        String expectedOutput = "z";
        assertEquals(expectedOutput, solution.removeDuplicateLetters(extremeInput));
    }
}