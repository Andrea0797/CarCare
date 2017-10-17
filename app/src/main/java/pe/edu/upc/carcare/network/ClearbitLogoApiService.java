package pe.edu.upc.carcare.network;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Usuario on 2/10/2017.
 */

public class ClearbitLogoApiService {

    public static String LOGO_BASE_URL="https://logo.clearbit.com/";

    public static String getUrlToLogo(String url)
    {
        try {
            return LOGO_BASE_URL + new URL(url).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return LOGO_BASE_URL + url;
        }
    }
}
