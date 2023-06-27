package woowaapplication.individual.moim.participant.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Allergens {
    None("없음", 0),
    EGGS("난류", 1),
    MILK("우유", 2),
    BUCKWHEAT("메밀", 3),
    WHEAT("밀", 4),
    SOY("대두", 5),
    WALNUT("호두", 6),
    PEANUT("땅콩", 7),
    PEACH("복숭아", 8),
    TOMATO("토마토", 9),
    PORK("돼지고기", 10),
    CHICKEN("닭고기", 11),
    BEEF("쇠고기", 12),
    SHRIMP("새우", 13),
    MACKEREL("고등어", 14),
    MUSSEL("홍합", 15),
    ABALONE("전복", 16),
    OYSTER("굴", 17),
    SHELLFISH("조개류", 18),
    CRAB("게", 19),
    SQUID("오징어", 20),
    SULFITES("아황산 포함식품", 21);

    private final String name;
    private final int code;

    Allergens(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static List<Allergens> getAllergensFromCodes(String allergensCodes) {
        return Arrays.stream(allergensCodes.split(","))
                .map(Integer::parseInt)
                .map(Allergens::getAllergenByCode)
                .collect(Collectors.toList());
    }

    private static Allergens getAllergenByCode(int code) {
        return Arrays.stream(Allergens.values())
                .filter(allergen -> allergen.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Allergen code: " + code));
    }
}
