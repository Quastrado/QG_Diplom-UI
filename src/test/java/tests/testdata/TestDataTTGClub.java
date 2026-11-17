package tests.testdata;

import org.junit.jupiter.params.provider.Arguments;
import pages.TTGClubClassesPage;
import pages.TTGClubSpellsScreenPage;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestDataTTGClub {

    public String searchPageTitle = "Поиск по сайту";

    public static List<String> settingsModalHeaders(){
        return List.of("Оформление", "Разделы справочника");
    }

    public static Stream<Arguments> searchModalResultsData() {
        return Stream.of(
                Arguments.of("Мультиклассирование", "Мультиклассирование", "/screens/multiclassing"),
                Arguments.of("Multiclassing", "Мультиклассирование", "/screens/multiclassing"),
                Arguments.of("Заклинания", "Заклинания", "/screens/spells")
        );
    }

    public String invalidQuery = "Драгонфрукт";

    public static Stream<Arguments> endToEndSearchData() {
        return Stream.of(
                Arguments.of(
                        "Классы",
                        "Классы",
                        "/classes",
                        "Классы",
                        (Consumer<String>) new TTGClubClassesPage()::verifyPageOpened
                ),
                Arguments.of(
                        "Заклинания",
                        "Заклинания",
                        "/screens/spells",
                        "Заклинания",
                        (Consumer<String>) new TTGClubSpellsScreenPage()::verifyPageOpened
                )
        );
    }

    public String charismaBonus = "2";
    public String amountOfMagic = "Много";

}
