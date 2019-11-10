public class UserDefinedException extends Exception{
    UserDefinedException(){
    }

    UserDefinedException(String msg){
        super(msg);
    }

    public static void main(String args[]){
        try{
            throw new UserDefinedException("Failed in Main");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
