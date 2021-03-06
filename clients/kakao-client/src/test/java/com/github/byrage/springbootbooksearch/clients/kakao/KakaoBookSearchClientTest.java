package com.github.byrage.springbootbooksearch.clients.kakao;

import com.github.byrage.springbootbooksearch.clients.kakao.dto.KakaoBookSearchResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("integration-test")
@SpringBootTest
@ActiveProfiles("test")
class KakaoBookSearchClientTest {

    @Autowired
    private KakaoBookSearchClient kakaoBookSearchClient;

    @Test
    void inquireKakaoBookSearch() {
        KakaoBookSearchResponse response = kakaoBookSearchClient.inquireKakaoBookSearch("카카오", 1, 50);

        assertThat(response).isNotNull()
                .extracting(KakaoBookSearchResponse::getDocuments).asList().hasSizeGreaterThan(0);

    }
}