package mobile.pk.com.ytsmovies.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by hello on 8/1/2015.
 */
public class TorrentUtils {

    private static final String format = "magnet:?xt=urn:btih:%s&dn=%s&%s";

    private static String trackers = "tr=udp://open.demonii.com:1337&tr=udp://tracker.istole.it:80&tr=http://tracker.yify-torrents.com/announce&tr=udp://tracker.publicbt.com:80&tr=udp://tracker.openbittorrent.com:80&tr=udp://tracker.coppersurfer.tk:6969&tr=udp://exodus.desync.com:6969&tr=http://exodus.desync.com:6969/announce";

    public static String getTorrentLink(String torrentHash, String movieName) throws UnsupportedEncodingException {
        return String.format(format, torrentHash, URLEncoder.encode(movieName,"utf-8"), trackers);
    }

    public static boolean canHandleIntent(Context context, Intent intent)
    {
        PackageManager manager = context.getPackageManager();
        List<ResolveInfo> list = manager.queryIntentActivities(intent, 0);
        return list != null && list.size() > 0;
    }

    public static void addMagnetToClipboard(Context context, String magnetLink) {
        ClipboardManager clipboard = (ClipboardManager)  context.getSystemService(context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", "Text to copy");
        clipboard.setPrimaryClip(clip);
    }
}
