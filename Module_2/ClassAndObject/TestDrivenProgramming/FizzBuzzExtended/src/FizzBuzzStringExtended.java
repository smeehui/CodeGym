public class FizzBuzzStringExtended extends FizzBuzzString{
    public FizzBuzzStringExtended(){
        super();
    }

    public FizzBuzzStringExtended(int checkedNumber) {
        super(checkedNumber);
    }

    @Override
    public String translate() {
        if (this.getCheckedNumber()>100||this.getCheckedNumber()<0) return "Ngoài phạm vi kiểm tra";
        String numberStr =  String.valueOf(this.getCheckedNumber());
        if (numberStr.contains("3")&&numberStr.contains("5")) return FizzBuzz;
        if (numberStr.contains("3")) return FIZZ;
        if (numberStr.contains("5")) return BUZZ;
        return numberToSpeech(numberStr);
    }

    public static void main(String[] args) {
        FizzBuzzStringExtended[] test = new FizzBuzzStringExtended[100];
        for(int i=0;i<test.length;i++) {
            test[i]= new FizzBuzzStringExtended(i);
            System.out.println(test[i].translate());
        }
    }

}
