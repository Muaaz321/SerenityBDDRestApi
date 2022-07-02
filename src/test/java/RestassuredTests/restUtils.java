package RestassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class restUtils {

        public static String getName(){
                String generateString = RandomStringUtils.randomAlphabetic(1);
                return ("Muaaz" + generateString);
        }

        public static String getJob() {
                String generateString = RandomStringUtils.randomAlphabetic(1);
                return ("Leader" + generateString);
        }

}
