package net.nemerosa.iteach.common.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.money.Money;

import java.time.LocalDateTime;
import java.time.YearMonth;

public final class ObjectMapperFactory {

    public static final Version JSON_MODULE_VERSION = new Version(1, 0, 0, null, "net.nemerosa.iteach", "iteach-common");

    public static ObjectMapper create() {
        ObjectMapper mapper = new ObjectMapper();
        // Support for annotated constructors, as generated by Lombok and @Data
        DeserializationConfig config = mapper.getDeserializationConfig();
        AnnotationIntrospector pair = AnnotationIntrospector.pair(config.getAnnotationIntrospector(), new ConstructorPropertiesAnnotationIntrospector());
        // Support for Joda Money
        jodaMoney(mapper);
        // Support for JDK 8 times
        jdkTime(mapper);
        // OK
        return mapper.setAnnotationIntrospector(pair);
    }

    private static void jdkTime(ObjectMapper mapper) {
        SimpleModule jdkTimeModule = new SimpleModule(
                "JDKTimeModule",
                JSON_MODULE_VERSION
        );
        // LocalDateTime
        jdkTimeModule.addSerializer(LocalDateTime.class, new JDKLocalDateTimeSerializer());
        jdkTimeModule.addDeserializer(LocalDateTime.class, new JDKLocalDateTimeDeserializer());
        // YearMonth
        jdkTimeModule.addSerializer(YearMonth.class, new JDKYearMonthSerializer());
        jdkTimeModule.addDeserializer(YearMonth.class, new JDKYearMonthDeserializer());
        // OK
        mapper.registerModule(jdkTimeModule);
    }

    private static void jodaMoney(ObjectMapper mapper) {
        SimpleModule jodaModule = new SimpleModule(
                "JodaMoneyModule",
                JSON_MODULE_VERSION
        );
        money(jodaModule);
        mapper.registerModule(jodaModule);
    }

    private static void money(SimpleModule module) {
        module.addSerializer(Money.class, new MoneySerializer());
        module.addDeserializer(Money.class, new MoneyDeserializer());
    }

    private ObjectMapperFactory() {
    }

}
