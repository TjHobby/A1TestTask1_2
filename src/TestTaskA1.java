import java.math.BigInteger;
import java.util.regex.Pattern;

public class TestTaskA1 {

    private static String IPV4_PATTERN = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static Pattern pattern = Pattern.compile(IPV4_PATTERN);

    public static BigInteger ipv4ToInt32(String ipv4) throws Exception {
        if(!pattern.matcher(ipv4).matches())
            throw new Exception("Illegal IP Address");
        String[] ipSegment = ipv4.split("\\.");
        long longIpv4 = 0;
        for(int i = 0; i<ipSegment.length;i++){
            longIpv4+=Long.parseLong(ipSegment[i])%256*Math.pow(256,3-i);
        }
        return BigInteger.valueOf(longIpv4);
    }

    public static String int32ToIpv4(BigInteger ipInt32){
        long longIpv4 = ipInt32.longValue();
        return String.format("%d.%d.%d.%d",
                (longIpv4 >> 24 & 0xff),
                (longIpv4 >> 16 & 0xff),
                (longIpv4 >> 8 & 0xff),
                (longIpv4 & 0xff));
    }

    private static long fact(int n){
        if(n<0 || n ==0)
            return 1;
        return n*(fact(n-1));
    }

    public static double task2(int n){
        if(n<1)
            return 1;
        long unPart = 0;
        for(int i = 1; i<=n;i++)
            unPart+=fact(i);
        return (1/(double)fact(n))*unPart;
    }
}
