package concurrency;

import java.util.*;
import java.util.concurrent.*;

/**
 * 1242. Web Crawler Multithreaded
 */
public class WebCrawlerMultithreaded {

    interface HtmlParser {
        List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visitedUrls = ConcurrentHashMap.newKeySet();
        crawl(List.of(startUrl), htmlParser, visitedUrls, startUrl);
        return new ArrayList<>(visitedUrls);
    }

    private void crawl(List<String> urls, HtmlParser htmlParser, Set<String> visitedUrls, String startUrl) {
        urls
                .parallelStream()
                .filter(url -> !visitedUrls.contains(url))
                .filter(url -> isTheSameDomain(url, startUrl))
                .peek(visitedUrls::add)
                .map(htmlParser::getUrls)
                .forEach(nextUrls -> crawl(nextUrls, htmlParser, visitedUrls, startUrl));

    }

    private boolean isTheSameDomain(String url1, String url2) {
        int slashes = 0;
        for (int i = 0; i < Math.min(url1.length(), url2.length()); i++) {
            if (url1.charAt(i) != url2.charAt(i)) {
                return false;
            }
            if (url1.charAt(i) == '/') {
                slashes++;
            }
            if (slashes == 3) {
                break;
            }
        }
        return true;
    }


}
