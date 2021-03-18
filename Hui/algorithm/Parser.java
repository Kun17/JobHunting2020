import java.util.*;

public class Parser {
    int idx;
    String source;

    int readNum() {
        if (idx >= source.length() || !Character.isDigit(source.charAt(idx))) return -1;
        int num = 0;
        while (idx < source.length() && Character.isDigit(source.charAt(idx))) {
            num = num * 10 + source.charAt(idx) - '0';
            ++idx;
            if (num > 255) return -1;
        }
        return num;
    }

    boolean readDot() {
        if (idx >= source.length()) return false;
        return source.charAt(idx++) == '.';
    }

    Integer parseIP(String input) {
        if (input == null) return null;
        this.source = input;
        this.idx = 0;

        int ret = readNum();
        if (ret == -1) return null;
        for (int i = 0; i < 3; ++i) {
            if(!readDot()) return null;
            int tmp = readNum();
            if (tmp == -1) return null;
            ret = (ret << 8) | tmp; 
        }
        if (idx != source.length()) return null;
        return ret;
    }

    static void printIP(Integer ip) {
        if (ip == null) {
            System.out.println("null");
            return;
        }
        for (int i = 3; i >= 0; --i) {
            System.out.print(((ip >> i * 8) & 0xFF) + (i > 0 ? "." : ""));
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        Parser parser = new Parser();
        printIP(parser.parseIP("127.0.0.1"));
        printIP(parser.parseIP("001.0.0.1"));
        printIP(parser.parseIP("001.0.0."));
        printIP(parser.parseIP(".0.0.1"));
    }
}