/*package fr.v0.minorease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ImageUpdater {

    private static final String UNSPLASH_API_URL = "https://api.unsplash.com/photos/random?query=hotel%20room&client_id=";
    private static final String UNSPLASH_ACCESS_KEY = "H5_-q1MgtkdZpY8bze8VcJwKNh7a09dr1kTupkh1cDI"; // Remplacez par votre clé d'accès Unsplash

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ImageUpdater.class, args);
    }

    @PostConstruct
    public void updateImages() {
        for (int roomId = 50; roomId <= 100; roomId++) {
            String imageUrl = getRandomImageUrl();
            updateRoomImage(roomId, imageUrl);
        }
    }

    private String getRandomImageUrl() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s%s", UNSPLASH_API_URL, UNSPLASH_ACCESS_KEY);
        UnsplashImageResponse response = restTemplate.getForObject(url, UnsplashImageResponse.class);
        if (response != null && response.getUrls() != null) {
            return response.getUrls().getRegular();
        }
        return null;
    }

    private void updateRoomImage(int roomId, String imageUrl) {
        if (imageUrl != null) {
            jdbcTemplate.update("UPDATE rooms SET image = ? WHERE id = ?", imageUrl, roomId);
        }
    }

    private static class UnsplashImageResponse {
        private UnsplashImageUrls urls;

        public UnsplashImageUrls getUrls() {
            return urls;
        }

        public void setUrls(UnsplashImageUrls urls) {
            this.urls = urls;
        }
    }

    private static class UnsplashImageUrls {
        private String regular;

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }
    }
}
*/