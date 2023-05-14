package duelistmod.events;

import basemod.IUIElement;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.megacrit.cardcrawl.characters.*;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.helpers.*;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.relics.*;
import duelistmod.*;
import duelistmod.abstracts.*;
import duelistmod.dto.DuelistConfigurationData;
import duelistmod.dto.EventConfigData;
import duelistmod.helpers.*;
import duelistmod.interfaces.*;
import duelistmod.ui.configMenu.DuelistLabeledToggleButton;

import java.util.*;

public class VisitFromAnubis extends DuelistEvent {


    public static final String ID = DuelistMod.makeID("VisitFromAnubis");
    public static final String IMG = DuelistMod.makeEventPath("VisitFromAnubis.png");
    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
    private static final String NAME = eventStrings.NAME;
    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
    private static final String[] OPTIONS = eventStrings.OPTIONS;
    private int screenNum = 0;
    private int scoreAmt = 0;

    public VisitFromAnubis() {
        super(ID, NAME, DESCRIPTIONS[0], IMG);
        this.noCardsInRewards = true;
        this.dungeonId = TheCity.ID;
        this.spawnCondition = () -> !this.getActiveConfig().getDisabled();
        this.bonusCondition = () -> !this.getActiveConfig().getDisabled();
        if (AbstractDungeon.player != null && AbstractDungeon.getCurrMapNode() != null && AbstractDungeon.getCurrRoom() != null) {
            AbstractPlayer p = AbstractDungeon.player;
            ArrayList<AbstractRelic> relics = p.relics;

            ArrayList<Integer> allowedToRemoveIndices = new ArrayList<>();
            for (int j = 0; j < relics.size(); j++) {
                if (!(relics.get(j) instanceof VisitFromAnubisRemovalFilter) || ((VisitFromAnubisRemovalFilter) relics.get(j)).canRemove()) {
                    allowedToRemoveIndices.add(j);
                }
            }
            if (allowedToRemoveIndices.size() > 0) {
                this.scoreAmt = AbstractDungeon.cardRandomRng.random(150, 2500);

                imageEventText.setDialogOption(OPTIONS[0] + this.scoreAmt + OPTIONS[1]);
                imageEventText.setDialogOption(OPTIONS[2]);
            } else {
                this.scoreAmt = 0;

                imageEventText.setDialogOption(OPTIONS[3], true);
                imageEventText.setDialogOption(OPTIONS[2]);
            }
        }
    }

    @Override
    protected void buttonEffect(int i) {
        AbstractPlayer p = AbstractDungeon.player;
        ArrayList<AbstractRelic> relics = p.relics;
        switch (screenNum) {
            case 0:
                switch (i) {
                    case 0:
                        Util.addDuelistScore(this.scoreAmt, true);
                        ArrayList<Integer> allowedToRemoveIndices = new ArrayList<>();
                        for (int j = 0; j < relics.size(); j++) {
                            if (!(relics.get(j) instanceof VisitFromAnubisRemovalFilter) || ((VisitFromAnubisRemovalFilter) relics.get(j)).canRemove()) {
                                 allowedToRemoveIndices.add(j);
                            }
                        }
                        if (allowedToRemoveIndices.size() > 0) {
                            int toRemoveIndex = allowedToRemoveIndices.remove(AbstractDungeon.cardRandomRng.random(allowedToRemoveIndices.size() -1 ));
                            relics.remove(toRemoveIndex);
                        }
                        logDuelistMetric(NAME, "Scored: " + this.scoreAmt);
                        this.imageEventText.updateBodyText("A deal with Anubis has been struck. Enjoy your reward, Duelist.");
                        this.imageEventText.updateDialogOption(0, OPTIONS[2]);
                        this.imageEventText.clearRemainingOptions();
                        screenNum = 1;
                        break;
                    case 1:
                        this.imageEventText.updateBodyText("Anubis laughs at your cowardice.");
                        this.imageEventText.updateDialogOption(0, OPTIONS[2]);
                        this.imageEventText.clearRemainingOptions();
                        logDuelistMetric(NAME, "Leave");
                        screenNum = 1;
                }
                break;
            case 1:
                openMap();
                break;

        }
    }

    @Override
    public DuelistConfigurationData getConfigurations() {
        RESET_Y(); LINEBREAK(); LINEBREAK(); LINEBREAK(); LINEBREAK();
        ArrayList<IUIElement> settingElements = new ArrayList<>();
        EventConfigData onLoad = this.getActiveConfig();
        String tooltip = "When enabled, allows you encounter this event during runs. Enabled by default.";
        settingElements.add(new DuelistLabeledToggleButton("Event Enabled", tooltip,DuelistMod.xLabPos, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, !onLoad.getDisabled(), DuelistMod.settingsPanel, (label) -> {}, (button) ->
        {
            EventConfigData data = this.getActiveConfig();
            data.setDisabled(!button.enabled);
            DuelistMod.eventConfigSettingsMap.put(this.duelistEventId, data);
            try
            {
                SpireConfig config = new SpireConfig("TheDuelist", "DuelistConfig",DuelistMod.duelistDefaults);
                String eventConfigMap = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(DuelistMod.eventConfigSettingsMap);
                config.setString("eventConfigSettingsMap", eventConfigMap);
                config.save();
            } catch (Exception e) { e.printStackTrace(); }
        }));
        return new DuelistConfigurationData(this.title, settingElements, this);
    }
}
