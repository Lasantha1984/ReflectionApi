
package fieldtester;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FieldTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customer e = new Customer();
        e.setName("Lasantha");
        e.setAddress("Padukka");
        e.setAge("10");

        for (Field field : e.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(e);
                System.out.print(name + " :");
                System.out.println(value);
            } catch (IllegalArgumentException ex) {

                Logger.getLogger(FieldTester.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(FieldTester.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
