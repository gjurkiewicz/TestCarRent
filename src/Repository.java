import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Repository {

    private static final List<Car> carsList = new ArrayList<>();
    private static HashMap<String, byte[]> usersMap = new HashMap<>();

    public static void addCar(Car car){
        carsList.add(car);
    }
    public static void rentCar(int index){
        if(carsList.get(index).getStatus()==Status.FREE){
            carsList.get(index).setStatus(Status.RENT);
        }
    }
    public static void printData(){
        System.out.println(carsList);
    }
    public static void returnCar(int index){
        if(carsList.get(index).getStatus()==Status.RENT){
            carsList.get(index).setStatus(Status.FREE);
        }
    }
    public static void initData(){
        try {
            String pass = "password";

            byte[] bytesOfMessage = pass.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);

            usersMap.put("login",thedigest);

            String pass2 = "password2";

            byte[] bytesOfMessage2 = pass2.getBytes("UTF-8");
            MessageDigest md2 = MessageDigest.getInstance("MD5");
            byte[] thedigest2 = md2.digest(bytesOfMessage2);

            usersMap.put("login2",thedigest2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static void printUserData() {
        System.out.println(usersMap);
        System.out.println("grgrg");
    }

    public static boolean authenticateUser(String login, String pass) {
        boolean result = false;
        byte[] hashedPass = usersMap.get(login);

        try {
            byte[] bytesOfMessage = pass.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedUserPasswodr = md.digest(bytesOfMessage);
            result = Arrays.equals(hashedPass, hashedUserPasswodr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;

    }
}
