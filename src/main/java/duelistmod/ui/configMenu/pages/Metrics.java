package duelistmod.ui.configMenu.pages;

import basemod.IUIElement;
import basemod.ModLabel;
import basemod.ModLabeledButton;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import duelistmod.DuelistMod;
import duelistmod.enums.MetricsMode;
import duelistmod.enums.Mode;
import duelistmod.metrics.MetricsHelper;
import duelistmod.persistence.data.MetricsSettings;
import duelistmod.ui.configMenu.DuelistLabeledButton;
import duelistmod.ui.configMenu.DuelistLabeledToggleButton;
import duelistmod.ui.configMenu.RefreshablePage;
import duelistmod.ui.configMenu.SpecificConfigMenuPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

public class Metrics extends SpecificConfigMenuPage implements RefreshablePage {

    private boolean isRefreshing;

    public Metrics() {
        super("Metrics Settings", "Metrics");
    }

    public ArrayList<IUIElement> getElements() {
        ArrayList<IUIElement> settingElements = new ArrayList<>();

        String tooltip = "When enabled, tier scores appear under cards in card reward screens. NL NL Tier scores should be considered a guide for how well a card performs on average when picked during the current act with the current deck.";
        settingElements.add(new DuelistLabeledToggleButton("Show tier scores",tooltip, DuelistMod.xLabPos, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, settings().getTierScoresEnabled(), DuelistMod.settingsPanel,  (label) -> {}, (button) ->
        {
            settings().setTierScoresEnabled(button.enabled);
            DuelistMod.configSettingsLoader.save();
        }));

        tooltip = "When enabled, a tooltip will appear when hovering over the tier score button, which displays a summary that explains tier scores. Enabled by default.";
        settingElements.add(new DuelistLabeledToggleButton("Show tier score tooltip",tooltip, DuelistMod.xLabPos + DuelistMod.xSecondCol, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, settings().getTooltipsEnabled(), DuelistMod.settingsPanel,  (label) -> {}, (button) ->
        {
            settings().setTooltipsEnabled(button.enabled);
            DuelistMod.configSettingsLoader.save();
        }));

        LINEBREAK();

        tooltip = "When enabled, clicking on the tier score buttons will open the metrics site directly to the full list of cards (and scores) for your current deck.";
        settingElements.add(new DuelistLabeledToggleButton("Score buttons open metrics site",tooltip, DuelistMod.xLabPos, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, settings().getWebButtonsEnabled(), DuelistMod.settingsPanel, (label) -> {}, (button) ->
        {
            settings().setWebButtonsEnabled(button.enabled);
            DuelistMod.configSettingsLoader.save();
        }));

        LINEBREAK();

        tooltip = "When enabled, your run data will be submitted to the metrics server with your country and system language.";
        settingElements.add(new DuelistLabeledToggleButton("Upload country and language with metric data",tooltip, DuelistMod.xLabPos, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, settings().getAllowLocaleUpload(), DuelistMod.settingsPanel, (label) -> {}, (button) ->
        {
            settings().setAllowLocaleUpload(button.enabled);
            DuelistMod.configSettingsLoader.save();
        }));

        LINEBREAK();

        tooltip = "When enabled, Tier Scoring events that trigger on card reward screens will output logging to the BaseMod console. Enabled by default.";
        settingElements.add(new DuelistLabeledToggleButton("Log Tier Scores in console",tooltip, DuelistMod.xLabPos, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, settings().getLogMetricsScoresToDevConsole(), DuelistMod.settingsPanel, (label) -> {}, (button) ->
        {
            settings().setLogMetricsScoresToDevConsole(button.enabled);
            DuelistMod.configSettingsLoader.save();
        }));


        LINEBREAK();
        LINEBREAK();

        settingElements.add(new ModLabel("Metrics UUID: " + DuelistMod.metricsUUID, DuelistMod.xLabPos, DuelistMod.yPos,DuelistMod.settingsPanel,(me)->{}));
        ModLabeledButton copyButton = new DuelistLabeledButton("Copy", "Copy your UUID to the clipboard.", DuelistMod.xLabPos + DuelistMod.xSecondCol + DuelistMod.xThirdCol + 50, DuelistMod.yPos - 25, DuelistMod.settingsPanel, (element)->
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(DuelistMod.metricsUUID), null)
        );
        settingElements.add(copyButton);
        float copyWidth = ReflectionHacks.getPrivate(copyButton, ModLabeledButton.class, "w");

        LINEBREAK(25);

        settingElements.add(new ModLabel("UUID can be used to look up your runs on the Metrics site", (DuelistMod.xLabPos), (DuelistMod.yPos),DuelistMod.settingsPanel,(me)->{}));
        settingElements.add(new DuelistLabeledButton("View My Runs", "Directly open your browser to your list of runs on the Duelist Metrics site.", DuelistMod.xLabPos + DuelistMod.xSecondCol + DuelistMod.xThirdCol + 50 - (copyWidth / Settings.scale), DuelistMod.yPos - 25, DuelistMod.settingsPanel, (element)->{
            MetricsHelper.openPlayerRuns(true);
        }));

        this.isRefreshing = false;
        return settingElements;
    }

    private MetricsSettings settings() {
        return DuelistMod.persistentDuelistData.MetricsSettings;
    }

    @Override
    public void resetToDefault() {
        DuelistMod.persistentDuelistData.MetricsSettings = new MetricsSettings();
    }

    @Override
    public void refresh() {
        if (!this.isRefreshing && DuelistMod.paginator != null) {
            this.isRefreshing = true;
            DuelistMod.paginator.refreshPage(this);
        }
    }
}
