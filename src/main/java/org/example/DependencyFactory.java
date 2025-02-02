
package org.example;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;

/**
 * The module containing all dependencies required by the {@link Handler}.
 */
public class DependencyFactory {

    private DependencyFactory() {}

    /**
     * @return an instance of S3Client
     */
    public static S3AsyncClient s3Client() {

        S3Configuration configuration = S3Configuration.builder()
                .chunkedEncodingEnabled(false)
                .build();
        return S3AsyncClient.builder()
                .endpointOverride(URI.create("http://127.0.0.1:9000"))
                .serviceConfiguration(configuration)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }
}
