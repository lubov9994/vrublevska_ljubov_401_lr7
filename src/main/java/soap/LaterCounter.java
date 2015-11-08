package soap;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

@Stateless
@WebService(name = "LaterCounter", serviceName = "LaterCount")
public class LaterCounter {

    public LaterCounter() {
    }

    @WebMethod
    public String count(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < word.length();i++) {
            if (map.get(word.charAt(i)) == null) {
                map.put(word.charAt(i), 0);
            }
            map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
        }

        String result = "";
        for (Character key : map.keySet()) {
            result += key + "-" + map.get(key) + ",";
        }
        result = result.substring(0, result.length()-1);

        return result;
    }

}

