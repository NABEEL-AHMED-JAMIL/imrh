package com.etisalat.imrh.config;

import com.etisalat.imrh.util.ExceptionUtil;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

/**
 * @author Nabeel Ahmed
 */
@Configuration
@EnableCaching
public class ImrhConfiguration {

    public Logger logger = LogManager.getLogger(ImrhConfiguration.class);

    private String BUCKET_NAME = "imrh-7db21.appspot.com";
    private final String JSON_FILE = "fcm/imrh-7db21-firebase-adminsdk-1bj2y-df92421a1b.json";

    @Bean
    public CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer() {
        return new CacheManagerCustomizer<ConcurrentMapCacheManager>() {
            @Override
            public void customize(ConcurrentMapCacheManager cacheManager) {
                cacheManager.setAllowNullValues(false);
            }
        };
    }

    @Bean
    public FirebaseApp getFirebaseApp() {
        FirebaseApp firebaseApp = null;
        try {
            FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials
                .fromStream(new ClassPathResource(JSON_FILE).getInputStream()))
                .setStorageBucket(BUCKET_NAME).build();
            if (FirebaseApp.getApps().isEmpty()) {
                firebaseApp = FirebaseApp.initializeApp(options);
            } else {
                firebaseApp = FirebaseApp.getInstance();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getFirebaseApp", ExceptionUtil.getRootCause(ex));
        }
        return firebaseApp;
    }
}
