package com.troncoPruebas.classroom.Service;
import com.troncoPruebas.classroom.repositories.UsuarioRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    private SpringConfig spring;
    private CloudConfig cloud;

    // Getters and Setters
    public SpringConfig getSpring() {
        return spring;
    }

    public void setSpring(SpringConfig spring) {
        this.spring = spring;
    }

    public CloudConfig getCloud() {
        return cloud;
    }

    public void setCloud(CloudConfig cloud) {
        this.cloud = cloud;
    }


    // Nested Classes
    public static class SpringConfig {
        private ApplicationConfig application;
        private DatasourceConfig datasource;

        // Getters and Setters
        public ApplicationConfig getApplication() {
            return application;
        }

        public void setApplication(ApplicationConfig application) {
            this.application = application;
        }

        public DatasourceConfig getDatasource() {
            return datasource;
        }

        public void setDatasource(DatasourceConfig datasource) {
            this.datasource = datasource;
        }

        public static class ApplicationConfig {
            private String name;

            // Getters and Setters
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class DatasourceConfig {
            private String url;
            private String username;
            private String password;
            private String driverClassName;

            @Bean
            public DataSource dataSource() {
                return DataSourceBuilder.create()
                        .driverClassName(this.driverClassName)
                        .url(this.url)
                        .username(this.username)
                        .password(this.password)
                        .build();
            }

            public void setDriverClassName(String driverClassName) {
                this.driverClassName = driverClassName;
            }




            public String getDriverClassName() {
                return this.driverClassName;
            }


            // Getters and Setters
            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }
    }

    public static class CloudConfig {
        private AwsConfig aws;

        // Getters and Setters
        public AwsConfig getAws() {
            return aws;
        }

        public void setAws(AwsConfig aws) {
            this.aws = aws;
        }

        public static class AwsConfig {
            private CredentialsConfig credentials;
            private S3Config s3;

            // Getters and Setters
            public CredentialsConfig getCredentials() {
                return credentials;
            }

            public void setCredentials(CredentialsConfig credentials) {
                this.credentials = credentials;
            }

            public S3Config getS3() {
                return s3;
            }

            public void setS3(S3Config s3) {
                this.s3 = s3;
            }

            public static class CredentialsConfig {
                private String accessKey;
                private String secretKey;

                // Getters and Setters
                public String getAccessKey() {
                    return accessKey;
                }

                public void setAccessKey(String accessKey) {
                    this.accessKey = accessKey;
                }

                public String getSecretKey() {
                    return secretKey;
                }

                public void setSecretKey(String secretKey) {
                    this.secretKey = secretKey;
                }
            }

            public static class S3Config {
                private String region;

                // Getters and Setters
                public String getRegion() {
                    return region;
                }

                public void setRegion(String region) {
                    this.region = region;
                }
            }
        }
    }
}