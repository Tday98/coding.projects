/**
 * Created by tristanday on 4/17/17.
 */
public class CacheRunner {
    public static void main (String[] args) {
        Cache myCache = new Cache(5);
        myCache.update("Google Chrome");
        System.out.println(myCache);
    }
}
