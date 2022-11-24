package huy.product;

public class CheckInputException {
    enum Type{
        DOUBLE("double"),
        INT("int");
        private final String s;
        Type(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }
    private Type desiredType;
    private String input;
    public CheckInputException(){}
    public CheckInputException(Type type, String input) {
        this.desiredType = type;
        this.input = input;
    }
    public boolean check() {switch (this.desiredType){
           case DOUBLE:
               try {
                   Double.parseDouble(this.input.toString());
                   return true;
               }catch (NumberFormatException e) {
                   return false;
               }
        case INT:
            try {
                Integer.parseInt(this.input.toString());
                return true;
            }catch (NumberFormatException e) {
                return false;
            }
        default: return false;
        }
    }
    public boolean check(Type type,String input){
        this.desiredType = type;
        this.input = input;
        return check();
    }
}
