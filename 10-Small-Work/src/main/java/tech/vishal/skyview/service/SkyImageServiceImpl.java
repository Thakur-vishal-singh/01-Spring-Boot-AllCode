package tech.vishal.skyview.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class SkyImageServiceImpl implements SkyImageService {

    private static final Map<String, String> LOCATION_COORDINATES = new HashMap<>();

    static {
        LOCATION_COORDINATES.put("India", "20.5937,78.9629");
        LOCATION_COORDINATES.put("US", "37.0902,-95.7129");
        LOCATION_COORDINATES.put("UK", "55.3781,-3.4360");
        LOCATION_COORDINATES.put("Australia", "-25.2744,133.7751");
        LOCATION_COORDINATES.put("Japan", "36.2048,138.2529");
        LOCATION_COORDINATES.put("Brazil", "-14.2350,-51.9253");
        LOCATION_COORDINATES.put("South Africa", "-30.5595,22.9375");
    }

    @Override
    public byte[] fetchSkyImage(String location) {
        String coordinates = LOCATION_COORDINATES.getOrDefault(location, "0,0");
        String url = String.format("https://skyview.gsfc.nasa.gov/current/cgi/runquery.pl?Position=%s&Survey=DSS&Return=JPEG", coordinates);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, byte[].class);
    }
}
