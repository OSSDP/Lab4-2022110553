/**
 * @description:
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
//加一行dev分支的注释,,
public class Solution2 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26]; // 26个字母
        int[] num = new int[26]; // 记录每个字母的出现次数

        // 统计每个字母的出现次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 每遍历一个字符，将其计数减一
            num[ch - 'a']--;

            // 如果该字符已经在结果中，跳过
            if (vis[ch - 'a']) {
                continue;
            }

            // 贪心：如果当前字符比结果末尾字符字典序小，且结果末尾字符在后续还会出现
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                vis[sb.charAt(sb.length() - 1) - 'a'] = false; // 标记末尾字符为未使用
                sb.deleteCharAt(sb.length() - 1); // 删除末尾字符
            }

            // 将当前字符加入结果，并标记为已使用
            sb.append(ch);
            vis[ch - 'a'] = true;
        }
        return sb.toString();
    }
}