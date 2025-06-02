package algorithms.hashtable;

import java.util.*;

/**
 * 1797. Design Authentication Manager
 */
public class AuthenticationManager {

    private final LinkedHashMap<String, Integer> tokens;
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.tokens = new LinkedHashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        cleanOldTokens(currentTime);
        if (!tokens.containsKey(tokenId)) {
            tokens.put(tokenId, currentTime);
        }
    }

    public void renew(String tokenId, int currentTime) {
        cleanOldTokens(currentTime);
        if (tokens.containsKey(tokenId)) {
            tokens.remove(tokenId);
            tokens.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        cleanOldTokens(currentTime);
        return tokens.size();
    }

    private void cleanOldTokens(int currentTime) {
        Iterator<Map.Entry<String, Integer>> iterator = tokens.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() + timeToLive <= currentTime) {
                iterator.remove();
            } else {
                return;
            }
        }
    }


}
