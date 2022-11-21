public class FizzBuzzString {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FizzBuzz = FIZZ+BUZZ;

    private int checkedNumber;
    public FizzBuzzString(){}
    public FizzBuzzString(int checkedNumber) {
        this.checkedNumber = checkedNumber;
    }

    public String translate() {
        if(this.getCheckedNumber()<0) return "Ngoài phạm vi kiểm tra";
        if (this.getCheckedNumber()%3==0&&this.getCheckedNumber()%5 ==0) return FizzBuzz;
        if (this.getCheckedNumber() % 3 == 0) return FIZZ;
        if (this.getCheckedNumber() % 5 == 0) return BUZZ;
        return String.valueOf(this.getCheckedNumber());
    }
    public String numberToSpeech(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num>100) return numStr;
        return new NumberToSpeech(num).toSpeech();
    };
    public int getCheckedNumber() {
        return this.checkedNumber;
    }
}