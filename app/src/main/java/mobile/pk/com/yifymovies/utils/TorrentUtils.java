package mobile.pk.com.yifymovies.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by hello on 8/1/2015.
 */
public class TorrentUtils {

    private static final String format = "magnet:?xt=urn:btih:%s&dn=%s&%s";

    private static String trackers = "tr=udp://open.demonii.com:1337&tr=udp://tracker.istole.it:80&tr=http://tracker.yify-torrents.com/announce&tr=udp://tracker.publicbt.com:80&tr=udp://tracker.openbittorrent.com:80&tr=udp://tracker.coppersurfer.tk:6969&tr=udp://exodus.desync.com:6969&tr=http://exodus.desync.com:6969/announce";

    public static String getTorrentLink(String torrentHash, String movieName) throws UnsupportedEncodingException {
        return String.format(format, torrentHash, URLEncoder.encode(movieName,"utf-8"), trackers);
    }
}
