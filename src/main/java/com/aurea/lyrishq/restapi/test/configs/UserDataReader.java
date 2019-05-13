package com.aurea.lyrishq.restapi.test.configs;

import static org.apache.commons.lang.StringUtils.EMPTY;

import java.io.InputStream;
import java.util.stream.Stream;
import org.yaml.snakeyaml.Yaml;

public final class UserDataReader {

    public static final String DEFAULT = "default";
    private static final String CONFIG_YML = "config.yml";
    private static final String DASH = "-";
    private static UserDataReader instance;
    private transient ClientConfig clientConfig;
    private transient String filename;

    private UserDataReader() {
    }

    public static void init(final String environment) {
        if (instance != null && instance.fileStartsWith(environment)) {
            return;
        }
        instance = new UserDataReader();
        updateFileName(environment);

        loadFromYaml();
    }

    private static void loadFromYaml() {
        final InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(instance.filename);
        Yaml yaml = new Yaml();
        instance.clientConfig = yaml.loadAs(inputStream, ClientConfig.class);
    }

    private static void updateFileName(final String environment) {
        instance.filename = EMPTY;
        if (environment.isEmpty() || environment.equalsIgnoreCase(DEFAULT)) {
            instance.filename = CONFIG_YML;
        } else {
            instance.filename = environment + DASH + CONFIG_YML;
        }
    }

    public static UserDataReader getInstance() {
        if (null == instance) {
            init(EMPTY);
        }
        return instance;
    }

    private boolean fileStartsWith(final String env) {
        return filename.startsWith(env);
    }

    public UserInfo getRole(final Role role) {

        return Stream.of(instance.clientConfig.getUserInfo())
                .filter(item -> item.role.equals(role))
                .findFirst().get();
    }
}
