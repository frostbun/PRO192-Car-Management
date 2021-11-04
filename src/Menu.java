import java.util.List;
import java.io.BufferedReader;

public class Menu {

    public static String getString(BufferedReader reader, String message) {
        return getPattern(reader, message, "^.+$");
    }

    public static String getPattern(BufferedReader reader, String message, String pattern) {
        while(true) {
            try {
                System.out.print(message);
                String ret = reader.readLine();
                if(!ret.matches(pattern) || ret.matches(",:")) {
                    throw new Exception();
                }
                return ret;
            }
            catch(Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public static double getDouble(BufferedReader reader, String message, double min, double max) {
        while(true) {
            try {
                System.out.print(message);
                double ret = Double.parseDouble(reader.readLine());
                if(ret<min || ret>max) {
                    throw new Exception();
                }
                return ret;
            }
            catch(Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public static int getInteger(BufferedReader reader, String message, int min, int max) {
        while(true) {
            try {
                System.out.print(message);
                int ret = Integer.parseInt(reader.readLine());
                if(ret<min || ret>max) {
                    throw new Exception();
                }
                return ret;
            }
            catch(Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public static int getChoice(BufferedReader reader, String title, List<String> option) {
        System.out.println(title);
        for(int i=0; i<option.size(); ++i) {
            System.out.format("%d. %s\n", i, option.get(i));
        }
        return getInteger(reader, "Your choice: ", 0, option.size());
    }
}
