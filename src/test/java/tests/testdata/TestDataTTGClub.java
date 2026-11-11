package tests.testdata;

import pages.TTGClubSpellsScreenPage;

import java.util.Map;

public class TestDataTTGClub {

    public String searchQuery = "Заклинания";
    public String searchResultLink = "/screens/spells";
    public Map<String, TTGClubSpellsScreenPage> searchResultPage = Map.ofEntries(
            Map.entry("/screens/spells", new TTGClubSpellsScreenPage())
    );
    public String formula = "d20";
    public String cssExpectedValue = "rgba(19, 26, 32, 1)";
    public String searchPageTitle = "Поиск по сайту";
}
