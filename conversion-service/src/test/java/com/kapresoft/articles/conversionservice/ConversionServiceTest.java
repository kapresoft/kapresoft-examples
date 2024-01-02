package com.kapresoft.articles.conversionservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unchecked")
@SpringBootTest
class ConversionServiceTest {

    @Autowired
    ConversionService conversionService;

    @Test
    void shouldConvert_Strings_to_Numbers() {
        List<String> stringList = List.of("1", "2", "3", "4");
        TypeDescriptor sourceType = TypeDescriptor.forObject(stringList);
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Integer.class));
        List<Integer> convertedNumbers = (List<Integer>) conversionService.convert(stringList, sourceType, targetType);

        assertThat(convertedNumbers).isNotNull()
                .containsExactly(1, 2, 3, 4);
    }

}
