import java.util.HashSet;
import java.util.Set;
  
public class BloomFilter {
    public static void main(String[] args)
    {
        Set<String> blackListedIPs
            = new HashSet<>();
        blackListedIPs.add("192.170.0.1");
        blackListedIPs.add("75.245.10.1");
        blackListedIPs.add("10.125.22.20");
  
        // true
        System.out.println(
            blackListedIPs
                .contains(
                    "75.245.10.1"));
  
        // false
        System.out.println(
            blackListedIPs
                .contains(
                    "101.125.20.22"));
    }
}
