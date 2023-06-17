package woowaapplication.individual.moim.utils;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import woowaapplication.individual.moim.fixture.FieldFixture;

import java.util.List;

import static woowaapplication.individual.moim.fixture.FieldFixture.데이터_생성_결과_로케이션;
import static woowaapplication.individual.moim.fixture.FieldFixture.식별자_아이디;

public class JsonPathUtil {

    public static String Location_추출(ExtractableResponse<Response> API_응답_결과) {
        return API_응답_결과.header(데이터_생성_결과_로케이션.필드명());
    }

    public static Long 식별자_ID_추출(ExtractableResponse<Response> API_응답_결과) {
        return Long값_추출(API_응답_결과, 식별자_아이디);
    }

    public static Long Long값_추출(ExtractableResponse<Response> API_응답_결과, FieldFixture 추출할_데이터_필드) {
        return API_응답_결과.jsonPath().getLong(추출할_데이터_필드.필드명());
    }

    public static Integer Integer값_추출(ExtractableResponse<Response> API_응답_결과, FieldFixture 추출할_데이터_필드) {
        return API_응답_결과.jsonPath().getInt(추출할_데이터_필드.필드명());
    }

    public static String 문자열값_추출(ExtractableResponse<Response> API_응답_결과, FieldFixture 추출할_데이터_필드) {
        return API_응답_결과.jsonPath().getString(추출할_데이터_필드.필드명());
    }

    public static List<Object> List값_추출(ExtractableResponse<Response> API_응답_결과, FieldFixture 추출할_데이터_필드) {
        return API_응답_결과.jsonPath().getList(추출할_데이터_필드.필드명());
    }
}
