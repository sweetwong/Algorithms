package offer;

class Offer05_替换空格 {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

}
