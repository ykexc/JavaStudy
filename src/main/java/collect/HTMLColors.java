package collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HTMLColors {


    public static final Object[][] ARRAY = {
            {0xF0F8FF, "AliceBlue"},
            {0xFAEBD7, "AntiqueWhite"},
            {0x7FFFD4, "Aquamarine"}
    };
    public static final Map<Integer, String> MAP = Arrays.stream(ARRAY).collect(
            Collectors.toMap(
                    element -> (Integer) element[0],
                    element -> (String) element[1],
                    (v1, v2) -> {
                        throw new IllegalStateException();
                    },
                    LinkedHashMap::new
            )
    );

    public static final Map<Integer, String> HASH_MAP = Arrays.stream(ARRAY).collect(
            Collectors.toMap(
                    key -> (Integer) key[0],
                    key -> (String) key[1]
                    )
    );

    public static void main(String[] args) {
        System.out.println(MAP);
        System.out.println(HASH_MAP);
    }
}
