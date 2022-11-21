import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        String expressionText = "122 - 1 * (11 + 11)";
        List<Lexeme> lexemes = lexAnalyze(expressionText);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        System.out.println(expr(lexemeBuffer));
    }

    public enum LexemeType {
        LEFT_BRACKET,
        RIGHT_BRACKET,
        OP_PLUS,
        OP_MINUS,
        OP_MUL,
        OP_DEV,
        NUMBER,
        END
    }
    public static class Lexeme {
        LexemeType type;
        String value;

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static List<Lexeme> lexAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expText.length()) {
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DEV, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, c));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Wrong symbol");
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.END, ""));
        return lexemes;
    }

    public static class LexemeBuffer {
        private int pos;
        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }

    public static int expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.END) {
            return 0;
        } else {
            lexemes.back();
            return plusMinus(lexemes);
        }
    }

    public static int plusMinus(LexemeBuffer lexemes) {
        int value = multDiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS -> value = value + multDiv(lexemes);
                case OP_MINUS -> value = value - multDiv(lexemes);
                case END, RIGHT_BRACKET -> {
                    lexemes.back();
                    return value;
                }
                default -> throw new RuntimeException("Some information");
            }
        }
    }

    public static int multDiv(LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL -> value = value * factor(lexemes);
                case OP_DEV -> value = value / factor(lexemes);
                case END, RIGHT_BRACKET, OP_PLUS, OP_MINUS -> {
                    lexemes.back();
                    return value;
                }
                default -> throw new RuntimeException("Some information");
            }
        }
    }

    private static int factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET:
                int value = expr(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Some information");
                }
                return value;
            default:
                throw new RuntimeException("Some information");
        }
    }
}
