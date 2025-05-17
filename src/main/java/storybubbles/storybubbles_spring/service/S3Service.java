package storybubbles.storybubbles_spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;

@Service
public class S3Service {
    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    private static final String PROFILE_PICS_PREFIX = "Profile Images/";

    public List<String> getAllProfileImageUrls() {
        ListObjectsV2Request request = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .prefix(PROFILE_PICS_PREFIX)
                .build();

        return s3Client.listObjectsV2(request).contents().stream()
                .filter(s3Object -> !s3Object.key().endsWith("/")) // Exclude folders
                .map(s3Object -> generatePublicUrl(s3Object.key()))
                .collect(Collectors.toList());
    }

    public String generatePublicUrl(String objectKey) {
        return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(objectKey)).toExternalForm();
    }

    public boolean validateImageExists(String imageKey) {
        try {
            s3Client.headObject(HeadObjectRequest.builder()
                    .bucket(bucketName)
                    .key(imageKey)
                    .build());
            return true;
        } catch (NoSuchKeyException e) {
            return false;
        }
    }
}
