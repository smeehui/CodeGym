public class NumberToSpeech {
    private final int number;

    public NumberToSpeech(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static String toSingleNumberOnes(int ones) {
        return switch (ones) {
            case 0 -> "không";
            case 1 -> "một";
            case 2 -> "hai";
            case 3 -> "ba";
            case 4 -> "bốn";
            case 5 -> "năm";
            case 6 -> "sáu";
            case 7 -> "bảy";
            case 8 -> "tám";
            case 9 -> "chín";
            case 10 -> "mười";
            default -> "";
        };
    }

    public static String toSingleNumberTen(int tens) {
        return switch (tens) {
            case 1 -> "mốt";
            case 2 -> "hai";
            case 3 -> "ba";
            case 4 -> "bốn";
            case 5 -> "năm";
            case 6 -> "sáu";
            case 7 -> "bảy";
            case 8 -> "tám";
            case 9 -> "chín";
            default -> "mươi";
        };
    }

    public String toSpeech() {
        if (this.getNumber() < 11) return toSingleNumberOnes(this.getNumber());
        if (this.getNumber() < 20) return "mười " + toSingleNumberOnes(this.getNumber() % 10);
        else {
            int tens = this.getNumber() / 10;
            int ones = this.getNumber() % 10;
            return toSingleNumberOnes(tens) + " " + toSingleNumberTen(ones);

        }
    }
}
